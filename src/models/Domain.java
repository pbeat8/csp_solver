package models;

import java.util.ArrayList;

public class Domain {
	
	private ArrayList<Integer> values;
	
	public Domain(ArrayList<Integer> values) {
		this.values=values;
	}

	public ArrayList<Integer> getValues() {
		return values;
	}
	
	public int getSize() {
		return values.size();
	}
	
	public int getValue(int index) {
		return values.get(index);
	}
	
	public void removeValue(int value) {
		values.remove(Integer.valueOf(value));
	}
	
	public void removeValue(Integer value) {
		values.remove(value);
	}

	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}
	
	@Override
	 public boolean equals(Object o) {  
      if (o == this) { 
          return true; 
      } 
      if (!(o instanceof Point)) { 
          return false; 
      } 
      Domain d = (Domain) o;  
      return this.values.equals(d.values); 
  } 

}
