package entity;

public class EntityProdotti {
	private String codice;
	private String categoria;
	private String tipo;
	private String descrizione;
	private float prezzo;
	private int quantita;
	
public EntityProdotti(String codice, String categoria, String tipo, String descrizione, float prezzo, int quantita) {
	super();
	this.codice=codice;
	this.categoria=categoria;
	this.tipo=tipo;
	this.descrizione=descrizione;
	this.prezzo=prezzo;
	this.quantita=quantita;
}
public String getcodice() {
	return codice;
}
public void setcodice(String codice) {
	this.codice=codice;
}
public String getcategoria() {
	return categoria;
}
public void setcategoria(String categoria) {
	this.categoria=categoria;
}
public String gettipo() {
	return tipo;
}
public void settipo(String tipo) {
	this.tipo=tipo;
}
public String getdescrizione() {
	return descrizione;
}
public void setdescrizione(String descrizione) {
	this.descrizione=descrizione;
}
public float getprezzo() {
	return prezzo;
}
public void setprezzo(float prezzo) {
	this.prezzo=prezzo;
}
public int getquantita() {
	return quantita;
}
public void setquantita(int quantita) {
	this.quantita=quantita;
}
}
