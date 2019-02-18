java -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &
sleep 25
java -jar ms-contratos/target/ms-contratos-0.0.1-SNAPSHOT.jar &
java -jar ms-assinaturas/target/ms-assinaturas-0.0.1-SNAPSHOT.jar &
java -jar ms-usuarios/target/ms-usuarios-0.0.1-SNAPSHOT.jar &
java -jar ms-notificacoes/target/ms-notificacoes-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=80 zuul-server/target/zuul-server-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=9200 hystrix-turbine/target/hystrix-turbine-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=9100 hystrix-dashboard/target/hystrix-dashboard-0.0.1-SNAPSHOT.jar