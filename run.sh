#!/bin/bash
mvn clean install eclipse:eclipse: assembly:single && clear && java -cp target/binary-tree-0.0.1-SNAPSHOT-jar-with-dependencies.jar -jar target/binary-tree-0.0.1-SNAPSHOT-jar-with-dependencies.jar
