package fr.gouv.mte.capqualif.capqualif.request.domain.marin.request;

import java.util.List;

public class RequestDetails {
    public String requestedTitreId;
    public String startDate;
    public String requestStatus;
    public List<Object> documents;
    public boolean canBeSent;

    public String getRequestedTitreId() {
        return requestedTitreId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public List<Object> getDocuments() {
        return documents;
    }

    public boolean isCanBeSent() {
        return canBeSent;
    }

    @Override
    public String toString() {
        return "RequestDetails{" +
                "requestedTitreId='" + requestedTitreId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", requestStatus='" + requestStatus + '\'' +
                ", documents=" + documents +
                ", canBeSent=" + canBeSent +
                '}';
    }
}
