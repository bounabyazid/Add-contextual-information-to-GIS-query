package SIG;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class COMPARESON extends Frame {

	private static final long serialVersionUID = 1L;
	public Vector columnNames = new Vector();
	public Vector<Vector> data = new Vector();
	
	private JButton jButton1 = null;
	public JScrollPane jScrollPane1 = null;
	public JTable jTable1 = null;
	public COMPARESON() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public COMPARESON(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public COMPARESON(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public COMPARESON(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize() {
		this.setLayout(null);
		this.setSize(401, 239);
		this.setTitle("Tableau de Comparaison :");

		this.add(getJButton1(), null);
		this.add(getJScrollPane1(), null);
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(282, 194, 106, 32));
			jButton1.setText("Fermmer");
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					COMPARESON.this.dispose();
				}
			});
		}
		return jButton1;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(9, 33, 386, 148));
		}
		return jScrollPane1;
	}
}
