#!/usr/bin/env bash

ROOT=/home/zinjvi/projects/GS/CLI/insightedge
CLI_HOME=$ROOT/insightedge-cli
CLI_JAR=$CLI_HOME/target/insightedge-cli-1.1.0-SNAPSHOT.jar:$ROOT/cli-core/target/cli-core-1.1.0-SNAPSHOT.jar:$ROOT/xap-cli/target/xap-cli-1.1.0-SNAPSHOT.jar
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
        run_non_interactive_help
    elif [ -z "$COMMAND" ]; then
        run_interactive_mode
    elif [ ! -z "$RUN_CODE" ]; then
        run_non_interactive_scala_code
    else
        run_non_interactive_command
    fi

}

run_non_interactive_help() {
    scala -cp $CLI_JAR $HELP_MAIN $COMMAND
}

run_interactive_mode() {
    scala -cp $CLI_JAR -i $MODULES
}

run_non_interactive_scala_code() {
    scala -cp $CLI_JAR -i $MODULES -e "$COMMAND"
}

run_non_interactive_command() {
    scala -cp $CLI_JAR $CLI_MAIN $COMMAND
}

main "$@"
