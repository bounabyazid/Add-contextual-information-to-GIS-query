package SIG;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Checkbox;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Inscription extends Frame {

	private static final long serialVersionUID = 1L;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Label label6 = null;
	private Label label7 = null;
	private JPasswordField PasswordField1 = null;
	private JComboBox ComboBox1 = null;
	private JComboBox ComboBox2 = null;
	private JComboBox ComboBox3 = null;
	private Label label8 = null;
	private Label label9 = null;
	private Label label10 = null;
	private JButton Button1 = null;
	private JButton Button2 = null;
	private JButton Button3 = null;
	private JTextField TextField1 = null;
	private JTextField TextField2 = null;
	private JTextField TextField3 = null;
	private JTextField TextField4 = null;
	private JTextField TextField5 = null;
	private JTextField TextField6 = null;
	private JPasswordField PasswordField2 = null;
	private JComboBox ComboBox4 = null;
	public Inscription() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public Inscription(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Inscription(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Inscription(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private JPasswordField getPasswordField1() {
		if (PasswordField1 == null) {
			PasswordField1 = new JPasswordField();
			PasswordField1.setBounds(new Rectangle(161, 354, 192, 25));
		}
		return PasswordField1;
	}

	private JComboBox getComboBox1() {
		if (ComboBox1 == null) {
			Vector <String> items = new Vector <String> ();
			items.add("Homme");
			items.add("Femme");
			ComboBox1 = new JComboBox(items);
			ComboBox1.setBounds(new Rectangle(107, 117, 246, 25));
		}
		return ComboBox1;
	}

	private JComboBox getComboBox2() {
		if (ComboBox2 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=31;i++)
			 items.add(Integer.toString(i));
			ComboBox2 = new JComboBox(items);
			ComboBox2.setBounds(new Rectangle(181, 156, 53, 25));
		}
		return ComboBox2;
	}

	private JComboBox getComboBox3() {
		if (ComboBox3 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=12;i++)
			 items.add(Integer.toString(i));
			ComboBox3 = new JComboBox(items);
			ComboBox3.setBounds(new Rectangle(238, 157, 49, 25));
		}
		return ComboBox3;
	}

	private JButton getButton1() {
		if (Button1 == null) {
			Button1 = new JButton();
			Button1.setBounds(new Rectangle(29, 425, 151, 29));
			Button1.setText("Vider les Champs");
			Button1.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					Vider();
				}
			});
		}
		return Button1;
	}
    
	private void Vider()
    {
    	TextField1.setText("");
        TextField2.setText("");
        TextField3.setText("");
        TextField4.setText("");
        TextField5.setText(""); 
        TextField6.setText("");
        PasswordField1.setText("");
        PasswordField2.setText("");
    }
	private boolean userexiste()
	{
	 boolean existe = false;
	 try {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   	       String DBurl= "jdbc:odbc:base" ;
  	       Connection C = DriverManager.getConnection(DBurl);
           Statement state = C.createStatement(); 
		   ResultSet result = state.executeQuery("SELECT * FROM \"USER\" WHERE username = \'"+TextField6.getText()+"\';");
		 //  ResultSetMetaData resultMeta = result.getMetaData();
   	       if(result.next())
   	       	return true;
   	       state.close();
		   C.close();
	 }catch (SQLException e){e.printStackTrace();}
	  catch (ClassNotFoundException e){e.printStackTrace();}
 	 return existe;
	}
    private boolean Teste()
    {
     boolean Test = true;
     if(/*TextField1.getText().isEmpty()||
     TextField2.getText().isEmpty()||
     TextField3.getText().isEmpty()||
     TextField4.getText().isEmpty()||
     TextField5.getText().isEmpty()|| */
     TextField6.getText().isEmpty()||
     PasswordField1.getText().isEmpty()||
     PasswordField2.getText().isEmpty())
     {
      JOptionPane.showMessageDialog(null,"L'un des champs est vide!");
      return false;
     }
     if(userexiste())
     {
	  JOptionPane.showMessageDialog(null,"Username existe déja!");
  	  TextField6.setText("");
	  return false;
     }
     if(!PasswordField1.getText().equals(PasswordField2.getText()))
     {
      JOptionPane.showMessageDialog(null,"Mot de passe et sa confirmation sont pas identiques!");
      PasswordField1.setText("");
      PasswordField2.setText("");      
      return false;	 
     }
     return Test;
    }
	private JButton getButton2(){
		if (Button2 == null) {
			Button2 = new JButton();
			Button2.setBounds(new Rectangle(193, 426, 77, 26));
			Button2.setText("Quiter");
			Button2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.exit(0); 
				}
			});
		}
		return Button2;
	}

	private JButton getButton3() {
		if (Button3 == null) {
			Button3 = new JButton();
			Button3.setBounds(new Rectangle(285, 426, 69, 27));
			Button3.setText("Ok");
			Button3.addMouseListener(new java.awt.event.MouseAdapter() {
				@SuppressWarnings("deprecation")
				public void mouseClicked(java.awt.event.MouseEvent e) {
					 try {
						  if(Teste())
						  {
						   String date = ComboBox2.getSelectedItem()+"-"+ComboBox3.getSelectedItem()+"-"+ComboBox4.getSelectedItem();
						   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				     	   String DBurl= "jdbc:odbc:base" ;
				    	   Connection C = DriverManager.getConnection(DBurl);
                           Statement state = C.createStatement(); 
						   state.executeUpdate("INSERT INTO \"USER\"(username,password,nom,prenom,sex,dnaissance,lnaissance,diplome,fonction)VALUES(\'"+
								                                  TextField6.getText()+"\',\'"+PasswordField1.getText()+"\',\'"+TextField1.getText()+"\',\'"+TextField2.getText()+"\',\'"+ComboBox1.getSelectedItem()+"\',\'"+date+"\',\'"+TextField3.getText()+"\',\'"+TextField4.getText()+"\',\'"+TextField5.getText()+"\');");
						   state.close();
						   C.close();
						   Vider();
						   Inscription.this.dispose();
						   new Profil();
						  }					   
						  // C.AFFICHER("\"USER\"");
					  } 
				      catch (Exception e1) {e1.printStackTrace();}
				    }
			});
		}
		return Button3;
	}

	private JTextField getTextField1() {
		if (TextField1 == null) {
			TextField1 = new JTextField();
			TextField1.setBounds(new Rectangle(89, 46, 265, 25));
		}
		return TextField1;
	}

	private JTextField getTextField2() {
		if (TextField2 == null) {
			TextField2 = new JTextField();
			TextField2.setBounds(new Rectangle(107, 83, 247, 25));
		}
		return TextField2;
	}

	private JTextField getTextField3() {
		if (TextField3 == null) {
			TextField3 = new JTextField();
			TextField3.setBounds(new Rectangle(182, 195, 172, 25));
		}
		return TextField3;
	}

	private JTextField getTextField4() {
		if (TextField4 == null) {
			TextField4 = new JTextField();
			TextField4.setBounds(new Rectangle(110, 229, 244, 25));
		}
		return TextField4;
	}

	private JTextField getTextField5() {
		if (TextField5 == null) {
			TextField5 = new JTextField();
			TextField5.setBounds(new Rectangle(114, 270, 241, 25));
		}
		return TextField5;
	}

	private JTextField getTextField6() {
		if (TextField6 == null) {
			TextField6 = new JTextField();
			TextField6.setBounds(new Rectangle(165, 315, 190, 25));
		}
		return TextField6;
	}

	private JPasswordField getPasswordField2() {
		if (PasswordField2 == null) {
			PasswordField2 = new JPasswordField();
			PasswordField2.setBounds(new Rectangle(161, 392, 192, 25));
		}
		return PasswordField2;
	}

	private JComboBox getComboBox4() {
		if (ComboBox4 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1950;i<=2012;i++)
			 items.add(Integer.toString(i));
			ComboBox4 = new JComboBox(items);
			ComboBox4.setBounds(new Rectangle(292, 157, 64, 25));
		}
		return ComboBox4;
	}
	
	public static void main(String[] args) {
		new Inscription();
	}

	private void initialize() {
		label10 = new Label();
		label10.setBounds(new Rectangle(29, 390, 117, 24));
		label10.setText("Confirmation :");
		label10.setFont(new Font("Dialog", Font.BOLD, 14));
		label9 = new Label();
		label9.setBounds(new Rectangle(30, 353, 121, 24));
		label9.setText("Mot de passe :");
		label9.setFont(new Font("Dialog", Font.BOLD, 14));
		label8 = new Label();
		label8.setBounds(new Rectangle(31, 314, 125, 24));
		label8.setText("Nom Utilisateur :");
		label8.setFont(new Font("Dialog", Font.BOLD, 14));
		label7 = new Label();
		label7.setBounds(new Rectangle(30, 270, 75, 24));
		label7.setText("Fonction :");
		label7.setFont(new Font("Dialog", Font.BOLD, 14));
		label6 = new Label();
		label6.setBounds(new Rectangle(30, 229, 73, 24));
		label6.setText("Diplome :");
		label6.setFont(new Font("Dialog", Font.BOLD, 14));
		label5 = new Label();
		label5.setBounds(new Rectangle(31, 194, 144, 24));
		label5.setText("Lieu de Naissance :");
		label5.setFont(new Font("Dialog", Font.BOLD, 14));
		label4 = new Label();
		label4.setBounds(new Rectangle(31, 157, 144, 24));
		label4.setText("Date de Naissance :");
		label4.setFont(new Font("Dialog", Font.BOLD, 14));
		label3 = new Label();
		label3.setBounds(new Rectangle(30, 121, 41, 24));
		label3.setText("Sex :");
		label3.setFont(new Font("Dialog", Font.BOLD, 14));
		label2 = new Label();
		label2.setBounds(new Rectangle(30, 83, 68, 24));
		label2.setText("Prénom :");
		label2.setFont(new Font("Dialog", Font.BOLD, 14));
		label1 = new Label();
		label1.setBounds(new Rectangle(31, 47, 45, 23));
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		label1.setText("Nom :");
		this.setLayout(null);
		this.setSize(385, 470);
		this.setResizable(false);
		this.setTitle("Inscription :");

		this.add(label1, null);
		this.add(label2, null);
		this.add(label3, null);
		this.add(label4, null);
		this.add(label5, null);
		this.add(label6, null);
		this.add(label7, null);
		this.add(label8, null);
		this.add(label9, null);
		this.add(label10, null);
		this.add(getPasswordField1(), null);
		this.add(getComboBox1(), null);
		this.add(getComboBox2(), null);
		this.add(getComboBox3(), null);
		this.setVisible(true);
		this.add(getButton1(), null);
		this.add(getButton2(), null);
		this.add(getButton3(), null);
		this.add(getTextField1(), null);
		this.add(getTextField2(), null);
		this.add(getTextField3(), null);
		this.add(getTextField4(), null);
		this.add(getTextField5(), null);
		this.add(getTextField6(), null);
		this.add(getPasswordField2(), null);
		this.add(getComboBox4(), null);
	}
} 
