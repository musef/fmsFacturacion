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
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import beansControls.AlbaranesBean;
import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansControls.FacturasBean;
import beansControls.PagosBean;
import beansControls.TiposIvaBean;
import beansControls.UtilsFacturacion;
import beansList.ListadosPdf;
import beansModels.Facturas;

import main.SpringFacturacion;


/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicesModifying extends UtilsFacturacion implements ActionListener, ItemListener {
	
	// spring objects
	private ClockAndDate dateEsp;
	private TiposIvaBean ivas;
	private ClientesBean clienteFac;
	private Facturas datosF;
	private FacturasBean facturador;
	private ListadosPdf dataList;
	private PagosBean formaPago;
	private AlbaranesBean albaranes;
	

	// not a spring object
	private Facturas invoiceToModify;				// objeto facturas

	private JFrame mainFrame;
	
	
	// MODIFICAR FACTURA
	private JPanel marco2B;
	private JPanel marcoAux0B;
	private JPanel marcoAux1B;
	private JPanel marcoHead0B;
	private JPanel marcoHead1B;
	private JPanel marcoHead2B;
	private JPanel marcoHead3B;
	private JPanel marcoInput1B;
	private JPanel marcoInput2B;
	private JPanel marcoAux01B;
	private JPanel marcoAux02B;	
	private JPanel marcoAux11B;
	private JPanel marcoAux11_BB;
	private JPanel marcoAux12B;
	private JPanel marcoAux21B;
	private JPanel marcoAux21_BB;
	private JPanel marcoAux22B;
	private JPanel marcoAux31B;
	private JPanel marcoAux31_BB;
	private JPanel marcoAux32B;
	private JPanel marcoAux41B;
	private JPanel marcoAux41_BB;
	private JPanel marcoAux42B;
	private JPanel marcoAux51B;
	private JPanel marcoAux51_BB;
	private JPanel marcoAux52B;
	private JPanel marcoAux61B;
	private JPanel marcoAux62B;
	private JPanel marcoAux71B;
	private JPanel marcoAux72B;
	
	private JComboBox<String> selInvoiceB;
	private JComboBox<String> selCustomerInvB;
	private JTextField invoiceNumberB;
	private JTextField nameCustomerInvB;
	private JTextField dateCustomerInvB;
	private JTextField numberCustomerInvB;
	
	private JComboBox<String> numberOpB;
	private JTextField textOpB;
	private JTextField qttOpB;
	private JTextField priceOpB;	
	private JComboBox<String> ivaOpB;
	private JTextField amountOpB;		
	
	private final int LENGTHPANEL=5;
	private JTextField cod1B;
	private JTextField tex1B;
	private JTextField ud1B;
	private JTextField price1B;
	private JTextField iva1B;
	private JTextField imp1B;
	private JTextField cod2B;
	private JTextField tex2B;
	private JTextField ud2B;
	private JTextField price2B;
	private JTextField iva2B;
	private JTextField imp2B;
	private JTextField cod3B;
	private JTextField tex3B;
	private JTextField ud3B;
	private JTextField price3B;
	private JTextField iva3B;
	private JTextField imp3B;
	private JTextField cod4B;
	private JTextField tex4B;
	private JTextField ud4B;
	private JTextField price4B;
	private JTextField iva4B;
	private JTextField imp4B;
	private JTextField cod5B;
	private JTextField tex5B;
	private JTextField ud5B;
	private JTextField price5B;
	private JTextField iva5B;
	private JTextField imp5B;
	
	private double tipoIva1B;
	private double tipoIva2B;
	private double tipoIva3B;
	private double baseIB=0;
	private double cuotaIB=0;
	private double retencIB=0;
	private double base0B=0;
	private double base1B=0;
	private double base2B=0;
	private double base3B=0;
	private double cuota1B=0;
	private double cuota2B=0;
	private double cuota3B=0;
	private JTextField baseImpB;
	private JTextField cuotaIvaB;
	private JTextField retencIRPFB;
	private JTextField importeTotalB;
			
	private JButton anadirFB;
	private JButton info;
	private JButton delF1B;
	private JButton delF2B;
	private JButton delF3B;
	private JButton delF4B;
	private JButton delF5B;
	private JButton grabarFB;
	private JButton borrarFB;

	
	// DATOS DE LA FACTURA EN MODIFICACION
	private List<String[]> datosFactB;				// lista de los datos facturados
	private String nextNumberFactB;					// Num. de factura (numérico)
	private String selectedCustomerB;				// key del cliente a facturar
	private List<String[]> listClientesFacB;		// lista de clientes seleccionables para modificar
	private List<String[]> listAlbaranesFacB;		// lista de albaranes pendientes de facturar
	private List<String[]> listInvoiceB;			// lista de facturas seleccionables para modificar
	private int indexCustomerB;
	private String serieFact;
	private String customerModifying;				// keycode del cliente a modificar

	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	private final Color COLORL=Color.BLACK;
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	private final String CODEDIRECT="999999";	// codigo de entrada directa (no albaran grabado)			
	
	
	
	public PanelInvoicesModifying() {
		// CONSTRUCTOR

	}
	
	
	public void setDateEsp (ClockAndDate date) {
		// spring
		this.dateEsp=date;	
	}
	
	public void setIvas (TiposIvaBean tipos) {
		// spring
		this.ivas=tipos;
	}
	
	public void setClienteFac(ClientesBean customer) {
		// spring
		this.clienteFac=customer;
	}
	
	public void setFactura (Facturas factura) {
		// spring
		this.datosF=factura;
	}
	
	public void setFacturador (FacturasBean fact) {
		// spring
		this.facturador=fact;
	}
	
	public void setDataList(ListadosPdf dataList) {
		// spring
		this.dataList = dataList;
	}
	
	public void setFormaPago (PagosBean formaPago) {
		// spring
		this.formaPago=formaPago;
	}
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	
	
	/**
	 * Método que permite la modificación de la factura, mostrándola en el panel.
	 * 
	 * @return - un JPanel componiendo la pantalla de factura
	 */
	
	public JPanel modifyInvoice(JFrame mainFrame) {
		
		// aun no existe cliente a modificar
		customerModifying="";
		
		this.serieFact=SpringFacturacion.serialInvoices;
		this.mainFrame=mainFrame;
		
		marco2B=new JPanel();
		
		// creamos los objetos swing
		marcoAux0B=new JPanel();
		Dimension panDim0=new Dimension(650,55);
		marcoAux0B.setMinimumSize(panDim0);
		marcoAux0B.setPreferredSize(panDim0);
		marcoAux0B.setMaximumSize(panDim0);
		Dimension panDim1=new Dimension(650,450);
		marcoAux1B=new JPanel();
		marcoAux1B.setMinimumSize(panDim1);
		marcoAux1B.setPreferredSize(panDim1);
		marcoAux1B.setMaximumSize(panDim1);

		
		// titulo
		JLabel titleB=new JLabel("                          FACTURACIÓN - MODIFICACIÓN                      ");
		titleB.setFont(font1);
		// creamos el formulario
		
		// cabecera
		//factura=new FacturasBean();	
		selInvoiceB=new JComboBox<String>();
		selInvoiceB.addItem("Seleccione número...");
		//clienteFac=new ClientesBean();
		listInvoiceB=facturador.searchAllInvoiceNumber();
		for (String[] data: listInvoiceB) {
			selInvoiceB.addItem(data[1]);
		}
		invoiceNumberB=new JTextField("");
		invoiceNumberB.setEditable(false);
		//invoiceNumberB.setToolTipText("OBLIGATORIO: Entre 3 y 50 caracteres");
		
		
		selCustomerInvB=new JComboBox<String>();
		selCustomerInvB.addItem("Seleccione cliente...");
		//clienteFac=new ClientesBean();
		listClientesFacB=clienteFac.getListCustomers();
		for (String[] data: listClientesFacB) {
			selCustomerInvB.addItem(data[2]);
		}
		nameCustomerInvB=new JTextField("");
		nameCustomerInvB.setEditable(false);		
		
		dateCustomerInvB=new JTextField(dateEsp.getDate());
		dateCustomerInvB.setToolTipText("OBLIGATORIO: formato dd-mm-aaaa");
		
		numberCustomerInvB=new JTextField("");
		numberCustomerInvB.setToolTipText("OBLIGATORIO: máx 15 caracteres");	
		
		// zona inputs
		numberOpB=new JComboBox<String>();
		numberOpB.addItem("Entrada directa");
		
		textOpB=new JTextField("");
		textOpB.setToolTipText("OBLIGATORIO: máximo 200 caracteres");
		qttOpB=new JTextField("");
		textOpB.setToolTipText("campo numérico");
		priceOpB=new JTextField("");
		priceOpB.setToolTipText("campo numérico");
		
		ivaOpB=new JComboBox<String>();
		//ivas=new TiposIvaBean();
		List<String[]> listIv=ivas.getListIva();
		for (String[] a:listIv) {
			if (!(a[1].equals("0") || a[4].equals("2"))) {
				// si el iva no esta inactivo ni es de compras lo añade
				// pero por orden de clase de iva			
				//ivaOp.add(new JLabel(a[3]),(int)Integer.parseInt(a[5]));
				ivaOpB.addItem(a[3]);
			}
		}
		
		amountOpB=new JTextField();
		//amountOp.setToolTipText("campo numérico");
		amountOpB.setEnabled(false);
		
		anadirFB=new JButton("intro");
		anadirFB.setToolTipText("pulse para incorporar datos");
		
		marcoHead0B=new JPanel();
		marcoHead1B=new JPanel();
		marcoHead2B=new JPanel();
		marcoHead3B=new JPanel();
		marcoInput1B=new JPanel();
		marcoInput2B=new JPanel();
		marcoAux01B=new JPanel();
		marcoAux02B=new JPanel();	
		marcoAux11B=new JPanel();
		marcoAux11_BB=new JPanel();
		marcoAux12B=new JPanel();
		marcoAux21B=new JPanel();
		marcoAux21_BB=new JPanel();
		marcoAux22B=new JPanel();
		marcoAux31B=new JPanel();
		marcoAux31_BB=new JPanel();
		marcoAux32B=new JPanel();
		marcoAux41B=new JPanel();
		marcoAux41_BB=new JPanel();
		marcoAux42B=new JPanel();
		marcoAux51B=new JPanel();
		marcoAux51_BB=new JPanel();
		marcoAux52B=new JPanel();
		marcoAux61B=new JPanel();
		marcoAux62B=new JPanel();
		marcoAux71B=new JPanel();
		marcoAux72B=new JPanel();
		
		marcoHead0B.setLayout(new GridLayout(1,2));
		marcoHead1B.setLayout(new GridLayout(1,2));
		marcoHead2B.setLayout(new GridLayout(1,2));
		marcoHead3B.setLayout(new GridLayout(1,2));
		marcoInput1B.setLayout(new GridLayout(1,2));
		marcoInput2B.setLayout(new GridLayout(1,4));
		marcoAux01B.setLayout(new GridLayout(1,2));
		marcoAux02B.setLayout(new GridLayout(1,4));		
		marcoAux11B.setLayout(new GridLayout(1,2));
		marcoAux11_BB.setLayout(new BoxLayout(marcoAux11_BB,BoxLayout.X_AXIS));
		marcoAux12B.setLayout(new GridLayout(1,4));
		marcoAux21B.setLayout(new GridLayout(1,2));
		marcoAux21_BB.setLayout(new BoxLayout(marcoAux21_BB,BoxLayout.X_AXIS));
		marcoAux22B.setLayout(new GridLayout(1,4));
		marcoAux31B.setLayout(new GridLayout(1,2));
		marcoAux31_BB.setLayout(new BoxLayout(marcoAux31_BB,BoxLayout.X_AXIS));
		marcoAux32B.setLayout(new GridLayout(1,4));
		marcoAux41B.setLayout(new GridLayout(1,2));
		marcoAux41_BB.setLayout(new BoxLayout(marcoAux41_BB,BoxLayout.X_AXIS));
		marcoAux42B.setLayout(new GridLayout(1,4));
		marcoAux51B.setLayout(new GridLayout(1,2));
		marcoAux51_BB.setLayout(new BoxLayout(marcoAux51_BB,BoxLayout.X_AXIS));
		marcoAux52B.setLayout(new GridLayout(1,4));
		marcoAux61B.setLayout(new GridLayout(1,2));
		marcoAux62B.setLayout(new GridLayout(1,2));
		marcoAux71B.setLayout(new GridLayout(1,1));
		marcoAux72B.setLayout(new GridLayout(1,3));
		
		cod1B=new JTextField("");
		cod1B.setEditable(false);
		tex1B=new JTextField("");
		tex1B.setEditable(false);
		ud1B=new JTextField("");
		ud1B.setEditable(false);
		price1B=new JTextField("");
		price1B.setEditable(false);
		iva1B=new JTextField("");
		iva1B.setEditable(false);
		imp1B=new JTextField("");
		imp1B.setEditable(false);
		cod2B=new JTextField("");
		cod2B.setEditable(false);
		tex2B=new JTextField("");
		tex2B.setEditable(false);
		ud2B=new JTextField("");
		ud2B.setEditable(false);
		price2B=new JTextField("");
		price2B.setEditable(false);
		iva2B=new JTextField("");
		iva2B.setEditable(false);
		imp2B=new JTextField("");
		imp2B.setEditable(false);
		cod3B=new JTextField("");
		cod3B.setEditable(false);
		tex3B=new JTextField("");
		tex3B.setEditable(false);
		ud3B=new JTextField("");
		ud3B.setEditable(false);
		price3B=new JTextField("");
		price3B.setEditable(false);
		iva3B=new JTextField("");
		iva3B.setEditable(false);
		imp3B=new JTextField("");
		imp3B.setEditable(false);
		cod4B=new JTextField("");
		cod4B.setEditable(false);
		tex4B=new JTextField("");
		tex4B.setEditable(false);
		ud4B=new JTextField("");
		ud4B.setEditable(false);
		price4B=new JTextField("");
		price4B.setEditable(false);
		iva4B=new JTextField("");
		iva4B.setEditable(false);
		imp4B=new JTextField("");
		imp4B.setEditable(false);
		cod5B=new JTextField("");
		cod5B.setEditable(false);
		tex5B=new JTextField("");
		tex5B.setEditable(false);
		ud5B=new JTextField("");
		ud5B.setEditable(false);
		price5B=new JTextField("");
		price5B.setEditable(false);
		iva5B=new JTextField("");
		iva5B.setEditable(false);
		imp5B=new JTextField("");
		imp5B.setEditable(false);
		
		Dimension dim=new Dimension(45,20);	
		delF1B=new JButton("M");
		delF1B.setPreferredSize(dim);
		delF1B.setMaximumSize(dim);
		delF1B.setMinimumSize(dim);
		delF1B.setToolTipText("Borrar este apunte");
		
		delF2B=new JButton("M");		
		delF2B.setPreferredSize(dim);
		delF2B.setMaximumSize(dim);
		delF2B.setMinimumSize(dim);
		delF2B.setToolTipText("Borrar este apunte");
		
		delF3B=new JButton("M");	
		delF3B.setPreferredSize(dim);
		delF3B.setMaximumSize(dim);
		delF3B.setMinimumSize(dim);
		delF3B.setToolTipText("Borrar este apunte");
		
		delF4B=new JButton("M");		
		delF4B.setPreferredSize(dim);
		delF4B.setMaximumSize(dim);
		delF4B.setMinimumSize(dim);
		delF4B.setToolTipText("Borrar este apunte");
		
		delF5B=new JButton("M");	
		delF5B.setPreferredSize(dim);
		delF5B.setMaximumSize(dim);
		delF5B.setMinimumSize(dim);
		delF5B.setToolTipText("Borrar este apunte");
		
		baseImpB=new JTextField("");
		cuotaIvaB=new JTextField("");
		retencIRPFB=new JTextField("");
		if (SpringFacturacion.retInvoices==0) {
			retencIRPFB=new JTextField("0,00");
			retencIRPFB.setEnabled(false);
		}
		importeTotalB=new JTextField("");
		
		marcoHead0B.add(selInvoiceB);
		marcoHead0B.add(invoiceNumberB);
		marcoHead1B.add(selCustomerInvB);
		marcoHead1B.add(nameCustomerInvB);
		marcoHead2B.add(new JLabel("Fecha: (dd-mm-aaaa)"));
		marcoHead2B.add(dateCustomerInvB);
		marcoHead3B.add(new JLabel("Número:"));
		marcoHead3B.add(numberCustomerInvB);
		
		marcoAux01B.add(new JLabel("código"));
		marcoAux01B.add(new JLabel("   texto"));
		marcoAux02B.add(new JLabel("     uds."));
		marcoAux02B.add(new JLabel("   importe"));
		marcoAux02B.add(new JLabel("     iva"));
		marcoAux02B.add(new JLabel(""));
		marcoInput1B.add(numberOpB);
		marcoInput1B.add(textOpB);
		marcoInput2B.add(qttOpB);
		marcoInput2B.add(priceOpB);
		marcoInput2B.add(ivaOpB);
		marcoInput2B.add(anadirFB);
		marcoAux11_BB.add(delF1B);
		marcoAux11_BB.add(cod1B);
		marcoAux11B.add(marcoAux11_BB);
		marcoAux11B.add(tex1B);
		marcoAux12B.add(ud1B);
		marcoAux12B.add(price1B);
		marcoAux12B.add(iva1B);
		marcoAux12B.add(imp1B);
		marcoAux21_BB.add(delF2B);
		marcoAux21_BB.add(cod2B);
		marcoAux21B.add(marcoAux21_BB);
		marcoAux21B.add(tex2B);
		marcoAux22B.add(ud2B);
		marcoAux22B.add(price2B);
		marcoAux22B.add(iva2B);
		marcoAux22B.add(imp2B);
		marcoAux31_BB.add(delF3B);
		marcoAux31_BB.add(cod3B);
		marcoAux31B.add(marcoAux31_BB);
		marcoAux31B.add(tex3B);
		marcoAux32B.add(ud3B);
		marcoAux32B.add(price3B);
		marcoAux32B.add(iva3B);
		marcoAux32B.add(imp3B);
		marcoAux41_BB.add(delF4B);
		marcoAux41_BB.add(cod4B);
		marcoAux41B.add(marcoAux41_BB);
		marcoAux41B.add(tex4B);
		marcoAux42B.add(ud4B);
		marcoAux42B.add(price4B);
		marcoAux42B.add(iva4B);
		marcoAux42B.add(imp4B);
		marcoAux51_BB.add(delF5B);
		marcoAux51_BB.add(cod5B);
		marcoAux51B.add(marcoAux51_BB);
		marcoAux51B.add(tex5B);
		marcoAux52B.add(ud5B);
		marcoAux52B.add(price5B);
		marcoAux52B.add(iva5B);
		marcoAux52B.add(imp5B);
		marcoAux61B.add(baseImpB);
		marcoAux61B.add(cuotaIvaB);
		marcoAux62B.add(retencIRPFB);
		marcoAux62B.add(importeTotalB);
		
		// preparamos los botones 
		grabarFB=new JButton("Cambiar factura");
		grabarFB.setToolTipText("pulse para grabar la factura modificada");
		borrarFB=new JButton("Borrar datos");
		borrarFB.setToolTipText("pulse para borrar el formulario");
		
		marcoAux71B.add(new JLabel());
		marcoAux72B.add(grabarFB);
		marcoAux72B.add(new JLabel());
		marcoAux72B.add(borrarFB);
		
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
		marcoAux0B.add(titleB);
		marcoAux0B.add(panelButton3);
		
		marcoAux1B.setLayout(new GridLayout(19,2));

		marcoAux1B.add(marcoHead0B);
		marcoAux1B.add(new JLabel(""));
		marcoAux1B.add(marcoHead1B);
		marcoAux1B.add(new JLabel(""));	
		marcoAux1B.add(marcoHead2B);
		marcoAux1B.add(new JLabel(""));		
		marcoAux1B.add(marcoHead3B);
		marcoAux1B.add(new JLabel(""));

		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" INTRODUCCIÓN DE DATOS:"));
		marcoAux1B.add(new JLabel(" "));

		marcoAux1B.add(marcoAux01B);
		marcoAux1B.add(marcoAux02B);
		marcoAux1B.add(marcoInput1B);
		marcoAux1B.add(marcoInput2B);
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" "));
		
		marcoAux1B.add(new JLabel("VISUALIZACIÓN ÚLTIMOS APUNTES"));
		marcoAux1B.add(new JLabel(" "));	
		marcoAux1B.add(marcoAux11B);
		marcoAux1B.add(marcoAux12B);		
		marcoAux1B.add(marcoAux21B);
		marcoAux1B.add(marcoAux22B);
		marcoAux1B.add(marcoAux31B);
		marcoAux1B.add(marcoAux32B);
		marcoAux1B.add(marcoAux41B);
		marcoAux1B.add(marcoAux42B);
		marcoAux1B.add(marcoAux51B);
		marcoAux1B.add(marcoAux52B);
		
		marcoAux1B.add(new JLabel("   Base Imponible                                    Cuota iva"));
		marcoAux1B.add(new JLabel("  Retención                                               Importe total IVA incluido"));
		marcoAux1B.add(marcoAux61B);
		marcoAux1B.add(marcoAux62B);
		
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(marcoAux71B);
		marcoAux1B.add(marcoAux72B);
		
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2B.setLayout(new BorderLayout());
		marco2B.add(marcoAux0B,BorderLayout.NORTH);
		marco2B.add(marcoAux1B,BorderLayout.CENTER);
		marco2B.add(new JLabel("     "),BorderLayout.EAST);
		marco2B.add(new JLabel("     "),BorderLayout.WEST);
		marco2B.add(new JLabel("     "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2B.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2B.setVisible(true);
		
		// habilitamos los listener de los eventos
		selInvoiceB.addItemListener(this);
		selCustomerInvB.addItemListener(this);
		info.addActionListener(this);
		borrarFB.addActionListener(this);
		grabarFB.addActionListener(this);
		anadirFB.addActionListener(this);
		delF1B.addActionListener(this);
		delF2B.addActionListener(this);
		delF3B.addActionListener(this);
		delF4B.addActionListener(this);
		delF5B.addActionListener(this);
		
		return marco2B;
				
	} // end of method ModifyFactura
	
	
	
	/**
	 * Este método realiza un chequeo de los datos de la factura. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de modificación facturas.
	 * 
	 * @return boolean TRUE or FALSE según el formulario esté correcto o haya errores.
	 */
	
	@SuppressWarnings("unused")
	private boolean checkFormModifyInvoice () {
		
		boolean result=true;
		
		nameCustomerInvB.setBackground(OKFORM);
		dateCustomerInvB.setBackground(OKFORM);
		numberCustomerInvB.setBackground(OKFORM);
		textOpB.setBackground(OKFORM);
		qttOpB.setBackground(OKFORM);
		priceOpB.setBackground(OKFORM);
		amountOpB.setBackground(OKFORM);
		
		if (nameCustomerInvB.getText().trim().isEmpty()) {
			nameCustomerInvB.setBackground(ERRORFORM);
			result=false;
		}
				
		if (!dateEsp.checkDate(dateCustomerInvB.getText().trim())) {
			dateCustomerInvB.setBackground(ERRORFORM);
			result=false;
		}
		
		if (numberCustomerInvB.getText().trim().isEmpty()) {
			numberCustomerInvB.setBackground(ERRORFORM);
			result=false;
		}
		
		if (textOpB.getText().trim().isEmpty() || textOpB.getText().trim().length()>200) {
			textOpB.setBackground(ERRORFORM);
			result=false;
		}
		
		String qtt=qttOpB.getText().trim();
		if (qtt.isEmpty()) {
			qtt="0";
		}
		double checkQtt=0;
		try {
			checkQtt=(double)Double.parseDouble(qtt);
		} catch (NumberFormatException nf) {
			qttOpB.setBackground(ERRORFORM);
			result=false;
		}

		String prz=priceOpB.getText().trim();
		if (prz.isEmpty()) {
			prz="0";
		}
		double checkPrz=0;
		try {
			checkPrz=(double)Double.parseDouble(prz);
		} catch (NumberFormatException nf) {
			priceOpB.setBackground(ERRORFORM);
			result=false;
		}

		return result;
		
	} // end of method checkFormModifyInvoice
	
	
	
	/**
	 * Este método muestra en el formulario la factura para modificar.
	 * @param invoiceToModify - Facturas, objeto que contiene la factura a modificar
	 */
	
	private void renoveInvoice(Facturas invoiceToModify) {
		
		numberOpB.setSelectedIndex(0);
		textOpB.setText("");
		qttOpB.setText("");
		priceOpB.setText("");
		ivaOpB.setSelectedIndex(0);
		amountOpB.setText("");
		
		cod1B.setText("");
		tex1B.setText("");
		ud1B.setText("");
		price1B.setText("");
		iva1B.setText("");
		imp1B.setText("");
		cod2B.setText("");
		tex2B.setText("");
		ud2B.setText("");
		price2B.setText("");
		iva2B.setText("");
		imp2B.setText("");
		cod3B.setText("");
		tex3B.setText("");
		ud3B.setText("");
		price3B.setText("");
		iva3B.setText("");
		imp3B.setText("");
		cod4B.setText("");
		tex4B.setText("");
		ud4B.setText("");
		price4B.setText("");
		iva4B.setText("");
		imp4B.setText("");
		cod5B.setText("");
		tex5B.setText("");
		ud5B.setText("");
		price5B.setText("");
		iva5B.setText("");
		imp5B.setText("");
		
		baseImpB.setText("");
		cuotaIvaB.setText("");
		retencIRPFB.setText("");
		importeTotalB.setText("");
		
		//  CABECERA
		nameCustomerInvB.setText(invoiceToModify.getNameCustomer());
				
		String fecha=dateEsp.convertDateToString(invoiceToModify.getDateF());
		dateCustomerInvB.setText(fecha);		
		if (serieFact.isEmpty()) {
			numberCustomerInvB.setText(invoiceToModify.getNumber());
		} else {
			numberCustomerInvB.setText(invoiceToModify.getSerial()+"/"+invoiceToModify.getNumber());
		}
		
		// localiza la clave de cliente y busca los albaranes pendientes
		// renovando la lista
		List<String[]> search=new ArrayList<String[]>();
		String cust[]=clienteFac.getCustomer(customerModifying);
		String a[]=new String[2];
		a[0]=cust[1];
		a[1]=cust[2];
		search.add(a);		
		listAlbaranesFacB=albaranes.searchPendingDeliveriesCustomers(search);
		
		// se actualiza el list
		marco2B.setVisible(false);
		marcoInput1B.remove(numberOpB);
		
		numberOpB=new JComboBox<String>();
		numberOpB.addItem("Entrada directa");			
		for (String b[]:listAlbaranesFacB) {
			numberOpB.addItem(b[3]);
		}
		numberOpB.addItemListener(this);
		
		marcoInput1B.add(numberOpB, 0);
		marcoInput1B.revalidate();
		marco2B.setVisible(true);
		marco2B.revalidate();
		
		// DETALLE MOVIMIENTOS
		
		datosFactB=invoiceToModify.getDataInvoice();
		int longData=datosFactB.size();
		if (longData>5) {
			longData=5;
		}
		
		switch (longData) {
		case 5:
			cod5B.setText(datosFactB.get(5)[0]);
			tex5B.setText(datosFactB.get(5)[1]);
			ud5B.setText(datosFactB.get(5)[2]);
			price5B.setText(datosFactB.get(5)[3]);
			iva5B.setText(datosFactB.get(5)[4]);
			imp5B.setText(datosFactB.get(5)[5]);

		case 4:
			cod4B.setText(datosFactB.get(4)[0]);
			tex4B.setText(datosFactB.get(4)[1]);
			ud4B.setText(datosFactB.get(4)[2]);
			price4B.setText(datosFactB.get(4)[3]);
			iva4B.setText(datosFactB.get(4)[4]);
			imp4B.setText(datosFactB.get(4)[5]);

		case 3:
			cod3B.setText(datosFactB.get(3)[0]);
			tex3B.setText(datosFactB.get(3)[1]);
			ud3B.setText(datosFactB.get(3)[2]);
			price3B.setText(datosFactB.get(3)[3]);
			iva3B.setText(datosFactB.get(3)[4]);
			imp3B.setText(datosFactB.get(3)[5]);

		case 2:
			cod2B.setText(datosFactB.get(1)[0]);
			tex2B.setText(datosFactB.get(1)[1]);
			ud2B.setText(datosFactB.get(1)[2]);
			price2B.setText(datosFactB.get(1)[3]);
			iva2B.setText(datosFactB.get(1)[4]);
			imp2B.setText(datosFactB.get(1)[5]);
		
		case 1:
			cod1B.setText(datosFactB.get(0)[0]);
			tex1B.setText(datosFactB.get(0)[1]);
			ud1B.setText(datosFactB.get(0)[2]);
			price1B.setText(datosFactB.get(0)[3]);
			iva1B.setText(datosFactB.get(0)[4]);
			imp1B.setText(datosFactB.get(0)[5]);
			break;
		}
				
		
		// RESUMEN FACTURA
		double bases=invoiceToModify.getBaseImponible0()+invoiceToModify.getBaseImponible1()+invoiceToModify.getBaseImponible2()+invoiceToModify.getBaseImponible3();
		baseImpB.setText(formatoDecimal.format(bases));
		double cuotas=invoiceToModify.getIva1()+invoiceToModify.getIva2()+invoiceToModify.getIva3();
		cuotaIvaB.setText(formatoDecimal.format(cuotas));
		double retenciones=invoiceToModify.getRetencion();
		retencIRPFB.setText(formatoDecimal.format(retenciones));
		importeTotalB.setText(formatoDecimal.format(bases+cuotas-retenciones));
		
		
		
	} // end of renoveInvoice
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	private void newIntro() {
		
		cod5B.setText(cod4B.getText().trim());
		tex5B.setText(tex4B.getText().trim());
		ud5B.setText(ud4B.getText().trim());
		price5B.setText(price4B.getText().trim());
		iva5B.setText(iva4B.getText().trim());
		imp5B.setText(imp4B.getText().trim());
		
		cod4B.setText(cod3B.getText().trim());
		tex4B.setText(tex3B.getText().trim());
		ud4B.setText(ud3B.getText().trim());
		price4B.setText(price3B.getText().trim());
		iva4B.setText(iva3B.getText().trim());
		imp4B.setText(imp3B.getText().trim());
		
		cod3B.setText(cod2B.getText().trim());
		tex3B.setText(tex2B.getText().trim());
		ud3B.setText(ud2B.getText().trim());
		price3B.setText(price2B.getText().trim());
		iva3B.setText(iva2B.getText().trim());
		imp3B.setText(imp2B.getText().trim());
		
		cod2B.setText(cod1B.getText().trim());
		tex2B.setText(tex1B.getText().trim());
		ud2B.setText(ud1B.getText().trim());
		price2B.setText(price1B.getText().trim());
		iva2B.setText(iva1B.getText().trim());
		imp2B.setText(imp1B.getText().trim());
		
		double amount=convertToNumber(qttOpB.getText().trim())*convertToNumber(priceOpB.getText().trim());
		
		String code="";
		if (numberOpB.getSelectedIndex()==0) {
			// seleccionado input direct
			code=CODEDIRECT;
		} else {
			code=numberOpB.getSelectedItem().toString();
		}
		cod1B.setText(code);
		tex1B.setText(textOpB.getText().trim());
		ud1B.setText(qttOpB.getText().trim());
		price1B.setText(priceOpB.getText().trim());
		iva1B.setText(ivaOpB.getSelectedItem().toString());
		imp1B.setText(formatoDecimal.format(amount));
		
		
	} // fin del metodo newIntro
	
	
	
	/**
	 * Este método borra la entrada de lista 'del', moviendo los demás datos hacia arriba en la lista del formulario.
	 * 
	 * @param del - int, posición de la lista del formulario que se desea borrar.
	 */
	
	private void delIntro(int del) {
		
		switch (del) {
			case 1:
				delList(datosFactB,cod1B.getText(),tex1B.getText(),ud1B.getText(),price1B.getText(),iva1B.getText(),imp1B.getText());
				break;
				
			case 2:
				delList(datosFactB,cod2B.getText(),tex2B.getText(),ud2B.getText(),price2B.getText(),iva2B.getText(),imp2B.getText());
				break;
				
			case 3:
				delList(datosFactB,cod3B.getText(),tex3B.getText(),ud3B.getText(),price3B.getText(),iva3B.getText(),imp3B.getText());
				break;
			
			case 4:
				delList(datosFactB,cod4B.getText(),tex4B.getText(),ud4B.getText(),price4B.getText(),iva4B.getText(),imp4B.getText());
				break;
	
			case 5:
				delList(datosFactB,cod5B.getText(),tex5B.getText(),ud5B.getText(),price5B.getText(),iva5B.getText(),imp5B.getText());
				break;
	
			default:
				break;
		}
		
		switch (del) {
			case 1:
				cod1B.setText(cod2B.getText().trim());
				tex1B.setText(tex2B.getText().trim());
				ud1B.setText(ud2B.getText().trim());
				price1B.setText(price2B.getText().trim());
				iva1B.setText(iva2B.getText().trim());
				imp1B.setText(imp2B.getText().trim());
	
			case 2:
				cod2B.setText(cod3B.getText().trim());
				tex2B.setText(tex3B.getText().trim());
				ud2B.setText(ud3B.getText().trim());
				price2B.setText(price3B.getText().trim());
				iva2B.setText(iva3B.getText().trim());
				imp2B.setText(imp3B.getText().trim());
	
			case 3:
				cod3B.setText(cod4B.getText().trim());
				tex3B.setText(tex4B.getText().trim());
				ud3B.setText(ud4B.getText().trim());
				price3B.setText(price4B.getText().trim());
				iva3B.setText(iva4B.getText().trim());
				imp3B.setText(imp4B.getText().trim());
			
			case 4:
				cod4B.setText(cod5B.getText().trim());
				tex4B.setText(tex5B.getText().trim());
				ud4B.setText(ud5B.getText().trim());
				price4B.setText(price5B.getText().trim());
				iva4B.setText(iva5B.getText().trim());
				imp4B.setText(imp5B.getText().trim());
	
			case 5:
				int lengthDatos=datosFactB.size();
				// en el caso de que haya datos fuera de la vista, hay que
				// recuperar el siguiente dato de la lista, que es descendente
				if (lengthDatos>4) {
					cod5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[0]);
					tex5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[1]);
					ud5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[2]);
					price5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[3]);
					iva5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[4]);
					imp5B.setText(datosFactB.get(lengthDatos-LENGTHPANEL)[5]);
				} else {
					cod5B.setText("");
					tex5B.setText("");
					ud5B.setText("");
					price5B.setText("");
					iva5B.setText("");
					imp5B.setText("");
				}
				break;
	
			default:
				break;
		}
		
	} // fin del metodo delIntro
	
	
	
	/**
	 * Este metodo borra del list Lista la grabacion que coincide con los parametros adjuntos.
	 * 
	 * @param lista
	 * @param codigo
	 * @param texto
	 * @param uds
	 * @param precio
	 * @param iva
	 * @param importe
	 */
	
	private void delList(List<String[]> lista, String codigo, String texto, String uds, String precio, String iva, String importe) {
		
		numberOpB.setSelectedIndex(0);
		textOpB.setText(texto);
		qttOpB.setText(uds);
		priceOpB.setText(precio);
		amountOpB.setText(importe);
		ivaOpB.setSelectedItem(iva);
		
		int index=0;
		int thisIndex=999;	// registra el indice a eliminar de la lista, el cual es unico.
		for (String[] n:lista) {
			// solo borra de la lista un dato en el cual coincidan todos los parametros buscados
			if (n[0].equals(codigo) && n[1].equals(texto) && n[2].equals(uds) && n[3].equals(precio) &&
					n[4].equals(iva) && n[5].equals(importe)) {
				thisIndex=index;
			}
			index++;
		}
		if (thisIndex!=999) {
			// elimina el dato localizado
			lista.remove(thisIndex);
		}
		
		
	} // fin del metodo delList
	
	
	
	/**
	 * Este metodo recalcula la base imponible, la cuota de iva y el importe total,
	 * y muestra esos datos en los campos determinados.
	 */
	
	private void calculBases() {
		
		base0B=0;
		base1B=0;
		base2B=0;
		base3B=0;
		cuota1B=0;
		cuota2B=0;
		cuota3B=0;		
		baseIB=0;
		cuotaIB=0;
		retencIB=0;

		tipoIva1B=0;
		tipoIva2B=0;
		tipoIva3B=0;
		
		for (String[] n:datosFactB) {
			
			// nos devuelve la clase de iva
			int tIva=ivas.getClassIva(1, n[4]);
			
			// en funcion de la clase de iva, se incrementa desgloses de iva 
			if (tIva==0) {
				base0B+=convertToNumber(n[5]);
			} else if (tIva==1) {
				tipoIva1B=convertToNumber(n[4])/100;
				base1B+=convertToNumber(n[5]);
				cuota1B+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			} else if (tIva==2) {
				tipoIva2B=convertToNumber(n[4])/100;
				base2B+=convertToNumber(n[5]);
				cuota2B+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			} else {
				tipoIva3B=convertToNumber(n[4])/100;
				base3B+=convertToNumber(n[5]);
				cuota3B+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			}
			baseIB=base0B+base1B+base2B+base3B;
			cuotaIB=cuota1B+cuota2B+cuota3B;				
		}
				
		retencIB=baseIB*(SpringFacturacion.retInvoices/100);
		double totalIB=baseIB+cuotaIB-retencIB;
		
		baseImpB.setText(formatoDecimal.format(baseIB));
		cuotaIvaB.setText(formatoDecimal.format(cuotaIB));
		retencIRPFB.setText(formatoDecimal.format(retencIB));
		importeTotalB.setText(formatoDecimal.format(totalIB));
		
	} // end of calculBases
	
	
	
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
		
		JPanel panelText=new JPanel();
		panelText.setLayout(new BoxLayout(panelText,BoxLayout.Y_AXIS));
		panelText.add(new JLabel(""));
		panelText.add(new JLabel(""));
		JTextArea hText=new JTextArea(
				"1.- Primeramente deberá seleccionar una factura para modificar.\n" +
				"2.- Podrá modificar la fecha de la factura, si lo desea, en formato dd-mm-aaaa.\n" +
				"3.- El sistema muestra el número de factura, y permite modificarla. El sistema\n" +
				"    no comprobará si el número modificado está duplicado o no.\n" +
				"4.- Si lo desea puede modificar los 5 últimos apuntes pulsando en el botón 'M'\n" +
				"    situado al lado del apunte. Los datos se moverán hacia la zona de intro -\n" +
				"    ducción de datos, para que pueda efectuar la modificación o borrar esos\n" +
				"    datos.\n" +
				"5.- Cuando tenga confeccionada la factura, pulse el botón 'Cambiar factura'. La\n" +
				"    aplicación le pedirá la confirmación. En caso afirmativo, La factura habrá \n" +
				"    quedado grabada. A continuación, la aplicación le preguntará si desea imprimir\n" +
				"    la factura en formato PDF. En caso afirmativo se generará un PDF que quedará\n" +
				"    grabado en donde tenga instalada la aplicación. El PDF no se mostrará en \n" +
				"    pantalla automáticamente.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE MODIFICACIÓN FACTURAS"));
		
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
		
		
		if (numberOpB!=null && numberOpB.getSelectedIndex()>0) {
			// si se ha seleccionado un numero de albaran
			
			int index=numberOpB.getSelectedIndex()-1;
			
			String code=listAlbaranesFacB.get(index)[3];
			// hay que detectar si el codigo de albaran esta repetido,
			// excluyendo el codigo CODEDIRECT de entrada directa
			boolean codeNotRepeat=true;
			if (!code.equals(CODEDIRECT)) {
				for (String a[]:datosFactB) {
					if (code.equals(a[0])) {
						codeNotRepeat=false;
					}
				}
			}
			
			if (codeNotRepeat) {
				
				double amount=convertToNumber(listAlbaranesFacB.get(index)[8])*convertToNumber(listAlbaranesFacB.get(index)[9]);
				textOpB.setText(listAlbaranesFacB.get(index)[7]);
				qttOpB.setText(listAlbaranesFacB.get(index)[8]);
				priceOpB.setText(listAlbaranesFacB.get(index)[9]);
				ivaOpB.setSelectedItem(listAlbaranesFacB.get(index)[10]);
				
				String datos[]=new String[7];
				datos[0]=code;
				datos[1]=listAlbaranesFacB.get(index)[7];
				datos[2]=listAlbaranesFacB.get(index)[8];
				datos[3]=listAlbaranesFacB.get(index)[9];
				datos[4]=listAlbaranesFacB.get(index)[10];
				datos[5]=formatoDecimal.format(amount);
				datos[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFacB.get(index)[10]));
				datosFactB.add(datos);
				
				newIntro();				
				calculBases();
				
				if (!listAlbaranesFacB.get(index)[11].isEmpty()) {
					double amount2=convertToNumber(listAlbaranesFacB.get(index)[13])*convertToNumber(listAlbaranesFacB.get(index)[14]);
					textOpB.setText(listAlbaranesFacB.get(index)[12]);
					qttOpB.setText(listAlbaranesFacB.get(index)[13]);
					priceOpB.setText(listAlbaranesFacB.get(index)[14]);
					ivaOpB.setSelectedItem(listAlbaranesFacB.get(index)[15]);
					
					String datos2[]=new String[7];
					datos2[0]=code;
					datos2[1]=listAlbaranesFacB.get(index)[12];
					datos2[2]=listAlbaranesFacB.get(index)[13];
					datos2[3]=listAlbaranesFacB.get(index)[14];
					datos2[4]=listAlbaranesFacB.get(index)[15];
					datos2[5]=formatoDecimal.format(amount2);
					datos2[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFacB.get(index)[15]));
					datosFactB.add(datos2);
					
					newIntro();				
					calculBases();
				}
				
				if (!listAlbaranesFacB.get(index)[16].isEmpty()) {
					double amount3=convertToNumber(listAlbaranesFacB.get(index)[18])*convertToNumber(listAlbaranesFacB.get(index)[19]);
					textOpB.setText(listAlbaranesFacB.get(index)[17]);
					qttOpB.setText(listAlbaranesFacB.get(index)[18]);
					priceOpB.setText(listAlbaranesFacB.get(index)[19]);
					ivaOpB.setSelectedItem(listAlbaranesFacB.get(index)[20]);
					
					String datos3[]=new String[7];
					datos3[0]=code;
					datos3[1]=listAlbaranesFacB.get(index)[17];
					datos3[2]=listAlbaranesFacB.get(index)[18];
					datos3[3]=listAlbaranesFacB.get(index)[19];
					datos3[4]=listAlbaranesFacB.get(index)[20];
					datos3[5]=formatoDecimal.format(amount3);
					datos3[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFacB.get(index)[20]));
					datosFactB.add(datos3);
					
					newIntro();				
					calculBases();
				}
				
			}	
			
		} else if (selCustomerInvB!=null && selCustomerInvB.getSelectedIndex()!=0) {
			
			// si selecciona el cliente
			// se muestra en pantalla, se buscan los albaranes pendientes y se resetea el list
			indexCustomerB=selCustomerInvB.getSelectedIndex()-1;
			nameCustomerInvB.setText(listClientesFacB.get(indexCustomerB)[2]);
			selectedCustomerB=listClientesFacB.get(indexCustomerB)[1];	
			
			// selecciona los albaranes pendientes del cliente
			List<String[]> search=new ArrayList<String[]>();
			String a[]=new String[2];
			a[0]=listClientesFacB.get(indexCustomerB)[1];
			a[1]=listClientesFacB.get(indexCustomerB)[2];
			search.add(a);		
			listAlbaranesFacB=albaranes.searchPendingDeliveriesCustomers(search);
			
			// se actualiza el list
			marco2B.setVisible(false);
			//marco2B.remove(marcoAux1B);
			//marcoAux01B.remove(marcoInput1B);
			
			marcoInput1B.remove(numberOpB);
			
			numberOpB=new JComboBox<String>();
			numberOpB.addItem("Entrada directa");			
			for (String b[]:listAlbaranesFacB) {
				numberOpB.addItem(b[3]);
			}
			numberOpB.addItemListener(this);
			
			marcoInput1B.add(numberOpB, 0);
			marcoInput1B.revalidate();
			
			//marcoAux1B.add(marcoInput1B, 14);
			//marcoAux1B.revalidate();
			
			//marco2B.add(marcoAux1B,1);
			marco2B.setVisible(true);
			marco2B.revalidate();
		
		} else if (selInvoiceB!=null && selInvoiceB.getSelectedIndex()!=0 ) {
			
			// si se ha seleccionado factura
			// se coge el numero, se buscan los datos y se muestra en formulario
			String data=String.valueOf(selInvoiceB.getSelectedItem());
			invoiceToModify=facturador.getInvoice(data);
			
			customerModifying=invoiceToModify.getCodeCustomer();
			renoveInvoice(invoiceToModify);
			
						
			//selCustomerInvB.setSelectedItem(nameCustomerInvB.getText());
			
		} 
		
		
		if (e.getItem().toString().equals("Seleccione número...")) {
			
			// Eliminando la parte grafica
			// borra el formulario
			selCustomerInvB.setSelectedIndex(0);
			nameCustomerInvB.setText("");
			
			numberOpB.setSelectedIndex(0);
			numberCustomerInvB.setText("");
			textOpB.setText("");
			qttOpB.setText("");
			priceOpB.setText("");
			ivaOpB.setSelectedIndex(0);
			amountOpB.setText("");
			dateCustomerInvB.setText("");		
			
			cod1B.setText("");
			tex1B.setText("");
			ud1B.setText("");
			price1B.setText("");
			iva1B.setText("");
			imp1B.setText("");
			cod2B.setText("");
			tex2B.setText("");
			ud2B.setText("");
			price2B.setText("");
			iva2B.setText("");
			imp2B.setText("");
			cod3B.setText("");
			tex3B.setText("");
			ud3B.setText("");
			price3B.setText("");
			iva3B.setText("");
			imp3B.setText("");
			cod4B.setText("");
			tex4B.setText("");
			ud4B.setText("");
			price4B.setText("");
			iva4B.setText("");
			imp4B.setText("");
			cod5B.setText("");
			tex5B.setText("");
			ud5B.setText("");
			price5B.setText("");
			iva5B.setText("");
			imp5B.setText("");
			
			baseImpB.setText("");
			cuotaIvaB.setText("");
			importeTotalB.setText("");
			
			
		} // end of seleccione número
		
	} // end of method itemChanged


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("intro")) {
			
			if (checkFormModifyInvoice()) {
				
				String code="";
				if (numberOpB.getSelectedIndex()==0) {
					// seleccionado input direct
					code=CODEDIRECT;
				} else {
					code=numberOpB.getSelectedItem().toString();
				}

				double amount=convertToNumber(qttOpB.getText().trim())*convertToNumber(priceOpB.getText().trim());
				amountOpB.setText(formatoDecimal.format(amount));
							
				String datos[]=new String[7];
				datos[0]=code;
				datos[1]=textOpB.getText().trim();
				datos[2]=qttOpB.getText().trim();
				datos[3]=priceOpB.getText().trim();
				datos[4]=ivaOpB.getSelectedItem().toString();
				datos[5]=formatoDecimal.format(amount);
				datos[6]=String.valueOf(ivaOpB.getSelectedIndex());
				
				datosFactB.add(datos);
				
				newIntro();
				
				calculBases();				
						
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en datos a grabar", "Error en factura", JOptionPane.ERROR_MESSAGE);
			}
			
		} // END OF INTRODATOS
		
		
		if (source.equals("M")) {
			/*
			 * Segun el boton pulsado:
			 *    Primero se elimina el dato de la lista de articulos grabados en la factura
			 *    Luego se procede a cambiar el albaran a pendiente, si es que es un albaran grabado
			 *    Si el albaran es grabado, se actualiza la lista del selector de albaranes
			 *    Por ultimo se recalculan las bases
			 */
			
			boolean albaranGrabado=false;
			
			if (e.getSource()==delF1B) {			
				// si el albaran no es de introduccion directa cambia el estado del albaran
				if (!cod1B.getText().trim().equals(CODEDIRECT)) {
					
					if (!albaranes.changeToPendingState(cod1B.getText().trim())) {					
						// si algun albaran no pudo pasar a pendiente por error
						JOptionPane.showMessageDialog(mainFrame, "Este albarán no pudo dejarse pendiente.","Modificación de facturas",JOptionPane.ERROR_MESSAGE);
					} else {
						albaranGrabado=true;
					}
				}
				delIntro(1);
				calculBases();
			}
			
			if (e.getSource()==delF2B) {
				
				// si el albaran no es de introduccion directa cambia el estado del albaran
				if (!cod2B.getText().trim().equals(CODEDIRECT)) {
					
					if (!albaranes.changeToPendingState(cod2B.getText().trim())) {
						// si algun albaran no pudo pasar a pendiente por error
						JOptionPane.showMessageDialog(mainFrame, "Este albarán no pudo dejarse pendiente.","Modificación de facturas",JOptionPane.ERROR_MESSAGE);
					} else {
						albaranGrabado=true;
					}
				}			
				delIntro(2);
				calculBases();
			}
			
			if (e.getSource()==delF3B) {
				
				// si el albaran no es de introduccion directa cambia el estado del albaran
				if (!cod3B.getText().trim().equals(CODEDIRECT)) {
					if (!albaranes.changeToPendingState(cod3B.getText().trim())) {
						// si algun albaran no pudo pasar a pendiente por error
						JOptionPane.showMessageDialog(mainFrame, "Este albarán no pudo dejarse pendiente.","Modificación de facturas",JOptionPane.ERROR_MESSAGE);
					} else {
						albaranGrabado=true;
					}
				}	
				delIntro(3);
				calculBases();
			}
			
			if (e.getSource()==delF4B) {
				
				// si el albaran no es de introduccion directa cambia el estado del albaran
				if (!cod4B.getText().trim().equals(CODEDIRECT)) {
					if (!albaranes.changeToPendingState(cod4B.getText().trim())) {
						// si algun albaran no pudo pasar a pendiente por error
						JOptionPane.showMessageDialog(mainFrame, "Este albarán no pudo dejarse pendiente.","Modificación de facturas",JOptionPane.ERROR_MESSAGE);
					} else {
						albaranGrabado=true;
					}
				}	
				delIntro(4);
				calculBases();
			}
			
			if (e.getSource()==delF5B) {
				
				// si el albaran no es de introduccion directa cambia el estado del albaran
				if (!cod5B.getText().trim().equals(CODEDIRECT)) {
					if (!albaranes.changeToPendingState(cod5B.getText().trim())) {
						// si algun albaran no pudo pasar a pendiente por error
						JOptionPane.showMessageDialog(mainFrame, "Este albarán no pudo dejarse pendiente.","Modificación de facturas",JOptionPane.ERROR_MESSAGE);
					} else {
						albaranGrabado=true;
					}
				}		
				delIntro(5);
				calculBases();
			}
			
			// Se renueva la lista de albaranes pendientes, si es que es un albaran grabado
			if (albaranGrabado) {
				
				marco2B.setVisible(false);
				marco2B.remove(marcoAux1B);
				marcoAux01B.remove(marcoInput1B);
				
				marcoInput1B.remove(numberOpB);
				
				// localiza la clave de cliente y busca los albaranes pendientes
				List<String[]> search=new ArrayList<String[]>();
				String cust[]=clienteFac.getCustomer(customerModifying);
				String a[]=new String[2];
				a[0]=cust[1];
				a[1]=cust[2];
				search.add(a);		
				listAlbaranesFacB=albaranes.searchPendingDeliveriesCustomers(search);
				
				numberOpB=new JComboBox<String>();
				numberOpB.addItem("Entrada directa");			
				for (String b[]:listAlbaranesFacB) {
					numberOpB.addItem(b[3]);
				}
				numberOpB.addItemListener(this);
				
				marcoInput1B.add(numberOpB, 0);
				marcoInput1B.revalidate();
				
				marcoAux1B.add(marcoInput1B, 14);
				marcoAux1B.revalidate();
				
				marco2B.add(marcoAux1B,1);
				marco2B.setVisible(true);
				marco2B.revalidate();
			}

			
		} // END OF M
		
		
		if (source.equals("Cambiar factura")) {	
			
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea modificar la factura mostrada en el formulario?", "Grabación de la factura", JOptionPane.YES_NO_OPTION)==0) {
				
				// vuelve a calcular las bases
				calculBases();
				
				// creacion del objeto factura
				//Facturas datosF=new Facturas();
				String numbIv=numberCustomerInvB.getText().trim();
				numbIv=numbIv.substring(numbIv.length()-6);
				datosF.setNumber(numbIv);
				datosF.setSerial(SpringFacturacion.serialInvoices);
				String dateToRecord=dateCustomerInvB.getText().trim().substring(6)+dateCustomerInvB.getText().trim().substring(2,6)+dateCustomerInvB.getText().trim().substring(0,2);
				datosF.setDateF(Date.valueOf(dateToRecord));
				datosF.setCodeCompany(SpringFacturacion.idCompany);
				datosF.setNameCompany(SpringFacturacion.nameCompany);
				datosF.setAddressCompany(SpringFacturacion.addressCompany);
				datosF.setPostalCompany(SpringFacturacion.cpostalCompany);
				datosF.setCityCompany(SpringFacturacion.cityCompany);
				datosF.setNifCompany(SpringFacturacion.nifCompany);
				
				selectedCustomerB=listClientesFacB.get(indexCustomerB)[1];
				datosF.setCodeCustomer(selectedCustomerB);
				datosF.setNameCustomer(nameCustomerInvB.getText().trim());
				
				datosF.setAddressCustomer(listClientesFacB.get(indexCustomerB)[3]);
				datosF.setPostalCustomer(listClientesFacB.get(indexCustomerB)[4]);
				datosF.setCityCustomer(listClientesFacB.get(indexCustomerB)[5]);
				datosF.setNifCustomer(listClientesFacB.get(indexCustomerB)[6]);
				
				datosF.setBaseImponible0(base0B);
				datosF.setBaseImponible1(base1B);
				datosF.setTipoIva1(tipoIva1B);
				datosF.setIva1(cuota1B);
				datosF.setBaseImponible2(base2B);
				datosF.setTipoIva2(tipoIva2B);
				datosF.setIva2(cuota2B);
				datosF.setBaseImponible3(base3B);
				datosF.setTipoIva3(tipoIva3B);
				datosF.setIva3(cuota3B);
				datosF.setTipoRet(SpringFacturacion.retInvoices);
				datosF.setRetencion(retencIB);
				datosF.setTotalFactura(baseIB+cuotaIB-retencIB);

				String paiment=listClientesFacB.get(indexCustomerB)[7];
				datosF.setDiaPago("");
				if (paiment!=null && !paiment.isEmpty()) {
					String datosPago[]=formaPago.getPago(paiment);
					datosF.setFormaPago(datosPago[2]);
					if (!datosPago[3].isEmpty() && !datosPago[3].equals("0")) {
						int diaPago=0;
						try {
							diaPago=(int)Integer.valueOf(datosPago[4]);
						} catch (NumberFormatException nf) {
							diaPago=0;
						}
						int aplaz=0;
						try {
							aplaz=(int)Integer.valueOf(datosPago[3]);
						} catch (NumberFormatException nf) {
							aplaz=0;
						}						
						datosF.setDiaPago(dateEsp.paymentDay(dateCustomerInvB.getText().trim(), aplaz, diaPago));
					}
					
				} else {
					datosF.setFormaPago("");
				}
				
				datosF.setDataInvoice(datosFactB);
				
				// grabando la factura
				//factura=new FacturasBean();
				if (facturador.modifyInvoice(datosF.getNumber(), datosF.getSerial(),datosF)) {
					JOptionPane.showMessageDialog(mainFrame, "Factura grabada correctamente","Grabación de facturas",JOptionPane.INFORMATION_MESSAGE);
				
					// cambiando el numero de factura				
					if (numbIv.equals(String.valueOf(SpringFacturacion.lastInvoiceNumber+1))) {
						SpringFacturacion.lastInvoiceNumber=SpringFacturacion.lastInvoiceNumber+1;
					} 
					nextNumberFactB=formatoFactura.format(SpringFacturacion.lastInvoiceNumber+1);
					
					if (serieFact.isEmpty()) {
						numberCustomerInvB.setText(nextNumberFactB);
					} else {
						numberCustomerInvB.setText(serieFact+"/"+nextNumberFactB);
					}
					
					// eliminando la lista
					datosFactB=new ArrayList<String[]>();
					
					// Eliminando la parte grafica
					selCustomerInvB.setSelectedIndex(0);
					nameCustomerInvB.setText("");
					
					numberOpB.setSelectedIndex(0);
					textOpB.setText("");
					qttOpB.setText("");
					priceOpB.setText("");
					ivaOpB.setSelectedIndex(0);
					amountOpB.setText("");
					
					cod1B.setText("");
					tex1B.setText("");
					ud1B.setText("");
					price1B.setText("");
					iva1B.setText("");
					imp1B.setText("");
					cod2B.setText("");
					tex2B.setText("");
					ud2B.setText("");
					price2B.setText("");
					iva2B.setText("");
					imp2B.setText("");
					cod3B.setText("");
					tex3B.setText("");
					ud3B.setText("");
					price3B.setText("");
					iva3B.setText("");
					imp3B.setText("");
					cod4B.setText("");
					tex4B.setText("");
					ud4B.setText("");
					price4B.setText("");
					iva4B.setText("");
					imp4B.setText("");
					cod5B.setText("");
					tex5B.setText("");
					ud5B.setText("");
					price5B.setText("");
					iva5B.setText("");
					imp5B.setText("");
					
					baseImpB.setText("");
					cuotaIvaB.setText("");
					importeTotalB.setText("");
			
					if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea generar un pdf de la factura?", "Impresión de la factura", JOptionPane.YES_NO_OPTION)==0) {
						if (dataList.getInvoice("Factura"+datosF.getSerial()+datosF.getNumber(), datosF)) {
							JOptionPane.showMessageDialog(mainFrame, "Generado el pdf de la factura","Impresión de la factura",JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error: no ha sido posible generar el pdf","Impresión de la factura",JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en modificación de factura","Grabación de facturas",JOptionPane.ERROR_MESSAGE);
				}
			}		
		}	 //END OF MODIFICAR FACTURA
		
		
		
		if (source.equals("Borrar datos")) {
			
			// Eliminando la parte grafica
			selCustomerInvB.setSelectedIndex(0);
			nameCustomerInvB.setText("");
			
			numberOpB.setSelectedIndex(0);
			numberCustomerInvB.setText("");
			textOpB.setText("");
			qttOpB.setText("");
			priceOpB.setText("");
			ivaOpB.setSelectedIndex(0);
			amountOpB.setText("");
			dateCustomerInvB.setText("");
			
			
			cod1B.setText("");
			tex1B.setText("");
			ud1B.setText("");
			price1B.setText("");
			iva1B.setText("");
			imp1B.setText("");
			cod2B.setText("");
			tex2B.setText("");
			ud2B.setText("");
			price2B.setText("");
			iva2B.setText("");
			imp2B.setText("");
			cod3B.setText("");
			tex3B.setText("");
			ud3B.setText("");
			price3B.setText("");
			iva3B.setText("");
			imp3B.setText("");
			cod4B.setText("");
			tex4B.setText("");
			ud4B.setText("");
			price4B.setText("");
			iva4B.setText("");
			imp4B.setText("");
			cod5B.setText("");
			tex5B.setText("");
			ud5B.setText("");
			price5B.setText("");
			iva5B.setText("");
			imp5B.setText("");
			
			baseImpB.setText("");
			cuotaIvaB.setText("");
			importeTotalB.setText("");
			
		} // end of borrar
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
		
	}
	
	
	

} // ************** END OF CLASS
