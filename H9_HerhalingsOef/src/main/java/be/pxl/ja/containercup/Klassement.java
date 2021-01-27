package be.pxl.ja.containercup;

public enum Klassement {
	M("SPORTMAN"),
	V("SPORTVROUW"),
	BV("BV");

	private String omschrijving;

	Klassement(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getOmschrijving() {
		return omschrijving;
	}
}
