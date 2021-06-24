package fr.gouv.mte.capqualif.capqualif.request.domain.marin.request;

public class Request {
    public Requestor requestor;
    public RequestDetails details;

    public Requestor getRequestor() {
        return requestor;
    }

    public RequestDetails getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestor=" + requestor +
                ", requestDetails=" + details +
                '}';
    }
}
