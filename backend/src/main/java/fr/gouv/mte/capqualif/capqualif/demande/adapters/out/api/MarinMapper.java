package fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.capqualif.demande.domain.marin.Marin;
import org.springframework.stereotype.Component;

@Component
class MarinMapper {
    Marin mapToDomaineEntity(MarinDto marinDto) {
        Marin marin = new Marin(
                marinDto.getNumIdentification(),
                marinDto.getNom(),
                marinDto.getNomUsage(),
                marinDto.getPrenom(),
                marinDto.getVilleNaissance(),
                marinDto.getNumeroFixe(),
                marinDto.getNumeroPortable(),
                marinDto.getAdresseMessagerie(),
                marinDto.getDateNaissance(),
                marinDto.getDateIdentification(),
                marinDto.getCodeNationalite().getLibelle(),
                marinDto.getCodeCivilite().getLibelle(),
                marinDto.getCodeServiceRattachement().getLibelle()
        );
        return marin;
    }
}
