package beansControlsTest;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import beansControls.UtilsFacturacion;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */

public class TestUtilsFacturacion {
	
	

	@Before
	public void setUp() throws Exception {
	}

		// ****** TEST DE CONVERTONUMBERNULL

	@Test
	public void testConvertToNumberNull() {
		UtilsFacturacion newUtil=new UtilsFacturacion();
		assertNotNull("parametro null", newUtil.convertToNumber(null));
		assertEquals("parametro null", -1, newUtil.convertToNumber(null),0);
	}
	
	@Test
	public void testConvertToNumberEmpty() {
		UtilsFacturacion newUtil=new UtilsFacturacion();
		assertNotNull("parametro empty", newUtil.convertToNumber(""));
		assertEquals("parametro empty", 0, newUtil.convertToNumber(""),0);
	}
	
	@Test
	public void testConvertToNumberNotANumber() {
		UtilsFacturacion newUtil=new UtilsFacturacion();
		assertNotNull("parametro no es número", newUtil.convertToNumber("hola"));
		assertEquals("parametro no es número", -1, newUtil.convertToNumber("hola"),0);
	}

	@Test
	public void testConvertToNumber() {
		UtilsFacturacion newUtil=new UtilsFacturacion();
		// not decimal number
		String number="4";
		double num=4;
		assertNotNull("parametro es un número", newUtil.convertToNumber(number));
		assertTrue("parametro es un número", num==newUtil.convertToNumber(number));
		assertEquals("parametro es un número", num,newUtil.convertToNumber(number),0);
		
		// decimal number spanish format
		number="4,15";
		num=4.15;
		assertNotNull("parametro es un número", newUtil.convertToNumber(number));
		assertTrue("parametro es un número", num==newUtil.convertToNumber(number));
		assertEquals("parametro es un número", num,newUtil.convertToNumber(number),0);
		number="4,15003";
		assertFalse("parametro es un número", num==newUtil.convertToNumber(number));
		
		// decimal number english format
		number="4.15";
		num=4.15;
		assertNotNull("parametro es un número", newUtil.convertToNumber(number));
		assertEquals("parametro es un número", num,newUtil.convertToNumber(number),0);
		number="4.15003";
		assertFalse("parametro es un número", num==newUtil.convertToNumber(number));
		
	}
	
		// ****** TEST DE TESTORDERPLEASE
	
	@Test
	public void testOrderPleaseNull() {
		
		UtilsFacturacion newUtil=new UtilsFacturacion();
		assertNull("lista nula", newUtil.orderPlease(null, 0));
	}
	
	@Test
	public void testOrderPleaseEmptyList() {
		
		UtilsFacturacion newUtil=new UtilsFacturacion();
		List<String[]>lista=new ArrayList<String[]>();
		assertNull("lista vacía", newUtil.orderPlease(lista, 0));
	}
	
	
	@Test
	public void testOrderPleaseWrongNumberOrder() {
		
		UtilsFacturacion newUtil=new UtilsFacturacion();
		String[] a={"2","juan","AAA3"};
		String[] b={"1","pepe","AAA1"};
		String[] c={"0","luis","BAA3"};
		List<String[]>lista=new ArrayList<String[]>();
		lista.add(a);
		lista.add(b);
		lista.add(c);
		assertNull("Numero orden inexistente", newUtil.orderPlease(lista, 4));
		assertNull("orden no es un numero positivo", newUtil.orderPlease(lista, -1));
	}
	
	
	@Test
	public void testOrderPleaseWorkCorrectly() {
		
		UtilsFacturacion newUtil=new UtilsFacturacion();
		String[] a={"0","pepe","AAA3"};
		String[] b={"1","juan","BAA3"};
		String[] c={"2","luis","AAA1"};
		List<String[]>lista=new ArrayList<String[]>();
		lista.add(a);
		lista.add(b);
		lista.add(c);
		
		List<String[]>listaTest=new ArrayList<String[]>();	
		listaTest.add(a);
		listaTest.add(b);
		listaTest.add(c);	
		assertEquals("listas iguales", lista, listaTest);
		
		assertNotNull("ordenamos lista", listaTest=newUtil.orderPlease(listaTest, 0));

		assertEquals("listas iguales", lista, listaTest=newUtil.orderPlease(listaTest, 0));
	
		assertEquals("listas iguales al ordenarse", lista, listaTest=newUtil.orderPlease(listaTest, 0));
		
		assertFalse("listas distintas al ordenarse diferente", lista==(listaTest=newUtil.orderPlease(listaTest, 2)));
		assertNotNull("ordenamos lista", listaTest=newUtil.orderPlease(listaTest, 0));
		assertEquals("listas iguales", lista, listaTest);
		
		assertFalse("distintos ordenes distintas listas", lista==(listaTest=newUtil.orderPlease(listaTest, 1)));	
		assertEquals("listas iguales al ordenarse de nuevo", lista, listaTest=newUtil.orderPlease(listaTest, 0));
		assertFalse("listas distintas al ordenarse diferente", lista==(listaTest=newUtil.orderPlease(listaTest, 2)));
		assertEquals("listas iguales al ordenarse de nuevo", lista, listaTest=newUtil.orderPlease(listaTest, 0));		

	}
	
	
	// ****** TEST DE TESTORDERPLEASE
	
