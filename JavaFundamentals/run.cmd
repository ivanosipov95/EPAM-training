@echo off
cd src\main
javac -sourcepath ./java java/javase01/t01/main/Main.java -d ../../target/classes
cd ..\..\
java -cp ./target/classes javase01/t01/main/Main
