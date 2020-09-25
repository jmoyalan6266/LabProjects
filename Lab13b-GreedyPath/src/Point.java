public class Point {
	private double x, y;
	private boolean visited;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		visited = false;
	}

	/** get the Euclidean distance between two points */
	public double getDistance(Point other) {
		double Xsq = Math.pow(other.getX() - this.getX(), 2);
		double Ysq = Math.pow(other.getY() - this.getY(), 2);
		return Math.sqrt(Xsq + Ysq);
		
	}
	public void setVisited(boolean t)
	{
		visited = t;
	}
	public boolean getVisited()
	{
		return visited;
	}

	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
