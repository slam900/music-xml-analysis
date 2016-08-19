#!/usr/bin/env sh

mvn clean compile assembly:single

if [ $? -ne 0 ]; then
  exit $?
fi

rm -rf dist/*

# should only be one monolithic jar
cp ./target/*.jar ./dist
