package br.com.guide_ms.domain.port;

import br.com.guide_ms.domain.port.dto.GuideResponse;

public interface FindGuideByIdPort {

    GuideResponse findById(String id);
}
