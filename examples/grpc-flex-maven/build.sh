mvn archetype:create-from-project
rm -rf ../../archetypes/helidon-flex-maven/*
cp -rf ./target/generated-sources/archetype/src     ../../archetypes/helidon-flex-maven/src
cp -rf ./target/generated-sources/archetype/pom.xml ../../archetypes/helidon-flex-maven/