package beansViews;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.SpringFacturacion;




/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class MarcoClientes extends JPanel implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	
	private JFrame mainFrame;
	private JPanel panelPrincipal;
	private JPanel marco;
	private JMenuBar menu;
	private JMenu mnu1;
	private JMenu mnu2;
	private JMenu mnu3;
	private JMenu mnu4;
	private JMenuItem mIt1;
	private JMenuItem mIt2;
	//private int select;
		
	
	// OBJETOS SPRING
	private PanelCustomersCreating panelCreating;
	private PanelCustomersModifying panelModifying;
	private PanelCustomersDeleting panelDeleting;
	private PanelCustomersPrinting panelPrinting;
	//private EnterSandMan reinicia;
	

	
	
	
	
	
	/**
	 * Metodo constructor.
	 * 
	 * @param pantallaPrincipal - Es el JFrame sobre el que se ubica el Panel de 
	 *     	trabajo con cuentas

	 */
	
	public MarcoClientes() {
		// CONSTRUCTOR
		//select=0;
	}
	
	
	public void setPanelCreating(PanelCustomersCreating panelCreating) {
		// spring
		this.panelCreating = panelCreating;
	}

	public void setPanelModifying(PanelCustomersModifying panelModifying) {
		// spring
		this.panelModifying = panelModifying;
	}

	public void setPanelDeleting(PanelCustomersDeleting panelDeleting) {
		// spring
		this.panelDeleting = panelDeleting;
	}

	public void setPanelPrinting(PanelCustomersPrinting panelPrinting) {
		// spring
		this.panelPrinting = panelPrinting;
	}
	/*
	public void setReinicia (EnterSandMan reinicia) {
		// spring
		this.reinicia=reinicia;
	}
	*/
	
	
	/**
	 * 	Barra de menús de la aplicacion desde la que se podrán crear,
	 *  modificar y dar de baja usuarios
	 * 
	 * @return devuelve un JPanel con la barra de menús de usuario y el formulario de alta creado.
	 */
	
	public JPanel marcoPrincipal(JFrame mainFrame, int tabbed) {
	
		this.mainFrame=mainFrame;
		
		panelPrincipal=new JPanel();
		panelPrincipal.setBackground(SpringFacturacion.fondoColor);
		marco=new JPanel();
		

		// creamos la barra de menu de opciones
		mnu1=new JMenu("Alta");
		mnu2=new JMenu("Modificación");
		mnu3=new JMenu("Baja");
		mnu4=new JMenu("Listados");
		mIt1=new JMenuItem("Listado de clientes");
		mIt2=new JMenuItem("Facturación de clientes");
		
		mnu4.add(mIt1);
		mnu4.add(mIt2);
		
		menu=new JMenuBar();		
		menu.add(mnu1);
		menu.add(new JLabel("          "));
		menu.add(mnu2);
		menu.add(new JLabel("          "));
		menu.add(mnu3);
		menu.add(new JLabel("          "));
		menu.add(mnu4);
		
		menu.setVisible(true);
		
		// seleccion en funcion de la pestaña activa
		switch (tabbed) {
		case 1:
			marco=panelCreating.newCustomer(mainFrame);
			break;
		case 2:
			marco=panelModifying.modCustomer(mainFrame);
			break;
		case 3:
			marco=panelDeleting.delCustomer(mainFrame);
			break;
		case 4:
			marco=panelPrinting.showMenuList(mainFrame);
			break;
		default:
			marco=panelCreating.newCustomer(mainFrame);
			break;
		}
		
		
		// añadimos los componentes al panel principal
		panelPrincipal.add(menu);
		panelPrincipal.add(marco);
				
		mnu1.addItemListener(this);
		mnu2.addItemListener(this);
		mnu3.addItemListener(this);
		mnu4.addItemListener(this);
		mIt1.addActionListener(this);
		mIt2.addActionListener(this);
		
		panelPrincipal.setVisible(true);
			
		return panelPrincipal;
		
	}	// fin del metodo marcoPrincipal
	
	

	/**
	 * Este método realiza una actualización de los paneles de alta, modificación o baja,
	 * una vez realizada alguna de esas operaciones.
	 * 
	 * @param select - un int que nos indica en que sección se ha producido el cambio (0=alta, 1=modificacion,
	 * 2=baja).
	 */
	/*
	private void actualiza(int select) {
		
		marco.setVisible(false);
		panelPrincipal.remove(menu);
		panelPrincipal.remove(marco);
		if (select==0) {
			marco=panelCreating.newCustomer(mainFrame);
		} else if (select==1) {
			marco=panelModifying.modCustomer(mainFrame);
		} else if (select==2){
			marco=panelDeleting.delCustomer(mainFrame);
		}  else {
			marco=panelPrinting.printCustomers(mainFrame);
		}
		
		marco.setVisible(true);
		panelPrincipal.add(menu);
		panelPrincipal.add(marco);
		panelPrincipal.revalidate();
		
		// se actualizan pestañas
		reinicia.reinicia(2,select+1);
		
	} // end of actualiza
	*/
	
	


	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getActionCommand();	
		

		if (source.equals("Alta")) { 
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelCreating.newCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		
		} // fin de alta
		
		if (source.equals("Modificación")) { 
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelModifying.modCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		
		} // fin de modificacion
		
		
		if (source.equals("Baja")) { 
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelDeleting.delCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		
		} // fin de baja


		if (source.equals("Listado de clientes")) {			
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelPrinting.showMenuList(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		}
		
		if (source.equals("Facturación de clientes")) {			
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelPrinting.showMenuInvoices(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		}
		
	
		
	} // fin de metodo ActionPerformed

	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
			// MENUITEMS seleccion general
		if (mnu1.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelCreating.newCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
			//select=0;
			
		}
		
		if (mnu2.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelModifying.modCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
			//select=1;
		}
		
		if (mnu3.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelDeleting.delCustomer(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
			//select=2;
		}

	}


	
} // ****************** FIN DE LA CLASS
