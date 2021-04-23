package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConditionMapperTest {

    ConditionMapper conditionMapper;

    @Test
    void shouldMapToJPAEntity() throws IOException {

        // Given
        Condition condition = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivFormationModulaire.json").getConditions().get(0);

        // When
        ConditionJpaEntity actual = conditionMapper.mapToJpaEntity(condition);

        // Then
//        ConditionJpaEntity expected = new ConditionJpaEntity()

    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(location), Titre.class);
    }

}