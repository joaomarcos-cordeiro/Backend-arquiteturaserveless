# Backend-arquitetura-serveless
 Sistema de pedidos através de catálogos do fornecedor(lojista) - como por exemplo **totens de autoatendimento do McDonald’s** que o cliente pede o pedido direto da interface digital, sem interação humana.

## ``` Contexto (BusinessRules) ```
◦ O sistema facilita que lojistas publiquem seus **catálogos de produtos** e que esses dados sejam processados de forma **assíncrona, escalável e desacoplada**, diante da **arquitetura serverless orientada a eventos**, implementada em Java.

◦ A inserção e o processamento dos catálogos ocorre na **mensageria**, que preserva a  alta disponibilidade e tolerância a falhas.

## ``` ~~~ English -> ```
System based on supplier (merchant) product catalogs, **such as McDonald’s self-service kiosks**, where customers place orders directly through a digital interface without human interaction.

## ``` Context (BusinessRules) ```

◦ The system enables merchants to publish their **product catalogs**, which are processed in an **asynchronous, scalable, and decoupled manner**, using an event-driven serverless architecture, implemented in Java.

◦ The insertion and processing of catalogs are handled through a **messaging layer**, ensuring high availability and fault tolerance.
 
- arquitetura-serveless - AWS SQS - AWS Lambda  - AWS3(bucket)
- DB -> MongoDB(NoSQL)
## ``` Diagrama de Fluxo | Event-Driven Architecture Diagram  ```
<img width="1536" height="1024" alt="ae6538b6-a108-47ab-8902-f24a256d2f29" src="https://github.com/user-attachments/assets/5e6b75a6-9a81-4327-831c-47ae05c71394" />


- Stack Tecnológica

◦ **AWS S3** – Armazenamento dos catálogos dos fornecedores 

◦ **AWS SQS** – Fila de mensageria para eventos de catálogo

◦ **AWS Lambda** – Processa os eventos e regras de negócio

◦ **MongoDB (NoSQL)** – Persistência de dados de produtos e categorias

◦ **API REST** – Exposição de endpoints para criação e atualização de dados

## ``` Fluxo ```

1. O fornecedor envia seu catálogo para um **bucket S3**
2. Um evento é publicado em uma **fila SQS**
3. **AWS Lambda** consomem a mensagem e processam os dados
4. Informações são normalizadas no **MongoDB**
5. **API RESTful** disponibiliza os dados para consumo por aplicações clientes

## ``` ~~~ English -> ```
- Technology Stack

◦ **AWS S3** – Storage for supplier catalogs  

◦ **AWS SQS** – Message queue for catalog-related events  

◦ **AWS Lambda** – Event processing and business rule execution  

◦ **MongoDB (NoSQL)** – Persistence layer for products and categories  

◦ **REST API** – Exposure of endpoints for data creation and updates  

## ``` Event Flow ```

1. The supplier uploads its catalog to an **S3 bucket**  
2. An event is published to an **SQS queue**  
3. **AWS Lambda** functions consume the message and process the data  
4. Data is normalized and persisted in **MongoDB**  
5. A **RESTful API** exposes the data for consumption by client applications 



