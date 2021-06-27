package fr.gouv.mte.capqualif.capqualif.instruction.domain;

import java.util.List;

public class DataSources {

    private List<DataSource> dataSources;

    public DataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public List<DataSource> getDataSources() {
        return dataSources;
    }
}
