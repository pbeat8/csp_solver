package constraints;

import models.Variable;

public interface Constraint {
	public boolean check (int[] values);
	public boolean contains(Variable v);

}
