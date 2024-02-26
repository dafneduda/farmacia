package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {

	//CRUD do produto  (Create, Read, Update and Delete)
	public void criarProduto(Produto produto);
	public void listarProdutos();
	public void consultarProdutoPorId(int numero);
	public void atualizarProduto(Produto produto);
	public void deletarProduto(int numero);
		
}
