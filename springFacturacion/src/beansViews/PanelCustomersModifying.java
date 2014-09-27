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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import beansControls.PagosBean;
import beansModels.Clientes;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelCustomersModifying implements ActionListener, ItemListener {
	
	
	private JFrame mainFrame;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	private List<String[]> listCustomers;
	
	private String idToModify;
	private String keyToModify;
	private JComboBox<String> nameSelect2;
	private JTextField nameF2;
	private JTextField addressF2;
	private JTextField cityF2;
	private JTextField codeF2;
	private JTextField nifF2;
	private JTextField payF2;
	private String idPaymentF2;
	private JComboBox<String> getPay2;
	private JTextField taxAddressF2;
	private JTextField taxCityF2;
	private JTextField taxCodeF2;
	private JCheckBox checkTax2;
	private JButton info;
	private JButton cambiar;
	private JButton borrar2;
	
	private List<String[]> custPagos;
	
	// SPRING
	private PagosBean pagosCust;
	private ClientesBean customers;
	private Clientes clienteToMod;
	private EnterSandMan reinicia;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	
	
	public PanelCustomersModifying() {
		// CONSTRUCTOR
	}
	


	public void setPagosCust(PagosBean pagos) {
		// spring
		this.pagosCust = pagos;
	}
	
	public void setCustomers(ClientesBean clientes) {
		// spring
		this.customers = clientes;	
	}
	
	public void setThisCustomer(Clientes thisCustomer) {
		// spring
		this.clienteToMod=thisCustomer;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	/**
	 * Este m�todo devuelve un JPanel con un formulario para poder seleccionar el
	 * cliente a modificar mediante un comboBox.
	 * 
	 * @return - un JPanel en forma de formulario de modificaci�n de clientes
	 */
	
	public JPanel modCustomer(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,475));
		marcoAux1.setPreferredSize(new Dimension(650,475));
		marcoAux1.setMaximumSize(new Dimension(650,475));
		
		nameSelect2=new JComboBox<String>();
		nameSelect2.addItem("Seleccione... ");
		listCustomers=listCustomers();	
		for (String[] list:listCustomers) {
			nameSelect2.addItem(list[2]);
		}
		
		// titulo
		JLabel title=new JLabel("MODIFICACI�N DE CLIENTES");
		title.setFont(font1);
		// creamos el formulario
		JLabel name=new JLabel("Nombre cliente ");
		name.setFont(font2);
		name.setForeground(colorL);
		nameF2=new JTextField("");
		nameF2.setToolTipText("OBLIGATORIO: entre 3 y 50 caracteres");
		JLabel address=new JLabel("Direcci�n");
		address.setFont(font2);
		address.setForeground(colorL);
		addressF2=new JTextField("");
		addressF2.setToolTipText("m�ximo 50 caracteres");
		JLabel city=new JLabel("Localidad");
		city.setFont(font2);
		city.setForeground(colorL);
		cityF2=new JTextField("");
		cityF2.setToolTipText("m�ximo 50 caracteres");
		JLabel code=new JLabel("C�digo postal");
		code.setFont(font2);
		code.setForeground(colorL);
		codeF2=new JTextField("");
		codeF2.setToolTipText("OBLIGATORIO: 5 caracteres");
		JLabel nif=new JLabel("N.I.F.");
		nif.setFont(font2);
		nif.setForeground(colorL);
		nifF2=new JTextField("");
		nifF2.setToolTipText("OBLIGATORIO: 9 caracteres");
		//pagos=new PagosBean();
		if ((custPagos=pagosCust.getListPago())==null) {
			custPagos.add(new String[5]);
		}
		getPay2=new JComboBox<String>();
		getPay2.addItem("Seleccione pago");
		for (String[]n:custPagos) {
			getPay2.addItem(n[1]);
		}
		payF2=new JTextField("");
		payF2.setEnabled(false);

		checkTax2=new JCheckBox();
		
		JLabel taxAddress=new JLabel("Direcci�n fiscal");
		taxAddress.setFont(font2);
		taxAddress.setForeground(colorL);
		taxAddressF2=new JTextField("");
		taxAddressF2.setToolTipText("m�ximo 50 caracteres");
		taxAddressF2.setEditable(false);
		JLabel taxCity=new JLabel("Localidad fiscal");
		taxCity.setFont(font2);
		taxCity.setForeground(colorL);
		taxCityF2=new JTextField("");
		taxCityF2.setToolTipText("m�ximo 50 caracteres");
		taxCityF2.setEditable(false);
		JLabel taxCode=new JLabel("C.P. fiscal");
		taxCode.setFont(font2);
		taxCode.setForeground(colorL);
		taxCodeF2=new JTextField("");
		taxCodeF2.setToolTipText("5 caracteres");	
		taxCodeF2.setEditable(false);
		
		// preparamos los botones
		cambiar=new JButton("Modificar");
		cambiar.setToolTipText("pulse para modificar este cliente");
		borrar2=new JButton("Borrar");
		borrar2.setToolTipText("pulse para borrar formulario");
		ImageIcon icon = new ImageIcon("src/images/info.png");
		info=new JButton(icon);
		info.setBorderPainted(true);
		info.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		info.setMargin(m);
		info.setToolTipText("pulse para informaci�n");
		info.setActionCommand("info");

		JPanel panelButton1=new JPanel();
		panelButton1.setLayout(new FlowLayout());
		panelButton1.add(cambiar);
		panelButton1.add(new JLabel());
		JPanel panelButton2=new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(new JLabel());
		panelButton2.add(borrar2);
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		panelButton3.add(info);
		Dimension dimP=new Dimension(60,50);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);
		
		// a�adimos todos los elementos a los JPanel auxiliares
		marcoAux0.add(title);
		marcoAux1.setLayout(new GridLayout(15,4));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(nameSelect2);
		marcoAux1.add(new JLabel(" "));	
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name);
		marcoAux1.add(nameF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(address);
		marcoAux1.add(addressF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(city);
		marcoAux1.add(cityF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(code);
		marcoAux1.add(codeF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(nif);
		marcoAux1.add(nifF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(getPay2);
		marcoAux1.add(payF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel("distinto domicilio fiscal"));
		marcoAux1.add(checkTax2);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxAddress);
		marcoAux1.add(taxAddressF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxCity);
		marcoAux1.add(taxCityF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxCode);
		marcoAux1.add(taxCodeF2);
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton1);
		marcoAux1.add(panelButton2);
		marcoAux1.add(new JLabel(" "));
		
		// a�adimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0,BorderLayout.NORTH);
		marco2.add(marcoAux1,BorderLayout.CENTER);
		marco2.add(new JLabel("         "),BorderLayout.EAST);
		marco2.add(new JLabel("         "),BorderLayout.WEST);
		marco2.add(new JLabel("       "),BorderLayout.SOUTH);
		
		// le a�adimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		borrar2.addActionListener(this);
		cambiar.addActionListener(this);
		info.addActionListener(this);
		checkTax2.addItemListener(this);
		nameSelect2.addItemListener(this);
		getPay2.addItemListener(this);
		
		return marco2;
		
	} // end of modCustomer
	
	
	
	/**
	 * Este metodo chequea el formulario de grabaci�n de clientes.
	 * El formulario estar� correcto siempre y cuando tenga rellenado el nombre, el
	 * c�digo postal y el nif. Tambien controla que el resto de los datos tengan la
	 * longitud y el tipo de datos correcto.
	 * 
	 * @param select - int que informa de la secci�n del formulario (alta=0, modificacion=1)
	 * 
	 * @return boolean TRUE / FALSE seg�n el formulario este correcto o incorrecto.
	 */
	
	private boolean checkForm(int select) {
		
		boolean result=true;
		
		
			
			nameF2.setBackground(OKFORM);
			addressF2.setBackground(OKFORM);
			cityF2.setBackground(OKFORM);
			codeF2.setBackground(OKFORM);
			nifF2.setBackground(OKFORM);
			payF2.setBackground(OKFORM);
			taxCodeF2.setBackground(OKFORM);
			taxAddressF2.setBackground(OKFORM);
			taxCityF2.setBackground(OKFORM);
			
			if (nameF2.getText().trim().length()<3 || nameF2.getText().trim().length()>50) {
				nameF2.setBackground(ERRORFORM);
				result=false;
			}
			if (addressF2.getText().trim().length()>50) {
				addressF2.setBackground(ERRORFORM);
				result=false;
			}
			if (cityF2.getText().trim().length()>50) {
				cityF2.setBackground(ERRORFORM);
				result=false;
			}
			if (codeF2.getText().trim().length()!=5) {
				codeF2.setBackground(ERRORFORM);
				result=false;
			}
			if (nifF2.getText().trim().length()!=9) {
				nifF2.setBackground(ERRORFORM);
				result=false;
			}
			if (payF2.getText().trim().length()>50) {
				payF2.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax2.isSelected() && taxCodeF2.getText().trim().length()!=5) {
				taxCodeF2.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax2.isSelected() && taxCityF2.getText().trim().length()>50) {
				taxCityF2.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax2.isSelected() && taxAddressF2.getText().trim().length()>50) {
				taxAddressF2.setBackground(ERRORFORM);
				result=false;
			}
			
	
		return result;
		
	} // end of method checkForm
	
	
	/**
	 * Este m�todo devuelve una nueva lista de clientes, con su informaci�n para manejar.
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
		title.add(new JLabel("AYUDA DE MEN� CLIENTES"));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea(
				"- En el men� de clientes puede crear, modificar, eliminar y listar\n" +
				"los clientes objeto de facturaci�n y notas de entrega.\n" +
				"Se recomienda crear un cliente gen�rico para sus ventas al\n" +
				"p�blico. En la versi�n 1.1 no existe la posibilidad de emitir \n" +
				"tickets de venta.\n\n" +
				"1.- Tanto en Alta como en Modificaci�n, deber� introducir como\n" +
				"m�nimo el nombre del cliente, el nif y el c�digo postal.\n" +
				"2.- Existe la opci�n de dar de alta un domicilio fiscal distinto,\n" +
				"el cual ser� entonces el domicilio de factura.\n" +
				"3.- No es recomendable borrar empresas que tienen facturaci�n,\n" +
				"ni modificar los datos con un nif distinto.\n" +
				"4.- Cada nif distinto deber�a ser un cliente distinto, con\n" +
				"excepci�n del cliente gen�rico de venta al contado, si lo crea.\n" +
				"5.- Listados es solamente una relaci�n de los clientes seleccio-.\n" +
				"nados, con sus datos de facturaci�n.\n");
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
		if (checkTax2!=null && checkTax2.isSelected()) {
			taxAddressF2.setEditable(true);
			taxCodeF2.setEditable(true);
			taxCityF2.setEditable(true);
		} else if (checkTax2!=null && !checkTax2.isSelected()) {
			taxAddressF2.setEditable(false);
			taxCodeF2.setEditable(false);
			taxCityF2.setEditable(false);
		}
		
		
		if (nameSelect2!=null && nameSelect2.getSelectedIndex()>0) {
			idToModify=listCustomers.get(nameSelect2.getSelectedIndex()-1)[0];
			keyToModify=listCustomers.get(nameSelect2.getSelectedIndex()-1)[1];	
			nameF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[2]);
			addressF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[3]);
			cityF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[5]);
			codeF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[4]);
			nifF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[6]);
			idPaymentF2=listCustomers.get(nameSelect2.getSelectedIndex()-1)[7];
			String payment[]=pagosCust.getPago(idPaymentF2);
			if (payment==null) {
				payment=new String[5];
			}

			payF2.setText(payment[2]);
			taxAddressF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[8]);
			taxCityF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[10]);
			taxCodeF2.setText(listCustomers.get(nameSelect2.getSelectedIndex()-1)[9]);
		}
		
		if (getPay2!=null && getPay2.getSelectedIndex()!=0) {
			payF2.setText(custPagos.get(getPay2.getSelectedIndex()-1)[2]);
		} 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getActionCommand();
		
		if (source.equals("Modificar")) {
			if (JOptionPane.showConfirmDialog(mainFrame, "�Desea modificar este cliente?", "Modificaci�n de clientes", JOptionPane.YES_NO_OPTION)==0) {
				if (checkForm(1)) {
					// revisado OK el formulario
					//Clientes cliente=new Clientes();
					long idMod=0;
					try {
						idMod=(long)Long.parseLong(idToModify);
					} catch (NumberFormatException nf) {
						idMod=0;
					}
					clienteToMod.setId(idMod);
					clienteToMod.setCustomerKey(keyToModify);
					clienteToMod.setCustomerName(nameF2.getText().trim());
					clienteToMod.setCustomerAddress(addressF2.getText().trim());
					clienteToMod.setCustomerCity(cityF2.getText().trim());
					clienteToMod.setCustomerCP(codeF2.getText().trim());
					clienteToMod.setCustomerNIF(nifF2.getText().trim());
					
					clienteToMod.setPayment((long)Long.parseLong(idPaymentF2));
					clienteToMod.setTaxAddress(taxAddressF2.getText().trim());
					clienteToMod.setTaxCity(taxCityF2.getText().trim());
					clienteToMod.setTaxCP(taxCodeF2.getText().trim());	
					
					if (customers.modifyCustomer(keyToModify, clienteToMod)) {
						JOptionPane.showMessageDialog(mainFrame, "El cliente ha sido modificado correctamente", "Modificaci�n de clientes", JOptionPane.INFORMATION_MESSAGE);
						reinicia.reinicia(2, 2);
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Error en la modificaci�n del cliente", "Modificaci�n de clientes", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en formulario de modificaci�n", "Modificaci�n de clientes", JOptionPane.ERROR_MESSAGE);
				}
			}

		} // fin de modificar
		
		if (source.equals("Borrar")) { 
			
			nameF2.setText("");
			addressF2.setText("");
			cityF2.setText("");
			codeF2.setText("");
			nifF2.setText("");
			payF2.setText("");
			taxAddressF2.setText("");
			taxCityF2.setText("");
			taxCodeF2.setText("");
		
		} // fin de borrar
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}
	

} // *********************************************** END OF CLASS
