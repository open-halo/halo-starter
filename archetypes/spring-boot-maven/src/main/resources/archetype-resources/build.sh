mvn archetype:create-from-project
rm -rf ../../archetypes/spring-boot-maven/*
cp -rf ./target/generated-sources/archetype/src     ../../archetypes/spring-boot-maven/src
cp -rf ./target/generated-sources/archetype/pom.xml ../../archetypes/spring-boot-maven/