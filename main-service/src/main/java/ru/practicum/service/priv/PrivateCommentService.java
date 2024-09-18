package ru.practicum.service.priv;

import ru.practicum.exceptions.CommentException;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.IsNotPublishedException;
import ru.practicum.exceptions.ValidationException;
import ru.practicum.model.comment.dto.CommentDtoResponse;
import ru.practicum.model.comment.dto.NewCommentDto;
import ru.practicum.model.comment.dto.UpdateCommentDto;

import java.util.List;

public interface PrivateCommentService {

    CommentDtoResponse create(Integer userId, Integer eventId, NewCommentDto newCommentDto) throws NotFoundException, IsNotPublishedException;

    CommentDtoResponse patch(Integer userId, Integer eventId, UpdateCommentDto updateCommentDto) throws NotFoundException, CommentException;

    CommentDtoResponse getComment(Integer id) throws NotFoundException;

    List<CommentDtoResponse> get(List<Integer> userId, List<Integer> eventId, String text, String startTime, String endTime) throws ValidationException;

    void delete(Integer id) throws NotFoundException;
}
