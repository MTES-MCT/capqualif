package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class ConditionTitreToRealDataInExistingDataSourcesMapper {

    private DataInExistingDataSourceMock dataInExistingDataSourceMock;

    public ConditionTitreToRealDataInExistingDataSourcesMapper(DataInExistingDataSourceMock dataInExistingDataSourceMock) {
        this.dataInExistingDataSourceMock = dataInExistingDataSourceMock;
    }

    public DataToExtractFromExistingDataSource getInfosForSearchInExistingSource(ConditionTitre conditionTitre) {
        DataToExtractFromExistingDataSource dataToExtractFromExistingDataSource = dataInExistingDataSourceMock.findByConditionValue(conditionTitre.getValueExpressedInLegalTerms());
        return dataToExtractFromExistingDataSource;
    }
}