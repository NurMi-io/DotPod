#!/bin/sh
export CROWDIN_PERSONAL_TOKEN=`cat ~/.appconfig/com.nurmi.dotpod/crowdin.key`
alias crowdin-cli='java -jar crowdin-cli.jar'
crowdin-cli "$@"
