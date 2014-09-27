package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.FacturasBean;
import beansModels.Facturas;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestFacturasBean {

	@Before
	public void setUp() throws Exception {
	}





	@Test
	public void testCreateInvoice() {
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac1.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0);
		datos.setBaseImponible1(0);
		datos.setTipoIva1(0);
		datos.setIva1(0);
		datos.setBaseImponible2(0);
		datos.setTipoIva2(0);
		datos.setIva2(0);
		datos.setBaseImponible3(0);
		datos.setTipoIva3(0);
		datos.setIva3(0);
		datos.setTipoRet(0);
		datos.setRetencion(0);
		datos.setTotalFactura(0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());

		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", fact.createInvoice((null)));
		
		assertFalse("objeto empty", fact.createInvoice(new Facturas()));
		
		assertTrue("Empresa para grabar", fact.createInvoice(datos));
		
		fact.eraseInvoice("1","");
	}

	@Test
	public void testEraseInvoice() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac2.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0);
		datos.setBaseImponible1(0);
		datos.setTipoIva1(0);
		datos.setIva1(0);
		datos.setBaseImponible2(0);
		datos.setTipoIva2(0);
		datos.setIva2(0);
		datos.setBaseImponible3(0);
		datos.setTipoIva3(0);
		datos.setIva3(0);
		datos.setTipoRet(0);
		datos.setRetencion(0);
		datos.setTotalFactura(0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		fact.createInvoice(datos);
		
		assertFalse("id NULL", fact.eraseInvoice(null,""));
		assertFalse("id empty", fact.eraseInvoice("",""));
		assertFalse("id incorrecta", fact.eraseInvoice("9999",""));
		assertFalse("serial null", fact.eraseInvoice("9999",null));
		assertTrue("Factura correcta para borrar", fact.eraseInvoice("1",""));
		
	}

	@Test
	public void testModifyInvoice() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac3.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0);
		datos.setBaseImponible1(0);
		datos.setTipoIva1(0);
		datos.setIva1(0);
		datos.setBaseImponible2(0);
		datos.setTipoIva2(0);
		datos.setIva2(0);
		datos.setBaseImponible3(0);
		datos.setTipoIva3(0);
		datos.setIva3(0);
		datos.setTipoRet(0);
		datos.setRetencion(0);
		datos.setTotalFactura(0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		fact.createInvoice(datos);
		
		// se prepara para modificar
		datos.setNameCustomer("OTRA EMPRESA");
		
		assertFalse("todos datos incorrectos", fact.modifyInvoice("9999", "asd",null));
		assertFalse("numero incorrecto", fact.modifyInvoice("9999", "",datos));
		assertFalse("numero NULL", fact.modifyInvoice(null, "",datos));
		assertFalse("numero empty", fact.modifyInvoice("", "",datos));
		assertFalse("serial NULL", fact.modifyInvoice("1",null,datos));
		assertFalse("objeto NULL", fact.modifyInvoice("1", "",null));
		assertFalse("objeto empty", fact.modifyInvoice("1", "",new Facturas()));
		
		assertTrue("Modificación realizada correctamente", fact.modifyInvoice("1", "",datos));
		
		// borramos los datos
		fact.eraseInvoice("1","");
		
	}

	@Test
	public void testGetInvoice() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac4.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setId(1);
		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0.0);
		datos.setBaseImponible1(0.0);
		datos.setTipoIva1(0.0);
		datos.setIva1(0.0);
		datos.setBaseImponible2(0.0);
		datos.setTipoIva2(0.0);
		datos.setIva2(0.0);
		datos.setBaseImponible3(0.0);
		datos.setTipoIva3(0.0);
		datos.setIva3(0.0);
		datos.setTipoRet(0.0);
		datos.setRetencion(0.0);
		datos.setTotalFactura(0.0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		fact.createInvoice(datos);
		
		assertNull("numero incorrecta",fact.getInvoice("9999"));
		assertNull("numero NULL", fact.getInvoice(null));
		assertNull("numero empty", fact.getInvoice(""));

		Facturas newFactura=new Facturas();
		fact.setFactura(newFactura);
		assertEquals("Factura correcto localizado",datos.getNumber(),fact.getInvoice("1").getNumber());
		assertEquals("Factura correcto localizado",datos.getId(),fact.getInvoice("1").getId());
		assertEquals("Factura correcto localizado",datos.getDataInvoice(),fact.getInvoice("1").getDataInvoice());
		assertEquals("Factura correcto localizado",datos.getDateF(),fact.getInvoice("1").getDateF());
		assertEquals("Factura correcto localizado",datos.getBaseImponible0(),fact.getInvoice("1").getBaseImponible0(),0);
		assertEquals("Factura correcto localizado",datos.getTotalFactura(),fact.getInvoice("1").getTotalFactura(),0);
	
		// borramos los datos
		fact.eraseInvoice("1","");
		
	}
	
	

	@Test
	public void testGetInvoiceById() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac5.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setId(1);
		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0.0);
		datos.setBaseImponible1(0.0);
		datos.setTipoIva1(0.0);
		datos.setIva1(0.0);
		datos.setBaseImponible2(0.0);
		datos.setTipoIva2(0.0);
		datos.setIva2(0.0);
		datos.setBaseImponible3(0.0);
		datos.setTipoIva3(0.0);
		datos.setIva3(0.0);
		datos.setTipoRet(0.0);
		datos.setRetencion(0.0);
		datos.setTotalFactura(0.0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		fact.createInvoice(datos);
		
		assertNull("id incorrecta",fact.getInvoiceById("9999"));
		assertNull("id NULL", fact.getInvoiceById(null));
		assertNull("id empty", fact.getInvoiceById(""));

		Facturas newFactura=new Facturas();
		fact.setFactura(newFactura);
		assertEquals("Factura correcto localizado",datos.getNumber(),fact.getInvoiceById("1").getNumber());
		assertEquals("Factura correcto localizado",datos.getId(),fact.getInvoiceById("1").getId());
		assertEquals("Factura correcto localizado",datos.getDataInvoice(),fact.getInvoiceById("1").getDataInvoice());
		assertEquals("Factura correcto localizado",datos.getDateF(),fact.getInvoiceById("1").getDateF());
		assertEquals("Factura correcto localizado",datos.getBaseImponible0(),fact.getInvoiceById("1").getBaseImponible0(),0);
		assertEquals("Factura correcto localizado",datos.getTotalFactura(),fact.getInvoiceById("1").getTotalFactura(),0);
	
		// borramos los datos
		fact.eraseInvoice("1","");
	}

	
	
	@Test
	public void testSearchAllInvoiceNumber() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac6.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setId(1);
		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("332564");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0.0);
		datos.setBaseImponible1(0.0);
		datos.setTipoIva1(0.0);
		datos.setIva1(0.0);
		datos.setBaseImponible2(0.0);
		datos.setTipoIva2(0.0);
		datos.setIva2(0.0);
		datos.setBaseImponible3(0.0);
		datos.setTipoIva3(0.0);
		datos.setIva3(0.0);
		datos.setTipoRet(0.0);
		datos.setRetencion(0.0);
		datos.setTotalFactura(0.0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",fact.searchAllInvoiceNumber());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1","1","332564"};
		
		// creamos dato
		fact.createInvoice(datos);
		
		assertNotNull("Ahora si hay datos",fact.searchAllInvoiceNumber());
		
		assertArrayEquals("La lista retorna los datos", data, fact.searchAllInvoiceNumber().get(0));
		
		// borramos los datos
		fact.eraseInvoice("1","");
	}
	
	

	@Test
	public void testSearchExtractInvoices() {
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac7.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura

		datos.setId(1);
		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer("");
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0.0);
		datos.setBaseImponible1(0.0);
		datos.setTipoIva1(0.0);
		datos.setIva1(0.0);
		datos.setBaseImponible2(0.0);
		datos.setTipoIva2(0.0);
		datos.setIva2(0.0);
		datos.setBaseImponible3(0.0);
		datos.setTipoIva3(0.0);
		datos.setIva3(0.0);
		datos.setTipoRet(0.0);
		datos.setRetencion(0.0);
		datos.setTotalFactura(0.0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",fact.searchExtractInvoices());
		
		// ahora creamos datos y los insertamos
		fact.createInvoice(datos);
		String data[]={"1","1","","2014-01-01","121212","EMPRESA","","28000","","A28000000","","","","","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","",""};
		
		assertNotNull("Ahora si hay datos",fact.searchExtractInvoices());
		
		assertArrayEquals("La lista retorna los datos", data, fact.searchExtractInvoices().get(0));
		
		// borramos los datos
		fact.eraseInvoice("1","");
		
	}

	@Test
	public void testSearchExtractInvoicesByCustomers() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac8.txt");
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
			
		fact.setMainFile(mainFile);	
		
		Facturas datos=new Facturas();
		// creacion del objeto factura
		String codeCust="AA245";
		
		datos.setId(1);
		datos.setNumber("1");
		datos.setSerial("");
		datos.setDateF(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");
		datos.setNameCompany("EMPRESA");
		datos.setAddressCompany("");
		datos.setPostalCompany("28000");
		datos.setCityCompany("");
		datos.setNifCompany("A28000000");		
		datos.setCodeCustomer(codeCust);
		datos.setNameCustomer("");
		datos.setAddressCustomer("");
		datos.setPostalCustomer("");
		datos.setCityCustomer("");
		datos.setNifCustomer("");
		datos.setBaseImponible0(0.0);
		datos.setBaseImponible1(0.0);
		datos.setTipoIva1(0.0);
		datos.setIva1(0.0);
		datos.setBaseImponible2(0.0);
		datos.setTipoIva2(0.0);
		datos.setIva2(0.0);
		datos.setBaseImponible3(0.0);
		datos.setTipoIva3(0.0);
		datos.setIva3(0.0);
		datos.setTipoRet(0.0);
		datos.setRetencion(0.0);
		datos.setTotalFactura(0.0);
		datos.setDiaPago("");
		datos.setFormaPago("");
		datos.setDataInvoice(new ArrayList<String[]>());
		
		List<String[]>cust=new ArrayList<String[]>();
		assertNull("Lista a buscar nula", fact.searchExtractInvoicesByCustomers(null));
		assertNull("Lista a buscar vacía", fact.searchExtractInvoicesByCustomers(cust));
		
		String cust1[]=new String[2];
		cust1[0]="";
		cust1[1]=codeCust;
		cust.add(cust1);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",fact.searchExtractInvoicesByCustomers(cust));
		
		// ahora creamos datos y los insertamos
		fact.createInvoice(datos);
		String data[]={"1","1","","2014-01-01","121212","EMPRESA","","28000","","A28000000",codeCust,"","","","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","",""};
		
		assertNotNull("Ahora si hay datos",fact.searchExtractInvoicesByCustomers(cust));
		
		assertArrayEquals("La lista retorna los datos correctos", data, fact.searchExtractInvoicesByCustomers(cust).get(0));
		
		// borramos los datos
		fact.eraseInvoice("1","");
		
		
	}

	@Test
	public void testSearchExtractInvoicesByOrderCustomers() {
		
		FacturasBean fact=new FacturasBean();
		File mainFile=new File(""+"TestdatosFac9.txt");
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
			
		fact.setMainFile(mainFile);	
		
		// creacion de codigo de clientes
		String codeCust="AA245";
		String codeCust2="BB245";
		
		Facturas datos1=new Facturas();
		// creacion del objeto factura
		datos1.setId(1);
		datos1.setNumber("1");
		datos1.setSerial("");
		datos1.setDateF(Date.valueOf("2014-01-01"));
		datos1.setCodeCompany("121212");
		datos1.setNameCompany("EMPRESA");
		datos1.setAddressCompany("");
		datos1.setPostalCompany("28000");
		datos1.setCityCompany("");
		datos1.setNifCompany("A28000000");		
		datos1.setCodeCustomer(codeCust);
		datos1.setNameCustomer("");
		datos1.setAddressCustomer("");
		datos1.setPostalCustomer("");
		datos1.setCityCustomer("");
		datos1.setNifCustomer("");
		datos1.setBaseImponible0(0.0);
		datos1.setBaseImponible1(0.0);
		datos1.setTipoIva1(0.0);
		datos1.setIva1(0.0);
		datos1.setBaseImponible2(0.0);
		datos1.setTipoIva2(0.0);
		datos1.setIva2(0.0);
		datos1.setBaseImponible3(0.0);
		datos1.setTipoIva3(0.0);
		datos1.setIva3(0.0);
		datos1.setTipoRet(0.0);
		datos1.setRetencion(0.0);
		datos1.setTotalFactura(0.0);
		datos1.setDiaPago("");
		datos1.setFormaPago("");
		datos1.setDataInvoice(new ArrayList<String[]>());
		
		Facturas datos2=new Facturas();
		// creacion del objeto factura
		datos2.setId(2);
		datos2.setNumber("2");
		datos2.setSerial("");
		datos2.setDateF(Date.valueOf("2014-01-02"));
		datos2.setCodeCompany("121212");
		datos2.setNameCompany("EMPRESA");
		datos2.setAddressCompany("");
		datos2.setPostalCompany("28000");
		datos2.setCityCompany("");
		datos2.setNifCompany("A28000000");		
		datos2.setCodeCustomer(codeCust2);
		datos2.setNameCustomer("");
		datos2.setAddressCustomer("");
		datos2.setPostalCustomer("");
		datos2.setCityCustomer("");
		datos2.setNifCustomer("");
		datos2.setBaseImponible0(0.0);
		datos2.setBaseImponible1(0.0);
		datos2.setTipoIva1(0.0);
		datos2.setIva1(0.0);
		datos2.setBaseImponible2(0.0);
		datos2.setTipoIva2(0.0);
		datos2.setIva2(0.0);
		datos2.setBaseImponible3(0.0);
		datos2.setTipoIva3(0.0);
		datos2.setIva3(0.0);
		datos2.setTipoRet(0.0);
		datos2.setRetencion(0.0);
		datos2.setTotalFactura(0.0);
		datos2.setDiaPago("");
		datos2.setFormaPago("");
		datos2.setDataInvoice(new ArrayList<String[]>());
		
		Facturas datos3=new Facturas();
		// creacion del objeto factura
		datos3.setId(3);
		datos3.setNumber("3");
		datos3.setSerial("");
		datos3.setDateF(Date.valueOf("2014-01-03"));
		datos3.setCodeCompany("121212");
		datos3.setNameCompany("EMPRESA");
		datos3.setAddressCompany("");
		datos3.setPostalCompany("28000");
		datos3.setCityCompany("");
		datos3.setNifCompany("A28000000");		
		datos3.setCodeCustomer(codeCust);
		datos3.setNameCustomer("");
		datos3.setAddressCustomer("");
		datos3.setPostalCustomer("");
		datos3.setCityCustomer("");
		datos3.setNifCustomer("");
		datos3.setBaseImponible0(0.0);
		datos3.setBaseImponible1(0.0);
		datos3.setTipoIva1(0.0);
		datos3.setIva1(0.0);
		datos3.setBaseImponible2(0.0);
		datos3.setTipoIva2(0.0);
		datos3.setIva2(0.0);
		datos3.setBaseImponible3(0.0);
		datos3.setTipoIva3(0.0);
		datos3.setIva3(0.0);
		datos3.setTipoRet(0.0);
		datos3.setRetencion(0.0);
		datos3.setTotalFactura(0.0);
		datos3.setDiaPago("");
		datos3.setFormaPago("");
		datos3.setDataInvoice(new ArrayList<String[]>());
		
		List<String[]>cust=new ArrayList<String[]>();
		assertNull("Lista a buscar nula", fact.searchExtractInvoicesByOrderCustomers(null));
		assertNull("Lista a buscar vacía", fact.searchExtractInvoicesByOrderCustomers(cust));
		
		String cust1[]=new String[2];
		cust1[0]="";
		cust1[1]=codeCust;
		cust.add(cust1);
		
		String cust2[]=new String[2];
		cust2[0]="";
		cust2[1]=codeCust2;
		cust.add(cust2);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",fact.searchExtractInvoicesByOrderCustomers(cust));
		
		// ahora creamos datos y los insertamos
		fact.createInvoice(datos1);		
		assertNotNull("Ahora si hay datos",fact.searchExtractInvoicesByOrderCustomers(cust));
		
		// deberia ordenar el datos2 en tercer lugar, por orden de cliente, y el datos3 en segundo lugar junto con el datos1
		fact.createInvoice(datos2);
		fact.createInvoice(datos3);
		String data[]={"2","2","","2014-01-02","121212","EMPRESA","","28000","","A28000000",codeCust2,"","","","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","",""};

		assertArrayEquals("La lista retorna los datos correctos", data, fact.searchExtractInvoicesByOrderCustomers(cust).get(2));
		
		// borramos los datos
		fact.eraseInvoice("1","");
		fact.eraseInvoice("2","");
		fact.eraseInvoice("3","");
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		File fileDup1=new File(""+"TestdatosFac1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosFac2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosFac3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosFac4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosFac5.txt");
		fileDup5.delete();
		File fileDup6=new File(""+"TestdatosFac6.txt");
		fileDup6.delete();
		File fileDup7=new File(""+"TestdatosFac7.txt");
		fileDup7.delete();
		File fileDup8=new File(""+"TestdatosFac8.txt");
		fileDup8.delete();
		File fileDup9=new File(""+"TestdatosFac9.txt");
		fileDup9.delete();
	}

}
