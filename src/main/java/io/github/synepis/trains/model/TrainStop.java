package io.github.synepis.trains.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TrainStop {
    private String id;                  // "{tiploc}-{wta}-{pta}-{wtp}-{wtd}-{ptd}"
    private ScheduledTime scheduled;
    private RealTime realTime;
}
