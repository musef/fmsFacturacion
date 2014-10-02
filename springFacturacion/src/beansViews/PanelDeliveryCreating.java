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
import beansControls.TiposIvaBean;
import beansControls.UtilsFacturacion;
import beansList.ListadosPdf;
import beansModels.Albaranes;

import main.SpringFacturacion;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class PanelDeliveryCreating extends UtilsFacturacion implements ActionListener, ItemListener {
	
	
	// spring objects
	private ClockAndDate dateEsp;
	private TiposIvaBean ivas;
	private ClientesBean clienteFac;
	
	private Albaranes datosF;
	private AlbaranesBean albaranes;
	private EnterSandMan reinicia;
	private ListadosPdf dataList;	
	
	private JFrame mainFrame;
	
	// CREAR FACTURAS
	private JPanel marcoAux0;
	private JPanel marcoAux1;
	private JPanel marcoHead1;
	private JPanel marcoHead2;
	private JPanel marcoHead3;
	private JPanel marcoInput1;
	private JPanel marcoInput2;
	private JPanel marcoInput3;
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
	
	//private final int LENGTHPANEL=3;
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
	
	private JTextField baseImp;
	private JTextField cuotaIva;
	private JTextField retencIRPF;
	private JTextField importeTotal;
	
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
	

	
	private JButton anadirF;
	private JButton delF1;
	private JButton delF2;
	private JButton delF3;
	private JButton grabarF;
	private JButton borrarF;
	private JButton info;
	
	private List<String[]> listClientesFac;
	private int indexCustomer;
	
	// DATOS EN CREACION
	private List<String[]> datosAlb;				// lista de los datos facturados
	private String nextNumber;						// siguiente albaran
	private String selectedCustomer;				// key del cliente a facturar
	
	
	// GENERAL
	private Font font1=new Font("SansSerif", Font.BOLD, 20);
	private final Color ERRORFORM=Color.RED;
	private final Color OKFORM=Color.WHITE;
	private final Color COLORL=Color.BLACK;
	private DecimalFormat formatoDecimal=new DecimalFormat("#,###.00");
	private DecimalFormat formatoFactura=new DecimalFormat("000000");
	
	
	
	public PanelDeliveryCreating() {
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
	
	public void setDatosF (Albaranes albaran) {
		// spring
		this.datosF=albaran;
	}
	
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	
	public void setDataList (ListadosPdf dataList) {
		// spring
		this.dataList=dataList;
	}

	
	
	
	
	/**
	 * Método que suministra el panel de nota de entrega con sus componentes.
	 * 
	 * @return - un JPanel componiendo la pantalla de albaranes
	 */
	
	public JPanel makeDelivery(JFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		
		JPanel marco2=new JPanel();
		
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
		datosAlb=new ArrayList<String[]>();
		
		// titulo
		JLabel title=new JLabel("                            ALBARANES - CREACIÓN                      ");
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

		nextNumber=formatoFactura.format(albaranes.getNextNumber());
		if (nextNumber.substring(0, 1).equals("0")) {
			String year=dateEsp.getDate().substring(6);
			nextNumber=year+nextNumber;
		}
		numberCustomerInv=new JTextField(nextNumber);
		numberCustomerInv.setToolTipText("OBLIGATORIO: máx 15 caracteres");	
		
		// zona inputs
		numberOp=new JComboBox<String>();
		numberOp.addItem("Entrada directa");
		textOp=new JTextField();
		textOp.setToolTipText("OBLIGATORIO: máximo 200 caracteres");
		qttOp=new JTextField();
		qttOp.setToolTipText("campo numérico");
		priceOp=new JTextField();
		priceOp.setToolTipText("campo numérico");
		
		ivaOp=new JComboBox<String>();
		//ivas=new TiposIvaBean();
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
				ivaOp.addItem(a[3]);
			}
		}
		
		amountOp=new JTextField();
		//amountOp.setToolTipText("campo numérico");
		amountOp.setEnabled(false);
		
		anadirF=new JButton("intro datos");
		anadirF.setToolTipText("pulse para incorporar datos");
		
		marcoHead1=new JPanel();
		marcoHead2=new JPanel();
		marcoHead3=new JPanel();
		marcoInput1=new JPanel();
		marcoInput2=new JPanel();
		marcoInput3=new JPanel();
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

		marcoAux61=new JPanel();
		marcoAux62=new JPanel();
		marcoAux71=new JPanel();
		marcoAux72=new JPanel();

		marcoHead1.setLayout(new GridLayout(1,2));
		marcoHead2.setLayout(new GridLayout(1,2));
		marcoHead3.setLayout(new GridLayout(1,2));
		marcoInput1.setLayout(new GridLayout(1,2));
		marcoInput2.setLayout(new GridLayout(1,4));
		marcoInput3.setLayout(new GridLayout(1,1));
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

		
		Dimension dim=new Dimension(45,20);	
		delF1=new JButton("X");
		delF1.setPreferredSize(dim);
		delF1.setMaximumSize(dim);
		delF1.setMinimumSize(dim);
		delF1.setToolTipText("Borrar este artículo");
		
		delF2=new JButton("X");		
		delF2.setPreferredSize(dim);
		delF2.setMaximumSize(dim);
		delF2.setMinimumSize(dim);
		delF2.setToolTipText("Borrar este artículo");
		
		delF3=new JButton("X");	
		delF3.setPreferredSize(dim);
		delF3.setMaximumSize(dim);
		delF3.setMinimumSize(dim);
		delF3.setToolTipText("Borrar este artículo");
		
		baseImp=new JTextField("");
		cuotaIva=new JTextField("");
		retencIRPF=new JTextField("");
		if (SpringFacturacion.retInvoices==0) {
			retencIRPF=new JTextField("0,00");
			retencIRPF.setEditable(false);
		}
		importeTotal=new JTextField("");

		marcoHead1.add(selCustomerInv);
		marcoHead1.add(nameCustomerInv);
		marcoHead2.add(new JLabel("Fecha: (dd-mm-aaaa)"));
		marcoHead2.add(dateCustomerInv);
		marcoHead3.add(new JLabel("Número:"));
		marcoHead3.add(numberCustomerInv);
		
		marcoAux01.add(new JLabel("código artículo"));
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
		marcoInput3.add(new JLabel(""));
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
		marcoAux61.add(baseImp);
		marcoAux61.add(cuotaIva);
		marcoAux62.add(retencIRPF);
		marcoAux62.add(importeTotal);
		
		// preparamos los botones 
		grabarF=new JButton("Grabar albarán");
		grabarF.setToolTipText("pulse para grabar el albarán");
		borrarF=new JButton("Borrar datos");
		borrarF.setToolTipText("pulse para los datos del formulario");
		
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

		// añadimos todos los elementos a los JPanel auxiliares
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
		marcoAux1.add(new JLabel(" INTRODUCCIÓN DE DATOS:"));
		marcoAux1.add(new JLabel(" "));

		marcoAux1.add(marcoAux01);
		marcoAux1.add(marcoAux02);
		marcoAux1.add(marcoInput1);
		marcoAux1.add(marcoInput2);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel("VISUALIZACIÓN ÚLTIMOS ARTÍCULOS"));
		marcoAux1.add(new JLabel(" "));	
		marcoAux1.add(marcoAux11);
		marcoAux1.add(marcoAux12);		
		marcoAux1.add(marcoAux21);
		marcoAux1.add(marcoAux22);
		marcoAux1.add(marcoAux31);
		marcoAux1.add(marcoAux32);
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		marcoAux1.add(new JLabel("     Base Imponible                                   Cuota iva"));
		marcoAux1.add(new JLabel("   Retención                                                Importe total IVA incluido"));
		marcoAux1.add(marcoAux61);
		marcoAux1.add(marcoAux62);
		
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(marcoAux71);
		marcoAux1.add(marcoAux72);
		marcoAux1.add(new JLabel(" "));
		marcoAux1.add(new JLabel(" "));
		
		
		// añadimos los jpanel auxiliares al jpanel principal
		marco2.setLayout(new BorderLayout());
		marco2.add(marcoAux0,BorderLayout.NORTH);
		marco2.add(marcoAux1,BorderLayout.CENTER);
		marco2.add(new JLabel("     "),BorderLayout.EAST);
		marco2.add(new JLabel("     "),BorderLayout.WEST);
		marco2.add(new JLabel("     "),BorderLayout.SOUTH);
		
		// le añadimos borde
		marco2.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		// hacemos visible el Jpanel principal con todos los elementos
		marco2.setVisible(true);
		
		// habilitamos los listener de los eventos
		selCustomerInv.addItemListener(this);
		borrarF.addActionListener(this);
		grabarF.addActionListener(this);
		anadirF.addActionListener(this);
		info.addActionListener(this);
		delF1.addActionListener(this);
		delF2.addActionListener(this);
		delF3.addActionListener(this);
		
		return marco2;
				
	} // end of method makeDelivery
	
	
	
	/**
	 * Este método realiza un chequeo de los datos del albaran. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de creación albaranes.
	 * 
	 * @return boolean TRUE or FALSE según el formulario esté correcto o haya errores.
	 */
	
	private boolean checkFinalForm () {
		
		boolean result=true;
		
		nameCustomerInv.setBackground(OKFORM);
		dateCustomerInv.setBackground(OKFORM);
		numberCustomerInv.setBackground(OKFORM);
		
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
		
		// Si no hay texto en tex1 es que el albaran está en blanco. No se admite un albaran sin texto
		// se admite un albaran sin importes, solo texto (por ejemplo para entrega sin cargo
		// de un material de reposición o muestra)
		if (tex1.getText().trim().isEmpty()) {
			result=false;
		}
		
		
		return result;
		
	} // end of method checkFinalForm
	
	
	
	/**
	 * Este método realiza un chequeo de los datos del albaran. Si detecta un
	 * error, devuelve un false, e ilumina la casilla del formulario de creación albaranes.
	 * 
	 * @return boolean TRUE or FALSE según el formulario esté correcto o haya errores.
	 */
	
	@SuppressWarnings("unused")
	private boolean checkFormCreateDelivery () {
		
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
		
	} // end of method checkFormCreateDelivery
	
	
	
	/**
	 * Este metodo mueve las entradas hacia abajo, y mete la nueva en la primera posicion
	 * 
	 */
	private void newIntro() {
		
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
			code="999999";
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
				delList(datosAlb,cod1.getText(),tex1.getText(),ud1.getText(),price1.getText(),iva1.getText(),imp1.getText());
				break;
				
			case 2:
				delList(datosAlb,cod2.getText(),tex2.getText(),ud2.getText(),price2.getText(),iva2.getText(),imp2.getText());
				break;
				
			case 3:
				delList(datosAlb,cod3.getText(),tex3.getText(),ud3.getText(),price3.getText(),iva3.getText(),imp3.getText());
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
				cod3.setText("");
				tex3.setText("");
				ud3.setText("");
				price3.setText("");
				iva3.setText("");
				imp3.setText("");
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
		
		for (String[] n:datosAlb) {
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
				"1.- Primeramente deberá seleccionar un cliente .\n" +
				"2.- Introduzca la fecha del albarán, en formato dd-mm-aaaa.\n" +
				"3.- El sistema facilita el siguiente número de albarán. Si lo desea, puede modificarlo\n" +
				"    introduciendo un número distinto. Si introduce letras se producirá un error. El\n" +
				"    número de albarán automático es una combinación del año y un número consecu-\n" +
				"    tivo. Por defecto, el sistema añadirá el año al número de albarán.\n" +
				"4.- Los datos se introducen en la zona de 'Introducción de datos'.\n" +
				"    En la versión 1.1 no está contemplado el control de stocks y artículos. Los artículos\n" +
				"    deben grabarse por entrada directa. Grabe en 'texto' el nombre del artículo o su\n" +
				"    descripción, las uds. a facturar (1 como mínimo), el importe unitario sin IVA,\n" +
				"    seleccione el tipo de IVA y pulse el botón 'intro datos' para aceptar la entrada.\n" +
				"    La aplicación realizará los cálculos, y le mostrará en primera línea el apunte\n" +
				"    realizado, y calculará la base imponible, el iva y el total de factura.\n " +
				"    En la versión 1.1 solo pueden grabarse 3 artículos por albarán\n" +
				"5.- Si lo desea puede borrar cada uno de los artículos pulsando en el botón 'X' al lado\n" +
				"    del apunte a borrar. La aplicación recalculará los datos automáticamente.\n" +
				"6.- Si desea borrar todos los datos introducidos, pulse en el botón Borrar datos.\n" +
				"7.- Cuando tenga confeccionado el albarán, pulse el botón 'Grabar albarán'. La aplica-\n" +
				"    ción le pedirá la confirmación. En caso afirmativo, el albarán habrá quedado\n" +
				"    grabado. A continuación, la aplicación le preguntará si desea imprimir el albarán \n" +
				"    en format oPDF. En caso afirmativo se generará un PDF que quedará grabado en donde\n" +
				"    tenga instalada la aplicación. El PDF no se mostrará automáticamente en pantalla.\n");
		hText.setForeground(COLORL);
		hText.setEditable(false);
		panelText.add(hText);
		
		JPanel title=new JPanel();
		title.add(new JLabel("AYUDA DE CREACIÓN ALBARANES"));
		
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
		
		if (selCustomerInv!=null && selCustomerInv.getSelectedIndex()!=0) {

			indexCustomer=selCustomerInv.getSelectedIndex()-1;
			nameCustomerInv.setText(listClientesFac.get(indexCustomer)[2]);
			selectedCustomer=listClientesFac.get(indexCustomer)[1];	
			
		}
		
	} // end of itemStateChanged
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String source=e.getActionCommand();
		
		if (source.equals("intro datos")) {
			
			if (checkFormCreateDelivery()) {
				
				String code="";
				if (numberOp.getSelectedIndex()==0) {
					// seleccionado input direct
					code="999999";
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
				int claseIva=ivas.getClassIva(1, ivaOp.getSelectedItem().toString());
				datos[6]=String.valueOf(claseIva);
				
				datosAlb.add(datos);
				
				newIntro();
				
				calculBases();
						
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en datos a grabar", "Error en Albarán", JOptionPane.ERROR_MESSAGE);
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

		} // END OF X
		
		
		if (source.equals("Borrar datos")) {	
			
			if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea borrar los datos que ha introducido en el formulario?", "Grabación de albaranes", JOptionPane.YES_NO_OPTION)==0) {
				// eliminando la lista
				datosAlb=new ArrayList<String[]>();
				
				// Eliminando la parte grafica
				selCustomerInv.setSelectedIndex(0);
				nameCustomerInv.setText("");
				
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
				baseImp.setText("");
				cuotaIva.setText("");
				importeTotal.setText("");				
			}
		} // END OF BORRAR
		
		
		if (source.equals("Grabar albarán")) {	
			
			if (checkFinalForm()) {
				
				if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea grabar el albarán que ha introducido en el formulario?", "Grabación de albaranes", JOptionPane.YES_NO_OPTION)==0) {
					
					// vuelve a calcular las bases
					calculBases();
					
					// creacion del objeto albaran
			
					datosF.setInvoice("");
					datosF.setCodeCustomer(selectedCustomer);
					String numbIv=numberCustomerInv.getText().trim();
					datosF.setNumber(numbIv);
					String dateToRecord=dateCustomerInv.getText().trim().substring(6)+dateCustomerInv.getText().trim().substring(2,6)+dateCustomerInv.getText().trim().substring(0,2);
					datosF.setDateOper(Date.valueOf(dateToRecord));
					datosF.setCodeCompany(SpringFacturacion.idCompany);
					
					datosF.setCodeOper1("");
					datosF.setCodeOper2("");
					datosF.setCodeOper3("");
					datosF.setTextOper1("");
					datosF.setTextOper2("");
					datosF.setTextOper3("");
					
					switch (datosAlb.size()) {
					case 3:
						datosF.setCodeOper3(datosAlb.get(2)[0]);
						datosF.setTextOper3(datosAlb.get(2)[1]);
						datosF.setQttOper3(convertToNumber(datosAlb.get(2)[2]));
						datosF.setPriceOper3(convertToNumber(datosAlb.get(2)[3]));
						datosF.setIvaOper3(convertToNumber(datosAlb.get(2)[4]));
					case 2:
						datosF.setCodeOper2(datosAlb.get(1)[0]);
						datosF.setTextOper2(datosAlb.get(1)[1]);
						datosF.setQttOper2(convertToNumber(datosAlb.get(1)[2]));
						datosF.setPriceOper2(convertToNumber(datosAlb.get(1)[3]));
						datosF.setIvaOper2(convertToNumber(datosAlb.get(1)[4]));
					case 1:
						datosF.setCodeOper1(datosAlb.get(0)[0]);
						datosF.setTextOper1(datosAlb.get(0)[1]);
						datosF.setQttOper1(convertToNumber(datosAlb.get(0)[2]));
						datosF.setPriceOper1(convertToNumber(datosAlb.get(0)[3]));
						datosF.setIvaOper1(convertToNumber(datosAlb.get(0)[4]));
						break;
						default:
							break;		
					}
					
					// los valores han sido calculados en calculaBase
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
					datosF.setRetencion(retencI);
					datosF.setTipoRet(SpringFacturacion.retInvoices);
					datosF.setTotalAlbaran(baseI+cuotaI-retencI);
					
					
					// grabando el albaran
					
					if (albaranes.createDelivery(datosF)) {
						JOptionPane.showMessageDialog(mainFrame, "Albarán grabado correctamente","Grabación de albaranes",JOptionPane.INFORMATION_MESSAGE);
					
						nextNumber=formatoFactura.format(albaranes.getNextNumber());
						numberCustomerInv.setText(nextNumber);
						
						// eliminando la lista
						datosAlb=new ArrayList<String[]>();
						
						// Eliminando la parte grafica
						selCustomerInv.setSelectedIndex(0);
						nameCustomerInv.setText("");
						
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
						
						baseImp.setText("");
						cuotaIva.setText("");
						importeTotal.setText("");
				
						if (JOptionPane.showConfirmDialog(mainFrame, "¿Desea generar un pdf del albarán?", "Impresión de albarán", JOptionPane.YES_NO_OPTION)==0) {
							String[] cliente=clienteFac.getCustomer(datosF.getCodeCustomer());
							if (dataList.getDelivery("albaran"+datosF.getNumber(), datosF, cliente[2], cliente[3], cliente[4], cliente[5], cliente[6])) {
								JOptionPane.showMessageDialog(mainFrame, "Generado el pdf del albarán","Impresión de albarán",JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(mainFrame, "Error: no ha sido posible generar el pdf","Impresión de albarán",JOptionPane.ERROR_MESSAGE);
							}
						}
				
						
						// se actualizan pestañas
						reinicia.reinicia(3,1);
						
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Error en grabación de albarán","Grabación de albaranes",JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "Error en datos a grabar", "Error en Albarán", JOptionPane.ERROR_MESSAGE);
			}
			

					
		}	 //END OF GRABAR ALBARAN		
		
		
		if (source.equals("info")) {
			createHelp();
		}
		
		
	} // end of item

	
	
	
} // ************* END OF CLASS
