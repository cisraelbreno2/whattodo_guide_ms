package br.com.guide_ms.domain.entity.factory;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.GuideRegisterResponse;
import br.com.guide_ms.domain.port.dto.GuideResponse;

import java.time.LocalDateTime;

public class GuideFactory {

    private GuideFactory(){}

    public static Guide fromRegisterRequest(GuideRegisterRequest request){
        return new Guide(request.getUserId(), request.getGuideCreatorUserId(), request.getTitle(), request.getDescription(), LocalDateTime.now());
    }

    public static GuideRegisterResponse toRegisterResponse(Guide guide){
        return new GuideRegisterResponse(guide.getId(), guide.getTitle());
    }

    public static GuideResponse toGuideResponse(Guide guide){
        return new GuideResponse(guide.getId(), guide.getUserId(), guide.getGuideCreatorUserId(), guide.getTitle(), guide.getDescription(), guide.getCreateDate());
    }


}
