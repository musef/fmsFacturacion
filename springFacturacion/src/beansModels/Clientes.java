package beansModels;

import java.io.Serializable;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class Clientes implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private long id;
	private String customerKey;
	private String customerName;
	private String customerAddress;
	private String customerCP;
	private String customerCity;
	private String customerNIF;
	
	private long payment;
	private String taxAddress;
	private String taxCP;
	private String taxCity;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerCP() {
		return customerCP;
	}
	public void setCustomerCP(String customerCP) {
		this.customerCP = customerCP;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerNIF() {
		return customerNIF;
	}
	public void setCustomerNIF(String customerNIF) {
		this.customerNIF = customerNIF;
	}
	public long getPayment() {
		return payment;
	}
	public void setPayment(long payment) {
		this.payment = payment;
	}
	public String getTaxAddress() {
		return taxAddress;
	}
	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}
	public String getTaxCP() {
		return taxCP;
	}
	public void setTaxCP(String taxCP) {
		this.taxCP = taxCP;
	}
	public String getTaxCity() {
		return taxCity;
	}
	public void setTaxCity(String taxCity) {
		this.taxCity = taxCity;
	}
	
	

} // ************************ END OF CLASS
