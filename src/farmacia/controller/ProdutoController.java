package farmacia.controller;

import java.util.ArrayList;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	// criar a ArrayList para armazenar os produtos com seus atributos
	// int numero armazenará o número da última conta que foi criada.

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int numero = 0;

	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO Produto " + produto.getNome() + " foi criado.");
	}

	@Override
	public void listarProdutos() {
		for (var produto : listaProdutos) {
			produto.visualizar(); // produto é uma variável local
		}
	}

	@Override
	public void consultarProdutoPorId(int numero) {
		var produto = buscarNaCollection(numero);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nO Produto ID " + numero + " não foi encontrado!");
	}

	@Override
	public void atualizarProduto(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO Produto com ID " + produto.getId() + " foi atualizado com sucesso!");
		} else
			System.out.println("\nO Produto com ID " + produto.getId() + " não foi econtrado.");
	}

	@Override
	public void deletarProduto(int numero) {
		var produto = buscarNaCollection(numero);

		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\n O Produto ID " + numero + " foi apagado com sucesso!");
		}

		else
			System.out.println("\nO Produto ID " + numero + " não foi encontrado!");
	}

	public Produto buscarNaCollection(int numero) {
		for (var produto : listaProdutos) {
			if (produto.getId() == numero) {
				return produto;
			}
		}
		return null;
	}
}
