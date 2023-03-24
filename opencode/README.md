# OpenCode
Uma API para acessar portfólios públicos ou pessoais.

##Endpoints 
- Login
    - [Cadastro-usuario](#cadastro-usuario)
    - [Login](#realização-do-login)
- Código
    - [adicionar-codigo](#adicionar-codigo)
    - [excluir-codigo](#excluir-codigo)
    - [acessar-codigo](#acessar-codigo)
    - [acesarTodos-codigo](#acessarTodos-codigo)
    - [editar-codigo](#editar-codigo)
- Portfolios
    - [publicar-portfolio](#publicar-portfolio)
    - [editar-portfolio](#editar-portfolio)
    - [excluir-portfolio](#excluir-portfolio)
    - [acessar-portfolio](#acessar-portfolio)

### Cadastrar Usuario

`POST` /OpenCode/api/cadastro-usuario

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|email | texto | sim | email do usuario 
|senha | texto | sim | senha do usuario 
*Exemplo de requisição*
```json
{
    "email": "exemplo@gmail.com",
    "senha": "exemplosenha123",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | o usuario foi cadastrado com sucesso 
|404 | erro ao cadastrar usuario

### Realização do Login
`GET` OpenCode/api/login/{id}

*Exemplo de resposta*

```json
{
    "email": "exemplo@gmail.com",
    "senha": "exemplosenha123",
}
```
*Resposta* 

|codigo | descricao
|-------|----------
|200 | o login foi confirmado 
|404 | nao foi encontrado usuario com esse ID

### Adicionar Codigo

`POST` /OpenCode/api/adicionar-codigo

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-usuario | numero | sim | identificação do usuario
|codigo | texto | sim | codigo feito pelo usuario 


*Exemplo de requisição*
```json
{
    "id-usuario ": 001,
    "codigo": "arquivo_codigo.py",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | o codigo foi adicionado ao portfolio com sucesso 
|404 | erro ao salvar o codigo no portfolio


### Excluir Codigo

`DELETE` /OpenCode/api/excluir-codigo

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-usuario | numero | sim | identificação do usuario
|senha-usuario | texto | sim | senha do usuario 
|id-codigo | numero | sim | codigo do usuario 

*Exemplo de requisição*
```json
{
    "id-usuario": 001,
    "senha-usuario": "senhaexemplo123",
    "id-codigo": 010,
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | o codigo foi excluido do portfolio com sucesso 
|400 | erro ao excluir o codigo do portfolio


### Acessar Codigo

`GET` /OpenCode/api/acessar-codigo

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-usuario | numero | sim | identificação do usuario
|id-codigo | numero | sim | codigo do usuario 

*Exemplo de requisição*
```json
{
    "id-usuario": 001,
    "id-codigo": 010,
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | o acesso ao codigo foi autorizado
|400 | erro ao acessar o codigo do portfolio



### Editar Codigo

`POST` /OpenCode/api/editar-codigo

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-portfolio | numero | sim | identificação do portfolio aonde o codigo esta sendo salvo
|titulo-codigo | texto | sim | titulo dado pelo usuario 

*Exemplo de requisição*
```json
{
    "id-portfolio": 4000,
    "titulo-codigo": "codigo01",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | edicao do codigo autorizada
|400 | erro ao editar o codigo



### Publicar Portfolio 

`POST` /OpenCode/api/publicar-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
| id-usuario | numero | sim | identificacao do usuario
|nome-usuario | texto | sim | nome do usuario
|id-portfolio | numero | sim | identificacao do portfolio
|nome-portfolio | texto | sim | nome do portfolio

*Exemplo de requisição*
```json
{
    "id-usuario": 001,
    "nome-usuario": "user201",
    "id-portfolio": 4008,
    "nome-portfolio": "projeto.java",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | portfolio publicado com sucesso
|400 | erro ao publicar o portfolio

### Editar Portfólio
`POST` /OpenCode/api/editar-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-portfolio | numero | sim | identificacao do portfolio
|nome-portfolio | texto | sim | nome do portfolio

*Exemplo de requisição*
```json
{
    "id-portfolio": 4008,
    "nome-portfolio": "projeto.java",
}
```
*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | edição do portfólio autorizado
|400 | erro ao editar o portfolio


### Deletar Portfólio
`DELETE` /OpenCode/api/excluir-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-portfolio | numero | sim | identificacao do portfolio
|nome-portfolio | texto | sim | nome do portfolio
|senha-usuario | texto | sim | senha do usuário

*Exemplo de requisição*
```json
{
    "id-portfolio": 4008,
    "nome-portfolio": "projeto.java",
    "senha-usuario": "senhaexemplo123"
}
```
*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | o portfólio foi excluido com sucesso
|400 | erro ao excluir o portfólio


### Acessar Portfólio
`GET` /OpenCode/api/acessar-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
|id-usuario | numero | sim | identificação do usuario
|id-portfolio | numero | sim | identificacao do portfolio

*Exemplo de requisição*
```json
{
    "id-usuario": 001,
    "id-portfolio": 4008,
}
```
*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | o acesso ao portfólio foi autorizado
|400 | erro ao acessar portfólio

