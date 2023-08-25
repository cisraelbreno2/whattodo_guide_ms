package br.com.guide_ms.domain.entity;

import br.com.guide_ms.domain.entity.enums.CategoryLocacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Stop {

    private String id;
    private String title;
    private String coordinates;
    private String whatToDo;
    private CategoryLocacion categoryLocacion;
    private LocalDateTime initialDateHour;
    private LocalDateTime finalDateHour;
    private List<String> attachmentList;
    private String guideId;

    public Stop(String title, String coordinates, String whatToDo, CategoryLocacion categoryLocacion, LocalDateTime initialDateHour, LocalDateTime finalDateHour, List<String> attachmentList) {
        this.title = title;
        this.coordinates = coordinates;
        this.whatToDo = whatToDo;
        this.categoryLocacion = categoryLocacion;
        this.initialDateHour = initialDateHour;
        this.finalDateHour = finalDateHour;
        this.attachmentList = attachmentList;
    }

    public void addGuideId(String guideId){
        if(guideId == null || guideId.isEmpty()){
            throw new IllegalArgumentException("Não é possivel atribuir um guia nulo a uma parada");
        }
        this.guideId = guideId;
    }
}
