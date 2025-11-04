#!/bin/bash

ARG="${1:-scenario.txt}"

echo "Running simulation..."
java -cp src io.github.rwintgen.avaj_launcher.Main $1
echo "Simulation done."