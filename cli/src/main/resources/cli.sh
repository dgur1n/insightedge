#!/usr/bin/env bash


# 1) ./cli.sh grid-gsaStop --gsaId=myGsaId-123123213
# 2) ./cli.sh -c "grid.gsaStop(gsaId = \"myGsaId-123123213\")"
# 3) ./cli.sh



export CLI_HOME=/home/zinjvi/projects/GS/CLI/insightedge/cli

if [ "$#" -gt 0 ]; then
    if [ "$1" == "-c" ]; then
        shift
        echo "run code $@"
        scala -cp $CLI_HOME/target/cli-1.1.0-SNAPSHOT.jar -i $CLI_HOME/src/main/resources/importGrid.scala -e "$@"
    else
        scala -cp $CLI_HOME/target/cli-1.1.0-SNAPSHOT.jar org.gigaspaces.insightedge.cli.prototype.main "$@"
    fi
else
    scala -cp $CLI_HOME/target/cli-1.1.0-SNAPSHOT.jar -i ./importGrid.scala
fi

