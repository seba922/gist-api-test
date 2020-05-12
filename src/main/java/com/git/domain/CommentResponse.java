package com.git.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentResponse {
    private String url;
    private Integer id;
    private String nodeId;
    private User user;
    private String authorAssociation;
    private String createdAt;
    private String updatedAt;
    private String body;
}
