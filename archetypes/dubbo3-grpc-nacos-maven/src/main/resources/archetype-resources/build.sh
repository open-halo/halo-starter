mvn archetype:create-from-project
rm -rf ../../archetypes/dubbo3-grpc-nacos-maven/*
cp -rf ./target/generated-sources/archetype/src     ../../archetypes/dubbo3-grpc-nacos-maven/src
cp -rf ./target/generated-sources/archetype/pom.xml ../../archetypes/dubbo3-grpc-nacos-maven/