	@Test
	public void testGetNextId() {
		
		UtilsFacturacion newUtil=new UtilsFacturacion();
		File mainFile=new File(""+"Testdatos.txt");
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
		
		// PRIMERO SE TESTEA EL FICHERO VACIO
		assertNotNull("fichero nulo", newUtil.getNextId(null));
		assertTrue("fichero nulo", -1==newUtil.getNextId(null));
		assertTrue("fichero vacío", 1==newUtil.getNextId(mainFile));

		// fabrica el String a grabar
		String idTest="1";
		String graba=idTest+'|'+""+'|';
		
		// GRABAMOS EN EL FICHERO 
		
		FileWriter fichero=null;
		BufferedWriter salida=null;
		
		// ahora genera el fichero Users
		try {
			fichero=new FileWriter(mainFile,true);
			salida=new BufferedWriter(fichero);
			salida.write(graba);
			salida.newLine();
		} catch (IOException e) {
			System.err.println("Error en grabación fichero pago");
		} finally {
			try {
				salida.flush();
				salida.close();
				fichero.close();
			} catch (IOException e) {
				System.err.println("error cerrando el fichero pago");
			}
		}
			
		// AHORA SE TESTEA EL FICHERO CON UN DATO
		long valueToTest=(long)Long.parseLong(idTest);
		valueToTest++;
		assertTrue("fichero con un dato", valueToTest==newUtil.getNextId(mainFile));
		//System.out.println("ID:"+newUtil.getNextId(mainFile));
		
		// GRABAMOS OTRO DATO PARA TESTEO 
		
		idTest="3";
		graba=idTest+'|'+""+'|';
		
		fichero=null;
		salida=null;
		
		// ahora genera el fichero Users
		try {
			fichero=new FileWriter(mainFile,true);
			salida=new BufferedWriter(fichero);
			salida.write(graba);
			salida.newLine();
		} catch (IOException e) {
			System.err.println("Error en grabación fichero pago");
		} finally {
			try {
				salida.flush();
				salida.close();
				fichero.close();
			} catch (IOException e) {
				System.err.println("error cerrando el fichero pago");
			}
		}
		
		// SEGUNDO TESTEO
		valueToTest=(long)Long.parseLong(idTest);
		valueToTest++;
		assertTrue("fichero con OTRO dato", valueToTest==newUtil.getNextId(mainFile));
		//System.out.println("ID:"+newUtil.getNextId(mainFile));
		
		
		File fileDup1=new File(""+"Testdatos.txt");
		fileDup1.delete();
		
	}

}  // ***************** END OF CLASS
