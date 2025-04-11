mvn archetype:create-from-project
rm -rf ../../archetypes/quarkus-maven/*
cp -rf ./target/generated-sources/archetype/src     ../../archetypes/quarkus-maven/src
cp -rf ./target/generated-sources/archetype/pom.xml ../../archetypes/quarkus-maven/