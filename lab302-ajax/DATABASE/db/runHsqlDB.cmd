:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: port check >>> netstat -ano | findstr 9001
::: port 변경 시 hsqlmanager.cmd, jdbc.properties 도 localhost:port 형태로 변경해야 함
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
..\..\..\..\bin\jdk8u402-b06\bin\java.exe -Dfile.encoding=UTF-8 -cp ./hsqldb-2.3.2.jar org.hsqldb.Server -database.0 sampledb -dbname.0 sampledb