package SIG;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LOG extends Frame {

	private static final long serialVersionUID = 1L;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JPasswordField jPasswordField = null;
	private JTextField USER = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton Button3 = null;
	public LOG() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public LOG(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public LOG(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public LOG(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(25, 147, 71, 32));
			jButton1.setText("Quiter");
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.exit(0);
				}
			});
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(102, 147, 106, 32));
			jButton2.setText("Inscription");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				 LOG.this.dispose();
				 new Inscription();
				}
			});
		}
		return jButton2;
	}

	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setBounds(new Rectangle(132, 94, 160, 30));
			jPasswordField.setText("147");
		}
		return jPasswordField;
	}

	private JTextField getJTextField() {
		if (USER == null) {
			USER = new JTextField();
			USER.setBounds(new Rectangle(133, 50, 160, 30));
			USER.setText("yazid");
		}
		return USER;
	}

	private JButton getButton3() {
		if (Button3 == null) {
			Button3 = new JButton();
			Button3.setBounds(new Rectangle(215, 149, 75, 32));
			Button3.setText("Ok");
			Button3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					 try {
						   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				     	   String DBurl= "jdbc:odbc:base" ;
				    	   Connection C = DriverManager.getConnection(DBurl);
  
						   Statement state = C.createStatement(); 
						   ResultSet result = state.executeQuery("SELECT * FROM \"USER\" WHERE username = \'"+USER.getText()+"\' AND password = \'"+jPasswordField.getText()+"\';");
						   ResultSetMetaData resultMeta = result.getMetaData();
						   if(result.next())
						   {
							 FORM F = new FORM();
						     F.num = (Integer) result.getObject(1);
						     LOG.this.dispose();
						   }
						   //C.AFFICHER("\"USER\"");
					  } 
					   catch (SQLException e1) {e1.printStackTrace();} 
					   catch (ClassNotFoundException e2) {e2.printStackTrace();}
					 }
			});
		}
		return Button3;
	}

	public static void main(String[] args) {
		//LOG L = 
			new LOG();
	}

	private void initialize() {
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(25, 93, 101, 29));
		jLabel2.setText("Mot de Pass :");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(23, 49, 104, 26));
		jLabel1.setText("Nom Utilisateur");
		this.setLayout(null);
		this.setSize(315, 196);
		this.setResizable(false);
		this.setTitle("Connexion :");

		this.setVisible(true);
		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
		this.add(getJPasswordField(), null);
		this.add(getJTextField(), null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getButton3(), null);
	}

}  //  @jve:decl-index=0:visual-constraint="329,21"
