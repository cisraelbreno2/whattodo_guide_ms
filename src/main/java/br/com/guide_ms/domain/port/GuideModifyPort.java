package br.com.guide_ms.domain.port;

import br.com.guide_ms.domain.port.dto.GuideModifyRequest;
import br.com.guide_ms.domain.port.dto.GuideModifyResponse;

public interface GuideModifyPort {

    GuideModifyResponse modify(GuideModifyRequest guideModifyRequest);
}
