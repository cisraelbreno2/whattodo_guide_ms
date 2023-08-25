package br.com.guide_ms.domain.entity;

import br.com.guide_ms.domain.exceptions.GuideModifyException;
import br.com.guide_ms.domain.util.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Guide {

    private String id;
    private String userId;
    private String guideCreatorUserId;
    private String title;
    private String description;
    private LocalDateTime createDate;

    public Guide(String userId, String guideCreatorUserId, String title, String description, LocalDateTime createDate) {
        this.userId = userId;
        this.guideCreatorUserId = guideCreatorUserId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

    public void modifyDescription(String description){
        if(ObjectUtils.isNullOrEmpty(description)){
            throw new GuideModifyException("A descrição do guia não pode estar vazia");
        }
        this.description = description;
    }

    public void modifyTitle(String title){
        if(ObjectUtils.isNullOrEmpty(title)){
            throw new GuideModifyException("O titulo do guia não pode estar vazia");
        }
        this.title = title;
    }
}
