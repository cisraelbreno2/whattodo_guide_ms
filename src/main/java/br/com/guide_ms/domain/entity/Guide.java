package br.com.guide_ms.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Guide {

    private String id;
    private String userId;
    private String GuideCreatorUserId;
    private String title;
    private String description;
    private LocalDateTime createDate;

    public Guide(String userId, String guideCreatorUserId, String title, String description, LocalDateTime createDate) {
        this.userId = userId;
        GuideCreatorUserId = guideCreatorUserId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }
}
