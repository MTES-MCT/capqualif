package fr.gouv.mte.capqualif.capqualif.request.domain.request;

public class RequestTitre {
    private String name;
    private String slug;
    private String capacite;
    private Integer validityDurationInYears;

    public RequestTitre(String name, String slug, String capacite, Integer validityDurationInYears) {
        this.name = name;
        this.slug = slug;
        this.capacite = capacite;
        this.validityDurationInYears = validityDurationInYears;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCapacite() {
        return capacite;
    }

    public Integer getValidityDurationInYears() {
        return validityDurationInYears;
    }
}
