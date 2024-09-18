package ru.practicum.controller.priv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.Constants;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.LimitExceededException;
import ru.practicum.exceptions.RequestErrorException;
import ru.practicum.model.request.dto.ParticipationRequestDto;
import ru.practicum.service.priv.PrivateRequestService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PrivateRequestsController {

    @Autowired
    PrivateRequestService service;

    private static final String USER_REQUESTS_PATH = Constants.USER_PATH_ID + Constants.REQUESTS_PATH;
    private static final String USER_REQUEST_CANCEL_PATH = USER_REQUESTS_PATH + Constants.REQUEST_PATH_ID + "/cancel";

    @GetMapping(USER_REQUESTS_PATH)
    public List<ParticipationRequestDto> get(@PathVariable(name = "user-id") Integer userId) throws NotFoundException {
        return service.get(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(USER_REQUESTS_PATH)
    public ParticipationRequestDto create(@PathVariable(name = "user-id") Integer userId,
                                          @RequestParam Integer eventId) throws
            NotFoundException, LimitExceededException, RequestErrorException {
        return service.create(userId, eventId);
    }

    @PatchMapping(USER_REQUEST_CANCEL_PATH)
    public ParticipationRequestDto patch(@PathVariable(name = "user-id") Integer userId,
                                         @PathVariable(name = "request-id") Integer requestId) throws NotFoundException {
        return service.patch(userId, requestId);
    }
}
