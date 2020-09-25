import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class NBodySimulation {
	private Body[] bodies; // stores all the bodies in the simulation
	private int numBodies; // number of bodies in this simulation
	private double uRadius; // radius of the universe
	private String fileName; // file providing the input

	public NBodySimulation(String file) throws IOException {
		// TODO
		fileName = file;
		File n = new File(fileName);
		Scanner in = new Scanner(n);
		numBodies = in.nextInt(); 
		bodies = new Body[numBodies];
		uRadius = in.nextDouble();
		for (int i = 0; i < numBodies; i++) {
			bodies[i] = new Body(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(),
					in.next());
		}

		initCanvas(); // don't move, should be the last line of the constructor
	}

	/** initialize the drawing canvas */
	private void initCanvas() {
		StdDraw.setScale(-uRadius, uRadius); // set canvas size / scale
		StdDraw.picture(0, 0, "starfield.jpg"); // paint background

		for (Body body : bodies)
			body.draw();
	}

	/**
	 * run the n-bodies simulation
	 * 
	 * @param T
	 *            total time to run the simulation, in seconds
	 * @param dt
	 *            time step, in seconds
	 */
	public void run(double T, double dt) {
		for (int i = 0; i < T; i += dt) {
			StdDraw.picture(0, 0, "starfield.jpg");
			for (int t = 0; t < numBodies; t++) {

				bodies[t].setNetForce(bodies);
				bodies[t].update(dt);

			}
			for (int t = 0; t < numBodies; t++) {
				bodies[t].draw();
			}
			StdDraw.show(10); // don't worry about the compiler warning
		}
	}
}