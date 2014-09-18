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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.ClientesBean;
import beansControls.FacturasBean;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelCustomersDeleting implements ActionListener, ItemListener {
	
	
	private JFrame mainFrame;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	private String keyToErase;
	private JComboBox<String> nameSelect3;
	private JTextField nameF3;
	private JTextField addressF3;
	private JTextField cityF3;
	private JTextField codeF3;
	private JTextField nifF3;
	private JButton info;
	private JButton eliminar;
	
	private List<String[]> listCustomers;
	
	//SPRING
	private ClientesBean customers;
	private FacturasBean facturas;
	private EnterSandMan reinicia;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;

	

	public PanelCustomersDeleting () {
		// CONSTRUCTOR
	}
	
	public void setCustomers(ClientesBean clientes) {
		// spring
		this.customers = clientes;	
	}
	
	public void setFacturas (FacturasBean facturas) {
		// spring
		this.facturas=facturas;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	
	/**
	 * Este método devuelve un JPanel con un formulario para poder seleccionar el
	 * cliente a borrar mediante un comboBox.
	 * 
	 * @return - un JPanel en forma de formulario de borrado de clientes
	 */
	
	public JPanel delCustomer(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,475));
		marcoAux1.setPreferredSize(new Dimension(650,475));
		marcoAux1.setMaximumSize(new Dimension(650,475));
		
		nameSelect3=new JComboBox<String>();
		nameSelect3.addItem("Seleccione... ");
		listCustomers=listCustomers();
		
		for (String[] list:listCustomers) {
			nameSelect3.addItem(list[2]);
		}
		
		// titulo
		JLabel title=new JLabel("BORRADO DE CLIENTES");
		title.setFont(font1);
		// creamos el formulario
		JLabel name=new JLabel("Nombre cliente ");
		name.setFont(font2);
		name.setForeground(colorL);
		nameF3=new JTextField("");
		nameF3.setToolTipText("máximo 50 caracteres");
		JLabel address=new JLabel("Dirección");
		address.setFont(font2);
		address.setForeground(colorL);
		addressF3=new JTextField("");
		addressF3.setToolTipText("máximo 50 caracteres");
		JLabel city=new JLabel("Localidad");
		city.setFont(font2);
		city.setForeground(colorL);
		cityF3=new JTextField("");
		cityF3.setToolTipText("máximo 50 caracteres");
		JLabel code=new JLabel("Código postal");
		code.setFont(font2);
		code.setForeground(colorL);
		codeF3=new JTextField("");
		codeF3.setToolTipText("máximo 5 caracteres");
		JLabel nif=new JLabel("N.I.F.");
		nif.setFont(font2);
		nif.setForeground(colorL);
		nifF3=new JTextField("");
		nifF3.setToolTipText("máximo 9 caracteres");
		
		nameF3.setEditable(false);
		addressF3.setEditable(false);
		cityF3.setEditable(false);
		codeF3.setEditable(false);
		nifF3.setEditable(false);
	
		// preparamos los botones
		eliminar=new JButton("Eliminar");
		eliminar.setToolTipText("pulse para eliminar este cliente");
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
		panelButton1.add(new JLabel());
		panelButton1.add(eliminar);
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
		marcoAux1.add(nameSelect3);
		marcoAux1.add(new JLabel(" "));		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name);
		marcoAux1.add(nameF3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(address);
		marcoAux1.add(addressF3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(city);
		marcoAux1.add(cityF3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(code);
		marcoAux1.add(codeF3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(nif);
		marcoAux1.add(nifF3);
		
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
		marcoAux1.add(panelButton1);
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
		eliminar.addActionListener(this);
		info.addActionListener(this);
		nameSelect3.addItemListener(this);
		
		return marco2;
		
	} // end of delCustomer
	
	
	
	
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
		if (nameSelect3!=null && nameSelect3.getSelectedIndex()>0) {
			keyToErase=listCustomers.get(nameSelect3.getSelectedIndex()-1)[1];			
			nameF3.setText(listCustomers.get(nameSelect3.getSelectedIndex()-1)[2]);
			addressF3.setText(listCustomers.get(nameSelect3.getSelectedIndex()-1)[3]);
			cityF3.setText(listCustomers.get(nameSelect3.getSelectedIndex()-1)[5]);
			codeF3.setText(listCustomers.get(nameSelect3.getSelectedIndex()-1)[4]);
			nifF3.setText(listCustomers.get(nameSelect3.getSelectedIndex()-1)[6]);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getActionCommand();
		
		if (source.equals("Eliminar")) {
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea eliminar este cliente?", "Borrado de clientes", JOptionPane.YES_NO_OPTION)==0) {
				List<String[]> customerToErase=new ArrayList<String[]>();
				String data[]={"",keyToErase};
				customerToErase.add(data);
				if (facturas.searchExtractInvoicesByCustomers(customerToErase).size()>0) {
					if (JOptionPane.showConfirmDialog(mainFrame, "¿Realmente desea eliminar este cliente?\nTiene facturas grabadas.", "Borrado de clientes", JOptionPane.YES_NO_OPTION)==0) {
						if (customers.eraseCustomer(keyToErase)) {
							JOptionPane.showMessageDialog(mainFrame, "El cliente ha sido eliminado correctamente", "Borrado de clientes", JOptionPane.INFORMATION_MESSAGE);
							reinicia.reinicia(2, 3);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error en el borrado del cliente", "Borrado de clientes", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else if (customers.eraseCustomer(keyToErase)) {
							JOptionPane.showMessageDialog(mainFrame, "El cliente ha sido eliminado correctamente", "Borrado de clientes", JOptionPane.INFORMATION_MESSAGE);
							reinicia.reinicia(2, 3);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error en el borrado del cliente", "Borrado de clientes", JOptionPane.ERROR_MESSAGE);
						}
			}

		} // fin de eliminar
		
		
		if (source.equals("info")) {
			createHelp();
		}
	}
	
	
} // ********************************* END OF CLASS
