//Atualizando dados pelo JAVA para o SQL
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			/*
			 * Sempre que for der UPDATE ou DELETE é recomendado
			 * utilizar o WHERE para atualizar o elemento específico,
			 * ao invés de todos os elementos.
			 */
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			//Aqui coloca os valores dos PlaceHolders (?)
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Feito! Linhas afetadas: " + rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
