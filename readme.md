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

#### Insere um novo Cartão de Crédito

```http
  POST /cartao/
```

Enviar o seguinte contrato no corpo da requisição:

```json
{
  "nome_cartao_credito": "Nome do Tiular",
  "bandeira_cartao_credito": "Bandeira do Cartão",
  "limite_cartao_credito": 0,
  "saldo_cartao_credito": 0
}
```

#### Consulta Saldo e Limite de um Cartão de Crédito

```http
  GET /cartao/{id}
```

#### Consulta todos os Cartões de Crédito armazenados.

```http
  GET /cartao/
```

---

#### Cria uma nova Fatura

```http
  POST /fatura/
```

Enviar o seguinte contrato no corpo da requisição:

```json
{
  "data_vencimento": "dd/MM/yyyy"
}
```

#### Consulta uma Fatura

```http
  POST /fatura/{id}
```

---

#### Cria um novo Item Fatura

```http
  POST /item-fatura/
```

Enviar o seguinte contrato no corpo da requisição:

```json
{
  "descricao_item_fatura": "Descrição da compra",
  "valor_item_fatura": 100,
  "fatura": {
    "id_fatura": 1
  },
  "cartao_credito": {
    "id_cartao_credito": 1
  }
}
```
