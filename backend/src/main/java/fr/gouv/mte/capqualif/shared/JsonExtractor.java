package fr.gouv.mte.capqualif.shared;

import com.jayway.jsonpath.JsonPath;
import fr.gouv.mte.capqualif.capQualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.CorrespondingDataInExistingDataSource;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.ParentKey;
import fr.gouv.mte.capqualif.capAdmin.titre.domain.enums.DataType;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Component
public class JsonExtractor {

    public List<ExtractionResult> getAllWantedData(String json,
                                                   CorrespondingDataInExistingDataSource dataToExtract) {

        List<ExtractionResult> results = new ArrayList<ExtractionResult>();

        String mainWantedDataFromJson = extractWantedDataFromJson(
                json,
                dataToExtract.getMainWantedData(),
                dataToExtract.getMainWantedData().getKeyInExistingDataSource()
        );
        results.add(
                createResult(
                        dataToExtract.getMainWantedData().getKeyInExistingDataSource().getJuridicalName(),
                        mainWantedDataFromJson,
                        dataToExtract.getMainWantedData().getDataType())
        );

        if (dataToExtract.getKeysOfAdditionalWantedData() != null)
            for (KeyInExistingDataSource key : dataToExtract.getKeysOfAdditionalWantedData()) {
                String additionalWantedDataFromJson = extractWantedDataFromJson(
                        json,
                        dataToExtract.getMainWantedData(),
                        key
                );
                results.add(
                        createResult(key.getJuridicalName(), additionalWantedDataFromJson, key.getDataType())
                );
            }
        return results;
    }

    private String extractWantedDataFromJson(String json, EntryInExistingDataSource wantedData,
                                             KeyInExistingDataSource key) {
        String query = buildQuery(wantedData, key);
        String wantedDataValue = findInJson(query, json);
        System.out.println("For the query ------ " + query + " ------ wanted data is " + wantedDataValue);
        return wantedDataValue;
    }

    /**
     * Builds the query used to fetch the data we want from a JSON document.
     *
     * @param dataUsedAsFilter filter to select the json object that contains the wanted data
     * @param keyOfWantedData
     * @return query as a string
     */
    private String buildQuery(EntryInExistingDataSource dataUsedAsFilter, KeyInExistingDataSource keyOfWantedData) {
        // query examples:
        // $..[?(@.codeBrevetMarin.libelle == "Certificat de formation de base à la sécurité (STCW10)")].dateEffet
        // $..[?(@.codeBrevetMarin.libelle == "Certificat de formation de base à la sécurité (STCW10)")]
        // .codeBrevetMarin.libelle

        String keyOfFilterData;
        if (dataUsedAsFilter.getKeyInExistingDataSource().isNested()) {
            keyOfFilterData =
                    buildPath(dataUsedAsFilter.getKeyInExistingDataSource().getParentKeys()) + dataUsedAsFilter.getKeyInExistingDataSource().getRealNameInExistingDataSource();
        } else {
            keyOfFilterData = dataUsedAsFilter.getKeyInExistingDataSource().getRealNameInExistingDataSource();
        }

        String key;                       // Will be the key in the Json we want to read value of.
        if (keyOfWantedData.getParentKeys() != null) {
            key = buildPath(keyOfWantedData.getParentKeys()) + keyOfWantedData.getRealNameInExistingDataSource();
        } else {
            key = keyOfWantedData.getRealNameInExistingDataSource();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$");      // The root element to query. This starts all path expressions.
        stringBuilder.append("..");     // Deep scan. Available anywhere a name is required.
        stringBuilder.append("[?(@.");   // [? : Filter expression. Expression must evaluate to a boolean value.
        // @ : The current node being processed by a filter predicate.
        // .<name> : Dot-notated child (here, name is the variable in the next line)
        stringBuilder.append(keyOfFilterData);     // The path is composed of the key we are looking for and its
        // possible parents.
        // If this key is nested (has parents), it will be something like : parent1.parent2.key
        if (dataUsedAsFilter.getValueInExistingDataSource() != null) {
            stringBuilder.append("=='");    // Comparison to a value ((here, value is the variable in the next line))
            stringBuilder.append(dataUsedAsFilter.getValueInExistingDataSource().getContent());
            stringBuilder.append("'");
        }
        stringBuilder.append(")].");
        stringBuilder.append(key);          // The key in the Json we want to read value of.
        System.out.println("data query is : " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * Builds a path to access the wanted key using key's parents.
     *
     * @param parentKeys Can be null
     * @return path as a string
     */
    private String buildPath(List<ParentKey> parentKeys) {
        StringJoiner stringJoiner = new StringJoiner(".");
        List<ParentKey> sortedParentKeys = parentKeys.stream()
                .sorted(Comparator.comparing(ParentKey::getPosition))
                .collect(Collectors.toList());
        for (ParentKey key : sortedParentKeys) {
            stringJoiner.add(key.getKeyName());
        }
        return stringJoiner.toString() + ".";
    }

    private String findInJson(String query, String json) {
        JSONArray wantedValueAsJSONArray = JsonPath.parse(json).read(query);
        return wantedValueAsJSONArray.get(0).toString();
    }

    private ExtractionResult createResult(String key, String value, DataType dataType) {
        ExtractionResult result = new ExtractionResult(key, value, dataType);
        return result;
    }
}
