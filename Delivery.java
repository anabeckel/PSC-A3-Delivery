import java.util.ArrayList;
import java.util.Scanner;

// Demais classes permanecem iguais...

public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro de Restaurantes fixos
        Restaurante restaurante1 = new Restaurante("Restaurante Italiano", "italiano@gmail.com", "Comida Italiana");
        restaurante1.adicionarEndereco(new Endereco("Rua B", 200, "Porto Alegre", "90100-000"));
        restaurante1.adicionarTelefone(new Telefone("51", "988888888"));
        restaurante1.adicionarAlimento(new Alimento("Pizza Margherita", 50.0f, restaurante1));
        restaurante1.adicionarAlimento(new Alimento("Lasanha", 40.0f, restaurante1));

        Restaurante restaurante2 = new Restaurante("Restaurante Japonês", "japones@gmail.com", "Comida Japonesa");
        restaurante2.adicionarEndereco(new Endereco("Rua C", 300, "Porto Alegre", "90200-000"));
        restaurante2.adicionarTelefone(new Telefone("51", "977777777"));
        restaurante2.adicionarAlimento(new Alimento("Sushi", 25.0f, restaurante2));
        restaurante2.adicionarAlimento(new Alimento("Tempurá", 30.0f, restaurante2));

        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(restaurante1);
        restaurantes.add(restaurante2);

        Cliente cliente = null;

        while (true) {
            System.out.println("=======================================================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Criar Pedido");
            System.out.println("3 - Sair ");
            System.out.println("=======================================================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1: // Cadastrar Cliente
                    System.out.println("=== Cadastro de Cliente ===");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o email do cliente: ");
                    String emailCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();

                    cliente = new Cliente(nomeCliente, emailCliente, cpfCliente);

                    System.out.print("Digite a rua do endereço: ");
                    String ruaCliente = scanner.nextLine();
                    System.out.print("Digite o número do endereço: ");
                    int numeroCliente = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite a cidade: ");
                    String cidadeCliente = scanner.nextLine();
                    System.out.print("Digite o CEP: ");
                    String cepCliente = scanner.nextLine();

                    cliente.adicionarEndereco(new Endereco(ruaCliente, numeroCliente, cidadeCliente, cepCliente));

                    System.out.print("Digite o DDD do telefone: ");
                    String dddCliente = scanner.nextLine();
                    System.out.print("Digite o número do telefone: ");
                    String telefoneCliente = scanner.nextLine();

                    cliente.adicionarTelefone(new Telefone(dddCliente, telefoneCliente));

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2: // Criar Pedido
                    if (cliente == null) {
                        System.out.println("É necessário cadastrar um cliente antes de criar um pedido!");
                        break;
                    }

                    System.out.println("=== Restaurantes Disponíveis ===");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        Restaurante r = restaurantes.get(i);
                        System.out.println((i + 1) + " - " + r.getNome() + " (" + r.getTipoComida() + ")");
                    }

                    System.out.print("Escolha um restaurante pelo número: ");
                    int escolhaRestaurante = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    if (escolhaRestaurante < 1 || escolhaRestaurante > restaurantes.size()) {
                        System.out.println("Restaurante inválido!");
                        break;
                    }

                    Restaurante restauranteEscolhido = restaurantes.get(escolhaRestaurante - 1);

                    Pedido pedido = new Pedido("Cartão de Crédito", cliente, restauranteEscolhido);

                    System.out.println("=== Alimentos Disponíveis ===");
                    for (int i = 0; i < restauranteEscolhido.getListaAlimentos().size(); i++) {
                        Alimento alimento = restauranteEscolhido.getListaAlimentos().get(i);
                        System.out.println((i + 1) + " - " + alimento.getDescricao() + " (R$ " + alimento.getPrecoUnitario() + ")");
                    }

                    System.out.print("Quantos itens deseja adicionar ao pedido? ");
                    int numItens = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    for (int i = 0; i < numItens; i++) {
                        System.out.print("Escolha o número do alimento: ");
                        int escolhaAlimento = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer

                        if (escolhaAlimento < 1 || escolhaAlimento > restauranteEscolhido.getListaAlimentos().size()) {
                            System.out.println("Alimento inválido!");
                            i--; // Permite tentar novamente
                            continue;
                        }

                        Alimento alimentoEscolhido = restauranteEscolhido.getListaAlimentos().get(escolhaAlimento - 1);

                        System.out.print("Digite a quantidade desejada: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer

                        ItemPedido itemPedido = new ItemPedido(quantidade, alimentoEscolhido);
                        pedido.adicionarItem(itemPedido);
                    }

                    float precoTotal = pedido.calcularPrecoTotal();
                    System.out.println("Pedido criado com sucesso!");
                    System.out.println("Preço total do pedido: R$ " + precoTotal);
                    cliente.realizarPedido(pedido);
                    break;

                case 3: // Sair
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
