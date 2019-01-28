# reactive-spring

Neste repositório é disponibilizado uma prova de conceito de uma arquitetura reativa contemplando os requisitos do Manifesto Reativo https://www.reactivemanifesto.org/pt-BR.

Para uma prova de conceito foi proposto um cenário tendo um cartório digital que certifica a assinatura de documentos digitalmente. Esse processo é iniciado através de um cadastramento de contrato, contendo descrição, um arquivo binário, no formato texto ou PDF, CPF, nome, e e-mail do responsável, juntamente com uma lista de signatários, nome, e-mail e CPF. Após o cadastramento do contrato as partes envolvidas são notificadas através de e-mail e podem realizar assinatura através de um portal.

O foco de prova de conceito foi aplicar uma arquitetura responsiva, resiliente, elástica e orientada por mensagens, isto é, contemplando os requisitos definidos no Manifesto Reativo utilizando o Spring Framework 5 como plataforma.

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

A execução pode ser realidada através do script run.sh, a ser executado através do Git Bash em ambiente Windows 

## Soluções de código aberto utilizadas:

•	Jenkins - Responsável por disponibilizar realizar a compilação e disponibilizar para execução os serviços, bem como escalá-los ou desativá-los conforme a demanda.

•	RabbitMQ - Servidor de mensageria utilizado pelos microserviços.

•	MongoDB – Banco de dados, foi criada uma instância Docker, com uma coleção para cada microserviço

## Front End

• O front-end foi desenvolvido em Angular 4 que está consumindo os endpoints em REST

##### instruções para subir o servidor Angular CLI
- npm install
- ng serve
