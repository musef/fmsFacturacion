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

import main.SpringFacturacion;
import beansControls.AlbaranesBean;
import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansList.ListadosCsv;
import beansList.ListadosPdf;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class PanelDeliveryPrinting implements ActionListener {
	
	private JFrame mainFrame;
	private JPanel marcoAux1;
	
	// OBJETOS SPRING
	private ClockAndDate dateEsp;
	private ClientesBean clienteFac;
	private AlbaranesBean albaranes;
	private ListadosPdf dataList;
	private ListadosCsv dataListCsv;
	
	// LISTAR FACTURAS
	private List<String[]> listDeliveries;
	private List<String[]> listSelectedDeliveries;
	private JComboBox<String> firstDelivery;
	private JComboBox<String> lastDelivery;
	private JComboBox<String> deliveryState;
	private List<String[]> listCustomers;
	private List<String[]> listSelectedCustomers;
	private JComboBox<String> firstCustomer;
	private JComboBox<String> lastCustomer;
	private JButton botonPDF;
	private JButton botonCSV;
	private JButton info;
	
	// VARIABLES DEL LISTADO
	private int state;
	private long delivery1;
	private long delivery2;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Font font3=new Font("SansSerif", Font.PLAIN, 14);
	private Font font4=new Font("SansSerif", Font.PLAIN, 12);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private final Color COLORL=Color.BLACK;
	
	
	
	public PanelDeliveryPrinting() {
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
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
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
	 * Método que permite la selección de los albaranes a imprimir, mostrándolos en el panel.
	 * 
	 * @return - un JPanel componiendo la pantalla de seleccion de albaranes
	 */
	
	public JPanel showMenu(JFrame mainFrame) {
			
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
		
		firstDelivery=new JComboBox<String>();
		firstDelivery.addItem("Albarán inicial... ");
		
		listDeliveries=albaranes.searchAllDeliveries();
		
		for (String[] list:listDeliveries) {
			firstDelivery.addItem(list[3]);
		}
		firstDelivery.setSelectedIndex(fInv);
		 
		lastDelivery=new JComboBox<String>();
		lastDelivery.addItem("Albarán final... ");
		
		for (String[] list:listDeliveries) {
			lastDelivery.addItem(list[3]);
		}
		lastDelivery.setSelectedIndex(lInv);
		
		
		deliveryState=new JComboBox<String>();
		deliveryState.addItem("Todos");
		deliveryState.addItem("Pendientes");
		deliveryState.addItem("Facturados");
		
		
		// titulo
		JLabel title=new JLabel("LISTADO DE ALBARANES");
		title.setFont(font1);
		
		// creamos el formulario
		JLabel name1=new JLabel("Desde cliente... ");
		name1.setFont(font2);

		JLabel name2=new JLabel("Hasta cliente... ");
		name2.setFont(font2);
		
		JLabel inv1=new JLabel("Desde albarán... ");
		inv1.setFont(font2);

		JLabel inv2=new JLabel("Hasta albarán... ");
		inv2.setFont(font2);
		
		JLabel estado=new JLabel("Estado ... ");
		estado.setFont(font2);	
		
		// preparamos los botones

		JPanel buttonPane=new JPanel();
		Dimension button=new Dimension(25,10);
		buttonPane.setPreferredSize(button);
		buttonPane.setMaximumSize(button);
		JButton listar=new JButton("Listar");
		listar.setToolTipText("pulse para listar los albaranes");
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
		
		marcoAux1.setLayout(new GridLayout(16,4));
		
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
		marcoAux1.add(firstDelivery);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(inv2);
		marcoAux1.add(lastDelivery);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(estado);
		marcoAux1.add(deliveryState);
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

		
		return marco2;	
	
		
	} // end of printDeliveries
	
	
	
	/**
	 * Este metodo muestra una JFrame con el listado de clientes seleccionado, dando la opcion para imprimir en PDF o en TXT 
	 * @return
	 */
	
	private JFrame showListDeliveries(List<String[]>listDeliveriesToPrinting) {
		
		JFrame frameList=new JFrame("Listado de albaranes");
		frameList.setBounds(25, 25, 900, 700);
		frameList.setLocationByPlatform(true);
		frameList.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameList.setLocationByPlatform(false);
		JPanel marco3=new JPanel();
		BoxLayout bLayout=new BoxLayout(marco3,BoxLayout.Y_AXIS);
		marco3.setLayout(bLayout);
		

		// CABECERA
		JPanel marcoTit=new JPanel();
		JLabel title=new JLabel("LISTADO DE ALBARANES");
		title.setFont(font1);
		marcoTit.add(title);
		
		// CUERPO
		
		// CREAMOS UNA VISUALIZACION DE 25 LINEAS
		JPanel marcoList=new JPanel();
		
		if (listDeliveriesToPrinting!=null && !listDeliveriesToPrinting.isEmpty()) {
			int listRows=listDeliveriesToPrinting.size()+5;
			if (listRows<25) {
				listRows=25;
			}
			
			GridLayout layout=new GridLayout(listRows,6);
			marcoList.setLayout(layout);

			marcoList.add(new JLabel("CLIENTE"));
			marcoList.add(new JLabel("ALBARÁN"));
			marcoList.add(new JLabel("   FECHA"));
			marcoList.add(new JLabel("         BASE"));
			marcoList.add(new JLabel("         TOTAL"));
			marcoList.add(new JLabel("  ESTADO"));


			int elem=0;
			double basTotal=0;
			double impTotal=0;
			
			for (String a[]:listDeliveriesToPrinting) {		

				marcoList.add(labelFont(a[2]));
				marcoList.add(labelFont(a[3]));
				marcoList.add(labelFont(a[4].substring(8)+a[4].substring(4,8)+a[4].substring(0,4)));
				
				double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
				double tot=(double)Double.parseDouble(a[33]);
				basTotal=basTotal+bas;
				impTotal=impTotal+tot;
				
				String sp0=formatoDecimal.format(bas);
				for (int n=sp0.length();n<15;n++) {
					sp0=" "+sp0;
				}
				marcoList.add(labelFont(sp0));	
				String sp1=formatoDecimal.format(tot);
				for (int n=sp1.length();n<15;n++) {
					sp1=" "+sp1;
				}
				marcoList.add(labelFont(sp1));
				if (a[1].isEmpty()) {
					marcoList.add(labelFont("PENDIENTE"));
				} else {
					marcoList.add(labelFont("FACTURADO"));
				}
				
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
			}
			
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			
			marcoList.add(new JLabel("TOTALES"));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel("BASES"));
			marcoList.add(new JLabel("IMPORTES"));
			marcoList.add(new JLabel(""));
			
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(formatoDecimal.format(basTotal)));
			marcoList.add(new JLabel(formatoDecimal.format(impTotal)));
			marcoList.add(new JLabel(""));
			
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));
			marcoList.add(new JLabel(""));

		} else {
			
			GridLayout layout=new GridLayout(25,3);
			marcoList.setLayout(layout);

			marcoList.add(new JLabel(" "));
			marcoList.add(new JLabel("NO EXISTEN DATOS EN LA SELECCION"));
			marcoList.add(new JLabel(" "));
			
		}
		
		
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
		botonCSV.setToolTipText("Pulse para generar un fichero CSV legible por excel");
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
		
	}  // end of method showListDeliveries
	
	
	
	/**
	 * Este metodo genera un fichero PDF.
	 * 
	 * @return
	 */
	
	private boolean generatesPdfFile(List<String[]>listSelectedDeliveries, long deliv1, long deliv2, int state) {
		
		// CABECERA
		String titulo="LISTADO DE ALBARANES\n\n";
		
		// CUERPO
		List<String[]> cuerpo=new ArrayList<String[]>();
		
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
						
						String data[]=new String[6];
						data[0]=a[2];
						data[1]=a[3];
						data[2]=a[4];
						data[3]=formatoDecimal.format(bas);
						data[4]=formatoDecimal.format(tot);		
						String texto="";
						if (a[1].isEmpty()) {
							texto="PENDIENTE";
						} else {
							texto="FACTURADO";
						}
						data[5]=texto;
						cuerpo.add(data);	
						elem++;					
					} else if (state==1) {
						// estado 1 quiere decir albaranes pendientes
						if (a[1].isEmpty()) {
							double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
							double tot=(double)Double.parseDouble(a[33]);
							basTotal=basTotal+bas;
							impTotal=impTotal+tot;
							
							String data[]=new String[6];
							data[0]=a[2];
							data[1]=a[3];
							data[2]=a[4];
							data[3]=formatoDecimal.format(bas);
							data[4]=formatoDecimal.format(tot);
							data[5]="PENDIENTE";
							cuerpo.add(data);	
							elem++;	
						}
					} else {
						// estado 2 quiere decir albaranes facturados
						if (!a[1].isEmpty()) {
							double bas=(double)Double.parseDouble(a[21])+(double)Double.parseDouble(a[22])+(double)Double.parseDouble(a[25])+(double)Double.parseDouble(a[28]);
							double tot=(double)Double.parseDouble(a[33]);
							basTotal=basTotal+bas;
							impTotal=impTotal+tot;
							
							String data[]=new String[6];
							data[0]=a[2];
							data[1]=a[3];
							data[2]=a[4];
							data[3]=formatoDecimal.format(bas);
							data[4]=formatoDecimal.format(tot);
							data[5]="FACTURADO";
							cuerpo.add(data);	
							elem++;		
						}
					}
				}

			}
			
					// rellenamos el cuerpo con lineas hasta el minimo de 25, si es que no hay suficientes
			
			for (int j=elem;j<24;j++) {
				String a[]={" "," "," "," "," "," "};
				cuerpo.add(a);	
			}
			
			// añadimos con los sumatorios
			String resumen1[]={" "," "," ","BASES","TOTALES"," "};
			cuerpo.add(resumen1);
			String resumen2[]={"SUMAS... "," "," ",formatoDecimal.format(basTotal),formatoDecimal.format(impTotal)," "};
			cuerpo.add(resumen2);
			String resumen3[]={" "," "," "," "," "," "};
			cuerpo.add(resumen3);

		} else {
			String data[]=new String[6];
			data[0]="NO EXISTEN DATOS EN LA SELECCION";
			data[1]="";
			data[2]="";
			data[3]="";
			data[4]="";
			data[5]="";
			cuerpo.add(data);			
		}
		
						
		// PIE
		//ClockAndDate today=new ClockAndDate();
		String pie="Listado generado por "+SpringFacturacion.nameUsuario+" el "+dateEsp.showMeTheDate();			
		
		if (!dataList.getDeliveriesList("listadoAlbaranes", titulo, cuerpo, pie)) {
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
				"Listado de albaranes es una relación ordenada por número de los albaranes \n" +
				"grabados correspondientes a el cliente o clientes seleccionados, pudiendo \n" +
				"seleccionar por estado (pendiente, facturado o todos) y por números.\n\n" +
				"1.- Al pulsar 'Listar' se generará una nueva pantalla con los datos de los \n" +
				"    albaranes: cliente, número, fecha, bases, cuotas y totales.\n" +
				"2.- En la pantalla generada, tendrá la posibilidad de generar un fichero .pdf \n" +
				"    o .csv (legible por excel) pulsando en el botón correspondiente.\n" +
				"3.- El fichero .pdf o .csv generado no se abrirá automáticamente, sino que se \n" +
				"    grabará en el directorio principal de instalación (donde resida la aplicación).\n" +
				"    Si ud. no tiene derechos de creación de ficheros, se producirá un error. \n" +
				"    En ese caso, debe consultar con su administrador de red.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE LISTADO ALBARANES"));
		
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
			
			
			// LISTA DE CLIENTES
			List<String[]> customersList=new ArrayList<String[]>();
			for (int n=indCustomer1;n<=indCustomer2;n++) {
				String a[]=new String[2];
				a[0]=listCustomers.get(n)[1];
				a[1]=listCustomers.get(n)[2];
				customersList.add(a);
			}
			
			// DESDE ALBARAN HASTA ALBARAN
			delivery1=0;
			try {
				delivery1=(long)Long.parseLong(firstDelivery.getSelectedItem().toString());
			} catch (NumberFormatException nf) {
				delivery1=0;
			}
			delivery2=0;
			try {
				delivery2=(long)Long.parseLong(lastDelivery.getSelectedItem().toString());
			} catch (NumberFormatException nf) {
				delivery2=(long)Long.MAX_VALUE;
			}
			
			// ESTADO A BUSCAR 0=TODOS, 1=PENDIENTES, 2=FACTURADOS
			state=deliveryState.getSelectedIndex();
			
			// LISTA DE LOS ALBARANES A IMPRIMIR
			listSelectedDeliveries=albaranes.searchAllDeliveriesCustomers(customersList);

			List<String[]> listDeliveriesToPrinting=new ArrayList<String[]>();
			if (listSelectedDeliveries!=null) {
				// seleccionamos los albaranes segun los criterios de seleccion de formulario
				for (String a[]:listSelectedDeliveries) {		
					long num=(long)Long.parseLong(a[3]);
					// se procesan los numeros dentro del rango
					if (delivery1<=num && num<=delivery2) {
						// si estado es cero quiere decir todos los albaranes
						if (state==0) {
							listDeliveriesToPrinting.add(a);
						} else if (state==1) {
							// estado 1 quiere decir albaranes pendientes
							if (a[1].isEmpty()) {
								listDeliveriesToPrinting.add(a);
							}
						} else {
							// estado 2 quiere decir albaranes facturados
							if (!a[1].isEmpty()) {
								listDeliveriesToPrinting.add(a);
							}
						}
					}
				}
			}

					
			showListDeliveries(listDeliveriesToPrinting);

		} // fin de lista
		
		
		if (source.equals("Generar .CSV")) {
			
			if (dataListCsv.generatesCsvFileList(listSelectedDeliveries, delivery1, delivery2, state,dateEsp.showMeTheDate())) {
				JOptionPane.showMessageDialog(mainFrame, "El fichero csv ha sido generado correctamente", "Generación de ficheros", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "ERROR\n\nNo ha sido posible generar el fichero csv", "Generación de ficheros", JOptionPane.ERROR_MESSAGE);
			}		
		} // fin de generarCSV
		
		
		if (source.equals("Generar .PDF")) {
			
			if (generatesPdfFile(listSelectedDeliveries, delivery1, delivery2, state)) {
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
