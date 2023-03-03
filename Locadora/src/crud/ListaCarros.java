package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaCarros {

	public static void listaCarro() throws SQLException {
		Connection conexao = FarmConexao.getConnection();

		// comando sql a ser executado
		String sql = "Select * from carro_tb";

		// cria a declaracao para receber um resultado do sql
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		// Cria uma lista de carros para armazenar os dados vindo do banco
		List<Carro> carros = new ArrayList<>();

		// percorre todas as linhas do Resultset
		while (resultado.next()) {
			// Pega o resultado do codigo e nome
			int id_carro = resultado.getInt("id_carro");
			String modelo = resultado.getString("modelo");
			String cor = resultado.getString("cor");
			String fabricante = resultado.getString("Fabricante");
			String placa = resultado.getString("Placa");
			Double valor_diaria = resultado.getDouble("valor_diaria");

			// cria um carro
			carros.add(new Carro(id_carro, modelo, cor, fabricante, placa, valor_diaria));

		}

		// Para exibir na tela os carros que vieram no select executado
		for (Carro c : carros) {

			System.out.println(
					"ID: " + c.getId_carro() + " Modelo: " + c.getModelo() + " Cor: " + c.getCor() + " Fabricante: "
							+ c.getFabricante() + " Placa: " + c.getPlaca() + " Vl_Diaria R$ " + c.getValor_diaria());
		}

		// chama o metodo perguntando se o cliente deseja voltar ao menu principal
		Auxiliar.voltaMenu();

		// fecha o statment
		stmt.close();
		// fecha a conexao
		conexao.close();

	}

}
