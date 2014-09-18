package beansModels;

import java.io.Serializable;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class TiposIva implements Serializable {

	/*
	 * idIva ---------> identificador del IVA
	 * activeIva -----> inactivo o activo (0=inactivo, 1=activo)
	 * nameIva -------> Denominación del tipo de IVA
	 * rateIva -------> Tipo del IVA, en porcentaje
	 * typeIva -------> Iva para clientes o proveedores (1 o 2)
	 * classIva ------> Clase de iva (0=exento, 1=superreducido, 2=reducido, 3=general)
	 * accIva --------> Cuenta contable para IVA
	 */

	private static final long serialVersionUID = 1L;
	
	private long idIva;
	private int activeIva;
	private String nameIva;
	private double rateIva;
	private int typeIva;
	private int classIva;
	private String accIva;
	
	
	
	public long getIdIva() {
		return idIva;
	}
	public void setIdIva(long idIva) {
		this.idIva = idIva;
	}
	public double getRateIva() {
		return rateIva;
	}
	public void setRateIva(double rateIva) {
		this.rateIva = rateIva;
	}
	public String getNameIva() {
		return nameIva;
	}
	public void setNameIva(String nameIva) {
		this.nameIva = nameIva;
	}
	public int getTypeIva() {
		return typeIva;
	}
	public void setTypeIva(int typeIva) {
		this.typeIva = typeIva;
	}
	public String getAccIva() {
		return accIva;
	}
	public void setAccIva(String accIva) {
		this.accIva = accIva;
	}
	public int getActiveIva() {
		return activeIva;
	}
	public void setActiveIva(int activeIva) {
		this.activeIva = activeIva;
	}
	public int getClassIva() {
		return classIva;
	}
	public void setClassIva(int classIva) {
		this.classIva = classIva;
	}

	
	
} // ************* END OF CLASS
