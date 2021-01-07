//implementando uma transa��o no JAVA para o Banco de Dados
package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			//Isso � para n�o d� commit antes de terminar tudo
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2100 WHERE DepartmentId = 1");
			
			//Criando um erro falso para simular um problema na transa��o
			/*int x = 1;
			if( x < 2) {
				throw new SQLException("falso erro!");
			}*/
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			//Aqui � para confirmar que ambas as opera��es acabou
			conn.commit();
			
			System.out.println("rows 1 " + rows1);
			System.out.println("rows 2 " + rows2);
		}
		catch(SQLException e){
			//e.printStackTrace();
			//Caso der alguma exce��o tentar refazer a opera��o
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				//lan�ando a exce��o personalizada
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());	
			}
			
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
