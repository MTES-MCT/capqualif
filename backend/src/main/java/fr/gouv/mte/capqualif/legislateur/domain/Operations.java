package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

public class Operations {
    private String titre;
    private List<Operation> operations;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "titre='" + titre + '\'' +
                ", operations=" + operations +
                '}';
    }
}
