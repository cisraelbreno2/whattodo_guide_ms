package br.com.guide_ms.domain.port;

import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.GuideRegisterResponse;

public interface GuideRegisterPort {

    GuideRegisterResponse register(GuideRegisterRequest GuideRegisterRequest);
}
