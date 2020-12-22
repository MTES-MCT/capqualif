package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {
    JsonElement getMarinData(Map infosToLookFor, String numeroDeMarin);
}
