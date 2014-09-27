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

import beansControls.AlbaranesBean;
import beansModels.Albaranes;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */


public class TestAlbaranesBean {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testCreateDelivery() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb1.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("1");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", alb.createDelivery(null));
		
		assertFalse("objeto empty", alb.createDelivery(new Albaranes()));
		
		assertTrue("Empresa para grabar", alb.createDelivery(datos));
		
		
		alb.eraseDelivery("1");
	}

	
	@Test
	public void testEraseDelivery() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb2.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("1");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
		
		assertFalse("id NULL", alb.eraseDelivery(null));
		assertFalse("id empty", alb.eraseDelivery(""));
		assertFalse("id incorrecta", alb.eraseDelivery("9999"));
		assertTrue("Factura correcta para borrar", alb.eraseDelivery("1"));
		
	}

	
	@Test
	public void testModifyDelivery() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb3.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("1");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
		
		// se prepara para modificar
		datos.setBaseImponible0(1);
		
		assertFalse("todos datos incorrectos", alb.modifyDelivery("9999", null));
		assertFalse("numero incorrecto", alb.modifyDelivery("9999", datos));
		assertFalse("numero NULL", alb.modifyDelivery(null, datos));
		assertFalse("numero empty", alb.modifyDelivery("", datos));
		assertFalse("objeto NULL", alb.modifyDelivery("1", null));
		assertFalse("objeto empty", alb.modifyDelivery("1", new Albaranes()));
		
		// se crea para suplantar spring
		Albaranes newAlbaran=new Albaranes();
		alb.setAlbaran(newAlbaran);
		
		assertTrue("Modificación realizada correctamente", alb.modifyDelivery("1", datos));
		
		// borramos los datos
		alb.eraseDelivery("1");
		
	}

	
	@Test
	public void testChangeToInvoicedState() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb4.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
		
		// se prepara para modificar
		datos.setBaseImponible0(1);
		
		assertFalse("todos datos incorrectos", alb.changeToInvoicedState("9999", null));
		assertFalse("numero incorrecto", alb.changeToInvoicedState("9999", "1"));
		assertFalse("numero NULL", alb.changeToInvoicedState(null, "1"));
		assertFalse("numero empty", alb.changeToInvoicedState("", "1"));
		assertFalse("factura NULL", alb.changeToInvoicedState("1",null));
		assertFalse("factura empty", alb.changeToInvoicedState("1",""));
		
		// se crea para suplantar spring
		Albaranes newAlbaran=new Albaranes();
		alb.setAlbaran(newAlbaran);
		
		assertTrue("Modificación realizada correctamente", alb.changeToInvoicedState("1", "1"));
		
		// borramos los datos
		alb.eraseDelivery("1");
		
	}

	
	@Test
	public void testChangeToPendingState() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb5.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
		
		// se prepara para modificar
		datos.setBaseImponible0(1);
		
		assertFalse("numero incorrecto", alb.changeToPendingState("9999"));
		assertFalse("numero NULL", alb.changeToPendingState(null));
		assertFalse("numero empty", alb.changeToPendingState(""));
		
		// se crea para suplantar spring
		alb.setAlbaran(datos);
		
		// al emplear el metodo este dato se pone en empty
		datos.setInvoice("");
		
		assertTrue("Modificación realizada correctamente", alb.changeToPendingState("1"));
		assertEquals("Modificación realizada correctamente", datos, alb.getDelivery("1"));
		
		// borramos los datos
		alb.eraseDelivery("1");
		
	}

	
	@Test
	public void testGetDelivery() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb6.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
		
		assertNull("numero incorrecto",alb.getDelivery("9999"));
		assertNull("numero NULL", alb.getDelivery(null));
		assertNull("numero empty", alb.getDelivery(""));
		
	
		// se crea para suplantar spring
		alb.setAlbaran(datos);
		assertEquals("Albaran correcto localizado",datos,alb.getDelivery("1"));

		// borramos los datos
		alb.eraseDelivery("1");
	}

	
	@Test
	public void testGetNextNumber() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb7.txt");
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
		
		alb.setMainFile(mainFile);
		
		// PRIMERO SE TESTEA EL FICHERO VACIO
		assertTrue("fichero vacio", 1==alb.getNextNumber());

		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		long idTest=1;
		datos.setId(idTest);
		datos.setInvoice("");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		alb.createDelivery(datos);
			
		// AHORA SE TESTEA EL FICHERO CON UN DATO
		long valueToTest=idTest;
		valueToTest++;
		assertTrue("fichero con un dato", valueToTest==alb.getNextNumber());
		
		// GRABAMOS OTRO DATO PARA TESTEO 
		
		idTest=2;
		datos.setNumber("2");
		alb.createDelivery(datos);
		
		// SEGUNDO TESTEO
		valueToTest=idTest;
		valueToTest++;
		assertTrue("fichero con OTRO dato", valueToTest==alb.getNextNumber());
		
		
	}
	
	
	
	@Test
	public void testSearchAllDeliveries() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb8.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",alb.searchAllDeliveries());
		
		// ahora creamos datos para comparacion
		String data[]={"1","","","1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
				
		// creamos dato
		alb.createDelivery(datos);
		
		// comprobamos grabaciones
		assertNotNull("Ahora si hay datos",alb.searchAllDeliveries());
		assertArrayEquals("La lista retorna los datos", data, alb.searchAllDeliveries().get(0));
		
		// ahora creamos otro dato
		datos.setTotalAlbaran(12.10);
		alb.createDelivery(datos);
		
		// ahora creamos datos para comparacion
		String data2[]={"2","","","1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","12.1"};

		// comprobamos grabaciones
		assertArrayEquals("La lista retorna los datos", data2, alb.searchAllDeliveries().get(1));
		assertTrue("La lista tiene los 2 datos", 2==alb.searchAllDeliveries().size());
				
		// borramos los datos
		alb.eraseDelivery("1");
		
	}

	@Test
	public void testSearchAllDeliveriesCustomers() {
		
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb8.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("P2MASK2");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		// CREAMOS LA LISTA DE CLIENTES
		List<String[]>customSel=new ArrayList<String[]>();
		String cust1[]={"P2MASK2","LUISETE"};
		String cust2[]={"R2DEDOS","MANOLETE"};
		customSel.add(cust1);
		customSel.add(cust2);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",alb.searchAllDeliveriesCustomers(customSel));
		
		// ahora creamos datos para comparacion
		String data[]={"1","",cust1[1],"1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
				
		// creamos dato
		alb.createDelivery(datos);
		
		// comprobamos grabaciones
		assertNull("Lista de clientes nula", alb.searchAllDeliveriesCustomers(null));
		assertNull("Lista de clientes vacia", alb.searchAllDeliveriesCustomers(new ArrayList<String[]>()));
		assertNotNull("Ahora si hay datos",alb.searchAllDeliveriesCustomers(customSel));
		assertArrayEquals("La lista retorna los datos", data, alb.searchAllDeliveriesCustomers(customSel).get(0));
		
		// ahora creamos otro dato
		datos.setCodeCustomer(cust2[0]);
		datos.setTotalAlbaran(12.10);
		alb.createDelivery(datos);
		
		// ahora creamos datos para comparacion
		String data2[]={"2","",cust2[1],"1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","12.1"};

		// comprobamos grabaciones
		assertArrayEquals("La lista retorna los datos", data2, alb.searchAllDeliveriesCustomers(customSel).get(1));
		assertTrue("La lista tiene los 2 datos", 2==alb.searchAllDeliveriesCustomers(customSel).size());
				
		// borramos los datos
		alb.eraseDelivery("1");
		alb.eraseDelivery("2");
	}

	
	@Test
	public void testSearchPendingDeliveriesCustomers() {

		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb8.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("P2MASK2");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		// CREAMOS LA LISTA DE CLIENTES
		List<String[]>customSel=new ArrayList<String[]>();
		String cust1[]={"P2MASK2","LUISETE"};
		String cust2[]={"R2DEDOS","MANOLETE"};
		customSel.add(cust1);
		customSel.add(cust2);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",alb.searchPendingDeliveriesCustomers(customSel));
		
		// ahora creamos datos para comparacion
		String data[]={"1","",cust1[1],"1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
				
		// creamos dato
		alb.createDelivery(datos);
		
		// comprobamos grabaciones
		assertNull("Lista de clientes nula", alb.searchPendingDeliveriesCustomers(null));
		assertNull("Lista de clientes vacia", alb.searchPendingDeliveriesCustomers(new ArrayList<String[]>()));
		assertNotNull("Ahora si hay datos",alb.searchPendingDeliveriesCustomers(customSel));
		assertArrayEquals("La lista retorna los datos", data, alb.searchPendingDeliveriesCustomers(customSel).get(0));
		
		// ahora creamos otro dato
		datos.setCodeCustomer(cust2[0]);
		datos.setNumber("2");
		datos.setTotalAlbaran(12.10);
		alb.createDelivery(datos);
		
		// ahora creamos datos para comparacion
		String data2[]={"2","",cust2[1],"2","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","12.1"};

		// comprobamos grabaciones
		assertArrayEquals("La lista retorna los datos", data2, alb.searchPendingDeliveriesCustomers(customSel).get(1));
		assertTrue("La lista tiene los 2 albaranes pendientes", 2==alb.searchPendingDeliveriesCustomers(customSel).size());
		
		// ahora cambiamos un dato de pendiente a facturado
		datos.setInvoice("1");
		alb.modifyDelivery("1", datos);
		assertTrue("La lista tiene ahora 1 albaran pendiente", 1==alb.searchPendingDeliveriesCustomers(customSel).size());
				
		// borramos los datos
		alb.eraseDelivery("1");
		alb.eraseDelivery("2");
	}

	
	@Test
	public void testSearchInvoicedDeliveriesCustomers() {

		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb8.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("1");
		datos.setCodeCustomer("P2MASK2");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		// CREAMOS LA LISTA DE CLIENTES
		List<String[]>customSel=new ArrayList<String[]>();
		String cust1[]={"P2MASK2","LUISETE"};
		String cust2[]={"R2DEDOS","MANOLETE"};
		customSel.add(cust1);
		customSel.add(cust2);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",alb.searchInvoicedDeliveriesCustomers(customSel));
		
		// ahora creamos datos para comparacion
		String data[]={"1","1",cust1[1],"1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
				
		// creamos dato
		alb.createDelivery(datos);
		
		// comprobamos grabaciones
		assertNull("Lista de clientes nula", alb.searchInvoicedDeliveriesCustomers(null));
		assertNull("Lista de clientes vacia", alb.searchInvoicedDeliveriesCustomers(new ArrayList<String[]>()));
		assertNotNull("Ahora si hay datos",alb.searchInvoicedDeliveriesCustomers(customSel));
		assertArrayEquals("La lista retorna los datos", data, alb.searchInvoicedDeliveriesCustomers(customSel).get(0));
		
		// ahora creamos otro dato
		datos.setCodeCustomer(cust2[0]);
		datos.setNumber("2");
		datos.setInvoice("2");
		datos.setTotalAlbaran(12.10);
		alb.createDelivery(datos);
		
		// ahora creamos datos para comparacion
		String data2[]={"2","2",cust2[1],"2","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","12.1"};

		// comprobamos grabaciones
		assertArrayEquals("La lista retorna los datos", data2, alb.searchInvoicedDeliveriesCustomers(customSel).get(1));
		assertTrue("La lista tiene los 2 albaranes facturados", 2==alb.searchInvoicedDeliveriesCustomers(customSel).size());
		
		// ahora cambiamos un dato de facturado a pendiente
		datos.setInvoice("");
		alb.modifyDelivery("1", datos);
		assertTrue("La lista tiene ahora 1 albaran facturado", 1==alb.searchInvoicedDeliveriesCustomers(customSel).size());
				
		// borramos los datos
		alb.eraseDelivery("1");
		alb.eraseDelivery("2");
		
	}

	
	@Test
	public void testSearchAllDeliveriesPending() {
	
		AlbaranesBean alb=new AlbaranesBean();
		File mainFile=new File(""+"TestdatosAlb9.txt");
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
			
		alb.setMainFile(mainFile);	
		
		Albaranes datos=new Albaranes();
		datos.setId(1);
		datos.setInvoice("");
		datos.setCodeCustomer("P2MASK2");
		datos.setNumber("1");
		datos.setDateOper(Date.valueOf("2014-01-01"));
		datos.setCodeCompany("121212");		
		
		datos.setCodeOper1("");
		datos.setTextOper1("");
		datos.setQttOper1(0);
		datos.setPriceOper1(0);
		datos.setIvaOper1(0);
		
		datos.setCodeOper2("");
		datos.setTextOper2("");
		datos.setQttOper2(0);
		datos.setPriceOper2(0);
		datos.setIvaOper2(0);
		
		datos.setCodeOper3("");
		datos.setTextOper3("");
		datos.setQttOper3(0);
		datos.setPriceOper3(0);
		datos.setIvaOper3(0);

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
		datos.setTotalAlbaran(0);
		
		// hay que asegurarse de que no existen datos
		assertNull("No hay datos",alb.searchAllDeliveriesPending());
		
		// ahora creamos datos para comparacion
		String data[]={"1","","P2MASK2","1","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
				
		// creamos dato
		alb.createDelivery(datos);
		
		// comprobamos grabaciones
		assertNotNull("Ahora si hay datos",alb.searchAllDeliveriesPending());
		assertArrayEquals("La lista retorna los datos", data, alb.searchAllDeliveriesPending().get(0));
		
		// ahora creamos otro dato
		datos.setCodeCustomer("JODT");
		datos.setNumber("2");
		datos.setTotalAlbaran(12.10);
		alb.createDelivery(datos);
		
		// ahora creamos datos para comparacion
		String data2[]={"2","","JODT","2","2014-01-01","121212","","","0.0","0.0","0.0","","","0.0","0.0","0.0","","","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","0.0","12.1"};

		// comprobamos grabaciones
		assertArrayEquals("La lista retorna los datos", data2, alb.searchAllDeliveriesPending().get(1));
		assertTrue("La lista tiene los 2 albaranes pendientes", 2==alb.searchAllDeliveriesPending().size());
		
		// ahora cambiamos un dato de pendiente a facturado
		datos.setInvoice("1");
		alb.modifyDelivery("1", datos);
		assertTrue("La lista tiene ahora 1 albaran pendiente", 1==alb.searchAllDeliveriesPending().size());
				
		// borramos los datos
		alb.eraseDelivery("1");
		alb.eraseDelivery("2");
	}


	
	@After
	public void tearDown() throws Exception {
		
		
		File fileDup1=new File(""+"TestdatosAlb1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosAlb2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosAlb3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosAlb4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosAlb5.txt");
		fileDup5.delete();
		File fileDup6=new File(""+"TestdatosAlb6.txt");
		fileDup6.delete();
		File fileDup7=new File(""+"TestdatosAlb7.txt");
		fileDup7.delete();
		File fileDup8=new File(""+"TestdatosAlb8.txt");
		fileDup8.delete();
		File fileDup9=new File(""+"TestdatosAlb9.txt");
		fileDup9.delete();
		
	}

}
