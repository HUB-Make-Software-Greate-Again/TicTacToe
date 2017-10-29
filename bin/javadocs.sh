#! /bin/bash
./gradlew javadoc
rm -rf src/main/resources/public/javadoc
mv build/docs/javadoc src/main/resources/public