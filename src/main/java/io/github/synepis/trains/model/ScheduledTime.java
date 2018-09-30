package io.github.synepis.trains.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScheduledTime {
    private String arrival;
    private String passing;
    private String departure;
}
