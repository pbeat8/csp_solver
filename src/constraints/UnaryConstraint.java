package constraints;

import models.Variable;

public abstract class UnaryConstraint implements Constraint {

	private Variable X;
	protected int value;
	
	public UnaryConstraint(Variable X, int value) {
		this.X=X;
		this.value=value;
	}

	public Variable getX() {
		return X;
	}

	public void setX(Variable x) {
		X = x;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean contains(Variable v) {
		if(X.equals(v)) return true;
		return false;
	}

}
