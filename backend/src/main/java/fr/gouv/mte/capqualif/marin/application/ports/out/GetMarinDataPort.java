package fr.gouv.mte.capqualif.marin.application.ports.out;

import fr.gouv.mte.capqualif.marin.domain.Marin;

public interface GetMarinDataPort {

    Marin getMarinData(String sailorNumber);

}
