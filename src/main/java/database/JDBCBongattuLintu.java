package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BongattuLintu;

public class JDBCBongattuLintu implements BongattuLintuDAO {

	Database db = new Database();

	@Override
	public List<BongattuLintu> bongatutLinnut() {
		List<BongattuLintu> kaikkiLinnut = new ArrayList<BongattuLintu>();
		try {

			PreparedStatement query = db.connect().prepareStatement("SELECT * FROM \"bongattu_lintu\"");
			ResultSet result = query.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String laji = result.getString("laji");
				String paikka = result.getString("paikka");
				String pvm = result.getString("pvm");
				kaikkiLinnut.add(new BongattuLintu(id, laji, paikka, pvm));
			}

			query.close();
			db.connect().close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return kaikkiLinnut;
	}

	@Override
	public BongattuLintu getId(int id) {
		// TODO lisää getId jos tarvii
		return null;
	}

	@Override
	public boolean addBongattuLintu(BongattuLintu lintu) {
		try {

			PreparedStatement query = db.connect()
					.prepareStatement("INSERT INTO \"bongattu_lintu\" (laji, paikka, pvm) VALUES (?, ?, ?)");
			query.setString(1, lintu.getLaji());
			query.setString(2, lintu.getBongattuPaikka());
			query.setString(3, lintu.getBongattuPvm());

			query.executeUpdate();
			System.out.println("Successfully added " + lintu.getLaji());

			query.close();
			db.connect().close();

			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to add BongattuLintu " + lintu.getLaji());

			return false;
		}

	}

	@Override
	public boolean removeBongattuLintu(int id) {
		try {
			PreparedStatement query = db.connect().prepareStatement("DELETE FROM \"bongattu_lintu\" WHERE id = ?");
			query.setInt(1, id);
			int records = query.executeUpdate();
			System.out.println("Succesfully removed " + records + " BongattuLintu");

			query.close();
			db.connect().close();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to remove BongattuLintu");
			return false;
		}

	}

}
