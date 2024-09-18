package ru.practicum.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.Constants;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.PublishedException;
import ru.practicum.exceptions.PatchException;
import ru.practicum.exceptions.PublicationException;
import ru.practicum.model.event.dto.EventDtoResponse;
import ru.practicum.model.event.dto.UpdateEventAdminRequest;
import ru.practicum.service.admin.AdminEventService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/events")
public class AdminEventController {

    @Autowired
    AdminEventService service;

    @GetMapping
    public List<EventDtoResponse> get(@RequestParam(required = false) List<Integer> users,
                                      @RequestParam(required = false) List<String> states,
                                      @RequestParam(required = false) List<Integer> categories,
                                      @RequestParam(required = false) String rangeStart,
                                      @RequestParam(required = false) String rangeEnd,
                                      @RequestParam(defaultValue = "0") Integer from, @RequestParam(defaultValue = "10") Integer size) {
        return service.get(users, states, categories, rangeStart, rangeEnd, from, size);
    }

    @PatchMapping(Constants.EVENT_PATH_ID)
    public EventDtoResponse patch(@PathVariable(name = "event-id") Integer eventId, @Valid @RequestBody UpdateEventAdminRequest updateEventAdminRequest)
            throws PatchException, NotFoundException, PublishedException, PublicationException {
        return service.patch(eventId, updateEventAdminRequest);
    }
}