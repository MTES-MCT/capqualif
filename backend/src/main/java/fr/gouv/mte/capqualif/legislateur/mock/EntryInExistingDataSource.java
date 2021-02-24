package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.List;

public class EntryInExistingDataSource {
    private KeyInExistingDataSource key;
    private Value value;

    public EntryInExistingDataSource(KeyInExistingDataSource key, Value value) {
        this.key = key;
        this.value = value;
    }

    public KeyInExistingDataSource getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}
