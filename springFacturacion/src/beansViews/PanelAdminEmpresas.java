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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import main.SpringFacturacion;

import beansModels.DatosEmpresa;
import beansControls.EmpresaBean;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */


public class PanelAdminEmpresas implements ActionListener {

	private JFrame mainFrame;
	
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	
	private JTextField nameF;
	private JTextField nameF2;
	private JTextField addressF;
	private JTextField codeF;
	private JTextField cityF;
	private JTextField nifF;
	private JTextField textoF;
	private JTextField serieF;
	private JTextField numeroF;
	private JCheckBox retencF;
	
	private JButton grabarE;
	private JButton borrarE;
	private JButton infoE;
	
	// SPRING
	private DatosEmpresa newEmpresa;
	private EmpresaBean empresa;
	private EnterSandMan reinicia;
	
	private List<String[]> allEmpresas;
	private final int NUMBERCOMPANY=0;
	private String idEmpresa;
	
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private Font font2=new Font("SansSerif", Font.BOLD, 16);
	private Color colorL=Color.BLACK;
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	
	
	
	public PanelAdminEmpresas() {
		// CONSTRUCTOR
		
	}
	
	
	public void setEmpresa (EmpresaBean empresa) {
		//spring
		this.empresa=empresa;
	}
	
	public void setNewEmpresa (DatosEmpresa newEmpresa) {
		//spring
		this.newEmpresa=newEmpresa;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	
	/**
	 * Método que suministra el panel de la empresa con sus componentes.
	 * 
	 * @return - un JPanel componiendo la pantalla de datos de empresa
	 */
	
	public JPanel panelPrincipal(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(650,410));
		marcoAux1.setPreferredSize(new Dimension(650,410));
		marcoAux1.setMaximumSize(new Dimension(650,410));
		
		//empresa=new EmpresaBean();
		if ((allEmpresas=empresa.getListEmpresa())==null) {
			allEmpresas.add(new String[11]);
		}
		

		// titulo
		JLabel title=new JLabel("DATOS DE EMPRESA");
		title.setFont(font1);
		// creamos el formulario
		JLabel name=new JLabel("Nombre de empresa");
		name.setFont(font2);
		name.setForeground(colorL);
		nameF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[1]);
		nameF.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		
		JLabel name2=new JLabel("Nombre comercial ");
		name2.setFont(font2);
		name2.setForeground(colorL);
		nameF2=new JTextField(allEmpresas.get(NUMBERCOMPANY)[2]);
		nameF2.setToolTipText("máximo 50 caracteres");
		
