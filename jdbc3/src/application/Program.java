package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

import db.DB;

public class Program {

	public static void main(String[] args){
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			/*
			 * A ? eh um placeholder, um lugar que depois coloca o valor.
			 * O PreparedStatement permite montar a consulta SQL para deixar
			 * os parametros para colocar depois.
			 * 
			 * Agora iremos fazer uma sobrecarga em prepareStament
			 *  para que possamos retornar o valor do id.
			 */ 
			
			/*
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			//O setString eh para colocar o valor nos placeholders
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			//Ao inves de java.util.Date() para o banco de dado soh esse:
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			*/
			
			/*
			 * Fazendo outro exemplo, inserindo multiplos elementos,
			 * nesse caso insere apenas os nomes do departamento
			 */
			st = conn.prepareStatement(
					"insert into department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();
			//System.out.println("Done! Rows affected: " + rowsAffected);
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					/*
					 * Ao inves de colocar "id" no parametro do metodo getInt()
					 * tenho que colocar o 1 para indicar que quero pegar a
					 * primeira coluna.
					 */
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}
		}
		
		//Exceção para quando houver erro no Acesso ao Banco de Dados
		catch (SQLException e){
			e.printStackTrace();
		}
		
		/* excecao para a data que nao eh mais usada
		catch(ParseException e) {
			e.printStackTrace();
		}
		*/
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
