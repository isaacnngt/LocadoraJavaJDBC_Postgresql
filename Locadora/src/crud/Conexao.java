package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	public static void main(String[] args) throws SQLException {

		// Variavel da URL para conexao com o banco
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		// Variavel do usuario do banco
		final String usuario = "postgres";
		// Variavel da senha do Banco
		final String senha = "123";

		// O m�todo getConnection lan�a uma exce��o que precisa ser tratada pelo Throws
		// ou try catch
		// Neste caso implementado se acontecer uma exce��o. A aplica��o simplesmente
		// sa� do m�todo Main
		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		// Caso ele passe do metodo acima esta mensagem ser� exibida no console
		System.out.println("Conexao Efetuada com sucesso!");

		// Caso ele passe do metodo acima esta mensagem ser� exibida no panel do Java
		JOptionPane.showMessageDialog(null, "Conexao realizada com sucesso!");

		// Finalizar a conex�o
		conexao.close();

	}

}
