package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.TiposIvaBean;
import beansModels.TiposIva;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestTiposIvaBean {
	

	
	@Before
	public void setUp() throws Exception {
		

		
	}
	
	
	
	@Test
	public void testEraseIva() {
		
		TiposIvaBean tipo=new TiposIvaBean();
		File mainFile=new File(""+"TestdatosIva5.txt");
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
		
		TiposIva iva=new TiposIva();	
		iva.setIdIva(1);
		iva.setTypeIva(1);
		iva.setAccIva("");
		iva.setActiveIva(1);
		iva.setClassIva(3);
		iva.setNameIva("IVA GENERAL");
		iva.setRateIva(21);
		tipo.createIva(iva);

		assertFalse("id NULL", tipo.eraseIva(null));
		assertFalse("id empty", tipo.eraseIva(""));
		assertFalse("id incorrecta", tipo.eraseIva("9999"));
		assertTrue("iva correcto para borrar", tipo.eraseIva("1"));
	}
	
	
	@Test
	public void testGetListIva() {
		
		TiposIvaBean tipo=new TiposIvaBean();
		File mainFile=new File(""+"TestdatosIva1.txt");
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
		TiposIva iva=new TiposIva();
		
		tipo.setMainFile(mainFile);
		
		iva.setIdIva(1);
		iva.setTypeIva(1);
		iva.setAccIva("");
		iva.setActiveIva(1);
		iva.setClassIva(3);
		iva.setNameIva("IVA GENERAL");
		iva.setRateIva(21);
		
		// hay que asegurarse de que no existen datos

		List<String[]> lista=new ArrayList<String[]>();
		assertNull("No hay datos",tipo.getListIva());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1","1","IVA GENERAL","21.0","1","3",""};
		lista.add(data);
		
		// creamos dato
		tipo.createIva(iva);
		
		assertNotNull("Ahora si hay datos",tipo.getListIva());
		
		assertArrayEquals("La lista retorna los datos", lista.get(0), tipo.getListIva().get(0));
		
		// borramos dato
		tipo.eraseIva("1");
		
	}
	
	
	@Test
	
	public void testcreateIva() {
		
		TiposIvaBean tipo=new TiposIvaBean();
		File mainFile=new File(""+"TestdatosIva2.txt");
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
		TiposIva iva=new TiposIva();	
		iva.setIdIva(1);
		iva.setTypeIva(1);
		iva.setAccIva("");
		iva.setActiveIva(1);
		iva.setClassIva(3);
		iva.setNameIva("IVA GENERAL");
		iva.setRateIva(21);
		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		tipo.setMainFile(mainFile);
		
		assertFalse("objeto null", tipo.createIva(null));
		
		assertFalse("objeto empty", tipo.createIva(new TiposIva()));
		
		assertTrue("iva para grabar", tipo.createIva(iva));
		
		tipo.eraseIva("1");
		
	}
	
	

	
	
	@Test
	public void testModifyIva() {
		
		TiposIvaBean tipo=new TiposIvaBean();
		File mainFile=new File(""+"TestdatosIva3.txt");
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
		TiposIva iva=new TiposIva();
		
		tipo.setMainFile(mainFile);
		
		iva.setIdIva(1);
		iva.setTypeIva(1);
		iva.setAccIva("");
		iva.setActiveIva(1);
		iva.setClassIva(3);
		iva.setNameIva("IVA GENERAL");
		iva.setRateIva(21);

	
		// Se graba un iva
		tipo.createIva(iva);
		
		// se prepara para modificar
		iva.setNameIva("IVA CORONEL");
		
		assertFalse("objeto null", tipo.modifyIva("0", null));
		
		assertFalse("objeto empty", tipo.modifyIva("0",new TiposIva()));
		
		assertTrue("iva correcto para modificar", tipo.modifyIva("1",iva));
	
		// una segunda modificacion
		iva.setNameIva("IVA CAPITAN");		
		assertFalse("id incorrecta", tipo.modifyIva("9999", iva));
		assertFalse("id NULL", tipo.modifyIva(null, iva));
		assertFalse("id empty", tipo.modifyIva("", iva));
		// cambia el indice en la modificacion
		assertTrue("iva correcto para modificar", tipo.modifyIva("1",iva));
		
		// borramos los datos - ojo cambia el indice en la modificacion
		tipo.eraseIva("1");
		
	}


	@Test
	public void testGetClassIva() {
		
		TiposIvaBean tipo=new TiposIvaBean();
		File mainFile=new File(""+"TestdatosIva4.txt");
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
		
		assertNotNull("retorno no nulo por errores", tipo.getClassIva(0, null));	
		assertTrue("retorno no nulo por errores", tipo.getClassIva(0, null)==-1);
		
		// grabamos un dato para testar
		TiposIva iva=new TiposIva();
		iva.setIdIva(0);
		iva.setTypeIva(1);
		iva.setAccIva("");
		iva.setActiveIva(1);
		iva.setClassIva(3);
		iva.setNameIva("IVA SUPERIOR");
		iva.setRateIva(21);
		tipo.createIva(iva);
		
		assertTrue("tipo de iva no válido", tipo.getClassIva(0, "21")==-1);
		assertTrue("tipo de iva no válido", tipo.getClassIva(3, "21")==-1);
		assertTrue("porcentaje de iva null", tipo.getClassIva(1, null)==-1);
		assertTrue("porcentaje de iva empty", tipo.getClassIva(1, "")==-1);
		assertTrue("porcentaje de iva String no numerica", tipo.getClassIva(1, "hola")==-1);
		assertTrue("porcentaje de iva inexistente", tipo.getClassIva(1, "99.99")==-1);
		
		assertTrue("iva correcto buscado", tipo.getClassIva(1, "21")==3);
		assertTrue("iva correcto dentro límites respuesta", (tipo.getClassIva(1, "21")>=0 && (tipo.getClassIva(1, "21")<4 )));
		
		// borramos el dato creado
		tipo.eraseIva("1");
	}
	
	@After
	public void tearDown() throws Exception {
		
		File fileDup1=new File(""+"TestdatosIva1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosIva2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosIva3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosIva4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosIva5.txt");
		fileDup5.delete();
	}

}
