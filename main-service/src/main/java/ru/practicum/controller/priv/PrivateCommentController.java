package ru.practicum.controller.priv;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.Constants;
import ru.practicum.exceptions.CommentException;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.IsNotPublishedException;
import ru.practicum.exceptions.ValidationException;
import ru.practicum.model.comment.dto.CommentDtoResponse;
import ru.practicum.model.comment.dto.NewCommentDto;
import ru.practicum.model.comment.dto.UpdateCommentDto;
import ru.practicum.service.priv.PrivateCommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class PrivateCommentController {

    @Autowired
    PrivateCommentService service;

    private static final String USER_EVENT_COMMENT_PATH = Constants.USER_PATH_ID + Constants.EVENT_PATH + Constants.EVENT_PATH_ID;
    private static final String USER_COMMENT_PATH = Constants.USER_PATH_ID + "/comment" + Constants.COMMENT_ID;
    private static final String COMMENT_ID_PATH = Constants.COMMENT_ID;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(USER_EVENT_COMMENT_PATH)
    public CommentDtoResponse create(@PathVariable(name = "user-id") Integer userId,
                                     @PathVariable(name = "event-id") Integer eventId, @Valid @RequestBody
                                     NewCommentDto newCommentDto) throws
            IsNotPublishedException, NotFoundException {
        return service.create(userId, eventId, newCommentDto);
    }

    @PatchMapping(USER_COMMENT_PATH)
    public CommentDtoResponse patch(@PathVariable(name = "user-id") Integer userId,
                                    @PathVariable(name = "comment-id") Integer commentId, @Valid @RequestBody
                                    UpdateCommentDto updateCommentDto) throws
            NotFoundException, CommentException {
        return service.patch(userId, commentId, updateCommentDto);
    }

    @GetMapping(COMMENT_ID_PATH)
    public CommentDtoResponse getComment(@PathVariable(name = "comment-id") Integer commentId) throws NotFoundException {
        return service.getComment(commentId);
    }

    @GetMapping
    public List<CommentDtoResponse> get(@RequestParam(required = false) List<Integer> userId,
                                        @RequestParam(required = false) List<Integer> eventId,
                                        @RequestParam(required = false) String text,
                                        @RequestParam(required = false) String startTime,
                                        @RequestParam(required = false) String endTime) throws NotFoundException, ValidationException {
        return service.get(userId, eventId, text, startTime, endTime);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(COMMENT_ID_PATH)
    public void delete(@PathVariable(name = "comment-id") Integer commentId) throws NotFoundException {
        service.delete(commentId);
    }
}
