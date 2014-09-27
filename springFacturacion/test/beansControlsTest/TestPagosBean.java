package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.PagosBean;
import beansModels.FormaPago;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestPagosBean {

	@Before
	public void setUp() throws Exception {
		

		
	}
	
	
	
	@Test
	public void testGetListPago() {
		
		PagosBean tipo=new PagosBean();
		File mainFile=new File(""+"TestdatosPago1.txt");
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
		FormaPago pago=new FormaPago();
		
		tipo.setMainFile(mainFile);
		
		pago.setIdPago(1);
		pago.setNamePago("CONTADO");
		pago.setTextoPago("PAGOS AL CONTADO");
		pago.setDiasPago("0");
		pago.setFechaPago("0");

		
		// hay que asegurarse de que no existen datos

		List<String[]> lista=new ArrayList<String[]>();
		assertNull("No hay datos",tipo.getListPago());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1","CONTADO","PAGOS AL CONTADO","0","0"};
		lista.add(data);
		
		// creamos dato
		tipo.createPago(pago);
		
		assertNotNull("Ahora si hay datos",tipo.getListPago());
		
		assertArrayEquals("La lista retorna los datos", lista.get(0), tipo.getListPago().get(0));
		
		// borramos dato
		tipo.erasePago("1");
		
	}
	
	@Test
	public void testGetPago() {
		
		PagosBean tipo=new PagosBean();
		File mainFile=new File(""+"TestdatosPago5.txt");
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
		
		FormaPago pago=new FormaPago();
		pago.setIdPago(1);
		pago.setNamePago("CONTADO");
		pago.setTextoPago("PAGOS AL CONTADO");
		pago.setDiasPago("0");
		pago.setFechaPago("0");
		// creamos un pago
		tipo.createPago(pago);
		
		assertNull("id incorrecta",tipo.getPago("9999"));
		assertNull("id NULL", tipo.getPago(null));
		assertNull("id empty", tipo.getPago(""));
		// cambia el indice en la modificacion
		String data[]={"1","CONTADO","PAGOS AL CONTADO","0","0"};
		assertArrayEquals("pago correcto localizado",data, tipo.getPago("1"));
	
		tipo.erasePago("1");
	}
	
	
	@Test
	public void testCreatePago() {
		
		PagosBean tipo=new PagosBean();
		File mainFile=new File(""+"TestdatosPago2.txt");
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
		
		FormaPago pago=new FormaPago();
		pago.setIdPago(1);
		pago.setNamePago("CONTADO");
		pago.setTextoPago("PAGOS AL CONTADO");
		pago.setDiasPago("0");
		pago.setFechaPago("0");
		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", tipo.createPago(null));
		
		assertFalse("objeto empty", tipo.createPago(new FormaPago()));
		
		assertTrue("pago para grabar", tipo.createPago(pago));
		
		tipo.erasePago("1");
		
	}
	
	
	@Test
	public void testErasePago() {
		
		PagosBean tipo=new PagosBean();
		File mainFile=new File(""+"TestdatosPago3.txt");
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
		
		FormaPago pago=new FormaPago();
		pago.setIdPago(1);
		pago.setNamePago("CONTADO");
		pago.setTextoPago("PAGOS AL CONTADO");
		pago.setDiasPago("0");
		pago.setFechaPago("0");
		tipo.createPago(pago);

		assertFalse("id NULL", tipo.erasePago(null));
		assertFalse("id empty", tipo.erasePago(""));
		assertFalse("id incorrecta", tipo.erasePago("9999"));
		assertTrue("pago correcto para borrar", tipo.erasePago("1"));
	}
	
	
	@Test
	public void testModifyPago() {
		
		PagosBean tipo=new PagosBean();
		File mainFile=new File(""+"TestdatosPago4.txt");
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
		
		FormaPago pago=new FormaPago();
		pago.setIdPago(1);
		pago.setNamePago("CONTADO");
		pago.setTextoPago("PAGOS AL CONTADO");
		pago.setDiasPago("0");
		pago.setFechaPago("0");

	
		// Se graba un iva
		tipo.createPago(pago);
		
		// se prepara para modificar
		pago.setNamePago("PAGO TARADO");
		
		assertFalse("objeto null", tipo.modifyPago("0", null));
		
		assertFalse("objeto empty", tipo.modifyPago("0",new FormaPago()));
		
		assertTrue("pago correcto para modificar", tipo.modifyPago("1",pago));
	
		// una segunda modificacion
		pago.setNamePago("PAGO CAPITAN");		
		assertFalse("id incorrecta", tipo.modifyPago("9999", pago));
		assertFalse("id NULL", tipo.modifyPago(null, pago));
		assertFalse("id empty", tipo.modifyPago("", pago));
		// cambia el indice en la modificacion
		assertTrue("pago correcto para modificar", tipo.modifyPago("1",pago));
		
		// borramos los datos - ojo cambia el indice en la modificacion
		tipo.erasePago("1");
		
	}


	
	
	@After
	public void tearDown() throws Exception {
		
		File fileDup1=new File(""+"TestdatosPago1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosPago2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosPago3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosPago4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosPago5.txt");
		fileDup5.delete();
		
	}

}
