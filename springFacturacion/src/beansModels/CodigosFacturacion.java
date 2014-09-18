package beansModels;

import java.io.Serializable;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class CodigosFacturacion implements Serializable {

	/*
	 * code -------> codigo de facturacion
	 * codeText ---> Texto del codigo
	 * amount -----> Importe correspondiente al codigo (not required)
	 * ivaCode ----> codigo del iva que corresponda (not required)
	 */

	private static final long serialVersionUID = 1L;
	private String code;
	private String codeText;
	private double amount;
	private int ivaCode;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeText() {
		return codeText;
	}
	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getIvaCode() {
		return ivaCode;
	}
	public void setIvaCode(int ivaCode) {
		this.ivaCode = ivaCode;
	}

} // ************* END OF CLASS
