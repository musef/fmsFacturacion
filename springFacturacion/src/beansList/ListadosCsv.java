package beansList;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


import main.SpringFacturacion;
import beansControls.FileRecorder;
import beansModels.Albaranes;
import beansModels.Facturas;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class ListadosCsv {
	
	// SPRING
	private FileRecorder recording;
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private SimpleDateFormat fechaCortaESP=new SimpleDateFormat("dd-MM-yyyy",new Locale("es"));

	
	public ListadosCsv() {
		// CONSTRUCTOR
	}
	
	public void setRecording (FileRecorder recording) {
		// spring
		this.recording=recording;
	}
	
	
	/**
	 * Este método genera un csv de nombre 'filename', con la información del albaran suministrado.
	 * 
	 * @param filename - String, nombre del fichero a generar.
	 * @param alb - Albaranes, objeto conteniendo la información del albarán
	 * @param name - String, nombre del cliente
	 * @param address - String, dirección del cliente
	 * @param cpostal - String, codigo postal del cliente
	 * @param city - String, localidad del cliente
	 * @param nif - String, nif del cliente
	 * @return TRUE o FALSE con el resultado de la operación
	 */
	
	public boolean generatesDelivery (String filename, Albaranes alb, String name, String address, String cpostal, String city, String nif) {
		
		
		String cabecera1=SpringFacturacion.nameCompany+";\n"+SpringFacturacion.addressCompany+";\n"+SpringFacturacion.cpostalCompany+" "+SpringFacturacion.cityCompany+";\n"+SpringFacturacion.nifCompany+";\n";
		String fecha=fechaCortaESP.format(alb.getDateOper());
		String cabecera2="Albarán nº "+alb.getNumber()+";;"+"Fecha: "+fecha+";\n";
		String cabecera3=";;;"+name+"\n;;;"+address+"\n;;;"+cpostal+" "+city+"\n;;;"+nif+"\n;;;\n";
					
		String cuerpo="\n\n";
		
		cuerpo=cuerpo+"CODIGO;"+"CONCEPTO;"+"UDS;"+"PRECIO;"+"IVA;"+"IMPORTE;"+"\n";		
		cuerpo=cuerpo+alb.getCodeOper1()+";"+alb.getTextOper1()+";"+formatoDecimal.format(alb.getQttOper1())+";"+formatoDecimal.format(alb.getPriceOper1())+";"+formatoDecimal.format(alb.getIvaOper1())+";"+formatoDecimal.format((alb.getQttOper1()*alb.getPriceOper1()))+";\n";
		if (alb.getQttOper2()>0) {
			cuerpo=cuerpo+alb.getCodeOper2()+";"+alb.getTextOper2()+";"+formatoDecimal.format(alb.getQttOper2())+";"+formatoDecimal.format(alb.getPriceOper2())+";"+formatoDecimal.format(alb.getIvaOper2())+";"+formatoDecimal.format((alb.getQttOper2()*alb.getPriceOper2()))+";\n";
		} else {
			cuerpo=cuerpo+";;;;;;\n";
		}
		if (alb.getQttOper3()>0) {
			cuerpo=cuerpo+alb.getCodeOper3()+";"+alb.getTextOper3()+";"+formatoDecimal.format(alb.getQttOper3())+";"+formatoDecimal.format(alb.getPriceOper3())+";"+formatoDecimal.format(alb.getIvaOper3())+";"+formatoDecimal.format((alb.getQttOper3()*alb.getPriceOper3()))+";\n";
		} else {
			cuerpo=cuerpo+";;;;;;\n";
		}
		cuerpo=cuerpo+";;;;;;\n";
		
		String resumen="";
		resumen=resumen+";"+"BASE IMPONIBLE;"+"CUOTA IVA;"+"RETENCIÓN;"+";"+"IMPORTE TOTAL;"+"\n";
		resumen=resumen+";"+formatoDecimal.format((alb.getBaseImponible0()+alb.getBaseImponible1()+alb.getBaseImponible2()+alb.getBaseImponible3()))+";"+
					formatoDecimal.format((alb.getIva1()+alb.getIva2()+alb.getIva3()))+";"+formatoDecimal.format(alb.getRetencion())+";"+";"+formatoDecimal.format(alb.getTotalAlbaran())+";"+"\n";
			
		
		String dataToRecording=cabecera1+cabecera2+cabecera3+cuerpo+resumen;
		
		boolean result=recording.CreateCsvtDelivery("albaran"+alb.getNumber(),dataToRecording);
		
		return result;
			
	} // end of method generatesDelivery
	
	
	
	/**
	 * Este método genera un listado de albaranes, grabándolo en un fichero csv transportable a excel. El listado se confecciona
	 * según los parámetros seleccionados.
	 *  
	 * @param listSelectedDeliveries - List, lista con todos los albaranes seleccionados.
	 * @param deliv1 - long, número de albarán desde el cual imprimir.
	 * @param deliv2 - long, número de albarán hasta el cual imprimir.
	 * @param state - int, estado deseado de los albaranes a imprimir (1=pendiente, 2=facturado)
	 * @param today - String, la fecha del día.
	 * @return TRUE o FALSE con el resultado de la operación.
	 */
	
	public boolean generatesCsvFileList(List<String[]>listSelectedDeliveries, long deliv1, long deliv2, int state, String today) {
		
		// CABECERA
		String title="LISTADO DE FACTURAS;\n\n";
		
		// CUERPO
		
		String cabeceras="CLIENTE;"+"NÚMERO;"+"FECHA;"+"BASE IMPONIBLE;"+"TOTAL FACTURA;"+"ESTADO;\n";
			
		String cuerpo="";
		String resumen="";
		
		if (listSelectedDeliveries!=null && !listSelectedDeliveries.isEmpty()) {
			int elem=0;
			double basTotal=0;
			double impTotal=0;
			
			for (String a[]:listSelectedDeliveries) {		
				long num=(long)Long.parseLong(a[3]);
				// se procesan los numeros dentro del rango
				if (deliv1<=num && num<=deliv2) {
					// si estado es cero quiere decir todos los albaranes
					if (state==0) {

						double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
						double tot=(double)Double.parseDouble(a[33]);
						basTotal=basTotal+bas;
						impTotal=impTotal+tot;
						
						String texto="";
						if (a[1].isEmpty()) {
							texto="PENDIENTE";
						} else {
							texto="FACTURADO";
						}
						cuerpo+=a[2]+";"+a[3]+";"+a[4]+";"+formatoDecimal.format(bas)+";"+formatoDecimal.format(tot)+";"+texto+";\n";
						
						elem++;					
					} else if (state==1) {
						// estado 1 quiere decir albaranes pendientes
						if (a[1].isEmpty()) {
							double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
							double tot=(double)Double.parseDouble(a[33]);
							basTotal=basTotal+bas;
							impTotal=impTotal+tot;
							
							cuerpo+=a[2]+";"+a[3]+";"+a[4]+";"+formatoDecimal.format(bas)+";"+formatoDecimal.format(tot)+";"+"PENDIENTE;\n";
							
							elem++;	
						}
					} else {
						// estado 2 quiere decir albaranes facturados
						if (!a[1].isEmpty()) {
							double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
							double tot=(double)Double.parseDouble(a[33]);
							basTotal=basTotal+bas;
							impTotal=impTotal+tot;
							
							cuerpo+=a[2]+";"+a[3]+";"+a[4]+";"+formatoDecimal.format(bas)+";"+formatoDecimal.format(tot)+";"+"FACTURADO;\n";	
							elem++;	
						}
					}
				}

			}
			

				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
			
			for (int j=elem;j<24;j++) {

				cuerpo+=";;;;;;"+"\n";

			}
			
			// añadimos con los sumatorios
			resumen="TOTALES;;;"+"BASES;"+"IMPORTES;;\n";
			resumen+=";;;"+formatoDecimal.format(basTotal)+";"+formatoDecimal.format(impTotal)+";;\n\n";
			
		} else {
			cuerpo="NO EXISTEN DATOS EN LA SELECCION\n\n\n";
			resumen="";
		}
		

				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today;			
		
		String dataToRecording=title+cabeceras+cuerpo+resumen+pie;
		
		boolean result=recording.CreateListDeliveries(dataToRecording);
		
		return result;
		
	} // end of method generatesCsvFileList
	
	
	
	/**
	 *  Este método genera una factura en formato csv, exportable a excel, con los datos suministrados.
	 *  
	 * @param filename - String, nombre del fichero a generar.
	 * @param factura - Facturas, objeto conteniendo la factura a imprimir.
	 * @return TRUE o FALSE con el resultado de la operación.
	 */
	
	public boolean generatesInvoice (String filename, Facturas factura) {
		
		String cabecera1=factura.getNameCompany()+";\n"+factura.getAddressCompany()+";\n"+factura.getPostalCompany()+" "+factura.getCityCompany()+";\n"+factura.getNifCompany()+";\n";
	    // crea el formato de fecha a mostrar
		SimpleDateFormat fechaCortaESP=new SimpleDateFormat("dd-MM-yyyy",new Locale("es"));
		String fecha=fechaCortaESP.format(factura.getDateF());
		String cabecera2="Factura nº "+factura.getSerial()+""+factura.getNumber()+";;"+"Fecha: "+fecha+";\n";
		String cabecera3=";;;"+factura.getNameCustomer()+"\n;;;"+factura.getAddressCustomer()+"\n;;;"+factura.getPostalCustomer()+" "+factura.getCityCustomer()+"\n;;;"+factura.getCityCustomer()+"\n;;;\n";
					
		String cuerpo="\n\n";
		
		cuerpo=cuerpo+"CODIGO;"+"CONCEPTO;"+"UDS;"+"PRECIO;"+"IVA;"+"IMPORTE;"+"\n";	
		for (String[] a: factura.getDataInvoice()) {
			cuerpo=cuerpo+a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";"+a[5]+";"+"\n";
		}
		
		// relleno en blanco
		for (int n=factura.getDataInvoice().size();n<20;n++) {
			cuerpo=cuerpo+";;;;;;\n";			
		}
		
		String resumen="\n\n";
	    resumen=resumen+"BASE IMPONIBLE;"+"RETENC. IRPF;"+"CUOTA IVA;"+"TOTAL FACTURA;\n";
	    
	    resumen=resumen+formatoDecimal.format(factura.getBaseImponible0()+factura.getBaseImponible1()+factura.getBaseImponible2()+factura.getBaseImponible3())+";"+
	    		formatoDecimal.format(factura.getRetencion())+";"+formatoDecimal.format(factura.getIva1()+factura.getIva2()+factura.getIva3())+";"+
	    		formatoDecimal.format(factura.getTotalFactura())+";\n";
		
	    String pago="\n\n";
			
	    // FORMA DE PAGO
	    if (factura.getDiaPago().isEmpty()) {
	    	pago=pago+"FORMA DE PAGO: "+factura.getFormaPago()+";\n";
	    } else {
	    	pago=pago+"FORMA DE PAGO: "+factura.getFormaPago()+" VENCIMIENTO "+factura.getDiaPago()+";\n";
	    }
	    
	    String desgloses="\n\n";
	    
	    // TABLA DE DESGLOSES DE IVA    
	    @SuppressWarnings("unused")
		int numDesg=1;
	    
	    desgloses=desgloses+"DESGLOSES DE IVA;\n";
	    desgloses=desgloses+"BASE AL  0,00%..: "+formatoDecimal.format(factura.getBaseImponible0())+
	    		" --> ;CUOTA AL 0,00%..: 0,00;"+"\n";
	       
	    if (factura.getIva1()>0) {
	    	
	    	String perc1=formatoDecimal.format(factura.getTipoIva1()*100);
	    	
	    	desgloses=desgloses+"BASE AL "+perc1+"%..: "+formatoDecimal.format(factura.getBaseImponible1())+" euros"+
	    		" --> ;"+"CUOTA AL "+perc1+"%..: "+formatoDecimal.format(factura.getIva1())+" euros;"+"\n";
		    
		    numDesg++;
	    }   

	    if (factura.getIva2()>0) {
	    	
	    	String perc2=formatoDecimal.format(factura.getTipoIva2()*100);
		    
	    	desgloses=desgloses+"BASE AL "+perc2+"%..: "+formatoDecimal.format(factura.getBaseImponible2())+" euros"+
		    		" --> ;"+"CUOTA AL "+perc2+"%..: "+formatoDecimal.format(factura.getIva2())+" euros;"+"\n";
		    
		    numDesg++;
		    
	    }

	    if (factura.getIva3()>0) {
	    	
	    	String perc3=formatoDecimal.format(factura.getTipoIva3()*100);
		    
	    	desgloses=desgloses+"BASE AL "+perc3+"%..: "+formatoDecimal.format(factura.getBaseImponible3())+" euros"+
		    		" --> ;"+"CUOTA AL "+perc3+"%..: "+formatoDecimal.format(factura.getIva3())+" euros;"+"\n";
		    
		    numDesg++;
		    
	    }
	    
	    if (factura.getRetencion()>0) {
	    	
	    	String retI=formatoDecimal.format(factura.getTipoRet()*100);
	    	desgloses=desgloses+"RETENCIÓN DE IRPF el "+retI+"%; total RETENCION "+formatoDecimal.format(factura.getRetencion())+" euros\n";
		    
		    numDesg++;
	    	
	    }
	    
		String pie=";";
		
		String dataToRecording=cabecera1+cabecera2+cabecera3+cuerpo+resumen+pago+desgloses+pie;
		
		boolean result=recording.CreateCsvtDelivery("Factura"+factura.getSerial()+factura.getNumber(),dataToRecording);
		
		return result;
			
	} // end of method generatesInvoice
	
	
	
	/**
	 * Este método genera un listado de facturas, grabándolo en un fichero csv transportable a excel.
	 * 
	 * @param listSelectedCustomers - List, con la lista de los clientes seleccionados.
	 * @param listSelectedInvoices - List, con la lista de las facturas seleccionadas para generar.
	 * @param cust1 - int, indice del list de clientes desde el cual se seleccionan las facturas
	 * @param cust2 - int, indice del list de clientes hasta el cual se seleccionan las facturas
	 * @param inv1 - long, número de factura desde la cual listar.
	 * @param inv2 - long, número de factura hasta la cual listar.
	 * @param today - String, con el día de fecha de listado.
	 * @return TRUE o FALSE con el resultado de la operación.
	 */
	
	public boolean generatesCsvListInvoices(List<String[]>listSelectedCustomers, List<String[]>listSelectedInvoices, int cust1, int cust2, long inv1, long inv2, String today) {
		
		// CABECERA
		String title="LISTADO DE FACTURAS del "+inv1+" al "+inv2+" SELECCIONADO POR CLIENTES;\n\n";
		
		// CUERPO
		
		String cabeceras="CLIENTE;"+"SERIE;"+"NÚMERO;"+"FECHA;"+"BASE IMPONIBLE;"+"CUOTA IVA;"+"TOTAL FACTURA;\n";
			
		String cuerpo="";
		
		int elem=0;
		double basTotal=0;
		double cuoTotal=0;
		double impTotal=0;
		
		for (String a[]:listSelectedInvoices) {		
			for (int j=cust1;j<=cust2;j++) {
				long numF=0;
				try {
					numF=(long) Long.parseLong(a[1]);
				} catch (NumberFormatException nf) {
					numF=0;
				}
				if (a[10].equals(listSelectedCustomers.get(j)[1]) && numF>=inv1 && numF<=inv2) {
					double bas=(double)Double.parseDouble(a[16])+(double)Double.parseDouble(a[17])+(double)Double.parseDouble(a[20])+(double)Double.parseDouble(a[23]);
					double tot=(double)Double.parseDouble(a[28]);
					double iva=tot-bas;
					basTotal=basTotal+bas;
					cuoTotal=cuoTotal+iva;
					impTotal=impTotal+tot;
					cuerpo+=a[11]+";"+a[2]+";"+a[1]+";"+a[3]+";"+formatoDecimal.format(bas)+";"+formatoDecimal.format(iva)+";"+formatoDecimal.format(tot)+";"+"\n";	
					elem++;
				}
			}	
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<24;j++) {

			cuerpo+=";;;;;;;"+"\n";

		}
		
			// resumen de la facturacion generada
		String resumen="TOTALES;"+";;;"+"TOTAL BASES;"+"TOTAL CUOTAS;"+"TOTAL IMPORTES;"+"\n"+
				";;;;"+formatoDecimal.format(basTotal)+";"+formatoDecimal.format(cuoTotal)+";"+formatoDecimal.format(impTotal)+";\n\n";
		
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today;			
		
		String dataToRecording=title+cabeceras+cuerpo+resumen+pie;
		
		//FileRecorder fr=new FileRecorder();
		boolean result=recording.CreateListInvoices("listadoFacturas",dataToRecording);
		
		return result;
		
	} // end of method generatesCsvListInvoices
	
	
	
	/**
	 * Este método genera un listado de facturas de iva repercutido, desde-hasta las fechas seleccionadas. El listado
	 * es grabado en un fichero csv exportable a excel.
	 * 
	 * @param listSelectedInvoices - List con La lista de todas las facturas disponibles para imprimir
	 * @param date1 - String, la fecha inicial desde la cual listar en formato dd-MM-yyyy
	 * @param date2 - String, la fecha final hasta la cual listar en formato dd-MM-yyyy
	 * 
	 * @return boolean TRUE o FALSE según el resultado de la generación del listado en formato csv
	 */
	
	public boolean generatesCsvListIva(List<String[]>listSelectedInvoices, String date1, String date2) {
		
		// CABECERA
		String title="LISTADO DE IVA REPERCUTIDO del "+date1+" al "+date2+";\n\n";
		
		// CUERPO
		
		String cabeceras="SERIE;"+"NÚMERO;"+"FECHA;"+"CLIENTE;"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"TOTAL;\n"+
		";"+";"+";"+";"+"EXENTO ;"+"EXENTO ;"+"SUPERRED. ;"+"SUPERRED. ;"+"REDUCIDO;"+"REDUCIDO;"+"GENERAL;"+"GENERAL;"+"FACTURA;\n";
			
		String cuerpo="";
		
		int elem=0;
		double bas0=0;
		double bas1=0;
		double iva1=0;
		double bas2=0;
		double iva2=0;
		double bas3=0;
		double iva3=0;

		
			
		// convierte fechas para comparacion
		String d1=date1.substring(6)+date1.substring(2, 6)+date1.substring(0, 2);
		String d2=date2.substring(6)+date2.substring(2, 6)+date2.substring(0, 2);		
		
		for (String a[]:listSelectedInvoices) {
								
			// Seleccionamos los datos en funcion de los filtros del formulario
			if (a[3].compareTo(d1)>=0 && a[3].compareTo(d2)<=0) {

					cuerpo+=a[2]+";"+a[1]+";"+a[3]+";"+a[11]+";"+formatoDecimal.format((double)Double.parseDouble(a[16]))+";"+formatoDecimal.format(0)+";"+
							formatoDecimal.format((double)Double.parseDouble(a[17]))+";"+formatoDecimal.format((double)Double.parseDouble(a[18])*(double)Double.parseDouble(a[17]))+";"+
							formatoDecimal.format((double)Double.parseDouble(a[20]))+";"+formatoDecimal.format((double)Double.parseDouble(a[21])*(double)Double.parseDouble(a[20]))+";"+
							formatoDecimal.format((double)Double.parseDouble(a[23]))+";"+formatoDecimal.format((double)Double.parseDouble(a[24])*(double)Double.parseDouble(a[23]))+";"+
							formatoDecimal.format((double)Double.parseDouble(a[28]))+";"+"\n";
					
					bas0=bas0+(double)Double.parseDouble(a[16]);
					bas1=bas1+(double)Double.parseDouble(a[17]);
					bas2=bas2+(double)Double.parseDouble(a[20]);
					bas3=bas3+(double)Double.parseDouble(a[23]);
					
					iva1=iva1+((double)Double.parseDouble(a[17]))*((double)Double.parseDouble(a[18]));
					iva2=iva2+((double)Double.parseDouble(a[20]))*((double)Double.parseDouble(a[21]));
					iva3=iva3+((double)Double.parseDouble(a[23]))*((double)Double.parseDouble(a[24]));
					
					elem++;
			}	
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<24;j++) {

			cuerpo+=";;;;;;;;;;;;;"+"\n";

		}
		
		// RESUMEN
		
			// generamos los porcentajes de iva a mostrar
		String p1=" ";
		if (iva1>0) {
			p1=formatoDecimal.format((iva1*100/bas1));
		}
		String p2=" ";
		if (iva2>0) {
			p2=formatoDecimal.format((iva2*100/bas2));
		}
		String p3=" ";
		if (iva3>0) {
			p3=formatoDecimal.format((iva3*100/bas3));
		}
		String resumen=";"+";"+";"+";"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"BASE ;"+"IVA ;"+"TOTAL;\n"+
				";"+";"+";"+";"+"EXENTO 0,00%;"+"EXENTO 0,00%;"+"SUPERRED."+p1+";"+"SUPERRED."+p1+";"+"REDUCIDO "+p2+";"+"REDUCIDO "+p2+
				";"+"GENERAL "+p3+";"+"GENERAL "+p3+";"+"FACTURA;\n";
		
		resumen+=";"+";"+";"+";"+formatoDecimal.format(bas0)+";"+formatoDecimal.format(0)+";"+
				formatoDecimal.format(bas1)+";"+formatoDecimal.format(iva1)+";"+
				formatoDecimal.format(bas2)+";"+formatoDecimal.format(iva2)+";"+
				formatoDecimal.format(bas3)+";"+formatoDecimal.format(iva3)+";"+
				formatoDecimal.format(bas0+bas1+bas2+bas3+iva1+iva2+iva3)+";"+"\n";
		
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="\n\nListado generado por "+SpringFacturacion.nameUsuario;			
		
		String dataToRecording=title+cabeceras+cuerpo+resumen+pie;
		
		//FileRecorder fr=new FileRecorder();
		boolean result=recording.CreateListInvoices("listadoIVA",dataToRecording);
		
		return result;
		
	} // end of method generatesCsvListIva
	
	
	
} // *********** END OF CLASS
