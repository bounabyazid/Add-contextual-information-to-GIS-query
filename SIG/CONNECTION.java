package SIG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CONNECTION
{
	public Connection connection;
	public Statement state;
	public ResultSet result;
	public ResultSetMetaData resultMeta;
	public Vector<Vector> data = new Vector();
	
	public CONNECTION()
	{
	 
		  try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
	      String DBurl= "jdbc:odbc:base" ;
	      connection = DriverManager.getConnection(DBurl);
	      state = connection.createStatement();
		  } catch (ClassNotFoundException e) {} catch (SQLException e) {
			
		}
	}
	
	public void DECONECTE() throws SQLException
	{
	   state.close();
	   connection.close();
	}
	
	public void EXECUTE_REQUETE(String Requete) throws SQLException
	{
	   result = state.executeQuery(Requete);
	   resultMeta = result.getMetaData();
	}

	public void REMPLIR_RESULTATS(Vector data,Vector columnNames) throws SQLException
	{
		int columns = resultMeta.getColumnCount();
	    
        for (int i = 1; i <=columns; i++) {
         columnNames.addElement(resultMeta.getColumnName(i));
        }
        while (result.next()) 
        {
            Vector row = new Vector(columns);
            for (int i = 1; i <= columns; i++) 
             row.addElement(result.getObject(i));     
            data.addElement(row);
        }	
	}
	
	public void AFFICHER_RESULTATS() throws SQLException
	{
        while (result.next()) 
        {
            Vector row = new Vector(resultMeta.getColumnCount());
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) 
             row.addElement(result.getObject(i));     
            data.addElement(row);
        }	  
	}
}
