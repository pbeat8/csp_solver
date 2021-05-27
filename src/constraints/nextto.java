package constraints;

import models.Variable;

public class nextto extends BinaryConstraint {

	public nextto(Variable X, Variable Y) {
		super(X,Y);
	}

	@Override
	public boolean check(int[] values) {
		// TODO Auto-generated method stub
		return Math.abs(values[0]-values[1])==1;
	}

}
