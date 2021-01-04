package application;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import util.ProductPredicate;

public class Programa {

	public static void main(String[] args) {
		List<Produto> list = new ArrayList<>();
		list.add(new Produto("Tv", 900.00)); 
		list.add(new Produto("Mouse", 50.00)); 
		list.add(new Produto("Tablet", 350.50)); 
		list.add(new Produto("HD Case", 80.90));
		
		//list.removeIf(p -> p.getPreco() >= 100);
		list.removeIf(new ProductPredicate());
		
		for(Produto p : list) {
			System.out.println(p);
		}
	}

}
