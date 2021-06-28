package fr.gouv.mte.capqualif.capqualif.request.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.MarinDTO;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;
import org.springframework.stereotype.Component;

@Component
class MarinMapper {
    Marin mapToDomainEntity(MarinDTO marinDto) {
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