#!/bin/bash

ARG="${1:-scenario.txt}"

bash scripts/compile.sh
bash scripts/run.sh "$ARG"
bash scripts/clean.sh