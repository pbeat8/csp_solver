package main;

import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;

import csp.CSPSolver;
import models.Variable;
import problems.EinsteinProblem;
import problems.MapColoring;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int variables=10;
		int colors=4;
		runMapColoring(variables, colors);
		runEinstein();
		
	}
	
	public static void runMapColoring(int variables, int colors) {
		System.out.println("*** Map coloring problem ***");
		MapColoring mc=new MapColoring(variables, colors); 
		CSPSolver map_solver=new CSPSolver(mc.getVariables(), mc.getConstraints());
		Hashtable<Variable, Integer> result=map_solver.backtrackingSearch();
		if(result==null) {
			System.out.println("No solution was found!");
		}
		else {
			System.out.println("Solution: ");
			Set<Variable> keys = result.keySet();
			Iterator<Variable> itr = keys.iterator();
		    while (itr.hasNext()) { 
		    	Variable v = itr.next();
		    	int value=result.get(v);
		    	String colour="";
		    	switch (value){
		    		case 1: colour="red"; break;
		    		case 2: colour="blue"; break;
		    		case 3: colour="green"; break;
		    		case 4: colour="yellow"; break;
		    	}
		    	System.out.println(v.toString()+" : "+colour);
		    }
		    mc.printSolution(result);
		}
	}
	
	public static void runEinstein() {
		System.out.println("***** Einstein's / Zebra puzzle *****");
		EinsteinProblem ep=new EinsteinProblem(); 
		CSPSolver einstein_solver=new CSPSolver(ep.getVariables(), ep.getConstraints());
		Hashtable<Variable, Integer> result=einstein_solver.backtrackingSearch();
		if(result==null) {
			System.out.println("No solution was found!");
		}
		else {
			System.out.println("Solution: ");
			Set<Variable> keys = result.keySet();
			for(int i=1; i<=5; i++) {
				Iterator<Variable> itr1 = keys.iterator();
				System.out.print("House "+i+": ");
			    while (itr1.hasNext()) { 
			    	Variable v = itr1.next();
			    	if(result.get(v)==i) System.out.print(v.toString()+", ");
			    } 
			    System.out.println();
			}
		}
	}

}
