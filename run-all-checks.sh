#!/bin/sh
# Run gradle + all check-* scripts, aggregate result

dir=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd) || exit 1

ret=0

# 1. Run Gradle checks
echo "== Running Gradle checks =="
if ! "$dir"/gradlew clean test jacocoTestReport checkstyleMain checkstyleTest check coverage; then
    ret=1
fi

# 2. Run all check-* scripts
echo "== Running shell checks =="
for checkscript in "$dir"/check-*; do
    [ -e "$checkscript" ] || continue  # skip if none exist

    echo "-- Running $(basename "$checkscript")"
    if ! "$checkscript"; then
        echo "❌ Failed: $(basename "$checkscript")"
        ret=1
    else
        echo "✅ Passed: $(basename "$checkscript")"
    fi
done

echo "== Done =="

exit $ret