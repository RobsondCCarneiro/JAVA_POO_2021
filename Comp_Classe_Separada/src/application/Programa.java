/*
 * Existe varios metodos de implementar o mesmo programa, este eh o primeiro, que ira utilizar uma
 * classe separada utilizando o Comparator
 */
package application;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class Programa {

	public static void main(String[] args) {
		List<Produto> list = new ArrayList<>();
		
		list.add(new Produto("TV", 900.0));
		list.add(new Produto("notebook", 1200.0));
		list.add(new Produto("tablet", 450.0));
		
		/*
		 * Se o criterio de comparacao mudar, precisaria alterar na classe Product, para manutencao
		 * eh indesejado, dessa forma, foi criado uma classe por fora chamada de MyComparator
		 * de forma que quando mudar o criterio de comparacao, jah altera diretamente na classe
		 */
		list.sort(new MyComparator());
		
		/*
		 * Antes da mudanca, houve o:
		 * Collections.sort(list);
		 * Porém como a classe Produto nao eh mais uma interface de Comparable, entao este metodo
		 * nao funcionaria, entao foi criado o metodo que esta logo acima que o parametro eh 
		 * um comparator
		 */
		
		for(Produto p:list) {
			System.out.println(p);
		}

	}

}
