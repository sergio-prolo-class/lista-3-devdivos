package ifsc.poo.atendimento;

import java.util.Scanner;

public class Menu {

    public void executar() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Bem-vindo(a)!!");
        int opcao;

        Atendimento atendimento = new Atendimento();
        Cliente cliente = null;
        String descricao = null;

        //Exibe o menu de opções do usuário
        do {
            System.out.println("\nEscolha uma opcao: ");
            System.out.println("0 - Encerrar atendimento");
            System.out.println("1 - Cadastro de dados");
            System.out.println("2 - Nova solicitacao");
            System.out.println("3 - Telefones de todos os clientes");
            System.out.println("4 - O proximo cliente e: ");
            System.out.println("5 - Proxima demanda: ");
            System.out.println("6 - Idade dos clientes atendidos");
            System.out.println("7 - Telefone de clientes em espera");
            opcao = inp.nextInt();
            inp.nextLine();

        switch (opcao) {
             case 0: //encerra o atendimento
                    System.out.println("Encerrando atendimento...");
                    break;
            case 1: //cadastra os dados do cliente
                System.out.println("Digite o nome do cliente: ");
                String nome = inp.nextLine();

                System.out.println("Digite a idade do cliente: ");
                int idade = inp.nextInt();
                inp.nextLine();

                System.out.println("Digite o telefone do cliente: ");
                String telefone = inp.nextLine();

                System.out.println("Insira a descrição da solicitação: ");
                descricao = inp.nextLine();

                cliente = new Cliente(nome, idade, telefone);
                atendimento.adicionarSolicitacao(cliente, descricao);

                break;

            case 2: //registra uma nova solicitação de cliente
                System.out.println("Registro de nova solicitação");
                System.out.println("Digite o nome do cliente: ");
                String nomeC = inp.nextLine();
                System.out.println("Digite a idade do cliente: ");
                int idadeC = inp.nextInt();
                inp.nextLine(); 
                System.out.println("Digite o telefone do cliente: ");
                String telefoneC = inp.nextLine();
                System.out.println("Insira a descrição da nova solicitação: ");
                descricao = inp.nextLine();

                atendimento.adicionarSolicitacao(cliente, descricao);
            
                break;

            case 3: //lista os telefones de todos os clientes
                System.out.println("Telefones de todos os clientes: ");
                for (String telefoneCliente : atendimento.listarTelefones()) {
                    System.out.println(telefoneCliente);
                }
                break;
            case 4: //mostra o próximo cliente da fila
                System.out.printf("O próximo cliente é: " + atendimento.proximoCliente());
                break;

            case 5: // atende a próxima solicitação
                System.out.printf("A próxima solicitação é: " + atendimento.proximaSolicitacao());
                break;

            case 6: // lista as idades dos clientes atendidos
                System.out.println("Idades dos clientes atendidos: ");
                for (Integer idadeCliente : atendimento.idadesAtendidos()) {
                    System.out.println(idadeCliente);
                }
                break;

            case 7: // lista os telefones dos clientes que estão em espera
                System.out.println("Telefones de clientes em espera: ");
                for (String telefoneEspera : atendimento.telefonesEmEspera()) {
                    System.out.println(telefoneEspera);
                }
                break;
            default: //tratativa de erro 
                System.out.println("Opção inválida. Tente novamente.");

       }
        } while (opcao != 0);
    }
}
