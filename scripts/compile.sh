#!/bin/bash

echo "Compiling Java source files..."
find * -name "*.java" > sources.txt
javac @sources.txt
echo "Compilation finished."