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

public class PanelCustomersCreating implements ActionListener, ItemListener {
	
	
	private JFrame mainFrame;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	private JTextField nameF;
	private JTextField addressF;
	private JTextField cityF;
	private JTextField codeF;
	private JTextField nifF;
	private JTextField payF;
	private JComboBox<String> getPay;
	private JTextField taxAddressF;
	private JTextField taxCityF;
	private JTextField taxCodeF;
	private JCheckBox checkTax;
	private JButton info;
	private JButton grabar;
	private JButton borrar;
	
	private List<String[]> custPagos;
	
	// SPRING
	private PagosBean pagosCust;
	private Clientes thisCustomer;
	private ClientesBean customers;
	private EnterSandMan reinicia;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;

	public PanelCustomersCreating() {
		// CONSTRUCTOR
	}
	


	public void setPagosCust(PagosBean pagos) {
		// spring
		this.pagosCust = pagos;
	}
	
	public void setThisCustomer(Clientes thisCustomer) {
		// spring
		this.thisCustomer = thisCustomer;
	}
	
	public void setCustomers(ClientesBean clientes) {
		// spring
		this.customers = clientes;	
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	
	/**
	 * Este método devuelve un JPanel con un formulario para poder dar de alta
	 * un nuevo cliente en la base de datos.
	 * 
	 * @return - un JPanel en forma de formulario de creación de clientes
	 */

	public JPanel newCustomer(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,475));
		marcoAux1.setPreferredSize(new Dimension(650,475));
		marcoAux1.setMaximumSize(new Dimension(650,475));
		
		// titulo
		JLabel title=new JLabel("ALTA DE CLIENTES");
		title.setFont(font1);
		// creamos el formulario
		JLabel name=new JLabel("Nombre cliente ");
		name.setFont(font2);
		name.setForeground(colorL);
		nameF=new JTextField("");
		nameF.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		JLabel address=new JLabel("Dirección");
		address.setFont(font2);
		address.setForeground(colorL);
		addressF=new JTextField("");
		addressF.setToolTipText("máximo 50 caracteres");
		JLabel city=new JLabel("Localidad");
		city.setFont(font2);
		city.setForeground(colorL);
		cityF=new JTextField("");
		cityF.setToolTipText("máximo 50 caracteres");
		JLabel code=new JLabel("Código postal");
		code.setFont(font2);
		code.setForeground(colorL);
		codeF=new JTextField("");
		codeF.setToolTipText("OBLIGATORIO: 5 caracteres");
		JLabel nif=new JLabel("N.I.F.");
		nif.setFont(font2);
		nif.setForeground(colorL);
		nifF=new JTextField("");
		nifF.setToolTipText("OBLIGATORIO: 9 caracteres");

		//pagos=new PagosBean();
		if ((custPagos=pagosCust.getListPago())==null) {
			custPagos.add(new String[5]);
		}
		getPay=new JComboBox<String>();
		getPay.addItem("Seleccione pago");
		for (String[]n:custPagos) {
			getPay.addItem(n[1]);
		}
		payF=new JTextField("");
		payF.setEnabled(false);
		//payF.setToolTipText("máximo 50 caracteres");
		checkTax=new JCheckBox();
		
