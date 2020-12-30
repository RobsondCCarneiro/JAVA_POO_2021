package application;

import java.util.Comparator;

import entities.Produto;

public class MyComparator implements Comparator<Produto>{

	@Override
	public int compare(Produto p1, Produto p2) {
		
		//Aqui retorna 0 se for igual, -1 se for menor e 1 se for maior.
		return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
	}
}
