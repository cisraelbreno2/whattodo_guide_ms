package br.com.guide_ms.domain.port.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GuideModifyRequest {

    private String id;
    private String title;
    private String description;
}
