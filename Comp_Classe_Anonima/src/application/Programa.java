//Aqui eh o segundo exemplo
package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Produto;

public class Programa {

	public static void main(String[] args) {
		List<Produto> list = new ArrayList<>();
		
		list.add(new Produto("TV", 900.0));
		list.add(new Produto("notebook", 1200.0));
		list.add(new Produto("tablet", 450.0));
		
		/*
		 * Por comodidade pode criar uma CLASSE ANONIMA dessa forma
		 */
		Comparator<Produto> comp = new Comparator<Produto>() {
			public int compare(Produto p1, Produto p2) {
				
				//Aqui retorna 0 se for igual, -1 se for menor e 1 se for maior.
				return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
			}
		};
		
		list.sort(comp);
		
		for(Produto p:list) {
			System.out.println(p);
		}

	}

}
