package SIG;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Profil extends Frame {

	private static final long serialVersionUID = 1L;
	private Label label1 = null;
	private JTextField jTextField1 = null;
	private Label label3 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Label label6 = null;
	private Label label2 = null;
	private JComboBox ComboBox1 = null;
	private JComboBox ComboBox2 = null;
	private JComboBox ComboBox3 = null;
	private JComboBox ComboBox4 = null;
	private JComboBox ComboBox5 = null;
	private JComboBox ComboBox6 = null;
	private Label label7 = null;
	private JCheckBox CheckBox1 = null;
	private JComboBox ComboBox7 = null;
	private Label label8 = null;
	private JComboBox ComboBox8 = null;
	private Label label9 = null;
	private JTextField jTextField2 = null;
	private Label label10 = null;
	private JComboBox ComboBox9 = null;
	private JComboBox ComboBox10 = null;
	private JComboBox ComboBox11 = null;
	private JComboBox ComboBox12 = null;
	private JComboBox ComboBox13 = null;
	private JComboBox ComboBox14 = null;
	private JComboBox ComboBox15 = null;
	private JComboBox ComboBox16 = null;
	private JComboBox ComboBox17 = null;
	private JComboBox ComboBox18 = null;
	private JComboBox ComboBox19 = null;
	private JComboBox ComboBox20 = null;
	private JButton Button1 = null;
	private JButton Button2 = null;
	private JButton Button3 = null;
	private Label label11 = null;
	private JTextField jTextField3 = null;
	private JComboBox ComboBox21 = null;
	private Label label12 = null;
	private Label label13 = null;
	private Vector items1 = null;
	private JTextField jTextField4 = null;
	private JComboBox ComboBox22 = null;
	private Vector items11 = null;
	public Profil() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public Profil(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Profil(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Profil(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	private JComboBox getComboBox11() {
		if (ComboBox11 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox11 = new JComboBox(items);
			ComboBox11.setBounds(new Rectangle(375, 81, 48, 25));
		}
		return ComboBox11;
	}

	private JComboBox getComboBox12() {
		if (ComboBox12 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox12 = new JComboBox(items);
			ComboBox12.setBounds(new Rectangle(375, 116, 47, 25));
		}
		return ComboBox12;
	}

	private JComboBox getComboBox13() {
		if (ComboBox13 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox13 = new JComboBox(items);
			ComboBox13.setBounds(new Rectangle(375, 152, 47, 25));
		}
		return ComboBox13;
	}

	private JComboBox getComboBox14() {
		if (ComboBox14 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox14 = new JComboBox(items);
			ComboBox14.setBounds(new Rectangle(375, 188, 48, 25));
		}
		return ComboBox14;
	}

	private JComboBox getComboBox15() {
		if (ComboBox15 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox15 = new JComboBox(items);
			ComboBox15.setBounds(new Rectangle(375, 227, 48, 25));
		}
		return ComboBox15;
	}

	private JComboBox getComboBox16() {
		if (ComboBox16 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox16 = new JComboBox(items);
			ComboBox16.setBounds(new Rectangle(376, 265, 46, 28));
		}
		return ComboBox16;
	}

	private JComboBox getComboBox17() {
		if (ComboBox17 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
		     items.add(Double.toString(i/10));
			ComboBox17 = new JComboBox(items);
			ComboBox17.setBounds(new Rectangle(375, 306, 47, 25));
		}
		return ComboBox17;
	}

	private JComboBox getComboBox18() {
		if (ComboBox18 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox18 = new JComboBox(items);
			ComboBox18.setBounds(new Rectangle(375, 343, 48, 25));
		}
		return ComboBox18;
	}

	private JComboBox getComboBox19() {
		if (ComboBox19 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox19 = new JComboBox(items);
			ComboBox19.setBounds(new Rectangle(375, 383, 47, 25));
		}
		return ComboBox19;
	}

	private JComboBox getComboBox20() {
		if (ComboBox20 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox20 = new JComboBox(items);
			ComboBox20.setBounds(new Rectangle(375, 424, 47, 25));
		}
		return ComboBox20;
	}

	private JButton getButton1() {
		if (Button1 == null) {
			Button1 = new JButton();
			Button1.setBounds(new Rectangle(29, 544, 81, 38));
			Button1.setText("Quiter");
			Button1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.exit(0);
				}
			});
		}
		return Button1;
	}

	private JButton getButton2() {
		if (Button2 == null) {
			Button2 = new JButton();
			Button2.setBounds(new Rectangle(137, 544, 168, 38));
			Button2.setText("Vider les champs");
			Button2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					initialize();				}
			});
		}
		return Button2;
	}

	private JButton getButton3() {
		if (Button3 == null) {
			Button3 = new JButton();
			Button3.setBounds(new Rectangle(331, 544, 91, 38));
			Button3.setText("Valider");
			Button3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {						  
				      	   Class.forName("org.postgresql.Driver");
				      	   Connection C = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIG","postgres","admin");
						   Statement state = C.createStatement(); 
						   
						   ResultSet result = state.executeQuery("SELECT MAX(num) FROM \"USER\";");
						   
						   String id_u = "";
						   while(result.next())
					        id_u = result.getObject(1).toString();
						   
						   result.close();
						   						  			   					   
						   //-----------------------------------------------------------
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','1','Nombre de jours de voyage','=','"+jTextField1.getText()+"','"+ComboBox10.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','2','Lieu de départ','=','"+jTextField2.getText()+"','"+ComboBox11.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','3','Heure de départ','=','"+ComboBox1.getSelectedItem()+"','"+ComboBox12.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','4','Voyage direct','=','"+CheckBox1.isSelected()+"','"+ComboBox13.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','5','Moyen de transport','=','"+ComboBox2.getSelectedItem()+"','"+ComboBox14.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','6','Niveau du confort','=','"+ComboBox3.getSelectedItem()+"','"+ComboBox15.getSelectedItem()+"');");
						   
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','7','Hotel nombre étoiles','=','"+ComboBox4.getSelectedItem()+"','"+ComboBox16.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','8','Region hotel','=','"+ComboBox5.getSelectedItem()+"','"+ComboBox17.getSelectedItem()+"');");
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','9','Proche','=','"+jTextField3.getText()+"','"+ComboBox18.getSelectedItem()+"');");				   				  
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','10','Type de sejour','=','"+ComboBox6.getSelectedItem()+"','"+ComboBox19.getSelectedItem()+"');");
						   
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','11','Categorie de restaurant','=','"+ComboBox7.getSelectedItem()+"','"+ComboBox20.getSelectedItem()+"');");				   

						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','12','Régime alimentaire','=','"+ComboBox8.getSelectedItem()+"','"+ComboBox19.getSelectedItem()+"');");				   
						   state.executeUpdate("INSERT INTO \"PROFIL\"(id_u, id_c, lien, operateur, valeur, poids)VALUES('"+id_u+"','13','Le montant a dépenser','"+ComboBox9.getSelectedItem()+"','"+jTextField2.getText()+"','"+ComboBox19.getSelectedItem()+"');");				   

						   //-----------------------------------------------------------
						   Profil.this.dispose();
						   FORM F = new FORM();
						   F.num = Integer.parseInt(id_u);
						   
						   state.close();	
						   C.close();
					  }
				      catch (Exception e1) {e1.printStackTrace();}
				      
					}
			});
		}
		return Button3;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(158, 342, 203, 25));
		}
		return jTextField3;
	}

	private JComboBox getComboBox21() {
		if (ComboBox21 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox21 = new JComboBox(items);
			ComboBox21.setBounds(new Rectangle(375, 460, 48, 25));
		}
		return ComboBox21;
	}

	
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(254, 497, 107, 25));
		}
		return jTextField4;
	}

	private JComboBox getComboBox22() {
		if (ComboBox22 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox22 = new JComboBox(items);
			ComboBox22.setBounds(new Rectangle(375, 498, 48, 25));
		}
		return ComboBox22;
	}

	public static void main(String[] args) {
		new Profil();
	}
	private void initialize() {
		label13 = new Label();
		label13.setBounds(new Rectangle(29, 496, 153, 24));
		label13.setText("Le montant dépensé:");
		label13.setFont(new Font("Dialog", Font.BOLD, 14));
		label12 = new Label();
		label12.setBounds(new Rectangle(29, 460, 153, 27));
		label12.setText("Régime alimentaire :");
		label12.setFont(new Font("Dialog", Font.BOLD, 14));
		label11 = new Label();
		label11.setBounds(new Rectangle(29, 424, 185, 24));
		label11.setText("Categorie de restaurant :");
		label11.setFont(new Font("Dialog", Font.BOLD, 14));
		label10 = new Label();
		label10.setBounds(new Rectangle(30, 383, 122, 24));
		label10.setText("Type de sejour :");
		label10.setFont(new Font("Dialog", Font.BOLD, 14));
		label9 = new Label();
		label9.setBounds(new Rectangle(30, 344, 116, 24));
		label9.setText("Proche :");
		label9.setFont(new Font("Dialog", Font.BOLD, 14));
		label8 = new Label();
		label8.setBounds(new Rectangle(30, 304, 120, 24));
		label8.setText("Region d'hotel :");
		label8.setFont(new Font("Dialog", Font.BOLD, 14));
		label7 = new Label();
		label7.setBounds(new Rectangle(29, 265, 174, 24));
		label7.setText("Hotel Nombre d'étoiles :");
		label7.setFont(new Font("Dialog", Font.BOLD, 14));
		label2 = new Label();
		label2.setBounds(new Rectangle(29, 79, 117, 24));
		label2.setText("Lieu de départ :");
		label2.setFont(new Font("Dialog", Font.BOLD, 14));
		label6 = new Label();
		label6.setBounds(new Rectangle(28, 228, 140, 24));
		label6.setText("Niveau du Confort :");
		label6.setFont(new Font("Dialog", Font.BOLD, 14));
		label5 = new Label();
		label5.setBounds(new Rectangle(28, 190, 153, 24));
		label5.setText("Moyen de transport :" +
				"");
		label5.setFont(new Font("Dialog", Font.BOLD, 14));
		label4 = new Label();
		label4.setBounds(new Rectangle(28, 153, 122, 24));
		label4.setText("Voyage direct :");
		label4.setFont(new Font("Dialog", Font.BOLD, 14));
		label3 = new Label();
		label3.setBounds(new Rectangle(28, 116, 128, 24));
		label3.setText("Heure de départ :");
		label3.setFont(new Font("Dialog", Font.BOLD, 14));
		label1 = new Label();
		label1.setBounds(new Rectangle(29, 43, 212, 24));
		label1.setText("Nombre de jours de voyage :");
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		this.setLayout(null);
		this.setSize(449, 602);
		this.setResizable(true);
		this.setTitle("Profil Utilisateur :");
		this.setVisible(true);
		this.add(label1, null);
		this.add(label3, null);
		this.add(label4, null);
		this.add(label5, null);
		this.add(getJTextField1(), null);
		this.add(label6, null);
		this.add(label2, null);
		this.add(getComboBox2(), null);
		this.add(getComboBox3(), null);
		this.add(getComboBox4(), null);
		this.add(getComboBox5(), null);
		this.add(getComboBox6(), null);
		this.add(label7, null);
		this.add(getCheckBox1(), null);
		this.add(label8, null);
		this.add(getComboBox8(), null);
		this.add(label9, null);
		this.add(getJTextField2(), null);
		this.add(label10, null);
		this.add(getComboBox11(), null);
		this.add(getComboBox12(), null);
		this.add(getComboBox13(), null);
		this.add(getComboBox14(), null);
		this.add(getComboBox15(), null);
		this.add(getComboBox16(), null);
		this.add(getComboBox17(), null);
		this.add(getComboBox18(), null);
		this.add(getComboBox19(), null);
		this.add(getComboBox20(), null);
		this.add(getButton1(), null);
		this.add(getButton2(), null);
		this.add(getButton3(), null);
		this.add(label11, null);
		this.add(getJTextField3(), null);
		this.add(getComboBox21(), null);
		this.add(label12, null);
		this.add(label13, null);
		this.add(getComboBox1(), null);
		this.add(getComboBox10(), null);
		this.add(getComboBox7(), null);
		this.add(getComboBox9(), null);
		this.add(getComboBox22(), null);
		this.add(getJTextField4(), null);
		
		this.ComboBox2.addItem("Avion");
		this.ComboBox2.addItem("Bus");
		this.ComboBox2.addItem("Bateau");
		this.ComboBox2.addItem("Train");
		this.ComboBox2.addItem("Voiture");
		
		this.ComboBox5.addItem("Centre Ville");
		this.ComboBox5.addItem("les environs de la Ville");
				
		this.ComboBox6.addItem("Circuits Scientifiques");
		this.ComboBox6.addItem("Circuits Religieux");
		this.ComboBox6.addItem("Circuits Touristiques");
		
		this.ComboBox7.addItem("Classe A");
		this.ComboBox7.addItem("Classe B");
		this.ComboBox7.addItem("Classe C");
		this.ComboBox7.addItem("Hors Classe");
		
		this.ComboBox8.addItem("Alimentation carnée");
		this.ComboBox8.addItem("Alimentation lactée");
		this.ComboBox8.addItem("Alimentation végétale");
		
		this.ComboBox9.addItem("<");
		this.ComboBox9.addItem("<=");
		this.ComboBox9.addItem("=");
		this.ComboBox9.addItem(">=");
		this.ComboBox9.addItem(">");
		
	}
	
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(251, 43, 110, 24));
		}
		return jTextField1;
	}

	/**
	 * This method initializes ComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboBox1() {
		if (ComboBox1 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=24;i++)
			 items.add(Integer.toString(i));
			ComboBox1 = new JComboBox(items);
			ComboBox1.setBounds(new Rectangle(163, 116, 198, 25));
		}
		return ComboBox1;
	}

	private JComboBox getComboBox2() {
		if (ComboBox2 == null) {
			ComboBox2 = new JComboBox();
			ComboBox2.setBounds(new Rectangle(188, 189, 173, 25));
		}
		return ComboBox2;
	}

	private JComboBox getComboBox3() {
		if (ComboBox3 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=12;i++)
			 items.add(Integer.toString(i));
			ComboBox3 = new JComboBox(items);
			ComboBox3.setBounds(new Rectangle(176, 229, 185, 25));
		}
		return ComboBox3;
	}

	private JComboBox getComboBox4() {
		if (ComboBox4 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=7;i++)
			 items.add(Integer.toString(i));
			ComboBox4 = new JComboBox(items);
			ComboBox4.setBounds(new Rectangle(209, 267, 153, 25));
		}
		return ComboBox4;
	}

	private JComboBox getComboBox5() {
		if (ComboBox5 == null) {
			ComboBox5 = new JComboBox();
			ComboBox5.setBounds(new Rectangle(158, 305, 203, 25));
		}
		return ComboBox5;
	}

	private JComboBox getComboBox6() {
		if (ComboBox6 == null) {
			ComboBox6 = new JComboBox();
			ComboBox6.setBounds(new Rectangle(160, 382, 201, 25));
		}
		return ComboBox6;
	}

	private JCheckBox getCheckBox1() {
		if (CheckBox1 == null) {
			CheckBox1 = new JCheckBox();
			CheckBox1.setBounds(new Rectangle(159, 152, 202, 26));
			CheckBox1.setText("oui");
		}
		return CheckBox1;
	}

	private JComboBox getComboBox7() {
		if (ComboBox7 == null) {
			ComboBox7 = new JComboBox();
			ComboBox7.setBounds(new Rectangle(225, 424, 136, 25));
		}
		return ComboBox7;
	}

	private JComboBox getComboBox8() {
		if (ComboBox8 == null) {
			ComboBox8 = new JComboBox();
			ComboBox8.setBounds(new Rectangle(193, 461, 168, 25));
		}
		return ComboBox8;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(153, 79, 210, 25));
		}
		return jTextField2;
	}

	private JComboBox getComboBox9() {
		if (ComboBox9 == null) {
			ComboBox9 = new JComboBox();
			ComboBox9.setBounds(new Rectangle(193, 497, 53, 25));
		}
		return ComboBox9;
	}
	private JComboBox getComboBox10() {
		if (ComboBox10 == null) {
			Vector <String> items = new Vector <String> ();
			for(double i=0;i<=10;i++)
			 items.add(Double.toString(i/10));
			ComboBox10 = new JComboBox(items);
			ComboBox10.setBounds(new Rectangle(374, 43, 49, 25));
		}
		return ComboBox10;
	}
}  //  @jve:decl-index=0:visual-constraint="32,28"
