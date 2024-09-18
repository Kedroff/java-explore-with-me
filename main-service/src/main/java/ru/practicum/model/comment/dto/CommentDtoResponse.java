package ru.practicum.model.comment.dto;

import lombok.Data;

@Data
public class CommentDtoResponse {

    private String text;
    private Integer author;
    private Integer event;
    private String timestamp;
}
