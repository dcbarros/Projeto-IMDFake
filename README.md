# IMDFake - Plataforma de Filmes Fictícia

## Estrutura do Projeto
```
_src
 |__controller
 |  |__AtorController.java
 |  |__DiretorController.java
 |  |__FilmeController.java
 |__models
 |  |__Artista.java
 |  |__Ator.java
 |  |__Diretor.java
 |  |__Filme.java
 |__repository
 |  |__AtorRepository.java
 |  |__DiretorRepository.java
 |  |__FilmeRepository.java
 |__services
 |  |__AtorService.java
 |  |__DiretorService.java
 |  |__FilmeService.java
 |__view
 |  |__Console.java
 |__App.java
 ```
## Descrição
Este repositório contém a implementação de uma plataforma fictícia de filmes chamada "IMDFake". A estrutura do projeto está organizada em pacotes representando diferentes partes da aplicação:

### Controller

- AtorController.java: Controlador para operações relacionadas a atores.
- DiretorController.java: Controlador para operações relacionadas a diretores.
- FilmeController.java: Controlador para operações relacionadas a filmes.
  
### Models
- Artista.java: Classe abstrata representando um artista (ator ou diretor).
- Ator.java: Classe representando um ator.
- Diretor.java: Classe representando um diretor.
- Filme.java: Classe representando um filme.
### Repository
- AtorRepository.java: Repositório para operações relacionadas a atores.
- DiretorRepository.java: Repositório para operações relacionadas a diretores.
- FilmeRepository.java: Repositório para operações relacionadas a filmes.
### Services
- AtorService.java: Serviço para operações relacionadas a atores.
- DiretorService.java: Serviço para operações relacionadas a diretores.
- FilmeService.java: Serviço para operações relacionadas a filmes.
### View
- Console.java: Classe responsável pela interface de linha de comando.
  
**App.java: Ponto de entrada da aplicação.**

## Funcionalidades
- Listar filmes da plataforma.
- Buscar por filmes.
- Cadastrar filmes.
- Cadastrar atores.
- Cadastrar diretores.
- Associar filme a ator.
- Associar filme a diretor.
- Sair do sistema.

## Como Executar
- Clone o repositório: git clone https://github.com/dcbarros/Projeto-IMDFake.git
- Navegue até o diretório do projeto: cd imdfake
- Compile e execute a aplicação: javac App.java && java App
## Requisitos
- Java Development Kit (JDK) 8 ou superior.

## Observações
Este projeto é puramente fictício e tem como objetivo demonstrar uma estrutura de código em Java para uma aplicação de plataforma de filmes.

A estrutura do projeto segue um modelo MVC (Model-View-Controller).

A aplicação é executada a partir da classe App.java e interage com o usuário através da classe Console.java.

Os dados são armazenados em memória através de repositórios (AtorRepository.java, DiretorRepository.java, FilmeRepository.java) e manipulados por serviços (AtorService.java, DiretorService.java, FilmeService.java).

A aplicação foi desenvolvida como um projeto educacional e pode conter simplificações para fins de aprendizado.
