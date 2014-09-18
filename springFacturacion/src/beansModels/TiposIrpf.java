package beansModels;

import java.io.Serializable;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class TiposIrpf implements Serializable {

	/*
	 * id--------------> identificador del irpf
	 * activeIrpf -----> inactivo o activo (0=inactivo, 1=activo)
	 * nameIrpf -------> Denominación del tipo de Irpf
	 * rateIrpf -------> Tipo del Irpf, en porcentaje
	 * typeIrpf -------> Irpf para clientes o de proveedores (1 o 2)
	 * accIrpf --------> Cuenta contable para IRPF
	 */
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private int activeIrpf;
	private String nameIrpf;
	private double rateIrpf;
	private int typeIrpf;
	private String accIrpf;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getActiveIrpf() {
		return activeIrpf;
	}
	public void setActiveIrpf(int activeIrpf) {
		this.activeIrpf = activeIrpf;
	}
	public String getNameIrpf() {
		return nameIrpf;
	}
	public void setNameIrpf(String nameIrpf) {
		this.nameIrpf = nameIrpf;
	}
	public double getRateIrpf() {
		return rateIrpf;
	}
	public void setRateIrpf(double rateIrpf) {
		this.rateIrpf = rateIrpf;
	}
	public int getTypeIrpf() {
		return typeIrpf;
	}
	public void setTypeIrpf(int typeIrpf) {
		this.typeIrpf = typeIrpf;
	}
	public String getAccIrpf() {
		return accIrpf;
	}
	public void setAccIrpf(String accIrpf) {
		this.accIrpf = accIrpf;
	}
	
	
} // *********** END OF CLASS
