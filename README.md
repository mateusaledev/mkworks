# MKWorks API

Bem-vindo à documentação da API MKWorks! Esta API é destinada ao gerenciamento de clientes e ordens de serviço.

## Tabela de Conteúdos

- [1. ClienteController](#1-clientecontroller)
    - [1.1 Listar Clientes](#11-listar-clientes)
    - [1.2 Buscar Cliente por ID](#12-buscar-cliente-por-id)
    - [1.3 Adicionar Cliente](#13-adicionar-cliente)
    - [1.4 Atualizar Cliente por ID](#14-atualizar-cliente-por-id)
    - [1.5 Remover Cliente por ID](#15-remover-cliente-por-id)

- [2. ComentarioController](#2-comentariocontroller)
    - [2.1 Listar Comentários de uma Ordem de Serviço](#21-listar-comentários-de-uma-ordem-de-serviço)
    - [2.2 Adicionar Comentário a uma Ordem de Serviço](#22-adicionar-comentário-a-uma-ordem-de-serviço)

- [3. OrdemServicoController](#3-ordemservicocontroller)
    - [3.1 Criar Ordem de Serviço](#31-criar-ordem-de-serviço)
    - [3.2 Listar Ordens de Serviço](#32-listar-ordens-de-serviço)
    - [3.3 Buscar Ordem de Serviço por ID](#33-buscar-ordem-de-serviço-por-id)
    - [3.4 Finalizar Ordem de Serviço](#34-finalizar-ordem-de-serviço)

## 1. ClienteController

### 1.1 Listar Clientes

Retorna a lista de todos os clientes cadastrados.

#### Exemplo de Uso:

```http
GET /clientes
```

### 1.2 Buscar Cliente por ID

Retorna os detalhes de um cliente específico com base no ID fornecido.

#### Exemplo de Uso:

```http
GET /clientes/1
```

### 1.3 Adicionar Cliente

Adiciona um novo cliente.

#### Exemplo de Uso:

```http
POST /clientes
Content-Type: application/json

{
  "nome": "Nome do Cliente",
  "email": "cliente@email.com",
  "telefone": "123456789"
}
```

### 1.4 Atualizar Cliente por ID

Atualiza os dados de um cliente específico com base no ID fornecido.

#### Exemplo de Uso:

```http
PUT /clientes/1
Content-Type: application/json

{
  "nome": "Novo Nome do Cliente",
  "email": "novocliente@email.com",
  "telefone": "987654321"
}
```

### 1.5 Remover Cliente por ID

Remove um cliente com base no ID fornecido.

#### Exemplo de Uso:

```http
DELETE /clientes/1
```

## 2. ComentarioController

### 2.1 Listar Comentários de uma Ordem de Serviço

Retorna a lista de comentários de uma ordem de serviço específica.

#### Exemplo de Uso:

```http
GET /ordens-servico/1/comentarios
```

### 2.2 Adicionar Comentário a uma Ordem de Serviço

Adiciona um novo comentário a uma ordem de serviço.

#### Exemplo de Uso:

```http
POST /ordens-servico/1/comentarios
Content-Type: application/json

{
  "descricao": "Novo comentário na ordem de serviço"
}
```

## 3. OrdemServicoController

### 3.1 Criar Ordem de Serviço

Cria uma nova ordem de serviço.

#### Exemplo de Uso:

```http
POST /ordens-servico
Content-Type: application/json

{
  "clienteId": 1,
  "descricao": "Descrição da ordem de serviço",
  "preco": 100.00
}
```

### 3.2 Listar Ordens de Serviço

Retorna a lista de todas as ordens de serviço cadastradas.

#### Exemplo de Uso:

```http
GET /ordens-servico
```

### 3.3 Buscar Ordem de Serviço por ID

Retorna os detalhes de uma ordem de serviço específica com base no ID fornecido.

#### Exemplo de Uso:

```http
GET /ordens-servico/1
```

### 3.4 Finalizar Ordem de Serviço

Finaliza uma ordem de serviço com base no ID fornecido.

#### Exemplo de Uso:

```http
PUT /ordens-servico/1/finalizacao
```

---