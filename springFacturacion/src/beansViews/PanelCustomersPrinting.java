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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansControls.FacturasBean;
import beansControls.FileRecorder;
import beansList.ListadosPdf;

import main.SpringFacturacion;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelCustomersPrinting implements ActionListener, ItemListener {
	
	//SPRING
	private ClockAndDate today;
	private FileRecorder recording;
	private ListadosPdf dataList;
	private ClientesBean customers;
	private FacturasBean facturas;
	
	private JFrame mainFrame;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	private JComboBox<String> firstCustomer;
	private JComboBox<String> lastCustomer;
	private List<String[]> listSelectedCustomers;
	private List<String[]> listSelectedInvoices;
	private List<String[]> listCustomers;
	
	private JTextField firstDate;
	private JTextField lastDate;

	private JButton listar;
	private JButton botonPDF;
	private JButton botonCSV;
	private JButton botonTXT;
	private JButton info;
	
	private JButton listar2;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Font font3=new Font("SansSerif", Font.PLAIN, 14);
	private Font font4=new Font("SansSerif", Font.PLAIN, 12);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private Color colorL=Color.BLACK;

	

	public PanelCustomersPrinting () {
		// CONSTRUCTOR
	}
	
	
	public void setDataList (ListadosPdf dataList) {
		// spring
		this.dataList=dataList;
	}
	
	public void setToday (ClockAndDate today) {
		// spring
		this.today=today;
	}

	public void setRecording(FileRecorder recording) {
		// spring
		this.recording = recording;
	}
	
	public void setCustomers(ClientesBean clientes) {
		// spring
		this.customers = clientes;	
	}
	
	public void setFacturas (FacturasBean facturas) {
		// spring
		this.facturas=facturas;
	}
	
	
	 // ************************ BLOQUE DE LISTADOS DE DATOS DE CLIENTES
	
	
	/**
	 * Este método fabrica una pantalla de seleccion de clientes para listar. Con este método accederemos a
	 * un listado de clientes con sus datos principales de facturación.
	 * 
	 * @param mainFrame - JFrame, el JFrame principal que sirve de marco a la pantalla generada.
	 * @return JPanel, con el panel conteniendo la pantalla generada.
	 */
	
	public JPanel showMenuList(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,475));
		marcoAux1.setPreferredSize(new Dimension(650,475));
		marcoAux1.setMaximumSize(new Dimension(650,475));
		
		firstCustomer=new JComboBox<String>();
		firstCustomer.addItem("Cliente inicial... ");
		listCustomers=listCustomers();
		listSelectedCustomers=listCustomers();
		for (String[] list:listCustomers) {
			firstCustomer.addItem(list[2]);
		}		

		lastCustomer=new JComboBox<String>();
		lastCustomer.addItem("Cliente final... ");
		for (String[] list:listCustomers) {
			lastCustomer.addItem(list[2]);
		}
			
		// titulo
		JLabel title=new JLabel("LISTADO DE CLIENTES");
		title.setFont(font1);
		
		// creamos el formulario
		JLabel name1=new JLabel("Desde cliente... ");
		name1.setFont(font2);
		name1.setForeground(colorL);

		JLabel name2=new JLabel("Hasta cliente... ");
		name2.setFont(font2);
		name2.setForeground(colorL);
		
	
		// preparamos los botones
		listar=new JButton("Listar");
		listar.setToolTipText("pulse para listar los clientes");
		
		ImageIcon icon = new ImageIcon("src/images/info.png");
		info=new JButton(icon);
		info.setBorderPainted(true);
		info.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		info.setMargin(m);
		info.setToolTipText("pulse para información");
		info.setActionCommand("info");
		
		JPanel panelButton1=new JPanel();
		panelButton1.setLayout(new FlowLayout());
		panelButton1.add(listar);
		panelButton1.add(new JLabel());
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		panelButton3.add(info);
		Dimension dimP=new Dimension(60,50);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);
		
		// añadimos todos los elementos a los JPanel auxiliares
		marcoAux0.add(title);
		
		marcoAux1.setLayout(new GridLayout(15,4));
		
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
		marcoAux1.add(firstCustomer);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name2);
		marcoAux1.add(lastCustomer);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton1);
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
		marco2.add(new JLabel("         "),BorderLayout.EAST);
		marco2.add(new JLabel("         "),BorderLayout.WEST);
		marco2.add(new JLabel("       "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		listar.addActionListener(this);
		info.addActionListener(this);
		firstCustomer.addItemListener(this);
		lastCustomer.addItemListener(this);
		
		return marco2;	
			
	} // end of showMenuList
	
	
	
	/**
	 * Este metodo muestra una nueva JFrame con el listado de clientes seleccionados, dando la opcion para imprimir en PDF o en TXT 
	 * 
	 * @param listSelectedCustomers - List, lista de los clientes seleccionados para imprimir.
	 * @return boolean TRUE o FALSE con el resultado de la operación.
	 */
	
	private JFrame showListCustomers(List<String[]>listSelectedCustomers) {
		
		JFrame frameList=new JFrame("Listado clientes");
		frameList.setBounds(25, 25, 900, 700);
		frameList.setLocationByPlatform(true);
		frameList.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameList.setLocationByPlatform(false);
		JPanel marco3=new JPanel();
		BoxLayout bLayout=new BoxLayout(marco3,BoxLayout.Y_AXIS);
		marco3.setLayout(bLayout);
		

		// CABECERA
		JPanel marcoTit=new JPanel();
		JLabel title=new JLabel("LISTADO DE CLIENTES");
		title.setFont(font1);
		marcoTit.add(title);
		
		// CUERPO
		
		// CREAMOS UNA VISUALIZACION DE 25 LINEAS
		JPanel marcoList=new JPanel();
		int listRows=listSelectedCustomers.size()+1;
		if (listRows<25) {
			listRows=25;
		}
		GridLayout layout=new GridLayout(listRows,5);
		marcoList.setLayout(layout);
		
		marcoList.add(new JLabel("CLIENTE"));
		marcoList.add(new JLabel("DIRECCIÓN"));
		marcoList.add(new JLabel("CODIGO POSTAL"));
		marcoList.add(new JLabel("LOCALIDAD"));
		marcoList.add(new JLabel("N.I.F."));
		

		for (String a[]:listSelectedCustomers) {		
			marcoList.add(labelFont(a[2]));
			marcoList.add(labelFont(a[3]));
			marcoList.add(labelFont(a[4]));
			marcoList.add(labelFont(a[5]));
			marcoList.add(labelFont(a[6]));		
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=listSelectedCustomers.size();j<listRows-1;j++) {
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
		}
		
		// lo ponemos en un scrollPane por si excede la pantalla
		JScrollPane scroll=new JScrollPane(marcoList);
		scroll.setVisible(true);
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String foot="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		// BOTONES
		JPanel panelButtons=new JPanel();
		panelButtons.setLayout(new GridLayout(3,6));
		botonPDF=new JButton("Generar .PDF");
		botonPDF.setToolTipText("Pulse para generar un fichero PDF");
		botonTXT=new JButton("Generar .CSV");
		botonPDF.setToolTipText("Pulse para generar un fichero CSV legible por excel");
		botonPDF.addActionListener(this);
		botonTXT.addActionListener(this);
		
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
		panelButtons.add(botonTXT);
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
		marco3.add(scroll);
		marco3.add(foo);
		marco3.add(panelButtons);
		
		frameList.add(marco3);
		
		frameList.setVisible(true);
		
		return frameList;
		
	}  // end of method showListCustomers
	
	
	
	/**
	 * Este metodo genera la lista de los datos de los clientes seleccionados, en un fichero de texto CSV legible por excel. 
	 * 
	 * @param listSelectedCustomers - List, lista de los clientes seleccionados para imprimir.
	 * @return boolean TRUE o FALSE con el resultado de la operación.
	 */
	
	private boolean generatesCsvList(List<String[]>listSelectedCustomers) {
		
		// CABECERA
		String title="LISTADO DE CLIENTES;\n\n";
		
		// CUERPO
		
		String cabeceras="CLIENTE;"+"DIRECCIÓN;"+"CODIGO POSTAL;"+"LOCALIDAD;"+"N.I.F.;\n";

		
		String cuerpo="";
		for (String a[]:listSelectedCustomers) {
			cuerpo+=a[2]+";"+a[3]+";"+a[4]+";"+a[5]+";"+a[6]+";"+"\n";	
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=listSelectedCustomers.size();j<24;j++) {
			cuerpo+=";;;;;"+"\n";	
		}
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		String dataToRecording=title+cabeceras+cuerpo+pie;
		
		//FileRecorder fr=new FileRecorder();
		recording.CreateListCustomers(dataToRecording);
		
		return true;
		
	} // end of method generatesCsvList
		
	
	
	/**
	 *  Este método genera un fichero pdf con los datos de los clientes seleccionados.
	 *  
	 * @param listSelectedCustomers - List, lista con los clientes seleccionados.
	 * @return boolena TRUE o FALSE, con el resultado de la operación. 
	 */
	
	private boolean generatesPdfList(List<String[]>listSelectedCustomers) {
		
		// CABECERA
		String titulo="LISTADO DE CLIENTES\n\n";
		
		// CUERPO
		List<String[]> cuerpo=new ArrayList<String[]>();
		
		for (String a[]:listSelectedCustomers) {
			String data[]=new String[5];
			data[0]=a[2];
			data[1]=a[3];
			data[2]=a[4];
			data[3]=a[5];
			data[4]=a[6];
			cuerpo.add(data);	
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=listSelectedCustomers.size();j<24;j++) {
			String a[]={" "," "," "," "," "};
			cuerpo.add(a);	
		}
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		if (!dataList.getCustomersList("listadoClientes",titulo,cuerpo,pie)) {
			return false;
		}
		
		return true;
		
	} // end of method generatesPdfList
	
	
	 // ************************ BLOQUE DE LISTADOS DE FACTURAS DE CLIENTES
	
	
	/**
	 * Este método fabrica una pantalla de seleccion de clientes y sus facturas para listar. Con este método podemos
	 * listar un resumen de las facturas de cada cliente, agrupadas y sumadas cliente a cliente y con un sumatorio
	 * general final. 
	 * 
	 * @param mainFrame - JFrame, el JFrame principal que sirve de marco a la pantalla generada.
	 * @return JPanel, con el panel conteniendo la pantalla generada.
	 */
	
	public JPanel showMenuInvoices(JFrame mainFrame) {
			
		this.mainFrame=mainFrame;
		
		int fCust=0;
		int lCust=0;
		
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
		listCustomers=customers.getListCustomers();
		listSelectedCustomers=customers.getListCustomers();
		firstCustomer=new JComboBox<String>();
		lastCustomer=new JComboBox<String>();

		firstCustomer.addItem("Cliente inicial... ");
		for (String a[]:listCustomers) {
			firstCustomer.addItem(a[2]);
		}
		firstCustomer.setSelectedIndex(fCust);		
		
		lastCustomer.addItem("Cliente final... ");
		for (String a[]:listCustomers) {
			lastCustomer.addItem(a[2]);
		}
		lastCustomer.setSelectedIndex(lCust);
		
		// creamos el formulario
		JLabel date1=new JLabel("Desde fecha... ");
		date1.setFont(font2);
		firstDate=new JTextField("01-01-"+today.getDate().substring(6));

		JLabel date2=new JLabel("Hasta fecha... ");
		date2.setFont(font2);
		lastDate=new JTextField("31-12-"+today.getDate().substring(6));
		
		
		// titulo
		JLabel title=new JLabel("LISTADO DE FACTURAS");
		title.setFont(font1);
		
		// creamos el formulario
		JLabel name1=new JLabel("Desde cliente... ");
		name1.setFont(font2);

		JLabel name2=new JLabel("Hasta cliente... ");
		name2.setFont(font2);
			
	
		// preparamos los botones

		JPanel buttonPane=new JPanel();
		Dimension button=new Dimension(25,10);
		buttonPane.setPreferredSize(button);
		buttonPane.setMaximumSize(button);
		listar2=new JButton("Mostrar");
		listar2.setToolTipText("pulse para listar las facturas");
		buttonPane.add(listar2);
		
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
		marcoAux1.add(firstCustomer);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name2);
		marcoAux1.add(lastCustomer);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
			
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(date1);
		marcoAux1.add(firstDate);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(date2);
		marcoAux1.add(lastDate);
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
		listar2.addActionListener(this);
		info.addActionListener(this);
		firstCustomer.addItemListener(this);
		lastCustomer.addItemListener(this);
		
		return marco2;	
	
		
	} // end of printInvoices
		
	

	/**
	 * Este metodo muestra una JFrame con el listado de facturas de clientes seleccionados, 
	 * ordenadas por clientes y sumadas. Permite la opcion para imprimir en PDF o en TXT 
	 * 
	 * @param listSelectedInvoices - List, conteniendo la lista de las facturas de los clientes seleccionados.
	 * @param date1 - String, con la fecha de inicio del listado en formato dd-MM-yyyy
	 * @param date2 - String, con la fecha de final del listado en formato dd-MM-yyyy
	 * @return Boolean, TRUE o FALSE con el resultado de la generación del fichero.
	 */
	
	private JFrame showListInvoices(List<String[]>listInvoicesToPrinting, int numberCustomers) {
		
		JFrame frameList=new JFrame("Listado de clientes");
		frameList.setBounds(25, 25, 900, 700);
		frameList.setLocationByPlatform(true);
		frameList.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameList.setLocationByPlatform(false);
		JPanel marco3=new JPanel();
		BoxLayout bLayout=new BoxLayout(marco3,BoxLayout.Y_AXIS);
		marco3.setLayout(bLayout);
		

		// CABECERA
		JPanel marcoTit=new JPanel();
		JLabel title=new JLabel("LISTADO DE FACTURAS POR CLIENTES");
		title.setFont(font1);
		marcoTit.add(title);
		
		// CUERPO
		
		// CREAMOS UNA VISUALIZACION DE 25 LINEAS MINIMO
		JPanel marcoList=new JPanel();
		int listRows=(listInvoicesToPrinting.size()+(numberCustomers*2)+4);
		if (listRows<25) {
			listRows=25;
		}
		GridLayout layout=new GridLayout(listRows,7);
		marcoList.setLayout(layout);

		marcoList.add(new JLabel("CLIENTE"));
		marcoList.add(new JLabel("SERIE"));
		marcoList.add(new JLabel("FACTURA"));
		marcoList.add(new JLabel("  FECHA"));
		marcoList.add(new JLabel("        BASE"));
		marcoList.add(new JLabel("         IVA"));
		marcoList.add(new JLabel("      TOTAL"));


		int elem=0;
		double basTotal=0;
		double cuoTotal=0;
		double impTotal=0;
		double basParcial=0;
		double cuoParcial=0;
		double impParcial=0;
		

		
		String currentCustomer=listInvoicesToPrinting.get(0)[10];
		
		for (String a[]:listInvoicesToPrinting) {		
			
			if (!currentCustomer.equals(a[10])) {
				
				// ha cambiado el cliente
				currentCustomer=a[10];
				
				// imprimimos el resumen de datos
				marcoList.add(new JLabel("SUBTOTAL..."));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				String b1=formatoDecimal.format(basParcial);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (basParcial<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(cuoParcial);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (cuoParcial<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(impParcial);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (impParcial<1000) {
					t1=" "+t1;
				}
				marcoList.add(labelFont(b1));	
				marcoList.add(labelFont(c1));	
				marcoList.add(labelFont(t1));
				basParcial=0;
				cuoParcial=0;
				impParcial=0;
				elem++;	
				
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				marcoList.add(new JLabel(" "));
				elem++;	
				
			} 

			
				marcoList.add(labelFont(a[11]));
				marcoList.add(labelFont(a[2]));
				marcoList.add(labelFont(a[1]));
				String fecha=" ";
				if (a[3].length()>=10) {
					fecha=a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4);
				}
				marcoList.add(labelFont(fecha));
				double bas=(double)Double.parseDouble(a[16])+(double)Double.parseDouble(a[17])+(double)Double.parseDouble(a[20])+(double)Double.parseDouble(a[23]);
				double tot=(double)Double.parseDouble(a[28]);
				double iva=tot-bas;
				// acumulacion sobre los parciales
				basParcial=basParcial+bas;
				cuoParcial=cuoParcial+iva;
				impParcial=impParcial+tot;
				// acumulacion sobre los totales
				basTotal=basTotal+bas;
				cuoTotal=cuoTotal+iva;
				impTotal=impTotal+tot;
				
				String b1=formatoDecimal.format(bas);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (bas<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(iva);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (iva<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(tot);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (tot<1000) {
					t1=" "+t1;
				}
				
				marcoList.add(labelFont(b1));	
				marcoList.add(labelFont(c1));	
				marcoList.add(labelFont(t1));	
				elem++;
	
		}
		
		// ultimo cliente hay que imprimir el resumen
		
		// imprimimos el resumen de datos
		marcoList.add(new JLabel("SUBTOTAL..."));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		String b1=formatoDecimal.format(basParcial);
		for (int n=b1.length();n<12;n++) {
			b1=" "+b1;
		}
		if (basParcial<1000) {
			b1=" "+b1;
		}
		String c1=formatoDecimal.format(cuoParcial);
		for (int n=c1.length();n<12;n++) {
			c1=" "+c1;
		}
		if (cuoParcial<1000) {
			c1=" "+c1;
		}
		String t1=formatoDecimal.format(impParcial);
		for (int n=t1.length();n<12;n++) {
			t1=" "+t1;
		}
		if (impParcial<1000) {
			t1=" "+t1;
		}
		marcoList.add(labelFont(b1));	
		marcoList.add(labelFont(c1));	
		marcoList.add(labelFont(t1));
		basParcial=0;
		cuoParcial=0;
		impParcial=0;
		elem++;	
		
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		elem++;
		
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes

		for (int j=(listInvoicesToPrinting.size()+(numberCustomers*2)+4);j<25;j++) {
			
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel(" "));

		}

		System.out.println(" fuuu "+elem);
		
		marcoList.add(new JLabel("TOTALES"));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel("BASES"));
		marcoList.add(new JLabel("CUOTAS"));
		marcoList.add(new JLabel("IMPORTES"));
		
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(formatoDecimal.format(basTotal)));
		marcoList.add(new JLabel(formatoDecimal.format(cuoTotal)));
		marcoList.add(new JLabel(formatoDecimal.format(impTotal)));
		
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		marcoList.add(new JLabel(" "));
		
		
		// lo ponemos en un scrollPane por si excede la pantalla
		JScrollPane scroll=new JScrollPane(marcoList);
		scroll.setVisible(true);
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String foot="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		// BOTONES
		JPanel panelButtons=new JPanel();
		panelButtons.setLayout(new GridLayout(3,6));
		botonPDF=new JButton("Generar .pdf");
		botonPDF.setToolTipText("Pulse para generar un fichero PDF");
		botonCSV=new JButton("Generar .csv");
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
		
		// PIE
		JLabel foo=new JLabel(foot);
		foo.setFont(font4);
		marcoList.setFont(font3);
		
		marco3.add(marcoTit);
		marco3.add(scroll);
		marco3.add(foo);
		marco3.add(panelButtons);
		
		frameList.add(marco3);
		
		frameList.setVisible(true);
		
		return frameList;
		
	}  // end of method showListInvoices
	
	
	
	/**
	 * Este metodo genera la lista de las facturas agrupadas por los clientes seleccionados, 
	 * en un fichero de texto CSV legible por excel. 
	 * 
	 * @param listSelectedInvoices - List, conteniendo la lista de las facturas de los clientes seleccionados.
	 * @param date1 - String, con la fecha de inicio del listado en formato dd-MM-yyyy
	 * @param date2 - String, con la fecha de final del listado en formato dd-MM-yyyy
	 * @return Boolean, TRUE o FALSE con el resultado de la generación del fichero.
	 */
	
	private boolean generatesCsvListInvoices(List<String[]>listSelectedInvoices, String date1, String date2) {
		
		
		// CABECERA
		String title="LISTADO DE FACTURAS POR CLIENTES;\n\n";
		
		// CUERPO
		
		String cabeceras="CLIENTE;"+"SERIE;"+"FACTURA;"+"FECHA;"+"BASE;"+"IVA;"+"TOTAL;\n";

		int elem=0;
		double basTotal=0;
		double cuoTotal=0;
		double impTotal=0;
		double basParcial=0;
		double cuoParcial=0;
		double impParcial=0;
		
		// convierte fechas para comparacion
		String d1=date1.substring(6)+date1.substring(2, 6)+date1.substring(0, 2);
		String d2=date2.substring(6)+date2.substring(2, 6)+date2.substring(0, 2);
		
		// cliente que estamos procesando actualmente
		String currentCustomer=listSelectedInvoices.get(0)[10];
		
		// VARIABLE DONDE SE ACUMULA INFORMACION
		String cuerpo="";
		
		for (String a[]:listSelectedInvoices) {		
			
			if (!currentCustomer.equals(a[10])) {
				
				// ha cambiado el cliente
				currentCustomer=a[10];
				
				// imprimimos el resumen de datos
				cuerpo+="SUBTOTAL...;;;;";
				String b1=formatoDecimal.format(basParcial);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (basParcial<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(cuoParcial);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (cuoParcial<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(impParcial);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (impParcial<1000) {
					t1=" "+t1;
				}
				cuerpo+=b1+";";	
				cuerpo+=c1+";";
				cuerpo+=t1+";"+"\n";

				basParcial=0;
				cuoParcial=0;
				impParcial=0;
				elem++;	
				
				// espacio de separacion
				cuerpo+=";;;;;;;"+"\n";
				elem++;	
				
			} 

			if (a[3].compareTo(d1)>=0 && a[3].compareTo(d2)<=0) {

				String fecha=" ";
				if (a[3].length()>=10) {
					fecha=a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4);
				}
				
				cuerpo+=a[11]+";";	
				cuerpo+=a[2]+";";
				cuerpo+=a[1]+";";
				cuerpo+=fecha+";";
				
				double bas=(double)Double.parseDouble(a[16])+(double)Double.parseDouble(a[17])+(double)Double.parseDouble(a[20])+(double)Double.parseDouble(a[23]);
				double tot=(double)Double.parseDouble(a[28]);
				double iva=tot-bas;
				// acumulacion sobre los parciales
				basParcial=basParcial+bas;
				cuoParcial=cuoParcial+iva;
				impParcial=impParcial+tot;
				// acumulacion sobre los totales
				basTotal=basTotal+bas;
				cuoTotal=cuoTotal+iva;
				impTotal=impTotal+tot;
				
				String b1=formatoDecimal.format(bas);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (bas<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(iva);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (iva<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(tot);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (tot<1000) {
					t1=" "+t1;
				}
				
				cuerpo+=b1+";";	
				cuerpo+=c1+";";
				cuerpo+=t1+";"+"\n";	
				elem++;
			
			}
				
		}
		
		// ultimo cliente hay que imprimir el resumen
		
		// imprimimos el resumen de datos
		cuerpo+="SUBTOTAL...;;;;";
		String b1=formatoDecimal.format(basParcial);
		for (int n=b1.length();n<12;n++) {
			b1=" "+b1;
		}
		if (basParcial<1000) {
			b1=" "+b1;
		}
		String c1=formatoDecimal.format(cuoParcial);
		for (int n=c1.length();n<12;n++) {
			c1=" "+c1;
		}
		if (cuoParcial<1000) {
			c1=" "+c1;
		}
		String t1=formatoDecimal.format(impParcial);
		for (int n=t1.length();n<12;n++) {
			t1=" "+t1;
		}
		if (impParcial<1000) {
			t1=" "+t1;
		}
		cuerpo+=b1+";";	
		cuerpo+=c1+";";
		cuerpo+=t1+";"+"\n";

		basParcial=0;
		cuoParcial=0;
		impParcial=0;
		elem++;	
				
				
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<24;j++) {
			cuerpo+=";;;;;;;"+"\n";	
		}
			//RESUMEN FINAL DEL LISTADO
		cuerpo+="TOTALES;;;;BASES;CUOTAS;IMPORTES;"+"\n";

		cuerpo+=";;;;";
		cuerpo+=formatoDecimal.format(basTotal)+";";
		cuerpo+=formatoDecimal.format(cuoTotal)+";";
		cuerpo+=formatoDecimal.format(impTotal)+";"+"\n\n";
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		String dataToRecording=title+cabeceras+cuerpo+pie;
		
		//FileRecorder fr=new FileRecorder();
		recording.CreateListInvoices("Facturacion", dataToRecording);
		
		return true;
		
	} // end of method generatesCsvListInvoices
	
	
	
	/**
	 * Este metodo genera la lista de las facturas agrupadas por los clientes seleccionados, 
	 * en un fichero de texto PDF. 
	 * 
	 * @param listSelectedInvoices - List, conteniendo la lista de las facturas de los clientes seleccionados.
	 * @param date1 - String, con la fecha de inicio del listado en formato dd-MM-yyyy
	 * @param date2 - String, con la fecha de final del listado en formato dd-MM-yyyy
	 * @return Boolean, TRUE o FALSE con el resultado de la generación del fichero.
	 */
	
	
	private boolean generatesPdfListInvoices(List<String[]>listSelectedInvoices, String date1, String date2) {
		
		// CABECERA
		String titulo="LISTADO DE FACTURAS POR CLIENTES\n\n";
		
		// CUERPO
		List<String[]> cuerpo=new ArrayList<String[]>();
		
		double basTotal=0;
		double cuoTotal=0;
		double impTotal=0;
		double basParcial=0;
		double cuoParcial=0;
		double impParcial=0;
		
		// convierte fechas para comparacion
		String d1=date1.substring(6)+date1.substring(2, 6)+date1.substring(0, 2);
		String d2=date2.substring(6)+date2.substring(2, 6)+date2.substring(0, 2);
		
		// cliente que estamos procesando actualmente
		String currentCustomer=listSelectedInvoices.get(0)[10];
			
		String data[]=new String[7];
		
		for (String a[]:listSelectedInvoices) {		
			
			if (!currentCustomer.equals(a[10])) {
				
				// ha cambiado el cliente
				currentCustomer=a[10];
				
				// imprimimos el resumen de datos
				data=new String[7];
				data[0]="SUBTOTAL...";
				data[1]="";
				data[2]="";
				data[3]="";
				String b1=formatoDecimal.format(basParcial);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (basParcial<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(cuoParcial);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (cuoParcial<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(impParcial);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (impParcial<1000) {
					t1=" "+t1;
				}
				data[4]=b1;
				data[5]=c1;
				data[6]=t1;
				cuerpo.add(data);

				basParcial=0;
				cuoParcial=0;
				impParcial=0;	
				
			} 

			if (a[3].compareTo(d1)>=0 && a[3].compareTo(d2)<=0) {

				String fecha=" ";
				if (a[3].length()>=10) {
					fecha=a[3].substring(8)+a[3].substring(4,8)+a[3].substring(0,4);
				}
				data=new String[7];
				data[0]=a[11];
				data[1]=a[2];
				data[2]=a[1];
				data[3]=fecha;
				
				double bas=(double)Double.parseDouble(a[16])+(double)Double.parseDouble(a[17])+(double)Double.parseDouble(a[20])+(double)Double.parseDouble(a[23]);
				double tot=(double)Double.parseDouble(a[28]);
				double iva=tot-bas;
				// acumulacion sobre los parciales
				basParcial=basParcial+bas;
				cuoParcial=cuoParcial+iva;
				impParcial=impParcial+tot;
				// acumulacion sobre los totales
				basTotal=basTotal+bas;
				cuoTotal=cuoTotal+iva;
				impTotal=impTotal+tot;
				
				String b1=formatoDecimal.format(bas);
				for (int n=b1.length();n<12;n++) {
					b1=" "+b1;
				}
				if (bas<1000) {
					b1=" "+b1;
				}
				String c1=formatoDecimal.format(iva);
				for (int n=c1.length();n<12;n++) {
					c1=" "+c1;
				}
				if (iva<1000) {
					c1=" "+c1;
				}
				String t1=formatoDecimal.format(tot);
				for (int n=t1.length();n<12;n++) {
					t1=" "+t1;
				}
				if (tot<1000) {
					t1=" "+t1;
				}
				
				data[4]=b1;
				data[5]=c1;
				data[6]=t1;
				cuerpo.add(data);	
			
			}
				
		}
		
		// ultimo cliente hay que imprimir el resumen
		
		// imprimimos el resumen de datos
		data=new String[7];
		data[0]="SUBTOTAL...";
		data[1]="";
		data[2]="";
		data[3]="";
		String b1=formatoDecimal.format(basParcial);
		for (int n=b1.length();n<12;n++) {
			b1=" "+b1;
		}
		if (basParcial<1000) {
			b1=" "+b1;
		}
		String c1=formatoDecimal.format(cuoParcial);
		for (int n=c1.length();n<12;n++) {
			c1=" "+c1;
		}
		if (cuoParcial<1000) {
			c1=" "+c1;
		}
		String t1=formatoDecimal.format(impParcial);
		for (int n=t1.length();n<12;n++) {
			t1=" "+t1;
		}
		if (impParcial<1000) {
			t1=" "+t1;
		}
		data[4]=b1;
		data[5]=c1;
		data[6]=t1;
		cuerpo.add(data);

		basParcial=0;
		cuoParcial=0;
		impParcial=0;	
		
			//RESUMEN FINAL DEL LISTADO

		data=new String[7];
		data[0]="TOTALES";
		data[1]="";
		data[2]="";
		data[3]="";
		data[4]="BASES";
		data[5]="CUOTAS";
		data[6]="IMPORTES";
		cuerpo.add(data);

		data=new String[7];
		data[0]="";
		data[1]="";
		data[2]="";
		data[3]="";
		data[4]=formatoDecimal.format(basTotal);
		data[5]=formatoDecimal.format(cuoTotal);
		data[6]=formatoDecimal.format(impTotal);
		cuerpo.add(data);
		
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+today.showMeTheDate();			
		
		if (!dataList.getCustomersListInvoices("Facturacion",titulo,cuerpo,pie)) {
			return false;
		}
		
		return true;
		
	} // end of method generatesPdfListInvoices

	
	
	
	/**
	 * Este método devuelve una nueva lista de clientes, con su información para manejar.
	 * @return - un list de String[] con los datos de los clientes.
	 */
	
	private List<String[]> listCustomers() {
		
		//clientes=new ClientesBean();
		List<String[]> lista=customers.getListCustomers();
		
		return lista;
		
	} // end of listCustomers
	
	
	
	/**
	 * This method make a JLabel with a determinate font
	 * @param text - a String for the label
	 * @return a JLabel with font
	 */
	
	private JLabel labelFont(String text) {
		
		JLabel aLabel=new JLabel(text);
		aLabel.setFont(font3);
		
		return aLabel;
	} // end of labelFont
	
	
	
	/**
	 * Crea la ayuda en pantalla
	 */
	
	private void createHelp () {
		
		JFrame helpFrame=new JFrame("Pantalla de ayuda");
		helpFrame.setBounds(150, 150, 500, 500);
		helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		helpFrame.setAlwaysOnTop(true);
		helpFrame.setLocationByPlatform(false);
		helpFrame.setResizable(false);
		
		JPanel panelHelp=new JPanel();
		panelHelp.setLayout(new BorderLayout());
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE MENÚ CLIENTES"));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea(
				"- En el menú de clientes puede crear, modificar, eliminar y listar\n" +
				"los clientes objeto de facturación y notas de entrega.\n" +
				"Se recomienda crear un cliente genérico para sus ventas al\n" +
				"público. En la versión 1.1 no existe la posibilidad de emitir \n" +
				"tickets de venta.\n\n" +
				"1.- Tanto en Alta como en Modificación, deberá introducir como\n" +
				"mínimo el nombre del cliente, el nif y el código postal.\n" +
				"2.- Existe la opción de dar de alta un domicilio fiscal distinto,\n" +
				"el cual será entonces el domicilio de factura.\n" +
				"3.- No es recomendable borrar empresas que tienen facturación,\n" +
				"ni modificar los datos con un nif distinto.\n" +
				"4.- Cada nif distinto debería ser un cliente distinto, con\n" +
				"excepción del cliente genérico de venta al contado, si lo crea.\n" +
				"5.- Listados es solamente una relación de los clientes seleccio-.\n" +
				"nados, con sus datos de facturación.\n");
		hText.setForeground(colorL);
		hText.setEditable(false);
		panelText.add(hText);
		
		panelHelp.add(title,BorderLayout.NORTH);
		panelHelp.add(panelText,BorderLayout.CENTER);
		panelHelp.add(new JLabel(" "),BorderLayout.EAST);
		panelHelp.add(new JLabel(" "),BorderLayout.WEST);
		panelHelp.add(new JLabel(" "),BorderLayout.SOUTH);
		
		panelHelp.setVisible(true);
		
		helpFrame.add(panelHelp);
		
		helpFrame.setVisible(true);
		
	} // end of method createHelp
	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
			// COMBOBOX de listados
		
		String ini=null;
		String fin=null;
		int index1=0;
		int index2=0;
		if (firstCustomer!=null && firstCustomer.getSelectedIndex()>0) {
			ini=listCustomers.get(firstCustomer.getSelectedIndex()-1)[2];
			index1=firstCustomer.getSelectedIndex()-1;
		} else if (firstCustomer!=null && firstCustomer.getSelectedIndex()==0) {
			ini=listCustomers.get(0)[2];
			index1=0;
		}
		
		if (lastCustomer!=null && lastCustomer.getSelectedIndex()>0) {
			fin=listCustomers.get(lastCustomer.getSelectedIndex()-1)[2];
			index2=lastCustomer.getSelectedIndex()-1;
		} else if (lastCustomer!=null && lastCustomer.getSelectedIndex()==0) {
			fin=listCustomers.get(listCustomers.size()-1)[2];
			index2=listCustomers.size()-1;
		}
		
		// aqui se cambia la lista de clientes seleccionados
		if (ini!=null && fin!=null) {
			listSelectedCustomers.clear();
			for (int n=index1;n<=index2;n++) {
				listSelectedCustomers.add(listCustomers.get(n));
			}
		}
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getActionCommand();
		
		if (source.equals("Listar")) {
			// la lista o es la que incluye a todos los clientes, o bien se ha cambiado en itemStatedChanged
			showListCustomers(listSelectedCustomers);
		}
		
		if (source.equals("Generar .CSV")) {
			
			if (generatesCsvList(listSelectedCustomers)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero csv ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero csv", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}		
		} // fin de generarCSV
		
		
		if (source.equals("Generar .PDF")) {
			
			if (generatesPdfList(listSelectedCustomers)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero pdf ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero pdf", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}
			
		} // fin de generarPDF
		
		
		
		if (source.equals("Mostrar")) {
			// la lista o es la que incluye a todos los clientes, o bien se ha cambiado en itemStatedChanged
			
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!today.checkDate(fecha1)) {
				fecha1="01-01-"+today.getDate().substring(6);
			}
			
			if (!today.checkDate(fecha2)) {
				fecha2="31-12-"+today.getDate().substring(6);
			}
			// obtenemos las facturas que corresponden a los clientes seleccionados
			listSelectedInvoices=facturas.searchExtractInvoicesByOrderCustomers(listSelectedCustomers);
			
			List<String[]> listInvoicesToPrinting=new ArrayList<String[]>();
			for (String a[]:listSelectedInvoices) {

				if (a[3].compareTo(fecha1)>=0 && a[3].compareTo(fecha2)<=0) {
					// dentro de las fechas de facturas seleccionadas
					listInvoicesToPrinting.add(a);			
				}
					
			}		
			
			showListInvoices(listInvoicesToPrinting,listSelectedCustomers.size());
		}
		
		
		if (source.equals("Generar .csv")) {
			
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!today.checkDate(fecha1)) {
				fecha1="01-01-"+today.getDate().substring(6);
			}
			
			if (!today.checkDate(fecha2)) {
				fecha2="31-12-"+today.getDate().substring(6);
			}
			// obtenemos las facturas que corresponden a los clientes seleccionados
			listSelectedInvoices=facturas.searchExtractInvoicesByOrderCustomers(listSelectedCustomers);
			
			if (generatesCsvListInvoices(listSelectedInvoices, fecha1, fecha2)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero csv ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero csv", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}		
		} // fin de generarCSV
		
		
		if (source.equals("Generar .pdf")) {
			
			String fecha1=firstDate.getText().trim();
			String fecha2=lastDate.getText().trim();
			
			if (!today.checkDate(fecha1)) {
				fecha1="01-01-"+today.getDate().substring(6);
			}
			
			if (!today.checkDate(fecha2)) {
				fecha2="31-12-"+today.getDate().substring(6);
			}
			// obtenemos las facturas que corresponden a los clientes seleccionados
			listSelectedInvoices=facturas.searchExtractInvoicesByOrderCustomers(listSelectedCustomers);
			
			if (generatesPdfListInvoices(listSelectedInvoices, fecha1, fecha2)) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero pdf ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero pdf.\nCompruebe que el fichero no esté abierto.\n" +
						"Si está abierto, cierrelo y pruebe de nuevo.", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}
			
		} // fin de generarPDF
	
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}
	
	
} // ************** END OF CLASS
