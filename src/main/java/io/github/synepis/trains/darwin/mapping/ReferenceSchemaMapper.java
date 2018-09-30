package io.github.synepis.trains.darwin.mapping;

import io.github.synepis.trains.darwin.model.cttreferenceschema.LocationRef;
import io.github.synepis.trains.model.Station;

import java.util.List;
import java.util.stream.Collectors;

public class ReferenceSchemaMapper {

    public static List<Station> map(List<LocationRef> locationRefs) {
        return locationRefs.stream()
                .parallel()
                .map(l -> Station.builder()
                        .tiploc(l.getTpl())
                        .name(l.getLocname())
                        .crs(l.getCrs())
                        .build())
                .collect(Collectors.toList());
    }
}
