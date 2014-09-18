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
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.FacturasBean;
import beansList.ListadosCsv;
import beansList.ListadosPdf;
import beansModels.Facturas;




/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicePDF implements ActionListener, ItemListener {

	private JFrame mainFrame;
	private JPanel marcoAux1;
	
	// OBJETOS SPRING
	private FacturasBean facturador;
	private ListadosPdf dataList;
	private ListadosCsv dataListCsv;
	private Facturas factura;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);	// LISTAR FACTURAS
	private List<String[]> listInvoices;
	private JComboBox<String> serialInvoices;
	private JComboBox<String> firstInvoice;
	private JComboBox<String> lastInvoice;
	private final Color COLORL=Color.BLACK;
	
	private JButton listarPDF;
	private JButton listarCSV;
	private JButton info;
	
	public PanelInvoicePDF() {
		// CONSTRUCTOR
	}
	
	
	
	public void setFacturador (FacturasBean facturador) {
		// spring
		this.facturador=facturador;
	}
	
	public void setDataList(ListadosPdf dataList) {
		// spring
		this.dataList = dataList;
	}
	
	public void setFactura (Facturas factura) {
		// spring
		this.factura=factura;
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
	
	public JPanel printInvoice(JFrame mainFrame) {
			
		this.mainFrame=mainFrame;
		
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
		
		serialInvoices=new JComboBox<String>();
		serialInvoices.addItem("Todas las series");
		
		int fInv=0;
		firstInvoice=new JComboBox<String>();
		firstInvoice.addItem("Elija factura");
		listInvoices=facturador.searchAllInvoiceNumber();
		//listSelectedInvoices=facturador.searchExtractInvoices();
		for (String[] list:listInvoices) {
			firstInvoice.addItem(list[1]);
		}
		firstInvoice.setSelectedIndex(fInv);
		
		lastInvoice=new JComboBox<String>();
		lastInvoice.addItem("Elija factura");
		listInvoices=facturador.searchAllInvoiceNumber();
		//listSelectedInvoices=facturador.searchExtractInvoices();
		for (String[] list:listInvoices) {
			lastInvoice.addItem(list[1]);
		}
		lastInvoice.setSelectedIndex(fInv);		
		
		// titulo
		JLabel title=new JLabel("SELECCIÓN DE FACTURAS A GENERAR");
		title.setFont(font1);
		
		JLabel serial1=new JLabel("Elija Serie...");
		serial1.setFont(font2);
				
		JLabel inv1=new JLabel("Desde Factura...");
		inv1.setFont(font2);

		JLabel inv2=new JLabel("Hasta Factura...");
		inv2.setFont(font2);		
	
		// preparamos los botones

		JPanel buttonPane=new JPanel();
		Dimension button=new Dimension(50,10);
		buttonPane.setPreferredSize(button);
		buttonPane.setMaximumSize(button);
		
		listarPDF=new JButton("Listar PDF");
		listarPDF.setToolTipText("pulse para listar las facturas");
		buttonPane.add(listarPDF);
		
		listarCSV=new JButton("Listar CSV");
		listarCSV.setToolTipText("pulse para listar las facturas");
		buttonPane.add(listarCSV);
		
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
		
		marcoAux1.setLayout(new GridLayout(13,4));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton3);
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(serial1);
		marcoAux1.add(serialInvoices);
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
		listarCSV.addActionListener(this);
		listarPDF.addActionListener(this);
		info.addActionListener(this);
		firstInvoice.addItemListener(this);
		lastInvoice.addItemListener(this);
		
		return marco2;	
		
	} // end of printInvoices
	
		
	
	/**
	 * Este metodo genera el fichero pdf de las facturas seleccionada de una lista, entre invoice1 e invoice2.
	 * 
	 * @param list - Lista ordenadas por número de las facturas entre las que se encuentran las seleccionadas
	 * @param invoice1 - int, la primera factura a generar pdf.
	 * @param invoice2 - int, la última factura a generar pdf.
	 */
	
	private void showInvoicePDF(List<String[]> list, int invoice1, int invoice2) {
		
		boolean allOK=true;
		
		for (int n=invoice1;n<=invoice2;n++) {
			
			String idInvoice=list.get(n)[0];
			// busca la factura
			factura=facturador.getInvoiceById(idInvoice);
			if (factura!=null) {
				// crea el nombre y genera el fichero
				String fileName="Factura"+factura.getSerial()+factura.getNumber();
				if (dataList.getInvoice(fileName, factura)) {
					// nop
				} else {
					allOK=false;
				}			
			}
		}
		
		if (allOK) {
			JOptionPane.showMessageDialog(mainFrame, "Los ficheros pdf han sido generados correctamente", "Generación de facturas", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Ha habido algún error en los pdf generados.\nCompruebe los ficheros.", "Generación de facturas", JOptionPane.ERROR_MESSAGE);
		}
		
	} // end of method showInvoicePDF
	
	
	
	private void showInvoiceCSV(List<String[]> list, int invoice1, int invoice2) {
		
		boolean allOK=true;
		
		for (int n=invoice1;n<=invoice2;n++) {
			
			String idInvoice=list.get(n)[0];
			// busca la factura
			factura=facturador.getInvoiceById(idInvoice);
			if (factura!=null) {
				// crea el nombre y genera el fichero
				String fileName="Factura"+factura.getSerial()+factura.getNumber();
				if (dataListCsv.generatesInvoice(fileName, factura)) {
					// nop
				} else {
					allOK=false;
				}			
			}
		}
		
		if (allOK) {
			JOptionPane.showMessageDialog(mainFrame, "Los ficheros csv han sido generados correctamente", "Generación de facturas", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Ha habido algún error en los csv generados.\nCompruebe los ficheros.", "Generación de facturas", JOptionPane.ERROR_MESSAGE);
		}
		
	} // end of method showInvoiceCSV
	
	
	
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
				"Impresión de facturas genera los ficheros pdf de las facturas seleccionadas en la\n" +
				"pantalla, mediante los filtros correspondientes.\n\n" +
				"1.- Serie de facturación: en la versión 1.1 no es posible seleccionar por series,\n" +
				"    se mostrarán todas las facturas correspondientes a todas las series creadas.\n" +
				"2.- Podrá seleccionar desde un número de factura hasta un número de factura.\n" +
				"    Para generar una sola factura, deberá seleccionar el mismo número, obviamente.\n" +
				"3.- Pulsando en 'Listar PDF' el fichero se grabará automáticamente en el directorio\n" +
				"    principal de instalación (donde resida la aplicación). Igual en el caso de\n " +
				"    'Listar CSV'.\n" +
				"    Si ud. no tiene derechos de creación de ficheros, se producirá un error. En ese\n" +
				"    caso, debe consultar con su administrador de red.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE GENERACIÓN PDF FACTURAS"));
		
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
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("Listar PDF")) {
			
			int invoice1=firstInvoice.getSelectedIndex();
			int invoice2=lastInvoice.getSelectedIndex();
			
			if (invoice2>=invoice1 && invoice1>0) {
				showInvoicePDF(listInvoices,invoice1-1,invoice2-1);
			}		

		} // fin de listaPDF
		
		
		if (source.equals("Listar CSV")) {
			
			int invoice1=firstInvoice.getSelectedIndex();
			int invoice2=lastInvoice.getSelectedIndex();
			
			if (invoice2>=invoice1 && invoice1>0) {
				showInvoiceCSV(listInvoices,invoice1-1,invoice2-1);
			}		

		} // fin de listaCSV
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}
	
	
} // ************* END OF CLASS
