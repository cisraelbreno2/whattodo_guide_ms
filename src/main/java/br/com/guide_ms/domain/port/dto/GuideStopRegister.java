package br.com.guide_ms.domain.port.dto;

import br.com.guide_ms.domain.entity.enums.CategoryLocacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class GuideStopRegister {

    private String title;
    private String coordinates;
    private String whatToDo;
    private CategoryLocacion categoryLocacion;
    private LocalDateTime initialDateHour;
    private LocalDateTime finalDateHour;
    private List<String> attachmentList;

}
