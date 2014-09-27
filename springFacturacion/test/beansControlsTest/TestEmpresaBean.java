package beansControlsTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beansControls.EmpresaBean;
import beansModels.DatosEmpresa;




/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestEmpresaBean {

	@Before
	public void setUp() throws Exception {
	}



	@Test
	public void testCreateEmpresa() {
		
		EmpresaBean emp=new EmpresaBean();
		File mainFile=new File(""+"TestdatosEmp1.txt");
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
			
		emp.setMainFile(mainFile);	
		
		DatosEmpresa datos=new DatosEmpresa();
		datos.setId(1);
		datos.setNombreEmpresa("EMPRESA");
		datos.setNombreComercial("");
		datos.setDireccion("");
		datos.setCpostal("28000");
		datos.setLocalidad("");
		datos.setNif("A28000000");
		datos.setSerieFact("");
		datos.setTexto("");
		datos.setRetencion(0);
		datos.setUltimoNumero(0);

		
		// INICIALMENTE HAY QUE ASEGURARSE DE QUE NO HAY DATOS EN EL FICHERO
		
		assertFalse("objeto null", emp.createEmpresa((null)));
		
		assertFalse("objeto empty", emp.createEmpresa(new DatosEmpresa()));
		
		assertTrue("Empresa para grabar", emp.createEmpresa(datos));
		
		emp.eraseEmpresa("1");
		
	}

	
	
	@Test
	public void testModifyEmpresa() {
		
		EmpresaBean emp=new EmpresaBean();
		File mainFile=new File(""+"TestdatosEmp2.txt");
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
			
		emp.setMainFile(mainFile);	
		
		DatosEmpresa datos=new DatosEmpresa();
		datos.setId(1);
		datos.setNombreEmpresa("EMPRESA");
		datos.setNombreComercial("");
		datos.setDireccion("");
		datos.setCpostal("28000");
		datos.setLocalidad("");
		datos.setNif("A28000000");
		datos.setSerieFact("");
		datos.setTexto("");
		datos.setRetencion(0);
		datos.setUltimoNumero(0);
		emp.createEmpresa(datos);
		
		// se prepara para modificar
		datos.setNombreEmpresa("OTRA EMPRESA");
		
		assertFalse("objeto null", emp.modifyEmpresa("0", null));
		
		assertFalse("objeto empty", emp.modifyEmpresa("0",new DatosEmpresa()));
		
		assertTrue("Empresa correcto para modificar", emp.modifyEmpresa("1",datos));
	
		// una segunda modificacion
		datos.setNombreEmpresa("NINGUNA EMPRESA");		
		assertFalse("id incorrecta", emp.modifyEmpresa("9999", datos));
		assertFalse("id NULL", emp.modifyEmpresa(null, datos));
		assertFalse("id empty", emp.modifyEmpresa("", datos));
		// cambia el indice en la modificacion
		assertTrue("Empresa correcto para modificar", emp.modifyEmpresa("1",datos));
		
		// borramos los datos - ojo cambia el indice en la modificacion
		emp.eraseEmpresa("1");
		
	}

	
	
	@Test
	public void testEraseEmpresa() {
		
		EmpresaBean emp=new EmpresaBean();
		File mainFile=new File(""+"TestdatosEmp3.txt");
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
			
		emp.setMainFile(mainFile);	
		
		DatosEmpresa datos=new DatosEmpresa();
		datos.setId(1);
		datos.setNombreEmpresa("EMPRESA");
		datos.setNombreComercial("");
		datos.setDireccion("");
		datos.setCpostal("28000");
		datos.setLocalidad("");
		datos.setNif("A28000000");
		datos.setSerieFact("");
		datos.setTexto("");
		datos.setRetencion(0);
		datos.setUltimoNumero(0);
		emp.createEmpresa(datos);
		
		assertFalse("id NULL", emp.eraseEmpresa(null));
		assertFalse("id empty", emp.eraseEmpresa(""));
		assertFalse("id incorrecta", emp.eraseEmpresa("9999"));
		assertTrue("Empresa correcta para borrar", emp.eraseEmpresa("1"));
		
	}

	@Test
	public void testModifyInvoiceNumber() {
		
		EmpresaBean emp=new EmpresaBean();
		File mainFile=new File(""+"TestdatosEmp5.txt");
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
			
		emp.setMainFile(mainFile);	
		
		DatosEmpresa datos=new DatosEmpresa();
		datos.setId(1);
		datos.setNombreEmpresa("EMPRESA");
		datos.setNombreComercial("");
		datos.setDireccion("");
		datos.setCpostal("28000");
		datos.setLocalidad("");
		datos.setNif("A28000000");
		datos.setSerieFact("");
		datos.setTexto("");
		datos.setRetencion(0);
		datos.setUltimoNumero(1);
		emp.createEmpresa(datos);
		
		// se prepara para modificar
		datos.setNombreEmpresa("OTRA EMPRESA");
		
		assertFalse("ambos datos incorrectos", emp.modifyLastInvoiceNumber("9999", -5));
		assertFalse("numero no valido", emp.modifyLastInvoiceNumber("1", -5));
		assertFalse("id incorrecta", emp.modifyLastInvoiceNumber("9999", 1));
		assertFalse("id NULL", emp.modifyLastInvoiceNumber(null, 1));
		assertFalse("id empty", emp.modifyLastInvoiceNumber("", 1));
		
		
		long nuevoNumero=2;
		assertTrue("Modificación realizada correctamente", emp.modifyLastInvoiceNumber("1",nuevoNumero));
		
		String data[]={"1","EMPRESA","","","28000","","A28000000","","",String.valueOf(nuevoNumero),"0"};
		assertArrayEquals("La lista retorna los datos", data, emp.getListEmpresa().get(0));
		
		
		// borramos los datos - ojo cambia el indice en la modificacion
		emp.eraseEmpresa("1");
		
	}

	@Test
	public void testGetListEmpresa() {
		
		EmpresaBean emp=new EmpresaBean();
		File mainFile=new File(""+"TestdatosEmp4.txt");
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
			
		emp.setMainFile(mainFile);	
		
		DatosEmpresa datos=new DatosEmpresa();
		datos.setId(1);
		datos.setNombreEmpresa("EMPRESA");
		datos.setNombreComercial("");
		datos.setDireccion("");
		datos.setCpostal("28000");
		datos.setLocalidad("");
		datos.setNif("A28000000");
		datos.setSerieFact("");
		datos.setTexto("");
		datos.setRetencion(0);
		datos.setUltimoNumero(0);
		
		
		// hay que asegurarse de que no existen datos

		List<String[]> lista=new ArrayList<String[]>();
		String saveData[]={"","","","","","","","","","",""};
		assertArrayEquals("No hay datos",saveData,emp.getListEmpresa().get(0));
		
		// ahora creamos datos y los insertamos
		
		String data[]={"1","EMPRESA","","","28000","","A28000000","","","0","0"};
		lista.add(data);
		
		// creamos dato
		emp.createEmpresa(datos);
		
		assertNotNull("Ahora si hay datos",emp.getListEmpresa());
		
		assertArrayEquals("La lista retorna los datos", lista.get(0), emp.getListEmpresa().get(0));
		
		// borramos dato
		emp.eraseEmpresa("1");
	}

	
	
	@After
	public void tearDown() throws Exception {
		
		File fileDup1=new File(""+"TestdatosEmp1.txt");
		fileDup1.delete();
		File fileDup2=new File(""+"TestdatosEmp2.txt");
		fileDup2.delete();
		File fileDup3=new File(""+"TestdatosEmp3.txt");
		fileDup3.delete();
		File fileDup4=new File(""+"TestdatosEmp4.txt");
		fileDup4.delete();
		File fileDup5=new File(""+"TestdatosEmp5.txt");
		fileDup5.delete();
		
	}
	
}
