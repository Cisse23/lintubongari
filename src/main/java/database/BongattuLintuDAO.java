package database;

import java.util.List;

import model.BongattuLintu;

public interface BongattuLintuDAO {

	public List<BongattuLintu> bongatutLinnut();

	public BongattuLintu getId(int id);

	public boolean AddBongattuLintu(BongattuLintu lintu);

	public boolean removeBongattuLintu(int id);
}
