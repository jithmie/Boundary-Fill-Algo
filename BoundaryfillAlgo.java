import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoundaryfillAlgo extends JFrame implements MouseListener{
	Graphics g;
	int x1,y1,x2,y2;
	Color pixel[][]=new Color[800][800];// this line of code creates a virtual grid with a size of 800 by 800 pixels. 
	//Each pixel's color can be stored in this array. 
	
	BoundaryfillAlgo(){
		setTitle("BoundaryFill Algorithm");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(this);
		g=getGraphics();
	}
	public void mouseClicked(MouseEvent me){
		x1=me.getX();
		y1=me.getY();
		
		
		MidPointCircle(x1,y1,50);
		boundaryfill(x1,y1,Color.blue,Color.red);
	}
	public void mousePressed(MouseEvent me){
		
		
	}
	public void mouseReleased(MouseEvent me){
		
		
	}	 
	public void mouseEntered(MouseEvent me){}
	public void mouseMove(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}
	
	public void MidPointCircle(int xc,int yc,int r){
	int p=1-r;
	
	int x=0;
	int y=r;
	while(x<=y){
	PlotCircle(xc,yc,x,y);
	
	
	if(p<0)
	{
		p=p+(2*x)+3;
		
	}
	else{
		p=p+2*(x-y)+5;
		y=y-1;
	}
	x++;
	}
	
	}
	public void PlotCircle(int h,int k,int x,int y){
		//Uses the setPixel method to set the color of each pixel.
		setPixel(h+y,k-x,Color.red);
		setPixel(h+y,k+x,Color.red);
		setPixel(h-y,k-x,Color.red);
		setPixel(h-y,k+x,Color.red);
		setPixel(h+x,k-y,Color.red);
		setPixel(h+x,k+y,Color.red);
		setPixel(h-x,k-y,Color.red);
		setPixel(h-x,k+y,Color.red);
	}
	
	public Color getPixel(int x,int y)//Retrieves the color of a pixel at a specified (x, y) position in the pixel array.
	{
		return pixel[x][y];
	}
	public void setPixel(int x,int y,Color c)
	{
		g=getGraphics();
		g.setColor(c);//// Set the color for drawing
		pixel[x][y]=g.getColor();//// Store the color in the pixel array
		g.fillOval(x,y,2,2);//Draws a small filled oval at the specified position to visualize the pixel.
	}
	public void boundaryfill(int x,int y,Color fvalue,Color bvalue)
	{	//bordercolor				//avoid repeat fillingcolor
		if((getPixel(x,y)!=bvalue) && (getPixel(x,y)!=fvalue))
		{
			setPixel(x,y,fvalue);
			boundaryfill(x,y+1,fvalue,bvalue);
			boundaryfill(x,y-1,fvalue,bvalue);
			boundaryfill(x+1,y,fvalue,bvalue);
			boundaryfill(x-1,y,fvalue,bvalue);
		}
	}
	
	
	public static void main (String arg[])
	{
		BoundaryfillAlgo b1=new BoundaryfillAlgo();
	}
}
	