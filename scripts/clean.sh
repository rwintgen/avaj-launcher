#!/bin/bash

echo "Cleaning up compiled class files..."
find . -name '*.class' -delete
rm sources.txt
echo "Cleanup finished."