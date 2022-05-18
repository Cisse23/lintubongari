package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static final String URL = "jdbc:sqlite:D:\\Tietokanta\\lintuBongari.sqlite";

	public Connection connect() {
		Connection conny = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conny = DriverManager.getConnection(URL);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return conny;
	}

}
