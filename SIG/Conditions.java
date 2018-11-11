package SIG;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTable;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Conditions extends Frame {

	private static final long serialVersionUID = 1L;
	
	FORM F = null;
	
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Label label6 = null;
	
	public JComboBox ComboBox1 = null;
	public JComboBox ComboBox2 = null;
	public JComboBox ComboBox3 = null;
    public JComboBox ComboBox4 = null;
    public JComboBox ComboBox5 = null;
	
	private JButton Button1 = null;
	private JButton Button2 = null;
	private JButton Button3 = null;
	
	private Vector items1 = null;
	private Vector items11 = null;
	
	private JTextField jTextField1 = null;
	
	public Conditions() throws HeadlessException {
		super();
		initialize();
	}

	public Conditions(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public Conditions(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public Conditions(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	private JButton getButton1() {
		if (Button1 == null) {
			Button1 = new JButton();
			Button1.setBounds(new Rectangle(14, 261, 81, 38));
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
			Button2.setBounds(new Rectangle(101, 261, 150, 38));
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
			Button3.setBounds(new Rectangle(256, 261, 91, 38));
			Button3.setText("Valider");
			Button3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {	  			   					   
					       F.begin = System.currentTimeMillis();
						   String S = "",Cond = "";
						   //-----------------------------------------------------------
						   if(ComboBox1.getSelectedItem().toString() != "")
						    F.HOTEL = "Hotel.Nombre_Etoile='"+ComboBox1.getSelectedItem().toString()+"'";
						   if(ComboBox2.getSelectedItem().toString()!="" && F.HOTEL != "")
						    F.HOTEL += ", "+"Hotel.Region='"+ComboBox2.getSelectedItem()+"'";				   				  
						   if(ComboBox3.getSelectedItem().toString() != "")
							F.RESTAURENT = " Restaurant.Categorie='"+ComboBox3.getSelectedItem()+"'";				   
						   if(ComboBox4.getSelectedItem().toString() != "")
							F.RESTAURENT += ", "+"Restaurant.Regime_Alimentaire='"+ComboBox4.getSelectedItem()+"'";
						   if(ComboBox5.getSelectedItem().toString() != "")   
							F.RESTAURENT += ", "+"Restaurant.Region='"+ComboBox5.getSelectedItem()+"'";
						   if(jTextField1.getText()!="")
							F.PROCHE = jTextField1.getText();
						   //-----------------------------------------------------------
						   if(F.HOTEL!="" && F.RESTAURENT!="")
							Cond = "\n"+F.HOTEL+","+F.RESTAURENT;
					       else
					       {
					        if(F.HOTEL!="")
					         Cond += " "+F.HOTEL;
					        if(F.RESTAURENT!="")
					        {
					         if(Cond != "")	 
					          Cond += ","+F.RESTAURENT;
							 else
							  Cond = F.RESTAURENT;
					        }
					       }
						   //-----------------------------------------------------------
						   try {
		                         F.C.EXECUTE_REQUETE("Select * From PROFIL Where ID_U="+Integer.toString(F.num)+";");
		                         F.C.AFFICHER_RESULTATS();
		                         
		                         String POIDS = F.C.data.elementAt(12).elementAt(2).toString();
		                         POIDS = POIDS.replace(",",".");
		                         double Poids = Double.parseDouble(POIDS);
		                         if(Poids >  0.6)							  
		                          Cond += ", Sejour.PRIX"+F.C.data.elementAt(12).elementAt(4).toString()+F.C.data.elementAt(12).elementAt(5).toString();
							  } catch (SQLException e1) {} 
				           //-----------------------------------------------------------      
						   F.Filtrer_R = "Select Hotel,Hotel.Adresse,Hotel.Tel_Fax,Restaurant,Restaurant.Adresse,Restaurant.Tel_Fax";
						   if(Cond!="")
							F.Filtrer_R += ",Sejour.SEJOUR";
						   F.Filtrer_R += " From ";    
						   for(int i=0;i<F.list1.getItemCount()-1;i++)
						   {
							S += F.list1.getItem(i).toString()+",";
						   	F.Filtrer_R += F.list1.getItem(i).toString()+",";	
						   }
						   F.Filtrer_R += F.list1.getItem(F.list1.getItemCount()-1).toString()+",";
						   if(Cond!="")
							F.Filtrer_R += "Sejour";  
						   Cond = Cond.replace(","," and");
						   F.Filtrer_R += " Where";
						   if(Cond!="")
							F.Filtrer_R += Cond;
						   F.Filtrer_R += ";"; 
						   F.Filtrer_R = F.Filtrer_R.replace("\n"," ");
						   
						   //-----------------------------------------------------------
						   try {
		                         F.C.EXECUTE_REQUETE(F.Filtrer_R);
		                         F.C.REMPLIR_RESULTATS(F.data3, F.columnNames3);
							  } catch (SQLException e1) {}    
						   //-----------------------------------------------------------
			               F.show();
			               Conditions.this.dispose();
			               
			               F.textArea3.setText(F.Filtrer_R);
			               System.out.println(F.Filtrer_R);
			               //-----------------------------------------------------------
						   F.end = System.currentTimeMillis();
			               F.time3 = ((float) (F.end-F.begin)) / 1000f;
			               F.resultat.Label7.setText("NB Resultats = "+F.data3.size()+" Temps éstimé = "+F.time3);
			               F.resultat.jTable3 = new JTable(F.data3, F.columnNames3);
			               F.resultat.jScrollPane3.setViewportView(F.resultat.jTable3);
			               F.resultat.setVisible(true);
			               
			               //-----------------------------------------------------------
					}
			});
		}
		return Button3;
	}

	
	public static void main(String[] args) {
		Conditions C = new Conditions();
		C.setVisible(true);
	}
	private void initialize() {
		label6 = new Label();
		label6.setBounds(new Rectangle(15, 222, 157, 24));
		label6.setText("Proche :");
		label6.setFont(new Font("Dialog", Font.BOLD, 14));
		label5 = new Label();
		label5.setBounds(new Rectangle(14, 185, 157, 24));
		label5.setText("Région Restaurant :");
		label5.setFont(new Font("Dialog", Font.BOLD, 14));
		label4 = new Label();
		label4.setBounds(new Rectangle(14, 150, 165, 24));
		label4.setText("Régime Alimentaire :");
		label4.setFont(new Font("Dialog", Font.BOLD, 14));
		label3 = new Label();
		label3.setBounds(new Rectangle(14, 115, 185, 24));
		label3.setText("Categorie de restaurant :");
		label3.setFont(new Font("Dialog", Font.BOLD, 14));
		label2 = new Label();
		label2.setBounds(new Rectangle(15, 78, 120, 24));
		label2.setText("Region d'hotel :");
		label2.setFont(new Font("Dialog", Font.BOLD, 14));
		label1 = new Label();
		label1.setBounds(new Rectangle(15, 42, 174, 24));
		label1.setText("Hotel Nombre d'étoiles :");
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		this.setLayout(null);
		this.setSize(357, 324);
		this.setResizable(true);
		this.setTitle("Conditions Utilisateur :");
		this.setVisible(true);
		
		this.add(label1, null);
		this.add(label2, null);
		this.add(label3, null);
		this.add(label4, null);
		this.add(label5, null);
		this.add(label6, null);
		
		this.add(getComboBox1(), null);
		this.add(getComboBox2(), null);
		this.add(getComboBox3(), null);
		this.add(getComboBox4(), null);
		this.add(getComboBox5(), null);
		this.add(getJTextField1(), null);
		
		this.add(getButton1(), null);
		this.add(getButton2(), null);
		this.add(getButton3(), null);
					
		this.ComboBox2.addItem("Centre Ville");
		this.ComboBox2.addItem("les environs de la Ville");
						
		this.ComboBox3.addItem("Classe A");
		this.ComboBox3.addItem("Classe B");
		this.ComboBox3.addItem("Classe C");
		this.ComboBox3.addItem("Hors Classe");
		
		this.ComboBox4.addItem("Alimentation carnée");
		this.ComboBox4.addItem("Alimentation lactée");
		this.ComboBox4.addItem("Alimentation végétale");
		
		this.ComboBox5.addItem("Centre Ville");
		this.ComboBox5.addItem("les environs de la Ville");
	}
	
	private JComboBox getComboBox1() {//
		if (ComboBox1 == null) {
			Vector <String> items = new Vector <String> ();
			for(int i=1;i<=7;i++)
			 items.add(Integer.toString(i));
			ComboBox1 = new JComboBox(items);
			ComboBox1.setBounds(new Rectangle(191, 42, 155, 24));
		}
		return ComboBox1;
	}
	
	private JComboBox getComboBox2() {//
		if (ComboBox2 == null) {
			ComboBox2 = new JComboBox();
			ComboBox2.setBounds(new Rectangle(200, 78, 145, 25));
		}
		return ComboBox2;
	}

	private JComboBox getComboBox3() {
		if (ComboBox3 == null) {
			ComboBox3 = new JComboBox();
			ComboBox3.setBounds(new Rectangle(201, 115, 145, 24));
		}
		return ComboBox3;
	}
	
	private JComboBox getComboBox4() {
		if (ComboBox4 == null) {
			ComboBox4 = new JComboBox();
			ComboBox4.setBounds(new Rectangle(183, 150, 163, 24));
		}
		return ComboBox4;
	}
	
	private JComboBox getComboBox5() {
		if (ComboBox5 == null) {
			ComboBox5 = new JComboBox();
			ComboBox5.setBounds(new Rectangle(183, 185, 162, 25));
		}
		return ComboBox5;
	}
	
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(183, 222, 163, 24));
			jTextField1.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return jTextField1;
	}

}
