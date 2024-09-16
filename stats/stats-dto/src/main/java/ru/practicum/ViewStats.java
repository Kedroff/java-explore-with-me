package ru.practicum;

import lombok.*;

@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class ViewStats {
    String app;
    String uri;
    Long hits;
}