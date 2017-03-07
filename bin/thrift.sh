rm -rf ../src/main/java/supersql/
rm -rf ../gen-java/
thrift --gen java resource/jdbc.thrift
cp -r gen-java/com/tencent/supersql/ src/main/java/com/tencent/supersql/