		JLabel taxAddress=new JLabel("Dirección fiscal");
		taxAddress.setFont(font2);
		taxAddress.setForeground(colorL);
		taxAddressF=new JTextField("");
		taxAddressF.setToolTipText("máximo 50 caracteres");
		taxAddressF.setEditable(false);
		JLabel taxCity=new JLabel("Localidad fiscal");
		taxCity.setFont(font2);
		taxCity.setForeground(colorL);
		taxCityF=new JTextField("");
		taxCityF.setToolTipText("máximo 50 caracteres");
		taxCityF.setEditable(false);
		JLabel taxCode=new JLabel("C.P. fiscal");
		taxCode.setFont(font2);
		taxCode.setForeground(colorL);
		taxCodeF=new JTextField("");
		taxCodeF.setToolTipText("5 caracteres");	
		taxCodeF.setEditable(false);

	
		// preparamos los botones y deshabilitamos los botones cambiar y cancelar
		// porque inicialmente no son operativos hasta seleccionar cuenta
		grabar=new JButton("Grabar");
		grabar.setToolTipText("pulse para añadir un nuevo cliente");
		borrar=new JButton("Borrar");
		borrar.setToolTipText("pulse para borrar formulario");
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
		panelButton1.add(grabar);
		panelButton1.add(new JLabel());
		JPanel panelButton2=new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(new JLabel());
		panelButton2.add(borrar);
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
		marcoAux1.add(name);
		marcoAux1.add(nameF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(address);
		marcoAux1.add(addressF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(city);
		marcoAux1.add(cityF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(code);
		marcoAux1.add(codeF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(nif);
		marcoAux1.add(nifF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(getPay);
		marcoAux1.add(payF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel("distinto domicilio fiscal"));
		marcoAux1.add(checkTax);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxAddress);
		marcoAux1.add(taxAddressF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxCity);
		marcoAux1.add(taxCityF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(taxCode);
		marcoAux1.add(taxCodeF);
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton1);
		marcoAux1.add(panelButton2);
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
		borrar.addActionListener(this);
		grabar.addActionListener(this);
		info.addActionListener(this);
		checkTax.addItemListener(this);
		getPay.addItemListener(this);
		
		return marco2;
		
	} // end of newCustomer
	
	
	
	/**
	 * Este metodo chequea el formulario de grabación de clientes.
	 * El formulario estará correcto siempre y cuando tenga rellenado el nombre, el
	 * código postal y el nif. Tambien controla que el resto de los datos tengan la
	 * longitud y el tipo de datos correcto.
	 * 
	 * @param select - int que informa de la sección del formulario (alta=0, modificacion=1)
	 * 
	 * @return boolean TRUE / FALSE según el formulario este correcto o incorrecto.
	 */
	
	private boolean checkForm(int select) {
		
		boolean result=true;
		
		
			
			nameF.setBackground(OKFORM);
			addressF.setBackground(OKFORM);
			cityF.setBackground(OKFORM);
			codeF.setBackground(OKFORM);
			nifF.setBackground(OKFORM);
			payF.setBackground(OKFORM);
			taxCodeF.setBackground(OKFORM);
			taxAddressF.setBackground(OKFORM);
			taxCityF.setBackground(OKFORM);
			
			if (nameF.getText().trim().length()<3 || nameF.getText().trim().length()>50) {
				nameF.setBackground(ERRORFORM);
				result=false;
			}
			if (addressF.getText().trim().length()>50) {
				addressF.setBackground(ERRORFORM);
				result=false;
			}
			if (cityF.getText().trim().length()>50) {
				cityF.setBackground(ERRORFORM);
				result=false;
			}
			if (codeF.getText().trim().length()!=5) {
				codeF.setBackground(ERRORFORM);
				result=false;
			}
			if (nifF.getText().trim().length()!=9) {
				nifF.setBackground(ERRORFORM);
				result=false;
			}
			if (payF.getText().trim().length()>50) {
				payF.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax.isSelected() && taxCodeF.getText().trim().length()!=5) {
				taxCodeF.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax.isSelected() && taxCityF.getText().trim().length()>50) {
				taxCityF.setBackground(ERRORFORM);
				result=false;
			}
			if (checkTax.isSelected() && taxAddressF.getText().trim().length()>50) {
				taxAddressF.setBackground(ERRORFORM);
				result=false;
			}
			
			if (getPay.getSelectedIndex()==0) {
				payF.setBackground(ERRORFORM);
				result=false;
			}
						
			
	
		
		return result;
		
	} // end of method checkForm
	
	
	
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
		
		if (checkTax!=null && checkTax.isSelected()) {
			taxAddressF.setEditable(true);
			taxCodeF.setEditable(true);
			taxCityF.setEditable(true);
		} else if (checkTax!=null && !checkTax.isSelected()) {
			taxAddressF.setEditable(false);
			taxCodeF.setEditable(false);
			taxCityF.setEditable(false);
		}


		if (getPay!=null && getPay.getSelectedIndex()!=0) {
			payF.setText(custPagos.get(getPay.getSelectedIndex()-1)[2]);
		} else if (getPay!=null && getPay.getSelectedIndex()==0) {
			payF.setText("");
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getActionCommand();
		
		if (source.equals("Grabar")) {
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea grabar este cliente?", "Grabación de clientes", JOptionPane.YES_NO_OPTION)==0) {
				if (checkForm(0)) {
					// revisado OK el formulario
					//Clientes cliente=new Clientes();
					thisCustomer.setCustomerName(nameF.getText().trim());
					thisCustomer.setCustomerAddress(addressF.getText().trim());
					thisCustomer.setCustomerCity(cityF.getText().trim());
					thisCustomer.setCustomerCP(codeF.getText().trim());
					thisCustomer.setCustomerNIF(nifF.getText().trim());
					int typePay=getPay.getSelectedIndex()-1;
					thisCustomer.setPayment((long)Long.parseLong(custPagos.get(typePay)[0]));
					thisCustomer.setTaxAddress(taxAddressF.getText().trim());
					thisCustomer.setTaxCity(taxCityF.getText().trim());
					thisCustomer.setTaxCP(taxCodeF.getText().trim());
					int numAleatorio2=(int)Math.floor((Math.random()*(8999))+1001);

					String keyCust=nameF.getText().trim().substring(0, 3)+String.valueOf(numAleatorio2)+nifF.getText().trim().substring(0, 3);
					thisCustomer.setCustomerKey(keyCust);
					
					if (customers.createCustomer(thisCustomer)) {
						JOptionPane.showMessageDialog(mainFrame, "El cliente ha sido grabado correctamente", "Grabación de clientes", JOptionPane.INFORMATION_MESSAGE);
						reinicia.reinicia(2, 1);
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Error en la grabación del cliente", "Grabación de clientes", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en el formulario de creación", "Grabación de clientes", JOptionPane.ERROR_MESSAGE);
				}
			}

		} // fin de guardar
		
		
		if (source.equals("Borrar")) { 
			nameF.setText("");
			addressF.setText("");
			cityF.setText("");
			codeF.setText("");
			nifF.setText("");
			payF.setText("");
			taxAddressF.setText("");
			taxCityF.setText("");
			taxCodeF.setText("");
			
		} // fin de borrar 
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}
	
	
} // ************************************** END OF CLASS
