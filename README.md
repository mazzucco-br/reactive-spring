# reative-spring

https://github.com/armdev/reactive-spring-cloud/tree/master/google

## Os seguintes projetos foram criados

•	eureka-server - Registrador de serviços, ou seja, toda nova instância se registra no Eureka, que monitora o status da aplicação e disponibiliza para consulta quais instâncias estão disponíveis.

•	zuul-server - API gateway que disponibiliza os serviços e faz roteamento dinâmico utilizando o eureka-server.

•	hystrix-tubine – Agregador que monitora todas as instâncias de serviços registrados no eureka-server e disponibiliza os dados agrupados por serviço.

•	hystrix-dashbord - Interface de monitoramento onde se pode acompanhar em tempo real os serviços em execução, este apresenta as informações geradas pelo hystrix-tubine. O dashboard apresenta muitas informações úteis tais como, volume de tráfego, porcentagem de sucesso e falha, latência mínima, média e máxima, estado do circuit breaker, dentre outras.

•	ms-contratos - Microserviço para cadastramento de contratos, após receber um contrato é retornado um ID como resposta, os demais processos são feitos assincronamente, que são; validação e notificação de signatários.

•	ms-assinaturas - Microserviço que valida e regista assinaturas.

•	ms-usuarios - Microserviço para criação, atualização e listagem de usuários.

•	ms-notificacoes - Aplicação responsável por notificar os signatários, este é uma aplicação consumidora registrada no RabbitMQ

•	Portal - Página WEB simples, onde é possível a listagem dos últimos contratos e assinaturas através utilizando WebSockets.

## Soluções de código aberto utilizadas:

•	Jenkins - Responsável por disponibilizar realizar a compilação e disponibilizar para execução os serviços, bem como escalá-los ou desativá-los conforme a demanda.

•	RabbitMQ - Servidor de mensageria utilizado pelos microserviços.

•	MongoDB – Banco de dados, foi criada uma instância Docker, com uma coleção para cada microserviço

## Front End

•O front-end foi desenvolvido em Angular 4 que está consumindo os endpoints em REST

##### instruções para subir o servidor Angular CLI
- npm install
- ng serve
