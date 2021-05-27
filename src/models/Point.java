package models;

public class Point {
	
	private int x;
	private int y;
	
	public Point (int px, int py) {
		x=px;
		y=py;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	 @Override
	 public boolean equals(Object o) {  
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Point)) { 
            return false; 
        } 
        Point p = (Point) o;  
        return Integer.compare(x, p.x) == 0
                && Integer.compare(y, p.y) == 0; 
    } 
	
	@Override
	public String toString() {
		return String.format("%d;%d;", x, y);
	}
	
	@Override
	public Point clone() {
        return new Point(this.getX(), this.getY());
	}

}
