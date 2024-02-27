package farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import farmacia.model.Medicamento;
import farmacia.model.Produto;
import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;

public class Menu {

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();

		Scanner leia = new Scanner(System.in);

		int opcao, id, tipo, numero;
		String nome, fragrancia, generico;
		float preco;

		// criação de produtos
		System.out.println("Criar Produto\n");

		Medicamento m1 = new Medicamento(147, "Advil", 1, 23.98f, "Genérico");
		produtos.criarProduto(m1);

		Medicamento m2 = new Medicamento(148, "Dorflex", 1, 78.69f, "Genérico");
		produtos.criarProduto(m2);

		Cosmetico c1 = new Cosmetico(258, "Sallve", 2, 98.64f, "Fragrância");
		produtos.criarProduto(c1);

		Cosmetico c2 = new Cosmetico(259, "Avene", 2, 187.66f, "Fragrância");
		produtos.criarProduto(c2);

		produtos.listarProdutos();

		while (true) {

			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("                  FARMÁCIA FELIZ                     ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar Todos os Produtos             ");
			System.out.println("            3 - Consultar Produto por ID             ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Deletar Produto                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("   Opção desejada:                                   ");
			System.out.println("-----------------------------------------------------");

			// add try catch para tratar exceções
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nObrigade, Farmácia Feliz agradece seu sorriso!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto\n\n");

				System.out.println("Digite o ID do Produto: ");
				id = leia.nextInt();
				System.out.println("Digite o Nome do Produto: ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				do {
					System.out.println("Digite o Tipo do Produto (1-Medicamento ou 2-Cosmético): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Preço do Produto R$");
				preco = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("O medicamento foi cadastrado como Genérico.");
					generico = leia.nextLine();
					produtos.criarProduto(new Medicamento(id, nome, tipo, preco, generico));
				}
				case 2 -> {
					System.out.println("Alerta: esse cosmético contém Fragrância.");
					fragrancia = leia.nextLine();
					produtos.criarProduto(new Cosmetico(id, nome, tipo, preco, fragrancia));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar Todos os Produtos\n\n");
				produtos.listarProdutos();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar Produtos por ID\n\n");

				System.out.println("Digite o ID do Produto: ");
				numero = leia.nextInt();

				produtos.consultarProdutoPorId(numero);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");

				System.out.println("Digite o ID do Produto: ");
				id = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(id);

				if (buscaProduto != null) {

					tipo = buscaProduto.getTipo();

					System.out.println("Digite o Nome do Produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o Preço do Produto R$");
					preco = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("O medicamento foi atualizado como Genérico.");
						generico = leia.nextLine();
						produtos.atualizarProduto(new Medicamento(id, nome, tipo, preco, generico));
					}
					case 2 -> {
						System.out.println("Alerta: esse cosmético contém Fragrância.");
						fragrancia = leia.nextLine();
						produtos.atualizarProduto(new Cosmetico(id, nome, tipo, preco, fragrancia));
					}
					default -> {
						System.out.println("Tipo de Produto Inválido!");
					}

					}
				} else {
					System.out.println("O Produto não foi encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println("Deletar Produto\n\n");

				System.out.println("\nDigite o ID do Produto: ");
				numero = leia.nextInt();

				produtos.deletarProduto(numero);

				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	private static void keyPress() {
		try {
			System.out.println("\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}