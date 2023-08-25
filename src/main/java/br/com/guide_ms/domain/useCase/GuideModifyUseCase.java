package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.port.GuideModifyPort;
import br.com.guide_ms.domain.port.dto.GuideModifyRequest;
import br.com.guide_ms.domain.port.dto.GuideModifyResponse;
import br.com.guide_ms.domain.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuideModifyUseCase implements GuideModifyPort {

    private final GuideRepository guideRepository;

    @Override
    public GuideModifyResponse modify(GuideModifyRequest guideModifyRequest) {
        var guide = guideRepository.findById(guideModifyRequest.getId());

        guide.modifyDescription(guideModifyRequest.getDescription());
        guide.modifyTitle(guideModifyRequest.getTitle());

        guideRepository.saveGuide(guide);

        return new GuideModifyResponse("Guia alterado com sucesso");
    }
}
