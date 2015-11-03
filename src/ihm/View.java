package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.ControllerEventListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener{

	private static final int sizeH = 300;
	private static final int sizeW = 400;

	private Model model;
	private Controller controller;
	
	private JPanel jpSource;
	private JLabel jlTitreSource;
	private JTextField jtfSource;
	private JPanel jpDest;
	private JLabel jlTitreDest;
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
		this.add(setDestinationJP());
		this.add(setActionJP());
		
		this.pack();
		this.setVisible(true);
		
	}


	private JPanel setSourceJP() {
		
		jpSource = new JPanel();
		jtfSource = new JTextField("Repertoire du projet source");
		
		jpSource.setLayout(new BorderLayout());
		jpSource.add(jtfSource, BorderLayout.SOUTH);
		
		jpSource.setPreferredSize(new Dimension(sizeW, 50));
		
		return jpSource;
	}
	

	private JPanel setDestinationJP() {
		jpDest = new JPanel();
		jtfDest = new JTextField("Repertoire du projet de destination");
		
		jpDest.setLayout(new BorderLayout());
		jpDest.add(jtfDest, BorderLayout.SOUTH);
		
		jpDest.setPreferredSize(new Dimension(sizeW, 50));
		
		return jpDest;
	}

	private JPanel setActionJP() {

		jpAction = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));
		
		jbProceed = new JButton("Proceed to ofuscation");
		jbCancel = new JButton("Cancel");
		
		jbProceed.addActionListener(this);
		
		jpAction.add(jbProceed);
		jpAction.add(jbCancel);
		
		
		return jpAction;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == this.jbProceed) {
			
			model.setSourceDir(jtfSource.getText());
			model.setDestDir(jtfDest.getText());
			
			Controller.actionProceed();
		} else if (ae.getSource() == this.jbCancel) {
			Controller.actionCancel();
		}
		
	}
	
}
