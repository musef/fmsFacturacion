package beansModels;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class Facturas implements Serializable {

	/*
	 * id --------------> identificador de la grabacion
	 * number ----------> numero de la factura
	 * serial ----------> serie de facturacion
	 * dateF -----------> fecha de la factura 
	 * 
	 * codeCompany -----> codigo de la compañia que factura
	 * nameCompany -----> nombre de la compañia que factura
	 * addressCompany --> direccion de la compañia que factura
	 * postalCompany ---> código postal de la compañia que factura
	 * cityCompany -----> localidad de la compañia que factura
	 * nifCompany ------> nif de la compañia que factura
	 * 
	 * codeCustomer ----> codigo del cliente
	 * nameCustomer ----> nombre del cliente
	 * addressCustomer -> direccion del cliente
	 * postalCustomer --> codigo postal del cliente
	 * cityCustomer ----> localidad del cliente
	 * nifCustomer -----> nif del cliente
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
	 * totalFactura ----> importe total a pagar
	 * formaPago -------> forma de pago
	 * diaPago ---------> dia de pago
	 * 
	 *  EN FORMATO DE LIST <==> DatosFactura object
	 * codeOpers -------> codigo de los albaranes facturados
	 * codeProduct -----> codigo del producto facturado
	 * nameProduct -----> texto del producto facturado 
	 * qttProduct ------> cantidad del producto facturado
	 * priceProduct ----> precio sin iva del producto facturado
	 * ivaProduct ------> tipo de iva del producto facturado
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String number;
	private String serial;
	private Date dateF;
	
	private String codeCompany;
	private String nameCompany;
	private String addressCompany;
	private String postalCompany;
	private String cityCompany;
	private String nifCompany;
	
	private String codeCustomer;
	private String nameCustomer;
	private String addressCustomer;
	private String postalCustomer;
	private String cityCustomer;
	private String nifCustomer;

	private List<String[]>dataInvoice;
	/*
	private String codeOpers;
	private String codeProduct;
	private String nameProduct;
	private double qttProduct;
	private double priceProduct;
	private double ivaProduct;
	 */
	
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
	private double totalFactura;
	private String formaPago;
	private String diaPago;
	
	
	
	//private String codePay;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public String getCodeCompany() {
		return codeCompany;
	}
	public void setCodeCompany(String codeCompany) {
		this.codeCompany = codeCompany;
	}
	public String getCodeCustomer() {
		return codeCustomer;
	}
	public void setCodeCustomer(String codeCustomer) {
		this.codeCustomer = codeCustomer;
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
	public double getIva3() {
		return iva3;
	}
	public void setIva3(double iva3) {
		this.iva3 = iva3;
	}
	public double getRetencion() {
		return retencion;
	}
	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}
	public double getTotalFactura() {
		return totalFactura;
	}
	public void setTotalFactura(double totalFactura) {
		this.totalFactura = totalFactura;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/*
	public String getCodePay() {
		return codePay;
	}
	public void setCodePay(String codePay) {
		this.codePay = codePay;
	}
	*/
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public String getAddressCompany() {
		return addressCompany;
	}
	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}
	public String getPostalCompany() {
		return postalCompany;
	}
	public void setPostalCompany(String postalCompany) {
		this.postalCompany = postalCompany;
	}
	public String getCityCompany() {
		return cityCompany;
	}
	public void setCityCompany(String cityCompany) {
		this.cityCompany = cityCompany;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getAddressCustomer() {
		return addressCustomer;
	}
	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}
	public String getPostalCustomer() {
		return postalCustomer;
	}
	public void setPostalCustomer(String postalCustomer) {
		this.postalCustomer = postalCustomer;
	}
	public String getCityCustomer() {
		return cityCustomer;
	}
	public void setCityCustomer(String cityCustomer) {
		this.cityCustomer = cityCustomer;
	}
	public List<String[]> getDataInvoice() {
		return dataInvoice;
	}
	public void setDataInvoice(List<String[]> dataInvoice) {
		this.dataInvoice = dataInvoice;
	}
	public double getTipoIva1() {
		return tipoIva1;
	}
	public void setTipoIva1(double tipoIva1) {
		this.tipoIva1 = tipoIva1;
	}
	public double getTipoIva2() {
		return tipoIva2;
	}
	public void setTipoIva2(double tipoIva2) {
		this.tipoIva2 = tipoIva2;
	}
	public double getTipoIva3() {
		return tipoIva3;
	}
	public void setTipoIva3(double tipoIva3) {
		this.tipoIva3 = tipoIva3;
	}
	public double getTipoRet() {
		return tipoRet;
	}
	public void setTipoRet(double tipoRet) {
		this.tipoRet = tipoRet;
	}
	public String getDiaPago() {
		return diaPago;
	}
	public void setDiaPago(String diaPago) {
		this.diaPago = diaPago;
	}
	public String getNifCompany() {
		return nifCompany;
	}
	public void setNifCompany(String nifCompany) {
		this.nifCompany = nifCompany;
	}
	public String getNifCustomer() {
		return nifCustomer;
	}
	public void setNifCustomer(String nifCustomer) {
		this.nifCustomer = nifCustomer;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	

}
