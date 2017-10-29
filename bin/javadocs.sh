#! /bin/bash
./gradlew javadoc
rm -rf build/resources/main/public/javadoc/
mv build/docs/javadoc build/resources/main/public/