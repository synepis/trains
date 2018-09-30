package io.github.synepis.trains.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RealTime {
    private Timing arrival;
    private Timing passing;
    private Timing departure;
}
