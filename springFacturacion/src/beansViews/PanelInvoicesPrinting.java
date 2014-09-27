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
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansControls.FacturasBean;
import beansList.ListadosCsv;
import beansList.ListadosPdf;

import main.SpringFacturacion;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicesPrinting implements ActionListener, ItemListener {
	
	private JFrame mainFrame;
	private JPanel marcoAux1;
	
	// OBJETOS SPRING
	private ClockAndDate dateEsp;
	private ClientesBean clienteFac;
	private FacturasBean facturador;
	private ListadosPdf dataList;
	private ListadosCsv dataListCsv;
	
	// LISTAR FACTURAS
	private List<String[]> listInvoices;
	private List<String[]> listSelectedInvoices;
	private JComboBox<String> firstInvoice;
	private JComboBox<String> lastInvoice;
	private List<String[]> listCustomers;
	private List<String[]> listSelectedCustomers;
	private JComboBox<String> firstCustomer;
	private JComboBox<String> lastCustomer;
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
	
	
	
	public PanelInvoicesPrinting() {
		// CONSTRUCTOR
	}
	
	
	public void setDateEsp (ClockAndDate date) {
		// spring
		this.dateEsp=date;	
	}
	
	public void setClienteFac(ClientesBean customer) {
		// spring
		this.clienteFac=customer;
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
	
	public JPanel printInvoices(JFrame mainFrame) {
			
		this.mainFrame=mainFrame;
		
		int fCust=0;
		int lCust=0;
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
		listCustomers=clienteFac.getListCustomers();
		listSelectedCustomers=clienteFac.getListCustomers();
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
		
		firstInvoice=new JComboBox<String>();
		firstInvoice.addItem("Factura inicial... ");
		listInvoices=facturador.searchExtractInvoicesByCustomers(listSelectedCustomers);
		if ((listSelectedInvoices=facturador.searchExtractInvoices())==null) {
			listSelectedInvoices=new ArrayList<String[]>();
		}
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
		JLabel title=new JLabel("LISTADO DE FACTURAS");
		title.setFont(font1);
		
		// creamos el formulario
		JLabel name1=new JLabel("Desde cliente... ");
		name1.setFont(font2);

		JLabel name2=new JLabel("Hasta cliente... ");
		name2.setFont(font2);
		
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
		firstCustomer.addItemListener(this);
		lastCustomer.addItemListener(this);
		firstInvoice.addItemListener(this);
		lastInvoice.addItemListener(this);
		
		return marco2;	
	
		
	} // end of printInvoices
	
	
	
	/**
	 * Este metodo muestra una nueva ventana con el listado de facturas seleccionado, dando la opcion para 
	 * imprimir en PDF o en TXT.
	 *  
	 * @param listInvoicesToPrinting - List, con las facturas que se desean visualizar.
	 * @return JFrame, conteniendo la pantalla emergente con el listado de facturas solicitado.
	 */
	
	private JFrame showListInvoices(List<String[]>listInvoicesToPrinting) {
		
		JFrame frameList=new JFrame("Listado de facturas");
		frameList.setBounds(25, 25, 1000, 700);
		frameList.setLocationByPlatform(true);
		frameList.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameList.setLocationByPlatform(false);
		
		JPanel marco3=new JPanel();
		BoxLayout bLayout=new BoxLayout(marco3,BoxLayout.Y_AXIS);
		marco3.setLayout(bLayout);

		// CABECERA
		JPanel marcoTit=new JPanel();
		JLabel title=new JLabel("LISTADO DE FACTURAS");
		title.setFont(font1);
		marcoTit.add(title);
		
		// CUERPO
		
		// CREAMOS UNA VISUALIZACION DE 25 LINEAS
		JPanel marcoList=new JPanel();
		
		int listRows=listInvoicesToPrinting.size()+5;
		if (listRows<25) {
			listRows=25;
		}
		
		GridLayout layout=new GridLayout(listRows,7);
		marcoList.setLayout(layout);

		marcoList.add(new JLabel("CLIENTE"));
		marcoList.add(new JLabel("SERIE"));
		marcoList.add(new JLabel("FACTURA"));
		marcoList.add(new JLabel("FECHA"));
		marcoList.add(new JLabel("BASE"));
		marcoList.add(new JLabel("IVA"));
		marcoList.add(new JLabel("TOTAL"));


		int elem=0;
		double basTotal=0;
		double cuoTotal=0;
		double impTotal=0;
		
		for (String a[]:listInvoicesToPrinting) {		

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
			basTotal=basTotal+bas;
			cuoTotal=cuoTotal+iva;
			impTotal=impTotal+tot;
			
			String b1=formatoDecimal.format(bas);
			for (int n=b1.length();n<12;n++) {
				b1=" "+b1;
			}
			String c1=formatoDecimal.format(iva);
			for (int n=c1.length();n<12;n++) {
				c1=" "+c1;
			}
			String t1=formatoDecimal.format(tot);
			for (int n=t1.length();n<12;n++) {
				t1=" "+t1;
			}
			
			marcoList.add(labelFont(b1));	
			marcoList.add(labelFont(c1));	
			marcoList.add(labelFont(t1));	
			elem++;
		}
		
		
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<listRows-5;j++) {

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
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		
		marcoList.add(new JLabel("TOTALES"));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel("BASES"));
		marcoList.add(new JLabel("CUOTAS"));
		marcoList.add(new JLabel("IMPORTES"));
		
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(formatoDecimal.format(basTotal)));
		marcoList.add(new JLabel(formatoDecimal.format(cuoTotal)));
		marcoList.add(new JLabel(formatoDecimal.format(impTotal)));
		
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		marcoList.add(new JLabel(""));
		
		// lo ponemos en un scrollPane por si excede la pantalla
		JScrollPane scroll=new JScrollPane(marcoList);
		scroll.setVisible(true);
				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String foot="Listado generado por "+SpringFacturacion.nameUsuario+" el "+dateEsp.showMeTheDate();			
		
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
		marco3.add(scroll);
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
	
	private boolean generatesPdfFile(List<String[]>listSelectedCustomers, List<String[]>listSelectedInvoices, int cust1, int cust2, long inv1, long inv2) {
		
		// CABECERA
		String titulo="LISTADO DE FACTURAS\n\n";
		
		// CUERPO
		List<String[]> cuerpo=new ArrayList<String[]>();
		
		int elem=0;
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
					String data[]=new String[7];
					data[0]=a[11];
					data[1]=a[2];
					data[2]=a[1];
					data[3]=a[3];
					data[4]=formatoDecimal.format(bas);
					data[5]=formatoDecimal.format(iva);
					data[6]=formatoDecimal.format(tot);
					cuerpo.add(data);	
					elem++;
				}
			}	
		}
				// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
		
		for (int j=elem;j<24;j++) {
			String a[]={" "," "," "," "," "," "," "};
			cuerpo.add(a);	
		}
		

				
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+dateEsp.showMeTheDate();			
		
		if (!dataList.getInvoicesList("listadoFacturas", titulo, cuerpo, pie)) {
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
				"Listado de facturas es una relación ordenada por fecha y número de las facturas\n" +
				"correspondientes a el cliente o clientes seleccionados y factura o facturas selec-\n" +
				"cionados en los filtros correspondientes.\n\n" +
				"1.- Al pulsar 'Listar' se generará una nueva pantalla con los datos de las facturas:\n" +
				"    cliente, número, fecha, bases, cuotas y totales.\n" +
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
		title.add(new JLabel("AYUDA DE LISTADO FACTURAS"));
		
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
		aLabel.setFont(font3);
		
		return aLabel;
	} // end of labelFont
	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("Listar")) {
			
			int indCustomer1=0;
			if (firstCustomer.getSelectedIndex()==0) {
				indCustomer1=0;
			} else {
				indCustomer1=firstCustomer.getSelectedIndex()-1;
			}
						
			int indCustomer2=0;
			if (lastCustomer.getSelectedIndex()==0) {
				indCustomer2=listSelectedCustomers.size()-1;
			} else {
				indCustomer2=lastCustomer.getSelectedIndex()-1;
			}
			
			long invoice1=0;
			if (firstInvoice.getSelectedIndex()!=0) {
				try {
					invoice1=(long)Long.parseLong(listSelectedInvoices.get(firstInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice1=0;
				}
			} else {
				invoice1=0;
			}
			
			long invoice2=0;
			if (lastInvoice.getSelectedIndex()!=0) {
				try {
					invoice2=(long)Long.parseLong(listSelectedInvoices.get(lastInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice2=999999999;
				}
			} else {
				invoice2=999999999;
			}
		
			List<String[]> listInvoicesToPrinting=new ArrayList<String[]>();
			for (String a[]:listSelectedInvoices) {		
				for (int j=indCustomer1;j<=indCustomer2;j++) {
					// dentro de los limites de cliente seleccionado
					long numF=0;
					try {
						numF=(long) Long.parseLong(a[1]);
					} catch (NumberFormatException nf) {
						numF=0;
					}
					if (a[10].equals(listSelectedCustomers.get(j)[1]) && numF>=invoice1 && numF<=invoice2) {
						// dentro de los limites de facturas seleccionadas
						listInvoicesToPrinting.add(a);
					}
				}	
			}
			showListInvoices(listInvoicesToPrinting);

		} // fin de lista
		
		
		if (source.equals("Generar .CSV")) {
			
			int indCustomer1=0;
			if (firstCustomer.getSelectedIndex()==0) {
				indCustomer1=0;
			} else {
				indCustomer1=firstCustomer.getSelectedIndex()-1;
			}
						
			int indCustomer2=0;
			if (lastCustomer.getSelectedIndex()==0) {
				indCustomer2=listSelectedCustomers.size()-1;
			} else {
				indCustomer2=lastCustomer.getSelectedIndex()-1;
			}
			
			long invoice1=0;
			if (firstInvoice.getSelectedIndex()!=0) {
				try {
					invoice1=(long)Long.parseLong(listSelectedInvoices.get(firstInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice1=0;
				}
			} else {
				invoice1=0;
			}
			
			long invoice2=0;
			if (lastInvoice.getSelectedIndex()!=0) {
				try {
					invoice2=(long)Long.parseLong(listSelectedInvoices.get(lastInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice2=999999999;
				}
			} else {
				invoice2=999999999;
			}
			
			if (dataListCsv.generatesCsvListInvoices(listSelectedCustomers, listSelectedInvoices, indCustomer1, indCustomer2, invoice1, invoice2, dateEsp.showMeTheDate())) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero csv ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero csv", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}		
		} // fin de generarCSV
		
		
		if (source.equals("Generar .PDF")) {
			
			int indCustomer1=0;
			if (firstCustomer.getSelectedIndex()==0) {
				indCustomer1=0;
			} else {
				indCustomer1=firstCustomer.getSelectedIndex()-1;
			}
						
			int indCustomer2=0;
			if (lastCustomer.getSelectedIndex()==0) {
				indCustomer2=listSelectedCustomers.size()-1;
			} else {
				indCustomer2=lastCustomer.getSelectedIndex()-1;
			}
			
			long invoice1=0;
			if (firstInvoice.getSelectedIndex()!=0) {
				try {
					invoice1=(long)Long.parseLong(listSelectedInvoices.get(firstInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice1=0;
				}
			} else {
				invoice1=0;
			}
			
			long invoice2=0;
			if (lastInvoice.getSelectedIndex()!=0) {
				try {
					invoice2=(long)Long.parseLong(listSelectedInvoices.get(lastInvoice.getSelectedIndex()-1)[1]);
				} catch (NumberFormatException nf) {
					invoice2=999999999;
				}
			} else {
				invoice2=999999999;
			}
			
			if (generatesPdfFile(listSelectedCustomers, listSelectedInvoices, indCustomer1, indCustomer2, invoice1, invoice2)) {
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
