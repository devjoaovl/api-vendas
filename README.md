# Sistema de Vendas - API

Este projeto é uma API para gerenciamento de vendedores e vendas.  
Foi desenvolvido em **Java 17 **, utilizando **Spring Boot**, **Spring Data JPA** e **H2 Database**.

🛠 Tecnologias utilizadas

Java 22

Spring Boot

Spring Data JPA

H2 Database (pode ser substituído por MySQL/PostgreSQL)

Maven

-------------------------------------------------------------------------------------------

## 📌 Endpoints principais
👤 Vendedores
Cadastrar um vendedor

POST /vendedores

Request body:
```

{
  "nome": "João"
}
```


Response:
```
{
  "id": 1,
  "nome": "João"
}
```

## 💰 Vendas
Criar uma nova venda

POST /vendas

Request body:
```

{
  "valorVenda": 10500,
  "dataVenda": "2025-01-30",
  "idVendedor": 1
}
```


Response:
```

{
  "id": 1,
  "dataVenda": "2025-01-30",
  "valorVenda": 10500.0,
  "vendedor": {
    "id": 1,
    "nome": "João"
  }
}
```

## 📈 Relatório de Vendas
Consultar quantidade de vendas e sua média diária por período

GET /vendas/relatorio?inicio=2025-01-25&fim=2025-12-01

Response:
```

{
  "vendedorNome": "João",
  "totalVendas": 1,
  "mediaDiaria": 33.76
}
```
