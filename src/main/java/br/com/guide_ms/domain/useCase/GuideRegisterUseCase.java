package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.entity.Stop;
import br.com.guide_ms.domain.entity.factory.GuideFactory;
import br.com.guide_ms.domain.entity.factory.StopFactory;
import br.com.guide_ms.domain.port.GuideRegisterPort;
import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.GuideRegisterResponse;
import br.com.guide_ms.domain.repository.GuideRepository;
import br.com.guide_ms.domain.repository.StopRepository;
import br.com.guide_ms.domain.util.ObjectUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class GuideRegisterUseCase implements GuideRegisterPort {

    private final GuideRepository guideRepository;
    private final StopRepository stopRepository;

    @Override
    public GuideRegisterResponse register(GuideRegisterRequest guideRegisterRequest) {
        final var guide = guideRepository.saveGuide(GuideFactory.fromRegisterRequest(guideRegisterRequest));

        if(ObjectUtils.isNotNullOrEmpty(guideRegisterRequest.getGuideStopRegisterList())){
            var stops = guideRegisterRequest.getGuideStopRegisterList()
                    .stream()
                    .map(e -> StopFactory.fromRegisterRequest(e))
                    .toList();
            stops.stream().forEach(e -> e.addGuideId(guide.getId()));
            stopRepository.saveStopList(stops);
        }
        return new GuideRegisterResponse(guide.getId(), guide.getTitle());
    }
}
