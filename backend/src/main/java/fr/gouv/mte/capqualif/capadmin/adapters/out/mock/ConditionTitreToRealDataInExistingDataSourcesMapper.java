//package fr.gouv.mte.capqualif.capadmin.adapters.out.mock;
//
//import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.ConditionTitre;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class ConditionTitreToRealDataInExistingDataSourcesMapper {
//
//    private ExistingDataSource existingDataSource;
//
//    public ConditionTitreToRealDataInExistingDataSourcesMapper(ExistingDataSource existingDataSource) {
//        this.existingDataSource = existingDataSource;
//    }
//
//    public CorrespondingDataInExistingDataSource getInfosForSearchInExistingSource(ConditionTitre conditionTitre) {
//        return existingDataSource.findByConditionValue(conditionTitre);
//    }
//}