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

import main.SpringFacturacion;

import beansControls.AlbaranesBean;
import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansControls.FacturasBean;
import beansControls.PagosBean;
import beansControls.TiposIvaBean;
import beansControls.UtilsFacturacion;
import beansList.ListadosPdf;
import beansModels.Facturas;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicesCreating extends UtilsFacturacion implements ActionListener, ItemListener {
	
	// spring objects
	private ClockAndDate dateEsp;
	private TiposIvaBean ivas;
	private ClientesBean clienteFac;
	private Facturas datosF;
	private FacturasBean facturador;
	private ListadosPdf dataList;
	private AlbaranesBean albaranes;
	private PagosBean formaPago;

	private JFrame mainFrame;
	
	// CREAR FACTURAS
	private JPanel marco2;
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	private JPanel marcoHead1;
	private JPanel marcoHead2;
	private JPanel marcoHead3;
	private JPanel marcoInput1;
	private JPanel marcoInput2;
	private JPanel marcoAux01;
	private JPanel marcoAux02;	
	private JPanel marcoAux11;
	private JPanel marcoAux11_B;
	private JPanel marcoAux12;
	private JPanel marcoAux21;
	private JPanel marcoAux21_B;
	private JPanel marcoAux22;
	private JPanel marcoAux31;
	private JPanel marcoAux31_B;
	private JPanel marcoAux32;
	private JPanel marcoAux41;
	private JPanel marcoAux41_B;
	private JPanel marcoAux42;
	private JPanel marcoAux51;
	private JPanel marcoAux51_B;
	private JPanel marcoAux52;
	private JPanel marcoAux61;
	private JPanel marcoAux62;
	private JPanel marcoAux71;
	private JPanel marcoAux72;
	
	private JComboBox<String> selCustomerInv;
	private JTextField nameCustomerInv;
	private JTextField dateCustomerInv;
	private JTextField numberCustomerInv;
	
	private JComboBox<String> numberOp;
	private JTextField textOp;
	private JTextField qttOp;
	private JTextField priceOp;	
	private JComboBox<String> ivaOp;
	private JTextField amountOp;		
	
	private final int LENGTHPANEL=5;
	private JTextField cod1;
	private JTextField tex1;
	private JTextField ud1;
	private JTextField price1;
	private JTextField iva1;
	private JTextField imp1;
	private JTextField cod2;
	private JTextField tex2;
	private JTextField ud2;
	private JTextField price2;
	private JTextField iva2;
	private JTextField imp2;
	private JTextField cod3;
	private JTextField tex3;
	private JTextField ud3;
	private JTextField price3;
	private JTextField iva3;
	private JTextField imp3;
	private JTextField cod4;
	private JTextField tex4;
	private JTextField ud4;
	private JTextField price4;
	private JTextField iva4;
	private JTextField imp4;
	private JTextField cod5;
	private JTextField tex5;
	private JTextField ud5;
	private JTextField price5;
	private JTextField iva5;
	private JTextField imp5;
	
	private double tipoIva1;
	private double tipoIva2;
	private double tipoIva3;
	private double baseI=0;
	private double cuotaI=0;
	private double retencI=0;
	private double base0=0;
	private double base1=0;
	private double base2=0;
	private double base3=0;
	private double cuota1=0;
	private double cuota2=0;
	private double cuota3=0;
	private JTextField baseImp;
	private JTextField cuotaIva;
	private JTextField retencIRPF;
	private JTextField importeTotal;
	
	private JButton anadirF;
	private JButton delF1;
	private JButton delF2;
	private JButton delF3;
	private JButton delF4;
	private JButton delF5;
	private JButton grabarF;
	private JButton borrarF;
	private JButton info;
	
	private List<String[]> listClientesFac;			// lista de clientes
	private List<String[]> listAlbaranesFac;		// lista de albaranes pendientes de facturar
	private int indexCustomer;
	
	// DATOS DE LA FACTURA EN CREACION
	private List<String[]> datosFact;				// lista de los datos facturados
	private String serieFact;					// Num. de serie de factura
	private String nextNumberFact;					// Num. de factura (num�rico)
	private String selectedCustomer;				// key del cliente a facturar	
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private final Color ERRORFORM=Color.RED;  // color de casilla erronea en formulario
	private final Color OKFORM=Color.WHITE;   // color de casilla correcta en formulario
	private final Color COLORL=Color.BLACK;
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	private final String CODEDIRECT="999999";	// codigo de entrada directa (no albaran grabado)
	
	
	
	
	public PanelInvoicesCreating() {
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
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	
	public void setFormaPago (PagosBean formaPago) {
		// spring
		this.formaPago=formaPago;
	}
	
	
	
	/**
	 * M�todo que suministra el panel de factura con sus componentes.
	 * 
	 * @return - un JPanel componiendo la pantalla de factura
	 */
	
	public JPanel makeInvoice(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0=new JPanel();
		Dimension panDim0=new Dimension(650,55);
		marcoAux0.setMinimumSize(panDim0);
		marcoAux0.setPreferredSize(panDim0);
		marcoAux0.setMaximumSize(panDim0);
		
		Dimension panDim1=new Dimension(650,450);
		marcoAux1=new JPanel();
		marcoAux1.setMinimumSize(panDim1);
		marcoAux1.setPreferredSize(panDim1);
		marcoAux1.setMaximumSize(panDim1);
		
		// se instancia el list que acumula los datos
		datosFact=new ArrayList<String[]>();
		
		// titulo
		JLabel title=new JLabel("                          FACTURACI�N - CREACI�N                      ");
		title.setFont(font1);
		// creamos el formulario
		
		// cabecera
		selCustomerInv=new JComboBox<String>();
		selCustomerInv.addItem("Seleccione cliente...");
		//clienteFac=new ClientesBean();
		listClientesFac=clienteFac.getListCustomers();
		if (listClientesFac==null) {
			listClientesFac=new ArrayList<String[]>();
		}
		for (String[] data: listClientesFac) {
			selCustomerInv.addItem(data[2]);
		}
		nameCustomerInv=new JTextField("");
		
		nameCustomerInv.setEditable(false);		
		
		dateCustomerInv=new JTextField(dateEsp.getDate());
		dateCustomerInv.setToolTipText("OBLIGATORIO: formato dd-mm-aaaa");

		serieFact=SpringFacturacion.serialInvoices;
		nextNumberFact=formatoFactura.format(SpringFacturacion.lastInvoiceNumber+1);
		if (serieFact.isEmpty()) {
			numberCustomerInv=new JTextField(nextNumberFact);
		} else {
			numberCustomerInv=new JTextField(serieFact+"/"+nextNumberFact);
		}
		
		numberCustomerInv.setToolTipText("OBLIGATORIO: m�x 15 caracteres");	
		
		// zona inputs
		numberOp=new JComboBox<String>();
		numberOp.addItem("Entrada directa");
		textOp=new JTextField();
		textOp.setToolTipText("OBLIGATORIO: m�ximo 200 caracteres");
		qttOp=new JTextField();
		qttOp.setToolTipText("campo num�rico");
		priceOp=new JTextField();
		priceOp.setToolTipText("campo num�rico");
		
		ivaOp=new JComboBox<String>();
		//ivas=new TiposIvaBean();
		List<String[]> listIv;
		if ((listIv=ivas.getListIva())==null) {
			listIv=new ArrayList<String[]>();
			//listIv.add(new String[7]);
		}
		for (String[] a:listIv) {
			if (!(a[1].equals("0") || a[4].equals("2"))) {
				// si el iva no esta inactivo ni es de compras lo a�ade
				// pero por orden de clase de iva			
				//ivaOp.add(new JLabel(a[3]),(int)Integer.parseInt(a[5]));
				ivaOp.addItem(a[3]);
			}
		}
		
		amountOp=new JTextField();
		//amountOp.setToolTipText("campo num�rico");
		amountOp.setEnabled(false);
		
		anadirF=new JButton("intro");
		anadirF.setToolTipText("pulse para incorporar datos");
		
		marcoHead1=new JPanel();
		marcoHead2=new JPanel();
		marcoHead3=new JPanel();
		marcoInput1=new JPanel();
		marcoInput2=new JPanel();
		marcoAux01=new JPanel();
		marcoAux02=new JPanel();
		marcoAux11=new JPanel();
		marcoAux11_B=new JPanel();
		marcoAux12=new JPanel();
		marcoAux21=new JPanel();
		marcoAux21_B=new JPanel();
		marcoAux22=new JPanel();
		marcoAux31=new JPanel();
		marcoAux31_B=new JPanel();
		marcoAux32=new JPanel();
		marcoAux41=new JPanel();
		marcoAux41_B=new JPanel();
		marcoAux42=new JPanel();
		marcoAux51=new JPanel();
		marcoAux51_B=new JPanel();
		marcoAux52=new JPanel();
		marcoAux61=new JPanel();
		marcoAux62=new JPanel();
		marcoAux71=new JPanel();
		marcoAux72=new JPanel();

		marcoHead1.setLayout(new GridLayout(1,2));
		marcoHead2.setLayout(new GridLayout(1,2));
		marcoHead3.setLayout(new GridLayout(1,2));
		marcoInput1.setLayout(new GridLayout(1,2));
		marcoInput2.setLayout(new GridLayout(1,4));
		marcoAux01.setLayout(new GridLayout(1,2));
		marcoAux02.setLayout(new GridLayout(1,4));		
		marcoAux11.setLayout(new GridLayout(1,2));
		marcoAux11_B.setLayout(new BoxLayout(marcoAux11_B,BoxLayout.X_AXIS));
		marcoAux12.setLayout(new GridLayout(1,4));
		marcoAux21.setLayout(new GridLayout(1,2));
		marcoAux21_B.setLayout(new BoxLayout(marcoAux21_B,BoxLayout.X_AXIS));
		marcoAux22.setLayout(new GridLayout(1,4));
		marcoAux31.setLayout(new GridLayout(1,2));
		marcoAux31_B.setLayout(new BoxLayout(marcoAux31_B,BoxLayout.X_AXIS));
		marcoAux32.setLayout(new GridLayout(1,4));
		marcoAux41.setLayout(new GridLayout(1,2));
		marcoAux41_B.setLayout(new BoxLayout(marcoAux41_B,BoxLayout.X_AXIS));
		marcoAux42.setLayout(new GridLayout(1,4));
		marcoAux51.setLayout(new GridLayout(1,2));
		marcoAux51_B.setLayout(new BoxLayout(marcoAux51_B,BoxLayout.X_AXIS));
		marcoAux52.setLayout(new GridLayout(1,4));
		marcoAux61.setLayout(new GridLayout(1,2));
		marcoAux62.setLayout(new GridLayout(1,2));
		marcoAux71.setLayout(new GridLayout(1,1));
		marcoAux72.setLayout(new GridLayout(1,3));
		
		cod1=new JTextField("");
		cod1.setEditable(false);
		tex1=new JTextField("");
		tex1.setEditable(false);
		ud1=new JTextField("");
		ud1.setEditable(false);
		price1=new JTextField("");
		price1.setEditable(false);
		iva1=new JTextField("");
		iva1.setEditable(false);
		imp1=new JTextField("");
		imp1.setEditable(false);
		cod2=new JTextField("");
		cod2.setEditable(false);
		tex2=new JTextField("");
		tex2.setEditable(false);
		ud2=new JTextField("");
		ud2.setEditable(false);
		price2=new JTextField("");
		price2.setEditable(false);
		iva2=new JTextField("");
		iva2.setEditable(false);
		imp2=new JTextField("");
		imp2.setEditable(false);
		cod3=new JTextField("");
		cod3.setEditable(false);
		tex3=new JTextField("");
		tex3.setEditable(false);
		ud3=new JTextField("");
		ud3.setEditable(false);
		price3=new JTextField("");
		price3.setEditable(false);
		iva3=new JTextField("");
		iva3.setEditable(false);
		imp3=new JTextField("");
		imp3.setEditable(false);
		cod4=new JTextField("");
		cod4.setEditable(false);
		tex4=new JTextField("");
		tex4.setEditable(false);
		ud4=new JTextField("");
		ud4.setEditable(false);
		price4=new JTextField("");
		price4.setEditable(false);
		iva4=new JTextField("");
		iva4.setEditable(false);
		imp4=new JTextField("");
		imp4.setEditable(false);
		cod5=new JTextField("");
		cod5.setEditable(false);
		tex5=new JTextField("");
		tex5.setEditable(false);
		ud5=new JTextField("");
		ud5.setEditable(false);
		price5=new JTextField("");
		price5.setEditable(false);
		iva5=new JTextField("");
		iva5.setEditable(false);
		imp5=new JTextField("");
		imp5.setEditable(false);
		
		Dimension dim=new Dimension(45,20);	
		delF1=new JButton("X");
		delF1.setPreferredSize(dim);
		delF1.setMaximumSize(dim);
		delF1.setMinimumSize(dim);
		delF1.setToolTipText("Borrar este apunte");
		
		delF2=new JButton("X");		
		delF2.setPreferredSize(dim);
		delF2.setMaximumSize(dim);
		delF2.setMinimumSize(dim);
		delF2.setToolTipText("Borrar este apunte");
		
		delF3=new JButton("X");	
		delF3.setPreferredSize(dim);
		delF3.setMaximumSize(dim);
		delF3.setMinimumSize(dim);
		delF3.setToolTipText("Borrar este apunte");
		
		delF4=new JButton("X");		
		delF4.setPreferredSize(dim);
		delF4.setMaximumSize(dim);
		delF4.setMinimumSize(dim);
		delF4.setToolTipText("Borrar este apunte");
		
		delF5=new JButton("X");	
		delF5.setPreferredSize(dim);
		delF5.setMaximumSize(dim);
		delF5.setMinimumSize(dim);
		delF5.setToolTipText("Borrar este apunte");
		
		baseImp=new JTextField("");
		cuotaIva=new JTextField("");
		retencIRPF=new JTextField("");
		if (SpringFacturacion.retInvoices==0) {
			retencIRPF=new JTextField("0,00");
			retencIRPF.setEnabled(false);
		}
		importeTotal=new JTextField("");

		marcoHead1.add(selCustomerInv);
		marcoHead1.add(nameCustomerInv);
		marcoHead2.add(new JLabel("Fecha: (dd-mm-aaaa)"));
		marcoHead2.add(dateCustomerInv);
		marcoHead3.add(new JLabel("N�mero:"));
		marcoHead3.add(numberCustomerInv);
		
		marcoAux01.add(new JLabel("c�digo"));
		marcoAux01.add(new JLabel("   texto"));
		marcoAux02.add(new JLabel("     uds."));
		marcoAux02.add(new JLabel("   importe"));
		marcoAux02.add(new JLabel("     iva"));
		marcoAux02.add(new JLabel(""));
		marcoInput1.add(numberOp);
		marcoInput1.add(textOp);
		marcoInput2.add(qttOp);
		marcoInput2.add(priceOp);
		marcoInput2.add(ivaOp);
		marcoInput2.add(anadirF);
		marcoAux11_B.add(delF1);
		marcoAux11_B.add(cod1);
		marcoAux11.add(marcoAux11_B);
		marcoAux11.add(tex1);
		marcoAux12.add(ud1);
		marcoAux12.add(price1);
		marcoAux12.add(iva1);
		marcoAux12.add(imp1);
		marcoAux21_B.add(delF2);
		marcoAux21_B.add(cod2);
		marcoAux21.add(marcoAux21_B);
		marcoAux21.add(tex2);
		marcoAux22.add(ud2);
		marcoAux22.add(price2);
		marcoAux22.add(iva2);
		marcoAux22.add(imp2);
		marcoAux31_B.add(delF3);
		marcoAux31_B.add(cod3);
		marcoAux31.add(marcoAux31_B);
		marcoAux31.add(tex3);
		marcoAux32.add(ud3);
		marcoAux32.add(price3);
		marcoAux32.add(iva3);
		marcoAux32.add(imp3);
		marcoAux41_B.add(delF4);
		marcoAux41_B.add(cod4);
		marcoAux41.add(marcoAux41_B);
		marcoAux41.add(tex4);
		marcoAux42.add(ud4);
		marcoAux42.add(price4);
		marcoAux42.add(iva4);
		marcoAux42.add(imp4);
		marcoAux51_B.add(delF5);
		marcoAux51_B.add(cod5);
		marcoAux51.add(marcoAux51_B);
		marcoAux51.add(tex5);
		marcoAux52.add(ud5);
		marcoAux52.add(price5);
		marcoAux52.add(iva5);
		marcoAux52.add(imp5);
		marcoAux61.add(baseImp);
		marcoAux61.add(cuotaIva);
		marcoAux62.add(retencIRPF);
		marcoAux62.add(importeTotal);
		
		// preparamos los botones 
		grabarF=new JButton("Grabar factura");
		grabarF.setToolTipText("pulse para grabar la factura");
		borrarF=new JButton("Borrar datos");
		borrarF.setToolTipText("pulse para borrar el formulario");
		
		ImageIcon icon = new ImageIcon("src/images/info.png");
		info=new JButton(icon);
		info.setBorderPainted(true);
		info.setContentAreaFilled(false);
		Insets m=new Insets(0,0,0,0);
		info.setMargin(m);
		info.setToolTipText("pulse para informaci�n");
		info.setActionCommand("info");
		JPanel panelButton3=new JPanel();
		panelButton3.setLayout(new FlowLayout());
		panelButton3.add(new JLabel());
		marcoAux0.setAlignmentY(JPanel.RIGHT_ALIGNMENT);
		panelButton3.add(info);
		Dimension dimP=new Dimension(60,40);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);
		
		marcoAux71.add(new JLabel());
		marcoAux72.add(grabarF);
		marcoAux72.add(new JLabel());
		marcoAux72.add(borrarF);

		// a�adimos todos los elementos a los JPanel auxiliares
		marcoAux0.add(title);
		marcoAux0.add(panelButton3);
		
		marcoAux1.setLayout(new GridLayout(18,2));
		
		marcoAux1.add(marcoHead1);
		marcoAux1.add(new JLabel(""));	
		marcoAux1.add(marcoHead2);
		marcoAux1.add(new JLabel(""));		
		marcoAux1.add(marcoHead3);
		marcoAux1.add(new JLabel(""));

		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" INTRODUCCI�N DE DATOS:"));
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(marcoAux01);
		marcoAux1.add(marcoAux02);
		marcoAux1.add(marcoInput1);
		marcoAux1.add(marcoInput2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel("VISUALIZACI�N �LTIMOS APUNTES"));
		marcoAux1.add(new JLabel(" "));		
		marcoAux1.add(marcoAux11);
		marcoAux1.add(marcoAux12);		
		marcoAux1.add(marcoAux21);
		marcoAux1.add(marcoAux22);
		marcoAux1.add(marcoAux31);
		marcoAux1.add(marcoAux32);
		marcoAux1.add(marcoAux41);
		marcoAux1.add(marcoAux42);
		marcoAux1.add(marcoAux51);
		marcoAux1.add(marcoAux52);
		
		marcoAux1.add(new JLabel("   Base Imponible                                    Cuota iva"));
		marcoAux1.add(new JLabel("  Retenci�n                                               Importe total IVA incluido"));
		marcoAux1.add(marcoAux61);
		marcoAux1.add(marcoAux62);
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(marcoAux71);
		marcoAux1.add(marcoAux72);
		
		
		// a�adimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0,BorderLayout.NORTH);
		marco2.add(marcoAux1,BorderLayout.CENTER);
		marco2.add(new JLabel("     "),BorderLayout.EAST);
		marco2.add(new JLabel("     "),BorderLayout.WEST);
		marco2.add(new JLabel("     "),BorderLayout.SOUTH);
		
		// le a�adimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		selCustomerInv.addItemListener(this);
		numberOp.addItemListener(this);
		
		borrarF.addActionListener(this);
		grabarF.addActionListener(this);
		anadirF.addActionListener(this);
		info.addActionListener(this);
		delF1.addActionListener(this);
		delF2.addActionListener(this);
		delF3.addActionListener(this);
		delF4.addActionListener(this);
		delF5.addActionListener(this);
		
		return marco2;
				
	} // end of method makeInvoice
		
	
	
	/**
	 * Este m�todo realiza un chequeo de los datos de la factura. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de creaci�n facturas.
	 * 
	 * @return boolean TRUE or FALSE seg�n el formulario est� correcto o haya errores.
	 */
	
	private boolean checkFinalForm () {
		
		boolean result=true;
		
		nameCustomerInv.setBackground(OKFORM);
		dateCustomerInv.setBackground(OKFORM);
		numberCustomerInv.setBackground(OKFORM);
		importeTotal.setBackground(OKFORM);
		
		if (nameCustomerInv.getText().trim().isEmpty()) {
			nameCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
				
		if (!dateEsp.checkDate(dateCustomerInv.getText().trim())) {
			dateCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
		
		if (numberCustomerInv.getText().trim().isEmpty()) {
			numberCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
		
		// Si no hay texto en tex1 es que la factura est� en blanco. No se admiten facturas sin importe

		if (tex1.getText().trim().isEmpty()) {
			result=false;
		}

		if (importeTotal.getText().trim().isEmpty()) {
			importeTotal.setBackground(ERRORFORM);
			result=false;
		}
		
		if (convertToNumber(importeTotal.getText().trim())==0) {
			importeTotal.setBackground(ERRORFORM);
			result=false;
		}
		
		return result;
		
	} // end of method checkFinalForm
	


	/**
	 * Este m�todo realiza un chequeo de los datos de la factura. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de creaci�n facturas.
	 * 
	 * @return boolean TRUE or FALSE seg�n el formulario est� correcto o haya errores.
	 */
	
	@SuppressWarnings("unused")
	private boolean checkFormCreateInvoice () {
		
		boolean result=true;
		
		nameCustomerInv.setBackground(OKFORM);
		dateCustomerInv.setBackground(OKFORM);
		numberCustomerInv.setBackground(OKFORM);
		textOp.setBackground(OKFORM);
		qttOp.setBackground(OKFORM);
		priceOp.setBackground(OKFORM);
		amountOp.setBackground(OKFORM);
		
		if (nameCustomerInv.getText().trim().isEmpty()) {
			nameCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
				
		if (!dateEsp.checkDate(dateCustomerInv.getText().trim())) {
			dateCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
		
		if (numberCustomerInv.getText().trim().isEmpty()) {
			numberCustomerInv.setBackground(ERRORFORM);
			result=false;
		}
		
		if (textOp.getText().trim().isEmpty() || textOp.getText().trim().length()>200) {
			textOp.setBackground(ERRORFORM);
			result=false;
		}
		
		String qtt=qttOp.getText().trim();
		if (qtt.isEmpty()) {
			qtt="0";
		}
		double checkQtt=0;
		try {
			checkQtt=(double)Double.parseDouble(qtt);
		} catch (NumberFormatException nf) {
			qttOp.setBackground(ERRORFORM);
			result=false;
		}

		String prz=priceOp.getText().trim();
		if (prz.isEmpty()) {
			prz="0";
		}
		double checkPrz=0;
		try {
			checkPrz=(double)Double.parseDouble(prz);
		} catch (NumberFormatException nf) {
			priceOp.setBackground(ERRORFORM);
			result=false;
		}

		return result;
		
	} // end of method checkCreateInvoice
	
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	private void newIntro() {
		
		cod5.setText(cod4.getText().trim());
		tex5.setText(tex4.getText().trim());
		ud5.setText(ud4.getText().trim());
		price5.setText(price4.getText().trim());
		iva5.setText(iva4.getText().trim());
		imp5.setText(imp4.getText().trim());
		
		cod4.setText(cod3.getText().trim());
		tex4.setText(tex3.getText().trim());
		ud4.setText(ud3.getText().trim());
		price4.setText(price3.getText().trim());
		iva4.setText(iva3.getText().trim());
		imp4.setText(imp3.getText().trim());
		
		cod3.setText(cod2.getText().trim());
		tex3.setText(tex2.getText().trim());
		ud3.setText(ud2.getText().trim());
		price3.setText(price2.getText().trim());
		iva3.setText(iva2.getText().trim());
		imp3.setText(imp2.getText().trim());
		
		cod2.setText(cod1.getText().trim());
		tex2.setText(tex1.getText().trim());
		ud2.setText(ud1.getText().trim());
		price2.setText(price1.getText().trim());
		iva2.setText(iva1.getText().trim());
		imp2.setText(imp1.getText().trim());
		
		double amount=convertToNumber(qttOp.getText().trim())*convertToNumber(priceOp.getText().trim());
		
		String code="";
		if (numberOp.getSelectedIndex()==0) {
			// seleccionado input direct
			code=CODEDIRECT;
		} else {
			code=numberOp.getSelectedItem().toString();
		}
		cod1.setText(code);
		tex1.setText(textOp.getText().trim());
		ud1.setText(qttOp.getText().trim());
		price1.setText(priceOp.getText().trim());
		iva1.setText(ivaOp.getSelectedItem().toString());
		imp1.setText(formatoDecimal.format(amount));
		
		textOp.setText("");
		qttOp.setText("");
		priceOp.setText("");
		amountOp.setText("");
		
	} // fin del metodo newIntro
	
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	
	private void delIntro(int del) {
		
		switch (del) {
			case 1:
				delList(datosFact,cod1.getText(),tex1.getText(),ud1.getText(),price1.getText(),iva1.getText(),imp1.getText());
				break;
				
			case 2:
				delList(datosFact,cod2.getText(),tex2.getText(),ud2.getText(),price2.getText(),iva2.getText(),imp2.getText());
				break;
				
			case 3:
				delList(datosFact,cod3.getText(),tex3.getText(),ud3.getText(),price3.getText(),iva3.getText(),imp3.getText());
				break;
			
			case 4:
				delList(datosFact,cod4.getText(),tex4.getText(),ud4.getText(),price4.getText(),iva4.getText(),imp4.getText());
				break;
	
			case 5:
				delList(datosFact,cod5.getText(),tex5.getText(),ud5.getText(),price5.getText(),iva5.getText(),imp5.getText());
				break;
	
			default:
				break;
		}
		
		switch (del) {
			case 1:
				cod1.setText(cod2.getText().trim());
				tex1.setText(tex2.getText().trim());
				ud1.setText(ud2.getText().trim());
				price1.setText(price2.getText().trim());
				iva1.setText(iva2.getText().trim());
				imp1.setText(imp2.getText().trim());
	
			case 2:
				cod2.setText(cod3.getText().trim());
				tex2.setText(tex3.getText().trim());
				ud2.setText(ud3.getText().trim());
				price2.setText(price3.getText().trim());
				iva2.setText(iva3.getText().trim());
				imp2.setText(imp3.getText().trim());
	
			case 3:
				cod3.setText(cod4.getText().trim());
				tex3.setText(tex4.getText().trim());
				ud3.setText(ud4.getText().trim());
				price3.setText(price4.getText().trim());
				iva3.setText(iva4.getText().trim());
				imp3.setText(imp4.getText().trim());
			
			case 4:
				cod4.setText(cod5.getText().trim());
				tex4.setText(tex5.getText().trim());
				ud4.setText(ud5.getText().trim());
				price4.setText(price5.getText().trim());
				iva4.setText(iva5.getText().trim());
				imp4.setText(imp5.getText().trim());
	
			case 5:
				int lengthDatos=datosFact.size();
				// en el caso de que haya datos fuera de la vista, hay que
				// recuperar el siguiente dato de la lista, que es descendente
				if (lengthDatos>4) {
					cod5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[0]);
					tex5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[1]);
					ud5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[2]);
					price5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[3]);
					iva5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[4]);
					imp5.setText(datosFact.get(lengthDatos-LENGTHPANEL)[5]);
				} else {
					cod5.setText("");
					tex5.setText("");
					ud5.setText("");
					price5.setText("");
					iva5.setText("");
					imp5.setText("");
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
		
		int index=0;
		int thisIndex=999;
		for (String[]n:lista) {
			if (n[0].equals(codigo) && n[1].equals(texto) && n[2].equals(uds) && n[3].equals(precio) &&
					n[4].equals(iva) && n[5].equals(importe)) {
				thisIndex=index;
			}
			index++;
		}
		if (thisIndex!=999) {
			lista.remove(thisIndex);
		}
		
		
	} // fin del metodo delList
	
	
	
	/**
	 * Este metodo recalcula la base imponible, la cuota de iva y el importe total,
	 * y muestra esos datos en los campos determinados.
	 */
	
	private void calculBases() {
		
		base0=0;
		base1=0;
		base2=0;
		base3=0;
		cuota1=0;
		cuota2=0;
		cuota3=0;		
		baseI=0;
		cuotaI=0;
		retencI=0;

		tipoIva1=0;
		tipoIva2=0;
		tipoIva3=0;
		
		for (String[] n:datosFact) {
			
			// nos devuelve la clase de iva
			int tIva=ivas.getClassIva(1, n[4]);
			
			// en funcion de la clase de iva, se incrementa desgloses de iva 
			if (tIva==0) {
				base0+=convertToNumber(n[5]);
			} else if (tIva==1) {
				tipoIva1=convertToNumber(n[4])/100;
				base1+=convertToNumber(n[5]);
				cuota1+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			} else if (tIva==2) {
				tipoIva2=convertToNumber(n[4])/100;
				base2+=convertToNumber(n[5]);
				cuota2+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			} else {
				tipoIva3=convertToNumber(n[4])/100;
				base3+=convertToNumber(n[5]);
				cuota3+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			}
			baseI=base0+base1+base2+base3;
			cuotaI=cuota1+cuota2+cuota3;				
		}
				
		retencI=baseI*(SpringFacturacion.retInvoices/100);
		double totalI=baseI+cuotaI-retencI;
		
		baseImp.setText(formatoDecimal.format(baseI));
		cuotaIva.setText(formatoDecimal.format(cuotaI));
		retencIRPF.setText(formatoDecimal.format(retencI));
		importeTotal.setText(formatoDecimal.format(totalI));
		
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
				"1.- Primeramente deber� seleccionar un cliente para facturar.\n" +
				"2.- Introduzca la fecha de la factura, en formato dd-mm-aaaa.\n" +
				"3.- El sistema facilita el siguiente n�mero de factura. Si lo desea, puede modificarlo\n" +
				"    para introducir facturas en n�mero que haya dado de baja, o si desea tener otra\n" +
				"    serie de facturaci�n distinta a la principal.\n" +
				"    Por defecto, el sistema recordar� el �ltimo n�mero de factura mientras la aplica\n" +
				"    ci�n est� abierta. Puede cambiar el �ltimo n�mero de factura en Administraci�n-\n" +
				"    Empresas. Deber� reiniciar para que el cambio surta efecto.\n" +
				"4.- Los datos se introducen en la zona de 'Introducci�n de datos'. Si desea facturar\n" +
				"    un albar�n ya creado, seleccionelo en el desplegable 'codigo'. Si va a grabar\n" +
				"    directamente la factura, introduzca el texto de cada concepto, las uds. a facturar\n" +
				"    y el importe unitario. Luego seleccione el tipo de IVA a aplicar. Pulse en el\n" +
				"    bot�n 'intro' para aceptar la entrada.\n" +
				"    La aplicaci�n realizar� los c�lculos, y le mostrar� en primera l�nea el apunte\n" +
				"    realizado. Puede introducir todos los conceptos que desee, pero solo se le mos-\n" +
				"    trar�n los 5 �ltimos en pantalla.\n" +
				"5.- Si lo desea puede borrar los 5 �ltimos apuntes pulsando en el bot�n 'X' al lado\n" +
				"    del apunte a borrar. Si tiene m�s de 5 apuntes grabados, se mostrar� en pantalla el\n" +
				"    siguiente apunte y as� sucesivamente.\n" +
				"6.- Si desea borrar todos los datos introducidos, pulse en el bot�n Borrar datos.\n" +
				"7.- Cuando tenga confeccionada la factura, pulse el bot�n 'Grabar factura'. La aplicaci�n\n" +
				"    le pedir� la confirmaci�n. En caso afirmativo, La factura habr� quedado grabada.\n" +
				"    A continuaci�n, la aplicaci�n le preguntar� si desea imprimir la factura en formato\n" +
				"    PDF. En caso afirmativo se generar� un PDF que quedar� grabado en donde tenga\n" +
				"    instalada la aplicaci�n. El PDF no se mostrar� autom�ticamente en pantalla.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE CREACI�N FACTURAS"));
		
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
		
		String source=e.getActionCommand();
		
		if (source.equals("intro")) {
			
			if (checkFormCreateInvoice()) {
				
				String code="";
				if (numberOp.getSelectedIndex()==0) {
					// seleccionado input direct
					code=CODEDIRECT;
				} else {
					code=numberOp.getSelectedItem().toString();
				}

				double amount=convertToNumber(qttOp.getText().trim())*convertToNumber(priceOp.getText().trim());
				amountOp.setText(formatoDecimal.format(amount));
							
				String datos[]=new String[7];
				datos[0]=code;
				datos[1]=textOp.getText().trim();
				datos[2]=qttOp.getText().trim();
				datos[3]=priceOp.getText().trim();
				datos[4]=ivaOp.getSelectedItem().toString();
				datos[5]=formatoDecimal.format(amount);
				datos[6]=String.valueOf(ivaOp.getSelectedIndex());
				
				datosFact.add(datos);
				
				newIntro();
				
				calculBases();
						
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en datos a grabar", "Error en factura", JOptionPane.ERROR_MESSAGE);
			}
			
		} // END OF INTRODATOS
		

		
		if (source.equals("X")) {
			if (e.getSource()==delF1) {
				delIntro(1);
				calculBases();
			}
			if (e.getSource()==delF2) {
				delIntro(2);
				calculBases();
			}
			if (e.getSource()==delF3) {
				delIntro(3);
				calculBases();
			}
			if (e.getSource()==delF4) {
				delIntro(4);
				calculBases();
			}
			if (e.getSource()==delF5) {
				delIntro(5);
				calculBases();
			}
		} // END OF X
		
		
		
		if (source.equals("Grabar factura")) {	
			
			if (checkFinalForm()) {
				
				if (JOptionPane.showConfirmDialog(mainFrame, "�Desea grabar la factura que ha introducido en el formulario?", "Grabaci�n de la factura", JOptionPane.YES_NO_OPTION)==0) {
					
					// vuelve a calcular las bases
					calculBases();
					
					// creacion del objeto factura
					//Facturas datosF=new Facturas();
					String numbIv=numberCustomerInv.getText().trim();
					numbIv=numbIv.substring(numbIv.length()-6);
					datosF.setNumber(numbIv);
					datosF.setSerial(SpringFacturacion.serialInvoices);
					String dateToRecord=dateCustomerInv.getText().trim().substring(6)+dateCustomerInv.getText().trim().substring(2,6)+dateCustomerInv.getText().trim().substring(0,2);
					datosF.setDateF(Date.valueOf(dateToRecord));
					datosF.setCodeCompany(SpringFacturacion.idCompany);
					datosF.setNameCompany(SpringFacturacion.nameCompany);
					datosF.setAddressCompany(SpringFacturacion.addressCompany);
					datosF.setPostalCompany(SpringFacturacion.cpostalCompany);
					datosF.setCityCompany(SpringFacturacion.cityCompany);
					datosF.setNifCompany(SpringFacturacion.nifCompany);
					
					datosF.setCodeCustomer(selectedCustomer);
					datosF.setNameCustomer(nameCustomerInv.getText().trim());
					
					datosF.setAddressCustomer(listClientesFac.get(indexCustomer)[3]);
					datosF.setPostalCustomer(listClientesFac.get(indexCustomer)[4]);
					datosF.setCityCustomer(listClientesFac.get(indexCustomer)[5]);
					datosF.setNifCustomer(listClientesFac.get(indexCustomer)[6]);
					
					datosF.setBaseImponible0(base0);
					datosF.setBaseImponible1(base1);
					datosF.setTipoIva1(tipoIva1);
					datosF.setIva1(cuota1);
					datosF.setBaseImponible2(base2);
					datosF.setTipoIva2(tipoIva2);
					datosF.setIva2(cuota2);
					datosF.setBaseImponible3(base3);
					datosF.setTipoIva3(tipoIva3);
					datosF.setIva3(cuota3);
					datosF.setTipoRet(SpringFacturacion.retInvoices);
					datosF.setRetencion(retencI);
					datosF.setTotalFactura(baseI+cuotaI-retencI);
					
					String paiment=listClientesFac.get(indexCustomer)[7];
					datosF.setDiaPago("");
					if (paiment!=null && !paiment.isEmpty()) {
						String datosPago[]=formaPago.getPago(paiment);
						if (datosPago==null) {
							datosPago=new String[5];
						}
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
							datosF.setDiaPago(dateEsp.paymentDay(dateCustomerInv.getText().trim(), aplaz, diaPago));
						}
						
					} else {
						datosF.setFormaPago("");
					}
					
					datosF.setDataInvoice(datosFact);
					
					// grabando la factura
					//factura=new FacturasBean();
					if (facturador.createInvoice(datosF)) {
						JOptionPane.showMessageDialog(mainFrame, "Factura grabada correctamente","Grabaci�n de facturas",JOptionPane.INFORMATION_MESSAGE);
					
						// dando de baja los albaranes
						for (String a[]:datosFact) {
							if (!a[0].equals(CODEDIRECT)) {
								String numFact=datosF.getNumber();
								if (!datosF.getSerial().isEmpty()) {
									if (serieFact.isEmpty()) {
										numFact=datosF.getNumber();
									} else {
										numFact=datosF.getSerial()+"/"+datosF.getNumber();
									}
								}
								if (!albaranes.changeToInvoicedState(a[0], numFact)) {
									JOptionPane.showMessageDialog(mainFrame, "Error dando de baja albar�n",
											"Grabaci�n de facturas",JOptionPane.WARNING_MESSAGE);
								}
							}
						}
						
						// cambiando el numero de factura			
						
						int numf=0;
						try {
							numf=(int)Integer.parseInt((numbIv));
						} catch (NumberFormatException nf) {
							// do nothing
							System.err.println("ERROR: "+numbIv+" no es posible transformar en n�mero");
						}

						if (numf==(SpringFacturacion.lastInvoiceNumber+1)) {
							SpringFacturacion.lastInvoiceNumber=SpringFacturacion.lastInvoiceNumber+1;
						} 
						
						nextNumberFact=formatoFactura.format(SpringFacturacion.lastInvoiceNumber+1);
						if (serieFact.isEmpty()) {
							numberCustomerInv.setText(nextNumberFact);
						} else {
							numberCustomerInv.setText(serieFact+"/"+nextNumberFact);
						}
						
						
						// Eliminando la parte grafica
						selCustomerInv.setSelectedIndex(0);
						nameCustomerInv.setText("");
										
						
						numberOp=new JComboBox<String>();
						numberOp.addItem("Entrada directa");
						numberOp.setSelectedIndex(0);
						textOp.setText("");
						qttOp.setText("");
						priceOp.setText("");
						ivaOp.setSelectedIndex(0);
						amountOp.setText("");
						
						
						cod1.setText("");
						tex1.setText("");
						ud1.setText("");
						price1.setText("");
						iva1.setText("");
						imp1.setText("");
						cod2.setText("");
						tex2.setText("");
						ud2.setText("");
						price2.setText("");
						iva2.setText("");
						imp2.setText("");
						cod3.setText("");
						tex3.setText("");
						ud3.setText("");
						price3.setText("");
						iva3.setText("");
						imp3.setText("");
						cod4.setText("");
						tex4.setText("");
						ud4.setText("");
						price4.setText("");
						iva4.setText("");
						imp4.setText("");
						cod5.setText("");
						tex5.setText("");
						ud5.setText("");
						price5.setText("");
						iva5.setText("");
						imp5.setText("");
						
						baseImp.setText("");
						cuotaIva.setText("");
						importeTotal.setText("");
						
						nameCustomerInv.setBackground(OKFORM);
						dateCustomerInv.setBackground(OKFORM);
						numberCustomerInv.setBackground(OKFORM);
						textOp.setBackground(OKFORM);
						qttOp.setBackground(OKFORM);
						priceOp.setBackground(OKFORM);
						amountOp.setBackground(OKFORM);
				
						if (JOptionPane.showConfirmDialog(mainFrame, "�Desea generar un pdf de la factura?", "Impresi�n de la factura", JOptionPane.YES_NO_OPTION)==0) {
							if (dataList.getInvoice("Factura"+datosF.getSerial()+datosF.getNumber(), datosF)) {
								JOptionPane.showMessageDialog(mainFrame, "Generado el pdf de la factura","Impresi�n de la factura",JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(mainFrame, "Error: no ha sido posible generar el pdf","Impresi�n de la factura",JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Error en grabaci�n de factura","Grabaci�n de facturas",JOptionPane.ERROR_MESSAGE);
					}
					
					// eliminando la lista
					datosFact.clear();
					
					// eliminando variables
					base0=0;
					base1=0;
					base2=0;
					base3=0;
					cuota1=0;
					cuota2=0;
					cuota3=0;		
					baseI=0;
					cuotaI=0;
					retencI=0;

					tipoIva1=0;
					tipoIva2=0;
					tipoIva3=0;
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "No es posible grabar la factura:\n" +
						"Datos incorrectos o formulario incompleto.","Grabaci�n de facturas",JOptionPane.ERROR_MESSAGE);
			}
			

		}	 //END OF GRABAR FACTURA

		
		if (source.equals("Borrar datos")) {	
			
			if (JOptionPane.showConfirmDialog(mainFrame, "�Desea borrar los datos que ha introducido en el formulario?", "Borrado de la factura", JOptionPane.YES_NO_OPTION)==0) {
				// eliminando la lista
				datosFact=new ArrayList<String[]>();
				
				// Eliminando la parte grafica
				selCustomerInv.setSelectedIndex(0);
				nameCustomerInv.setText("");
				
				numberOp=new JComboBox<String>();
				numberOp.addItem("Entrada directa");
				numberOp.setSelectedIndex(0);
				textOp.setText("");
				qttOp.setText("");
				priceOp.setText("");
				ivaOp.setSelectedIndex(0);
				amountOp.setText("");
				
				nameCustomerInv.setBackground(OKFORM);
				dateCustomerInv.setBackground(OKFORM);
				numberCustomerInv.setBackground(OKFORM);
				textOp.setBackground(OKFORM);
				qttOp.setBackground(OKFORM);
				priceOp.setBackground(OKFORM);
				amountOp.setBackground(OKFORM);
				
				cod1.setText("");
				tex1.setText("");
				ud1.setText("");
				price1.setText("");
				iva1.setText("");
				imp1.setText("");
				cod2.setText("");
				tex2.setText("");
				ud2.setText("");
				price2.setText("");
				iva2.setText("");
				imp2.setText("");
				cod3.setText("");
				tex3.setText("");
				ud3.setText("");
				price3.setText("");
				iva3.setText("");
				imp3.setText("");
				cod4.setText("");
				tex4.setText("");
				ud4.setText("");
				price4.setText("");
				iva4.setText("");
				imp4.setText("");
				cod5.setText("");
				tex5.setText("");
				ud5.setText("");
				price5.setText("");
				iva5.setText("");
				imp5.setText("");				
				baseImp.setText("");
				cuotaIva.setText("");
				importeTotal.setText("");				
			}
		} // END OF BORRAR
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	} // end of actionPerformed

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// Seleccion del albaran a facturar
		if (numberOp!=null && numberOp.getSelectedIndex()>0) {
		
			int index=numberOp.getSelectedIndex()-1;
			
			String code=listAlbaranesFac.get(index)[3];
			// hay que detectar si el codigo de albaran esta repetido,
			// excluyendo el codigo CODEDIRECT de entrada directa
			boolean codeNotRepeat=true;
			if (!code.equals(CODEDIRECT)) {
				for (String a[]:datosFact) {
					if (code.equals(a[0])) {
						codeNotRepeat=false;
					}
				}
			}
			
			if (codeNotRepeat) {
				
				double amount=convertToNumber(listAlbaranesFac.get(index)[8])*convertToNumber(listAlbaranesFac.get(index)[9]);
				textOp.setText(listAlbaranesFac.get(index)[7]);
				qttOp.setText(listAlbaranesFac.get(index)[8]);
				priceOp.setText(listAlbaranesFac.get(index)[9]);
				ivaOp.setSelectedItem(listAlbaranesFac.get(index)[10]);
				
				String datos[]=new String[7];
				datos[0]=code;
				datos[1]=listAlbaranesFac.get(index)[7];
				datos[2]=listAlbaranesFac.get(index)[8];
				datos[3]=listAlbaranesFac.get(index)[9];
				datos[4]=listAlbaranesFac.get(index)[10];
				datos[5]=formatoDecimal.format(amount);
				datos[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFac.get(index)[10]));
				datosFact.add(datos);
				
				newIntro();				
				calculBases();
				
				if (!listAlbaranesFac.get(index)[11].isEmpty()) {
					double amount2=convertToNumber(listAlbaranesFac.get(index)[13])*convertToNumber(listAlbaranesFac.get(index)[14]);
					textOp.setText(listAlbaranesFac.get(index)[12]);
					qttOp.setText(listAlbaranesFac.get(index)[13]);
					priceOp.setText(listAlbaranesFac.get(index)[14]);
					ivaOp.setSelectedItem(listAlbaranesFac.get(index)[15]);
					
					String datos2[]=new String[7];
					datos2[0]=code;
					datos2[1]=listAlbaranesFac.get(index)[12];
					datos2[2]=listAlbaranesFac.get(index)[13];
					datos2[3]=listAlbaranesFac.get(index)[14];
					datos2[4]=listAlbaranesFac.get(index)[15];
					datos2[5]=formatoDecimal.format(amount2);
					datos2[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFac.get(index)[15]));
					datosFact.add(datos2);
					
					newIntro();				
					calculBases();
				}
				
				if (!listAlbaranesFac.get(index)[16].isEmpty()) {
					double amount3=convertToNumber(listAlbaranesFac.get(index)[18])*convertToNumber(listAlbaranesFac.get(index)[19]);
					textOp.setText(listAlbaranesFac.get(index)[17]);
					qttOp.setText(listAlbaranesFac.get(index)[18]);
					priceOp.setText(listAlbaranesFac.get(index)[19]);
					ivaOp.setSelectedItem(listAlbaranesFac.get(index)[20]);
					
					String datos3[]=new String[7];
					datos3[0]=code;
					datos3[1]=listAlbaranesFac.get(index)[17];
					datos3[2]=listAlbaranesFac.get(index)[18];
					datos3[3]=listAlbaranesFac.get(index)[19];
					datos3[4]=listAlbaranesFac.get(index)[20];
					datos3[5]=formatoDecimal.format(amount3);
					datos3[6]=String.valueOf(ivas.getClassIva(1, listAlbaranesFac.get(index)[20]));
					datosFact.add(datos3);
					
					newIntro();				
					calculBases();
				}
				
			}
			
		} else if (selCustomerInv!=null && selCustomerInv.getSelectedIndex()!=0) {
			// seleccion del cliente para facturar
			indexCustomer=selCustomerInv.getSelectedIndex()-1;
			nameCustomerInv.setText(listClientesFac.get(indexCustomer)[2]);
			selectedCustomer=listClientesFac.get(indexCustomer)[1];	
			
			// selecciona los albaranes pendientes del cliente
			List<String[]> search=new ArrayList<String[]>();
			String a[]=new String[2];
			a[0]=listClientesFac.get(indexCustomer)[1];
			a[1]=listClientesFac.get(indexCustomer)[2];
			search.add(a);		
			listAlbaranesFac=albaranes.searchPendingDeliveriesCustomers(search);
			
			// actualizacion del objeto numberOp (albaranes pendientes del cliente)
			marco2.setVisible(false);
			marco2.remove(marcoAux1);
			marcoAux01.remove(marcoInput1);
			marcoInput1.remove(0);
			
			numberOp=new JComboBox<String>();
			numberOp.addItem("Entrada directa");			
			for (String b[]:listAlbaranesFac) {
				numberOp.addItem(b[3]);
			}
			numberOp.addItemListener(this);
			
			marcoInput1.add(numberOp, 0);
			marcoInput1.revalidate();
			marcoAux1.add(marcoInput1, 12);
			marcoAux1.revalidate();
			marco2.add(marcoAux1,1);
			marco2.setVisible(true);
			marco2.revalidate();
		}
		
		
	} // end of itemStateChanged
	

}  // ************** END OF CLASS
