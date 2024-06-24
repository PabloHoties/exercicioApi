package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/bd_exercicioApi";
	private static String user = "postgres";
	private static String pass = "coti";

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, pass);
	}
}
