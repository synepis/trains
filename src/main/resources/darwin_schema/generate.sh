#!/bin/bash

rm -rf src/main/java/io/github/synepis/trains/darwin/model/cttreferenceschema/
rm -rf src/main/java/io/github/synepis/trains/darwin/model/cttschema/
rm -rf src/main/java/io/github/synepis/trains/darwin/model/pptschema/


xjc src/main/resources/darwin_schema/xsd/rttiCTTReferenceSchema_v3.xsd \
    -p io.github.synepis.trains.darwin.model.cttreferenceschema  \
    -d src/main/java/

xjc  src/main/resources/darwin_schema/xsd/rttiCTTSchema_v8.xsd \
    -p io.github.synepis.trains.darwin.model.cttschema \
    -d src/main/java/

xjc  src/main/resources/darwin_schema/xsd/rttiPPTSchema_v12.xsd \
    -p io.github.synepis.trains.darwin.model.pptschema \
    -d src/main/java/

