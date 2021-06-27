package fr.gouv.mte.capqualif.capqualif.instruction.domain;

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