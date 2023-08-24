package br.com.guide_ms.domain.repository;

import br.com.guide_ms.domain.entity.Guide;

public interface GuideRepository {

    Guide saveGuide(Guide guide);
    Guide findById(String id);
    void deleteGuide(String id);


}
