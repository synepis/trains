package io.github.synepis.trains.darwin;

import spock.lang.Specification

class XmlParserSpec extends Specification {

    private XmlParser xmlParser

    def setup() {
        xmlParser = new XmlParser()
    }

    def "can parse darwin reference data"() {
        given:
        def fileStream = new FileInputStream("src/test/resources/darwin_xml/reference_data_sample.xml")

        when:
        def refData = xmlParser.parseCttiReferenceSchema(fileStream)

        then:
        refData.locationRef.size() == 14
        refData.tocRef.size() == 7
        refData.cancellationReasons.reason.size() == 10
        refData.lateRunningReasons.reason.size() == 5
        refData.via.size() == 11
        refData.CISSource.size() == 3
    }

    def "can parse darwin timetable data"() {
        given:
        def fileStream = new FileInputStream("src/test/resources/darwin_xml/timetable_data_sample.xml")

        when:
        def ttData = xmlParser.parseCttiSchema(fileStream)

        then:
        ttData.journey.size() == 7
        ttData.association.size() == 2
    }

    def "can parse darwin push port data"() {
        given:
        def fileStream = new FileInputStream("src/test/resources/darwin_xml/push_port_data_sample.xml")

        when:
        def ppData = xmlParser.parsePPTSchema(fileStream)

        then:
        ppData.ts.toString() == "2018-09-30T08:54:00.2207281+01:00"
        ppData.UR.TS[0].rid == "201809308747473"
        ppData.UR.TS[0].ssd.toString() == "2018-09-30"
        ppData.UR.TS[0].uid == "W47473"
        ppData.UR.TS[0].location.size() == 24
    }
}
