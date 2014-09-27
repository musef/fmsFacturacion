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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.PagosBean;
import beansModels.FormaPago;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class PanelAdminPagos implements ActionListener, ItemListener {
	
	private JFrame mainFrame;
	private JPanel marco2;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	// PAGOS
	private JComboBox<String> selPago;
	private JTextField namePago;
	private JTextField textoPago;
	private JTextField diasPago;
	private JTextField fechaPago;
	private JButton grabarP;
	private JButton borrarP;
	private JButton infoP;
	
	// SPRING
	private PagosBean pagos;
	private FormaPago newPago;
	private EnterSandMan reinicia;
	
	private List<String[]> allPagos;
	private String idPago;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;
	
	
	
	public PanelAdminPagos () {
		// CONSTRUCTOR
	}
	
	public void setPagos (PagosBean pagos) {
		// spring
		this.pagos=pagos;
	}
	
	public void setNewPago (FormaPago newPago) {
		//spring
		this.newPago=newPago;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	
	/**
	 * Método que suministra el panel de formas de pago con sus componentes.
	 * 
	 * @return - un JPanel componiendo la pantalla de formas de pago
	 */
	
	public JPanel panelPrincipal(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,410));
		marcoAux1.setPreferredSize(new Dimension(650,410));
		marcoAux1.setMaximumSize(new Dimension(650,410));
		
		// titulo
		JLabel title=new JLabel("FORMAS DE PAGO");
		title.setFont(font1);
		// creamos el formulario
		JLabel selection=new JLabel("Elija: ");
		selection.setFont(font2);
		selection.setForeground(colorL);
		selPago=new JComboBox<String>();
		selPago.addItem("Seleccione...");
		//pagos=new PagosBean();
		if ((allPagos=pagos.getListPago())==null) {
			allPagos.add(new String[5]);
		}
		for (String[] data: allPagos) {
			selPago.addItem(data[1]);
		}
		
		JLabel name=new JLabel("Nombre del pago ");
		name.setFont(font2);
		name.setForeground(colorL);
		namePago=new JTextField("");
		namePago.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		JLabel tipo=new JLabel("Texto del Pago");
		tipo.setFont(font2);
		tipo.setForeground(colorL);
		textoPago=new JTextField("");
		textoPago.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		JLabel dias=new JLabel("Días de plazo:");
		dias.setFont(font2);
		dias.setForeground(colorL);
		diasPago=new JTextField("");
		diasPago.setToolTipText("OBLIGATORIO: numérico entre 0 y 999");
		JLabel fecha=new JLabel("Día de Pago:");
		fecha.setFont(font2);
		fecha.setForeground(colorL);
		fechaPago=new JTextField("");
		fechaPago.setToolTipText("OPCIONAL: día de pago");
	
		// preparamos los botones 
		grabarP=new JButton("Grabar pago");
		grabarP.setToolTipText("pulse para grabar los datos");
		borrarP=new JButton("Borrar pago");
		borrarP.setEnabled(false);
		borrarP.setToolTipText("pulse para eliminar los datos");
		ImageIcon icon = new ImageIcon("src/images/info.png");
		infoP=new JButton(icon);
		infoP.setBorderPainted(true);
		infoP.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		infoP.setMargin(m);
		infoP.setToolTipText("pulse para información");
		infoP.setActionCommand("info");
		JPanel panelButton1=new JPanel();
		panelButton1.setLayout(new FlowLayout());
		panelButton1.add(grabarP);
		panelButton1.add(new JLabel());
		JPanel panelButton2=new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(new JLabel());
		panelButton2.add(borrarP);
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		panelButton3.add(infoP);
		Dimension dimP=new Dimension(60,50);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);


		// añadimos todos los elementos a los JPanel auxiliares
		marcoAux0.add(title);
		marcoAux1.setLayout(new GridLayout(12,4));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(panelButton3);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(selection);
		marcoAux1.add(selPago);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name);
		marcoAux1.add(namePago);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(tipo);
		marcoAux1.add(textoPago);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(dias);
		marcoAux1.add(diasPago);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(fecha);
		marcoAux1.add(fechaPago);
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
	
		marcoAux1.add(new JLabel("  "));
		marcoAux1.add(panelButton1);
		marcoAux1.add(panelButton2);
		marcoAux1.add(new JLabel("  "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0,BorderLayout.NORTH);
		marco2.add(marcoAux1,BorderLayout.CENTER);
		marco2.add(new JLabel("  "),BorderLayout.EAST);
		marco2.add(new JLabel("  "),BorderLayout.WEST);
		marco2.add(new JLabel("       "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		selPago.addItemListener(this);
		borrarP.addActionListener(this);
		grabarP.addActionListener(this);
		infoP.addActionListener(this);
		
		return marco2;
				
	} // end of method pagoPanel
	
	
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
		title.add(new JLabel("AYUDA EN FORMAS DE PAGO"));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea("- En el panel de formas de pago puede introducir los datos\n" +
				"correspondientes a las distintas formas de pago de los clientes.\n\n" +
				"1.- En nombre debe introducir el nombre con el cual se identi-\n" +
				"ficará esta forma de pago.\n" +
				"2.- En texto debe introducir el texto que figurará en la factura\n" +
				"cuando se imprima.\n" +
				"3.- En días de plazo (opcional) puede introducir los días de \n" +
				"aplazamiento del pago de la factura, desde la fecha de creación.\n" +
				"4.- En el campo día de pago (opcional) puede introducir el día\n" +
				"en el cual el cliente abona la factura, teniendo en cuenta los\n" +
				"días de pago, si es que los tiene.\n\n" +
				"El control de días de plazo y de día de pago no funciona en la\n" +
				"versión 1.1 de la aplicación.\n\n" +
				"- Para modificar una forma de pago, deberá seleccionar la forma de\n" +
				"pago, efectuar los cambios deseados y luego pulsar en grabar.\n" +
				"- Para borrar una forma de pago, deberá seleccionar la forma de\n" +
				"pago y luego pulsar en borrar para eliminar la forma.\n\n" +
				"Borrar una forma de pago que ha sido utilizada en facturas\n" +
				"afectará a la impresión de esas factura. Procure borrar formas\n" +
				"de pago que sepa que no han sido utilizadas y/o cree otras si\n" +
				"lo considera necesario.");
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
		
		if (selPago!=null && selPago.getSelectedIndex()>0) {
			idPago=allPagos.get(selPago.getSelectedIndex()-1)[0];
			namePago.setText(allPagos.get(selPago.getSelectedIndex()-1)[1]);
			textoPago.setText(allPagos.get(selPago.getSelectedIndex()-1)[2]);
			diasPago.setText(allPagos.get(selPago.getSelectedIndex()-1)[3]);
			fechaPago.setText(allPagos.get(selPago.getSelectedIndex()-1)[4]);
			borrarP.setEnabled(true);
		} else if (selPago!=null && selPago.getSelectedIndex()==0) {
			idPago="0";
			namePago.setText("");
			textoPago.setText("");
			diasPago.setText("");
			fechaPago.setText("");
			borrarP.setEnabled(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		//**** LECTURA DE BOTONES DE PAGO
		
		if (source.equals("Grabar pago") && selPago.getSelectedIndex()==0 ) {
			//FormaPago newPago=new FormaPago();
			
			newPago.setNamePago(namePago.getText().trim());
			newPago.setTextoPago(textoPago.getText().trim());
			newPago.setDiasPago(diasPago.getText().trim());
			newPago.setFechaPago(fechaPago.getText().trim());

			if (pagos.createPago(newPago)) {
				// muestra mensaje y actualiza las pestañas
				JOptionPane.showMessageDialog(mainFrame, "La forma de pago ha sido grabada correctamente", "Grabación de Formas de pago", JOptionPane.INFORMATION_MESSAGE);
				reinicia.reinicia(1,3);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en la grabación de la forma de pago", "Grabación de Formas de pago", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (source.equals("Grabar pago") && selPago.getSelectedIndex()>0 ) {
			
			//FormaPago newPago=new FormaPago();
			idPago=allPagos.get(selPago.getSelectedIndex()-1)[0];
			try {
				newPago.setIdPago((long)Long.parseLong(idPago));
			} catch (NumberFormatException nf) {
				newPago.setIdPago(0);
			}			
			
			newPago.setNamePago(namePago.getText().trim());
			newPago.setTextoPago(textoPago.getText().trim());
			newPago.setDiasPago(diasPago.getText().trim());
			newPago.setFechaPago(fechaPago.getText().trim());

			if (pagos.modifyPago(idPago, newPago)) {
				// muestra mensaje y actualiza las pestañas
				JOptionPane.showMessageDialog(mainFrame, "La forma de pago ha sido modificada correctamente", "Modificación de Formas de pago", JOptionPane.INFORMATION_MESSAGE);
				reinicia.reinicia(1,3);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en la modificación de Formas de pago", "Modificación de Formas de pago", JOptionPane.ERROR_MESSAGE);
			}
		}		
		
		if (source.equals("Borrar pago")) {
			
			idPago=allPagos.get(selPago.getSelectedIndex()-1)[0];

			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar esta forma de pago?", "Borrado de Formas de pago", JOptionPane.YES_NO_OPTION)==0) {
				if (pagos.erasePago(idPago)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "La forma de pago ha sido borrado correctamente", "Borrado de Formas de pago", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,3);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en el borrado de la forma de pago", "Borrado de Formas de pago", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}

} // ************* END OF CLASS
