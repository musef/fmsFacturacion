package beansViews;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import main.SpringFacturacion;



/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring 2014-08-31
 */

public class MarcoAdministracion extends JPanel implements ItemListener {
	

	private static final long serialVersionUID = 1L;
	
	private JFrame mainFrame;
	private JPanel panelPrincipal;
	private JPanel marco;
	private JMenuBar menu;
	private JMenu mnu1;
	private JMenu mnu2;
	private JMenu mnu3;
	private JMenu mnu4;
	
	
	// TABBED PANELS
	private PanelAdminEmpresas panelCompany;
	private PanelAdminIvas panelIva;
	private PanelAdminPagos panelPago;
	private PanelAdminIrpf panelAdminIrpf;
	
	
	
	/**
	 * Metodo constructor.
	 * 
	 * @param pantallaPrincipal - Es el JFrame sobre el que se ubica el Panel de 
	 *     	trabajo con cuentas

	 */
	
	public MarcoAdministracion() {
		// CONSTRUCTOR
		
		// recibe la referencia del JFrame para ubicar las distintas
		// pantallas de mensaje
		mainFrame=null;
		
	}
	
	public void setPanelCompany (PanelAdminEmpresas panelCompany) {
		//spring
		this.panelCompany=panelCompany;
	}
	
	public void setPanelIva (PanelAdminIvas panelIva) {
		//spring
		this.panelIva=panelIva;
	}
	
	public void setPanelPago (PanelAdminPagos panelPago) {
		//spring
		this.panelPago=panelPago;
	}
	
	public void setPanelIrpf (PanelAdminIrpf panelAdminIrpf) {
		//spring
		this.panelAdminIrpf=panelAdminIrpf;
	}
	
	
	
	/**
	 * 	Barra de menús de la aplicacion desde la que se podrán crear,
	 *  modificar y dar de baja usuarios
	 * 
	 * @return devuelve un JPanel con la barra de menús de usuario y el formulario de alta creado.
	 */
	
	public JPanel marcoPrincipal(JFrame mainFrame, int tabbed) {
	
		this.mainFrame=mainFrame;
		
		panelPrincipal=new JPanel();
		marco=new JPanel();
		panelPrincipal.setBackground(SpringFacturacion.fondoColor);

		// creamos la barra de menu de opciones
		mnu1=new JMenu("Empresa");
		mnu2=new JMenu("IVA");
		mnu3=new JMenu("Formas Pago");
		mnu4=new JMenu("IRPF");
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
			marco=panelCompany.panelPrincipal(mainFrame);
			break;
		case 2:
			marco=panelIva.panelPrincipal(mainFrame);
			break;
		case 3:
			marco=panelPago.panelPrincipal(mainFrame);
			break;
		case 4:
			marco=panelAdminIrpf.panelPrincipal(mainFrame);
			break;
		default:
			marco=panelCompany.panelPrincipal(mainFrame);
			break;
		}
		// creamos el marco con los componentes
		
		
		// añadimos los componentes al panel principal
		panelPrincipal.add(new JLabel());
		panelPrincipal.add(menu);
		panelPrincipal.add(marco);
				
		mnu1.addItemListener(this);
		mnu2.addItemListener(this);
		mnu3.addItemListener(this);
		mnu4.addItemListener(this);
		
		panelPrincipal.setVisible(true);
			
		return panelPrincipal;
		
	}	// fin del metodo marcoPrincipal

		




	@Override
	public void itemStateChanged(ItemEvent it) {
				
		//Object source=it.getItem();
	
		if (mnu1.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelCompany.panelPrincipal(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
			
		}
		
		if (mnu2.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelIva.panelPrincipal(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		}
		
		if (mnu3.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelPago.panelPrincipal(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();
		}
		
		if (mnu4.isSelected()) {
			marco.setVisible(false);
			panelPrincipal.remove(menu);
			panelPrincipal.remove(marco);
			marco=panelAdminIrpf.panelPrincipal(mainFrame);
			marco.setVisible(true);
			panelPrincipal.add(menu);
			panelPrincipal.add(marco);
			panelPrincipal.revalidate();

		}
		
		
	} // Fin del metodo ItemStatedChanged


} // ********************** FIN DE LA CLASS
