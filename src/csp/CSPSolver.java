package csp;

import java.util.ArrayList;
import java.util.Hashtable;

import constraints.BinaryConstraint;
import constraints.Constraint;
import constraints.UnaryConstraint;
import models.Variable;

public class CSPSolver {
	
	private ArrayList<Variable> variables;
	private ArrayList<Constraint> constraints;
	
	public CSPSolver(ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		this.variables=variables;
		this.constraints=constraints;
	}
	
	public Hashtable<Variable, Integer> backtrackingSearch() {
		return recursiveBacktrackingSearch(new Hashtable<Variable, Integer>());
	}
	
	private Hashtable<Variable, Integer> recursiveBacktrackingSearch(Hashtable<Variable, Integer> assignment) {
		if (assignment.size()==variables.size()) return assignment;
		
		Variable first_unassigned=null;
		for(Variable var:variables) {
			if(!assignment.containsKey(var)) {
				first_unassigned=var;
				break;
			}
		}
		for(Integer value:first_unassigned.getDomain().getValues()) {
			Hashtable<Variable, Integer> new_assignment=new Hashtable<Variable, Integer>(assignment);
			new_assignment.put(first_unassigned, value);
			if (isConsistent(first_unassigned, new_assignment)){
				Hashtable<Variable, Integer> result=recursiveBacktrackingSearch(new_assignment);
				if(result!=null) return result;
			}
		}		
		return null;
	}
	
	private boolean isConsistent(Variable v, Hashtable<Variable, Integer> assignment) {
		for(Constraint c:constraints) {
			if(c.contains(v)) {
				if(c instanceof BinaryConstraint) {
					if(((BinaryConstraint) c).getX().equals(v)) {
						Variable other= ((BinaryConstraint) c).getY();
						if(assignment.containsKey(other))
							if(!c.check(new int[]{assignment.get(v), assignment.get(other)})) return false;
					}
					else {
						Variable other= ((BinaryConstraint) c).getX();
						if(assignment.containsKey(other))
							if(!c.check(new int[]{assignment.get(other), assignment.get(v)})) return false;
					}					
				}
				else if(c instanceof UnaryConstraint)
					if(!c.check(new int[]{assignment.get(v)})) return false;
			}
		}
		return true;		
	}
}
