package fr.gouv.mte.capqualif;

import fr.gouv.mte.capqualif.instruction.adapters.in.web.CompareMarinDataToConditionsTitreController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CapqualifApplicationTests {

	@Autowired
	private CompareMarinDataToConditionsTitreController compareMarinDataToConditionsTitreController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(compareMarinDataToConditionsTitreController).isNotNull();
	}

}
