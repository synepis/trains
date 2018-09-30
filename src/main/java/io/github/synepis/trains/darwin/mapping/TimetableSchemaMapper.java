package io.github.synepis.trains.darwin.mapping;

import io.github.synepis.trains.darwin.model.cttschema.*;
import io.github.synepis.trains.model.ScheduledTime;
import io.github.synepis.trains.model.TrainStop;
import io.github.synepis.trains.model.Train;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TimetableSchemaMapper {

    public static Train map(Schedule schedule) {
        return Train.builder()
                .rid(schedule.getRid())
                .trainStops(TimetableSchemaMapper.map(schedule.getOROrOPOROrIP()))
                .build();
    }

    private static List<TrainStop> map(List<Object> stops) {
        return stops.stream()
                .map(TimetableSchemaMapper::mapStop)
                .collect(Collectors.toList());
    }

    private static TrainStop mapStop(Object stop) {
        if (stop instanceof OR)   { return map((OR) stop); }
        if (stop instanceof OPOR) { return map((OPOR) stop); }
        if (stop instanceof PP)   { return map((PP) stop); }
        if (stop instanceof IP)   { return map((IP) stop); }
        if (stop instanceof OPIP) { return map((OPIP) stop); }
        if (stop instanceof DT)   { return map((DT) stop); }
        if (stop instanceof OPDT) { return map((OPDT) stop); }

        log.error("Could not map stop of type: {}", stop.getClass());
        throw new IllegalArgumentException();
    }

    private static TrainStop map(OR stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), null, null, null, stop.getWtd(), stop.getPtd()))
                .scheduled(ScheduledTime.builder()
                        .departure(stop.getPtd())
                        .build())
                .build();
    }

    private static TrainStop map(OPOR stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), null, null, null, stop.getWtd(), null))
                .scheduled(ScheduledTime.builder()
                        .departure(stop.getWtd())
                        .build())
                .build();
    }

    private static TrainStop map(PP stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), null, null, stop.getWtp(), null, null))
                .scheduled(ScheduledTime.builder()
                        .passing(stop.getWtp())
                        .build())
                .build();
    }

    private static TrainStop map(IP stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), stop.getWta(), stop.getPta(), null, stop.getWtd(), stop.getPtd()))
                .scheduled(ScheduledTime.builder()
                        .arrival(stop.getPta())
                        .departure(stop.getPtd())
                        .build())
                .build();
    }

    private static TrainStop map(OPIP stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), stop.getWta(), null, null, stop.getWtd(), null))
                .scheduled(ScheduledTime.builder()
                        .arrival(stop.getWta())
                        .departure(stop.getWtd())
                        .build())
                .build();
    }

    private static TrainStop map(DT stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), stop.getWta(), stop.getPta(), null, null, null))
                .scheduled(ScheduledTime.builder()
                        .arrival(stop.getPta())
                        .departure(stop.getPtd())
                        .build())
                .build();
    }

    private static TrainStop map(OPDT stop) {
        return TrainStop.builder()
                .id(mapStopId(stop.getTpl(), stop.getWta(), null, null, null, null))
                .scheduled(ScheduledTime.builder()
                        .arrival(stop.getWta())
                        .departure(stop.getWtd())
                        .build())
                .build();
    }


    private static String mapStopId(String tpl, String wta, String pta, String wtp, String wtd, String ptd) {
        return tpl + "-" +
                wta + "-" +
                pta + "-" +
                wtp + "-" +
                wtd + "-" +
                ptd;
    }
}
