rm -rf ../src/main/java/supersql/
rm -rf ../gen-java/
thrift --gen java resource/jdbc.thrift
rm -rf src/main/java/com/tencent/supersql/gen
cp -r gen-java/com/tencent/supersql/gen src/main/java/com/tencent/supersql/
