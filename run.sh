# To be run in cygwin

mvn clean install

# eureka server
mintty --title=eureka/8761 java -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &
ping 127.0.0.1 -n 21 > nul

# contratos
mintty --title=ms-contratos/9011 java -Dserver.port=9011 -jar ms-contratos/target/ms-contratos-0.0.1-SNAPSHOT.jar &

# zuul server
mintty --title=zuul/8080 java -jar -Dserver.port=8080 zuul-server/target/zuul-server-0.0.1-SNAPSHOT.jar &

# Turbine service
mintty --title=turbine/9200 java -jar -Dserver.port=9200 hystrix-turbine/target/hystrix-turbine-0.0.1-SNAPSHOT.jar &
ping 127.0.0.1 -n 30 > nul

# Hystrix Dashboard service
mintty --title=Hystrix-Dashboard/9100 java -jar -Dserver.port=9100 hystrix-dashboard/target/hystrix-dashboard-0.0.1-SNAPSHOT.jar &
ping 127.0.0.1 -n 30 > nul

"c:\Program Files (x86)\Mozilla Firefox\firefox.exe" http://localhost:8761
"c:\Program Files (x86)\Mozilla Firefox\firefox.exe" http://localhost:9100/hystrix/monitor?stream=http://localhost:9200/turbine.stream?cluster%3DMS-CONTRATOS
"c:\Program Files (x86)\Mozilla Firefox\firefox.exe" http://localhost:9100/hystrix/monitor?stream=http://localhost:9200/turbine.stream?cluster%3DMS-USUARIOS