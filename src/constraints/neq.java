package constraints;

import models.Variable;

public class neq extends BinaryConstraint {

	public neq(Variable X, Variable Y) {
		super(X,Y);
	}

	@Override
	public boolean check(int[] values) {
		// TODO Auto-generated method stub
		return values[0]!=values[1];
	}

}
