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
import beansControls.TiposIvaBean;
import beansControls.UtilsFacturacion;
import beansList.ListadosPdf;
import beansModels.Albaranes;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelDeliveryModifying extends UtilsFacturacion implements ActionListener, ItemListener {
		
	// spring objects
	private ClockAndDate dateEsp;
	private TiposIvaBean ivas;
	private ClientesBean clienteFac;
	private Albaranes datosF;
	private EnterSandMan reinicia;
	private AlbaranesBean albaranes;
	private ListadosPdf dataList;	
	
	// not a spring object
	private Albaranes deliveryToModify;
	
	private JFrame mainFrame;
	
	// BORRAR FACTURA
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
	
	private JComboBox<String> selDeliveryB;
	private JComboBox<String> selCustomerInvB;
	private JTextField deliveryNumberB;
	private JTextField nameCustomerInvB;
	private JTextField dateCustomerInvB;
	private JTextField numberCustomerInvB;
	
	private JComboBox<String> numberOpB;
	private JTextField textOpB;
	private JTextField qttOpB;
	private JTextField priceOpB;	
	private JComboBox<String> ivaOpB;
	private JTextField amountOpB;		
	
	//private final int LENGTHPANEL=5;
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
	
	private JTextField baseImpB;
	private JTextField cuotaIvaB;
	private JTextField retencIRPFB;
	private JTextField importeTotalB;
	
	// CALCULABASES
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

	
	private JButton anadirFB;
	private JButton info;
	private JButton modF1B;
	private JButton modF2B;
	private JButton modF3B;

	private JButton grabarFB;
	private JButton borrarFB;

	
	// DATOS DE LA FACTURA EN MODIFICACION
	private List<String[]> datosAlbB;				// lista de los datos de albaranes
	private String nextNumberDelivery;				// siguiente num. de albaran  (numérico)
	private String selectedCustomer;				// key del cliente a modificar
	private int indexCustomer;
	private List<String[]> listClientesFacB;		// lista de clientes seleccionables 
	private List<String[]> listDeliveryB;			// lista de albaranes pendientes de facturar

	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	private final Color COLORL=Color.BLACK;
	
	
	
	public PanelDeliveryModifying() {
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
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	public void setDatosF (Albaranes albaran) {
		// spring
		this.datosF=albaran;
	}

	public void setDataList (ListadosPdf dataList) {
		// spring
		this.dataList=dataList;
	}
	
	
	
	/**
	 * Método que permite la modificación del albarán, mostrándolo en el panel.
	 * 
	 * @return - un JPanel componiendo el albarán a modificar
	 */
	
	public JPanel modifyDelivery(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
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
		JLabel titleC=new JLabel("                            ALBARANES - MODIFICACIÓN               ");
		titleC.setFont(font1);
		// creamos el formulario
		
		// cabecera
		//factura=new FacturasCean();	
		selDeliveryB=new JComboBox<String>();
		selDeliveryB.addItem("Seleccione número...");
		//clienteFac=new ClientesCean();
		listDeliveryB=albaranes.searchAllDeliveriesPending();
		for (String[] data: listDeliveryB) {
			selDeliveryB.addItem(data[3]);
		}
		deliveryNumberB=new JTextField("");
		deliveryNumberB.setEditable(false);
		
		
		selCustomerInvB=new JComboBox<String>();
		selCustomerInvB.addItem("Seleccione cliente...");
		//clienteFac=new ClientesCean();
		listClientesFacB=clienteFac.getListCustomers();
		for (String[] data: listClientesFacB) {
			selCustomerInvB.addItem(data[2]);
		}
		nameCustomerInvB=new JTextField("");
		nameCustomerInvB.setEditable(false);		
		
		dateCustomerInvB=new JTextField(dateEsp.getDate());
		dateCustomerInvB.setEditable(true);
		
		numberCustomerInvB=new JTextField("");
		numberCustomerInvB.setEditable(true);	
		
		// zona inputs
		numberOpB=new JComboBox<String>();		
		numberOpB.addItem("Entrada directa");
		numberOpB.setEnabled(true);
		textOpB=new JTextField("");
		textOpB.setEditable(true);
		textOpB.setToolTipText("OBLIGATORIO: máximo 200 caracteres");
		qttOpB=new JTextField("");
		qttOpB.setEditable(true);
		textOpB.setToolTipText("campo numérico");
		priceOpB=new JTextField("");
		priceOpB.setEditable(true);
		priceOpB.setToolTipText("campo numérico");
		
		ivaOpB=new JComboBox<String>();
		List<String[]> listIv;
		listIv=ivas.getListIva();
		if (listIv==null) {
			listIv=new ArrayList<String[]>();
		}
		for (String[] a:listIv) {
			if (!(a[1].equals("0") || a[4].equals("2"))) {
				// si el iva no esta inactivo ni es de compras lo añade
				// pero por orden de clase de iva			
				//ivaOp.add(new JLabel(a[3]),(int)Integer.parseInt(a[5]));
				ivaOpB.addItem(a[3]);
			}
		}
		ivaOpB.setEnabled(true);

		amountOpB=new JTextField();
		amountOpB.setEditable(true);
		
		anadirFB=new JButton("intro");
		anadirFB.setEnabled(true);
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
		
		Dimension dim=new Dimension(45,20);	
		modF1B=new JButton("M");
		modF1B.setEnabled(true);
		modF1B.setPreferredSize(dim);
		modF1B.setMaximumSize(dim);
		modF1B.setMinimumSize(dim);
		
		modF2B=new JButton("M");
		modF2B.setEnabled(true);
		modF2B.setPreferredSize(dim);
		modF2B.setMaximumSize(dim);
		modF2B.setMinimumSize(dim);
		
		modF3B=new JButton("M");
		modF3B.setEnabled(true);
		modF3B.setPreferredSize(dim);
		modF3B.setMaximumSize(dim);
		modF3B.setMinimumSize(dim);
		
		baseImpB=new JTextField("");
		baseImpB.setEditable(true);
		cuotaIvaB=new JTextField("");
		cuotaIvaB.setEditable(true);
		retencIRPFB=new JTextField("");
		if (SpringFacturacion.retInvoices==0) {
			retencIRPFB=new JTextField("0,00");	
			retencIRPFB.setEditable(false);
		}
		retencIRPFB.setEditable(true);
		importeTotalB=new JTextField("");
		importeTotalB.setEditable(true);
		
		marcoHead0B.add(selDeliveryB);
		marcoHead0B.add(deliveryNumberB);
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
		marcoAux11_BB.add(modF1B);
		marcoAux11_BB.add(cod1B);
		marcoAux11B.add(marcoAux11_BB);
		marcoAux11B.add(tex1B);
		marcoAux12B.add(ud1B);
		marcoAux12B.add(price1B);
		marcoAux12B.add(iva1B);
		marcoAux12B.add(imp1B);
		marcoAux21_BB.add(modF2B);
		marcoAux21_BB.add(cod2B);
		marcoAux21B.add(marcoAux21_BB);
		marcoAux21B.add(tex2B);
		marcoAux22B.add(ud2B);
		marcoAux22B.add(price2B);
		marcoAux22B.add(iva2B);
		marcoAux22B.add(imp2B);
		marcoAux31_BB.add(modF3B);
		marcoAux31_BB.add(cod3B);
		marcoAux31B.add(marcoAux31_BB);
		marcoAux31B.add(tex3B);
		marcoAux32B.add(ud3B);
		marcoAux32B.add(price3B);
		marcoAux32B.add(iva3B);
		marcoAux32B.add(imp3B);

		marcoAux61B.add(baseImpB);
		marcoAux61B.add(cuotaIvaB);
		marcoAux62B.add(retencIRPFB);
		marcoAux62B.add(importeTotalB);
		
		// preparamos los botones 
		// preparamos los botones 
		grabarFB=new JButton("Cambiar albarán");
		grabarFB.setToolTipText("pulse para grabar el albarán");
		borrarFB=new JButton("Borrar datos");	
		borrarFB.setToolTipText("pulse para eliminar los datos del formulario");
		
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
		panelButton3.add(new JLabel());;
		panelButton3.add(info);
		Dimension dimP=new Dimension(60,40);
		panelButton3.setPreferredSize(dimP);
		panelButton3.setMaximumSize(dimP);
		panelButton3.setMinimumSize(dimP);
		
	

		// añadimos todos los elementos a los JPanel auxiliares
		marcoAux0B.add(titleC);
		marcoAux0B.add(panelButton3);
		
		marcoAux1B.setLayout(new GridLayout(18,2));

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
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" "));
		
		marcoAux1B.add(new JLabel("   Base Imponible                                    Cuota iva"));
		marcoAux1B.add(new JLabel("  Retención                                               Importe total IVA incluido"));
		marcoAux1B.add(marcoAux61B);
		marcoAux1B.add(marcoAux62B);
		
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(new JLabel(" "));
		marcoAux1B.add(marcoAux71B);
		marcoAux1B.add(marcoAux72B);
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0B,BorderLayout.NORTH);
		marco2.add(marcoAux1B,BorderLayout.CENTER);
		marco2.add(new JLabel("     "),BorderLayout.EAST);
		marco2.add(new JLabel("     "),BorderLayout.WEST);
		marco2.add(new JLabel("     "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		selDeliveryB.addItemListener(this);
		selCustomerInvB.addItemListener(this);
		grabarFB.addActionListener(this);
		borrarFB.addActionListener(this);
		anadirFB.addActionListener(this);
		info.addActionListener(this);
		modF1B.addActionListener(this);
		modF2B.addActionListener(this);
		modF3B.addActionListener(this);
		
		return marco2;
				
	} // end of method modifyDelivery
	
	
	
	/**
	 * Metodo que muestra los datos del albaran a borrar en el formulario.
	 * 
	 * @param deliveryToModify - Albaranes, objeto con los datos del albaran a mostrar antes de borrar
	 */
	
	private void showDeliveryToModify(Albaranes deliveryToModify) {
		
		// PRIMERO BORRAMOS CONTENIDO
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
		
		baseImpB.setText("");
		cuotaIvaB.setText("");
		importeTotalB.setText("");
		
		//  CABECERA
		selectedCustomer=deliveryToModify.getCodeCustomer();
		nameCustomerInvB.setText(clienteFac.getCustomer(selectedCustomer)[2]);
		String fecha=dateEsp.convertDateToString(deliveryToModify.getDateOper());
		dateCustomerInvB.setText(fecha);		
		numberCustomerInvB.setText(deliveryToModify.getNumber());
		
		String datos1[]=null;
		String datos2[]=null;
		String datos3[]=null;
		
		// DETALLE MOVIMIENTOS
		if (!deliveryToModify.getCodeOper3().isEmpty()) {
			cod3B.setText(deliveryToModify.getCodeOper3());
			tex3B.setText(deliveryToModify.getTextOper3());
			ud3B.setText(formatoDecimal.format(deliveryToModify.getQttOper3()));
			price3B.setText(formatoDecimal.format(deliveryToModify.getPriceOper3()));
			iva3B.setText(formatoDecimal.format(deliveryToModify.getIvaOper2()));
			imp3B.setText(formatoDecimal.format(deliveryToModify.getPriceOper3()*deliveryToModify.getQttOper3()));
			
			datos3=new String[7];
			datos3[0]=deliveryToModify.getCodeOper3();
			datos3[1]=tex3B.getText().trim();
			datos3[2]=ud3B.getText().trim();
			datos3[3]=price3B.getText().trim();
			datos3[4]=iva3B.getText().trim();
			datos3[5]=imp3B.getText().trim();
			int claseIva=ivas.getClassIva(1, String.valueOf(datos3[4]).replaceFirst(",", "."));
			datos3[6]=String.valueOf(claseIva);
			
		}

		if (!deliveryToModify.getCodeOper2().isEmpty()) {
			cod2B.setText(deliveryToModify.getCodeOper2());
			tex2B.setText(deliveryToModify.getTextOper2());
			ud2B.setText(formatoDecimal.format(deliveryToModify.getQttOper2()));
			price2B.setText(formatoDecimal.format(deliveryToModify.getPriceOper2()));
			iva2B.setText(formatoDecimal.format(deliveryToModify.getIvaOper2()));
			imp2B.setText(formatoDecimal.format(deliveryToModify.getPriceOper2()*deliveryToModify.getQttOper2()));
			
			datos2=new String[7];
			datos2[0]=deliveryToModify.getCodeOper2();
			datos2[1]=tex2B.getText().trim();
			datos2[2]=ud2B.getText().trim();
			datos2[3]=price2B.getText().trim();
			datos2[4]=iva2B.getText().trim();
			datos2[5]=imp2B.getText().trim();
			int claseIva=ivas.getClassIva(1, String.valueOf(datos2[4]).replaceFirst(",", "."));
			datos2[6]=String.valueOf(claseIva);
			
		}

		if (!deliveryToModify.getCodeOper1().isEmpty()) {
			cod1B.setText(deliveryToModify.getCodeOper1());
			tex1B.setText(deliveryToModify.getTextOper1());
			ud1B.setText(formatoDecimal.format(deliveryToModify.getQttOper1()));
			price1B.setText(formatoDecimal.format(deliveryToModify.getPriceOper1()));
			iva1B.setText(formatoDecimal.format(deliveryToModify.getIvaOper1()));
			imp1B.setText(formatoDecimal.format(deliveryToModify.getPriceOper1()*deliveryToModify.getQttOper1()));
			
			datos1=new String[7];
			datos1[0]=deliveryToModify.getCodeOper1();
			datos1[1]=tex1B.getText().trim();
			datos1[2]=ud1B.getText().trim();
			datos1[3]=price1B.getText().trim();
			datos1[4]=iva1B.getText().trim();
			datos1[5]=imp1B.getText().trim();
			int claseIva=ivas.getClassIva(1, String.valueOf(datos1[4]).replaceFirst(",", "."));
			datos1[6]=String.valueOf(claseIva);		
			
		}
		
		// se rellena el arraylist de edicion con los datos del albaran
		datosAlbB=new ArrayList<String[]>();
		
		if (datos1!=null) {
			datosAlbB.add(datos1);
		}
		
		if (datos2!=null) {
			datosAlbB.add(datos2);
		}
		if (datos3!=null) {
			datosAlbB.add(datos3);
		}

				
		// RESUMEN FACTURA
		double bases=deliveryToModify.getBaseImponible0()+deliveryToModify.getBaseImponible1()+deliveryToModify.getBaseImponible2()+deliveryToModify.getBaseImponible3();
		baseImpB.setText(formatoDecimal.format(bases));
		double cuotas=deliveryToModify.getIva1()+deliveryToModify.getIva2()+deliveryToModify.getIva3();

		cuotaIvaB.setText(formatoDecimal.format(cuotas));
		double retenciones=deliveryToModify.getRetencion();
		retencIRPFB.setText(formatoDecimal.format(retenciones));
		importeTotalB.setText(formatoDecimal.format(bases+cuotas-retenciones));
		
	} // end of showDeliveryToErase
	
	
	
	/**
	 * Este método realiza un chequeo de los datos del albaran. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de creación albaranes.
	 * 
	 * @return boolean TRUE or FALSE según el formulario esté correcto o haya errores.
	 */
	
	@SuppressWarnings("unused")
	private boolean checkFormCreateDelivery () {
		
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
			qtt=qtt.replaceFirst(",", ".");			
			try {
				checkQtt=(double)Double.parseDouble(qtt);	
				qttOpB.setText(qtt);
			} catch (NumberFormatException nf2) {
				qttOpB.setBackground(ERRORFORM);		
				result=false;
			}
		}

		String prz=priceOpB.getText().trim();
		if (prz.isEmpty()) {
			prz="0";
		}
		double checkPrz=0;
		try {
			checkPrz=(double)Double.parseDouble(prz);
		} catch (NumberFormatException nf) {
			prz=prz.replaceFirst(",", ".");			
			try {
				checkPrz=(double)Double.parseDouble(prz);	
				priceOpB.setText(prz);
			} catch (NumberFormatException nf2) {
				priceOpB.setBackground(ERRORFORM);
				result=false;
			}
		}

		return result;
		
	} // end of method checkFormCreateDelivery
	
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	private void newIntro() {
		
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
			code="999999";
		} else {
			code=numberOpB.getSelectedItem().toString();
		}
		cod1B.setText(code);
		tex1B.setText(textOpB.getText().trim());
		ud1B.setText(qttOpB.getText().trim());
		price1B.setText(priceOpB.getText().trim());
		iva1B.setText(ivaOpB.getSelectedItem().toString());
		imp1B.setText(formatoDecimal.format(amount));
		
		textOpB.setText("");
		qttOpB.setText("");
		priceOpB.setText("");
		amountOpB.setText("");
		
	} // fin del metodo newIntro
	
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	
	private void modIntro(int del) {
		
		switch (del) {
			case 1:
				datosAlbB=delList(datosAlbB,cod1B.getText(),tex1B.getText(),ud1B.getText(),price1B.getText(),iva1B.getText(),imp1B.getText());
				break;
				
			case 2:
				datosAlbB=delList(datosAlbB,cod2B.getText(),tex2B.getText(),ud2B.getText(),price2B.getText(),iva2B.getText(),imp2B.getText());
				break;
				
			case 3:
				datosAlbB=delList(datosAlbB,cod3B.getText(),tex3B.getText(),ud3B.getText(),price3B.getText(),iva3B.getText(),imp3B.getText());
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
				cod3B.setText("");
				tex3B.setText("");
				ud3B.setText("");
				price3B.setText("");
				iva3B.setText("");
				imp3B.setText("");
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
	
	private List<String[]> delList(List<String[]> lista, String codigo, String texto, String uds, String precio, String iva, String importe) {
		
		numberOpB.setSelectedIndex(0);
		textOpB.setText(texto);
		qttOpB.setText(uds);
		priceOpB.setText(precio);
		amountOpB.setText(importe);
		ivaOpB.setSelectedItem(iva);
		
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
		return lista;
			
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
		
		for (String[] n:datosAlbB) {
			int tIva=(int)Integer.parseInt(n[6]);
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
			} else if (tIva==3) {
				tipoIva3=convertToNumber(n[4])/100;
				base3+=convertToNumber(n[5]);
				cuota3+=(convertToNumber(n[5]))*(convertToNumber(n[4])/100);
			} 
			baseI=base0+base1+base2+base3;
			cuotaI=cuota1+cuota2+cuota3;				
		}
				
		retencI=baseI*(SpringFacturacion.retInvoices/100);
		double totalI=baseI+cuotaI-retencI;
		
		baseImpB.setText(formatoDecimal.format(baseI));
		cuotaIvaB.setText(formatoDecimal.format(cuotaI));
		retencIRPFB.setText(formatoDecimal.format(retencI));
		importeTotalB.setText(formatoDecimal.format(totalI));
		
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
				"1.- Primeramente deberá seleccionar el albarán que quiere modificar. Solo\n" +
				"    podrá modificar albaranes que aún no estén facturados.\n" +
				"2.- Elegido el albarán, los datos se mostrarán en pantalla.\n" +
				"3.- Puede modificar el cliente, simplemente seleccionándolo de la lista.\n" +
				"4.- Para modificar algún artículo, pulse en el botón M al lado del artículo.\n" +
				"    El artículo aparecerá seleccionado en la zona de introducción de datos,\n" +
				"    y se habrán modificado los datos de sumas del albarán. Ese dato estará\n" +
				"    pendiente de incorporar, pulsando 'intro' cuando lo haya modificado.\n" +
				"    Si solamente quería eliminarlo puede borrar los datos directamente, o\n" +
				"    grabar la factura sin incorporarlo pulsando 'intro'.\n" +
				"    La aplicación realizará los cálculos, y le mostrará en primera línea el apunte\n" +
				"    realizado. Puede introducir un máximo de tres conceptos por albarán.\n" +
				"5.- Si hubiera sucedido algún descuadre en los sumatorios del albarán, tiene\n" +
				"    la posibilidad de modificar los sumatorios de base imponible, cuota, retención\n" +
				"    e importe total directamente, en las casillas del formulario.\n" +
				"    La aplicación asumirá los cambios, reajustando contra la base imponible.\n" +
				"6.- Cuando tenga confeccionado el albarán, pulse el botón 'Grabar albarán'. La\n" +
				"    aplicación le pedirá la confirmación. En caso afirmativo, el albarán habrá\n" +
				"    quedado grabado. A continuación, la aplicación le preguntará si desea imprimir\n" +
				"    el albarán en formato PDF. En caso afirmativo se generará un PDF que quedará \n" +
				"    grabado en el lugar donde tenga instalada la aplicación. El PDF no se mostrará\n" +
				"    automáticamente en la pantalla.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE MODIFICACIÓN ALBARANES"));
		
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
			
			if (checkFormCreateDelivery()) {
				
				String code="";
				if (numberOpB.getSelectedIndex()==0) {
					// seleccionado input direct
					code="999999";
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
				int claseIva=ivas.getClassIva(1, ivaOpB.getSelectedItem().toString().replaceFirst(",", "."));
				datos[6]=String.valueOf(claseIva);
				
				datosAlbB.add(datos);
				
				newIntro();
				
				calculBases();
						
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en datos a grabar", "Error en Albarán", JOptionPane.ERROR_MESSAGE);
			}
			
		} // END OF INTRODATOS
		
		
		
		if (source.equals("M")) {
			if (e.getSource()==modF1B) {
				modIntro(1);
				calculBases();
			}
			if (e.getSource()==modF2B) {
				modIntro(2);
				calculBases();
			}
			if (e.getSource()==modF3B) {
				modIntro(3);
				calculBases();
			}

		} // END OF X
		
		
		
		if (source.equals("Cambiar albarán")) {	
			
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea modificar el albarán mostrado en el formulario?", "Modificación de albarán", JOptionPane.YES_NO_OPTION)==0) {
				
				// vuelve a calcular las bases.
				// ATENCION: retenemos los sumatorios por si han sido cambiados manualmente
				// las discrepancias se resuelven vía bases imponibles
				String retenF=retencIRPFB.getText().trim();
				String ivaF=cuotaIvaB.getText().trim();
				String totalF=importeTotalB.getText().trim();			
				
				calculBases();
				
				// seguimos recogiendo los datos del albaran
				datosF.setInvoice("");
				datosF.setCodeCustomer(selectedCustomer);
				String numbIv=numberCustomerInvB.getText().trim();
				datosF.setNumber(numbIv);
				String dateToRecord=dateCustomerInvB.getText().trim().substring(6)+dateCustomerInvB.getText().trim().substring(2,6)+dateCustomerInvB.getText().trim().substring(0,2);
				datosF.setDateOper(Date.valueOf(dateToRecord));
				datosF.setCodeCompany(SpringFacturacion.idCompany);
				
				// reseteamos los datos del objeto albaran
				datosF.setCodeOper1("");
				datosF.setCodeOper2("");
				datosF.setCodeOper3("");
				datosF.setTextOper1("");
				datosF.setTextOper2("");
				datosF.setTextOper3("");
				datosF.setQttOper1(0);
				datosF.setQttOper2(0);
				datosF.setQttOper3(0);
				datosF.setPriceOper1(0);
				datosF.setPriceOper2(0);
				datosF.setPriceOper3(0);
				datosF.setIvaOper1(0);
				datosF.setIvaOper2(0);
				datosF.setIvaOper3(0);
				
				// rellenamos el objeto albaran con los datos del list
				switch (datosAlbB.size()) {
				case 3:
					datosF.setCodeOper3(datosAlbB.get(2)[0]);
					datosF.setTextOper3(datosAlbB.get(2)[1]);
					datosF.setQttOper3(convertToNumber(datosAlbB.get(2)[2]));
					datosF.setPriceOper3(convertToNumber(datosAlbB.get(2)[3]));
					datosF.setIvaOper3(convertToNumber(datosAlbB.get(2)[4]));
				case 2:
					datosF.setCodeOper2(datosAlbB.get(1)[0]);
					datosF.setTextOper2(datosAlbB.get(1)[1]);
					datosF.setQttOper2(convertToNumber(datosAlbB.get(1)[2]));
					datosF.setPriceOper2(convertToNumber(datosAlbB.get(1)[3]));
					datosF.setIvaOper2(convertToNumber(datosAlbB.get(1)[4]));
				case 1:
					datosF.setCodeOper1(datosAlbB.get(0)[0]);
					datosF.setTextOper1(datosAlbB.get(0)[1]);
					datosF.setQttOper1(convertToNumber(datosAlbB.get(0)[2]));
					datosF.setPriceOper1(convertToNumber(datosAlbB.get(0)[3]));
					datosF.setIvaOper1(convertToNumber(datosAlbB.get(0)[4]));
					break;
					default:
						break;		
				}
				
				
				// los valores han sido calculados en calculaBase
				// ATENCION: hay que ajustar las discrepancias entre calculos y posibles
				// datos introducidos manualmente en los totales del albaran
				// partiendo de la base de que el total del formulario es inamovible
				// y que el irpf tambien es casilla unica
				// tanto bases como iva se ajustan por diferencias, con el siguiente criterio:
				// 1.- el iva tiene prioridad sobre la base imponible, por lo que el iva se ajusta al
				//     valor de la casilla y la base imponible se redondea
				// 2.- las bases receptoras del redondeo seran las mas altas por este orden: 3, 2, 1, 0
				//     o sea, base3, base2, base1 y base 0.
				
				double difTotal=convertToNumber(totalF)+convertToNumber(retenF)-convertToNumber(ivaF)-base0-base1-base2-base3;
				
				if (difTotal>=0.005 || difTotal<=-0.005) {
					// SI EXISTEN DIFERENCIAS, SE PROCEDE AL AJUSTE
					if ((convertToNumber(ivaF)-cuota3-cuota2-cuota1>=0.005) || (convertToNumber(ivaF)-cuota3-cuota2-cuota1<=-0.005) ) {
						if (cuota3>0) {
							cuota3+=(convertToNumber(ivaF)-cuota3-cuota2-cuota1);
						} else if (cuota2>0) {
							cuota2+=(convertToNumber(ivaF)-cuota3-cuota2-cuota1);
						} else if (cuota1>0) {
							cuota1+=(convertToNumber(ivaF)-cuota3-cuota2-cuota1);
						} 					
					}

					
					double redondeo=convertToNumber(totalF)-convertToNumber(ivaF)+convertToNumber(retenF)-base0-base1-base2-base3;
					if (redondeo>=0.005 || redondeo<=-0.005) {
						if (base3>0) {
							base3+=redondeo;
						} else if (base2>0) {
							base2+=redondeo;
						} else if (base1>0) {
							base1+=redondeo;
						} else if (base0>0) {
							base0+=redondeo;
						}	
					}	
				}
							
				datosF.setBaseImponible0(base0);
				datosF.setBaseImponible1(base1);
				datosF.setIva1(cuota1);
				datosF.setTipoIva1(tipoIva1);
				datosF.setBaseImponible2(base2);
				datosF.setIva2(cuota2);
				datosF.setTipoIva2(tipoIva2);
				datosF.setBaseImponible3(base3);
				datosF.setIva3(cuota3);
				datosF.setTipoIva3(tipoIva3);
							
				datosF.setRetencion(convertToNumber(retenF));
				datosF.setTipoRet(SpringFacturacion.retInvoices);
				datosF.setTotalAlbaran(convertToNumber(totalF));
				
				
				// grabando el albaran
				
				if (albaranes.modifyDelivery(numbIv, datosF)) {
					JOptionPane.showMessageDialog(mainFrame, "Albarán modificado correctamente","Modificación de albaranes",JOptionPane.INFORMATION_MESSAGE);
				
					nextNumberDelivery=formatoFactura.format(albaranes.getNextNumber());
					numberCustomerInvB.setText(nextNumberDelivery);
					
					// eliminando la lista
					datosAlbB=new ArrayList<String[]>();
					
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
					
					baseImpB.setText("");
					cuotaIvaB.setText("");
					importeTotalB.setText("");

					if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea generar un pdf del albarán?", "Impresión de albarán", JOptionPane.YES_NO_OPTION)==0) {
						String[] cliente=clienteFac.getCustomer(datosF.getCodeCustomer());
						if (dataList.getDelivery("albaran"+datosF.getNumber(), datosF, cliente[2], cliente[3], cliente[4], cliente[5], cliente[6])) {
							JOptionPane.showMessageDialog(mainFrame, "Generado el pdf del albarán","Impresión de albarán",JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error: no ha sido posible generar el pdf","Impresión de albarán",JOptionPane.ERROR_MESSAGE);
						}
					}
					
					// se actualizan pestañas
					reinicia.reinicia(3,2);
					
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en modificación de albarán","Modificación de albarán",JOptionPane.ERROR_MESSAGE);
				}
			}		
		}	 //END OF MODIFICAR FACTURA
		
		
		/*
		if (source.equals("Borrar albarán")) {

			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar la factura seleccionada en el formulario?", "Borrado de facturas", JOptionPane.YES_NO_OPTION)==0) {
				String numDel=selDeliveryB.getSelectedItem().toString();

				if (albaranes.eraseDelivery(numDel)) {
					JOptionPane.showMessageDialog(mainFrame, "Albarán borrado correctamente","Borrado de albaranes",JOptionPane.INFORMATION_MESSAGE);
					// mostrando el numero de albaran			
					nextNumberDelivery=formatoFactura.format(albaranes.getNextNumber());
					numberCustomerInvB.setText("");
					dateCustomerInvB.setText("");
					
					// eliminando la lista
					datosAlbB=new ArrayList<String[]>();
					listDeliveryB=new ArrayList<String[]>();
					selDeliveryB=new JComboBox<String>();
					selDeliveryB.addItem("Seleccione número...");
					//clienteFac=new ClientesCean();
					listDeliveryB=albaranes.searchAllDeliveriesPending();
					for (String[] data: listDeliveryB) {
						selDeliveryB.addItem(data[1]);
					}
					
					// Eliminando la parte grafica
					selDeliveryB.setSelectedIndex(0);
					selCustomerInvB.setSelectedIndex(0);
					nameCustomerInvB.setText("");
					
					//numberOpB.setSelectedIndex(0);
					textOpB.setText("");
					qttOpB.setText("");
					priceOpB.setText("");
					//ivaOpB.setSelectedIndex(0);
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
					
					baseImpB.setText("");
					cuotaIvaB.setText("");
					importeTotalB.setText("");
					
					// se actualizan pestañas
					reinicia.reinicia(3,2);
					
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Error en borrado de factura","Borrado de facturas",JOptionPane.ERROR_MESSAGE);
				}	
			}	
		}  // end of borrar factura
		*/
		
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
			
			baseImpB.setText("");
			cuotaIvaB.setText("");
			importeTotalB.setText("");
			
		} // end of borrar
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	} // end of actionPerformed

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (selDeliveryB!=null && selDeliveryB.getSelectedIndex()!=0) {
			String data=String.valueOf(selDeliveryB.getSelectedItem());
			deliveryToModify=albaranes.getDelivery(data);
			showDeliveryToModify(deliveryToModify);
		}
		
		if (selCustomerInvB!=null && selCustomerInvB.getSelectedIndex()!=0) {

			indexCustomer=selCustomerInvB.getSelectedIndex()-1;
			nameCustomerInvB.setText(listClientesFacB.get(indexCustomer)[2]);
			selectedCustomer=listClientesFacB.get(indexCustomer)[1];	
			
		}
		
	} // end of itemStateChanged
	
	

} // ************ END OF CLASS
