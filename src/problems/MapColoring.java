package problems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import constraints.Constraint;
import constraints.neq;
import drawing.GraphDrawing;
import models.Domain;
import models.Point;
import models.Segment;
import models.Variable;

public class MapColoring {
	
	private static int offset=125;
	
	private int n; //number of points on the map
	private int colours; //number of colors
	private final int xsize=400;
	private final int ysize=400;
	ArrayList<Point> points;
	ArrayList<Segment> lines;
	ArrayList<Variable> variables;
	ArrayList<Constraint> constraints;
	
	public MapColoring(int n, int colours) {
		this.n=n;
		this.colours=colours;
		init();
	}
	
	public ArrayList<Variable> getVariables(){
		return variables;
	}
	
	public ArrayList<Constraint> getConstraints(){
		return constraints;
	}
	
	private void init() {
		Random gen=new Random();
		points=new ArrayList<Point>();
		lines=new ArrayList<Segment>();
		while(points.size()<n) {
			Point p=new Point(gen.nextInt(xsize)+offset, gen.nextInt(ysize)+offset);
			if(!points.contains(p)) {
				points.add(p);
			}
		}
		ArrayList<Integer> possible_indexes=new ArrayList<Integer>();
		for(int i=0; i<points.size(); i++) possible_indexes.add(Integer.valueOf(i));
		while(possible_indexes.size()>0) {
			int index=possible_indexes.get(gen.nextInt(possible_indexes.size()));
			Point a=points.get(index);
			Point b=findClosest(a);
			if(b==null) possible_indexes.remove(Integer.valueOf(index));
			else lines.add(new Segment(a,b));
		}
		
		GraphDrawing.execute(points, lines);
		generateVariablesAndConstraints();
		
	}
	
	public void printSolution(Hashtable<Variable, Integer> assignment) {
		Hashtable<Integer, String> colours=new Hashtable<>();
		for(Variable v:variables) {
			String colour = "";
			int value=assignment.get(v);
			switch (value){
	    		case 1: colour="red"; break;
	    		case 2: colour="blue"; break;
	    		case 3: colour="green"; break;
	    		case 4: colour="yellow"; break;
	    	}
			colours.put(variables.indexOf(v), colour);
		}
		GraphDrawing.executeWithColour(points, lines, colours);
	}
	
	private void generateVariablesAndConstraints() {
		variables= new ArrayList<Variable>();
		constraints= new ArrayList<Constraint>();
		for(int i=0; i<points.size(); i++) {
			ArrayList<Integer> domain=new ArrayList<Integer>();
			for(int c=1; c<=colours; c++) domain.add(Integer.valueOf(c));
			System.out.println("Point "+i+": "+points.get(i).toString());
			variables.add(new Variable(new Domain(domain), "Point "+i));
		}
		for(int i=0; i<lines.size(); i++) {
			int index_a=points.indexOf(lines.get(i).getStart());
			int index_b=points.indexOf(lines.get(i).getEnd());
			constraints.add(new neq(variables.get(index_a), variables.get(index_b)));
			System.out.println("Constraint: Point "+index_a+" != Point "+index_b);
		}
	}
	
	private Point findClosest(Point p) {
		double min_distance=xsize*ysize;
		int min_index=-1;
		for(int i=0; i<points.size(); i++) {
			if(points.get(i)!=p) {
				double distance=Math.sqrt(Math.pow(p.getX()-points.get(i).getX(), 2)
					+Math.pow(p.getY()-points.get(i).getY(), 2));
				if(distance<min_distance) {
					Segment temp=new Segment(p, points.get(i));
					if(!lines.contains(temp) && !crossesAny(temp)) {
						min_distance=distance;
						min_index=i;
					}
				}
			}
		}		
		if(min_index==-1) return null;
		return points.get(min_index);
	}
	
	private boolean crossesAny(Segment a) {
		for(Segment b: lines) {
			if(a.isCrossing(b)) {
				return true;
			}
		}
		return false;
	}

}
