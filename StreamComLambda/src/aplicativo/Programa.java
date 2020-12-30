/*
 * Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.

Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.

Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.
 */
package aplicativo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entidades.Empregado;

public class Programa {

	public static void main(String[] args) {
		//Para imprimir o separador de decimal em ponto
		Locale.setDefault(Locale.US);
		
		//Esperar o usuario digitar
		Scanner sc = new Scanner(System.in);
		
		//Receber o endereco que o usuario digitou ate pressionar o ENTER
		System.out.print("Entre com o caminho do arquivo: ");
		String caminho = sc.nextLine();
		
		//Eh necessario criar o try e o Catch com a excecao para pegar os dados do arquivo se existir
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			List<Empregado> list = new ArrayList<>();
			
			String linha = br.readLine();
			while(linha != null) {
				String[] fields = linha.split(",");
				list.add(new Empregado(fields[0], fields[1], Double.parseDouble(fields[2])));
				linha = br.readLine();
			}
			
			System.out.println("Entre com o salario para mostrar o email dos funcionario com o salario superior: ");
			double salario = sc.nextDouble();
			
			//Stream eh uma sequencia de elementos advinda de uma fonte de dados que oferece suporte a OPERACOES AGREGADAS
			List<String> emails = list.stream()
					//filtra cada elemento por uma condicao
					.filter(x -> x.getSalario() > salario)
					//aplica uma funcao para cada elemento da lista
					.map(x -> x.getEmail())
					//ordena
					.sorted()
					//Acumula os emails ordenados numa lista
					.collect(Collectors.toList());
			
			System.out.println("E-mail das pessoas com o salario eh superior a: " + String.format("%.2f", salario) + ":");
			emails.forEach(System.out::println);
			
			double soma = list.stream()
					//filtra os elementos com a letra M
					.filter(x -> x.getNome().charAt(0) == 'M')
					//Pega apenas o salario pelo Metodo getSalario()
					.map(x -> x.getSalario())
					//faz operacoes matematica entre todos os elementos de forma que: reduce(elementoNeutro, (x[i],x[i+1]) -> x[i] oper x[i+1])
					.reduce(0.0, (x, y) -> x + y);
			System.out.println("Soma dos salario das pessoas que começam com a letra 'M': " + String.format("%.2f", soma));
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
