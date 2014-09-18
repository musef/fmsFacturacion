package beansModels;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class Albaranes implements Serializable {
	
	/*
	 * id ------------> identificador de la grabacion
	 * invoice -------> empty sin facturar o numero factura 
	 * codeCustomer --> codigo del cliente
	 * number --------> numero del albaran
	 * dateOper ------> fecha del albaran
	 * codeCompany ---> codigo de la compañia que factura

	 * ************ MAXIMO 3 ARTICULOS POR ALBARAN ****** 
 	 * codeOper ------> codigo de la operacion facturada (not required)
	 * textOper ------> texto de la operacion facturada (not required)
	 * qttOper -------> uds del albaran 
	 * priceOper -----> importe del albaran
	 * ivaOper -------> tipo iva del albaran
	 * 
	 * baseImponible0 --> base imponible sin iva
	 * baseImponible1 --> base imponible tipo 1
	 * tipoiva1 --------> tipo del iva 1
	 * iva1 ------------> iva tipo 1
	 * baseImponible2 --> base imponible tipo 2
	 * tipoiva2 --------> tipo del iva 2
	 * iva2 ------------> iva tipo 2
	 * baseImponible3 --> base imponible tipo 3
	 * tipoiva3 --------> tipo del iva 3
	 * iva3 ------------> iva tipo 3
	 * tiporet ---------> tipo de la retencion
	 * retencion -------> retencion por irpf (not required)
	 * totalAlbaran ----> importe total a pagar
	 */

	private static final long serialVersionUID = 1L;

	private long id;
	private String invoice;
	private String codeCustomer;
	private String number;
	private Date dateOper;
	private String codeCompany;
	
	private String codeOper1;
	private String textOper1;
	private double qttOper1;
	private double priceOper1;
	private double ivaOper1;
	
	private String codeOper2;
	private String textOper2;
	private double qttOper2;
	private double priceOper2;
	private double ivaOper2;
	
	private String codeOper3;
	private String textOper3;
	private double qttOper3;
	private double priceOper3;
	private double ivaOper3;
	
	private double baseImponible0;	
	private double baseImponible1;
	private double tipoIva1;
	private double iva1;
	private double baseImponible2;
	private double tipoIva2;
	private double iva2;
	private double baseImponible3;
	private double tipoIva3;
	private double iva3;
	private double tipoRet;
	private double retencion;
	private double totalAlbaran;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getCodeCustomer() {
		return codeCustomer;
	}
	public void setCodeCustomer(String codeCustomer) {
		this.codeCustomer = codeCustomer;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDateOper() {
		return dateOper;
	}
	public void setDateOper(Date dateOper) {
		this.dateOper = dateOper;
	}
	public String getCodeCompany() {
		return codeCompany;
	}
	public void setCodeCompany(String codeCompany) {
		this.codeCompany = codeCompany;
	}
	public String getCodeOper1() {
		return codeOper1;
	}
	public void setCodeOper1(String codeOper1) {
		this.codeOper1 = codeOper1;
	}
	public String getTextOper1() {
		return textOper1;
	}
	public void setTextOper1(String textOper1) {
		this.textOper1 = textOper1;
	}
	public double getQttOper1() {
		return qttOper1;
	}
	public void setQttOper1(double qttOper1) {
		this.qttOper1 = qttOper1;
	}
	public double getPriceOper1() {
		return priceOper1;
	}
	public void setPriceOper1(double priceOper1) {
		this.priceOper1 = priceOper1;
	}
	public double getIvaOper1() {
		return ivaOper1;
	}
	public void setIvaOper1(double ivaOper1) {
		this.ivaOper1 = ivaOper1;
	}
	public String getCodeOper2() {
		return codeOper2;
	}
	public void setCodeOper2(String codeOper2) {
		this.codeOper2 = codeOper2;
	}
	public String getTextOper2() {
		return textOper2;
	}
	public void setTextOper2(String textOper2) {
		this.textOper2 = textOper2;
	}
	public double getQttOper2() {
		return qttOper2;
	}
	public void setQttOper2(double qttOper2) {
		this.qttOper2 = qttOper2;
	}
	public double getPriceOper2() {
		return priceOper2;
	}
	public void setPriceOper2(double priceOper2) {
		this.priceOper2 = priceOper2;
	}
	public double getIvaOper2() {
		return ivaOper2;
	}
	public void setIvaOper2(double ivaOper2) {
		this.ivaOper2 = ivaOper2;
	}
	public String getCodeOper3() {
		return codeOper3;
	}
	public void setCodeOper3(String codeOper3) {
		this.codeOper3 = codeOper3;
	}
	public String getTextOper3() {
		return textOper3;
	}
	public void setTextOper3(String textOper3) {
		this.textOper3 = textOper3;
	}
	public double getQttOper3() {
		return qttOper3;
	}
	public void setQttOper3(double qttOper3) {
		this.qttOper3 = qttOper3;
	}
	public double getPriceOper3() {
		return priceOper3;
	}
	public void setPriceOper3(double priceOper3) {
		this.priceOper3 = priceOper3;
	}
	public double getIvaOper3() {
		return ivaOper3;
	}
	public void setIvaOper3(double ivaOper3) {
		this.ivaOper3 = ivaOper3;
	}
	public double getBaseImponible0() {
		return baseImponible0;
	}
	public void setBaseImponible0(double baseImponible0) {
		this.baseImponible0 = baseImponible0;
	}
	public double getBaseImponible1() {
		return baseImponible1;
	}
	public void setBaseImponible1(double baseImponible1) {
		this.baseImponible1 = baseImponible1;
	}
	public double getTipoIva1() {
		return tipoIva1;
	}
	public void setTipoIva1(double tipoIva1) {
		this.tipoIva1 = tipoIva1;
	}
	public double getIva1() {
		return iva1;
	}
	public void setIva1(double iva1) {
		this.iva1 = iva1;
	}
	public double getBaseImponible2() {
		return baseImponible2;
	}
	public void setBaseImponible2(double baseImponible2) {
		this.baseImponible2 = baseImponible2;
	}
	public double getTipoIva2() {
		return tipoIva2;
	}
	public void setTipoIva2(double tipoIva2) {
		this.tipoIva2 = tipoIva2;
	}
	public double getIva2() {
		return iva2;
	}
	public void setIva2(double iva2) {
		this.iva2 = iva2;
	}
	public double getBaseImponible3() {
		return baseImponible3;
	}
	public void setBaseImponible3(double baseImponible3) {
		this.baseImponible3 = baseImponible3;
	}
	public double getTipoIva3() {
		return tipoIva3;
	}
	public void setTipoIva3(double tipoIva3) {
		this.tipoIva3 = tipoIva3;
	}
	public double getIva3() {
		return iva3;
	}
	public void setIva3(double iva3) {
		this.iva3 = iva3;
	}
	public double getTipoRet() {
		return tipoRet;
	}
	public void setTipoRet(double tipoRet) {
		this.tipoRet = tipoRet;
	}
	public double getRetencion() {
		return retencion;
	}
	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}
	public double getTotalAlbaran() {
		return totalAlbaran;
	}
	public void setTotalAlbaran(double totalAlbaran) {
		this.totalAlbaran = totalAlbaran;
	}
	
	
	
	
	

}
