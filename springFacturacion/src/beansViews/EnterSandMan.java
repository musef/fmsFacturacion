package beansViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


import main.SpringFacturacion;

import beansControls.ClockAndDate;
import beansControls.EmpresaBean;
import beansControls.TiposIrpfBean;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class EnterSandMan extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;


	private JFrame mainFrame;		// marco principal de toda la aplicacion
	private JPanel marco;			// panel principal de la pantalla general
	private JPanel marcoAux0;		// marco auxiliar marcoIdentificacion
	//private JPanel marcoAux1;		// marco auxiliar marcoCreacion: se intercambia con marcoAux0
	private JPanel principal;
	private JPanel superior;
	private JLabel lateralDer;
	private JLabel lateralIzq;
	private JPanel inferior;


	// atributos de marcoIdentificacion
	private JLabel line;
	private JPanel fin;
	private JTextField nombreID;
	private JPasswordField passwordID;
	private JButton entrar;
	private JButton salir;
	private JButton nuevo;
	private Font font2=new Font("SansSerif", Font.BOLD, 16);

	
	// atributos de iniciate
	static JTabbedPane panelTabuladoPrincipal;
	private JTabbedPane tabbed;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JLabel timeAndDate=new JLabel();
	private JLabel nameTitle;
	private Font font0=new Font("Arial", Font.BOLD, 20);
	private Font font1=new Font("Arial", Font.BOLD, 14);
	//private Color colorTitulo=Color.white;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton desconectar;
	
	//SPRING
	private EmpresaBean thisEmpresa;
	private ClockAndDate time;
	private MarcoClientes cliente;
	private MarcoFacturas factura;	
	private MarcoAlbaranes albaranes;
	private MarcoAdministracion admin;
	private TiposIrpfBean irpfBean;

	private ImageIcon icon;
	
	public EnterSandMan() {
		// CONSTRUCTOR
		
	}
	

	public void setIrpfBean (TiposIrpfBean irpfBean) {
		// Spring
		this.irpfBean=irpfBean;
	}
	
	public void setFactura (MarcoFacturas factura) {
		//spring
		this.factura=factura;
	}
	
	public void setThisEmpresa(EmpresaBean thisEmpresa) {
		// spring
		this.thisEmpresa=thisEmpresa;
	}
	
	public void setAlbaranes(MarcoAlbaranes notas) {
		//spring
		this.albaranes=notas;
	}
	
	public void setAdmin (MarcoAdministracion admin) {
		// spring
		this.admin=admin;
	}
	
	public void setmCliente(MarcoClientes cliente) {
		// spring
		this.cliente = cliente;
	}
	
	public void setTime(ClockAndDate time) {
		// spring
		this.time = time;
	}
	
	
	/**
	 * El metodo start inicializa las acciones oportunas, y genera la ventana
	 * de identificacion.
	 * 
	 */
	
	public void startApp() {
		
		// genera la pantalla de identificacion
		identificate();
	
	} // fin del metodo start	
	
	
	
	/**
	 * Este metodo fabrica la pantalla de identificacion en la aplicacion.
	 * 
	 */
	
	private void identificate() {	
		
		// creamos la pantalla principal
		String titleFrame="fmsFacturación - Identificación ";
		mainFrame=new JFrame(titleFrame);
		mainFrame.setBounds(150, 150, 500, 400);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setLocationByPlatform(false);
		mainFrame.setResizable(false);
		
		// creamos el panel principal
		principal=new JPanel();
		//BoxLayout bx=new BoxLayout(principal, BoxLayout.Y_AXIS);
		principal.setLayout(new FlowLayout());
		
		// creamos cada uno de los elementos a añadir al panel
			// creamos el titulo

		JPanel panelTitle=new JPanel();
		Dimension dim=new Dimension(500,65);
		panelTitle.setMaximumSize(dim);
		panelTitle.setMinimumSize(dim);
		panelTitle.setPreferredSize(dim);
		panelTitle.setBackground(SpringFacturacion.fondoColor);
		panelTitle.setAlignmentY(JPanel.LEFT_ALIGNMENT);
		
		JLabel title=new JLabel("");
		icon = new ImageIcon("src/images/fmsSoft_sub.png");
		title.setIcon(icon);

		panelTitle.setLayout(new FlowLayout());
		panelTitle.add(title);
		panelTitle.add(new JLabel("                                                    "));
		panelTitle.add(new JLabel("                                                    "));
		
			// creamos el marco de identificacion
		JPanel ini=marcoIdentificacion();
		ini.setBackground(SpringFacturacion.fondoColor);
		Dimension dim2=new Dimension(500,335);
		ini.setMaximumSize(dim2);
		ini.setMinimumSize(dim2);
		ini.setPreferredSize(dim2);
		
		// añadimos todos los componentes al panel principal
		principal.add(panelTitle);
		principal.add(ini);
		
		// integramos el panel principal en la ventana
		mainFrame.add(principal);
		// hacemos visible la ventana
		mainFrame.setVisible(true);
		
	} // fin del metodo identificate	
	
	
	
	/**
	 * Pantalla de identificación del usuario.
	 * Hay que introducir login y password.
	 *  
	 * @param Este metodo no tiene parametros.
	 * 
	 * @return Retorna un JPanel con el marco de identificacion.
	 */
	
	private JPanel marcoIdentificacion() {
	
		// genera los JPanel necesarios
		marco=new JPanel();
		
		marcoAux0=new JPanel();
		marcoAux0.setBackground(SpringFacturacion.fondoColor);
		JPanel marcoAux1=new JPanel();
		marcoAux1.setBackground(SpringFacturacion.fondoColor);

		// crea el title
		JPanel marcoTitle2=new JPanel();
		marcoTitle2.setBackground(SpringFacturacion.fondoColor);
		JLabel title2=new JLabel("fmsFacturación");
		title2.setFont(new Font("Arial",Font.BOLD, 50));
		title2.setForeground(Color.BLACK);
		marcoTitle2.add(title2);
		
		// crea el marco 
		JLabel nombre=new JLabel("Usuario");
		nombre.setFont(font2);
		nombreID=new JTextField();
		nombreID.setToolTipText("Longitud entre 6 y 15 caracteres");
		JLabel password=new JLabel("Password");
		password.setFont(font2);
		passwordID=new JPasswordField();
		passwordID.setToolTipText("Longitud entre 6 y 15 caracteres");
		
		marcoAux0.setLayout(new GridLayout(3,4));

		
		marcoAux0.add(new JLabel(" "));
		marcoAux0.add(nombre);
		marcoAux0.add(nombreID);
		marcoAux0.add(new JLabel(" "));

		marcoAux0.add(new JLabel(" "));
		marcoAux0.add(password);
		marcoAux0.add(passwordID);
		marcoAux0.add(new JLabel(" "));
		
		marcoAux0.add(new JLabel(" "));
		marcoAux0.add(new JLabel(" "));
		marcoAux0.add(new JLabel(" "));
		marcoAux0.add(new JLabel(" "));
		
		
		// creamos una linea de separacion
		line=new JLabel(" ");
			// creamos un panel con los botones
		fin=new JPanel();
		fin.setLayout(new FlowLayout());
		fin.setBackground(SpringFacturacion.fondoColor);
		entrar=new JButton("Login");
		entrar.setToolTipText("pulsar para identificarse");
		salir=new JButton("Salir");
		salir.setToolTipText("pulsar para cerrar la aplicación");
		nuevo=new JButton("Nuevo Usuario");
		nuevo.setToolTipText("pulsar para crear un nuevo usuario");
		nuevo.setEnabled(false);
			// agregamos botones
		fin.add(entrar);
		fin.add(salir);
		fin.add(nuevo);
		
		marcoAux1.add(line);
		marcoAux1.add(fin);
		
		// añade el marco al marco principal
		marco.setLayout(new BoxLayout(marco,BoxLayout.Y_AXIS));
		marco.add(marcoTitle2);
		marco.add(marcoAux0);
		marco.add(marcoAux1);

		// crea un borde para remarcar el marco
		marco.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// visualiza el marco antes de retornar
		marco.setVisible(true);

		// habilitamos los botones para el control con actionListener
		entrar.addActionListener(this);
		salir.addActionListener(this);
		nuevo.addActionListener(this);
		
		return marco;
		
	} // fin del metodo marcoIdentificacion
	
	
	
	/**
	 * Pantalla de inicio de la aplicacion, una vez identificado correctamente un
	 * usuario. Muestra la pantalla principal con las 4 pestañas de trabajo.
	 * 
	 * @param Este metodo no tiene parametros.
	 * 
	 * @return Este metodo no retorna valores
	 */
	
	public void iniciate() {
		
		// crea una nueva ventana principal y sus caracteristicas
		String titleFrame="fmsFacturación v1.1 - Gestión           Usuario: "+SpringFacturacion.nameUsuario;
		mainFrame=new JFrame(titleFrame);
		mainFrame.setBounds(10, 10, 850, 750);
		mainFrame.setLocationByPlatform(true);
		mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		mainFrame.setLocationByPlatform(false);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setResizable(false);
		
		//marco=new JPanel();
		JPanel marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(new Dimension(600,600));
		marcoAux1.setPreferredSize(new Dimension(600,600));
		marcoAux1.setLayout(new GridLayout(2,2));
			
		ImageIcon ic1 = new ImageIcon("src/images/admin.png");
		ImageIcon ic2 = new ImageIcon("src/images/clientes.png");		
		ImageIcon ic3 = new ImageIcon("src/images/albaranes.png");
		ImageIcon ic4 = new ImageIcon("src/images/facturacion.png");
		

		b1=new JButton(ic1);
		b1.setActionCommand("admin");
		b1.setToolTipText("Administración");
		b2=new JButton(ic2);
		b2.setActionCommand("Clientes");
		b2.setToolTipText("Mantenimiento clientes");
		b3=new JButton(ic3);
		b3.setActionCommand("Albaranes");
		b3.setToolTipText("Albaranes");
		b4=new JButton(ic4);
		b4.setActionCommand("Facturas");
		b4.setToolTipText("Facturación");
		
		marcoAux1.add(b1);
		marcoAux1.add(b2);
		marcoAux1.add(b3);
		marcoAux1.add(b4);		
		
		mainFrame.add(marcoAux1,BorderLayout.CENTER);
		
		
		// crea el panel superior
		superior=new JPanel();
		superior.setLayout(new BoxLayout(superior,BoxLayout.Y_AXIS));
		superior.setAlignmentX(LEFT_ALIGNMENT);
		superior.setBackground(SpringFacturacion.fondoColor);
		
			// creamos elemento titulo para el panel superior
		JPanel titulo=new JPanel();
		titulo.setLayout(new GridLayout(1,1));
		titulo.setBackground(SpringFacturacion.fondoColor);
		nameTitle=new JLabel("Empresa: "+SpringFacturacion.nameCompany);
		nameTitle.setSize(250, 55);
		nameTitle.setFont(font0);
		titulo.add(nameTitle);

			// elemento de separacion
		//titulo.add(new JLabel("**"));
		
			// creamos el elemento fecha y hora de conexión 
		timeAndDate=new JLabel("conexion: "+time.showMeTheDate());
		timeAndDate.setFont(font1);
		timeAndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		titulo.add(timeAndDate);
		
			// creamos el elemento boton desconectar para el panel superior
		JPanel botonada=new JPanel();
		botonada.setLayout(new GridLayout(1,5));
		botonada.setBackground(SpringFacturacion.fondoColor);
		desconectar=new JButton("Desconectar");
		desconectar.setToolTipText("Salir de la aplicación");
		botonada.add(new JLabel());
		botonada.add(new JLabel());
		botonada.add(new JLabel());
		botonada.add(new JLabel());
		botonada.add(desconectar);
		
			// añadimos los elementos al panel titulo, con un espacio de separacion
		superior.add(titulo);
		superior.add(new JLabel(" "));
		superior.add(botonada);
		superior.add(new JLabel(" "));

		mainFrame.add(superior,BorderLayout.NORTH);
		
		// creamos el panel lateral izquierdo para tener un margen
		lateralIzq=new JLabel(" ");
		mainFrame.add(lateralIzq,BorderLayout.EAST);
		
		// creamos el panel lateral derecho para tener un margen
		lateralDer=new JLabel(" ");
		mainFrame.add(lateralDer,BorderLayout.WEST);
		
		// creamos la parte inferior
		inferior=new JPanel();
		Dimension dimInf=new Dimension(150,50);
		inferior.setMaximumSize(dimInf);
		inferior.setPreferredSize(dimInf);
		inferior.setLayout(new FlowLayout());
		JLabel sp=new JLabel(icon);
		inferior.add(sp);
		inferior.add(new JLabel("        musef2904@gmail.com"));
		
		
		// visualizamos el panel principal
		mainFrame.setVisible(true);
		
		// activamos los listener
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		desconectar.addActionListener(this);
		
		//okey.addActionListener(this);
		
	}	// fin del metodo iniciate
	
	

	/**
	 * Este metodo construye un menu de pestañas, seleccionando como principal
	 * la pestaña tabb dada por parametro
	 * 
	 * @param tabb - pestaña que quiere presentarse en visualizacion (0 a 3)
	 */
	
	private void tabbedMenu(int tabb) {
		
		// crea una nueva ventana principal y sus caracteristicas
		String titleFrame="fmsFacturación v1.1 - Gestión           Usuario: "+SpringFacturacion.nameUsuario;
		mainFrame=new JFrame(titleFrame);
		mainFrame.setBounds(10, 10, 850, 750);
		mainFrame.setLocationByPlatform(true);
		mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		mainFrame.setLocationByPlatform(false);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setResizable(false);
		
		/* NO SPRING
		MarcoClientes cliente=new MarcoClientes(mainFrame);		
		PanelFacturas factura=new PanelFacturas(mainFrame);
		MarcoAlbaranes notas=new MarcoAlbaranes(mainFrame);
		MarcoAdministracion admin=new MarcoAdministracion(mainFrame);
		*/
		
		panel1=admin.marcoPrincipal(mainFrame,1);
		panel2=cliente.marcoPrincipal(mainFrame,1);			
		panel3=albaranes.marcoPrincipal(mainFrame,1);
		panel4=factura.marcoPrincipal(mainFrame,1);	
	
		tabbed=panelTabulado(panel1,panel2,panel3,panel4);
		tabbed.setSelectedIndex(tabb);
		JPanel center=new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
		center.add(tabbed);
		
		JPanel latDerecha=new JPanel();
		JPanel latIzquierda=new JPanel();
		
		
		superior.setBackground(SpringFacturacion.fondoColor);
		center.setBackground(SpringFacturacion.fondoColor);
		latDerecha.setBackground(SpringFacturacion.fondoColor);
		latIzquierda.setBackground(SpringFacturacion.fondoColor);
		inferior.setBackground(SpringFacturacion.fondoColor);

		
		mainFrame.add(center,BorderLayout.CENTER);
		mainFrame.add(superior,BorderLayout.NORTH);
		mainFrame.add(latDerecha,BorderLayout.EAST);
		mainFrame.add(latIzquierda,BorderLayout.WEST);
		mainFrame.add(inferior,BorderLayout.SOUTH);
		
		mainFrame.setVisible(true);
		
	} // fin del metodo tabbedMenu
	
	
	
	/**
	 * Metodo constructor del panel de pestañas.
	 * 
	 * @param panel1 - panel de datos personales.
	 * @param panel2 - panel de cuentas de inversion.
	 * @param panel3 - panel de operaciones de inversion.
	 * @param panel4 - panel de consultas (historico).
	 * 
	 * @return Retorna un JTabbedPane con las 4 pestañas montadas.
	 */
	
	private JTabbedPane panelTabulado(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4) {

		panelTabuladoPrincipal=new JTabbedPane();
		panelTabuladoPrincipal.setFont(font0);
		panelTabuladoPrincipal.setBackground(SpringFacturacion.fondoColor);
		
		panelTabuladoPrincipal.addTab("Administración", panel1);
		panelTabuladoPrincipal.addTab("Clientes", panel2);		
		panelTabuladoPrincipal.addTab("Albaranes", panel3);
		panelTabuladoPrincipal.addTab("Facturas", panel4);
				
		
		return panelTabuladoPrincipal;
		
	}	// fin del metodo panelTabulado	
	

	/**
	 * Método que reinicia la pantalla, refrescando la información
	 */
	
	public void reinicia(int tabbed, int subTab) {
		
		// quita los paneles del principal
		panelTabuladoPrincipal.setVisible(false);
		panelTabuladoPrincipal.remove(panel1);
		panelTabuladoPrincipal.remove(panel2);
		panelTabuladoPrincipal.remove(panel3);
		panelTabuladoPrincipal.remove(panel4);
		
		// quita los componentes de cada panel y los reinicia para que se actualicen
		panel1.removeAll();
		panel1=admin.marcoPrincipal(mainFrame, subTab);
		panel2.removeAll();
		panel2=cliente.marcoPrincipal(mainFrame, subTab);
		panel3.removeAll();
		panel3=albaranes.marcoPrincipal(mainFrame, subTab);
		panel4.removeAll();
		panel4=factura.marcoPrincipal(mainFrame, subTab);
		
		// recupera la informacion de empresa (por si hubo cambios en panel empresa)
		SpringFacturacion.nameUsuario="Administrador";
		String empresaSel[]=new String[11];
		if (thisEmpresa.getListEmpresa()!=null) {
			empresaSel=thisEmpresa.getListEmpresa().get(0);
		}				
		SpringFacturacion.serialInvoices=empresaSel[8];
		SpringFacturacion.nameCompany=empresaSel[1];
		SpringFacturacion.addressCompany=empresaSel[3];
		SpringFacturacion.cpostalCompany=empresaSel[4];
		SpringFacturacion.cityCompany=empresaSel[5];
		SpringFacturacion.nifCompany=empresaSel[6];
		SpringFacturacion.idCompany=empresaSel[0];
		// si la empresa tiene retencion por irpf lo busca
		if (empresaSel[10].equals("1")) {
			List <String[]>irfpList;
			if ((irfpList=irpfBean.getListIrpf())==null) {
				irfpList=new ArrayList<String[]>();
			}
			for (String[] a:irfpList) {
				// si el irpf es activo y pertenece a ventas 
				if (a[1].equals("1") && a[4].equals("1")) {
					SpringFacturacion.retInvoices=(double)Double.parseDouble(a[3]);
				}
			}
		}		
		try {
			SpringFacturacion.lastInvoiceNumber=(long)Long.parseLong(empresaSel[9]);
		} catch (NumberFormatException nf) {
			SpringFacturacion.lastInvoiceNumber=0;
		}		
		nameTitle.setText("Empresa: "+SpringFacturacion.nameCompany);
		
		/*
		if (tabbed==4) {
			panel4.setVisible(true);
		} else if (tabbed==3) {
			panel3.setVisible(true);
		} else if (tabbed==2) {
			panel2.setVisible(true);
		} else {
			panel1.setVisible(true);
		}
		*/
		
		// vuelve a conectar los paneles actualizados al panel principal
		panelTabuladoPrincipal.addTab("Administración", panel1);
		panelTabuladoPrincipal.addTab("Clientes", panel2);		
		panelTabuladoPrincipal.addTab("Albaranes", panel3);
		panelTabuladoPrincipal.addTab("Facturas", panel4);		
		panelTabuladoPrincipal.revalidate();
		panelTabuladoPrincipal.setVisible(true);
		
		// selecciona el panel activo
		panelTabuladoPrincipal.setSelectedIndex(tabbed-1);
		
		mainFrame.revalidate();
			
	} // fin del metodo reinicia
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("Login")) {
			
			char[] pass=passwordID.getPassword();			
			String pss=String.copyValueOf(pass).toString().trim();
			
			
			if ((nombreID.getText().trim().equals("admin") && pss.equals("admin"))) {
				// identificacion correcta
				pass=new char[15];
				pss="";
				
				SpringFacturacion.nameUsuario="Administrador";

				String empresaSel[]=new String[11];
				if (thisEmpresa.getListEmpresa()!=null) {
					empresaSel=thisEmpresa.getListEmpresa().get(0);
				}
				
				SpringFacturacion.serialInvoices=empresaSel[8];
				SpringFacturacion.nameCompany=empresaSel[1];
				SpringFacturacion.addressCompany=empresaSel[3];
				SpringFacturacion.cpostalCompany=empresaSel[4];
				SpringFacturacion.cityCompany=empresaSel[5];
				SpringFacturacion.nifCompany=empresaSel[6];
				SpringFacturacion.idCompany=empresaSel[0];
				// si la empresa tiene retencion por irpf lo busca
				if (empresaSel[10].equals("1")) {
					List <String[]>irfpList;
					if ((irfpList=irpfBean.getListIrpf())==null) {
						irfpList=new ArrayList<String[]>();
					}
					for (String[] a:irfpList) {
						// si el irpf es activo y pertenece a ventas 
						if (a[1].equals("1") && a[4].equals("1")) {
							SpringFacturacion.retInvoices=(double)Double.parseDouble(a[3]);
						}
					}
				}
				
				try {
					SpringFacturacion.lastInvoiceNumber=(long)Long.parseLong(empresaSel[9]);
				} catch (NumberFormatException nf) {
					SpringFacturacion.lastInvoiceNumber=0;
				}
				
				mainFrame.setVisible(false);
				
				if (SpringFacturacion.nameCompany.isEmpty() && SpringFacturacion.nifCompany.isEmpty()) {
					// Si estos datos estan vacios es que es el primer acceso y no hay empresa creada
					JOptionPane.showMessageDialog(mainFrame, "La empresa no ha sido creada.\n\nEl primer paso a realizar debe ser crear los" +
							"\ndatos de la empresa, en la pestaña de\nAdministración. A continuación, cree los datos\n" +
							"de IVA, las formas de pago y, si es su caso,\n" +
							"el IRPF que le afecte.\n", "Advertencia: empresa no creada", JOptionPane.WARNING_MESSAGE);
				}
				
				iniciate();

			} else if (JOptionPane.showConfirmDialog(mainFrame, "El usuario-contraseña facilitado es incorrecto.\n" +
					"¿Desea intentarlo de nuevo?", "Error en identificación", JOptionPane.YES_NO_OPTION)!=0) {
				thisEmpresa.modifyLastInvoiceNumber(SpringFacturacion.idCompany, SpringFacturacion.lastInvoiceNumber);
				System.exit(0);
			}
				
		} // end of login
		
		if (source.equals("Clientes")) {
			mainFrame.setVisible(false);
			tabbedMenu(1);
		}
		
		if (source.equals("Facturas")) {
			mainFrame.setVisible(false);
			tabbedMenu(3);
		}
		
		if (source.equals("Albaranes")) {
			mainFrame.setVisible(false);
			tabbedMenu(2);
		}
		
		if (source.equals("admin")) {
			mainFrame.setVisible(false);
			tabbedMenu(0);
		}		
		
		if (source.equals("Desconectar")) {
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea abandonar la aplicación?", "Salida de la aplicación", JOptionPane.YES_NO_OPTION)==0) {
				thisEmpresa.modifyLastInvoiceNumber(SpringFacturacion.idCompany, SpringFacturacion.lastInvoiceNumber);
				System.exit(0);
			}		
		} 
		
		if (source.equals("Salir")) {
				System.exit(0);
		} 
		
	} // end of actionEvent

	
	
	// GETTERS AND SETTERS

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public ClockAndDate getTime() {
		return time;
	}

	public MarcoClientes getCliente() {
		return cliente;
	}

	public EmpresaBean getEmpresa() {
		return thisEmpresa;
	}




} // ********************** END OF CLASS
