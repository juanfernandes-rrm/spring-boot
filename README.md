# spring-boot
Neste curso, após meus estudos sobre Spring Data, dou continuidade e avanços os estudos com o Spring Boot, me aprofundando no Ecossistema Spring. Após a conclusão deste curso, pretendo iniciar um projeto para aplicar meus conhecimentos adiquiridos, afim de consolidá-los.

## Anotações
Neste readme, procurei abordar os conceitos visto durante o curso, entretanto não me aprofundo tanto. No notion procuro me aprofundar mais no conceitos, utilizando código, esquemas, imagens, problemas que enfrentei e soluções para os mesmos, e mais conteúdo para complementar o estudo. Se você tem interesse nesses detalhes, pode acessar [aqui](https://repeated-cobbler-d1a.notion.site/Spring-boot-1c3e8bd11a144d2794ca5e5384a801cd).

 ## Conteúdos abordados no curso
 - API Rest em Java com Spring Boot
 - Desenvolvimento de CRUDs utilizando o banco de dados MySQL
 - Flyway como ferramenta de Migrations da API
 - Validações utilizando o Bean Validation
 - Paginação dos dados da API
 
 ## Tecnologias
- Spring Boot 3
- Java 17
- Lombok
- MySQL / Flyway
- JPA / HIbernate
- Maven
- Insomnia / Postman

## Projeto a ser desenvolvido
Projeto de uma clinica médica chamada Voll Med, para controlar o cadastro de médicos e pacientes, e de agendamento de consultas.
Documentação das funcionalidades está disponível no Trello (disponibilizado pelo curso), com cards descrevendo as funcionalidades, regras de negócio e validações necessárias.

## Spring e Spring Boot
Spring e Spring Boot não são a mesma coisa. Spring é ***framework modular***, isto é, oferece vários módulos com seus respectivos objetivos. Desta forma, um projeto pode utilizar somente os módulos necessários, evitando que o framework seja pesado.
Entretanto, a configuração destes módulos é trabalhosa, extensa e de difícil manutenção. Neste sentindo, surge o Spring Boot, um módulo que visa facilitar a criação de projetos Spring e configurações dos módulos.

## Controller REST
Para mapear um controller e uma requisição, é utilizado o ***Spring MVC***, que fornece algumas anotações:
- ***@RestController***: Declara a classe como um controller REST.
- ***@RequestMapping***: Define o caminho da requisição.
- ***@GetMapping***: Mapeia requisições GET.
- ***@PostMapping***: Mapeia requisições POST.
- ***@PutMapping***: Mapeia requisições PUT.
- ***@DeleteMapping***: Mapeia requisições DELETE.
- ***@RequestBody***: Define que os dados de uma requisição estão no body.
- ***@PathVariable***: Define que os dados de uma requisição estão na URL (Parâmetro Dinâmico). 
- ***@Transactional***: Garante que todo o processo seja concluído, antes de realizar o commit. (princípio da atomicidade).

## Envio de dados para a API
Os dados são enviados para API através de uma requisição HTTP. Então é preciso definir o método e a URL da API, além dos dados que serão enviados. No caso abaixo, os dados estão sendo enviados no corpo da requisição no formato JSON( (JavaScript Object Notation).

`POST:http://localhost:8080/medicos`

```
{
"nome": "Carla Azevedo",
"email": "carla.azevedo@voll.med",
"telefone": "5588887777",
"crm": "547852",
"especialidade": "CARDIOLOGIA",
"endereco": {
    "logradouro": "rua 1",
    "bairro": "bairro",
    "cep": "12345678",
    "cidade": "Brasilia",
    "uf": "DF",
    "numero": "1",
    "complemento": "complemento"
    }
}
```

## Receber dados na API
Os dados são recebidos pelo [controller](https://github.com/FernandesPixel/spring-boot/tree/main/src/main/java/med/voll/api/controller), devidamente mapeado. Estes dados, são passados para um ***DTO (Data Transfer Object)***, que é um padrão utilizado para receber e enviar dados. Esse padrão sera utilizado em todas as entradas e saídas de dados da aplicação.

## Adicionar dependências no projeto
As dependências são adicionadas no arquivo [pom.xml](https://github.com/FernandesPixel/spring-boot/blob/main/pom.xml). Para adicionar as dependências corretamente, é recomendado utilizar o [spring initializr](https://start.spring.io/) para encontrar as dependências.
### Adicionando Spring Data
Após adicionar a dependência do ***Spring Data*** no projeto, é necessário adicionar as configurações do Banco de dados, estas configurações são feitas no arquivo [***application.yml.***](https://github.com/FernandesPixel/spring-boot/blob/main/src/main/resources/application.yml) 

Neste curso é utilizado o Spring Data. Entretanto, este conteúdo não será abordado nessa anotações, existem outras anotações feitas por mim [aqui](https://github.com/FernandesPixel/spring-data).

## Migrations com Flyway
Um Banco de Dados evolue conforme a aplicação cresce. Por isso, é interessante ter um  controle sobre as mudanças feitas no Banco. As ferramentas que fazem esse controle são chamadas de ***Ferramentas de Migrações (Migrations).*** Uma dessa ferramentas é o ***Flyway***, que tem suporte do Spring.

As mudanças são registradas através de arquivos ***.sql***, sendo que cada um deste representa uma versão do Banco de Dados. No projeto, estes arquivos devem ser armazenados na pasta ***resources>db>migration***.

Para o Flyway reconhecer estes arquivos, é necessário que eles tenham um padrão de nomenclatura: ***V[identificador]__[descricao-do-script]***.

Ex.: [V1__create-table-medicos](https://github.com/FernandesPixel/spring-boot/blob/main/src/main/resources/db/migration/V1__create-table-medicos.sql)

Migrations executadas, não podem ser modificadas. Pois ela já foi executada no Banco de Dados. Se uma modificação for necessária, deve ser criado uma nova Migration.

## Validação com Bean Validation
O Bean Validation é utilizado para facilitar a validação, isto é feito através de algumas anotações, como por exemplo:
- ***@Valid***: Validar objeto.
- ***@NotNull***: Validar nulos.
- ***@NotBlank***: Validar nulos e brancos.
- ***@Pattern***: Validar um padrão regex.

## Paginação
Limita a quantidade de registros devolvidos em uma resposta.

O Spring Data já oferece um objeto que abstrai a lógica de paginação, através da interface ***Pageable***. Ao passar esse objeto para o método ***findAll()***, é retornado um objeto ***Page***, que contém os dados do Genérico passado e informações sobre a paginação.

Com a paginação implementada, o cliente da API consegue determinar a quantidade de registros, qual página e outros atributos do objeto Page, customizando a resposta da requisição.

`GET:http://localhost:8080/pacientes?size=1&page=0`

A Ordenação funciona da mesma maneira, passando um parâmetro na URL e definindo por qual atributo deve ser ordenado. Para definir um padrão, é utilizado a anotação ***@PageableDefault*** passando parâmetros para os atributos do objeto Page.

## Boas práticas
Um Endpoint, para seguir o padrão REST, deve retornar um código de resposta adequado ao processamento da requisição. Por exemplo, no caso da URL `DEL:http://localhost:8080/medicos/id`, o mais adequado seria retornar o código 204 - Mensagem processada e sem conteúdo.
Para padronizar e controlar as resposta dos Endpoints, é utilizado a classe ***ResponseEntity*** do Spring como retorno.

Assim como, o código para um cadastro é 201 - Created, devolvendo no corpo da resposta o dados do recurso/registro cadastrado, e também um cabeçalho do protocolo HTTP (Location).
