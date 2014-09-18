package beansModels;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class DatosFactura {
	
	/*
	 * No usada, solo descriptiva
	 * codeOpers -------> codigo de los albaranes facturados
	 * codeProduct -----> codigo del producto facturado
	 * nameProduct -----> texto del producto facturado 
	 * qttProduct ------> cantidad del producto facturado
	 * priceProduct ----> precio sin iva del producto facturado
	 * ivaProduct ------> tipo de iva del producto facturado
	 */
	
	private String codeOpers;
	private String codeProduct;
	private String nameProduct;
	private double qttProduct;
	private double priceProduct;
	private double ivaProduct;
	
	
	public String getCodeOpers() {
		return codeOpers;
	}
	public void setCodeOpers(String codeOpers) {
		this.codeOpers = codeOpers;
	}
	public String getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getQttProduct() {
		return qttProduct;
	}
	public void setQttProduct(double qttProduct) {
		this.qttProduct = qttProduct;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}
	public double getIvaProduct() {
		return ivaProduct;
	}
	public void setIvaProduct(double ivaProduct) {
		this.ivaProduct = ivaProduct;
	}

}
