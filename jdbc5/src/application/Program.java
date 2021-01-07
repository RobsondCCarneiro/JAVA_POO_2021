//Deletando dados do SQL pelo JAVA
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

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
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Feito! Linhas afetadas: " + rowsAffected);
		}
		catch(SQLException e){
			//e.printStackTrace();
			//Gerando a minha própria exceção
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
