# Atendo em libras API

## Conectando com o banco de dados

Utilizamos no nosso projeto o banco de dados relacional PostgreSQL, junto com flyway migrations para versionamento.

Para instalar o Postgres, rode em seu terminal:

```
brew install postgresql
```

Feito isso, é necessário criar o banco de dados com o usuário postgres. Primeiro, entre no terminal do postgres usando seu usuário principal:

```
sudo -u psql <nome-de-usuario> postgres
```

Dentro do terminal do postgres, execute o comando:

```
CREATE DATABASE atendo_em_libras OWNER postgres;
```

