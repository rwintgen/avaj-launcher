#!/bin/bash

echo "Cleaning up compiled class files..."
find . -name '*.class' -delete
rm sources.txt 2>/dev/null
echo "Cleanup finished."