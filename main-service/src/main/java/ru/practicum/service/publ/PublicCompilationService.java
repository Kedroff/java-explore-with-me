package ru.practicum.service.publ;

import ru.practicum.exceptions.NotFoundException;
import ru.practicum.model.compilation.dto.CompilationResponseDto;

import java.util.List;

public interface PublicCompilationService {

    public List<CompilationResponseDto> get(Boolean pinned, Integer from, Integer size);

    public CompilationResponseDto getCompilation(Integer compId) throws NotFoundException;
}