import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path {
	private Point[] points;
	private double minX, minY; // min X and Y values, for setting canvas scale
	private double maxX, maxY; // maxes

	/** construct a path from a given file */
	public Path(String fileName) throws IOException {
		maxX = -1000000;
		maxY = -1000000;
		minX = 10000000;
		minY = 10000000;
		Scanner in = new Scanner(new File(fileName));
		int length = in.nextInt();
		points = new Point[length];
		for (int i = 0; i < length ; i++) {
			
			double x = in.nextDouble();
			double y = in.nextDouble();
			points[i] = new Point(x, y);
			if (y < minY) {
				minY = y;
			}
			if (x < minX) {
				minX = x;
			}
			if (y > maxY) {
				maxY = y;
			}
			if (x > maxX) {
				maxX = x;
			}
		}
	}

	/**
	 * returns the distance traveled going point to point, in order given in
	 * file
	 */
	public double getDistance() {
		double dist = 0;
		for (int i = 0; i < points.length - 1 ; i++)
		{
			dist += points[i].getDistance(points[i + 1]);
		}
		return dist; // replace
	}
	public int getNumPoints()
	{
		return points.length;
	}
	public Point getPoint(int i)
	{
		return points[i];
	}
	public double getMaxX()
	{
		return maxX;
	}
	public double getMaxY()
	{
		return maxY;
	}
	public double getMinX()
	{
		return minX;
	}
	public double getMinY()
	{
		return minY;
	}	

	@Override
	public String toString() {
		String t = "";
		for (int i = 0; i < points.length; i++ )
		{
			t += points[i]+ " "; 
		}

		return t;
	}
}
