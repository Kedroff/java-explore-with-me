package ru.practicum.service.admin;

import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.PublishedException;
import ru.practicum.exceptions.PatchException;
import ru.practicum.exceptions.PublicationException;
import ru.practicum.model.event.dto.EventDtoResponse;
import ru.practicum.model.event.dto.UpdateEventAdminRequest;

import java.util.List;

public interface AdminEventService {

    public List<EventDtoResponse> get(List<Integer> usersId, List<String> states, List<Integer> categoriesId, String start,
                                      String end, Integer from, Integer size);

    public EventDtoResponse patch(Integer eventId, UpdateEventAdminRequest updateEventAdminRequest) throws NotFoundException,
            PatchException, PublishedException, PublicationException;

}