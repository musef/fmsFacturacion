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

import beansControls.TiposIvaBean;
import beansModels.TiposIva;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class PanelAdminIvas implements ActionListener, ItemListener {
	
	private JFrame mainFrame;
	private JPanel marco2;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	// IVA
	private JComboBox<String> selIva;
	private JTextField nameIva;
	private JTextField tipoIva;
	private JComboBox<String> claseIva;
	private JComboBox<String> destIva;
	private JCheckBox activoIva;
	private JButton grabar;
	private JButton borrar;
	private JButton info;
	
	// SPRING
	private TiposIvaBean ivas;
	private TiposIva newIva;
	private EnterSandMan reinicia;
	
	private List<String[]> allIva;
	private String idIva;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;

	

	public PanelAdminIvas () {
		// CONSTRUCTOR
		
	}
	
	
	public void setIvas (TiposIvaBean iva) {
		// spring
		this.ivas=iva;
	}
	
	public void setNewIva (TiposIva newIva) {
		// spring
		this.newIva=newIva;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	
	/**
	 * Método que suministra el panel del Iva con sus componentes.
	 * 
	 * @return - un JPanel componiendo la pantalla del IVA
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
		JLabel title=new JLabel("MANTENIMIENTO DE IVA");
		title.setFont(font1);
		// creamos el formulario
		JLabel selection=new JLabel("Elija: ");
		selection.setFont(font2);
		selection.setForeground(colorL);
		selIva=new JComboBox<String>();
		selIva.addItem("Seleccione...");
		//ivas=new TiposIvaBean();
		if ((allIva=ivas.getListIva())==null) {
			allIva.add(new String[7]);
		}
		for (String[] data: allIva) {
			selIva.addItem(data[2]);
		}
		
		JLabel name=new JLabel("Concepto de IVA ");
		name.setFont(font2);
		name.setForeground(colorL);
		nameIva=new JTextField("");
		nameIva.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		JLabel tipo=new JLabel("Tipo de IVA");
		tipo.setFont(font2);
		tipo.setForeground(colorL);
		tipoIva=new JTextField("");
		tipoIva.setToolTipText("OBLIGATORIO, solo números: entre 0,00 y 99,99");
		JLabel dest=new JLabel("Elija:");
		dest.setFont(font2);
		dest.setForeground(colorL);
		destIva=new JComboBox<String>();
		destIva.addItem("Ventas");
		//destIva.addItem("Compras");
		JLabel clase=new JLabel("Elija:");
		clase.setFont(font2);
		clase.setForeground(colorL);
		claseIva=new JComboBox<String>();
		claseIva.addItem("Exento");
		claseIva.addItem("Superreducido");
		claseIva.addItem("Reducido");
		claseIva.addItem("General");
		JLabel activo=new JLabel("Activo");
		activo.setFont(font2);
		activo.setForeground(colorL);
		activoIva=new JCheckBox();
		activoIva.setSelected(false);

	
		// preparamos los botones y deshabilitamos los botones cambiar y cancelar
		// porque inicialmente no son operativos hasta seleccionar cuenta
		grabar=new JButton("Grabar");
		grabar.setToolTipText("pulse para grabar los datos");
		borrar=new JButton("Borrar");
		borrar.setEnabled(false);
		borrar.setToolTipText("pulse para eliminar los datos");
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
		marcoAux1.add(selIva);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name);
		marcoAux1.add(nameIva);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(tipo);
		marcoAux1.add(tipoIva);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(dest);
		marcoAux1.add(destIva);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(clase);
		marcoAux1.add(claseIva);
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(activo);
		marcoAux1.add(activoIva);
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
		selIva.addItemListener(this);
		borrar.addActionListener(this);
		grabar.addActionListener(this);
		info.addActionListener(this);
		
		return marco2;
		
	} // end of method ivaPanel

	
	
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
		title.add(new JLabel("AYUDA EN MANTENIMIENTO I.V.A."));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea("En el panel de mantenimiento de IVA podrán darse de alta, de baja \n" +
				"o modificarse distintos tipos de IVA. \n" +
				"En esta versión (1.1) solo es posible dar de alta IVA de clientes.\n\n" +
				"1.- En concepto de IVA debe introducirse el texto que sirva para  \n" +
				"identificar cada tipo de IVA.\n" +
				"2.- En tipo de IVA debe introducir el tipo (porcentaje) de IVA \n" +
				"que corresponda, en formato xx.xx (p.ejem. 10.00) y sin %.\n" +
				"3.- Solamente existe IVA de clientes en esta versión.\n" +
				"4.- Elija luego a que clase pertenece el IVA correspondiente. Las\n" +
				"clases de IVA existentes serán exento, superreducido, reducido y\n" +
				"general. Procure no duplicar IVAS distintos declarados de la misma\n" +
				"clase, porque solo funcionará uno de ellos.\n"+ 
				"5.- En la casilla activo puede activar o desactivar el IVA para que\n" +
				"aparezca o no en las opciones de selección. Es preferible desactivar\n" +
				"un tipo de IVA ya utilizado, antes que borrarlo.\n\n" +
				"Para modificar un IVA, solamente debe seleccionar el IVA que va\n" +
				"a modificar, cambiar los datos que desee, y pulsar en grabar.\n\n" +
				"Para borrar un IVA, solamente debe seleccionar el IVA que desea\n" +
				"eliminar, y pulsar el botón borrar.Al borrar el IVA, si tiene \n" +
				"grabaciones de albaranes o facturas con ese tipo de IVA, las fac-\n" +
				"turas no perderán los datos, pero pueden aparecer problemas con \n" +
				"los albaranes pendientes.");
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
		
		if (selIva!=null && selIva.getSelectedIndex()>0) {
			idIva=allIva.get(selIva.getSelectedIndex()-1)[0];
			activoIva.setSelected(false);
			if (allIva.get(selIva.getSelectedIndex()-1)[1].equals("1")) {
				activoIva.setSelected(true);
			}
			nameIva.setText(allIva.get(selIva.getSelectedIndex()-1)[2]);
			tipoIva.setText(allIva.get(selIva.getSelectedIndex()-1)[3]);
			destIva.setSelectedIndex((int)Integer.parseInt(allIva.get(selIva.getSelectedIndex()-1)[4])-1);
			claseIva.setSelectedIndex((int)Integer.parseInt(allIva.get(selIva.getSelectedIndex()-1)[5]));
			borrar.setEnabled(true);
		} else if (selIva!=null && selIva.getSelectedIndex()==0) {
			idIva="0";
			nameIva.setText("");
			tipoIva.setText("");
			activoIva.setSelected(false);
			borrar.setEnabled(false);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		//**** LECTURA DE BOTONES DE IVA
		
		if (source.equals("Grabar") && selIva.getSelectedIndex()==0 ) {
			// GRABAR UN NUEVO IVA
			
			//TiposIva newIva=new TiposIva();
			newIva.setActiveIva(1);
			newIva.setNameIva(nameIva.getText().trim());
			newIva.setRateIva((double)Double.parseDouble(tipoIva.getText().trim()));
			
			if (destIva.getSelectedIndex()==0) {
				newIva.setTypeIva(1);
			} else {
				newIva.setTypeIva(2);
			}
			
			newIva.setActiveIva(0);
			if (activoIva.isSelected()) {
				newIva.setActiveIva(1);
			}
			
			newIva.setClassIva(claseIva.getSelectedIndex());
			newIva.setAccIva("");
			if (ivas.createIva(newIva)) {
				// muestra mensaje y actualiza las pestañas
				JOptionPane.showMessageDialog(mainFrame, "El iva ha sido grabado correctamente", "Grabación de IVA", JOptionPane.INFORMATION_MESSAGE);
				reinicia.reinicia(1,2);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en la grabación del iva", "Grabación de IVA", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (source.equals("Grabar") && selIva.getSelectedIndex()>0 ) {
			// MODIFICAR UN IVA
			
			//TiposIva newIva=new TiposIva();
			idIva=allIva.get(selIva.getSelectedIndex()-1)[0];
			try {
				newIva.setIdIva((long)Long.parseLong(idIva));
			} catch (NumberFormatException nf) {
				newIva.setIdIva(0);
			}			
			
			newIva.setActiveIva(0);
			if (activoIva.isSelected()) {
				newIva.setActiveIva(1);
			}
			
			newIva.setNameIva(nameIva.getText().trim());
			newIva.setRateIva((double)Double.parseDouble(tipoIva.getText().trim()));
			
			if (destIva.getSelectedIndex()==0) {
				newIva.setTypeIva(1);
			} else {
				newIva.setTypeIva(2);
			}
			
			newIva.setClassIva(claseIva.getSelectedIndex());
			newIva.setAccIva("");
			if (ivas.modifyIva(idIva, newIva)) {
				// muestra mensaje y actualiza las pestañas
				JOptionPane.showMessageDialog(mainFrame, "El iva ha sido modificado correctamente", "Modificación de IVA", JOptionPane.INFORMATION_MESSAGE);
				reinicia.reinicia(1,2);
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en la modificación del iva", "Modificación de IVA", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		if (source.equals("Borrar")) {
			
			idIva=allIva.get(selIva.getSelectedIndex()-1)[0];

			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar esta cuenta de IVA?", "Borrado de IVA", JOptionPane.YES_NO_OPTION)==0) {
				if (ivas.eraseIva(idIva)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "El iva ha sido borrado correctamente", "Borrado de IVA", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,2);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en el borrado del iva", "Borrado de IVA", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}
	
	
} // ******* END OF CLASS


