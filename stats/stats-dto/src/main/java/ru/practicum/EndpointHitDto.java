package ru.practicum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class EndpointHitDto {
    String app;
    String uri;
    String ip;
    String timestamp;
}