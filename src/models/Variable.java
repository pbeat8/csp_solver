package models;

public class Variable {
	
	private Domain domain;
	private String identifier;
	
	public Variable(Domain domain, String identifier) {
		this.domain=domain;
		this.identifier=identifier;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public String toString() {
		return this.getIdentifier();
	}
	
	@Override
	 public boolean equals(Object o) {  
       if (o == this) { 
           return true; 
       } 
       if (!(o instanceof Point)) { 
           return false; 
       } 
       Variable v = (Variable) o;
       return this.identifier.equals(v.identifier);
   } 

}
