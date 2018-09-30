package io.github.synepis.trains.darwin.mapping

import io.github.synepis.trains.darwin.model.pptschema.*
import io.github.synepis.trains.model.TimingType
import spock.lang.Specification

class PushPortSchemaMapperTest extends Specification {
    def "test maps correctly a train"() {
        given:
        def ts = new TS(
                rid: "201809306772601",
                location: [
                        new TSLocation(
                                tpl: "tpl1", wtd: "10:04", ptd: "10:05",
                                dep: new TSTimeData(at: "10:06", et: "10:07", wet: "10:08")),
                        new TSLocation(
                                tpl: "tpl2", wtd: "10:04",
                                pass: new TSTimeData(et: "10:07", wet: "10:08")),
                        new TSLocation(
                                tpl: "tpl3", wtd: "10:04",
                                arr: new TSTimeData(wet: "10:08"))
                        ])

        when:
        def train = PushPortSchemaMapper.map(ts)

        then:
        assert train.rid == "201809306772601"
        assert train.trainStops.size() == 3

        assert train.trainStops[0].realTime.departure.time == "10:06"
        assert train.trainStops[0].realTime.departure.type == TimingType.ACTUAL

        assert train.trainStops[1].realTime.passing.time == "10:07"
        assert train.trainStops[1].realTime.passing.type == TimingType.ESTIMATE

        assert train.trainStops[2].realTime.arrival.time == "10:08"
        assert train.trainStops[2].realTime.arrival.type == TimingType.ESTIMATE
    }
}
