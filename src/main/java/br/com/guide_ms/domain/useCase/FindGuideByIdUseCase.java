package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.entity.factory.GuideFactory;
import br.com.guide_ms.domain.port.FindGuideByIdPort;
import br.com.guide_ms.domain.port.dto.GuideResponse;
import br.com.guide_ms.domain.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindGuideByIdUseCase implements FindGuideByIdPort {

    private final GuideRepository guideRepository;

    @Override
    public GuideResponse findById(String id) {
        return GuideFactory.toGuideResponse(guideRepository.findById(id));
    }
}
