package constraints;

import models.Variable;

public abstract class BinaryConstraint implements Constraint {
	
	private Variable X;
	private Variable Y;
	
	public BinaryConstraint(Variable X, Variable Y) {
		this.X=X;
		this.Y=Y;
	}
	
	public Variable getX() {
		return X;
	}

	public void setX(Variable x) {
		X = x;
	}

	public Variable getY() {
		return Y;
	}

	public void setY(Variable y) {
		Y = y;
	}
	
	@Override
	public boolean contains(Variable v) {
		if(X.equals(v) || Y.equals(v)) return true;
		return false;
	}

}
