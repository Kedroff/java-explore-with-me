package ru.practicum.service.priv;

import ru.practicum.exceptions.*;
import ru.practicum.model.event.dto.*;
import ru.practicum.model.request.dto.ParticipationRequestDto;

import java.util.List;

public interface PrivateEventService {

    public EventDtoResponse create(Integer userId, EventDto eventDto) throws NotFoundException, PatchException;

    public List<EventShortDto> getEvents(Integer userId, Integer from, Integer size) throws NotFoundException;

    public EventDtoResponse getFullEvent(Integer userId, Integer eventId) throws NotFoundException;

    public EventDtoResponse patchEvent(Integer userId, Integer eventId, UpdateEventUserRequest eventDto) throws NotFoundException, PatchException, PublishedException;

    public List<ParticipationRequestDto> getRequests(Integer userId, Integer eventId) throws NotFoundException, RequestErrorException;

    public RequestStatusResult patchStatus(Integer userId, Integer eventId, EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest) throws RequestErrorException, NotFoundException, LimitExceededException;

}