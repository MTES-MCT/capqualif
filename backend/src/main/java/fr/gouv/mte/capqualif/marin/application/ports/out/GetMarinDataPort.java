package fr.gouv.mte.capqualif.marin.application.ports.out;

import fr.gouv.mte.capqualif.marin.domain.Sailor;

public interface GetMarinDataPort {

    Sailor getMarinData(String sailorNumber);

}
