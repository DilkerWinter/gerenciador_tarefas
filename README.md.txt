
# Gerenciador de Tarefas

* Projeto feito em Java e SQL
* Criador, Organizador e listagem de Tarefas

## 💻 Pré-requisitos
### Banco de Dados
Para criar um banco de dados valido utilize estas querys em seu postgres SQL


#### Tarefas:
```
CREATE TABLE tarefas (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_criado DATE NOT NULL,
    data_finalizada DATE NOT NULL,
    concluida BOOLEAN NOT NULL DEFAULT false,
    criador_id INTEGER,
    prioridade BOOLEAN,
    responsavel_id INTEGER,
    FOREIGN KEY (criador_id) REFERENCES pessoas(id),
    FOREIGN KEY (responsavel_id) REFERENCES pessoas(id)
);
```
#### Pessoas:

```
CREATE TABLE pessoas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);
```

## Futuras Atualizações

Este projeto está sendo atualizado diariamente, com algumas metas:

- [ ] Atualizar Tela Automaticamente
- [ ] Adicionar Notificações
- [ ] Arrumar Listagem de Tarefas
- [ ] Refazer o Design das Telas
- [ ] Melhorar Interface
- [ ] Trazer mais Funcionalidades
 

## Tecnologias

<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"> <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
