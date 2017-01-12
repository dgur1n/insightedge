#!/usr/bin/env bash


# 1) ./cli.sh grid-gsaStop --gsaId=myGsaId-123123213
# 2) ./cli.sh -c "grid.gsaStop(gsaId = \"myGsaId-123123213\")"
# 3) ./cli.sh

CLI_HOME=/home/zinjvi/projects/GS/CLI/insightedge/cli
CLI_JAR=$CLI_HOME/target/cli-1.1.0-SNAPSHOT.jar
CLI_MAIN=org.gigaspaces.insightedge.cli.prototype.executeMain
HELP_MAIN=org.gigaspaces.insightedge.cli.prototype.helpMain
MODULES=$CLI_HOME/src/main/resources/modules.scala

main() {
    parse_options "$@"
    execute
}

parse_options() {
    while [ "$1" != "" ]; do
      case $1 in
        "help" | "--help" | "-h")
          IS_HELP=true
          ;;
        "-c")
          RUN_CODE=true
          ;;
        *)
            if [ -z $COMMAND ]; then
                COMMAND="$1"
            else
                COMMAND="$COMMAND $1"
            fi
          ;;
      esac
      shift
    done
}

execute() {

    if [ $IS_HELP ]; then
        scala -cp $CLI_JAR $HELP_MAIN $COMMAND
        exit
    fi

    if [ -z $COMMAND ]; then
        scala -cp $CLI_JAR -i $MODULES
        exit
    fi

    if [ ! -z $RUN_CODE ]; then
        scala -cp $CLI_JAR -i $MODULES -e "$COMMAND"
        exit
    fi

    scala -cp $CLI_JAR org.gigaspaces.insightedge.cli.prototype.main "$@"
}

main "$@"
