package constraints;

import models.Variable;

public class lt extends BinaryConstraint {

	public lt(Variable X, Variable Y) {
		super(X,Y);
	}

	@Override
	public boolean check(int[] values) {
		// TODO Auto-generated method stub
		return values[0]<values[1];
	}

}
