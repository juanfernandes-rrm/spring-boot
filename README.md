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
- Insomnia

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
- ***@GetMapping***: Mapeia o método GET.
- ***@PostMapping***: Mapeia o método POST.
- ***@RequestBody***: Define que os dados de uma requisição estão no body.

# Envio de dados para a API
Os dados são enviados para API através de uma requisição HTTP. Então é preciso definir o método e a URL da API, além dos dados que serão enviados. No caso abaixo, os dados estão sendo enviados no corpo da requisição no formato JSON( (JavaScript Object Notation).

<img src="https://www.notion.so/signed/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F56cb10e8-fcb7-4ac6-8ed9-4047016b4e84%2FUntitled.png?id=45c32c89-1cab-4387-bb68-400da752e168&table=block&spaceId=c201bf83-8b0f-4f26-aff6-11cb5d30850e&name=Untitled.png&userId=4b9f37e7-280d-4f3d-bb98-bcfe01bcc215&cache=v2" alt="Requisição de cadastro de médico"/>

# Receber dados na API
Os dados são recebidos pelo controller, devidamente mapeado. Estes dados, são passados para um ***DTO (Data Transfer Object)***, que é um padrão utilizado para receber e enviar dados. Esse padrão sera utilizado em todas as entradas e saídas de dados da aplicação.
