#!/usr/bin/env sh

dist_dir="$( cd "$( dirname "${0}" )/../dist" && pwd )"

java -jar "${dist_dir}/"*".jar" $*
