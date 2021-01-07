package db;

public class DbIntegrityException extends RuntimeException{

	//Como é subclasse de RuntimeException, então é obrigado ter o serial
	private static final long serialVersionUID = 1L;
	
	//Forçar a passar a mensagem para a superclasse
	public DbIntegrityException(String msg) {
		super(msg);
	}

}
