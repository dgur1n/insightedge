#!/usr/bin/env bash

if [ "$#" -gt 0 ]; then

    scala -cp /code/insightedge/cli/target/cli-1.1.0-SNAPSHOT.jar org.gigaspaces.insightedge.cli.CliTestApp "$@"
else
    scala -cp /code/insightedge/cli/target/cli-1.1.0-SNAPSHOT.jar -i ./importGrid.scala
fi