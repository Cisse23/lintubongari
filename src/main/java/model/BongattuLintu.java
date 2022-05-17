package model;

public class BongattuLintu {
	private String laji;
	private int id;
	private String bongattuPaikka;
	private String bongattuPvm;

	public BongattuLintu(String laji, String bongattuPaikka, String bongattuPvm) {
		this.laji = laji;
		this.bongattuPaikka = bongattuPaikka;
		this.bongattuPvm = bongattuPvm;
	}

	public String getLaji() {
		return laji;
	}

	public void setLaji(String nimi) {
		this.laji = nimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBongattuPaikka() {
		return bongattuPaikka;
	}

	public void setBongattuPaikka(String bongattuPaikka) {
		this.bongattuPaikka = bongattuPaikka;
	}

	public String getBongattuPvm() {
		return bongattuPvm;
	}

	public void setBongattuPvm(String bongattuPvm) {
		this.bongattuPvm = bongattuPvm;
	}
}
