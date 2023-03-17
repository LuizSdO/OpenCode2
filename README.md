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
    email: "exemplo@gmail.com",
    senha: "exemplosenha123",
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
    email: "exemplo@gmail.com",
    senha: "exemplosenha123",
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
    id-usuario : 001,
    codigo: "arquivo_codigo.py",
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
    id-usuario : 001,
    senha-usuario: "senhaexemplo123",
    id-codigo: 010,
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
    id-usuario : 001,
    id-codigo: 010,
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
    id-portfolio : 4000,
    titulo-codigo: "codigo01",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | edicao do codigo autorizada
|400 | erro ao editar o codigo


### Selecionar Linguagem

`GET` /OpenCode/api/selecionar-linguagem

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
| nome-linguagem | texto | sim | a linguagem escolhida pelo usuario

*Exemplo de requisição*
```json
{
    nome-linguagem : "java",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|200 | linguagem selecionada com sucesso
|400 | erro ao escolher linguagem


### Salvar Alterações 

`POST` /OpenCode/api/salvar-alteracoes

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
| id-codigo | numero | sim | identificacao do codigo
|nome-codigo | texto | sim | nome do codigo
|id-portfolio | numero | sim | identificacao do portfolio

*Exemplo de requisição*
```json
{
    id-codigo: 1002,
    nome-codigo: "codigoexemplo",
    id-portfolio: 4008,
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | alteracoes salvas no portfolio com sucesso
|400 | erro ao salvar alteracoes


### Publicar Portfolio 

`POST` /OpenCode/api/publicar-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
| id-usuario | numero | sim | identificacao do usuario
|nome-usuario | texto | sim | nome do usuario
|id-portfolio | numero | sim | identificacao do portfolio
|nome-portfolio | texto | sim | nome do portfolio
|senha-usuario | texto | sim | senha do usuario

*Exemplo de requisição*
```json
{
    id-usuario: 001,
    nome-usuario: "user201",
    id-portfolio: 4008,
    nome-portfolio: "projeto.java",
    senha-usuario: "senhauser201",
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | portfolio publicado com sucesso
|400 | erro ao publicar o portfolio


### Clonar Portfolio 

`GET` /OpenCode/api/clonar-portfolio

*Campos de requisição*

| campo | tipo | obrigatorio | descricao
|-------|-------|:------------:|----------|
| id-usuario | numero | sim | identificacao do usuario
|id-portfolio | numero | sim | identificacao do portfolio

*Exemplo de requisição*
```json
{
    id-usuario: 001,
    id-portfolio: 4008,
}
```

*Campos da resposta*
|codigo | descricao
|-------|----------
|201 | o portfolio foi adicionado a sua biblioteca com sucesso 
|400 | erro ao clonar o portfolio
