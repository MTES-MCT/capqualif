package fr.gouv.mte.capqualif.capqualif.request.domain.request;

public class RequestDetails {
    private String requestedTitreId;
    private String startDate;
    private String requestStatus;
    private Document document;
    private boolean canBeSent;

    public String getRequestedTitreId() {
        return requestedTitreId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public Document getDocuments() {
        return document;
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
                ", documents=" + document +
                ", canBeSent=" + canBeSent +
                '}';
    }
}
