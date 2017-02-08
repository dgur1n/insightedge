#!/usr/bin/env bash

if [ -z "${INSIGHTEDGE_HOME}" ]; then
  export INSIGHTEDGE_HOME="$(cd "`dirname "$0"`"/..; pwd)"
fi

. ${INSIGHTEDGE_HOME}/sbin/common-insightedge.sh

MODULES=$CLI_HOME/src/main/resources/modules.scala

CLI_MAIN=org.gigaspaces.insightedge.cli.prototype.executeMain
HELP_MAIN=org.gigaspaces.insightedge.cli.prototype.helpMain

MODULES="$INSIGHTEDGE_HOME/conf/cli-config.scala"

CLI_JARS="$(find $INSIGHTEDGE_HOME/lib -name "insightedge-cli-*.jar"):$INSIGHTEDGE_HOME/datagrid/lib/platform/unified-cli/*"

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
    scala -cp $CLI_JARS $HELP_MAIN $COMMAND
}

run_interactive_mode() {
    scala -cp $CLI_JARS -i $MODULES
}

run_non_interactive_scala_code() {
    scala -cp $CLI_JARS -i $MODULES -e "$COMMAND"
}

run_non_interactive_command() {
    scala -cp $CLI_JARS $CLI_MAIN $COMMAND
}



main "$@"
