import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyPath extends Path {
	private Point[] greedyPoints;

	public GreedyPath(String s) throws IOException {
		super(s);
		greedyPoints = new Point[getNumPoints()];
		greedyPoints[0] = super.getPoint(0);
		findPath();

	}

	private void findPath() {
		double minDist = 10000000;
		Point minDistP = null;
		for (int i = 0; i < getNumPoints() - 1; i++) {
			minDist = 1000000000;
			for (int x = 1; x < getNumPoints(); x++) {
				if (!super.getPoint(x).getVisited() && greedyPoints[i].getDistance(super.getPoint(x)) < minDist) {
					minDist = greedyPoints[i].getDistance(super.getPoint(x));	
					minDistP = super.getPoint(x);
				}
			}
			greedyPoints[i + 1] = minDistP;
			minDistP.setVisited(true);
			minDistP = null;
		}
	}

	@Override
	public Point getPoint(int i) {
		return greedyPoints[i];
	}

	@Override
	public double getDistance() {
		double dist = 0;
		for (int i = 0; i < greedyPoints.length - 1; i++) {
			dist += greedyPoints[i].getDistance(greedyPoints[i + 1]);
		}
		return dist; // replace

	}

	@Override
	public String toString() {
		String t = "";
		for (int i = 0; i < greedyPoints.length; i++) {
			t += greedyPoints[i] + " ";
		}

		return t;
	}

}
