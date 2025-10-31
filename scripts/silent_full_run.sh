#!/bin/bash

ARG="${1:-scenario.txt}"

bash scripts/compile.sh > /dev/null
bash scripts/run.sh "$ARG" > /dev/null
bash scripts/clean.sh > /dev/null