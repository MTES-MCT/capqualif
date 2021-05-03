package fr.gouv.mte.capqualif.capAdmin.domain.temp;

import fr.gouv.mte.capqualif.capAdmin.domain.Data;

import java.util.List;

public class Marin {
    private final List<Data> data;

    public Marin(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }
}