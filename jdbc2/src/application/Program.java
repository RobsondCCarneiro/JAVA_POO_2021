//Recuperando dados do MySQL para o JAVA
package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args){
		//Conectar o banco de dados
		Connection conn = null;
		//Preparar a consulta para preparar todos os bancos de dados
		Statement st = null;
		//Guardar o resultado na variavel rs
		ResultSet rs = null;
		
		//Como vai acessar arquivos externos, eh necessario o try, porque pode ter excecoes
		try {
			conn = DB.getConnection();
			
			//Instanciou a variavel st
			st = conn.createStatement();
			
			//Aqui coloca todos os comandos igual ao do MySQL
			rs = st.executeQuery("select * from department");
			
			//O next MOVE PARA O PROXIMO, RETORNA false SE JAH ESTIVER NA ULTIMA POSICAO (null)
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		/*
		 * Como Connection, Statement e ResultSet sao recursos externos 
		 * e nao sao controlados pela JVM, entao eh necessario que fechemos os recursos manualmente
		 */
		finally {
			//rs.close();
			DB.closeResultSet(rs);
			//st.close();
			DB.closeConnection();
			DB.closeConnection();
		}

	}

}
