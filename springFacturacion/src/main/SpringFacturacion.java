package main;

import java.awt.Color;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beansViews.EnterSandMan;

public class SpringFacturacion implements Runnable {

	public static String nameCompany;			// nombre de la empresa activa
	public static String idCompany;				// identificador de la empresa activa
	public static String addressCompany;		// direccion de la empresa activa
	public static String cpostalCompany;				// codigo postal de la empresa activa
	public static String cityCompany;					// localidad de la empresa activa
	public static String nifCompany;					// localidad de la empresa activa
	
	public static String nameUsuario;			// nombre del usuario activo
	public static String keyUser;				// keyUser del usuario activo
	
	public static String dir="";  				// ubicacion del directorio de ficheros de datos
	protected static Thread comienza;			// hilo de funcionamiento del programa
	public static int tabbed;					// pestaña de la pantalla principal donde se encuentra el usuario
	public static long lastInvoiceNumber;		// último número de factura utilizada
	public static String serialInvoices;			// serie de facturacion
	public static double retInvoices;			// retención en facturas
	
	public static Color fondoColor;				// color de fondo de la aplicacion
	
	
	private static SpringFacturacion main;
	private EnterSandMan enter;
	
	/**
	 * 
	 * @author musef
	 *
	 * @version 1.1.0_Spring 2014-08-31
	 */
	
	public static void main(String[] args) {

		//fondoColor=new Color(238,238,238);
		
		
		@SuppressWarnings("resource")
		ApplicationContext context2=new ClassPathXmlApplicationContext("main/applicationContext.xml");
		main=(SpringFacturacion)context2.getBean("main");
		fondoColor=new Color(220,220,220);
		comienza=new Thread(main);
		comienza.start();
	}


	@Override
	public void run() {
		
		enter.startApp();
	}


	public void setMain(SpringFacturacion mainSp) {
		// spring
		main=mainSp;
				
	}
	
	public void setEnterSandMan(EnterSandMan enter) {
		// spring
		this.enter=enter;
		
	}
	
	
	
	public static String getNameUsuario() {
		return nameUsuario;
	}


	public static void setNameUsuario(String nameUsuario) {
		SpringFacturacion.nameUsuario = nameUsuario;
	}


	public static String getKeyUser() {
		return keyUser;
	}


	public static void setKeyUser(String keyUser) {
		SpringFacturacion.keyUser = keyUser;
	}

}
