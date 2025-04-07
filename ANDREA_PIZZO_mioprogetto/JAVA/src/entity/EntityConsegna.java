package entity;
import java.sql.Date;
import java.sql.Time;

public class EntityConsegna {
	private Date data;
	private Time ora;
	
public EntityConsegna(Date data, Time ora) {
	this.data=data;
	this.ora=ora;
}
public Date getdata() {
	return data;
}
public Time getora() {
	return ora;
}
public void setdata(Date data) {
	this.data=data;
}
public void setora(Time ora) {
	this.ora=ora;
}
}