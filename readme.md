# Spring Boot REST API

Desafio de desenvolvimento de uma API REST para gestão de cartões de crédito utilizando o framework Spring Boot.

## Entidades

- Cartão de Crédito
- Fatura
- Item Fatura

## Documentação

- Cartão de Crédito

#### Retorna todos os Cartões de Crédito armazenados

```http
  GET /cartao
```

#### Consulta Saldo e Limite de um Cartão de Crédito

```http
  GET /cartao/{id}
```

| Parâmetro | Tipo  | Descrição               |
| :-------- | :---- | :---------------------- |
| `id`      | `int` | ID do Cartão de Crédito |
