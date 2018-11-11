package SIG;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

public class arbre
{	
	public FORM Form = null;
	public int N=0,Niveau = 1;
	public arbre pere = null,racine = null;
	public String ligne,Information;
	public BufferedReader Lecteur = null;
	public Vector<arbre> Fils = new Vector<arbre>();
	public java.util.Vector<Double> DIST = new java.util.Vector<Double>();
	
	public void FILS() throws IOException
	{
		ligne = Lecteur.readLine();
		if (ligne.startsWith("#")) 
		{
		   N = Integer.parseInt(ligne.substring(1,ligne.length())); 
		   //System.out.println(N);	
		   for(int i=0;i<N;i++)
			Fils.add(new arbre(Lecteur,this));
		}	
	}
	public arbre(BufferedReader Lecteur,arbre pere) throws IOException
	{
		this.Lecteur = Lecteur;
		this.pere = pere;
		if(pere == null)
		 this.racine = this;
		else
	    { 
		 this.racine = pere.racine;
		 this.Niveau = this.pere.Niveau+1;
		}
		if((ligne = Lecteur.readLine()) != null)
		 if (!ligne.startsWith("#")) 
		 {
		  this.Information = ligne;
		 // System.out.println(ligne);  
		  FILS();
		 }
	}
	public int Affichage()
	{
	 int M = 1;
	 for(int i=0;i<N;i++) 
	  M += Fils.elementAt(i).Affichage();
	 System.out.println(this.Information+" "+"Niveau = "+this.Niveau+" RACINE = "+this.racine.Information);
	 return M;
	}
	public void Listing(FORM Form,arbre R)
	{
	 Form.jComboBox2.addItem(R.Information); 
	 for(int i=0;i<N;i++) 
	  Fils.elementAt(i).Listing(Form,Fils.elementAt(i));
	}
	
    public arbre CONCEPT_COMMUN(arbre C1,arbre C2)
    {    
     while(C1.Niveau != C2.Niveau)
     {
      if(C1.Niveau > C2.Niveau)
       C1 = C1.pere;	
      if(C1.Niveau < C2.Niveau)
       C2 = C2.pere;	
     }
     while(C1 != C2)
     {
        C1 = C1.pere;	 
        C2 = C2.pere;
     }
     return C1;
    }
    
	public void ConSim(arbre C1,arbre C2)
	{
	  double ConSim = 0.;
	  arbre CC = null;
	  if(C1 != C2)
	  {
	    CC = CONCEPT_COMMUN(C1,C2);
		double N3 = CC.Niveau;
	    //ConSim = (N3*2)/((C1.Niveau)+(C2.Niveau)+(N3*2));	
	    ConSim = (N3*2)/((C1.Niveau-N3)+(C2.Niveau-N3)+(N3*2));	
		//ConSim = (N3*2)/((C1.Niveau)+(C2.Niveau));	
		
		DecimalFormat df = new DecimalFormat("########.00");
		String str = df.format(ConSim);
		ConSim = Double.parseDouble(str.replace(',', '.')); 
		
	    System.out.println(C1.Information+" "+C2.Information+" CC = "+CC.Information+" ConSim = "+ConSim);
	    
	    /*if(ConSim >= 0.6)
	     Form.list3.add(C2.Information);
	    if(ConSim <= 0.5)
	     Form.list2.add(C2.Information);*/
	  }
	  else
	  {
	   //Form.list3.add(C2.Information);
	   ConSim = 1;
	   System.out.println(C1.Information+" "+C2.Information+" CC = "+" ConSim = "+ConSim);
	  }
	  C1.DIST.add(ConSim);
	  for(int i=0;i<C2.N;i++) 
	   C2.Fils.elementAt(i).ConSim(C1,C2.Fils.elementAt(i));
	}
	
	public void CALCULE_SIM(arbre CON)
	{
	 for(int i=0;i<CON.N;i++) 
	  CON.Fils.elementAt(i).CALCULE_SIM(CON.Fils.elementAt(i));
	 CON.ConSim(CON,CON.racine);
	}
	
	public void MAT(BufferedWriter MC) throws IOException
    {
	  //MC.write(this.Information+" ");
	  for(int i=0;i<DIST.size();i++) 
	   //MC.write(DIST.elementAt(i)+"|");
	   MC.write(DIST.elementAt(i)+" ");

	  MC.write("\n");
	  for(int i=0;i<this.N;i++) 
	   Fils.elementAt(i).MAT(MC);
    }
	
	public arbre Trouver_Etage(String cons)//concept plus proche
	{
		int i;
		for(i=0;i < Fils.size(); i++)
		 if(Fils.elementAt(i).Information.contentEquals(cons))
		  return Fils.elementAt(i).pere;
		 if(i==Fils.size())
		 {
		  for(i=0;i < Fils.size(); i++)
		   if(Fils.elementAt(i).Trouver_Etage(cons)!=null)
		    return Fils.elementAt(i).Trouver_Etage(cons);
		 }
		 
		return null;
	}
	public static void main(String[] args) throws IOException
	{
	  arbre R = new arbre(new BufferedReader(new FileReader("D:\\Documents and Settings\\Utilisateur\\Bureau\\KHALED\\SIG\\src\\Ontologie1.txt")),null); 
	  R.Lecteur.close();
	  System.out.println("_______________________AFFCIHAGE_______________________");
	  int NB_CON = R.Affichage();
	  System.out.println("_______________________________________________________");
	  System.out.println("Nombre des Concepts = "+NB_CON);
	  System.out.println("_______________________________________________________");
	  R.CALCULE_SIM(R);
	  
	  BufferedWriter MC = new BufferedWriter(new FileWriter("D:\\Documents and Settings\\Utilisateur\\Bureau\\KHALED\\SIG\\src\\MATRICE.txt"));
	  R.MAT(MC);
 	  MC.close();
 	  
 	 /*arbre pere = R.Trouver_Etage("Hotel");
      System.out.println(pere.Information);
      for(int i=0;i<pere.Fils.size();i++) 
      {
       System.out.println("______________________________");
	   System.out.println(pere.Fils.elementAt(i).Information);
	   //for(int j=0;j<pere.Fils.elementAt(i).Fils.size();j++) 
		//System.out.println(pere.Fils.elementAt(i).Fils.elementAt(j).Information);
      }*/
	}
}

