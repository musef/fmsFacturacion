package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.TiposIrpfBean;
import beansModels.TiposIrpf;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestTiposIrpfBean {

	@Before
	public void setUp() throws Exception {
		

		
	}
	
	
	
	@Test
	public void testGetListIrpf() {
		
		TiposIrpfBean tipo=new TiposIrpfBean();
		File mainFile=new File(""+"TestdatosIrpf1.txt");
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
		
		TiposIrpf irpf=new TiposIrpf();		
		irpf.setId(1);
		irpf.setActiveIrpf(1);
		irpf.setNameIrpf("GENERAL");
		irpf.setRateIrpf(18);
		irpf.setTypeIrpf(1);
		irpf.setAccIrpf("");
		
		
		// hay que asegurarse de que no existen datos

		List<String[]> lista=new ArrayList<String[]>();
		assertNull("No hay datos",tipo.getListIrpf());
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1","1","GENERAL","18.0","1",""};
		lista.add(data);
		
		// creamos dato
		tipo.createIrpf(irpf);
		
		assertNotNull("Ahora si hay datos",tipo.getListIrpf());
		
		assertArrayEquals("La lista retorna los datos", lista.get(0), tipo.getListIrpf().get(0));
		
		// borramos dato
		tipo.eraseIrpf("1");
		
	}
	
	
	@Test
	
	public void testCreateIrpf() {
		
		TiposIrpfBean tipo=new TiposIrpfBean();
		File mainFile=new File(""+"TestdatosIrpf2.txt");
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

		TiposIrpf irpf=new TiposIrpf();		
		irpf.setId(1);
		irpf.setActiveIrpf(1);
		irpf.setNameIrpf("GENERAL");
		irpf.setRateIrpf(18);
		irpf.setTypeIrpf(1);
		irpf.setAccIrpf("");
		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", tipo.createIrpf(null));
		
		assertFalse("objeto empty", tipo.createIrpf(new TiposIrpf()));
		
		assertTrue("irpf para grabar", tipo.createIrpf(irpf));
		
		//tipo.eraseIrpf("1");
		
	}
	
	
	@Test
	public void testEraseIrpf() {
		
		TiposIrpfBean tipo=new TiposIrpfBean();
		File mainFile=new File(""+"TestdatosIrpf4.txt");
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

		TiposIrpf irpf=new TiposIrpf();		
		irpf.setId(1);
		irpf.setActiveIrpf(1);
		irpf.setNameIrpf("GENERAL");
		irpf.setRateIrpf(18);
		irpf.setTypeIrpf(1);
		irpf.setAccIrpf("");
		
		tipo.createIrpf(irpf);


		assertFalse("id NULL", tipo.eraseIrpf(null));
		assertFalse("id empty", tipo.eraseIrpf(""));
		assertFalse("id incorrecta", tipo.eraseIrpf("9999"));
		assertTrue("irpf correcto para borrar", tipo.eraseIrpf("1"));
	}
	
	
	@Test
	public void testModifyIrpf() {
		
		TiposIrpfBean tipo=new TiposIrpfBean();
		File mainFile=new File(""+"TestdatosIrpf3.txt");
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

		TiposIrpf irpf=new TiposIrpf();		
		irpf.setId(1);
		irpf.setActiveIrpf(1);
		irpf.setNameIrpf("GENERAL");
		irpf.setRateIrpf(18);
		irpf.setTypeIrpf(1);
		irpf.setAccIrpf("");
		
		// Se graba un irpf
		tipo.createIrpf(irpf);

		// se prepara para modificar
		irpf.setNameIrpf("Irpf CORONEL");
		
		assertFalse("objeto null", tipo.modifyIrpf("0", null));
		
		assertFalse("objeto empty", tipo.modifyIrpf("0",new TiposIrpf()));
		
		assertTrue("irpf correcto para modificar", tipo.modifyIrpf("1",irpf));
	
		// una segunda modificacion
		irpf.setNameIrpf("Irpf CAPITAN");		
		assertFalse("id incorrecta", tipo.modifyIrpf("9999", irpf));
		assertFalse("id NULL", tipo.modifyIrpf(null, irpf));
		assertFalse("id empty", tipo.modifyIrpf("", irpf));
		// cambia el indice en la modificacion
		assertTrue("irpf correcto para modificar", tipo.modifyIrpf("1",irpf));
		
		// borramos los datos - ojo cambia el indice en la modificacion
		tipo.eraseIrpf("1");
		
	}


	
	
	@After
	public void tearDown() throws Exception {
		
		File fileDup1=new File(""+"TestdatosIrpf1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosIrpf2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosIrpf3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosIrpf4.txt");
		fileDup4.delete();
	}
	
}