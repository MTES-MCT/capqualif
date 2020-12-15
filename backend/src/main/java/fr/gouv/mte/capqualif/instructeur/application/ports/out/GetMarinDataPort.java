package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import com.google.gson.JsonArray;

import java.util.List;

public interface GetMarinDataPort {
    JsonArray getMarinData(String existingDataSource, String numeroDeMarin);

}
