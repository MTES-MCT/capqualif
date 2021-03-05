package fr.gouv.mte.capqualif.instruction.application.services;

import org.springframework.stereotype.Component;

@Component
public class DataChecker {

//    @Autowired
//    TimeConverter timeConverter;
//
//    public ComparisonResult compareDataToCondition(List<Entry> entryList, ConditionTitre condition) {
//
//        boolean result = false;
//
//        for (Entry entry : entryList) {
//            System.out.println("!!!!!!!!!!!!!!!!");
//            System.out.println(entry);
//            if (condition.getValue().getType() == DataType.DATE) {
//                result = isDateBeforeLimitDate(entry.getValue().getContent(), condition.getValue().getContent());
//            }
//        }
//
//        ComparisonResult ComparaisonResult = new ComparisonResult("age minimum", result);
//        return ComparaisonResult;
//
//        List<Boolean> results = new ArrayList<>();
//
//        for (Map data : dataList) {
//            boolean singleCompareResult = false;
//
//            switch (condition.getHowToCompareValue()) {
//                case BIGGER_THAN:
//                    Integer age = calculateYearsBetweenDateAndToday(data.get("simpleField").toString());
//                    if (age > Integer.parseInt(condition.getValue().getContent())) singleCompareResult = true;
//                case STRICT_EQUALITY:
//                    if(data.containsKey("simpleField")) {
//                        if(data.get("simpleField").equals(condition.getValue().getContent()) && !isDataExpired(data.get("expirationField").toString())) singleCompareResult = true;
//                    }
//                    if(data.containsKey("nestedField")) {
//                        if(data.get("nestedField").equals(condition.getValue().getContent()) && !isDataExpired(data.get("expirationField").toString())) singleCompareResult = true;
//                    }
//            }
//            results.add(singleCompareResult);
//        }
//        if (results.contains(Boolean.TRUE)) return true;
//        return false;
//    }
//
//    private boolean isDateBeforeLimitDate(String evaluatedDateString, String limitDateString) {
//        TimeConverter timeConverter = new TimeConverter();
//        LocalDate evaluatedDate = timeConverter.convertStringDateToLocalDate(evaluatedDateString);
//        LocalDate limitDate = timeConverter.convertStringDateToLocalDate(limitDateString);
//        return evaluatedDate.isBefore(limitDate);
//    }
//
//    private boolean isDataExpired(String expirationDate) {
//        boolean isDataExpired = false;
//        LocalDate localExpirationDate = timeConverter.convertToLocalDate(expirationDate);
//        int result = localExpirationDate.compareTo(LocalDate.now());
//        if (result <= 0) isDataExpired = true;
//        return isDataExpired;
//    }
//
//    private Integer calculateYearsBetweenDateAndToday(String dateFromMarinData) {
//        LocalDate date = timeConverter.convertToLocalDate(dateFromMarinData);
//        LocalDate today = LocalDate.now();
//        if ((date != null)) {
//            return Period.between(date, today).getYears();
//        }
//        return null;
//    }
}
