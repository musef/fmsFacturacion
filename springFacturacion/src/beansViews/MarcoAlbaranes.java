package beansViews;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
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

public class MarcoAlbaranes extends JPanel implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	
	// PANEL PRINCIPAL
	private JFrame mainFrame;
	private JPanel marco;
	private JPanel marco1;
	private JMenuBar menu;
	private JMenu mnu1;
	private JMenu mnu2;
	private JMenu mnu3;
	private JMenu mnu4;
	private JMenuItem mIt1;
	private JMenuItem mIt2;

	// OBJETOS SPRING
	private PanelDeliveryCreating panelCreating;
	private PanelDeliveryModifying panelModifying;
	private PanelDeliveryDeleting panelDeleting;
	private PanelDeliveryPrinting panelPrinting;
	private PanelDeliveryPDF panelPdf;
	

	
	
	public MarcoAlbaranes () {
		// CONSTRUCTOR

	}
	
	
	public void setPanelCreating (PanelDeliveryCreating panelCreating) {
		// spring
		this.panelCreating=panelCreating;
	}
	
	public void setPanelModifying (PanelDeliveryModifying panelModifying) {
		// spring
		this.panelModifying=panelModifying;
	}
	
	public void setPanelDeleting (PanelDeliveryDeleting panelDeleting) {
		// spring
		this.panelDeleting=panelDeleting;
	}
	
	public void setPanelPrinting (PanelDeliveryPrinting panelPrinting) {
		// spring
		this.panelPrinting=panelPrinting;
	}
	
	public void setPanelPdf (PanelDeliveryPDF panelPdf) {
		// spring
		this.panelPdf=panelPdf;
	}
	
	
	/**
	 * 	Pestaña de la aplicacion desde la cual se pueden consultar todas las operaciones
	 * realizadas, seleccionadas por distintos tipos de filtros.
	 * 
	 * @param panelTabPrincipal - Es el objeto que controla la insercion y cambio de las 
	 * 		pestañas. Usado para cambiar de pestaña cuando quiere modificar una operacion.
	 * @param datosOperaciones - Es el objeto MarcoOperaciones que se pasa para poder
	 *  	manipular algunos atributos interrelacionados con cuentas.
	 *  
	 *  @return devuelve un JPanel con la ventana de consulta de operaciones.
	 */

	public JPanel marcoPrincipal(JFrame mainFrame, int tabbed) {
		
		this.mainFrame=mainFrame;
		
		marco=new JPanel();
		marco.setLayout(new BoxLayout(marco,BoxLayout.Y_AXIS));
		marco.setBackground(SpringFacturacion.fondoColor);
		
		// creamos la barra de menu de opciones
		mnu1=new JMenu("Creación");
		mnu2=new JMenu("Modificación");
		mnu3=new JMenu("Borrado");
		mnu4=new JMenu("Listados");
		menu=new JMenuBar();
		mIt1=new JMenuItem("Impresión de albaranes");
		mIt2=new JMenuItem("Relación de albaranes");
		
		Dimension dim=new Dimension(400,25);
		menu.setPreferredSize(dim);
		menu.setMaximumSize(dim);
		menu.setMinimumSize(dim);
		
		mnu4.add(mIt1);
		mnu4.add(mIt2);
		
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
			marco1=panelCreating.makeDelivery(mainFrame);
			break;
		case 2:
			marco1=panelModifying.modifyDelivery(mainFrame);
			break;
		case 3:
			marco1=panelDeleting.eraseDelivery(mainFrame);
			break;
		case 4:
			marco1=panelPrinting.showMenu(mainFrame);
			break;
		default:
			marco1=panelCreating.makeDelivery(mainFrame);
			break;
		}
		
		
		mnu1.addItemListener(this);
		mnu2.addItemListener(this);
		mnu3.addItemListener(this);
		mnu4.addItemListener(this);
		mIt1.addActionListener(this);
		mIt2.addActionListener(this);
		
		marco.add(new JLabel());
		marco.add(menu);
		marco.add(marco1);
		
		return marco;
		
	} // end of method marcoPrincipal
	
	



	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=e.getActionCommand();
		
		if (source.equals("Relación de albaranes")) {

			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPrinting.showMenu(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
			
		} 
		
		
		if (source.equals("Impresión de albaranes")) {

			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPdf.showMenu(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
			
		} 

		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
			
		
		// MENUS SUPERIORES
		
		if (mnu1.isSelected()) {
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelCreating.makeDelivery(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (mnu2.isSelected()) {
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelModifying.modifyDelivery(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (mnu3.isSelected()) {		
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelDeleting.eraseDelivery(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (mIt2.isSelected()) {			

		}
		
		
				
	} // end of itemStateChanged

	
} // *************** FIN DE LA CLASS
