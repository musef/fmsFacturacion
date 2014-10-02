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

import beansControls.TiposIrpfBean;
import beansModels.TiposIrpf;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class PanelAdminIrpf implements ActionListener, ItemListener {

	private JFrame mainFrame;
	private JPanel marco2;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	// IVA
	private JComboBox<String> selIrpf;
	private JTextField nameIrpf;
	private JTextField tipoIrpf;
	private JCheckBox activoIrpf;
	private JComboBox<String> destIrpf;
	private JButton grabar;
	private JButton borrar;
	private JButton info;
	
	// SPRING
	private TiposIrpfBean irpf;
	private TiposIrpf newIrpf;
	private EnterSandMan reinicia;
	
	private List<String[]> allIrpf;
	private String idIrpf;
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	
	
	
	public PanelAdminIrpf() {
		// CONSTRUCTOR
	}
	
	
	
	public void setTiposIrpfBean (TiposIrpfBean irpf) {
		// spring
		this.irpf=irpf;
	}
	
	public void setTiposIrpf (TiposIrpf newIrpf) {
		// spring
		this.newIrpf=newIrpf;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	 
	
	public JPanel panelPrincipal (JFrame mainFrame) {

		this.mainFrame=mainFrame;
		
		marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,410));
		marcoAux1.setPreferredSize(new Dimension(650,410));
		marcoAux1.setMaximumSize(new Dimension(650,410));
		
		// titulo
		JLabel title=new JLabel("MANTENIMIENTO DE IRPF");
		title.setFont(font1);
		// creamos el formulario
		JLabel selection=new JLabel("Elija: ");
		selection.setFont(font2);
		selection.setForeground(colorL);
		selIrpf=new JComboBox<String>();
		selIrpf.addItem("Seleccione...");
		//irpf=new TiposIrpfBean();
		if ((allIrpf=irpf.getListIrpf())==null) {
			allIrpf=new ArrayList<String[]>();
		}
		for (String[] data: allIrpf) {
			selIrpf.addItem(data[2]);
		}
		
		JLabel name=new JLabel("Concepto de IRPF ");
		name.setFont(font2);
		name.setForeground(colorL);
		nameIrpf=new JTextField("");
		nameIrpf.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		JLabel tipo=new JLabel("Tipo de IRPF");
		tipo.setFont(font2);
		tipo.setForeground(colorL);
		tipoIrpf=new JTextField("");
		tipoIrpf.setToolTipText("OBLIGATORIO, solo números: entre 0,00 y 99,99");
		JLabel activo=new JLabel("Activo");
		activo.setFont(font2);
		activo.setForeground(colorL);
		activoIrpf=new JCheckBox();
		activoIrpf.setSelected(false);
		JLabel dest=new JLabel("Elija:");
		dest.setFont(font2);
		dest.setForeground(colorL);
		destIrpf=new JComboBox<String>();
		destIrpf.addItem("Ventas");
		//destIrpf.addItem("Compras");

	
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
		marcoAux1.add(selIrpf);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name);
		marcoAux1.add(nameIrpf);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(tipo);
		marcoAux1.add(tipoIrpf);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(dest);
		marcoAux1.add(destIrpf);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(activo);
		marcoAux1.add(activoIrpf);
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
		selIrpf.addItemListener(this);
		borrar.addActionListener(this);
		grabar.addActionListener(this);
		info.addActionListener(this);
		
		return marco2;		
		
	} // END OF METHOD PANELPRINCIPAL
	
	
	
	/**
	 * Este metodo chequea el formulario y devuelve un false algun campo esta erroneo y faltan datos
	 * para rellenar. A su vez, resalta en rojo el campo erroneo.
	 * @return Boolean, TRUE o FALSE según el formulario esté correcto o contenga errores.
	 */
	
	private boolean checkForm() {
			
	
		boolean result=true;
		
		nameIrpf.setBackground(OKFORM);
		tipoIrpf.setBackground(OKFORM);
		
		if (nameIrpf.getText().trim().length()<3 || nameIrpf.getText().trim().length()>50) {
			nameIrpf.setBackground(ERRORFORM);
			result=false;
		}
		
		if (tipoIrpf.getText().trim().length()>6) {
			tipoIrpf.setBackground(ERRORFORM);
			result=false;
		}
		
		if (tipoIrpf.getText().trim().isEmpty()) {
			tipoIrpf.setBackground(ERRORFORM);
			result=false;
		}
		
		
		@SuppressWarnings("unused")
		double numberF=0;
		try {
			numberF=(double)Double.parseDouble(tipoIrpf.getText().trim());
		} catch (NumberFormatException nf) {
			tipoIrpf.setBackground(ERRORFORM);
			result=false;
		}

		return result;
	}  // end of checkForm
	
	
	
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
		title.add(new JLabel("AYUDA DE MANTENIMIENTO DE IRPF"));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea("- En el panel de mantenimiento IRPF puede introducir los datos\n" +
				"correspondientes a las distintas IRPFs a incluir en las facturas\n" +
				"a los clientes.\n" +
				"En la versión 1.1 solo existe IRPF para clientes, es decir, las.\n" +
				"retenciones por IRPF que soporta en sus facturas, si es que ud. \n" +
				"es profesional obligado a soportar retención.\n\n" +
				"1.- En concepto debe introducir el texto con el que identificará\n" +
				"la retención en la aplicación.\n" +
				"2.- En tipo de IRPF debe introducir el tipo (porcentaje) de IRPF \n" +
				"que corresponda, en formato xx.xx (p.ejem. 10.00) y sin %.\n" +
				"3.- Solamente existe IRPF de clientes en esta versión.\n" +
				"4.- Clickee en la casilla 'activo' para indicar a la aplicación\n" +
				"cual de los IRPF de clientes es el que actualmente es válido.\n" +
				"Si introduce varios IRPF activos, la aplicación tomará el último.\n\n" +
				"- Para modificar un IRPF, deberá seleccionarlo, efectuar los\n" +
				"cambios deseados y luego pulsar en grabar.\n" +
				"- Para borrar un IRPF, deberá seleccionarlo y luego pulsar borrar.\n" +
				"Si borra el IRPF activo, y sus facturas son con retención (activado\n" +
				"en el menú de empresas), al facturar se producirá un error.");
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
		if (selIrpf!=null && selIrpf.getSelectedIndex()>0) {
			idIrpf=allIrpf.get(selIrpf.getSelectedIndex()-1)[0];
			nameIrpf.setText(allIrpf.get(selIrpf.getSelectedIndex()-1)[2]);
			tipoIrpf.setText(allIrpf.get(selIrpf.getSelectedIndex()-1)[3]);
			if (allIrpf.get(selIrpf.getSelectedIndex()-1)[1].equals("1")) {
				activoIrpf.setSelected(true);
			}
			destIrpf.setSelectedIndex((int)Integer.parseInt(allIrpf.get(selIrpf.getSelectedIndex()-1)[4])-1);
			borrar.setEnabled(true);
		} else if (selIrpf!=null && selIrpf.getSelectedIndex()==0) {
			idIrpf="0";
			nameIrpf.setText("");
			tipoIrpf.setText("");
			activoIrpf.setSelected(false);
			borrar.setEnabled(false);
		}
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		//**** LECTURA DE BOTONES DE IRPF
		
		if (source.equals("Grabar") && selIrpf.getSelectedIndex()==0 ) {
			
			if (checkForm()) {
				//TiposIrpf newIrpf=new TiposIrpf();
				if (activoIrpf.isSelected()) {
					newIrpf.setActiveIrpf(1);
				} else {
					newIrpf.setActiveIrpf(0);
				}
				newIrpf.setNameIrpf(nameIrpf.getText().trim());
				
				try {
					newIrpf.setRateIrpf((double)Double.parseDouble(tipoIrpf.getText().trim()));
				} catch (NumberFormatException nf) {
					newIrpf.setRateIrpf(0);
				}
				
				if (destIrpf.getSelectedIndex()==0) {
					newIrpf.setTypeIrpf(1);
				} else {
					newIrpf.setTypeIrpf(2);
				}
				
				newIrpf.setAccIrpf("");
				if (irpf.createIrpf(newIrpf)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "El irpf ha sido grabado correctamente", "Grabación de IRPF", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,4);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en la grabación del irpf", "Grabación de IRPF", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Faltan datos necesarios para crear el irpf\n" +
						"o hay datos incorrectos en el formulario.", "Grabación de IRPF", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (source.equals("Grabar") && selIrpf.getSelectedIndex()>0 ) {
			if (checkForm()) {
				//TiposIrpf newIrpf=new TiposIrpf();
				idIrpf=allIrpf.get(selIrpf.getSelectedIndex()-1)[0];
				try {
					newIrpf.setId((long)Long.parseLong(idIrpf));
				} catch (NumberFormatException nf) {
					newIrpf.setId(0);
				}			
				if (activoIrpf.isSelected()) {
					newIrpf.setActiveIrpf(1);
				} else {
					newIrpf.setActiveIrpf(0);
				}
				
				newIrpf.setNameIrpf(nameIrpf.getText().trim());
				try {
					newIrpf.setRateIrpf((double)Double.parseDouble(tipoIrpf.getText().trim()));
				} catch (NumberFormatException nf) {
					newIrpf.setRateIrpf(0);
				}
				
				if (destIrpf.getSelectedIndex()==0) {
					newIrpf.setTypeIrpf(1);
				} else {
					newIrpf.setTypeIrpf(2);
				}
				
				newIrpf.setAccIrpf("");
				if (irpf.modifyIrpf(idIrpf, newIrpf)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "El irpf ha sido modificado correctamente", "Modificación de IRPF", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,4);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en la modificación del irpf", "Modificación de IRPF", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Faltan datos necesarios para modificar el irpf\n" +
						"o hay datos incorrectos en el formulario.", "Modificación de IRPF", JOptionPane.ERROR_MESSAGE);
			}

		}
		
		
		if (source.equals("Borrar")) {
			
			idIrpf=allIrpf.get(selIrpf.getSelectedIndex()-1)[0];

			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar esta cuenta de Irpf?", "Borrado de IRPF", JOptionPane.YES_NO_OPTION)==0) {
				if (irpf.eraseIrpf(idIrpf)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "El Irpf ha sido borrado correctamente", "Borrado de IRPF", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,4);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en el borrado del Irpf", "Borrado de IRPF", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}

}
