package io.github.synepis.trains.darwin.mapping;

import io.github.synepis.trains.darwin.model.pptschema.*;
import io.github.synepis.trains.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class PushPortSchemaMapper {

    public static Train map(TS ts) {
        return Train.builder()
                .rid(ts.getRid())
                .trainStops(PushPortSchemaMapper.map(ts.getLocation()))
                .build();
    }

    private static List<TrainStop> map(List<TSLocation> stops) {
        return stops.stream()
                .map(PushPortSchemaMapper::map)
                .collect(Collectors.toList());
    }


    private static TrainStop map(TSLocation location) {
        return TrainStop.builder()
                .id(mapStopId(location))
                .realTime(
                        RealTime.builder()
                                .arrival(mapTiming(location.getArr()))
                                .passing(mapTiming(location.getPass()))
                                .departure(mapTiming(location.getDep()))
                                .build())
                .build();
    }

    private static Timing mapTiming(TSTimeData tsTimeData) {
        if (tsTimeData == null) { return null; }

        if (tsTimeData.getAt() != null) {
            return Timing.builder().time(tsTimeData.getAt()).type(TimingType.ACTUAL).build();
        }
        if (tsTimeData.getEt() != null) {
            return Timing.builder().time(tsTimeData.getEt()).type(TimingType.ESTIMATE).build();
        }
        if (tsTimeData.getWet() != null) {
            return Timing.builder().time(tsTimeData.getWet()).type(TimingType.ESTIMATE).build();
        }

        log.warn("TSTimeData without at, et or wet");
        return null;
    }

    private static String mapStopId(TSLocation location) {
        return location.getTpl() + "-" +
                location.getWta() + "-" +
                location.getPta() + "-" +
                location.getWtp() + "-" +
                location.getWtd() + "-" +
                location.getPtd();
    }
}


