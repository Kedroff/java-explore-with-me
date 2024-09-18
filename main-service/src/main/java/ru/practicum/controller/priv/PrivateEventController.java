package ru.practicum.controller.priv;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.Constants;
import ru.practicum.exceptions.*;
import ru.practicum.model.event.dto.*;
import ru.practicum.model.request.dto.ParticipationRequestDto;
import ru.practicum.service.priv.PrivateEventService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PrivateEventController {

    private static final String USER_ID_PATH = Constants.USER_PATH_ID;
    private static final String EVENTS_PATH = Constants.EVENTS_PATH;
    private static final String EVENTS_PATH_ID = Constants.EVENTS_PATH_ID;
    private static final String USER_EVENT_REQUESTS_PATH = Constants.USER_EVENT_REQUESTS_PATH;

    @Autowired
    PrivateEventService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(USER_ID_PATH + EVENTS_PATH)
    public EventDtoResponse create(@PathVariable(name = "user-id") Integer userId,
                                   @Valid @RequestBody EventDto eventDto) throws NotFoundException, PatchException {
        return service.create(userId, eventDto);
    }

    @PatchMapping(USER_ID_PATH + EVENTS_PATH_ID)
    public EventDtoResponse patch(@PathVariable(name = "user-id") Integer userId,
                                  @PathVariable(name = "event-id") Integer eventId,
                                  @Valid @RequestBody UpdateEventUserRequest updateEventUserRequest) throws PatchException,
            NotFoundException, PublishedException {
        return service.patchEvent(userId, eventId, updateEventUserRequest);
    }

    @GetMapping(USER_ID_PATH + EVENTS_PATH_ID)
    public EventDtoResponse getFullEvent(@PathVariable(name = "user-id") Integer userId,
                                         @PathVariable(name = "event-id") Integer eventId) throws NotFoundException {
        return service.getFullEvent(userId, eventId);
    }

    @GetMapping(USER_ID_PATH + EVENTS_PATH)
    public List<EventShortDto> getEvents(@PathVariable(name = "user-id") Integer userId,
                                         @RequestParam(defaultValue = "0") Integer from,
                                         @RequestParam(defaultValue = "10") Integer size) throws NotFoundException {
        return service.getEvents(userId, from, size);
    }

    @GetMapping(USER_EVENT_REQUESTS_PATH)
    public List<ParticipationRequestDto> getRequests(@PathVariable(name = "user-id") Integer userId,
                                                     @PathVariable(name = "event-id") Integer eventId) throws
            RequestErrorException, NotFoundException {
        return service.getRequests(userId, eventId);
    }

    @PatchMapping(USER_EVENT_REQUESTS_PATH)
    public RequestStatusResult patchStatus(@PathVariable(name = "user-id") Integer userId,
                                           @PathVariable(name = "event-id") Integer eventId,
                                           @RequestBody(required = false) EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest)
            throws RequestErrorException, NotFoundException, LimitExceededException {
        return service.patchStatus(userId, eventId, eventRequestStatusUpdateRequest);
    }
}
