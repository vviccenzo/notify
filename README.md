# Notify - Sistema de Notificações

Este projeto é uma aplicação Java 17 utilizando Spring Framework, com integração de microserviços, banco de dados NoSQL (MongoDB) e mensageria com RabbitMQ. O sistema tem como objetivo fornecer um ambiente escalável e eficiente para o envio de notificações de diferentes tipos, como SMS, e-mail e outros, através de uma arquitetura baseada em microserviços.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Boot**: Framework para desenvolvimento rápido e simplificado de microserviços.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenar informações das notificações.
- **RabbitMQ**: Sistema de mensageria que permite a comunicação assíncrona entre os microserviços.

## Funcionalidades

A aplicação é composta por diversos microserviços que se comunicam de forma assíncrona para realizar o envio de notificações. A principal funcionalidade é a gestão de notificações que são recebidas por um microserviço central, que as encaminha para outros serviços responsáveis por enviar notificações por diferentes canais (SMS, E-mail, etc.).

### Fluxo de Notificação:

1. **Microserviço de Recepção**: Recebe uma notificação que pode ser de diferentes tipos e a encaminha para os respectivos microserviços responsáveis pelo envio.
   
2. **Microserviço de Envio de SMS**: Responsável por processar as notificações do tipo SMS e enviá-las para os usuários.
   
3. **Microserviço de Envio de E-mail**: Responsável por processar as notificações do tipo E-mail e enviá-las para os usuários.
   
4. **Microserviço de Outros Tipos de Notificação**: Pode ser expandido para incluir outros tipos de notificação, como push, WhatsApp, etc.

### Comunicação Assíncrona com RabbitMQ:
A comunicação entre os microserviços é feita de forma assíncrona utilizando o RabbitMQ, garantindo escalabilidade e desacoplamento entre os serviços.

### Banco de Dados:

- **MongoDB**: Utilizado para armazenar as informações das notificações, como status, tipo, e dados do usuário.
- **H2 Database**: Banco de dados relacional, utilizado para testes durante o desenvolvimento, garantindo flexibilidade no gerenciamento dos dados temporários.

## Arquitetura

- A arquitetura segue o padrão de microserviços, onde cada funcionalidade está encapsulada em seu próprio serviço, permitindo a escalabilidade e manutenção independentes.
- RabbitMQ garante a comunicação eficiente e não bloqueante entre os microserviços.
- MongoDB proporciona flexibilidade para armazenamento de dados não estruturados e de alta performance.
