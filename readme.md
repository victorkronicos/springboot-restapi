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
  GET /cartao/
```

#### Consulta Saldo e Limite de um Cartão de Crédito

```http
  GET /cartao/{id}
```

| Parâmetro | Tipo  | Descrição               |
| :-------- | :---- | :---------------------- |
| `id`      | `int` | ID do Cartão de Crédito |

#### Insere um novo Cartão de Crédito

```http
  POST /cartao/
```

Enviar o seguinte contrato:

```json
{
  "nome_cartao_credito": "Nome do Tiular",
  "bandeira_cartao_credito": "Bandeira do Cartão",
  "limite_cartao_credito": 0,
  "saldo_cartao_credito": 0
}
```
