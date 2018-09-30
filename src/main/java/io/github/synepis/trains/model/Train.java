package io.github.synepis.trains.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Train {
    private String rid;
    private List<TrainStop> trainStops;
    private List<List<TrainStop>> history;
}
