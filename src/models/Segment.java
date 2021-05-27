package models;

public class Segment {
	
	private Point start;
	private Point end;
	
	public Segment(Point sstart, Point send) {
		start=sstart; 
		end=send;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public boolean containsPoint(Point point) {
		if((point.getY()-this.getStart().getY())*(this.getEnd().getX()-this.getStart().getX())
				- (this.getEnd().getY()-this.getStart().getY())*(point.getX()-this.getStart().getX())==0) return true;
		return false;
	}
	
	public boolean containsPoint(float x, float y) {
		if((y-this.getStart().getY())*(this.getEnd().getX()-this.getStart().getX())
				- (this.getEnd().getY()-this.getStart().getY())*(x-this.getStart().getX())==0) return true;
		return false;
	}
	
	public boolean isCrossing(Segment other) {
	    float s1_x, s1_y, s2_x, s2_y;
	    s1_x = this.getEnd().getX() - this.getStart().getX();     
	    s1_y = this.getEnd().getY() - this.getStart().getY();
	    s2_x = other.getEnd().getX() - other.getStart().getX();     
	    s2_y = other.getEnd().getY() - other.getStart().getY();

	    float s, t;
	    s = (-s1_y * (this.getStart().getX() - other.getStart().getX()) + s1_x * 
	    		(this.getStart().getY() - other.getStart().getY())) / (-s2_x * s1_y + s1_x * s2_y);
	    t = ( s2_x * (this.getStart().getY() - other.getStart().getY()) - s2_y * 
	    		(this.getStart().getX() - other.getStart().getX())) / (-s2_x * s1_y + s1_x * s2_y);

	    if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
	    	float i_x = this.getStart().getX() + (t * s1_x);
	        float i_y = this.getStart().getY() + (t * s1_y);
	        if (Math.min(this.getStart().getX(), this.getEnd().getX())<i_x
	        		&& i_x<Math.max(this.getStart().getX(), this.getEnd().getX())
	        		&& Math.min(this.getStart().getY(), this.getEnd().getY())<i_y
	        		&& i_y<Math.max(this.getStart().getY(), this.getEnd().getY())
	        		&& Math.min(other.getStart().getX(), other.getEnd().getX())<i_x
	        		&& i_x<Math.max(other.getStart().getX(), other.getEnd().getX())
	        		&& Math.min(other.getStart().getY(), other.getEnd().getY())<i_y
	        		&& i_y<Math.max(other.getStart().getY(), other.getEnd().getY()))
	        	return true;
	    }

	    return false;
	}

	@Override
	public String toString() {
		return "Segment : "+start.toString()+end.toString();
	}
	
	@Override
	public Segment clone() {
        return new Segment(this.getStart().clone(), this.getEnd().clone());
	}
	
	@Override
	 public boolean equals(Object o) {  
       if (o == this) { 
           return true; 
       } 
       if (!(o instanceof Segment)) { 
           return false; 
       } 
       Segment s = (Segment) o;  
       return (this.start.equals(s.start) && this.end.equals(s.end)) || (this.start.equals(s.end) && this.end.equals(s.start)); 
   } 
	

}
