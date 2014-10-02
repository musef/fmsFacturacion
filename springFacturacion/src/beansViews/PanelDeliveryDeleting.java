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

import main.SpringFacturacion;
import beansControls.AlbaranesBean;
import beansControls.ClientesBean;
import beansControls.ClockAndDate;
import beansModels.Albaranes;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelDeliveryDeleting implements ActionListener, ItemListener {
		
	// spring objects
	private ClockAndDate dateEsp;
	private ClientesBean clienteFac;
	private EnterSandMan reinicia;
	
	private AlbaranesBean albaranes;
	//private ListadosPdf dataList;	
	
	// not a spring object
	private Albaranes deliveryToErase;
	
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
	
	private JComboBox<String> selDeliveryC;
	private JComboBox<String> selCustomerInvC;
	private JTextField deliveryNumberC;
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
	
	private JTextField baseImpC;
	private JTextField cuotaIvaC;
	private JTextField retencIRPFC;
	private JTextField importeTotalC;
	
	private JButton anadirFC;
	private JButton info;
	private JButton delF1C;
	private JButton delF2C;
	private JButton delF3C;


	private JButton borrarFC;

	
	// DATOS DE LA FACTURA EN BORRADO
	@SuppressWarnings("unused")
	private List<String[]> datosAlbC;				// lista de los datos de albaranes
	@SuppressWarnings("unused")
	private String nextNumberDelivery;				// siguiente num. de albaran  (numérico)
	@SuppressWarnings("unused")
	private List<String[]> listClientesFacC;		// lista de clientes seleccionables 
	private List<String[]> listDeliveryC;			// lista de albaranes pendientes de facturar

	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	private final Color COLORL=Color.BLACK;
	
	
	
	public PanelDeliveryDeleting() {
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
	
	public void setAlbaranes (AlbaranesBean albaranes) {
		// spring
		this.albaranes=albaranes;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}

	
	/**
	 * Método que permite el borrado del albarán, mostrándolo en el panel.
	 * 
	 * @return - un JPanel componiendo el formulario con el albarán a borrar
	 */
	
	public JPanel eraseDelivery(JFrame mainFrame) {
		
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
		JLabel titleC=new JLabel("                            ALBARANES - BORRADO                      ");
		titleC.setFont(font1);
		// creamos el formulario
		
		// cabecera
			
		selDeliveryC=new JComboBox<String>();
		selDeliveryC.addItem("Seleccione número...");
		//clienteFac=new ClientesCean();
		listDeliveryC=albaranes.searchAllDeliveriesPending();
		if (listDeliveryC==null) {
			listDeliveryC=new ArrayList<String[]>();
		}
		for (String[] data: listDeliveryC) {
			selDeliveryC.addItem(data[3]);
		}
		deliveryNumberC=new JTextField("");
		deliveryNumberC.setEditable(false);
				
		selCustomerInvC=new JComboBox<String>();
		selCustomerInvC.addItem("Seleccione cliente...");
		selCustomerInvC.setEnabled(false);
		nameCustomerInvC=new JTextField("");
		nameCustomerInvC.setEditable(false);		
		
		dateCustomerInvC=new JTextField("");
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
		
		marcoHead0C.add(selDeliveryC);
		marcoHead0C.add(deliveryNumberC);
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

		marcoAux61C.add(baseImpC);
		marcoAux61C.add(cuotaIvaC);
		marcoAux62C.add(retencIRPFC);
		marcoAux62C.add(importeTotalC);
		
		// preparamos los botones 
		borrarFC=new JButton("Borrar albarán");	
		borrarFC.setToolTipText("pulse para eliminar el albarán");

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
		
		marcoAux1C.setLayout(new GridLayout(18,2));

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
		marcoAux1C.add(new JLabel(" "));
		marcoAux1C.add(new JLabel(" "));
		
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
		selDeliveryC.addItemListener(this);
		selCustomerInvC.addItemListener(this);
		borrarFC.addActionListener(this);
		anadirFC.addActionListener(this);
		info.addActionListener(this);
		delF1C.addActionListener(this);
		delF2C.addActionListener(this);
		delF3C.addActionListener(this);
		
		return marco2;
				
	} // end of method EraseFactura
	
	
	
	/**
	 * Metodo que muestra los datos del albaran a borrar en el formulario.
	 * 
	 * @param deliveryToErase - Albaranes, objeto con los datos del albaran a mostrar antes de borrar
	 */
	
	private void showDeliveryToErase(Albaranes deliveryToErase) {
		
		//  CABECERA
		String codeCustomer=deliveryToErase.getCodeCustomer();
		nameCustomerInvC.setText(clienteFac.getCustomer(codeCustomer)[2]);
		String fecha=dateEsp.convertDateToString(deliveryToErase.getDateOper());
		dateCustomerInvC.setText(fecha);		
		numberCustomerInvC.setText(deliveryToErase.getNumber());
		
		// DETALLE MOVIMIENTOS
		if (!deliveryToErase.getCodeOper3().isEmpty()) {
			cod3C.setText(deliveryToErase.getCodeOper3());
			tex3C.setText(deliveryToErase.getTextOper3());
			ud3C.setText(formatoDecimal.format(deliveryToErase.getQttOper3()));
			price3C.setText(formatoDecimal.format(deliveryToErase.getPriceOper3()));
			iva3C.setText(formatoDecimal.format(deliveryToErase.getIvaOper2()));
			imp3C.setText(formatoDecimal.format(deliveryToErase.getPriceOper3()*deliveryToErase.getQttOper3()*deliveryToErase.getIvaOper3()/100));
		}

		if (!deliveryToErase.getCodeOper2().isEmpty()) {
			cod2C.setText(deliveryToErase.getCodeOper2());
			tex2C.setText(deliveryToErase.getTextOper2());
			ud2C.setText(formatoDecimal.format(deliveryToErase.getQttOper2()));
			price2C.setText(formatoDecimal.format(deliveryToErase.getPriceOper2()));
			iva2C.setText(formatoDecimal.format(deliveryToErase.getIvaOper2()));
			imp2C.setText(formatoDecimal.format(deliveryToErase.getPriceOper2()*deliveryToErase.getQttOper2()*deliveryToErase.getIvaOper2()/100));
		}

		if (!deliveryToErase.getCodeOper1().isEmpty()) {
			cod1C.setText(deliveryToErase.getCodeOper1());
			tex1C.setText(deliveryToErase.getTextOper1());
			ud1C.setText(formatoDecimal.format(deliveryToErase.getQttOper1()));
			price1C.setText(formatoDecimal.format(deliveryToErase.getPriceOper1()));
			iva1C.setText(formatoDecimal.format(deliveryToErase.getIvaOper1()));
			imp1C.setText(formatoDecimal.format(deliveryToErase.getPriceOper1()*deliveryToErase.getQttOper1()*deliveryToErase.getIvaOper1()/100));
		}
				
		// RESUMEN FACTURA
		double bases=deliveryToErase.getBaseImponible0()+deliveryToErase.getBaseImponible1()+deliveryToErase.getBaseImponible2()+deliveryToErase.getBaseImponible3();
		baseImpC.setText(formatoDecimal.format(bases));
		double cuotas=deliveryToErase.getIva1()+deliveryToErase.getIva2()+deliveryToErase.getIva3();

		cuotaIvaC.setText(formatoDecimal.format(cuotas));
		double retenciones=deliveryToErase.getRetencion();
		retencIRPFC.setText(formatoDecimal.format(retenciones));
		importeTotalC.setText(formatoDecimal.format(bases+cuotas-retenciones));
		
		
	} // end of showDeliveryToErase
	
	
	
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
				"1.- Primeramente deberá seleccionar el albarán que quiere eliminar. Solo podrá\n" +
				"    eliminar albaranes que aún no estén facturados.\n" +
				"2.- Seleccione de la lista el albarán que desea eliminar.\n" +
				"3.- Una vez seleccionado el albarán, los datos se mostrarán en el formulario.\n" +
				"4.- Si desea borrarlo, pulse en el botón 'Borrar albarán'. La aplicacion le pedirá\n" +
				"    la confirmación. En caso afirmativo, el albarán será eliminado.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE BORRADO DE ALBARANES"));
		
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
		
		if (source.equals("Borrar albarán")) {

			String numDel=selDeliveryC.getSelectedItem().toString();
			
			if (!(numberCustomerInvC.getText().trim().isEmpty() || numberCustomerInvC.getText().trim().equals(""))) {
				// si hay albaran seleccionado...
				
				if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar el albarán seleccionado en el formulario?", "Borrado de albaranes", JOptionPane.YES_NO_OPTION)==0) {
					
					// comprueba que el albaran no esta facturado
					// en realidad el programa no permite borrar un albaran facturado, no lo muestra en el menu
					if (albaranes.getDelivery(numDel).getInvoice().isEmpty()) {
						
						if (albaranes.eraseDelivery(numDel)) {
							JOptionPane.showMessageDialog(mainFrame, "Albarán borrado correctamente","Borrado de albaranes",JOptionPane.INFORMATION_MESSAGE);
							// mostrando el numero de albaran			
							nextNumberDelivery=formatoFactura.format(albaranes.getNextNumber());
							numberCustomerInvC.setText("");
							dateCustomerInvC.setText("");
							
							// eliminando la lista
							datosAlbC=new ArrayList<String[]>();
							listDeliveryC=new ArrayList<String[]>();
							selDeliveryC=new JComboBox<String>();
							selDeliveryC.addItem("Seleccione número...");
							//clienteFac=new ClientesCean();
							listDeliveryC=albaranes.searchAllDeliveriesPending();
							if (listDeliveryC==null) {
								listDeliveryC=new ArrayList<String[]>();
							}
							for (String[] data: listDeliveryC) {
								selDeliveryC.addItem(data[1]);
							}
							
							// Eliminando la parte grafica
							selDeliveryC.setSelectedIndex(0);
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
							
							baseImpC.setText("");
							cuotaIvaC.setText("");
							importeTotalC.setText("");
							
							// se actualizan pestañas
							reinicia.reinicia(3,3);
							
						} else {
							JOptionPane.showMessageDialog(mainFrame, "Error en borrado de albarán","Borrado de albaranes",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(mainFrame, "No es posible borrar este albarán\n" +
								"porque está facturado.\n\nSi quiere borrarlo, primero deberá\n" +
								"eliminarlo de la factura.","Borrado de albaranes",JOptionPane.ERROR_MESSAGE);
					}			
				}	

			} else {
				JOptionPane.showMessageDialog(mainFrame, "Debe seleccionar un albarán para eliminar.","Borrado de albaranes",JOptionPane.ERROR_MESSAGE);
			} 
			
		}  // end of borrar albaran
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
	} // end of actionPerformed

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (selDeliveryC!=null && selDeliveryC.getSelectedIndex()!=0) {
			String data=String.valueOf(selDeliveryC.getSelectedItem());
			deliveryToErase=albaranes.getDelivery(data);
			if (deliveryToErase!=null) {
				// muestra el albaran
				showDeliveryToErase(deliveryToErase);
			}			
		}
		
		if (selDeliveryC!=null && selDeliveryC.getSelectedIndex()==0) {
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
			
			baseImpC.setText("");
			cuotaIvaC.setText("");
			importeTotalC.setText("");
		}
		
	} // end of itemStateChanged
	
	

} // ************ END OF CLASS
