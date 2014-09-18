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

public class MarcoFacturas implements ItemListener, ActionListener {
	

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
	private JMenuItem mIt3;
	
	// OBJETOS SPRING
	private PanelInvoicesCreating panelCreating;
	private PanelInvoicesModifying panelModifying;
	private PanelInvoicesDeleting panelDeleting;
	private PanelInvoicesPrinting panelPrinting;
	private PanelInvoicePDF panelPrintInvoice;
	private PanelInvoicesIva panelPrintIva;
			

	
	
	public MarcoFacturas() {
		// CONSTRUCTOR

	}
	
	
	public void setPanelCreating(PanelInvoicesCreating panelCreating) {
		// spring
		this.panelCreating = panelCreating;
	}

	public void setPanelModifying(PanelInvoicesModifying panelModifying) {
		// spring
		this.panelModifying = panelModifying;
	}

	public void setPanelDeleting(PanelInvoicesDeleting panelDeleting) {
		// spring
		this.panelDeleting = panelDeleting;
	}

	public void setPanelPrinting(PanelInvoicesPrinting panelPrinting) {
		// spring
		this.panelPrinting = panelPrinting;
	}

	public void setPanelPrintInvoice (PanelInvoicePDF panelPrintInvoice) {
		// spring
		this.panelPrintInvoice=panelPrintInvoice;
	}
	
	public void setPanelPrintIva (PanelInvoicesIva panelPrintIva) {
		// spring
		this.panelPrintIva=panelPrintIva;
	}
	

	
	public JPanel marcoPrincipal(JFrame mainFrame, int tabbed ) {
		
		this.mainFrame=mainFrame;
		
		marco=new JPanel();
		marco.setLayout(new BoxLayout(marco,BoxLayout.Y_AXIS));
		marco.setBackground(SpringFacturacion.fondoColor);
		
		// creamos la barra de menu de opciones
		mnu1=new JMenu("Creación");
		mnu2=new JMenu("Modificación");
		mnu3=new JMenu("Borrado");
		mnu4=new JMenu("Listados");
		
		mIt1=new JMenuItem("Impresión de facturas");
		mIt2=new JMenuItem("Relación de facturas");
		mIt3=new JMenuItem("Relación de I.V.A repercutido");
		
		mnu4.add(mIt1);
		mnu4.add(mIt2);
		mnu4.add(mIt3);
		
		menu=new JMenuBar();
		
		Dimension dim=new Dimension(400,25);
		menu.setPreferredSize(dim);
		menu.setMaximumSize(dim);
		menu.setMinimumSize(dim);
		
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
			marco1=panelCreating.makeInvoice(mainFrame);
			break;
		case 2:
			marco1=panelModifying.modifyInvoice(mainFrame);
			break;
		case 3:
			marco1=panelDeleting.eraseInvoice(mainFrame);
			break;
		case 4:
			marco1=panelPrinting.printInvoices(mainFrame);
			break;
		default:
			marco1=panelCreating.makeInvoice(mainFrame);
			break;
		}
		
		
		
		mnu1.addItemListener(this);
		mnu2.addItemListener(this);
		mnu3.addItemListener(this);
		mnu4.addItemListener(this);
		mIt1.addActionListener(this);
		mIt2.addActionListener(this);
		mIt3.addActionListener(this);
		
		marco.add(new JLabel());
		marco.add(menu);
		marco.add(marco1);
		
		return marco;
		
	} // end of method marcoPrincipal
	
	
	

	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
			
		// MENUS SUPERIORES
		
		if (mnu1.isSelected()) {
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelCreating.makeInvoice(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (mnu2.isSelected()) {
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelModifying.modifyInvoice(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (mnu3.isSelected()) {		
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelDeleting.eraseInvoice(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		/*
		if (mIt2.isSelected()) {			
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPrinting.printInvoices(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		*/

				
	} // end of itemStateChanged


	@Override
	public void actionPerformed(ActionEvent e) {
	
		String source=e.getActionCommand();
		
		if (source.equals("Impresión de facturas")) {			
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPrintInvoice.printInvoice(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (source.equals("Relación de facturas")) {			
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPrinting.printInvoices(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		if (source.equals("Relación de I.V.A repercutido")) {			
			marco.setVisible(false);
			marco.remove(menu);
			marco.remove(marco1);
			marco1=panelPrintIva.printListInvoicesIva(mainFrame);
			marco1.setVisible(true);
			marco.add(menu);
			marco.add(marco1);
			marco.revalidate();
		}
		
		
		
	} // end of ActionPerformed
	
	
	


} // ************** END OF CLASS
