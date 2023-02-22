Estas anotações são baseadas no curso "Spring Boot 3: aplique boas práticas e proteja uma API Rest", onde continuo meus estudos em Spring.

# Conteúdos
- Boas práticas na API
- Tratamento de erros
- Autenticação e autorização
- Tokens JWT

# Códigos HTTP
Para seguir o padrão ***REST***, um Endpoint deve retornar um código de resposta adequada ao processamento da requisição. Por exemplo, no caso da URL ```http://localhost:8080/medicos/id``` (URL de exclusão), o mais adequado seria retornar o código ```204 - Mensagem processada e sem conteúdo.```
Para padronizar e controlar as resposta dos Endpoints, é utilizado a classe ***ResponseEntity*** do Spring como retorno. Com esta classe é possível determinar o retorno do código mais adequado e adicionar informações ao cabeçalho da resposta.

> Categoria de códigos: 
> Os códigos HTTP (ou HTTPS) possuem três dígitos, sendo que o primeiro
 dígito significa a classificação dentro das possíveis cinco categorias.
> **1XX:** *Informativo* – a solicitação foi aceita ou o processo continua em andamento;
> **2XX:** *Confirmação* – a ação foi concluída ou entendida;
> **3XX:** *Redirecionamento* – indica que algo mais precisa ser feito ou precisou ser feito para completar a solicitação;
> **4XX:** *Erro do cliente* – indica que a solicitação não pode ser concluída ou contém a sintaxe incorreta;
> **5XX:** *Erro no servidor* – o servidor falhou ao concluir a solicitação.
