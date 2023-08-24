package br.com.guide_ms.domain.port.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GuideRegisterRequest {

    private String userId;
    private String GuideCreatorUserId;
    private String title;
    private String description;
    private List<GuideStopRegister> guideStopRegisterList;
}
