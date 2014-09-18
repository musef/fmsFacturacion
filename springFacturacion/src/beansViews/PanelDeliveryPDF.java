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


import beansControls.AlbaranesBean;
import beansControls.ClientesBean;
import beansList.ListadosCsv;
import beansList.ListadosPdf;
import beansModels.Albaranes;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelDeliveryPDF implements ActionListener, ItemListener {

	private JFrame mainFrame;
	private JPanel marcoAux1;
	
	// OBJETOS SPRING
	private AlbaranesBean albaranes;
	private ListadosPdf dataList;
	private ListadosCsv dataListCsv;
	private Albaranes albaran;
	private ClientesBean clientes;
	
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);	// LISTAR FACTURAS
	private final Color COLORL=Color.BLACK;
	private List<String[]> listDeliveries;
	private JComboBox<String> firstDelivery;
	private JComboBox<String> lastDelivery;
	
	private JButton listarPDF;
	private JButton listarCSV;
	private JButton info;
	
	public PanelDeliveryPDF() {
		// CONSTRUCTOR
	}
	
	
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	
	public void setDataList(ListadosPdf dataList) {
		// spring
		this.dataList = dataList;
	}
	
	public void setAlbaran (Albaranes albaran) {
		// spring
		this.albaran=albaran;
	}
	
	public void setClientes (ClientesBean clientes) {
		// spring
		this.clientes=clientes;
	}
	
	public void setDataListCsv(ListadosCsv dataListCsv) {
		// spring
		this.dataListCsv = dataListCsv;
	}
	
	
	
	/**
	 * Método que permite la selección de los albaranes a imprimir.
	 * 
	 * @return - un JPanel componiendo la pantalla de seleccion de albaranes
	 */
	
	public JPanel showMenu(JFrame mainFrame) {
			
		this.mainFrame=mainFrame;
		
		int fInv=0;
		
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
		
		
		firstDelivery=new JComboBox<String>();
		firstDelivery.addItem("Elija albarán");
		listDeliveries=albaranes.searchAllDeliveries();
		for (String[] list:listDeliveries) {
			firstDelivery.addItem(list[3]);
		}
		firstDelivery.setSelectedIndex(fInv);
		
		lastDelivery=new JComboBox<String>();
		lastDelivery.addItem("Elija albarán");
		listDeliveries=albaranes.searchAllDeliveries();
		for (String[] list:listDeliveries) {
			lastDelivery.addItem(list[3]);
		}
		lastDelivery.setSelectedIndex(fInv);		
		
		// titulo
		JLabel title=new JLabel("SELECCIÓN DE ALBARANES A GENERAR");
		title.setFont(font1);
				
		JLabel inv1=new JLabel("Desde Albarán...");
		inv1.setFont(font2);

		JLabel inv2=new JLabel("Hasta Albarán...");
		inv2.setFont(font2);		
	
		// preparamos los botones
		JPanel buttonPane=new JPanel();
		Dimension button=new Dimension(50,10);
		buttonPane.setPreferredSize(button);
		buttonPane.setMaximumSize(button);
		
		listarPDF=new JButton("Listar PDF");
		listarPDF.setToolTipText("pulse para listar los albaranes en formato .pdf");
		buttonPane.add(listarPDF);
		
		listarCSV=new JButton("Listar CSV");
		listarCSV.setToolTipText("pulse para listar los albaranes en formato .csv");
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
		listarPDF.addActionListener(this);
		listarCSV.addActionListener(this);
		info.addActionListener(this);
		firstDelivery.addItemListener(this);
		lastDelivery.addItemListener(this);
		
		return marco2;	
	
		
	} // end of printDeliveries
	
		
	
	/**
	 * Este metodo genera el fichero pdf de los albaranes seleccionados de una lista, entre delivery1 e delivery2.
	 * 
	 * @param list - Lista ordenadas por número de las albarans entre las que se encuentran las seleccionadas
	 * @param delivery1 - int, la primera albaran a generar pdf.
	 * @param delivery2 - int, la última albaran a generar pdf.
	 */
	
	private void showDelivery(List<String[]> list, int delivery1, int delivery2) {
		
		boolean allOK=true;
		
		for (int n=delivery1;n<=delivery2;n++) {
			
			String idDelivery=list.get(n)[3];	// numero albaran
			String idCustomer=list.get(n)[2];	// key del cliente
			
			// busca el albaran
			albaran=albaranes.getDelivery(idDelivery);
			if (albaran!=null) {
				// recupera los datos del cliente
				String cliente[]=clientes.getCustomer(idCustomer);
				// crea el nombre y genera el fichero
				String fileName="Albaran"+albaran.getNumber();
				if (dataList.getDelivery(fileName, albaran,cliente[2], cliente[3], cliente[4], cliente[5], cliente[6])) {
					// nop todo OK
				} else {
					allOK=false;
				}			
			}
		}
		
		if (allOK) {
			JOptionPane.showMessageDialog(mainFrame, "Los ficheros pdf han sido generados correctamente", "Generación de albaranes", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Ha habido algún error en los pdf generados.\nCompruebe los ficheros.", "Generación de albaranes", JOptionPane.ERROR_MESSAGE);
		}
		
	} // end of method showDelivery
	
	
	
	/**
	 * Este metodo generara los ficheros csv correspondientes a los albaranes incluidos en listSelected,
	 * entre numeros deliv1 y deliv2.
	 * 
	 * @param listSelectedDeliveries - Lista de albaranes
	 * @param deliv1 - Desde el albaran a listar
	 * @param deliv2 - Hasta el albaran a listar
	 * @return TRUE o FALSE con el resultado de la operación.
	 */
	
	private boolean generatesCsvFile(List<String[]>listSelectedDeliveries, long deliv1, long deliv2) {

		boolean allOK=true;
		
		for (int n=(int)deliv1;n<=deliv2;n++) {

			String idDelivery=listSelectedDeliveries.get(n)[3];	// numero albaran
			String idCustomer=listSelectedDeliveries.get(n)[2];	// key del cliente

			// busca el albaran
			albaran=albaranes.getDelivery(idDelivery);
			
			if (albaran!=null) {
				// recupera los datos del cliente
				String cliente[]=clientes.getCustomer(idCustomer);
				// crea el nombre y genera el fichero
				String fileName="Albaran"+albaran.getNumber();
				
				if (dataListCsv.generatesDelivery(fileName, albaran,cliente[2], cliente[3], cliente[4], cliente[5], cliente[6])) {
					// nop
				} else {
					allOK=false;
				}			
			}
					
		}

		if (allOK) {
			JOptionPane.showMessageDialog(mainFrame, "Los ficheros csv han sido generados correctamente", "Generación de albaranes", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Ha habido algún error en los csv generados.\nCompruebe los ficheros.", "Generación de albaranes", JOptionPane.ERROR_MESSAGE);
		}
		
		return allOK;
		
	} // end of method generatesTxtFile
	
	
	
	
	
	
	
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
				"Impresión de albaranes genera los ficheros pdf o csv de los albaranes seleccionadas\n" +
				"en la pantalla, mediante los filtros correspondientes.\n\n" +
				"1.- Podrá seleccionar desde un número de albarán hasta un número de albarán.\n" +
				"    Para generar uno concreto, deberá seleccionar el mismo número, obviamente.\n" +
				"2.- Pulsando en 'Listar PDF' el fichero se grabará automáticamente en el directorio\n" +
				"    principal de instalación (donde resida la aplicación).\n" +
				"3.- Pulsando en 'Listar CSV' el fichero se grabará automáticamente en el directorio\n" +
				"    principal de instalación (donde resida la aplicación).\n\n" +	
				"Los ficheros generados no se abrirán de forma automática. Simplemente se grabarán.\n" +				
				"Si ud. no tiene derechos de creación de ficheros, se producirá un error. En ese\n" +
				"caso, debe consultar con su administrador de red.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE GENERACIÓN DE FACTURAS"));
		
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
			
			int delivery1=firstDelivery.getSelectedIndex();
			int delivery2=lastDelivery.getSelectedIndex();
			
			if (delivery2>=delivery1 && delivery1>0) {
				showDelivery(listDeliveries,delivery1-1,delivery2-1);
			}		

		} // fin de listar PDF
		
		
		if (source.equals("Listar CSV")) {
			
			int delivery1=firstDelivery.getSelectedIndex();
			int delivery2=lastDelivery.getSelectedIndex();
			
			if (delivery2>=delivery1 && delivery1>0) {
				generatesCsvFile(listDeliveries,delivery1-1,delivery2-1);
			}		

		} // fin de listar CSV
		
		
		if (source.equals("info")) {
			createHelp();
		} // fin de info
		
	}
	
	
} // ************* END OF CLASS
