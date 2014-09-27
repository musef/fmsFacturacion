package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.ClientesBean;
import beansModels.Clientes;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestClientesBean {

	@Before
	public void setUp() throws Exception {
	}



	@Test
	public void testCreateCustomer() {

		ClientesBean tipo=new ClientesBean();
		File mainFile=new File(""+"TestdatosCust1.txt");
		// comprueba si el fichero ivas existe
		if (!mainFile.exists()) {
			// si no existe el fichero de users, trata de crearlo
			try {
				mainFile.createNewFile();
			} catch (IOException e) {
				// sale con null si hay error
				e.printStackTrace();
			}
		}
			
		tipo.setMainFile(mainFile);	
		
		Clientes cust=new Clientes();
		cust.setId(1);
		cust.setCustomerName("PEPE");
		cust.setCustomerKey("23ERRE");
		cust.setCustomerAddress("");
		cust.setCustomerCity("");
		cust.setCustomerCP("");
		cust.setCustomerNIF("A28000000");
		cust.setPayment(0);
		cust.setTaxAddress("");
		cust.setTaxCity("");
		cust.setTaxCP("");
		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", tipo.createCustomer(null));
		
		assertFalse("objeto empty", tipo.createCustomer(new Clientes()));
		
		assertTrue("cliente correcto para grabar", tipo.createCustomer(cust));
		
		tipo.eraseCustomer("1");
		
	}

	@Test
	public void testEraseCustomer() {
		
		ClientesBean tipo=new ClientesBean();
		File mainFile=new File(""+"TestdatosCust2.txt");
		// comprueba si el fichero ivas existe
		if (!mainFile.exists()) {
			// si no existe el fichero de users, trata de crearlo
			try {
				mainFile.createNewFile();
			} catch (IOException e) {
				// sale con null si hay error
				e.printStackTrace();
			}
		}
			
		tipo.setMainFile(mainFile);	
		
		Clientes cust=new Clientes();
		cust.setId(1);
		cust.setCustomerName("PEPE");
		cust.setCustomerKey("23ERRE");
		cust.setCustomerAddress("");
		cust.setCustomerCity("");
		cust.setCustomerCP("");
		cust.setCustomerNIF("A28000000");
		cust.setPayment(0);
		cust.setTaxAddress("");
		cust.setTaxCity("");
		cust.setTaxCP("");
		
		tipo.createCustomer(cust);
		
		assertFalse("key NULL", tipo.eraseCustomer(null));
		assertFalse("key empty", tipo.eraseCustomer(""));
		assertFalse("key incorrecta", tipo.eraseCustomer("9999"));
		assertTrue("cliente correcto para borrar", tipo.eraseCustomer("23ERRE"));

	}

	
	
	@Test
	public void testModifyCustomer() {

		ClientesBean tipo=new ClientesBean();
		File mainFile=new File(""+"TestdatosCust3.txt");
		// comprueba si el fichero ivas existe
		if (!mainFile.exists()) {
			// si no existe el fichero de users, trata de crearlo
			try {
				mainFile.createNewFile();
			} catch (IOException e) {
				// sale con null si hay error
				e.printStackTrace();
			}
		}
			
		tipo.setMainFile(mainFile);	
		
		String customerKey="23ERRE";
		
		Clientes cust=new Clientes();
		cust.setId(1);
		cust.setCustomerName("PEPE");
		cust.setCustomerKey(customerKey);
		cust.setCustomerAddress("");
		cust.setCustomerCity("");
		cust.setCustomerCP("");
		cust.setCustomerNIF("A28000000");
		cust.setPayment(0);
		cust.setTaxAddress("");
		cust.setTaxCity("");
		cust.setTaxCP("");
		
		tipo.createCustomer(cust);
		
		// se prepara para modificar
		cust.setCustomerName("VAGO TARADO");
		
		assertFalse("objeto null", tipo.modifyCustomer(customerKey, null));	
		assertFalse("objeto empty", tipo.modifyCustomer(customerKey,new Clientes()));
		assertTrue("pago correcto para modificar", tipo.modifyCustomer(customerKey,cust));
	
		// una segunda modificacion
		cust.setCustomerName("VAGO CAPITAN");		
		assertFalse("key incorrecta", tipo.modifyCustomer("9999", cust));
		assertFalse("key NULL", tipo.modifyCustomer(null, cust));
		assertFalse("key empty", tipo.modifyCustomer("", cust));
		// cambia el indice en la modificacion
		assertTrue("pago correcto para modificar", tipo.modifyCustomer(customerKey,cust));
		
		// borramos los datos
		tipo.eraseCustomer("1");
		
	}


	@Test
	public void testGetCustomer() {
	
		ClientesBean tipo=new ClientesBean();
		File mainFile=new File(""+"TestdatosCust4.txt");
		// comprueba si el fichero ivas existe
		if (!mainFile.exists()) {
			// si no existe el fichero de users, trata de crearlo
			try {
				mainFile.createNewFile();
			} catch (IOException e) {
				// sale con null si hay error
				e.printStackTrace();
			}
		}
			
		tipo.setMainFile(mainFile);	
		
		String customerKey="23ERRE";
		
		Clientes cust=new Clientes();
		cust.setId(1);
		cust.setCustomerName("PEPE");
		cust.setCustomerKey(customerKey);
		cust.setCustomerAddress("");
		cust.setCustomerCity("");
		cust.setCustomerCP("");
		cust.setCustomerNIF("A28000000");
		cust.setPayment(0);
		cust.setTaxAddress("");
		cust.setTaxCity("");
		cust.setTaxCP("");
				
		// hay que asegurarse de que no existen datos

		assertNull("No hay datos", tipo.getListCustomers());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1",customerKey,"PEPE","","","","A28000000","0","","",""};
		
		// creamos dato
		tipo.createCustomer(cust);
		
		assertNull("KEY incorrecta",tipo.getCustomer("9999"));
		assertNull("KEY NULL", tipo.getCustomer(null));
		assertNull("KEY empty", tipo.getCustomer(""));

		assertArrayEquals("Cliente correcto localizado", data, tipo.getCustomer(customerKey));
	
		tipo.eraseCustomer("1");
		
	}
	
	
	@Test
	public void testGetListCustomers() {
		
		ClientesBean tipo=new ClientesBean();
		File mainFile=new File(""+"TestdatosCust5.txt");
		// comprueba si el fichero ivas existe
		if (!mainFile.exists()) {
			// si no existe el fichero de users, trata de crearlo
			try {
				mainFile.createNewFile();
			} catch (IOException e) {
				// sale con null si hay error
				e.printStackTrace();
			}
		}
			
		tipo.setMainFile(mainFile);	
		
		String customerKey="23ERRE";
		
		Clientes cust=new Clientes();
		cust.setId(1);
		cust.setCustomerName("PEPE");
		cust.setCustomerKey(customerKey);
		cust.setCustomerAddress("");
		cust.setCustomerCity("");
		cust.setCustomerCP("");
		cust.setCustomerNIF("A28000000");
		cust.setPayment(0);
		cust.setTaxAddress("");
		cust.setTaxCity("");
		cust.setTaxCP("");
				
		// hay que asegurarse de que no existen datos

		assertNull("No hay datos", tipo.getListCustomers());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1",customerKey,"PEPE","","","","A28000000","0","","",""};
		
		// creamos dato
		tipo.createCustomer(cust);
		
		assertNotNull("Ahora si hay datos", tipo.getListCustomers());
		
		assertArrayEquals("La lista retorna los datos", data, tipo.getListCustomers().get(0));
		
		// borramos dato
		tipo.eraseCustomer("1");
		
	}

	
	
	@After
	public void tearDown() throws Exception {
		File fileDup1=new File(""+"TestdatosCust1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosCust2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosCust3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosCust4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosCust5.txt");
		fileDup5.delete();
	}
	
}
