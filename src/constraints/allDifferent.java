package constraints;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.Variable;

public class allDifferent implements Constraint {
	
	ArrayList<Variable> variables;
	
	public allDifferent(ArrayList<Variable> variables) {
		this.variables=variables;
	} 
	
	public ArrayList<Variable> getVariables() {
		return variables;
	}

	@Override
	public boolean check(int[] values) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		for(int var: values) {
			if(set.contains(Integer.valueOf(var))) return false;
			else set.add(Integer.valueOf(var));
		}
		return true;
	}
	
	public ArrayList<Constraint> toneq(){
		ArrayList<Constraint> constraints=new ArrayList<Constraint>();
		for(int i=0; i<variables.size(); i++) {
			for(int j=i+1; j<variables.size(); j++) {
				constraints.add(new neq(variables.get(i), variables.get(j)));
			}
		}
		return constraints;
	}

	@Override
	public boolean contains(Variable v) {
		for(Variable var:variables) {
			if(var.equals(v)) return true;
		}
		return false;
	}

}
