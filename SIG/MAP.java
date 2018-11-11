package SIG;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MAP extends Frame {
	
	public FORM F = null;
	public Image Map = null,Hotel = null,Restaurant = null,ME = null;
	public int P_U_X = 480,P_U_Y = 310;
	private static final long serialVersionUID = 1L;

	public MAP() throws HeadlessException {
		super();
		initialize();
	}

	public MAP(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public MAP(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public MAP(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}
	 public void paint(Graphics g)
	 {
		 super.paint(g);
		 Graphics2D g2d = (Graphics2D)g;
		 g.drawImage(Map, 0, 0, this.getWidth(), this.getHeight(), this);
		 g.drawImage(ME,P_U_X,P_U_Y, ME.getWidth(null), ME.getHeight(null), this);
		 
		 for(int i=0;i<F.HXa.size();i++)
		 {
		  g.drawImage(Hotel, F.HXa.elementAt(i), F.HYa.elementAt(i), Hotel.getWidth(null), Hotel.getHeight(null), this);
		  g.drawImage(Restaurant, F.RXa.elementAt(i), F.RYa.elementAt(i), Restaurant.getWidth(null), Restaurant.getHeight(null), this);
		 }

         g2d.setColor(Color.RED);
         for(int i = 0;i<F.RXa.size();i++)
          g.drawLine(F.RXa.elementAt(i)+((int) Restaurant.getWidth(null)/2),F.RYa.elementAt(i)+((int) Restaurant.getHeight(null)/2), P_U_X+((int) ME.getWidth(null)/2), P_U_Y+((int) ME.getHeight(null)/2));

         g2d.setColor(Color.BLUE);
          for(int i = 0;i<F.HXa.size();i++)
           g.drawLine(F.HXa.elementAt(i)+((int) Hotel.getWidth(null)/2),F.HYa.elementAt(i)+((int) Hotel.getHeight(null)/2), P_U_X+((int) ME.getWidth(null)/2), P_U_Y+((int) ME.getHeight(null)/2));
	 }
	 private void initialize() 
	 {
		ImageIcon img = new ImageIcon(this.getClass().getResource("Biskra.JPG"));
		Map = img.getImage();
        img = new ImageIcon(this.getClass().getResource("hotel.jpeg"));
        Hotel = img.getImage();
        img = new ImageIcon(this.getClass().getResource("Restaurant.JPG"));
        Restaurant = img.getImage();
        img = new ImageIcon(this.getClass().getResource("redball.gif"));
        ME = img.getImage();
        
        P_U_X = (int)Map.getWidth(null)/2;
  	    P_U_Y = (int)Map.getHeight(null)/2;
        
        this.setLayout(null);
		this.setSize(Map.getWidth(null), Map.getHeight(null));
		this.setResizable(false);
		this.setTitle("Map Biskra :");
		this.setVisible(true);
		this.addMouseListener(new java.awt.event.MouseAdapter(){
		 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
    	  P_U_X = e.getX();
    	  P_U_Y = e.getY();
    	  System.out.println("X = "+P_U_X+" Y = "+P_U_Y);
    	  repaint();
    	 }
		});
	 }
} 