package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;

import java.util.Date;

public class DateValue extends Value {

    private Date dateToCompareTo;

    public DateValue(String valueExpressedInLegalTerms, ComparisonRule howToCompareValue, Date dateToCompareTo) {
        super(valueExpressedInLegalTerms, howToCompareValue);
        this.dateToCompareTo = dateToCompareTo;
    }

    public Date getDateToCompareTo() {
        return dateToCompareTo;
    }
}
