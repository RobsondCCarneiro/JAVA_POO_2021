package entities;

//antes de eu criar a classe MyComparator, eu declarava a classe como uma interface de Comparator
//public class Produto implements Comparable<Produto> {

public class Produto{
	private String nome;
	private Double preco;
	
	
	public Produto() {
		super();
	}


	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}
	
	//Aqui seria colocado o Comparator, porem para manutencao eh melhor o deixar como uma classe independente
	/*
	@Override
	public int compare(Produto p) {
		return nome.toUpperCase().compareTo(p.getNome().toUpperCase());
	}
	*/
}
