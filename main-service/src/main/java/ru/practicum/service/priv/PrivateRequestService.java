package ru.practicum.service.priv;

import ru.practicum.exceptions.NotFoundException;
import ru.practicum.exceptions.LimitExceededException;
import ru.practicum.exceptions.RequestErrorException;
import ru.practicum.model.request.dto.ParticipationRequestDto;

import java.util.List;

public interface PrivateRequestService {

    List<ParticipationRequestDto> get(Integer userId) throws NotFoundException;

    ParticipationRequestDto create(Integer userId, Integer eventId) throws NotFoundException, LimitExceededException, RequestErrorException;

    ParticipationRequestDto patch(Integer userId, Integer requestId) throws NotFoundException;
}