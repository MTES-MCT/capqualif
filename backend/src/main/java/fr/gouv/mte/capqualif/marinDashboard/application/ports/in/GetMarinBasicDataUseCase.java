package fr.gouv.mte.capqualif.marinDashboard.application.ports.in;

import fr.gouv.mte.capqualif.marinDashboard.domain.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
