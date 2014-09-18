package beansModels;

import java.io.Serializable;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class FormaPago implements Serializable {

	/*
	 * idPago ------> identificador de la grabacion
	 * namePago ----> nombre identificador de la forma de pago
	 * textoPago ---> texto que se mostrara en factura como forma de pago
	 * diasPago ----> numero de dias que se aplaza el pago
	 * fechaPago ---> dia concreto de vencimiento de pago (not required)
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private long idPago;
	private String namePago;
	private String textoPago;
	private String diasPago;
	private String fechaPago;
	
	
	
	public long getIdPago() {
		return idPago;
	}
	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}
	public String getNamePago() {
		return namePago;
	}
	public void setNamePago(String namePago) {
		this.namePago = namePago;
	}
	public String getTextoPago() {
		return textoPago;
	}
	public void setTextoPago(String textoPago) {
		this.textoPago = textoPago;
	}
	public String getDiasPago() {
		return diasPago;
	}
	public void setDiasPago(String diasPago) {
		this.diasPago = diasPago;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	

} // ************** END OF CLASS
