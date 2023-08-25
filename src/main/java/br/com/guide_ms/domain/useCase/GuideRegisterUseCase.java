package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.entity.factory.GuideFactory;
import br.com.guide_ms.domain.exceptions.GuideCreateException;
import br.com.guide_ms.domain.port.GuideRegisterPort;
import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.GuideRegisterResponse;
import br.com.guide_ms.domain.repository.GuideRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import static br.com.guide_ms.domain.util.ObjectUtils.isNullOrEmpty;

@Service
@AllArgsConstructor
public class GuideRegisterUseCase implements GuideRegisterPort {

    private final GuideRepository guideRepository;

    @Override
    public GuideRegisterResponse register(GuideRegisterRequest guideRegisterRequest) {
        if(isNullOrEmpty(guideRegisterRequest.getGuideCreatorUserId(), guideRegisterRequest.getUserId(), guideRegisterRequest.getTitle(), guideRegisterRequest.getDescription())){
            throw new GuideCreateException("O id, titulo ou descrição não podem estar nulos.");
        }

        final var guide = guideRepository.saveGuide(GuideFactory.fromRegisterRequest(guideRegisterRequest));
        return new GuideRegisterResponse(guide.getId(), guide.getTitle());
    }
}