		JLabel address=new JLabel("Dirección");
		address.setFont(font2);
		address.setForeground(colorL);
		addressF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[3]);
		addressF.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		
		JLabel code=new JLabel("Código postal");
		code.setFont(font2);
		code.setForeground(colorL);
		codeF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[4]);
		codeF.setToolTipText("OBLIGATORIO: 5 caracteres");
		
		JLabel city=new JLabel("Localidad");
		city.setFont(font2);
		city.setForeground(colorL);
		cityF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[5]);
		cityF.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		
		JLabel nif=new JLabel("N.I.F.");
		nif.setFont(font2);
		nif.setForeground(colorL);
		nifF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[6]);
		nifF.setToolTipText("OBLIGATORIO: 9 caracteres");

		JLabel texto=new JLabel("Texto");
		texto.setFont(font2);
		texto.setForeground(colorL);
		textoF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[7]);
		textoF.setToolTipText("máximo 200 caracteres");
		
		JLabel serie=new JLabel("Serie facturación");
		serie.setFont(font2);
		serie.setForeground(colorL);
		serieF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[8]);
		serieF.setToolTipText("máximo 8 caracteres");
		
		JLabel numero=new JLabel("Último nº factura");
		numero.setFont(font2);
		numero.setForeground(colorL);
		numeroF=new JTextField(allEmpresas.get(NUMBERCOMPANY)[9]);
		numeroF.setToolTipText("Entre 0 y 999999");
		
		JLabel retenc=new JLabel("Retención");
		retenc.setFont(font2);
		retenc.setForeground(colorL);
		retencF=new JCheckBox();
		if (allEmpresas.get(NUMBERCOMPANY)[10].equals("1")) {
			retencF.setSelected(true);
		}
		retencF.setToolTipText("Marque la casilla si sus facturas llevan retención");
		
		// preparamos los botones 
		grabarE=new JButton("Grabar empresa");
		grabarE.setToolTipText("pulse para grabar los datos");
		borrarE=new JButton("Borrar empresa");
		borrarE.setToolTipText("pulse para eliminar los datos");
		borrarE.setEnabled(false);
		ImageIcon icon = new ImageIcon("src/images/info.png");
		infoE=new JButton(icon);
		infoE.setBorderPainted(true);
		infoE.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		infoE.setMargin(m);
		infoE.setToolTipText("pulse para información");
		infoE.setActionCommand("info");
		JPanel panelButton1=new JPanel();
		panelButton1.setLayout(new FlowLayout());
		panelButton1.add(grabarE);
		panelButton1.add(new JLabel());
		JPanel panelButton2=new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(new JLabel());
		panelButton2.add(borrarE);
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		panelButton3.add(infoE);
		Dimension dimP=new Dimension(60,50);
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
		marcoAux1.add(name);
		marcoAux1.add(nameF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(name2);
		marcoAux1.add(nameF2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(address);
		marcoAux1.add(addressF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(code);
		marcoAux1.add(codeF);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(city);
		marcoAux1.add(cityF);
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(nif);
		marcoAux1.add(nifF);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(texto);
		marcoAux1.add(textoF);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(serie);
		marcoAux1.add(serieF);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(numero);
		marcoAux1.add(numeroF);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(retenc);
		marcoAux1.add(retencF);
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
	
		marcoAux1.add(new JLabel("  "));
		marcoAux1.add(panelButton1);
		marcoAux1.add(panelButton2);
		marcoAux1.add(new JLabel("  "));
		
		
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
		borrarE.addActionListener(this);
		grabarE.addActionListener(this);
		infoE.addActionListener(this);
		
		return marco2;
				
	} // end of method makeEmpresa
	
	
	/**
	 * Este metodo chequea el formulario y devuelve un false algun campo esta erroneo y faltan datos
	 * para rellenar. A su vez, resalta en rojo el campo erroneo.
	 * @return
	 */
	
	private boolean checkForm() {
	
		boolean result=true;
		
		nameF.setBackground(OKFORM);
		nameF2.setBackground(OKFORM);
		addressF.setBackground(OKFORM);
		cityF.setBackground(OKFORM);
		codeF.setBackground(OKFORM);
		nifF.setBackground(OKFORM);
		textoF.setBackground(OKFORM);
		serieF.setBackground(OKFORM);
		numeroF.setBackground(OKFORM);
		
		if (nameF.getText().trim().length()<3 || nameF.getText().trim().length()>50) {
			nameF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (nameF2.getText().trim().length()>50) {
			nameF2.setBackground(ERRORFORM);
			result=false;
		}
		
		if (addressF.getText().trim().length()<3 || addressF.getText().trim().length()>50) {
			addressF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (codeF.getText().trim().length()!=5) {
			addressF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (cityF.getText().trim().length()<3 || cityF.getText().trim().length()>50) {
			cityF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (nifF.getText().trim().length()!=9) {
			nifF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (textoF.getText().trim().length()>200) {
			textoF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (serieF.getText().trim().length()>8) {
			serieF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (numeroF.getText().trim().length()>6) {
			numeroF.setBackground(ERRORFORM);
			result=false;
		}
		
		if (numeroF.getText().trim().isEmpty()) {
			numeroF.setText("0");
		}
		@SuppressWarnings("unused")
		long numberF=0;
		try {
			numberF=(long)Long.parseLong(numeroF.getText().trim());
		} catch (NumberFormatException nf) {
			numeroF.setBackground(ERRORFORM);
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
		title.add(new JLabel("AYUDA DE CREACIÓN EMPRESA"));
		
		JPanel panelText=new JPanel();
		panelText.setBackground(title.getBackground());
		JTextArea hText=new JTextArea("En el panel de datos de empresa deberán introducirse los datos \n" +
				"correspondientes a la empresa que realiza las facturaciones. \n" +
				"En esta versión (1.1) solo es posible dar de alta una sola empresa.\n\n" +
				"1.- En nombre de empresa debe introducir el nombre o razón social \n" +
				"de la empresa que factura.\n" +
				"2.- En nombre comercial (opcional) puede introducir la marca o \n" +
				"nombre comercial de su empresa.\n" +
				"3.- Introduzca los demás datos de la empresa, poniendo cuidado en\n" +
				"respetar las longitudes máximas y mínimas de los campos.\n" +
				"4.- El campo 'Texto' recogerá los datos de la inscripción de la\n" +
				"empresa en el Registro Mercantil, si es su caso.\n" +
				"5.- Si desea tener una serie de facturación, rellene el campo co-\n" +
				"rrespondiente. Deberá cambiarlo manualmente durante la factura-\n" +
				"ción si desea tener más de una serie.\n" +
				"6.- Último nº de factura registra el último número facturado, al\n" +
				"cerrar la aplicación. Puede modificar manualmente este dato, el\n" +
				"cual surtirá efecto al cerrar y abrir la aplicación de nuevo.\n" +
				"7.- Si ud. es profesional y soporta retención en sus facturas,\n" +
				"deberá marcar la casilla 'retención', y dar de alta la retención\n" +
				"en el menú 'IRPF'.");
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
	public void actionPerformed(ActionEvent e) {
		
		//**** LECTURA DE BOTONES DE EMPRESA
		
		String source=e.getActionCommand();
		
		if (source.equals("Grabar empresa")) {
			
			if (checkForm()) {
				//DatosEmpresa newEmpresa=new DatosEmpresa();
				
				newEmpresa.setNombreEmpresa(nameF.getText().trim());
				newEmpresa.setNombreComercial(nameF2.getText().trim());
				newEmpresa.setDireccion(addressF.getText().trim());
				newEmpresa.setCpostal(codeF.getText().trim());
				newEmpresa.setLocalidad(cityF.getText().trim());
				newEmpresa.setNif(nifF.getText().trim());
				newEmpresa.setTexto(textoF.getText().trim());
				newEmpresa.setSerieFact(serieF.getText().trim());
				if (retencF.isSelected()) {
					newEmpresa.setRetencion(1);
				} else {
					newEmpresa.setRetencion(0);
				}
				
				long num=0;
				try {
					num=(long)Long.parseLong(numeroF.getText().trim());
				} catch (NumberFormatException nf) {
					num=0;
				}
				newEmpresa.setUltimoNumero(num);
				
				// pensado para una sola empresa !!!
				int companySelected=0;
				
				if (allEmpresas.get(companySelected)[0]!=null) {
					if (allEmpresas.get(companySelected)[0].equals("")) {
						// Es creacion de empresa
						if (empresa.createEmpresa(newEmpresa)) {
							// muestra mensaje y actualiza las pestañas
							JOptionPane.showMessageDialog(mainFrame, "Los datos de empresa han sido grabados correctamente", "Grabación de datos Empresa", JOptionPane.INFORMATION_MESSAGE);
							reinicia.reinicia(1,1);
							SpringFacturacion.lastInvoiceNumber=newEmpresa.getUltimoNumero();
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error en la grabación de datos de empresa", "Grabación de datos Empresa", JOptionPane.ERROR_MESSAGE);
						}
					} else	if (empresa.modifyEmpresa(allEmpresas.get(companySelected)[0], newEmpresa)) {
							//Es modificacion de datos
						// muestra mensaje y actualiza las pestañas
							JOptionPane.showMessageDialog(mainFrame, "Los datos de empresa han sido grabados correctamente", "Grabación de datos Empresa", JOptionPane.INFORMATION_MESSAGE);
							reinicia.reinicia(1,1);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error en la grabación de datos de empresa", "Grabación de datos Empresa", JOptionPane.ERROR_MESSAGE);
						}
					
				}
			}
		}		// end of grabar empresa
		
		
		if (source.equals("Borrar empresa")) {
			
			idEmpresa=allEmpresas.get(0)[0];

			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar esta empresa?", "Borrado de Empresa", JOptionPane.YES_NO_OPTION)==0) {
				if (empresa.eraseEmpresa(idEmpresa)) {
					// muestra mensaje y actualiza las pestañas
					JOptionPane.showMessageDialog(mainFrame, "La empresa ha sido borrada correctamente", "Borrado de Empresa", JOptionPane.INFORMATION_MESSAGE);
					reinicia.reinicia(1,1);
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en el borrado de empresa", "Borrado de Empresa", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		if (source.equals("info")) {
			createHelp();
		}
		
	}

} // *************** END OF CLASS
