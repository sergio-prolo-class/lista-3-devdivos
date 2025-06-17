# Correção

| Questão     | Legibilidade | P1 | P2 | Total |
|-------------|--------------|----|----|-------|
| Nota máxima | 15           | 35 | 50 | 100   |
| Nota        | 10           | 30 | 30 | 70    |

- arquivos binários no repositório, cuidado
- pacote atendimento com várias indentações falhas, cuidado

## Diagramas
- sem multiplicidade em algumas associações
- P1:
  - se Catalogo recebe um objeto Filme como argumento de adicionarFilme...
  - então ele não tem controle do ciclo de vida dos objetos Filme!
  - composição não está certo.

## P1

- SoC ferida
  - Controle.exibirFilmes() cuida de formatar o conteúdo de apresentação do Filme...
  - deve acontecer na classe Filme
  - Controle.executar() cuida de filtrar os filmes do catálogo...
  - deve acontecer na classe Catalogo
- Catalogo
  - se não pode haver duplicata, pq usar lista?

### Requisitos Funcionais
- [x] Adicionar filmes
- [x] Remover filmes
- [x] Listar filmes por ordem alfabética de título
- [x] Listar filmes por ordem alfabética de gênero
- [x] Listar filmes por ordem de lançamento
- [x] Buscar filmes de um ano

## P2

- nome de pacote errado, aplicação Java não roda
  - (vou ser muito legal e alterar por vocês, sob penalidade de 5 pontos)
- SRP ferido:
  - Menu é responsável por ambos: conversar com o usuário, e instanciar objetos Cliente
  - essa associação entre Menu e Cliente não está no diagrama
- Atendimento
  - se não pode haver clientes duplicados, por que usar lista?
    - adicionarSolicitacao() faz uso de Cliente.equals() para impedir duplicatas...
    - mas o que é Cliente.equals()? o que ele considera como igualdade?
  - se a lógica de negócios é FIFO, ou seja, uma fila, por que usar lista?
    - próximaSolicitacao() só atende clientes que não foram já atendidos...
    - em uma tentativa de obedecer a ordem de fila.
    - mas isso não faz sentido, já que um cliente pode fazer múltiplas solicitações
  - 

### Requisitos Funcionais
- [x] Registrar dados de um cliente quando é sua primeira solicitação
- [ ] Registrar novas solicitações vinculadas a um cliente
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [ ] Atender o próximo cliente
- [x] Listar as idades dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera