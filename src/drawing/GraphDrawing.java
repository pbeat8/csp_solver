package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import models.Point;
import models.Segment;

public class GraphDrawing extends JFrame {
	
	private static final long serialVersionUID = 1L;
	ArrayList<Point> points;
	ArrayList<Segment> lines;
	Hashtable<Integer, String> colours;
	
	public GraphDrawing(ArrayList<Point> points,	ArrayList<Segment> lines, Hashtable<Integer, String> colours) { 
        super("Map colouring graph");
		this.points=points;
		this.lines=lines;
		this.colours=colours;
    	 
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        for(Segment s:lines) {
        	g2d.drawLine(s.getStart().getX(), s.getStart().getY(), s.getEnd().getX(), s.getEnd().getY());
        }
        
        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(10f));
        for(Point p:points) {
        	g2d.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
        }
 
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        if(colours!=null) drawLinesColour(g);
        else drawLines(g);
    }
 
    public static void execute(ArrayList<Point> points,	ArrayList<Segment> lines) { //old main
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphDrawing(points, lines, null).setVisible(true);
            }
        });
    }
    
    void drawLinesColour(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        for(Segment s:lines) {
        	g2d.drawLine(s.getStart().getX(), s.getStart().getY(), s.getEnd().getX(), s.getEnd().getY());
        }
        
        g2d.setStroke(new BasicStroke(10f));
        for(Point p:points) {
        	int index=points.indexOf(p);
        	switch (colours.get(Integer.valueOf(index))){
	    		case "red":		g2d.setPaint(Color.red); break;
	    		case "blue": 	g2d.setPaint(Color.blue); break;
	    		case "green": 	g2d.setPaint(Color.green); break;
	    		case "yellow": 	g2d.setPaint(Color.yellow); break;
	    		case "pink": 	g2d.setPaint(Color.pink); break;
	    		default: 		g2d.setPaint(Color.black);
	    	}
        	g2d.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
        }
 
    }
 
    public static void executeWithColour(ArrayList<Point> points,	ArrayList<Segment> lines, Hashtable<Integer, String> colours) { //old main
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphDrawing(points, lines, colours).setVisible(true);
            }
        });
    }

}
