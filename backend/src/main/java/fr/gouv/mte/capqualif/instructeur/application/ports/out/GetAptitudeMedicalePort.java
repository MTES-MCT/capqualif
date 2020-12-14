package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import com.google.gson.JsonArray;

public interface GetAptitudeMedicalePort {
    JsonArray getAptitudeMedicale(String source, String sailorNumber);
}