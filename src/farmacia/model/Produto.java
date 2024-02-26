package farmacia.model;

public abstract class Produto {

	private int id;
	private String nome;
	private int tipo;
	private float preco;

	public Produto(int id, String nome, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {

		String tipoProduto = "";

		switch (this.tipo) {
		case 1:
			tipoProduto = "Medicamento";
			break;
		case 2:
			tipoProduto = "Cosmético";
			break;
		}

		System.out.println("--------------------------------");
		System.out.println("PRODUTO");
		System.out.println("--------------------------------");
		System.out.println("ID: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Tipo: " + tipoProduto);
		System.out.println("Preço R$" + this.preco);

	}
}
