# Backend-ArquiteturaServeless
 Sistema de pedidos através de catálogos do fornecedor(lojista) - como por exemplo **totens de autoatendimento do McDonald’s** que o cliente pede o pedido direto da interface digital, sem interação humana.

## Contexto (BusinessRules)
O sistema permite que lojistas publiquem seus **catálogos de produtos** e que esses dados sejam processados de forma **assíncrona, escalável e desacoplada**, diante da **arquitetura serverless orientada a eventos**, implementada em Java.

A inserção e o processamento dos catálogos ocorre na **mensageria**, que preserva a  alta disponibilidade e tolerância a falhas.
 
- arquitetura-serveless - AWS SQS - AWS Lambda  - AWS3(bucket)
- DB -> MongoDB(NoSQL)
## ``` Diagrama de Fluxo | Event-Driven Architecture Diagram  ```
<img width="1536" height="1024" alt="ae6538b6-a108-47ab-8902-f24a256d2f29" src="https://github.com/user-attachments/assets/5e6b75a6-9a81-4327-831c-47ae05c71394" />

