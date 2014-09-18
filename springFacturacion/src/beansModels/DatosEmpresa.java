package beansModels;

import java.io.Serializable;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class DatosEmpresa implements Serializable {
	
	/*
	 * id ---------------> id de la empresa
	 * nombreEmpresa ----> Nombre de la empresa (entre 3 y 50 chars)
	 * nombreComercial --> Nombre comercial de la empresa (entre 3 y 50 chars)
	 * direccion --------> Direccion de la empresa (entre 3 y 50 chars)
	 * cpostal ----------> codigo postal de la empresa (entre 3 y 50 chars)
	 * localidad --------> localidad de la empresa (entre 3 y 50 chars)
	 * nif --------------> nif de la empresa (9 chars)
	 * texto ------------> texto de la empresa (max 200 chars)
	 * serieFact --------> serie de facturacion (maximo 8 caracteres)
	 * ultimoNumero -----> ultimo numero facturado (de 0 a 999999)
	 * retencion --------> Empresa con retencion o no (0=sin retencion - 1=con retencion)
	 */

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nombreEmpresa;
	private String nombreComercial;
	private String direccion;
	private String cpostal;
	private String localidad;
	private String nif;
	private String texto;
	private String serieFact;
	private long ultimoNumero;
	private int retencion;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCpostal() {
		return cpostal;
	}
	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getSerieFact() {
		return serieFact;
	}
	public void setSerieFact(String serieFact) {
		this.serieFact = serieFact;
	}
	public long getUltimoNumero() {
		return ultimoNumero;
	}
	public void setUltimoNumero(long ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}
	public int getRetencion() {
		return retencion;
	}
	public void setRetencion(int retencion) {
		this.retencion = retencion;
	}

}
