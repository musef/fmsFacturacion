package beansViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import main.SpringFacturacion;

import beansControls.ClockAndDate;
import beansControls.FacturasBean;

import beansList.ListadosCsv;
import beansList.ListadosPdf;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicesIva implements ActionListener, ItemListener {
	
	private JFrame mainFrame;
	private JPanel marcoAux1;
	
	// OBJETOS SPRING
	private ClockAndDate dateEsp;
	private FacturasBean facturador;
	private ListadosPdf dataList;
	private ListadosCsv dataListCsv;
	
	
	// LISTAR FACTURAS
	private List<String[]> listInvoices;
	private List<String[]> listSelectedInvoices;
	private JComboBox<String> firstInvoice;
	private JComboBox<String> lastInvoice;
	private JTextField firstDate;
	private JTextField lastDate;

	private JButton botonPDF;
	private JButton botonCSV;
	private JButton info;
	
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Font font3=new Font("SansSerif", Font.PLAIN, 14);
	private Font font4=new Font("SansSerif", Font.PLAIN, 12);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private final Color COLORL=Color.BLACK;
	
	
	
	public PanelInvoicesIva() {
		// CONSTRUCTOR
	}
	

	public void setDateEsp (ClockAndDate date) {
		// spring
		this.dateEsp=date;	
	}
	
	public void setFacturador (FacturasBean fact) {
		// spring
		this.facturador=fact;
	}
	
	public void setDataList(ListadosPdf dataList) {
		// spring
		this.dataList = dataList;
	}
	
	public void setDataListCsv(ListadosCsv dataListCsv) {
		// spring
		this.dataListCsv = dataListCsv;
	}
	
	
	
	
	/**
	 * Método que permite la selección de la facturas a imprimir, mostrándola en el panel.
	 * 
	 * @return - un JPanel componiendo la pantalla de seleccion de facturas
	 */
	
	public JPanel printListInvoicesIva(JFrame mainFrame) {
			
		this.mainFrame=mainFrame;

		int fInv=0;
		int lInv=0;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		JPanel marcoAux0=new JPanel();
		marcoAux0.setMinimumSize(new Dimension(650,30));
		marcoAux0.setPreferredSize(new Dimension(650,30));
		marcoAux0.setMaximumSize(new Dimension(650,30));

		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,500));
		marcoAux1.setPreferredSize(new Dimension(650,500));
		marcoAux1.setMaximumSize(new Dimension(650,500));
		
		// creamos los combobox
		firstInvoice=new JComboBox<String>();
		firstInvoice.addItem("Factura inicial... ");
		if ((listInvoices=facturador.searchExtractInvoices())==null) {
			listInvoices=new ArrayList<String[]>();
		}
		if ((listSelectedInvoices=facturador.searchExtractInvoices())==null) {
			listSelectedInvoices=new ArrayList<String[]>();
		}
		;
		for (String[] list:listInvoices) {
			firstInvoice.addItem(list[1]);
		}
		firstInvoice.setSelectedIndex(fInv);

		lastInvoice=new JComboBox<String>();
		lastInvoice.addItem("Factura final... ");
		for (String[] list:listInvoices) {
			lastInvoice.addItem(list[1]);
		}
		lastInvoice.setSelectedIndex(lInv);
		
		
		// titulo
		JLabel title=new JLabel("LISTADO DE FACTURAS I.V.A. REPERCUTIDO");
		title.setFont(font1);
		
		// creamos el formulario
		JLabel name1=new JLabel("Desde fecha... ");
		name1.setFont(font2);
		firstDate=new JTextField("01-01-"+dateEsp.getDate().substring(6));

		JLabel name2=new JLabel("Hasta fecha... ");
		name2.setFont(font2);
		lastDate=new JTextField("31-12-"+dateEsp.getDate().substring(6));
		
		JLabel inv1=new JLabel("Desde factura... ");
		inv1.setFont(font2);

		JLabel inv2=new JLabel("Hasta factura... ");
		inv2.setFont(font2);
		
	
		// preparamos los botones

		JPanel buttonPane=new JPanel();
		Dimension button=new Dimension(25,10);
		buttonPane.setPreferredSize(button);
		buttonPane.setMaximumSize(button);
		JButton listar=new JButton("Listar");
		listar.setToolTipText("pulse para listar las facturas");
		buttonPane.add(listar);
		
		ImageIcon icon = new ImageIcon("src/images/info.png");
		info=new JButton(icon);
		info.setBorderPainted(true);
		info.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		info.setMargin(m);
		info.setToolTipText("pulse para información");
		info.setActionCommand("info");
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		panelButton3.add(info);
		Dimension dimP=new Dimension(60,40);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);

		// añadimos todos los elementos a los JPanel auxiliares
		marcoAux0.add(title);
		
		marcoAux1.setLayout(new GridLayout(14,4));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton3);
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name1);
		marcoAux1.add(firstDate);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name2);
		marcoAux1.add(lastDate);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
			
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(inv1);
		marcoAux1.add(firstInvoice);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(inv2);
		marcoAux1.add(lastInvoice);
		marcoAux1.add(new JLabel(" "));
		

			
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(buttonPane);
		marcoAux1.add(new JLabel(""));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0,BorderLayout.NORTH);
		marco2.add(marcoAux1,BorderLayout.CENTER);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		listar.addActionListener(this);
		info.addActionListener(this);
		firstInvoice.addItemListener(this);
		lastInvoice.addItemListener(this);
		
		return marco2;	
	
		
	} // end of printInvoices
	
	
	
	/**
	 * Este metodo muestra un JFrame con el listado de facturas seleccionado, dando la opcion para imprimir en PDF o en TXT 
	 * @return
	 */
	
	private JFrame showListInvoices( List<String[]>listSelectedInvoices, String dat1, String dat2, long inv1, long inv2) {
		
		JFrame frameList=new JFrame("Listado de I.V.A.");
		frameList.setBounds(25, 25, 900, 700);
		frameList.setLocationByPlatform(true);
		frameList.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameList.setLocationByPlatform(false);
		JPanel marco3=new JPanel();
		BoxLayout bLayout=new BoxLayout(marco3,BoxLayout.Y_AXIS);
		marco3.setLayout(bLayout);
		

		// CABECERA
		JPanel marcoTit=new JPanel();
		JLabel title=new JLabel("LISTADO DE I.V.A. REPERCUTIDO desde "+dat1+" al "+dat2);
		title.setFont(font1);
		marcoTit.add(title);
		
		// CUERPO
		
		// CREAMOS UNA VISUALIZACION DE 25 LINEAS
		JPanel marcoList=new JPanel();
		int listRows=listSelectedInvoices.size()+4;
		if (listRows<26) {
			listRows=26;
		}
		GridLayout layout=new GridLayout(listRows,13);
		marcoList.setLayout(layout);
	
		marcoList.add(new JLabel("  SERIE"));
		marcoList.add(new JLabel("  FACTURA"));
		marcoList.add(new JLabel("  FECHA"));
		marcoList.add(new JLabel("  CLIENTE"));
		marcoList.add(new JLabel("  BASE 0%"));
		marcoList.add(new JLabel("  IVA 0%"));
		marcoList.add(new JLabel("  BASE SUPERRED."));
		marcoList.add(new JLabel("  IVA SUPERRED."));
		marcoList.add(new JLabel("  BASE REDUC."));
		marcoList.add(new JLabel("  IVA REDUCIDO"));
		marcoList.add(new JLabel("  BASE GENERAL"));
		marcoList.add(new JLabel("  IVA GENERAL"));
		marcoList.add(new JLabel("   TOTAL"));


		int elem=0;
		double bas0=0;
		double iva0=0;
		double bas1=0;
		double iva1=0;
		double bas2=0;
		double iva2=0;
		double bas3=0;
		double iva3=0;
		double totbas=0;
		double totiva=0;
		double total=0;
		
		// convierte fechas para comparacion
		String d1=dat1.substring(6)+dat1.substring(2, 6)+dat1.substring(0, 2);
		String d2=dat2.substring(6)+dat2.substring(2, 6)+dat2.substring(0, 2);		
		
		for (String a[]:listSelectedInvoices) {
			
			long num=0;
			try {
				num=(long)Long.parseLong(a[1]);
			} catch (NumberFormatException nf) {
				num=0;
			}
			
		
			// Seleccionamos los datos en funcion de los filtros del formulario
			if (num>=inv1 && num<=inv2 && a[3].compareTo(d1)>=0 && a[3].compareTo(d2)<=0) {
							
				String sp=" ";
				marcoList.add(labelFont(a[2]));
				marcoList.add(labelFont(a[1]));
				marcoList.add(labelFont(a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4)));
				marcoList.add(labelFont(a[11]));
				sp=" ";
				String bs0=formatoDecimal.format(((double)Double.parseDouble(a[16])));
				for (int n=bs0.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+bs0));
				
				marcoList.add(labelFont("          "+formatoDecimal.format((double)Double.parseDouble("0"))));
				
				sp=" ";
				String bs1=formatoDecimal.format(((double)Double.parseDouble(a[17])));
				for (int n=bs1.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+bs1));
				
				sp=" ";
				String iv1=formatoDecimal.format(((double)Double.parseDouble(a[17]))*((double)Double.parseDouble(a[18])));
				for (int n=iv1.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+iv1));
				
				sp=" ";
				String bs2=formatoDecimal.format(((double)Double.parseDouble(a[20])));
				for (int n=bs2.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+bs2));
				
				sp=" ";
				String iv2=formatoDecimal.format(((double)Double.parseDouble(a[20]))*((double)Double.parseDouble(a[21])));
				for (int n=iv2.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+iv2));
				
				sp=" ";
				String bs3=formatoDecimal.format(((double)Double.parseDouble(a[23])));
				for (int n=bs3.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+bs3));
				
				sp=" ";
				String iv3=formatoDecimal.format(((double)Double.parseDouble(a[23]))*((double)Double.parseDouble(a[24])));
				for (int n=iv3.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+iv3));
				
				sp=" ";
				String tot=formatoDecimal.format((double)Double.parseDouble(a[28]));
				for (int n=tot.length();n<10;n++ ) {
					sp=sp+"  ";
				}
				marcoList.add(labelFont(sp+tot));
				
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
		
		totbas=bas0+bas1+bas2+bas3;
		totiva=iva0+iva1+iva2+iva3;
		total=totbas+totiva;
		
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<listRows-4;j++) {

			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));

		}
		
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel("TOTALES:..."));
		marcoList.add(new JLabel("BASE"));
		marcoList.add(new JLabel("IVA"));
		marcoList.add(new JLabel("BASE"));
		marcoList.add(new JLabel("IVA"));
		marcoList.add(new JLabel("BASE"));
		marcoList.add(new JLabel("IVA"));
		marcoList.add(new JLabel("BASE"));
		marcoList.add(new JLabel("IVA"));
		marcoList.add(new JLabel("TOTAL"));
		
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel("EXENTO 0%"));
		marcoList.add(new JLabel("EXENTO 0%"));
		marcoList.add(new JLabel("SUPERRED."+formatoDecimal.format((iva1*100/bas1))+"%"));
		marcoList.add(new JLabel("SUPERRED."+formatoDecimal.format((iva1*100/bas1))+"%"));
		marcoList.add(new JLabel("REDUCIDO "+formatoDecimal.format((iva2*100/bas2))+"%"));
		marcoList.add(new JLabel("REDUCIDO "+formatoDecimal.format((iva2*100/bas2))+"%"));
		marcoList.add(new JLabel("GENERAL "+formatoDecimal.format((iva3*100/bas3))+"%"));
		marcoList.add(new JLabel("GENERAL "+formatoDecimal.format((iva3*100/bas3))+"%"));
		marcoList.add(new JLabel("IMPORTES"));
		
		marcoList.add(labelFont(""));
		marcoList.add(labelFont(""));
		marcoList.add(labelFont(""));
		marcoList.add(labelFont(""));
		marcoList.add(labelFont(formatoDecimal.format((bas0))));
		marcoList.add(labelFont(formatoDecimal.format((iva0))));
		marcoList.add(labelFont(formatoDecimal.format((bas1))));
		marcoList.add(labelFont(formatoDecimal.format((iva1))));
		marcoList.add(labelFont(formatoDecimal.format((bas2))));
		marcoList.add(labelFont(formatoDecimal.format((iva2))));
		marcoList.add(labelFont(formatoDecimal.format((bas3))));
		marcoList.add(labelFont(formatoDecimal.format((iva3))));
		marcoList.add(labelFont(formatoDecimal.format((total))));
	
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String foot="\n\nListado generado por "+SpringFacturacion.nameUsuario+" el "+dateEsp.showMeTheDate();			
		
		// BOTONES
		JPanel panelButtons=new JPanel();
		panelButtons.setLayout(new GridLayout(3,6));
		botonPDF=new JButton("Generar .PDF");
		botonPDF.setToolTipText("Pulse para generar un fichero PDF");
		botonCSV=new JButton("Generar .CSV");
		botonPDF.setToolTipText("Pulse para generar un fichero CSV legible por excel");
		botonPDF.addActionListener(this);
		botonCSV.addActionListener(this);
		
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		
		panelButtons.add(new JLabel(""));
		panelButtons.add(botonPDF);
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(botonCSV);
		panelButtons.add(new JLabel(""));
		
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		panelButtons.add(new JLabel(""));
		
		

		JLabel foo=new JLabel(foot);
		foo.setFont(font4);
		marcoList.setFont(font3);
		
		marco3.add(marcoTit);
		marco3.add(marcoList);
		marco3.add(foo);
		marco3.add(panelButtons);
		
		frameList.add(marco3);
		
		frameList.setVisible(true);
		
		return frameList;
		
	}  // end of method showListInvoices
	
	
	

	
	
	
	/**
	 * Este metodo genera un fichero PDF.
	 * 
	 * @return
	 */
	
	private boolean generatesPdfFile(List<String[]>listSelectedInvoices, String dat1, String dat2, long inv1, long inv2) {
		
		// CABECERA
		String titulo="LISTADO DE FACTURAS I.V.A. REPERCUTIDO\ndel "+dat1+" al "+dat2+"\n\n";
		
		// CUERPO
		List<String[]> cuerpo=new ArrayList<String[]>();
		
		double bas0=0;
		double bas1=0;
		double iva1=0;
		double bas2=0;
		double iva2=0;
		double bas3=0;
		double iva3=0;
		
		
		String data[]=new String[13];
		data[0]=" SERIE";
		data[1]=" FACTURA";
		data[2]=" FECHA";
		data[3]=" CLIENTE";
		data[4]=" BASE EXENTA";
		data[5]=" IVA EXENTO";
		data[6]=" BASE SUP.RED.";
		data[7]=" IVA SUP.RED.";
		data[8]=" BASE REDUCIDO";
		data[9]=" IVA REDUCIDO";
		data[10]=" BASE GENERAL";
		data[11]=" IVA GENERAL";
		data[12]="  TOTAL";
		cuerpo.add(data);

		
	
			
		// convierte fechas para comparacion
		String d1=dat1.substring(6)+dat1.substring(2, 6)+dat1.substring(0, 2);
		String d2=dat2.substring(6)+dat2.substring(2, 6)+dat2.substring(0, 2);		
		
		for (String a[]:listSelectedInvoices) {
					
			long num=0;
			try {
				num=(long)Long.parseLong(a[1]);
			} catch (NumberFormatException nf) {
				num=0;
			}
			
		
			// Seleccionamos los datos en funcion de los filtros del formulario
			if (num>=inv1 && num<=inv2 && a[3].compareTo(d1)>=0 && a[3].compareTo(d2)<=0) {
								
				//double bas=(double)Double.parseDouble(a[16])+(double)Double.parseDouble(a[17])+(double)Double.parseDouble(a[20])+(double)Double.parseDouble(a[23]);
				//double tot=(double)Double.parseDouble(a[28]);
				//double iva=tot-bas;
				
				
				data=new String[13];
				data[0]=a[2];
				data[1]=a[1];
				data[2]=a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4);
				data[3]=a[11];
				data[4]=formatoDecimal.format((double)Double.parseDouble(a[16]));
				data[5]=formatoDecimal.format(0);
				data[6]=formatoDecimal.format((double)Double.parseDouble(a[17]));
				data[7]=formatoDecimal.format(((double)Double.parseDouble(a[17]))*((double)Double.parseDouble(a[18])));
				data[8]=formatoDecimal.format((double)Double.parseDouble(a[20]));
				data[9]=formatoDecimal.format(((double)Double.parseDouble(a[20]))*((double)Double.parseDouble(a[21])));
				data[10]=formatoDecimal.format((double)Double.parseDouble(a[23]));
				data[11]=formatoDecimal.format(((double)Double.parseDouble(a[23]))*((double)Double.parseDouble(a[24])));
				data[12]=formatoDecimal.format((double)Double.parseDouble(a[28]));
				cuerpo.add(data);	
				
				bas0=bas0+(double)Double.parseDouble(a[16]);
				bas1=bas1+(double)Double.parseDouble(a[17]);
				bas2=bas2+(double)Double.parseDouble(a[20]);
				bas3=bas3+(double)Double.parseDouble(a[23]);
				
				iva1=iva1+((double)Double.parseDouble(a[17]))*((double)Double.parseDouble(a[18]));
				iva2=iva2+((double)Double.parseDouble(a[20]))*((double)Double.parseDouble(a[21]));
				iva3=iva3+((double)Double.parseDouble(a[23]))*((double)Double.parseDouble(a[24]));

			}
				
		}
		

		// separacion
		
			String a[]={" "," "," "," "," "," "," "," "," "," "," "," "," "};
			cuerpo.add(a);	

		
		// resumen
			
		List<String[]> resumen=new ArrayList<String[]>();
		
		data=new String[13];
		data[0]=" ";
		data[1]=" ";
		data[2]=" ";
		data[3]=" ";
		if (bas0>0) {
			data[4]="BASE al 0,00%";
			data[5]="CUOTA al 0,00%";
		} else {
			data[4]="";
			data[5]="";
		}
		if (bas1>0) {
			data[6]="BASE al "+formatoDecimal.format((iva1*100/bas1))+"%";
			data[7]="CUOTA al "+formatoDecimal.format((iva1*100/bas1))+"%";
		} else {
			data[6]="";
			data[7]="";
		}
		if (bas2>0) {
			data[8]="BASE al "+formatoDecimal.format((iva2*100/bas2))+"%";
			data[9]="CUOTA al "+formatoDecimal.format((iva2*100/bas2))+"%";
		} else {
			data[8]="";
			data[9]="";
		}
		if (bas3>0) {
			data[10]="BASE al "+formatoDecimal.format((iva3*100/bas3))+"%";
			data[11]="CUOTA al "+formatoDecimal.format((iva3*100/bas3))+"%";
		} else {
			data[10]="";
			data[11]="";
		}
		
		data[12]="IMPORTES TOTALES";
		resumen.add(data);
			
		data=new String[13];
		data[0]=" ";
		data[1]=" ";
		data[2]=" ";
		data[3]="   TOTALES... ";
		data[4]=formatoDecimal.format(bas0);
		data[5]=formatoDecimal.format(0);
		data[6]=formatoDecimal.format(bas1);
		data[7]=formatoDecimal.format(iva1);
		data[8]=formatoDecimal.format(bas2);
		data[9]=formatoDecimal.format(iva2);
		data[10]=formatoDecimal.format(bas3);
		data[11]=formatoDecimal.format(iva3);
		data[12]=formatoDecimal.format(bas0+bas1+bas2+bas3+iva1+iva2+iva3);
		resumen.add(data);
		
		// otra separacion
		String b[]={" "," "," "," "," "," "," "," "," "," "," "," "," "};
		resumen.add(b);

				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+dateEsp.showMeTheDate();			
		
		if (!dataList.getIvaList("listadoIVA", titulo, cuerpo, resumen, pie)) {
			return false;
		}
		
		return true;
		
	} // end of method generatesPdfFile
	
	
	
	/**
	 * Crea la ayuda en pantalla
	 */
	
	private void createHelp () {
		
		JFrame helpFrame=new JFrame("Pantalla de ayuda");
		helpFrame.setBounds(150, 150, 500, 400);
		helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		helpFrame.setAlwaysOnTop(true);
		helpFrame.setLocationByPlatform(false);
		helpFrame.setResizable(false);
		
		JPanel panelHelp=new JPanel();
		panelHelp.setLayout(new BorderLayout());
		
		JPanel panelText=new JPanel();
		panelText.setLayout(new BoxLayout(panelText,BoxLayout.Y_AXIS));
		panelText.add(new JLabel(""));
		panelText.add(new JLabel(""));
		JTextArea hText=new JTextArea(
				"Listado de I.V.A. es una relación ordenada por fecha y número de las facturas\n" +
				"emitidas en el intervalo de fechas y números elegidos en los filtros del \n" +
				"formulario.\n\n" +
				"1.- Al pulsar 'Listar' se generará una nueva pantalla con los datos de las facturas,\n" +
				"    y las distintas bases imponibles e ivas desglosados.\n" +
				"2.- En la pantalla generada, tendrá la posibilidad de generar un fichero .pdf o .csv\n" +
				"    (legible por excel) pulsando en el botón correspondiente.\n" +
				"3.- El fichero .pdf o .csv generado no se abrirá automáticamente, sino que se grabará\n" +
				"    en el directorio principal de instalación (donde resida la aplicación).\n" +
				"    Si ud. no tiene derechos de creación de ficheros, se producirá un error. En ese\n" +
				"    caso, debe consultar con su administrador de red.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE LISTADO I.V.A. REPERCUTIDO"));
		
		panelHelp.add(title,BorderLayout.NORTH);
		panelHelp.add(panelText,BorderLayout.CENTER);
		panelHelp.add(new JLabel(" "),BorderLayout.EAST);
		panelHelp.add(new JLabel(" "),BorderLayout.WEST);
		panelHelp.add(new JLabel(" "),BorderLayout.SOUTH);
		
		panelHelp.setVisible(true);
		
		helpFrame.add(panelHelp);
		helpFrame.setVisible(true);	
		
	} // end of method createHelp
	
	
	
	/**
	 * This method make a JLabel with a determinate font
	 * @param text - a String for the label
	 * @return a JLabel with font
	 */
	
	private JLabel labelFont(String text) {
		
		JLabel aLabel=new JLabel(text);
		aLabel.setFont(font4);
		
		return aLabel;
	} // end of labelFont
	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("Listar")) {
			
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!dateEsp.checkDate(fecha1)) {
				fecha1="01-01-"+dateEsp.getDate().substring(6);
			}
			
			if (!dateEsp.checkDate(fecha2)) {
				fecha2="31-12-"+dateEsp.getDate().substring(6);
			}
			
			
			int sel1=firstInvoice.getSelectedIndex();
			int sel2=lastInvoice.getSelectedIndex();
			long invoice1=0;
			long invoice2=999999999;
			
			if (sel1!=0) {
				try {
					invoice1=(long)Long.parseLong(listSelectedInvoices.get(sel1-1)[1]);	
				} catch (NumberFormatException nf) {
					invoice1=0;
				}	
			}

			if (sel2!=0) {
				try {
					invoice2=(long)Long.parseLong(listSelectedInvoices.get(sel2-1)[1]);	
				} catch (NumberFormatException nf) {
					invoice2=999999999;
				}	
			}
			
			showListInvoices(listSelectedInvoices, fecha1, fecha2, invoice1, invoice2);

		} // fin de listar
		
		
		if (source.equals("Generar .CSV")) {
			
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!dateEsp.checkDate(fecha1)) {
				fecha1="01-01-"+dateEsp.getDate().substring(6);
			}
			
			if (!dateEsp.checkDate(fecha2)) {
				fecha2="31-12-"+dateEsp.getDate().substring(6);
			}
						
			
			if (dataListCsv.generatesCsvListIva(listSelectedInvoices, fecha1, fecha2)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero csv ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero csv", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}
				
		} // fin de generarCSV
		
		
		if (source.equals("Generar .PDF")) {
				
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!dateEsp.checkDate(fecha1)) {
				fecha1="01-01-"+dateEsp.getDate().substring(6);
			}
			
			if (!dateEsp.checkDate(fecha2)) {
				fecha2="31-12-"+dateEsp.getDate().substring(6);
			}
			
			
			int sel1=firstInvoice.getSelectedIndex();
			int sel2=lastInvoice.getSelectedIndex();
			long invoice1=0;
			long invoice2=999999999;
			
			if (sel1!=0) {
				try {
					invoice1=(long)Long.parseLong(listSelectedInvoices.get(sel1-1)[1]);	
				} catch (NumberFormatException nf) {
					invoice1=0;
				}	
			}

			if (sel2!=0) {
				try {
					invoice2=(long)Long.parseLong(listSelectedInvoices.get(sel2-1)[1]);	
				} catch (NumberFormatException nf) {
					invoice2=999999999;
				}	
			}
			
			if (generatesPdfFile(listSelectedInvoices, fecha1, fecha2, invoice1, invoice2)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero pdf ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero pdf", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}
			
		} // fin de generarPDF
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}

} // ************ END OF CLASS
