package io.github.synepis.trains.darwin.mapping


import io.github.synepis.trains.darwin.model.cttschema.*
import spock.lang.Specification

class TimetableSchemaMapperSpec extends Specification {

    def "test maps correctly a train"() {
        given:
        def journey = new Schedule(
                rid: "201809306772601",
                orOrOPOROrIP: [

                        new OR  (tpl: "tpl1", wtd: "10:04", ptd: "10:05"),
                        new OPOR(tpl: "tpl2", wtd: "10:04"),
                        new PP  (tpl: "tpl3", wtp: "10:03"),
                        new IP  (tpl: "tpl4", wta: "10:01", pta: "10:02", wtd: "10:04", ptd: "10:05"),
                        new OPIP(tpl: "tpl5", wta: "10:01", wtd: "10:04"),
                        new DT  (tpl: "tpl6", wta: "10:01", pta: "10:02"),
                        new OPDT(tpl: "tpl7", wta: "10:01")])

        when:
        def train = TimetableSchemaMapper.map(journey)

        then:
        assert train.rid == "201809306772601"

        assert train.trainStops[0].id == "tpl1-null-null-null-10:04-10:05"
        assert train.trainStops[0].scheduled.departure == "10:05"

        assert train.trainStops[1].id == "tpl2-null-null-null-10:04-null"
        assert train.trainStops[1].scheduled.departure == "10:04"

        assert train.trainStops[2].id == "tpl3-null-null-10:03-null-null"
        assert train.trainStops[2].scheduled.passing == "10:03"

        assert train.trainStops[3].id == "tpl4-10:01-10:02-null-10:04-10:05"
        assert train.trainStops[3].scheduled.arrival == "10:02"
        assert train.trainStops[3].scheduled.departure == "10:05"

        assert train.trainStops[4].id == "tpl5-10:01-null-null-10:04-null"
        assert train.trainStops[4].scheduled.arrival == "10:01"
        assert train.trainStops[4].scheduled.departure == "10:04"

        assert train.trainStops[5].id == "tpl6-10:01-10:02-null-null-null"
        assert train.trainStops[5].scheduled.arrival == "10:02"

        assert train.trainStops[6].id == "tpl7-10:01-null-null-null-null"
        assert train.trainStops[6].scheduled.arrival == "10:01"
    }

}
