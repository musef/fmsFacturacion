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
import beansModels.Facturas;

import main.SpringFacturacion;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelInvoicesDeleting implements ActionListener, ItemListener {
	
	// spring objects
	private FacturasBean facturador;
	private ClockAndDate dateEsp;
	private ClientesBean clienteFac;
	private AlbaranesBean albaranes;
	// not a spring object
	private Facturas invoiceToErase;
	
	private JFrame mainFrame;
	
	// BORRAR FACTURA
	private JPanel marcoAux0C;
	private JPanel marcoAux1C;
	private JPanel marcoHead0C;
	private JPanel marcoHead1C;
	private JPanel marcoHead2C;
	private JPanel marcoHead3C;
	private JPanel marcoInput1C;
	private JPanel marcoInput2C;
	private JPanel marcoAux01C;
	private JPanel marcoAux02C;	
	private JPanel marcoAux11C;
	private JPanel marcoAux11_CC;
	private JPanel marcoAux12C;
	private JPanel marcoAux21C;
	private JPanel marcoAux21_CC;
	private JPanel marcoAux22C;
	private JPanel marcoAux31C;
	private JPanel marcoAux31_CC;
	private JPanel marcoAux32C;
	private JPanel marcoAux41C;
	private JPanel marcoAux41_CC;
	private JPanel marcoAux42C;
	private JPanel marcoAux51C;
	private JPanel marcoAux51_CC;
	private JPanel marcoAux52C;
	private JPanel marcoAux61C;
	private JPanel marcoAux62C;
	private JPanel marcoAux71C;
	private JPanel marcoAux72C;
	
	private JComboBox<String> selInvoiceC;
	private JComboBox<String> selCustomerInvC;
	private JTextField invoiceNumberC;
	private JTextField nameCustomerInvC;
	private JTextField dateCustomerInvC;
	private JTextField numberCustomerInvC;
	
	private JComboBox<String> numberOpC;
	private JTextField textOpC;
	private JTextField qttOpC;
	private JTextField priceOpC;	
	private JComboBox<String> ivaOpC;
	private JTextField amountOpC;		
	
	//private final int LENGTHPANEL=5;
	private JTextField cod1C;
	private JTextField tex1C;
	private JTextField ud1C;
	private JTextField price1C;
	private JTextField iva1C;
	private JTextField imp1C;
	private JTextField cod2C;
	private JTextField tex2C;
	private JTextField ud2C;
	private JTextField price2C;
	private JTextField iva2C;
	private JTextField imp2C;
	private JTextField cod3C;
	private JTextField tex3C;
	private JTextField ud3C;
	private JTextField price3C;
	private JTextField iva3C;
	private JTextField imp3C;
	private JTextField cod4C;
	private JTextField tex4C;
	private JTextField ud4C;
	private JTextField price4C;
	private JTextField iva4C;
	private JTextField imp4C;
	private JTextField cod5C;
	private JTextField tex5C;
	private JTextField ud5C;
	private JTextField price5C;
	private JTextField iva5C;
	private JTextField imp5C;
	
	private JTextField baseImpC;
	private JTextField cuotaIvaC;
	private JTextField retencIRPFC;
	private JTextField importeTotalC;
	
	private JButton anadirFC;
	private JButton info;
	private JButton delF1C;
	private JButton delF2C;
	private JButton delF3C;
	private JButton delF4C;
	private JButton delF5C;

	private JButton borrarFC;

	
	// DATOS DE LA FACTURA EN BORRADO
	private List<String[]> datosFactC;				// lista de los datos facturados
	@SuppressWarnings("unused")
	private String nextNumberFact;					// Num. de factura (numérico)
	private List<String[]> listClientesFacC;		// lista de clientes seleccionables para modificar
	private List<String[]> listInvoiceC;			// lista de facturas seleccionables para modificar

	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	private final Color COLORL=Color.BLACK;
	
	
	public PanelInvoicesDeleting () {
		// CONSTRUCTOR

	}
	
	
	public void setDateEsp (ClockAndDate date) {
		// spring
		this.dateEsp=date;	
	}
	
	public void setClienteFac(ClientesBean customer) {
		// spring
		this.clienteFac=customer;
	}
	
	public void setFacturador (FacturasBean fact) {
		// spring
		this.facturador=fact;
	}

	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	

	
	
	/**
	 * Método que permite el borrado de la factura, mostrándola en el panel.
	 * 
	 * @return - un JPanel componiendo la pantalla de factura
	 */
	
	public JPanel eraseInvoice(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
		// creamos los objetos swing
		marcoAux0C=new JPanel();
		Dimension panDim0=new Dimension(650,55);
		marcoAux0C.setMinimumSize(panDim0);
		marcoAux0C.setPreferredSize(panDim0);
		marcoAux0C.setMaximumSize(panDim0);
		Dimension panDim1=new Dimension(650,450);
		marcoAux1C=new JPanel();
		marcoAux1C.setMinimumSize(panDim1);
		marcoAux1C.setPreferredSize(panDim1);
		marcoAux1C.setMaximumSize(panDim1);

		
		// titulo
		JLabel titleC=new JLabel("                          FACTURACIÓN - BORRADO                      ");
		titleC.setFont(font1);
		// creamos el formulario
		
		// cabecera
		//factura=new FacturasCean();	
		selInvoiceC=new JComboBox<String>();
		selInvoiceC.addItem("Seleccione número...");
		//clienteFac=new ClientesCean();
		if ((listInvoiceC=facturador.searchAllInvoiceNumber())==null) {
			listInvoiceC=new ArrayList<String[]>();
		}
		for (String[] data: listInvoiceC) {
			selInvoiceC.addItem(data[1]);
		}
		invoiceNumberC=new JTextField("");
		invoiceNumberC.setEditable(false);
		
		
		selCustomerInvC=new JComboBox<String>();
		selCustomerInvC.addItem("Seleccione cliente...");
		
		//clienteFac=new ClientesCean();
		listClientesFacC=clienteFac.getListCustomers();
		if (listClientesFacC==null) {
			listClientesFacC=new ArrayList<String[]>();
		}
		
		selCustomerInvC.setEnabled(false);
		/*
		for (String[] data: listClientesFacC) {
			selCustomerInvC.addItem(data[2]);
		}
		*/
		nameCustomerInvC=new JTextField("");
		nameCustomerInvC.setEditable(false);		
		
		dateCustomerInvC=new JTextField(dateEsp.getDate());
		dateCustomerInvC.setEditable(false);
		
		numberCustomerInvC=new JTextField("");
		numberCustomerInvC.setEditable(false);	
		
		// zona inputs
		numberOpC=new JComboBox<String>();
		numberOpC.setEnabled(false);
		//numberOpC.addItem("Entrada directa");
		textOpC=new JTextField("");
		textOpC.setEditable(false);
		textOpC.setToolTipText("OBLIGATORIO: máximo 200 caracteres");
		qttOpC=new JTextField("");
		qttOpC.setEditable(false);
		textOpC.setToolTipText("campo numérico");
		priceOpC=new JTextField("");
		priceOpC.setEditable(false);
		priceOpC.setToolTipText("campo numérico");
		
		ivaOpC=new JComboBox<String>();
		ivaOpC.setEnabled(false);

		amountOpC=new JTextField();
		amountOpC.setEditable(false);
		
		anadirFC=new JButton("intro");
		anadirFC.setEnabled(false);
		anadirFC.setToolTipText("pulse para incorporar datos");
		
		marcoHead0C=new JPanel();
		marcoHead1C=new JPanel();
		marcoHead2C=new JPanel();
		marcoHead3C=new JPanel();
		marcoInput1C=new JPanel();
		marcoInput2C=new JPanel();
		marcoAux01C=new JPanel();
		marcoAux02C=new JPanel();	
		marcoAux11C=new JPanel();
		marcoAux11_CC=new JPanel();
		marcoAux12C=new JPanel();
		marcoAux21C=new JPanel();
		marcoAux21_CC=new JPanel();
		marcoAux22C=new JPanel();
		marcoAux31C=new JPanel();
		marcoAux31_CC=new JPanel();
		marcoAux32C=new JPanel();
		marcoAux41C=new JPanel();
		marcoAux41_CC=new JPanel();
		marcoAux42C=new JPanel();
		marcoAux51C=new JPanel();
		marcoAux51_CC=new JPanel();
		marcoAux52C=new JPanel();
		marcoAux61C=new JPanel();
		marcoAux62C=new JPanel();
		marcoAux71C=new JPanel();
		marcoAux72C=new JPanel();
		
		marcoHead0C.setLayout(new GridLayout(1,2));
		marcoHead1C.setLayout(new GridLayout(1,2));
		marcoHead2C.setLayout(new GridLayout(1,2));
		marcoHead3C.setLayout(new GridLayout(1,2));
		marcoInput1C.setLayout(new GridLayout(1,2));
		marcoInput2C.setLayout(new GridLayout(1,4));
		marcoAux01C.setLayout(new GridLayout(1,2));
		marcoAux02C.setLayout(new GridLayout(1,4));		
		marcoAux11C.setLayout(new GridLayout(1,2));
		marcoAux11_CC.setLayout(new BoxLayout(marcoAux11_CC,BoxLayout.X_AXIS));
		marcoAux12C.setLayout(new GridLayout(1,4));
		marcoAux21C.setLayout(new GridLayout(1,2));
		marcoAux21_CC.setLayout(new BoxLayout(marcoAux21_CC,BoxLayout.X_AXIS));
		marcoAux22C.setLayout(new GridLayout(1,4));
		marcoAux31C.setLayout(new GridLayout(1,2));
		marcoAux31_CC.setLayout(new BoxLayout(marcoAux31_CC,BoxLayout.X_AXIS));
		marcoAux32C.setLayout(new GridLayout(1,4));
		marcoAux41C.setLayout(new GridLayout(1,2));
		marcoAux41_CC.setLayout(new BoxLayout(marcoAux41_CC,BoxLayout.X_AXIS));
		marcoAux42C.setLayout(new GridLayout(1,4));
		marcoAux51C.setLayout(new GridLayout(1,2));
		marcoAux51_CC.setLayout(new BoxLayout(marcoAux51_CC,BoxLayout.X_AXIS));
		marcoAux52C.setLayout(new GridLayout(1,4));
		marcoAux61C.setLayout(new GridLayout(1,2));
		marcoAux62C.setLayout(new GridLayout(1,2));
		marcoAux71C.setLayout(new GridLayout(1,1));
		marcoAux72C.setLayout(new GridLayout(1,3));
		
		cod1C=new JTextField("");
		cod1C.setEditable(false);
		tex1C=new JTextField("");
		tex1C.setEditable(false);
		ud1C=new JTextField("");
		ud1C.setEditable(false);
		price1C=new JTextField("");
		price1C.setEditable(false);
		iva1C=new JTextField("");
		iva1C.setEditable(false);
		imp1C=new JTextField("");
		imp1C.setEditable(false);
		cod2C=new JTextField("");
		cod2C.setEditable(false);
		tex2C=new JTextField("");
		tex2C.setEditable(false);
		ud2C=new JTextField("");
		ud2C.setEditable(false);
		price2C=new JTextField("");
		price2C.setEditable(false);
		iva2C=new JTextField("");
		iva2C.setEditable(false);
		imp2C=new JTextField("");
		imp2C.setEditable(false);
		cod3C=new JTextField("");
		cod3C.setEditable(false);
		tex3C=new JTextField("");
		tex3C.setEditable(false);
		ud3C=new JTextField("");
		ud3C.setEditable(false);
		price3C=new JTextField("");
		price3C.setEditable(false);
		iva3C=new JTextField("");
		iva3C.setEditable(false);
		imp3C=new JTextField("");
		imp3C.setEditable(false);
		cod4C=new JTextField("");
		cod4C.setEditable(false);
		tex4C=new JTextField("");
		tex4C.setEditable(false);
		ud4C=new JTextField("");
		ud4C.setEditable(false);
		price4C=new JTextField("");
		price4C.setEditable(false);
		iva4C=new JTextField("");
		iva4C.setEditable(false);
		imp4C=new JTextField("");
		imp4C.setEditable(false);
		cod5C=new JTextField("");
		cod5C.setEditable(false);
		tex5C=new JTextField("");
		tex5C.setEditable(false);
		ud5C=new JTextField("");
		ud5C.setEditable(false);
		price5C=new JTextField("");
		price5C.setEditable(false);
		iva5C=new JTextField("");
		iva5C.setEditable(false);
		imp5C=new JTextField("");
		imp5C.setEditable(false);
		
		Dimension dim=new Dimension(45,20);	
		delF1C=new JButton("X");
		delF1C.setEnabled(false);
		delF1C.setPreferredSize(dim);
		delF1C.setMaximumSize(dim);
		delF1C.setMinimumSize(dim);
		
		delF2C=new JButton("X");
		delF2C.setEnabled(false);
		delF2C.setPreferredSize(dim);
		delF2C.setMaximumSize(dim);
		delF2C.setMinimumSize(dim);
		
		delF3C=new JButton("X");
		delF3C.setEnabled(false);
		delF3C.setPreferredSize(dim);
		delF3C.setMaximumSize(dim);
		delF3C.setMinimumSize(dim);
		
		delF4C=new JButton("X");		
		delF4C.setEnabled(false);
		delF4C.setPreferredSize(dim);
		delF4C.setMaximumSize(dim);
		delF4C.setMinimumSize(dim);

		
		delF5C=new JButton("X");	
		delF5C.setEnabled(false);
		delF5C.setPreferredSize(dim);
		delF5C.setMaximumSize(dim);
		delF5C.setMinimumSize(dim);
		
		baseImpC=new JTextField("");
		baseImpC.setEditable(false);
		cuotaIvaC=new JTextField("");
		cuotaIvaC.setEditable(false);
		retencIRPFC=new JTextField("");
		if (SpringFacturacion.retInvoices==0) {
			retencIRPFC=new JTextField("0,00");			
		}
		retencIRPFC.setEditable(false);
		importeTotalC=new JTextField("");
		importeTotalC.setEditable(false);
		
		marcoHead0C.add(selInvoiceC);
		marcoHead0C.add(invoiceNumberC);
		marcoHead1C.add(selCustomerInvC);
		marcoHead1C.add(nameCustomerInvC);
		marcoHead2C.add(new JLabel("Fecha: (dd-mm-aaaa)"));
		marcoHead2C.add(dateCustomerInvC);
		marcoHead3C.add(new JLabel("Número:"));
		marcoHead3C.add(numberCustomerInvC);
		
		marcoAux01C.add(new JLabel("código"));
		marcoAux01C.add(new JLabel("   texto"));
		marcoAux02C.add(new JLabel("     uds."));
		marcoAux02C.add(new JLabel("   importe"));
		marcoAux02C.add(new JLabel("     iva"));
		marcoAux02C.add(new JLabel(""));
		marcoInput1C.add(numberOpC);
		marcoInput1C.add(textOpC);
		marcoInput2C.add(qttOpC);
		marcoInput2C.add(priceOpC);
		marcoInput2C.add(ivaOpC);
		marcoInput2C.add(anadirFC);
		marcoAux11_CC.add(delF1C);
		marcoAux11_CC.add(cod1C);
		marcoAux11C.add(marcoAux11_CC);
		marcoAux11C.add(tex1C);
		marcoAux12C.add(ud1C);
		marcoAux12C.add(price1C);
		marcoAux12C.add(iva1C);
		marcoAux12C.add(imp1C);
		marcoAux21_CC.add(delF2C);
		marcoAux21_CC.add(cod2C);
		marcoAux21C.add(marcoAux21_CC);
		marcoAux21C.add(tex2C);
		marcoAux22C.add(ud2C);
		marcoAux22C.add(price2C);
		marcoAux22C.add(iva2C);
		marcoAux22C.add(imp2C);
		marcoAux31_CC.add(delF3C);
		marcoAux31_CC.add(cod3C);
		marcoAux31C.add(marcoAux31_CC);
		marcoAux31C.add(tex3C);
		marcoAux32C.add(ud3C);
		marcoAux32C.add(price3C);
		marcoAux32C.add(iva3C);
		marcoAux32C.add(imp3C);
		marcoAux41_CC.add(delF4C);
		marcoAux41_CC.add(cod4C);
		marcoAux41C.add(marcoAux41_CC);
		marcoAux41C.add(tex4C);
		marcoAux42C.add(ud4C);
		marcoAux42C.add(price4C);
		marcoAux42C.add(iva4C);
		marcoAux42C.add(imp4C);
		marcoAux51_CC.add(delF5C);
		marcoAux51_CC.add(cod5C);
		marcoAux51C.add(marcoAux51_CC);
		marcoAux51C.add(tex5C);
		marcoAux52C.add(ud5C);
		marcoAux52C.add(price5C);
		marcoAux52C.add(iva5C);
		marcoAux52C.add(imp5C);
		marcoAux61C.add(baseImpC);
		marcoAux61C.add(cuotaIvaC);
		marcoAux62C.add(retencIRPFC);
		marcoAux62C.add(importeTotalC);
		
		// preparamos los botones 

		borrarFC=new JButton("Borrar factura");	
		borrarFC.setToolTipText("pulse para eliminar la factura");

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
		
		marcoAux71C.add(new JLabel());
		marcoAux72C.add(new JLabel());
		marcoAux72C.add(borrarFC);
		marcoAux72C.add(new JLabel());
		

		// añadimos todos los elementos a los JPanel auxiliares
		marcoAux0C.add(titleC);
		marcoAux0C.add(panelButton3);
		
		marcoAux1C.setLayout(new GridLayout(19,2));

		marcoAux1C.add(marcoHead0C);
		marcoAux1C.add(new JLabel(""));
		marcoAux1C.add(marcoHead1C);
		marcoAux1C.add(new JLabel(""));	
		marcoAux1C.add(marcoHead2C);
		marcoAux1C.add(new JLabel(""));		
		marcoAux1C.add(marcoHead3C);
		marcoAux1C.add(new JLabel(""));

		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(new JLabel(" INTRODUCCIÓN DE DATOS:"));
		marcoAux1C.add(new JLabel(" "));

		marcoAux1C.add(marcoAux01C);
		marcoAux1C.add(marcoAux02C);
		marcoAux1C.add(marcoInput1C);
		marcoAux1C.add(marcoInput2C);
		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(new JLabel(" "));

		marcoAux1C.add(new JLabel("VISUALIZACIÓN ÚLTIMOS APUNTES"));
		marcoAux1C.add(new JLabel(" "));	
		marcoAux1C.add(marcoAux11C);
		marcoAux1C.add(marcoAux12C);		
		marcoAux1C.add(marcoAux21C);
		marcoAux1C.add(marcoAux22C);
		marcoAux1C.add(marcoAux31C);
		marcoAux1C.add(marcoAux32C);
		marcoAux1C.add(marcoAux41C);
		marcoAux1C.add(marcoAux42C);
		marcoAux1C.add(marcoAux51C);
		marcoAux1C.add(marcoAux52C);
		
		marcoAux1C.add(new JLabel("   Base Imponible                                    Cuota iva"));
		marcoAux1C.add(new JLabel("  Retención                                               Importe total IVA incluido"));
		marcoAux1C.add(marcoAux61C);
		marcoAux1C.add(marcoAux62C);
		
		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(marcoAux71C);
		marcoAux1C.add(marcoAux72C);
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0C,BorderLayout.NORTH);
		marco2.add(marcoAux1C,BorderLayout.CENTER);
		marco2.add(new JLabel("     "),BorderLayout.EAST);
		marco2.add(new JLabel("     "),BorderLayout.WEST);
		marco2.add(new JLabel("     "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		selInvoiceC.addItemListener(this);
		//selCustomerInvC.addItemListener(this);
		borrarFC.addActionListener(this);
		anadirFC.addActionListener(this);
		info.addActionListener(this);
		delF1C.addActionListener(this);
		delF2C.addActionListener(this);
		delF3C.addActionListener(this);
		delF4C.addActionListener(this);
		delF5C.addActionListener(this);
		
		return marco2;
				
	} // end of method EraseFactura
	
	
	
	/**
	 * Este método muestra en el formulario la factura seleccionada para ser borrada.
	 * 
	 * @param invoiceToErase - Facturas, objeto conteniendo la información de la factura seleccionada.
	 */
	
	private void showInvoiceToErase(Facturas invoiceToErase) {
		//  CABECERA
		nameCustomerInvC.setText(invoiceToErase.getNameCustomer());
		String fecha=dateEsp.convertDateToString(invoiceToErase.getDateF());
		dateCustomerInvC.setText(fecha);		
		numberCustomerInvC.setText(invoiceToErase.getSerial()+"/"+invoiceToErase.getNumber());
		// DETALLE MOVIMIENTOS
		
		datosFactC=invoiceToErase.getDataInvoice();
		int longData=datosFactC.size();
		if (longData>5) {
			longData=5;
		}
		
		switch (longData) {
		case 5:
			cod5C.setText(datosFactC.get(5)[0]);
			tex5C.setText(datosFactC.get(5)[1]);
			ud5C.setText(datosFactC.get(5)[2]);
			price5C.setText(datosFactC.get(5)[3]);
			iva5C.setText(datosFactC.get(5)[4]);
			imp5C.setText(datosFactC.get(5)[5]);

		case 4:
			cod4C.setText(datosFactC.get(4)[0]);
			tex4C.setText(datosFactC.get(4)[1]);
			ud4C.setText(datosFactC.get(4)[2]);
			price4C.setText(datosFactC.get(4)[3]);
			iva4C.setText(datosFactC.get(4)[4]);
			imp4C.setText(datosFactC.get(4)[5]);

		case 3:
			cod3C.setText(datosFactC.get(3)[0]);
			tex3C.setText(datosFactC.get(3)[1]);
			ud3C.setText(datosFactC.get(3)[2]);
			price3C.setText(datosFactC.get(3)[3]);
			iva3C.setText(datosFactC.get(3)[4]);
			imp3C.setText(datosFactC.get(3)[5]);

		case 2:
			cod2C.setText(datosFactC.get(1)[0]);
			tex2C.setText(datosFactC.get(1)[1]);
			ud2C.setText(datosFactC.get(1)[2]);
			price2C.setText(datosFactC.get(1)[3]);
			iva2C.setText(datosFactC.get(1)[4]);
			imp2C.setText(datosFactC.get(1)[5]);
		
		case 1:
			cod1C.setText(datosFactC.get(0)[0]);
			tex1C.setText(datosFactC.get(0)[1]);
			ud1C.setText(datosFactC.get(0)[2]);
			price1C.setText(datosFactC.get(0)[3]);
			iva1C.setText(datosFactC.get(0)[4]);
			imp1C.setText(datosFactC.get(0)[5]);
			break;
		}
				
		// RESUMEN FACTURA
		double bases=invoiceToErase.getBaseImponible0()+invoiceToErase.getBaseImponible1()+invoiceToErase.getBaseImponible2()+invoiceToErase.getBaseImponible3();
		baseImpC.setText(formatoDecimal.format(bases));
		double cuotas=invoiceToErase.getIva1()+invoiceToErase.getIva2()+invoiceToErase.getIva3();
		cuotaIvaC.setText(formatoDecimal.format(cuotas));
		double retenciones=invoiceToErase.getRetencion();
		retencIRPFC.setText(formatoDecimal.format(retenciones));
		importeTotalC.setText(formatoDecimal.format(bases+cuotas-retenciones));
		
		
	} // end of showInvoiceToErase
	
	
	
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
				"2.- Si desea borrar la factura, pulse el botón 'Borrar factura'.\n" +
				"3.- La aplicación le solicitará confirmación para eliminar la factura.\n" +
				"    Si se confirma, la factura será borrada totalmente.\n" +
				"4.- Si solamente desea borrar un apunte de la factura, deberá hacerlo\n" +
				"    desde 'modificación'.\n");

		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE BORRADO FACTURAS"));
		
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
		
		if (source.equals("Borrar factura")) {
			
			if (!(numberCustomerInvC.getText().trim().isEmpty() || numberCustomerInvC.getText().trim().equals(""))) {
				// si hay factura seleccionada...
				if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar la factura seleccionada en el formulario?", "Borrado de facturas", JOptionPane.YES_NO_OPTION)==0) {
					String numDel=selInvoiceC.getSelectedItem().toString();

					if (facturador.eraseInvoice(numDel, SpringFacturacion.serialInvoices)) {
						
						// una vez borrada la factura, revisamos los albaranes grabados.
						// los datos de introduccion directa (999999) los ignoramos
						// los albaranes grabados (distintos de 999999) los pasamos a pendiente
						for (String a[]:invoiceToErase.getDataInvoice()) {
							if (!(a[0].equals("999999"))) {
								if (!albaranes.changeToPendingState(a[0])) {
									// si algun albaran no pudo pasar a pendiente por error
									JOptionPane.showMessageDialog(mainFrame, "Algún albarán no pudo dejarse pendiente.\nRevise la factura borrada y\n" +
											"compruebe que todos los albaranes están\n" +
											"ahora pendientes.","Borrado de facturas",JOptionPane.ERROR_MESSAGE);
								}						
							} 
						}
						
						JOptionPane.showMessageDialog(mainFrame, "Factura borrada correctamente","Borrado de facturas",JOptionPane.INFORMATION_MESSAGE);
						// mostrando el numero de factura			
						if (numDel.equals(formatoFactura.format(SpringFacturacion.lastInvoiceNumber))) {
							// si la borrada fue el ultimo numero de factura, podemos utilizar ese numero, retrocedemos
							// y lo mostramos como siguiente valido para grabar
							SpringFacturacion.lastInvoiceNumber=SpringFacturacion.lastInvoiceNumber-1;
						} 
						
						nextNumberFact=formatoFactura.format(SpringFacturacion.lastInvoiceNumber+1);
						numberCustomerInvC.setText("");
						dateCustomerInvC.setText("");
						
						// eliminando la lista
						datosFactC=new ArrayList<String[]>();
						listInvoiceC=new ArrayList<String[]>();
						selInvoiceC=new JComboBox<String>();
						selInvoiceC.addItem("Seleccione número...");
						
						if ((listInvoiceC=facturador.searchAllInvoiceNumber())==null) {
							listInvoiceC=new ArrayList<String[]>();
						}
						for (String[] data: listInvoiceC) {
							selInvoiceC.addItem(data[1]);
						}
						
						// Eliminando la parte grafica
						selInvoiceC.setSelectedIndex(0);
						selCustomerInvC.setSelectedIndex(0);
						nameCustomerInvC.setText("");
						
						//numberOpC.setSelectedIndex(0);
						textOpC.setText("");
						qttOpC.setText("");
						priceOpC.setText("");
						//ivaOpC.setSelectedIndex(0);
						amountOpC.setText("");
						
						cod1C.setText("");
						tex1C.setText("");
						ud1C.setText("");
						price1C.setText("");
						iva1C.setText("");
						imp1C.setText("");
						cod2C.setText("");
						tex2C.setText("");
						ud2C.setText("");
						price2C.setText("");
						iva2C.setText("");
						imp2C.setText("");
						cod3C.setText("");
						tex3C.setText("");
						ud3C.setText("");
						price3C.setText("");
						iva3C.setText("");
						imp3C.setText("");
						cod4C.setText("");
						tex4C.setText("");
						ud4C.setText("");
						price4C.setText("");
						iva4C.setText("");
						imp4C.setText("");
						cod5C.setText("");
						tex5C.setText("");
						ud5C.setText("");
						price5C.setText("");
						iva5C.setText("");
						imp5C.setText("");
						
						baseImpC.setText("");
						cuotaIvaC.setText("");
						importeTotalC.setText("");
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Error en borrado de factura","Borrado de facturas",JOptionPane.ERROR_MESSAGE);
					}	
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Debe seleccionar una factura para borrar.","Borrado de facturas",JOptionPane.ERROR_MESSAGE);
			}
				
				

	
		}  // end of borrar factura
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	} // end of actionPerformed

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (selInvoiceC!=null && selInvoiceC.getSelectedIndex()!=0) {
			String data=String.valueOf(selInvoiceC.getSelectedItem());
			invoiceToErase=facturador.getInvoice(data);
			showInvoiceToErase(invoiceToErase);
		}
		
		if (selInvoiceC!=null && selInvoiceC.getSelectedIndex()==0) {
			// Eliminando la parte grafica

			selCustomerInvC.setSelectedIndex(0);
			nameCustomerInvC.setText("");
			dateCustomerInvC.setText("");
			numberCustomerInvC.setText("");
			
			//numberOpC.setSelectedIndex(0);
			textOpC.setText("");
			qttOpC.setText("");
			priceOpC.setText("");
			//ivaOpC.setSelectedIndex(0);
			amountOpC.setText("");
			
			cod1C.setText("");
			tex1C.setText("");
			ud1C.setText("");
			price1C.setText("");
			iva1C.setText("");
			imp1C.setText("");
			cod2C.setText("");
			tex2C.setText("");
			ud2C.setText("");
			price2C.setText("");
			iva2C.setText("");
			imp2C.setText("");
			cod3C.setText("");
			tex3C.setText("");
			ud3C.setText("");
			price3C.setText("");
			iva3C.setText("");
			imp3C.setText("");
			cod4C.setText("");
			tex4C.setText("");
			ud4C.setText("");
			price4C.setText("");
			iva4C.setText("");
			imp4C.setText("");
			cod5C.setText("");
			tex5C.setText("");
			ud5C.setText("");
			price5C.setText("");
			iva5C.setText("");
			imp5C.setText("");
			
			baseImpC.setText("");
			cuotaIvaC.setText("");
			importeTotalC.setText("");
		}
		
	} // end of itemStateChanged
	
	
	

} // ************ END OF CLASS
