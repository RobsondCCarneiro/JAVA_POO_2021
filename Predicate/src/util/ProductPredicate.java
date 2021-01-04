/*
 * Predicate eh uma interface funcional que soh tem apenas um unico metodo abstrato. Suas implementacoes
 * serao tratadas como expressao lambda.
 */

package util;

import java.util.function.Predicate;

import entities.Produto;

public class ProductPredicate implements Predicate<Produto> {

	@Override
	public boolean test(Produto t) {
		return t.getPreco() >= 100.0;
	}

}
