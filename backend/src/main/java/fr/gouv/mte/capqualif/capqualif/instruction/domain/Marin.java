package fr.gouv.mte.capqualif.capqualif.instruction.domain;

import java.util.List;

public class Marin {

    private List<Data> data;

    public Marin() {}

    public Marin(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Marin{" +
                "data=" + data +
                '}';
    }
}