package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author jvdur
 *
 */
public class View extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int sizeH = 300;
	private static final int sizeW = 400;

	private Model model;
	private Controller controller;
	
	private JPanel jpSource;
	private JTextField jtfSource;
	
	private JPanel jpModel;
	private JTextField jtfModel;
	
	private JPanel jpDest;
	private JTextField jtfDest;
	
	private JPanel jpAction;
	private JButton jbProceed;
	private JButton jbCancel;

	
	public View(Model model, Controller controller) {
	
		this.model = model;
		this.controller = controller;
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(sizeW, sizeH));
		this.setResizable(false);
		this.setForeground(Color.WHITE);
		
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10,0);
		this.setLayout(fl);
		
		this.add(setSourceJP());
		this.add(setModelJP());
		this.add(setDestinationJP());
		this.add(setActionJP());
		
		this.pack();
		this.setVisible(true);
		
	}


	/**
	 * G�n�re le JPANEL de r�f�rencement du r�pertoire du projet source, celui a �diter
	 * @return jpanel source
	 */
	private JPanel setSourceJP() {
		jpSource = new JPanel();
		jtfSource = new JTextField("Repertoire du projet source");
		
		jpSource.setLayout(new BorderLayout());
		jpSource.add(jtfSource, BorderLayout.SOUTH);
		
		jpSource.setPreferredSize(new Dimension(sizeW, 50));
		
		return jpSource;
	}

	/**
	 * G�n�re le JPANEL de r�f�rencement du r�pertoire du projet source, celui a �diter
	 * @return jpanel source
	 */
	private JPanel setModelJP() {
		jpModel = new JPanel();
		jtfModel = new JTextField("Repertoire du projet mod�le");
		
		jpModel.setLayout(new BorderLayout());
		jpModel.add(jtfModel, BorderLayout.SOUTH);
		
		jpModel.setPreferredSize(new Dimension(sizeW, 50));
		
		return jpModel;
	}
	
	
	
		
	/**
	 * G�n�re le JPANEL de r�f�rencement du r�pertoire de destination du projet.
	 * @return
	 */
	private JPanel setDestinationJP() {
		jpDest = new JPanel();
		jtfDest = new JTextField("Repertoire du projet de destination");
		
		jpDest.setLayout(new BorderLayout());
		jpDest.add(jtfDest, BorderLayout.SOUTH);
		
		jpDest.setPreferredSize(new Dimension(sizeW, 50));
		
		return jpDest;
	}

	
	/**
	 * Enregistrement des listeners 
	 * @return
	 */
	private JPanel setActionJP() {

		jpAction = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));
		
		jbProceed = new JButton("Proceed to ofuscation");
		jbCancel = new JButton("Cancel");
		
		jbProceed.addActionListener(this);
		
		jpAction.add(jbProceed);
		jpAction.add(jbCancel);
		
		return jpAction;
	}

	/**
	 * Gestion des actions des listeners
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == this.jbProceed) {
			model.setSourceDir(jtfSource.getText());
			model.setDestDir(jtfDest.getText());
			model.setModelDir(jtfModel.getText());
			controller.actionProceed();

		} else if (ae.getSource() == this.jbCancel) {
			controller.actionCancel();
		}
	}
	
}
