package io.github.synepis.trains.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Timing {
    private TimingType type;
    private String time;
}

