package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import com.google.gson.JsonElement;

import java.util.List;

public interface GetMarinDataPort {
    JsonElement getMarinData(String existingDataSource, String numeroDeMarin);

}
