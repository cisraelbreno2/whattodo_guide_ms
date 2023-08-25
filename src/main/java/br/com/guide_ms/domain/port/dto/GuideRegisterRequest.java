package br.com.guide_ms.domain.port.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuideRegisterRequest {

    private String userId;
    private String guideCreatorUserId;
    private String title;
    private String description;

}
