package fi.agileo.spring.e11.kello;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * SuomiKello on suomalainen kello. SuomiKellolle voi asettaa lähteeksi jonkin
 * KelloLahde-luokan instanssin, jota SuomiKello käyttää nykyhetken selvittämiseen.
 * SuomiKello ei piittaa missä maassa sitä ajetaan, kellonaika näytetään
 * aina Itä-Euroopan aikavyöhykkeen mukaan ja muotoillaan suomalaiseen tapaan.
 */
public class GmtIsoKello implements Kello {


	private KelloLahde lahde;
	
	private SimpleDateFormat aikaMuotoilija = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat pvmMuotoilija = new SimpleDateFormat("yyyy-MM-dd");
	private TimeZone easternEuropeanTime = TimeZone.getTimeZone("GMT");

	public GmtIsoKello(KelloLahde lahde) {
		this.lahde = lahde;
		this.aikaMuotoilija.setTimeZone(easternEuropeanTime);
		this.pvmMuotoilija.setTimeZone(easternEuropeanTime);
	}

	public String getAika() {
		return aikaMuotoilija.format(lahde.haeAjanhetki());
	}

	public String getPvm() {
		return pvmMuotoilija.format(lahde.haeAjanhetki());
	}

}
