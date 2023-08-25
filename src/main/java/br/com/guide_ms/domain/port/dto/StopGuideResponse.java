package br.com.guide_ms.domain.port.dto;

import br.com.guide_ms.domain.entity.enums.CategoryLocacion;

import java.time.LocalDateTime;

public class StopGuideResponse {

    private String id;
    private String title;
    private String coordinates;
    private String whatToDo;
    private CategoryLocacion categoryLocacion;
    private LocalDateTime initialDateHour;
    private LocalDateTime finalDateHour;
}
