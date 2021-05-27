package constraints;

import models.Variable;

public class equnary extends UnaryConstraint{

	public equnary(Variable X, int value) {
		super(X, value);
	}

	@Override
	public boolean check(int[] values) {
		// TODO Auto-generated method stub
		return values[0]==value;
	}
	

}
