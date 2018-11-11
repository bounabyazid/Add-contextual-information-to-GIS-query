package SIG;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JComboBox;
import java.awt.Rectangle;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class FORM extends Frame {
    
	public int num,P_U_X,P_U_Y;
	public String HOTEL = "",RESTAURENT = "",PROCHE = "36000",
	              Enrichir_R = "",Spécifier_R = "",Filtrer_R = "",GPS_R = "";
	
	public CONNECTION C = new CONNECTION();  //  @jve:decl-index=0:
	Vector columnNames1 = new Vector();
	Vector<Vector> data1 = new Vector();  //  @jve:decl-index=0:
    
    Vector columnNames2 = new Vector();  //  @jve:decl-index=0:
    Vector<Vector> data2 = new Vector();  //  @jve:decl-index=0:
    
    Vector columnNames3 = new Vector();
    Vector<Vector> data3 = new Vector();
    
    Vector columnNames4 = new Vector();
    Vector<Vector> data4 = new Vector();  //  @jve:decl-index=0:
    
    Vector<Integer> HXa = new Vector();
    Vector<Integer> HYa = new Vector();
    Vector<Integer> RXa = new Vector();
    Vector<Integer> RYa = new Vector();
    
    float time1,time2,time3,time4;
    long begin,end;

    public MAP map = null;

	private static final long serialVersionUID = 1L;
	
	public JComboBox jComboBox1 = null;
	public JComboBox jComboBox2 = null;
	public JComboBox jComboBox3 = null;
	
	private JLabel Label1 = null;
	private JLabel Label2 = null;
	private JLabel Label3 = null;
	private JLabel Label6 = null;
	private JLabel Label7 = null;
	private JLabel Label8 = null;
	private JLabel Label9 = null;
	private JLabel Label10 = null;
	private JLabel Label11 = null;
	
	public List list1 = null;
	public List list2 = null;
	public List list3 = null;
	public List list4 = null;
	public List list5 = null;
	
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	
	public TextArea textArea1 = null;
	public TextArea textArea2 = null;
	public TextArea textArea3 = null;
	public TextArea textArea4 = null;
	
	private arbre R = null;  //  @jve:decl-index=0:
	public RESULTAT resultat;
	public Conditions conditions;
	
	public FORM() throws HeadlessException {
		super();
		initialize();
	}

	public FORM(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public FORM(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public FORM(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setBounds(new Rectangle(30, 58, 255, 25));
		}
		return jComboBox1;
	}

	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			jComboBox2.setBounds(new Rectangle(300, 57, 240, 25));
			jComboBox2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				  if(jComboBox2.getSelectedItem().toString() != "--Choisir un Concept--")
				  {
				   int i;
				   for(i=0;i<FORM.this.list1.getItemCount();i++)
				   	if(jComboBox2.getSelectedItem().toString().equals(FORM.this.list1.getItem(i).toString()))
				 	 break;
				 		   
				   if(i==FORM.this.list1.getItemCount())
					FORM.this.list1.add(jComboBox2.getSelectedItem().toString());//"N°: "+Integer.toString(i+1)+
				  }
				}
			});
		}
		return jComboBox2;
	}
	   	private JComboBox getJComboBox3() {
		if (jComboBox3 == null) {
			jComboBox3 = new JComboBox();
			jComboBox3.setBounds(new Rectangle(556, 57, 240, 25));
		}
		return jComboBox3;
	}

	private List getList1() {
		if (list1 == null) {
			list1 = new List();
			list1.setBounds(new Rectangle(30, 123, 196, 124));
			list1.setMultipleMode(true);
			
			try {
				R = new arbre(new BufferedReader(new FileReader("C:\\Documents and Settings\\farima\\Bureau\\PROJET\\SIG\\src\\Ontologie1.txt")),null);
				R.Lecteur.close();
				jComboBox2.addItem("--Choisir un Concept--");
				R.Listing(FORM.this,R);
			 } catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();} 
		}
		return list1;
	}
    
	private List getList2() {
		if (list2 == null) {
			list2 = new List();
			list2.setBounds(new Rectangle(300, 122, 188, 124));
		}
		return list2;
	}

	private List getList3() {
		if (list3 == null) {
			list3 = new List();
			list3.setBounds(new Rectangle(490, 122, 52, 123));
		}
		return list3;
	}

	private void CONCEPT_PROCHES(int num_con)
	{
	 int i = 0,j = 0,k = 0;
	 double SIM;
	 String ligne = null;
	 BufferedReader Lecteur = null;
	 try {
	  Lecteur = new BufferedReader(new FileReader("C:\\Documents and Settings\\farima\\Bureau\\PROJET\\SIG\\src\\MATRICE.txt"));
     
	  for(i=0;i<num_con;i++)
	   ligne = Lecteur.readLine();

	  list3.add(ligne);
	  
      i = 0;
	  j = ligne.indexOf(" ");
	   
	  while(j<=ligne.length())
	  {
	   SIM = Double.parseDouble(ligne.substring(i,j));
	   k++;
       if(SIM >= 0.4 && SIM < 0.7)
       {
    	list2.add(jComboBox2.getItemAt(k).toString());
        //list2.add(Integer.toString(k));
        list3.add(Double.toString(SIM));
       }
       if(SIM >= 0.7)
       {
    	list4.add(jComboBox2.getItemAt(k).toString());
        //list3.add(Integer.toString(k));
        list5.add(Double.toString(SIM));
       }
       i = j;
       j = ligne.indexOf(" ",j+1);
       if(j==-1)
       break;
	  }
     } catch (IOException e) {e.printStackTrace();}	 
	}

	private JButton getJButton1() {
			if (jButton1 == null) {
				jButton1 = new JButton();
				jButton1.setBounds(new Rectangle(230, 125, 55, 23));
				jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
					@SuppressWarnings("deprecation")
					public void mouseClicked(java.awt.event.MouseEvent e) {
						list2.clear();
						list3.clear();
						list4.clear();
						list5.clear();
				     for(int j=0;j<list1.getItemCount();j++)
				      for(int i=0;i<jComboBox2.getItemCount();i++)
					   if(jComboBox2.getItemAt(i).toString().equals(list1.getItem(j).toString()))
					 	CONCEPT_PROCHES(i);	
				    }
				});
				jButton1.setText("ok");
			}
			return jButton1;
		}

		private JButton getJButton2() {
			if (jButton2 == null) {
				jButton2 = new JButton();
				jButton2.setBounds(new Rectangle(230, 156, 55, 26));
				jButton2.setText("Del");
				jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						String[] items = list1.getSelectedItems();
						for(int i=0; i < items.length; i++){
						 list1.remove(items[i]);		
						}
					}
				});
			}
			return jButton2;
		}

		private JButton getJButton3() {
			if (jButton3 == null) {
				jButton3 = new JButton();
				jButton3.setBounds(new Rectangle(339, 258, 161, 26));
				jButton3.setText("Enrichir Requête");
				jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
					
					resultat = new RESULTAT();
					resultat.setVisible(true);
					textArea1.setText("");
					String S = "";
					
					Enrichir_R = "Select Hotel,Adresse,Tel_Fax From Hotel where Region='Centre Ville';";
                    
					for(int i=0;i<list1.getItemCount()-1;i++)
                    {
                      S += list1.getItem(i).toString()+",";
                    }
                     
                     S = jComboBox1.getSelectedItem().toString()+" "+S+list1.getItem(list1.getItemCount()-1).toString()+" "+jComboBox3.getSelectedItem().toString()+";";
                     textArea1.setText(S);
                    
                     begin = System.currentTimeMillis();
                      
                      try {
                          C.EXECUTE_REQUETE(Enrichir_R);
					 	  C.REMPLIR_RESULTATS(data1, columnNames1);
					  } catch (SQLException e1) {}
                      
                      resultat.jTable1 = new JTable(data1, columnNames1);
                      resultat.jScrollPane1.setViewportView(resultat.jTable1);
                     end = System.currentTimeMillis();
					 time1 = ((float) (end-begin)) / 1000f;
					 
					 resultat.Label5.setText("NB Resultats = "+data1.size()+" Temps éstimé = "+time1);
					 System.out.println(Enrichir_R);
					}
				});
			}
			return jButton3;
		}

		private JButton getJButton4() {
			if (jButton4 == null) {
				jButton4 = new JButton();
				jButton4.setBounds(new Rectangle(339, 372, 157, 26));
				jButton4.setText("Spécifier Requête");
				jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						String S = ""; 
						Spécifier_R = "Select Hotel,Hotel.Adresse,Hotel.Tel_Fax,Restaurant,Restaurant.Adresse,Restaurant.Tel_Fax From ";
	                    
						for(int i=0;i<list1.getItemCount()-1;i++)
	                    {
	                      S += list1.getItem(i).toString()+",";
	                      Spécifier_R += list1.getItem(i).toString()+",";
	                    }
						
						Spécifier_R += list1.getItem(list1.getItemCount()-1).toString()+" where Hotel.Region='Centre Ville';";// and Restaurant.Region='Centre Ville'
	                    S = jComboBox1.getSelectedItem().toString()+" "+S+list1.getItem(list1.getItemCount()-1).toString()+" "+jComboBox3.getSelectedItem().toString()+";";

						textArea2.setText(S);
						 
						 begin = System.currentTimeMillis();
						  try {
	                          C.EXECUTE_REQUETE(Spécifier_R);
						 	  C.REMPLIR_RESULTATS(data2, columnNames2);
						  } catch (SQLException e1) {}
	                      resultat.jTable2 = new JTable(data2, columnNames2);
	                      resultat.jScrollPane2.setViewportView(resultat.jTable2);
						 end = System.currentTimeMillis();
						 time2 = ((float) (end-begin)) / 1000f;
						 
						 resultat.Label6.setText("NB Resultats = "+data2.size()+" Temps éstimé = "+time2);
						 resultat.setVisible(true);
						 System.out.println(Spécifier_R);
					}
				});
			}
			return jButton4;
		}

		private JButton getJButton5() {
			if (jButton5 == null) {
				jButton5 = new JButton();
				jButton5.setBounds(new Rectangle(341, 482, 158, 26));
				jButton5.setText("Filtrer Requête");
				jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						
						conditions = new Conditions();
						conditions.F = FORM.this;
						FORM.this.setVisible(false);
						conditions.setVisible(true);
					}
				});
			}
			return jButton5;
		}
		public void Requete_GPS()
		{
			   for(int i=0;i<data4.size();i++)
			   {
	              int X1 = Integer.parseInt(data4.elementAt(i).elementAt(3).toString());
	              System.out.println(X1);
		          int Y1 = Integer.parseInt(data4.elementAt(i).elementAt(4).toString());
		          System.out.println(Y1);
		          int X2 = Integer.parseInt(data4.elementAt(i).elementAt(8).toString());
		          System.out.println(X2);
		          int Y2 = Integer.parseInt(data4.elementAt(i).elementAt(9).toString());
		          System.out.println(Y2);
		                       
	              HXa.add(X1);HYa.add(Y1);
	              RXa.add(X2);RYa.add(Y2);
	              
	              int DIST_GPS1 = (int) Math.sqrt(Math.pow((double)(X1-P_U_X),2)+Math.pow((double)(Y1-P_U_Y),2));
	              int DIST_GPS2 = (int) Math.sqrt(Math.pow((double)(X2-P_U_X),2)+Math.pow((double)(Y2-P_U_Y),2));
	              
	              System.out.println("DIST_GPS1 = "+DIST_GPS1+" DIST_GPS2 = "+DIST_GPS2);
	              if(DIST_GPS1 > Integer.parseInt(PROCHE) && DIST_GPS2 > Integer.parseInt(PROCHE))
	               data4.removeElementAt(i);
	            }    
		}
		private JButton getJButton6() {
			if (jButton6 == null) {
				jButton6 = new JButton();
				jButton6.setBounds(new Rectangle(344, 588, 157, 26));
				jButton6.setText("Enrichir Req GPS");
				jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
					 begin = System.currentTimeMillis();
					 textArea4.setText(textArea3.getText()+"Proche = "+PROCHE);
					 
					 if(map==null)
					 {
					  map = new MAP();
					  map.F = FORM.this;
                 	  map.setVisible(true);
					 }

 					 GPS_R = Filtrer_R;
 					 GPS_R = GPS_R.replaceAll("Restaurant,Restaurant.Adresse","H_X,H_Y,Restaurant,Restaurant.Adresse");
 					 GPS_R = GPS_R.replaceAll("Restaurant.Tel_Fax,","Restaurant.Tel_Fax,R_X,R_Y,");
  		
 					 System.out.println(GPS_R);
 					 
 					 try {
                        C.EXECUTE_REQUETE(GPS_R);
					 	C.REMPLIR_RESULTATS(data4, columnNames4);
					 	Requete_GPS();
					  } catch (SQLException e1) {}
 					
 					 resultat.jTable4 = new JTable(data4, columnNames4);
 					 resultat.jScrollPane4.setViewportView(resultat.jTable4);
                     resultat.setVisible(true);
                     end = System.currentTimeMillis();
					 time4 = ((float) (end-begin)) / 1000f;
					 resultat.Label8.setText("NB Resultats = "+data4.size()+" Temps éstimé = "+time4);
				
					 COMPARESON Comp = new COMPARESON();
					 Comp.columnNames.addElement("Requete");
					 Comp.columnNames.addElement("Nombre de Résults");
					 Comp.columnNames.addElement("Temps éstimé");
					 
					 Vector row1 = new Vector(3);
					 Vector row2 = new Vector(3);
					 Vector row3 = new Vector(3);
					 Vector row4 = new Vector(3);
					 
					 row1.addElement("Requete Enrichie");
					 row1.addElement(data1.size());
					 row1.addElement(time1);
					 Comp.data.addElement(row1);
					 
					 row2.addElement("Requete Spécifier");
					 row2.addElement(data2.size());
					 row2.addElement(time2);
					 Comp.data.addElement(row2);
					 
					 row3.addElement("Requete Filtré");
					 row3.addElement(data3.size());
					 row3.addElement(time3);
					 Comp.data.addElement(row3);
					 
					 row4.addElement("Requete GPS");
					 row4.addElement(data4.size());
					 row4.addElement(time4);
					 Comp.data.addElement(row4);
					 
					 Comp.jTable1 = new JTable(Comp.data, Comp.columnNames);
					 Comp.jScrollPane1.setViewportView(Comp.jTable1);
					 Comp.setVisible(true);
					}
				});
			}
			return jButton6;
		}

		private List getList4() {
			if (list4 == null) {
				list4 = new List();
				list4.setBounds(new Rectangle(557, 122, 188, 124));
				list4.setMultipleMode(true);
			}
			return list4;
		}

		private JButton getJButton7() {
			if (jButton7 == null) {
				jButton7 = new JButton();
				jButton7.setBounds(new Rectangle(802, 122, 52, 26));
				jButton7.setText("Del");
				jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) 
					{				
					 for(int i=list4.getItemCount()-1;i >= 0; i--)
					  if(list4.isSelected(i)) 
					  {
					   list4.remove(i);
					   list5.remove(i);
					  }
				    }
				});
			}
			return jButton7;
		}

		private TextArea getTextArea1() {
			if (textArea1 == null) {
				textArea1 = new TextArea();
				textArea1.setBounds(new Rectangle(30, 292, 767, 73));
				textArea1.setFont(new Font("Dialog", Font.PLAIN, 14));
			}
			return textArea1;
		}

		private TextArea getTextArea2() {
			if (textArea2 == null) {
				textArea2 = new TextArea();
				textArea2.setBounds(new Rectangle(30, 408, 766, 67));
				textArea2.setFont(new Font("Dialog", Font.PLAIN, 14));
			}
			return textArea2;
		}

		private TextArea getTextArea3() {
			if (textArea3 == null) {
				textArea3 = new TextArea();
				textArea3.setBounds(new Rectangle(30, 514, 767, 71));
				textArea3.setFont(new Font("Dialog", Font.PLAIN, 14));
			}
			return textArea3;
		}

		private TextArea getTextArea4() {
			if (textArea4 == null) {
				textArea4 = new TextArea();
				textArea4.setBounds(new Rectangle(30, 620, 765, 74));
				textArea4.setFont(new Font("Dialog", Font.PLAIN, 14));
			}
			return textArea4;
		}

		private JButton getJButton8() {
			if (jButton8 == null) {
				jButton8 = new JButton();
				jButton8.setBounds(new Rectangle(574, 698, 123, 32));
				jButton8.setText("Modifier profil");
			}
			return jButton8;
		}

		private JButton getJButton9() {
			if (jButton9 == null) {
				jButton9 = new JButton();
				jButton9.setBounds(new Rectangle(711, 699, 84, 32));
				jButton9.setText("Quitter");
				jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						System.exit(0);
					}
				});
			}
			return jButton9;
		}

		private List getList5() {
			if (list5 == null) {
				list5 = new List();
				list5.setBounds(new Rectangle(747, 122, 52, 123));
				list5.setMultipleMode(true);
			}
			return list5;
		}

		public static void main(String[] args) {
		new FORM();
		
	}

	private void initialize() 
	{
		Label11 = new JLabel();
		Label11.setBounds(new Rectangle(31, 589, 217, 18));
		Label11.setText("Requete enrichie par la position GPS :");
		Label10 = new JLabel();
		Label10.setBounds(new Rectangle(30, 487, 225, 16));
		Label10.setText("Requête filtrée par le profil utilisateur : ");
		Label2 = new JLabel();
		Label2.setBounds(new Rectangle(299, 32, 140, 19));
		Label2.setText("Creation d'une requete :");
		Label9 = new JLabel();
		Label9.setText("Spécification par les conditions de l'utilisateur :");
		Label9.setBounds(new Rectangle(30, 379, 273, 16));
		Label8 = new JLabel();
		Label8.setBounds(new Rectangle(31, 256, 193, 26));
		Label8.setText("Requete enrichie par l'ontologie :");
		Label7 = new JLabel();
		Label7.setBounds(new Rectangle(556, 88, 242, 30));
		Label7.setText("Liste des concepts proches avec S = 0.6");
		Label6 = new JLabel();
		Label6.setBounds(new Rectangle(300, 88, 242, 31));
		Label6.setText("Liste des concepts proches avec S = 0.4 ");
		Label3 = new JLabel();
		Label3.setBounds(new Rectangle(29, 87, 256, 29));
		Label3.setText("Liste des concepts initiaux");
		Label1 = new JLabel();
		Label1.setBounds(new Rectangle(31, 30, 64, 22));
		Label1.setText("Domaine :");
		this.setLayout(null);
		this.setSize(878, 745);
		this.setResizable(false);
		this.setTitle("Recherche :");
		this.setVisible(true);
		this.add(getJComboBox1(), null);
		this.add(Label1, null);
		this.add(getJComboBox2(), null);
		this.add(getJComboBox3(), null);
		this.add(Label3, null);
		this.add(Label6, null);
		this.add(Label7, null);
		this.add(Label8, null);
		this.add(Label9, null);
		this.add(getList1(), null);
		this.add(getList2(), null);
		this.add(getList3(), null);
		this.add(Label2, null);
		this.add(Label10, null);
		this.add(Label11, null);
		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
		this.add(getJButton3(), null);
		this.add(getJButton4(), null);
		this.add(getJButton5(), null);
		this.add(getJButton6(), null);
		this.add(getList4(), null);
		this.add(getJButton7(), null);
		this.add(getTextArea1(), null);
		this.add(getTextArea2(), null);
		this.add(getTextArea3(), null);
		this.add(getTextArea4(), null);
		this.add(getJButton8(), null);
		this.add(getJButton9(), null);
		this.add(getList5(), null);
		
		this.jComboBox1.addItem("Rechercher"); 
		this.jComboBox1.addItem("Trouver"); 
		this.jComboBox1.addItem("Localiser"); 
				
		this.jComboBox3.addItem("Eloigner"); 
		this.jComboBox3.addItem("Proche"); 
		this.jComboBox3.addItem("Plus proche"); 

	}
}  //  @jve:decl-index=0:visual-constraint="9,11"