package io.github.synepis.trains.darwin.mapping

import io.github.synepis.trains.darwin.model.cttreferenceschema.LocationRef
import spock.lang.Specification

class ReferenceSchemaMapperSpec extends Specification {

    def "test maps correctly LocationRefs"() {
        given:
        def locationRefs = [
                new LocationRef(tpl: "tpl1", locname: "locname1"),
                new LocationRef(tpl: "tpl2", crs: "crs2", locname: "locname2"),
                new LocationRef(tpl: "tpl3", crs: "crs3")
        ]

        when:
        def stations = ReferenceSchemaMapper.map(locationRefs)

        then:
        assert stations.size() == 3
        assert stations[0].tiploc == "tpl1"
        assert stations[0].name == "locname1"

        assert stations[1].tiploc == "tpl2"
        assert stations[1].crs == "crs2"
        assert stations[1].name == "locname2"

        assert stations[2].tiploc == "tpl3"
        assert stations[2].crs == "crs3"
    }
}
