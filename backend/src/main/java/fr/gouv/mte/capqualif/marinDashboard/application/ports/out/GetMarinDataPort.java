package fr.gouv.mte.capqualif.marinDashboard.application.ports.out;

import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.marinDashboard.domain.Marin;

public interface GetMarinDataPort {

    Marin getMarinData(String numeroDeMarin);

}
