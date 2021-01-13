package fr.gouv.mte.capqualif.marinDashboard.adapters.out.api;

import fr.gouv.mte.capqualif.marinDashboard.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marinDashboard.domain.Marin;
import fr.gouv.mte.capqualif.shared.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinDataAPIAdapter implements GetMarinDataPort {

    @Autowired
    JsonGetter jsonGetter;

    String API_URL = "***REMOVED******REMOVED***";
    String API_URL_MOCK = "***REMOVED***";

    @Override
    public Marin getMarinData(String numeroDeMarin) {
        Marin marinJson = jsonGetter.getMarinFromAPI(numeroDeMarin, API_URL_MOCK);
        return marinJson;
    }
}
