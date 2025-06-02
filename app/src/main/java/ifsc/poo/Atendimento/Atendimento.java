package ifsc.poo.atendimento;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
    private ArrayList<Cliente> clientesAtendidos = new ArrayList<>();

    // Opção 2 - Método para adicionar uma nova solicitação de cliente
    public void adicionarSolicitacao(Cliente cliente, String descricao) {
    // Procura o cliente já cadastrado para evitar duplicidade
    Cliente clienteExistente = null;
    for (Cliente c : clientes) {
        if (c.equals(cliente)) { // compara se o cliente já existe na lista
            clienteExistente = c;
            break;
        }
    }
    if (clienteExistente == null) {
        clientes.add(cliente);
        clienteExistente = cliente;
    }
    Solicitacao novaSolicitacao = new Solicitacao(clienteExistente, descricao);
    solicitacoes.add(novaSolicitacao);

    // a opção está com erro, pois não sei como fazer essa relação de 1 cliente para N solicitações, Usei o formulário de cadastro de novo ;)
}
// Opção 3 - Método para listar os telefones de todos os clientes
    public List<String> listarTelefones() {
        ArrayList<String> telefones = new ArrayList<>();
        for (Cliente c : clientes) { //percorre a lista de clientes 
            telefones.add(c.getNumeroTelefone()); //adiciona o telefone do cliente na lista de telefones
        }return telefones; //retorna a lista de telefones
    }

    // Opção 4 - Método para retornar o nome do próximo cliente na fila
   public String proximoCliente() {
    for (Solicitacao s : solicitacoes) {
        Cliente cliente = s.getCliente();
        if (!clientesAtendidos.contains(cliente)) {
            return cliente.getNome();
        }
    }
    return "Nenhum cliente na fila.";
}

// Opção 5 - Método para tratar a próxima solicitação
public String proximaSolicitacao() {
    if (!solicitacoes.isEmpty()) {
        Solicitacao solicitacao = solicitacoes.get(0);
        Cliente cliente = solicitacao.getCliente();
        String descricao = solicitacao.getDescricao();
        solicitacoes.remove(0);

        // Verifica se o cliente ainda tem outras solicitações na fila
        boolean aindaTemSolicitacao = false;
        for (Solicitacao s : solicitacoes) {
            if (s.getCliente().equals(cliente)) {
                aindaTemSolicitacao = true;
                break;
            }
        }
        // Se não tiver mais, marca como atendido
        if (!aindaTemSolicitacao && !clientesAtendidos.contains(cliente)) {
            clientesAtendidos.add(cliente);
        }
        return descricao;
    }
    return "Nenhuma solicitação na fila.";
}

// Opção 6 - Método para listar as idades dos clientes atendidos
    public List<Integer> idadesAtendidos() {
        ArrayList<Integer> idades = new ArrayList<>();
        for (Cliente c : clientesAtendidos) { //percorre a lista de clientes atendidos
            idades.add(c.getIdade()); //adiciona a idade do cliente na lista de idades
        }
        return idades; //retorna a lista de idades
    }

    // Opção 7 - Método para listar os telefones dos clientes que estão em espera
    public List<String> telefonesEmEspera() {
        ArrayList<String> telefones = new ArrayList<>();
         for (Solicitacao s : solicitacoes) {
        String telefone = s.getCliente().getNumeroTelefone();
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        }
    }
    return telefones; //retorna a lista de telefones
    }
}
