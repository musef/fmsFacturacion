package beansList;


import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import main.SpringFacturacion;

import beansControls.UtilsFacturacion;
import beansModels.Albaranes;
import beansModels.Facturas;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class ListadosPdf extends UtilsFacturacion {
	
	private File myFile;
	private FileOutputStream filePDF;
	private Paragraph parrafoH;
	private Paragraph parrafoF;
	private Paragraph parrafoPaiment;
	private PdfPTable tableH;
	private PdfPTable tableB;
	private PdfPTable tableT;
	private PdfPTable table;
	private String today;
	
	private com.itextpdf.text.Font font2=new com.itextpdf.text.Font();
	
	private DecimalFormat df;

	
	
	public ListadosPdf() {
		// CONSTRUCTOR
		
		df=new DecimalFormat("#,###.00");
		
		// crea el formato de fecha a mostrar
		SimpleDateFormat fecha=new SimpleDateFormat("yyyy-MM-dd");
		// pasa el formato a string, cogiendo la fecha del sistema
		today=fecha.format(new Date());
	}
	
	
	
	/**
	 * Este metodo crea un pdf con la lista de los datos de los clientes suministrada.
	 * 
	 * @param fileName - String, nombre del fichero pdf que queremos producir
	 * @param head - String, cabecera del fichero a producir.
	 * @param customers - List<String[5]> que contiene la lista de los clientes a generar. 
	 * @param foot - String, pie del listado
	 * @return boolean, TRUE o FALSE con el resultado de generación del fichero.
	 */
	
	public boolean getCustomersList(String fileName, String head, List<String[]> customers, String foot)  {
		
		Document listado=new Document();
		
		myFile=new File(fileName+today+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG");
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();
		
		parrafoH=new Paragraph();
		parrafoH.setFont(FontFactory.getFont(FontFactory.HELVETICA, 14));
		parrafoH.add(head);
		
		
		table=new PdfPTable(5);
		table.getDefaultCell().setBorder(0);
	    try {
			table.setTotalWidth(new float[]{ 144, 144,72, 144, 72 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    table.setLockedWidth(true);
		
		table.addCell("CLIENTE");
		table.addCell("DIRECCIÓN");
		table.addCell("CODIGO POSTAL");
		table.addCell("LOCALIDAD");
		table.addCell("N.I.F.");
		
		
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		
		for (String[] a: customers) {
			table.addCell(a[0]);
			table.addCell(a[1]);
			table.addCell(a[2]);
			table.addCell(a[3]);
			table.addCell(a[4]);
		}
		
		parrafoF=new Paragraph();
		parrafoF.add(foot);
		
		font2.setFamily("Arial");
		font2.setSize(12);
		font2.setStyle("Bold");
		parrafoF.setFont(font2);
		parrafoF.setFont(FontFactory.getFont(FontFactory.HELVETICA, 6));
		
		try {
			listado.add(parrafoH);
			listado.add(table);
			listado.add(parrafoF);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getCustomersList
	
	
	
	/**
	 * Este metodo crea un pdf con la lista de las facturas de los clientes seleccionados.
	 * 
	 * @param fileName - String, nombre del fichero pdf que queremos producir
	 * @param head - String, cabecera del fichero a producir.
	 * @param customers - List<String[5]> que contiene la lista de las facturas de clientes. 
	 * @param foot - String, pie del listado
	 * @return boolean, TRUE o FALSE con el resultado de generación del fichero.
	 */
	
	public boolean getCustomersListInvoices(String fileName, String head, List<String[]> customersInv, String foot)  {
		
		Document listado=new Document();

		myFile=new File(fileName+today+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG");
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();
		
		// cabecera del listado
		parrafoH=new Paragraph();
		parrafoH.setFont(FontFactory.getFont(FontFactory.HELVETICA, 14));
		parrafoH.add(head);
		
		// cuerpo del listado
		table=new PdfPTable(7);
		table.getDefaultCell().setBorder(0);
	    try {
			table.setTotalWidth(new float[]{ 144, 72, 72, 72, 72, 72, 72});
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    table.setLockedWidth(true);
		
		table.addCell("CLIENTE");
		table.addCell("SERIE");
		table.addCell("FACTURA");
		table.addCell(" FECHA");
		table.addCell("     BASE");
		table.addCell("      IVA");
		table.addCell("   TOTAL");
				
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		
		for (String[] a: customersInv) {
			table.addCell(a[0]);
			table.addCell(a[1]);
			table.addCell(a[2]);
			table.addCell(a[3]);
			table.addCell(a[4]);
			table.addCell(a[5]);
			table.addCell(a[6]);
			
			// se mete un espacio vacio despues del sumatorio parcial
			if (a[2].isEmpty()) {
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
			}
			
		}
		
		for (int n=customersInv.size();n<25;n++) {
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
		}
		
		Paragraph parrafoB=new Paragraph();
		parrafoB.setFont(FontFactory.getFont(FontFactory.HELVETICA, 8));
		parrafoB.add(table);
		
		// pie del listado
		parrafoF=new Paragraph();
		parrafoF.add(foot);
		
		try {
			listado.add(parrafoH);
			listado.add(parrafoB);
			listado.add(parrafoF);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getCustomersListInvoices
	
	
	
	/**
	 * Este metodo crea un pdf con la lista de los datos de las facturas suministrada.
	 * 
	 * @param fileName - String, nombre del fichero pdf que queremos producir
	 * @param head - String, cabecera del fichero a producir.
	 * @param invoices - List<String[7]> que contiene la lista de los datos de facturas a generar. 
	 * @param foot - String, pie del listado
	 * @return boolean, TRUE o FALSE según se haya generado sin problemas el listado o no.
	 */
	
	public boolean getInvoicesList(String fileName, String head, List<String[]> invoices, String foot)  {
		
		Document listado=new Document();
		
		myFile=new File(fileName+today+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG");
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();
		
		parrafoH=new Paragraph();
		parrafoH.setFont(FontFactory.getFont(FontFactory.HELVETICA, 14));
		parrafoH.add(head);
		
		
		table=new PdfPTable(7);
	    try {
			table.setTotalWidth(new float[]{ 144,66,78,72,72,66,72 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    table.setLockedWidth(true);
		//PdfPCell cell= new PdfPCell();
		
		table.addCell("CLIENTE");
		table.addCell("   SERIE");
		table.addCell(" NÚMERO");
		table.addCell("  FECHA");
		table.addCell("BASE IMPONIBLE");
		table.addCell("CUOTA IVA");
		table.addCell("TOTAL FACTURA");
		
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		
		Chunk chunk; 
		
		double bas=0;
		double cuo=0;
		double tot=0;
		
		double b1=0;
		double c1=0;
		double t1=0;
		
		for (String[] a: invoices) {
			
			b1=0;
			try {
				b1=convertToNumber(a[4]);
				if (b1==-1) b1=0;
			} catch (NumberFormatException nf) {
				b1=0;
			}
			bas=bas+b1;
			
			c1=0;
			try {
				c1=b1=convertToNumber(a[5]);
				if (c1==-1) c1=0;
			} catch (NumberFormatException nf) {
				c1=0;
			}
			cuo=cuo+c1;
			
			t1=0;
			try {
				t1=b1=convertToNumber(a[6]);
				if (t1==-1) t1=0;
			} catch (NumberFormatException nf) {
				t1=0;
			}
			tot=tot+t1;
			
			PdfPCell cellA= new PdfPCell();
		    chunk = new Chunk(a[0], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellA.addElement(chunk);
			table.addCell(cellA);
			
			for (int n=a[1].length();n<10;n++) {
				a[1]=" "+a[1];
			}
			PdfPCell cellB= new PdfPCell();
		    chunk = new Chunk(a[1], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellB.addElement(chunk);
			table.addCell(cellB);
			
			for (int n=a[2].length();n<17;n++) {
				a[2]=" "+a[2];
			}
			PdfPCell cellC= new PdfPCell();
		    chunk = new Chunk(a[2], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellC.addElement(chunk);
			table.addCell(cellC);
			
			PdfPCell cellD= new PdfPCell();
			String fecha=" ";
			if (a[3].length()>=10) {
				fecha=a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4);
			}
		    chunk = new Chunk("  "+fecha, FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellD.addElement(chunk);
			table.addCell(cellD);

			for (int n=a[4].length();n<15;n++) {
				a[4]=" "+a[4];
			}
			PdfPCell cellE= new PdfPCell();
		    chunk = new Chunk(a[4], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellE.addElement(chunk);
			table.addCell(cellE);
			
			for (int n=a[5].length();n<15;n++) {
				a[5]=" "+a[5];
			}
			PdfPCell cellF= new PdfPCell();
		    chunk = new Chunk(a[5], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellF.addElement(chunk);
			table.addCell(cellF);
			
			for (int n=a[6].length();n<15;n++) {
				a[6]=" "+a[6];
			}
			PdfPCell cellG= new PdfPCell();
		    chunk = new Chunk(a[6], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellG.addElement(chunk);
			table.addCell(cellG);
			
		}
		
		
		PdfPTable tableR=new PdfPTable(7);
	    try {
			tableR.setTotalWidth(new float[]{ 144,66,78,72,72,66,72 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    tableR.setLockedWidth(true);
		//PdfPCell cell= new PdfPCell();
		
		tableR.addCell("TOTALES");
		tableR.addCell("   ");
		tableR.addCell(" ");
		tableR.addCell(" ");
		tableR.addCell("TOTAL BASES");
		tableR.addCell("TOTAL CUOTAS");
		tableR.addCell("TOTAL FACTURAS");
		

		// RESUMEN
		tableR.addCell(" ");
		tableR.addCell(" ");
		tableR.addCell(" ");
		tableR.addCell(" ");
		
		PdfPCell cellE= new PdfPCell();
	    chunk = new Chunk(df.format(bas), FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cellE.addElement(chunk);
		tableR.addCell(cellE);

		PdfPCell cellF= new PdfPCell();
	    chunk = new Chunk(df.format(cuo), FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cellF.addElement(chunk);
		tableR.addCell(cellF);

		PdfPCell cellG= new PdfPCell();
	    chunk = new Chunk(df.format(tot), FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cellG.addElement(chunk);
		tableR.addCell(cellG);

		
		// PIE
		parrafoF=new Paragraph();
		parrafoF.add(foot);
		
		
		try {
			listado.add(parrafoH);
			listado.add(table);
			listado.add(tableR);			
			listado.add(parrafoF);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getInvoicesList

	
	
	/**
	 * Este metodo crea un pdf con la relación de los albaranes suministrada.
	 * 
	 * @param fileName - String, nombre del fichero pdf que queremos producir
	 * @param head - String, cabecera del fichero a producir.
	 * @param deliveries - List<String[6]> que contiene la lista de los datos de facturas a generar. 
	 * @param foot - String, pie del listado
	 * @return boolean, TRUE o FALSE según se haya generado sin problemas el listado o no.
	 */
	
	public boolean getDeliveriesList(String fileName, String head, List<String[]> deliveries, String foot)  {
		
		Document listado=new Document();
		
		myFile=new File(fileName+today+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG");
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();
		
		parrafoH=new Paragraph();
		parrafoH.setFont(FontFactory.getFont(FontFactory.HELVETICA, 14));
		parrafoH.add(head);
		
		
		table=new PdfPTable(6);
	    try {
			table.setTotalWidth(new float[]{ 162,86,70,78,78,78 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    table.setLockedWidth(true);
		//PdfPCell cell= new PdfPCell();
		
	    PdfPCell cell1= new PdfPCell();
	    PdfPCell cell2= new PdfPCell();
	    PdfPCell cell3= new PdfPCell();
	    PdfPCell cell4= new PdfPCell();
	    PdfPCell cell5= new PdfPCell();
	    PdfPCell cell6= new PdfPCell();
	    
	    Chunk chunk = new Chunk(" CLIENTE", FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cell1.addElement(chunk);
		table.addCell(cell1);
		chunk= new Chunk("      NÚMERO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell2.addElement(chunk);
		table.addCell(cell2);
		chunk= new Chunk("   FECHA", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell3.addElement(chunk);
		table.addCell(cell3);
		chunk= new Chunk("   BASE IMPONIBLE", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell4.addElement(chunk);
		cell4.setHorizontalAlignment(1);
		table.addCell(cell4);
		chunk= new Chunk("   TOTAL FACTURA", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell5.addElement(chunk);	
		table.addCell(cell5);
		chunk= new Chunk("   ESTADO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell6.addElement(chunk);
		table.addCell(cell6);
		
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		
		for (String[] a: deliveries) {
			
			PdfPCell cellA= new PdfPCell();
		    chunk = new Chunk(a[0], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellA.addElement(chunk);
			table.addCell(cellA);
			
			for (int n=a[1].length();n<15;n++) {
				a[1]=" "+a[1];
			}
			PdfPCell cellB= new PdfPCell();
		    chunk = new Chunk(a[1], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellB.addElement(chunk);
			table.addCell(cellB);
			
			PdfPCell cellC= new PdfPCell();
			String fecha=" ";
			if (a[2].length()>=10) {
				fecha=a[2].substring(8)+a[2].substring(4,8)+a[2].substring(0,4);
			}
		    chunk = new Chunk("  "+fecha, FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellC.addElement(chunk);
			table.addCell(cellC);
			
			for (int n=a[3].length();n<17;n++) {
				a[3]=" "+a[3];
			}
			PdfPCell cellD= new PdfPCell();
		    chunk = new Chunk(a[3], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellD.addElement(chunk);
			table.addCell(cellD);
			
			for (int n=a[4].length();n<17;n++) {
				a[4]=" "+a[4];
			}
			PdfPCell cellE= new PdfPCell();
		    chunk = new Chunk(a[4], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellE.addElement(chunk);
			table.addCell(cellE);
			
			PdfPCell cellF= new PdfPCell();
		    chunk = new Chunk(a[5], FontFactory.getFont(FontFactory.HELVETICA, 10));
		    cellF.addElement(chunk);
			table.addCell(cellF);
			
		}
		
		parrafoF=new Paragraph();
		parrafoF.add(foot);
		
		font2.setFamily("Arial");
		font2.setSize(12);
		font2.setStyle("Bold");
		parrafoF.setFont(font2);
		parrafoF.setFont(FontFactory.getFont(FontFactory.HELVETICA, 6));
		
		try {
			listado.add(parrafoH);
			listado.add(table);
			listado.add(parrafoF);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getDeliveriesList
	

	
	/**
	 * Este metodo genera un pdf de la factura a imprimir.
	 * 
	 * @param fileName - String, nombre del fichero pdf a generar.
	 * @param factura - Facturas, objeto conteniendo los datos de la factura a imprimir
	 * @return - boolean, TRUE or FALSE con el resultado de la impresion.
	 */
	
	public boolean getInvoice(String fileName, Facturas factura)  {
		
		Document listado=new Document();
		
		myFile=new File(fileName+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG GETTING THIS DELIVERY: "+fileName);
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();

		// CABECERA DE LA FACTURA
		
		tableH=new PdfPTable(3);
		tableH.getDefaultCell().setBorder(0);
	    try {
			tableH.setTotalWidth(new float[]{ 204,108,204 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    tableH.setLockedWidth(true);
	    tableH.setHorizontalAlignment(0);
	    
	    tableH.addCell(factura.getNameCompany());
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(factura.getAddressCompany());
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(factura.getPostalCompany()+" - "+factura.getCityCompany());
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(factura.getNifCompany());
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    if (!factura.getSerial().isEmpty()) {
	    	tableH.addCell("FACTURA nº "+factura.getSerial()+"/"+factura.getNumber());
	    } else {
	    	tableH.addCell("FACTURA nº "+factura.getNumber());
	    }
	    
	    tableH.addCell(" ");
		
	    // crea el formato de fecha a mostrar
		SimpleDateFormat fechaCortaESP=new SimpleDateFormat("dd-MM-yyyy",new Locale("es"));
		String fecha=fechaCortaESP.format(factura.getDateF());
	    tableH.addCell("FECHA: "+fecha);

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(factura.getNameCustomer());
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(factura.getAddressCustomer());
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(factura.getPostalCustomer()+" - "+factura.getCityCustomer());
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(factura.getNifCustomer());

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    // CUERPO DE LA FACTURA, CON EL DETALLE
		tableB=new PdfPTable(6);
		tableB.getDefaultCell().setBorder(0);
	    try {
			tableB.setTotalWidth(new float[]{ 72,204,56,56,50,78 });
		} catch (DocumentException e2) {
			e2.printStackTrace();
			return false;
		}
	    tableB.setLockedWidth(true);
	    tableB.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    
	    PdfPCell cell1= new PdfPCell();
	    PdfPCell cell2= new PdfPCell();
	    PdfPCell cell3= new PdfPCell();
	    PdfPCell cell4= new PdfPCell();
	    PdfPCell cell5= new PdfPCell();
	    PdfPCell cell6= new PdfPCell();
	    
	    Chunk chunk = new Chunk(" CODIGO", FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cell1.addElement(chunk);
		tableB.addCell(cell1);
		chunk= new Chunk(" CONCEPTO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell2.addElement(chunk);
		tableB.addCell(cell2);
		chunk= new Chunk("        UDS", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell3.addElement(chunk);
		tableB.addCell(cell3);
		chunk= new Chunk("   PRECIO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell4.addElement(chunk);
		cell4.setHorizontalAlignment(1);
		tableB.addCell(cell4);
		chunk= new Chunk("       IVA", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell5.addElement(chunk);	
		tableB.addCell(cell5);
		chunk= new Chunk("          TOTAL", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell6.addElement(chunk);
		tableB.addCell(cell6);

		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");

		for (String[] a: factura.getDataInvoice()) {
			String sp0="";
			for (int j=a[0].length();j<6;j++) {
				sp0=sp0.concat("  ");
			}
			tableB.addCell(sp0+a[0]);
			
			tableB.addCell(a[1]);
			
			String sp2=" ";
			for (int j=a[2].length();j<6;j++) {
				sp2=sp2.concat("  ");
			}
			tableB.addCell(sp2+a[2]);
			
			String sp3=" ";
			for (int j=a[3].length();j<6;j++) {
				sp3=sp3.concat("  ");
			}
			tableB.addCell(sp3+a[3]);
			
			String sp4="";
			for (int j=a[4].length();j<6;j++) {
				sp4=sp4.concat(" ");
			}
			tableB.addCell(sp4+a[4]+"%");

			String sp5=" ";
			for (int j=a[5].length();j<10;j++) {
				sp5=sp5.concat("  ");
			}
			tableB.addCell(sp5+a[5]);
			
		}
		
		// relleno en blanco
		for (int n=factura.getDataInvoice().size();n<20;n++) {
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");			
		}
		
		// TABLA DE TOTALES DE FACTURA
		
		tableT=new PdfPTable(4);
	    try {
			tableT.setTotalWidth(new float[]{ 144,114,114,144 });
		} catch (DocumentException e3) {
			e3.printStackTrace();
			return false;
		}
	    tableT.setLockedWidth(true);
	    tableT.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    
	    tableT.addCell("    BASE IMPONIBLE");
	    tableT.addCell("   RETENC. IRPF");
	    tableT.addCell("    CUOTA IVA");
	    tableT.addCell("     TOTAL FACTURA");
	    
	    tableT.addCell("            "+df.format(factura.getBaseImponible0()+factura.getBaseImponible1()+factura.getBaseImponible2()+factura.getBaseImponible3()));
	    tableT.addCell("           "+df.format(factura.getRetencion()));
	    tableT.addCell("        "+df.format(factura.getIva1()+factura.getIva2()+factura.getIva3()));
	    tableT.addCell("           "+df.format(factura.getTotalFactura()));

	    // FORMA DE PAGO
	    
	    parrafoPaiment=new Paragraph();
	    if (factura.getDiaPago().isEmpty()) {
	    	parrafoPaiment.add("FORMA DE PAGO: "+factura.getFormaPago());
	    } else {
	    	parrafoPaiment.add("FORMA DE PAGO: "+factura.getFormaPago()+" VENCIMIENTO "+factura.getDiaPago());
	    }
	    
	    
	    // TABLA DE DESGLOSES DE IVA
	    	    
	    Paragraph parrafoDesg=new Paragraph();
	    int numDesg=1;
	    
	    Chunk chunk0 = new Chunk("DESGLOSES DE IVA ", FontFactory.getFont(FontFactory.HELVETICA, 6));
	    chunk0.append("\n");
	    chunk0.append("BASE AL  0,00%..: "+df.format(factura.getBaseImponible0()));
	    chunk0.append(" --> ");
	    chunk0.append("CUOTA AL 0,00%..: 0,00");
	    chunk0.append("\n");
	       
	    if (factura.getIva1()>0) {
	    	
	    	String perc1=df.format(factura.getTipoIva1()*100);
	    	
		    chunk0.append("BASE AL "+perc1+"%..: "+df.format(factura.getBaseImponible1())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc1+"%..: "+df.format(factura.getIva1())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
	    }   

	    if (factura.getIva2()>0) {
	    	
	    	String perc2=df.format(factura.getTipoIva2()*100);
		    
		    chunk0.append("BASE AL "+perc2+"%..: "+df.format(factura.getBaseImponible2())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc2+"%..: "+df.format(factura.getIva2())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
		    
	    }

	    if (factura.getIva3()>0) {
	    	
	    	String perc3=df.format(factura.getTipoIva3()*100);
		    
		    chunk0.append("BASE AL "+perc3+"%..: "+df.format(factura.getBaseImponible3())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc3+"%..: "+df.format(factura.getIva3())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
		    
	    }
	    
	    if (factura.getRetencion()>0) {
	    	
	    	String retI=df.format(factura.getTipoRet()*100);
		    
		    chunk0.append("RETENCIÓN DE IRPF el "+retI+"%, total RETENCION "+df.format(factura.getRetencion())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
	    	
	    }
	    	
	    
	    parrafoDesg.add(chunk0);

		// FRASE FINAL
		parrafoF=new Paragraph();
		Chunk chunkLegend = new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6));
		parrafoF.add(chunkLegend);
		
		Paragraph parrafoSep1=new Paragraph();
		parrafoSep1.add(" ");
		Paragraph parrafoSep2=new Paragraph();
		parrafoSep2.add(" ");
		Paragraph parrafoSep3=new Paragraph();
		parrafoSep3.add(" ");
		Paragraph parrafoSep4=new Paragraph();	
		for (int n=5;n>numDesg;n--) {
			parrafoSep4.add("\n");
		}
		
		try {
			//listado.add(parrafoH);
			listado.add(tableH);
			listado.add(parrafoSep1);
			listado.add(tableB);
			listado.add(parrafoSep2);
			listado.add(tableT);
			listado.add(parrafoSep3);
			listado.add(parrafoPaiment);
			listado.add(parrafoDesg);
			listado.add(parrafoSep4);
			listado.add(parrafoF);
		} catch (DocumentException e4) {
			e4.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getInvoice
	
	
		
	/**
	 * Este metodo genera un pdf del albaran a imprimir.
	 * 
	 * @param fileName - String, nombre del fichero pdf a generar.
	 * @param albaran - Albaranes, objeto conteniendo los datos del albaran a imprimir
	 * @param custName - String, nombre del cliente a imprimir.
	 * @param custAddress - String, dirección del cliente a imprimir.
	 * @param custPost - String, código postal del cliente a imprimir.
	 * @param custCity - String, localidad del cliente a imprimir.
	 * @param custNif - String, nif del cliente a imprimir.
	 * @return - boolean, TRUE or FALSE con el resultado de la impresion.
	 */
	
	public boolean getDelivery(String fileName, Albaranes albaran, String custName, String custAddress, String custPost, String custCity, String custNif )  {
		
		Document listado=new Document();
		
		myFile=new File(fileName+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG GETTING THIS INVOICE: "+fileName);
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();

		// CABECERA DE LA FACTURA
		
		tableH=new PdfPTable(3);
		tableH.getDefaultCell().setBorder(0);
	    try {
			tableH.setTotalWidth(new float[]{ 204,108,204 });
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    tableH.setLockedWidth(true);
	    tableH.setHorizontalAlignment(0);
	    
	    tableH.addCell(SpringFacturacion.nameCompany);
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(SpringFacturacion.addressCompany);
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(SpringFacturacion.cpostalCompany+" - "+SpringFacturacion.cityCompany);
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(SpringFacturacion.nifCompany);
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    tableH.addCell("ALBARÁN nº "+albaran.getNumber());
	    tableH.addCell(" ");
		
	    // crea el formato de fecha a mostrar
		SimpleDateFormat fechaCortaESP=new SimpleDateFormat("dd-MM-yyyy",new Locale("es"));
		String fecha=fechaCortaESP.format(albaran.getDateOper());
	    tableH.addCell("FECHA: "+fecha);

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(custName);
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(custAddress);
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(custPost+" - "+custCity);
	    
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(custNif);

	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    tableH.addCell(" ");
	    
	    // CUERPO DE LA FACTURA, CON EL DETALLE
		tableB=new PdfPTable(6);
		tableB.getDefaultCell().setBorder(0);
	    try {
			tableB.setTotalWidth(new float[]{ 66,204,56,56,56,78 });
		} catch (DocumentException e2) {
			e2.printStackTrace();
			return false;
		}
	    tableB.setLockedWidth(true);
	    tableB.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    
	    PdfPCell cell1= new PdfPCell();
	    PdfPCell cell2= new PdfPCell();
	    PdfPCell cell3= new PdfPCell();
	    PdfPCell cell4= new PdfPCell();
	    PdfPCell cell5= new PdfPCell();
	    PdfPCell cell6= new PdfPCell();
	    
	    Chunk chunk = new Chunk(" CODIGO", FontFactory.getFont(FontFactory.HELVETICA, 10));
	    cell1.addElement(chunk);
		tableB.addCell(cell1);
		chunk= new Chunk(" CONCEPTO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell2.addElement(chunk);
		tableB.addCell(cell2);
		chunk= new Chunk("        UDS", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell3.addElement(chunk);
		tableB.addCell(cell3);
		chunk= new Chunk("   PRECIO", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell4.addElement(chunk);
		cell4.setHorizontalAlignment(1);
		tableB.addCell(cell4);
		chunk= new Chunk("       IVA", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell5.addElement(chunk);	
		tableB.addCell(cell5);
		chunk= new Chunk("          TOTAL", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell6.addElement(chunk);
		tableB.addCell(cell6);

		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");
		tableB.addCell(" ");

		
		 	
		String sp0=" ";
		for (int j=albaran.getCodeOper1().length();j<6;j++) {
			sp0=sp0.concat(" ");
		}
		PdfPCell cellA= new PdfPCell();
		chunk= new Chunk(sp0+albaran.getCodeOper1(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellA.addElement(chunk);
		tableB.addCell(cellA);

		PdfPCell cellB= new PdfPCell();
		chunk= new Chunk(albaran.getTextOper1(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellB.addElement(chunk);
		tableB.addCell(cellB);
		
		String sp2=" ";
		for (int j=0;j<6;j++) {
			sp2=sp2.concat("  ");
		}
		double qtt1=albaran.getQttOper1();
		PdfPCell cellC= new PdfPCell();
		chunk= new Chunk(sp2+df.format(qtt1), FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellC.addElement(chunk);
		tableB.addCell(cellC);

		
		String sp3=" ";
		for (int j=0;j<6;j++) {
			sp3=sp3.concat(" ");
		}
		double pri1=albaran.getPriceOper1();
		PdfPCell cellD= new PdfPCell();
		chunk= new Chunk(sp3+df.format(pri1), FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellD.addElement(chunk);
		tableB.addCell(cellD);
		
		String sp4=" ";
		for (int j=0;j<4;j++) {
			sp4=sp4.concat(" ");
		}
		double iva1=albaran.getIvaOper1();
		PdfPCell cellE= new PdfPCell();
		chunk= new Chunk(sp4+df.format(iva1)+"%", FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellE.addElement(chunk);
		tableB.addCell(cellE);


		String sp5=" ";
		String total1=df.format((qtt1*pri1*iva1/100)+(qtt1*pri1));
		for (int j=total1.length();j<12;j++) {
			sp5=sp5.concat("  ");
		}
		PdfPCell cellF= new PdfPCell();
		chunk= new Chunk(sp5+total1, FontFactory.getFont(FontFactory.HELVETICA, 8));
		cellF.addElement(chunk);
		tableB.addCell(cellF);
		
		if (albaran.getQttOper2()!=0) {
			
			sp0=" ";
			for (int j=albaran.getCodeOper2().length();j<6;j++) {
				sp0=sp0.concat(" ");
			}
			PdfPCell cellA2= new PdfPCell();
			chunk= new Chunk(sp0+albaran.getCodeOper2(), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellA2.addElement(chunk);
			tableB.addCell(cellA2);

			PdfPCell cellB2= new PdfPCell();
			chunk= new Chunk(albaran.getTextOper2(), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellB2.addElement(chunk);
			tableB.addCell(cellB2);
			
			sp2=" ";
			for (int j=0;j<6;j++) {
				sp2=sp2.concat("  ");
			}
			double qtt2=albaran.getQttOper2();
			PdfPCell cellC2= new PdfPCell();
			chunk= new Chunk(sp2+df.format(qtt2), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellC2.addElement(chunk);
			tableB.addCell(cellC2);
			
			sp3=" ";
			for (int j=0;j<6;j++) {
				sp3=sp3.concat(" ");
			}
			double pri2=albaran.getPriceOper2();
			PdfPCell cellD2= new PdfPCell();
			chunk= new Chunk(sp3+df.format(pri2), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellD2.addElement(chunk);
			tableB.addCell(cellD2);
			
			sp4=" ";
			for (int j=0;j<4;j++) {
				sp4=sp4.concat(" ");
			}
			double iva2=albaran.getIvaOper2();
			PdfPCell cellE2= new PdfPCell();
			chunk= new Chunk(sp4+df.format(iva2)+"%", FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellE2.addElement(chunk);
			tableB.addCell(cellE2);


			sp5=" ";
			String total2=(df.format((qtt2*pri2*iva2/100)+(qtt2*pri2)));
			for (int j=total2.length();j<12;j++) {
				sp5=sp5.concat("  ");
			}
			PdfPCell cellF2= new PdfPCell();
			chunk= new Chunk(sp5+total2, FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellF2.addElement(chunk);
			tableB.addCell(cellF2);
			
			
			/*
			tableB.addCell(sp0+albaran.getCodeOper2());
			tableB.addCell(albaran.getTextOper2());
			double qtt2=albaran.getQttOper2();
			tableB.addCell(sp2+df.format(qtt2));
			double pri2=albaran.getPriceOper2();
			tableB.addCell(sp3+df.format(pri2));
			double iva2=albaran.getIvaOper2();
			tableB.addCell(sp4+df.format(iva2)+"%");
			tableB.addCell(sp5+(df.format((qtt2*pri2*iva2/100)+(qtt2*pri2))));
			*/
		} else {
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
		}

		if (albaran.getQttOper3()!=0) {
			
			sp0=" ";
			for (int j=albaran.getCodeOper3().length();j<6;j++) {
				sp0=sp0.concat(" ");
			}
			PdfPCell cellA3= new PdfPCell();
			chunk= new Chunk(sp0+albaran.getCodeOper3(), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellA3.addElement(chunk);
			tableB.addCell(cellA3);

			PdfPCell cellB3= new PdfPCell();
			chunk= new Chunk(albaran.getTextOper3(), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellB3.addElement(chunk);
			tableB.addCell(cellB3);
			
			sp2=" ";
			for (int j=0;j<6;j++) {
				sp2=sp2.concat("  ");
			}
			double qtt3=albaran.getQttOper3();
			PdfPCell cellC3= new PdfPCell();
			chunk= new Chunk(sp2+df.format(qtt3), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellC3.addElement(chunk);
			tableB.addCell(cellC3);

			
			sp3=" ";
			for (int j=0;j<6;j++) {
				sp3=sp3.concat(" ");
			}
			double pri3=albaran.getPriceOper3();
			PdfPCell cellD3= new PdfPCell();
			chunk= new Chunk(sp3+df.format(pri3), FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellD3.addElement(chunk);
			tableB.addCell(cellD3);
			
			sp4=" ";
			for (int j=0;j<4;j++) {
				sp4=sp4.concat(" ");
			}
			double iva3=albaran.getIvaOper3();
			PdfPCell cellE3= new PdfPCell();
			chunk= new Chunk(sp4+df.format(iva3)+"%", FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellE3.addElement(chunk);
			tableB.addCell(cellE3);


			sp5=" ";
			String total3=df.format((qtt3*pri3*iva3/100)+(qtt3*pri3));
			for (int j=total3.length();j<12;j++) {
				sp5=sp5.concat("  ");
			}
			PdfPCell cellF3= new PdfPCell();
			chunk= new Chunk(sp5+total3, FontFactory.getFont(FontFactory.HELVETICA, 8));
			cellF3.addElement(chunk);
			tableB.addCell(cellF3);
			
			
			/*
			tableB.addCell(sp0+albaran.getCodeOper3());
			tableB.addCell(albaran.getTextOper3());
			double qtt3=albaran.getQttOper3();
			tableB.addCell(sp2+df.format(qtt3));
			double pri3=albaran.getPriceOper3();
			tableB.addCell(sp3+df.format(pri3));
			double iva3=albaran.getIvaOper3();
			tableB.addCell(sp4+df.format(iva3)+"%");
			tableB.addCell(sp5+(df.format((qtt3*pri3*iva3/100)+(qtt3*pri3))));
			*/
		} else {
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
			tableB.addCell(" ");
		}

		
		// TABLA DE TOTALES DE FACTURA
		
		tableT=new PdfPTable(4);
	    try {
			tableT.setTotalWidth(new float[]{ 144,114,114,144 });
		} catch (DocumentException e3) {
			e3.printStackTrace();
			return false;
		}
	    tableT.setLockedWidth(true);
	    tableT.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    
	    tableT.addCell("    BASE IMPONIBLE");
	    tableT.addCell("   RETENC. IRPF");
	    tableT.addCell("    CUOTA IVA");
	    tableT.addCell("     TOTAL ALBARÁN");
	    
	    tableT.addCell("            "+df.format(albaran.getBaseImponible0()+albaran.getBaseImponible1()+albaran.getBaseImponible2()+albaran.getBaseImponible3()));
	    tableT.addCell("           "+df.format(albaran.getRetencion()));
	    tableT.addCell("        "+df.format(albaran.getIva1()+albaran.getIva2()+albaran.getIva3()));
	    tableT.addCell("           "+df.format(albaran.getTotalAlbaran()));

	    
	    
	    // TABLA DE DESGLOSES DE IVA
	    	    
	    Paragraph parrafoDesg=new Paragraph();
	    int numDesg=1;
	    
	    Chunk chunk0 = new Chunk("DESGLOSES DE IVA ", FontFactory.getFont(FontFactory.HELVETICA, 6));
	    chunk0.append("\n");
	    chunk0.append("BASE AL  0,00%..: "+df.format(albaran.getBaseImponible0()));
	    chunk0.append(" --> ");
	    chunk0.append("CUOTA AL 0,00%..: 0,00");
	    chunk0.append("\n");
	       
	    if (albaran.getIva1()>0) {
	    	
	    	String perc1=df.format(albaran.getTipoIva1()*100);
	    	
		    chunk0.append("BASE AL "+perc1+"%..: "+df.format(albaran.getBaseImponible1())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc1+"%..: "+df.format(albaran.getIva1())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
	    }   

	    if (albaran.getIva2()>0) {
	    	
	    	String perc2=df.format(albaran.getTipoIva2()*100);
		    
		    chunk0.append("BASE AL "+perc2+"%..: "+df.format(albaran.getBaseImponible2())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc2+"%..: "+df.format(albaran.getIva2())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
		    
	    }

	    if (albaran.getIva3()>0) {
	    	
	    	String perc3=df.format(albaran.getTipoIva3()*100);
		    
		    chunk0.append("BASE AL "+perc3+"%..: "+df.format(albaran.getBaseImponible3())+" euros");
		    chunk0.append(" --> ");
		    chunk0.append("CUOTA AL "+perc3+"%..: "+df.format(albaran.getIva3())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
		    
	    }
	    
	    if (albaran.getRetencion()>0) {
	    	
	    	String retI=df.format(albaran.getTipoRet()*100);
		    
		    chunk0.append("RETENCIÓN DE IRPF el "+retI+"%, total RETENCION "+df.format(albaran.getRetencion())+" euros");
		    chunk0.append("\n");
		    
		    numDesg++;
	    	
	    }
	    	
	    
	    parrafoDesg.add(chunk0);

		// FRASE FINAL
	    /*
		parrafoF=new Paragraph();
		Chunk chunkLegend = new Chunk("Empresa registrada en el Registro Mercantil Folio 22 ", FontFactory.getFont(FontFactory.HELVETICA, 6));
		parrafoF.add(chunkLegend);
		*/
	    
		Paragraph parrafoSep1=new Paragraph();
		parrafoSep1.add(" ");
		Paragraph parrafoSep2=new Paragraph();
		parrafoSep2.add(" ");
		Paragraph parrafoSep3=new Paragraph();
		parrafoSep3.add(" ");
		Paragraph parrafoSep4=new Paragraph();	
		for (int n=5;n>numDesg;n--) {
			parrafoSep4.add("\n");
		}
		
		try {
			//listado.add(parrafoH);
			listado.add(tableH);
			listado.add(parrafoSep1);
			listado.add(tableB);
			listado.add(parrafoSep2);
			listado.add(tableT);
			listado.add(parrafoSep3);
			listado.add(parrafoDesg);
			listado.add(parrafoSep4);
			//listado.add(parrafoF);
		} catch (DocumentException e4) {
			e4.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getDelivery
	
	
	
	/**
	 * Este metodo crea un pdf con el listado de IVA repercutido generado.
	 * 
	 * @param fileName - String, nombre del fichero pdf que queremos generar.
	 * @param head - String, cabecera del fichero a producir.
	 * @param invoices - List<String[13]> que contiene la lista de los datos de facturas a generar. 
	 * @param summatory - List<String[13]> que contiene la lista de los sumatorios totales de facturas a generar.
	 * @param foot - String, pie del listado
	 * @return boolean, TRUE o FALSE según se haya generado sin problemas el listado o no.
	 */
	
	public boolean getIvaList(String fileName, String head, List<String[]> invoices, List<String[]> summatory, String foot)  {
		
		Document listado=new Document(PageSize.A4.rotate());
		
		myFile=new File(fileName+today+".pdf");
		try {
			filePDF=new FileOutputStream(myFile);
		} catch (Exception ex) {
			System.err.println("SOMETHING WAS WRONG");
			return false;
		}
		try {
			PdfWriter.getInstance(listado, filePDF).setInitialLeading(20);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		listado.open();
		
		parrafoH=new Paragraph();
		parrafoH.setFont(FontFactory.getFont(FontFactory.HELVETICA, 14));
		parrafoH.add(head);
		
		
		table=new PdfPTable(13);
	    try {
			table.setTotalWidth(new float[]{60,60,60,132,60,54,60,54,60,54,60,54,60});
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    table.setLockedWidth(true);
		//PdfPCell cell= new PdfPCell();
		
		/*
		table.addCell("   SERIE");
		table.addCell(" NÚMERO");
		table.addCell("  FECHA");
		table.addCell("CLIENTE");
		table.addCell("BASE IMPONIBLE");
		table.addCell("CUOTA IVA");
		table.addCell("TOTAL FACTURA");
		
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		*/
		
		
		double bas=0;
		double cuo=0;
		double tot=0;
		
		double b1=0;
		double c1=0;
		double t1=0;
		
		for (String[] a: invoices) {
			
			b1=0;
			try {
				b1=convertToNumber(a[4]);
				if (b1==-1) b1=0;
			} catch (NumberFormatException nf) {
				b1=0;
			}
			bas=bas+b1;
			
			c1=0;
			try {
				c1=convertToNumber(a[5]);
				if (c1==-1) c1=0;
			} catch (NumberFormatException nf) {
				c1=0;
			}
			cuo=cuo+c1;
			
			t1=0;
			try {
				t1=convertToNumber(a[6]);
				if (t1==-1) t1=0;
			} catch (NumberFormatException nf) {
				t1=0;
			}
			tot=tot+t1;
			

			PdfPCell cellA= new PdfPCell();
			Chunk chunk = new Chunk(" "+a[0], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellA.addElement(chunk);
			table.addCell(cellA);
			
			for (int n=a[1].length();n<10;n++) {
				a[1]=" "+a[1];
			}
			PdfPCell cellB= new PdfPCell();
		    chunk = new Chunk(a[1], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellB.addElement(chunk);
			table.addCell(cellB);
			/*
			String fecha=" ";
			if (a[2].length()>=10) {
				fecha=a[2].substring(8)+a[2].substring(4,8)+a[2].substring(0,4);
			}
			*/
			PdfPCell cellC= new PdfPCell();
		    chunk = new Chunk(a[2], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellC.addElement(chunk);
			table.addCell(cellC);
			
			PdfPCell cellD= new PdfPCell();
		    chunk = new Chunk(a[3], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellD.addElement(chunk);
			table.addCell(cellD);
			
			for (int n=a[4].length();n<15;n++) {
				a[4]=" "+a[4];
			}
			PdfPCell cellE= new PdfPCell();
		    chunk = new Chunk(a[4], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellE.addElement(chunk);
			table.addCell(cellE);
			
			for (int n=a[5].length();n<15;n++) {
				a[5]=" "+a[5];
			}
			PdfPCell cellF= new PdfPCell();
		    chunk = new Chunk(a[5], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellF.addElement(chunk);
			table.addCell(cellF);
			
			for (int n=a[6].length();n<15;n++) {
				a[6]=" "+a[6];
			}
			PdfPCell cellG= new PdfPCell();
		    chunk = new Chunk(a[6], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellG.addElement(chunk);
			table.addCell(cellG);
			
			for (int n=a[7].length();n<15;n++) {
				a[7]=" "+a[7];
			}
			PdfPCell cellH= new PdfPCell();
		    chunk = new Chunk(a[7], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellH.addElement(chunk);
			table.addCell(cellH);
			
			for (int n=a[8].length();n<10;n++) {
				a[8]=" "+a[8];
			}
			PdfPCell cellI= new PdfPCell();
		    chunk = new Chunk(a[8], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellI.addElement(chunk);
			table.addCell(cellI);
			
			for (int n=a[9].length();n<10;n++) {
				a[9]=" "+a[9];
			}
			PdfPCell cellJ= new PdfPCell();
		    chunk = new Chunk(a[9], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellJ.addElement(chunk);
			table.addCell(cellJ);
			
			for (int n=a[10].length();n<15;n++) {
				a[10]=" "+a[10];
			}
			PdfPCell cellK= new PdfPCell();
		    chunk = new Chunk(a[10], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellK.addElement(chunk);
			table.addCell(cellK);
			
			for (int n=a[11].length();n<10;n++) {
				a[11]=" "+a[11];
			}
			PdfPCell cellL= new PdfPCell();
		    chunk = new Chunk(a[11], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellL.addElement(chunk);
			table.addCell(cellL);
			
			String sp12="";
			for (int n=a[12].length();n<15;n++) {
				sp12=sp12+" ";
				}
			PdfPCell cellM= new PdfPCell();
		    chunk = new Chunk(sp12+a[12], FontFactory.getFont(FontFactory.HELVETICA, 9));
		    cellM.addElement(chunk);
			table.addCell(cellM);
			
		}
		
		
		PdfPTable tableR=new PdfPTable(13);
	    try {
			tableR.setTotalWidth(new float[]{60,60,60,132,60,54,60,54,60,54,60,54,60});
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return false;
		}
	    tableR.setLockedWidth(true);
		//PdfPCell cell= new PdfPCell();
		
		
		for (String[] a: summatory) {
			
			b1=0;
			try {
				b1=convertToNumber(a[4]);
				if (b1==-1) b1=0;
			} catch (NumberFormatException nf) {
				b1=0;
			}
			bas=bas+b1;
			
			c1=0;
			try {
				c1=convertToNumber(a[5]);
				if (c1==-1) c1=0;
			} catch (NumberFormatException nf) {
				c1=0;
			}
			cuo=cuo+c1;
			
			t1=0;
			try {
				t1=convertToNumber(a[6]);
				if (t1==-1) t1=0;
			} catch (NumberFormatException nf) {
				t1=0;
			}
			tot=tot+t1;
			

			PdfPCell cellA= new PdfPCell();
			Chunk chunk = new Chunk(" "+a[0], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellA.addElement(chunk);
			tableR.addCell(cellA);
			

			PdfPCell cellB= new PdfPCell();
		    chunk = new Chunk(a[1], FontFactory.getFont(FontFactory.HELVETICA, 9,Font.BOLD));
		    cellB.addElement(chunk);
			tableR.addCell(cellB);
			
			String fecha=" ";
			if (a[2].length()>=10) {
				fecha=a[2].substring(8)+a[2].substring(4,8)+a[2].substring(0,4);
			}
			PdfPCell cellC= new PdfPCell();
		    chunk = new Chunk(fecha, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellC.addElement(chunk);
			tableR.addCell(cellC);
			
			PdfPCell cellD= new PdfPCell();
		    chunk = new Chunk(a[3], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellD.addElement(chunk);
			tableR.addCell(cellD);
			

			PdfPCell cellE= new PdfPCell();
		    chunk = new Chunk(a[4], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellE.addElement(chunk);
			tableR.addCell(cellE);
			

			PdfPCell cellF= new PdfPCell();
		    chunk = new Chunk(a[5], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellF.addElement(chunk);
			tableR.addCell(cellF);
			

			PdfPCell cellG= new PdfPCell();
		    chunk = new Chunk(a[6], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellG.addElement(chunk);
			tableR.addCell(cellG);
			

			PdfPCell cellH= new PdfPCell();
		    chunk = new Chunk(a[7], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellH.addElement(chunk);
			tableR.addCell(cellH);
			

			PdfPCell cellI= new PdfPCell();
		    chunk = new Chunk(a[8], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellI.addElement(chunk);
			tableR.addCell(cellI);
			

			PdfPCell cellJ= new PdfPCell();
		    chunk = new Chunk(a[9], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellJ.addElement(chunk);
			tableR.addCell(cellJ);
			

			PdfPCell cellK= new PdfPCell();
		    chunk = new Chunk(a[10], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellK.addElement(chunk);
			tableR.addCell(cellK);
			

			PdfPCell cellL= new PdfPCell();
		    chunk = new Chunk(a[11], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellL.addElement(chunk);
			tableR.addCell(cellL);
			
			String sp12="";

			PdfPCell cellM= new PdfPCell();
		    chunk = new Chunk(sp12+a[12], FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD));
		    cellM.addElement(chunk);
			tableR.addCell(cellM);
			
		}

		

		
		// PIE
		parrafoF=new Paragraph();
		parrafoF.add(foot);
		
		
		try {
			listado.add(parrafoH);
			listado.add(table);
			listado.add(tableR);			
			listado.add(parrafoF);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			listado.close();
		} catch (Exception io) {
			return false;
		}
		
		return true;
		
	} // end of method getIvaList
	
	
	
	
	
} // ***************** END OF CLASS 
