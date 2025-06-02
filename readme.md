[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/glaA5tz-)

# Programação Orientada a Objetos

--- 

Dupla: Leticia Helena do Rosário Furlan e Roberto da Silva Espindola.

## Lista 3: Diagramas de classe

---

### Pacote 1 - Catálogo de filmes

#### Como executar o programa:

- Para rodar o programa basta digitar ```./gradlew run``` no terminal.
- Insira no terminal a opção desejada do menu e aperte ```Enter``` no teclado.
#### Instruções de uso:

- Adicionar filmes: adicione o filme ao catálogo com seu nome, ano de lançamento e genêro.
- Remover filmes: remova o filme desejado inserindo o seu título.
- Listar os filmes: opções que listam os filmes por ordem alfabética de título, de genêro e por ano de lançamento, acionando apenas a sua opção respectiva no menu do programa.
- Buscar os filmes de determinado ano: insira o ano do filme desejado para buscar o filme pelo seu ano de lançamento.



```mermaid
classDiagram
    direction RL
    class Controle{
        - catalogo : Catalogo
        + executar() void
    }
    class Catalogo{
        - filmes : ArrayList~Filme~
        + adicionarFilme(Filme filme) boolean
        + removerFilme(String titulo) boolean
        + listarFilmesPorAno() List~Filme~
        + listarFilmesPorGenero() List~Filme~
        + listarFilmesPorTitulo() List~Filme~
    }
    class Filme{
        - titulo : String
        - anoLancamento : int
        - genero : String
        }
    
    class App{
        +main(args: String[]) void
    }
        
    Controle <--App
    Catalogo <-- Controle
    Catalogo *-- Filme

```

### Pacote 2: Fila de atendimento 

#### Como executar o programa:

- Para rodar o programa basta digitar ```./gradlew run``` no terminal.
- Insira no terminal a opção desejada do menu e aperte ```Enter``` no teclado.

#### Instruções de uso:
- Cadastrar cliente: Informe nome, idade, telefone e uma primeira solicitação.
- Nova solicitação: Escolha um cliente já cadastrado e registre uma nova demanda para ele.
- Listar telefones: Exibe os telefones de todos os clientes cadastrados.
- Próximo cliente: Mostra quem é o próximo da fila de atendimento.
- Próxima demanda: Atende a próxima solicitação da fila.
- Idades dos clientes atendidos: Lista as idades dos clientes que já foram atendidos.
- Telefones de clientes em espera: Lista os telefones dos clientes que ainda possuem solicitações pendentes.


```mermaid
classDiagram
    class App {
        +main(args: String[]) void
    }

    class Menu {
        +executar() void
    }

    class Atendimento {
        -clientes : ArrayList~Cliente~
        -solicitacoes : ArrayList~Solicitacao~
        -clientesAtendidos : ArrayList~Cliente~
        +adicionarSolicitacao(cliente: Cliente, descricao: String) void
        +listarTelefones() List~String~
        +proximoCliente() String
        +proximaSolicitacao() String
        +idadesAtendidos() List~Integer~
        +telefonesEmEspera() List~String~
        }

    class Cliente {
        -nome : String
        -idade : int
        -numeroTelefone : String
        }

    class Solicitacao {
        -cliente : Cliente
        -descricao : String
        }

    App --> Menu
    Menu --> Atendimento
    Atendimento "1" o-- "*" Cliente
    Atendimento "1" o-- "*" Solicitacao
    Solicitacao --> Cliente
```