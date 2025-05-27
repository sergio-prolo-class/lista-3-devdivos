[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/glaA5tz-)

# Programação Orientada a Objetos

--- 

Dupla: Leticia Helena do Rosário Furlan e Roberto da Silva Espindola.

## Lista 3: Diagramas de classe

---

```mermaid
classDiagram
    class Controle{
        - catalogo : Catalogo
        + executar() void
    }
    class Catalogo{
        - filmes : ...
        
        
        + adicionarFilme(Filme filme) void
        + removerFilme(String titulo) void
    }
    class Filme{
        - titulo : String
        - anoLancamento : int
        - genero : String
        + getTitulo()  String
        + getAnoLancamento() int
        + getGenero() String
    }
    
    Catalogo <|-- Controle
    Catalogo *-- Filme
    
    
        
```