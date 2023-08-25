package br.com.guide_ms.domain.port.dto;

import br.com.guide_ms.domain.entity.enums.CategoryLocacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class GuideResponse {
    private String id;
    private String userId;
    private String GuideCreatorUserId;
    private String title;
    private String description;
    private LocalDateTime createDate;
}
