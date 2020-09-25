import java.io.*;
import java.util.*;
public class Body 
{
	public static final double G = 6.67E-11;  //Newtons' gravitational constant

	private double x, y; //planet's x and y coordinate position
	private double xVelocity, yVelocity;
	private double mass;
	private double xNetForce, yNetForce; //net forces action on this planet
	private double xAccel, yAccel;

	private String image; //image of this planet (for drawing)

	/*
	 * TODO - student written methods here
	 */
	public Body(double xPos, double yPos, double xV, double yV, double m, String ima)
	{
		x = xPos;
		y = yPos;
		xVelocity = xV;
		yVelocity = yV;
		mass = m;
		image = ima;
		xNetForce = 0;
		yNetForce = 0;
		xAccel = 0;
		yAccel = 0;
	}

	private double getDistance(Body other)
	{
		return Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2));


	}

	private double getPairwiseForce(Body other)
	{
		double r = getDistance(other);
		return ((G * mass * other.mass)/(r * r));

	}

	private double getPairwiseForceX(Body other)
	{
		double forceX=(getPairwiseForce(other) * (other.x - x))/getDistance(other);
		return forceX;
	}

	private double getPairwiseForceY(Body other)
	{
		double forceY=(getPairwiseForce(other) * (other.y-y))/getDistance(other);
		return forceY;
	}

	/** calculates / sets the net force exerted on this body by all the (input) bodies */

	public void setNetForce(Body[] bodies)
	{
		xNetForce=0;
		yNetForce=0;
		for (int i=0; i < bodies.length; i++)
		{
			if (this == bodies[i]) //check if this object and object at i are same 
				continue;
			else
			{
				xNetForce += getPairwiseForceX(bodies[i]);
				yNetForce += getPairwiseForceY(bodies[i]);
			}
		}
	}

	/** updates this body's accel, vel, and position, given the time step */
	public void update(double dt)
	{
		//double xVeli = xVelocity;
		//double yVeli = yVelocity;
		xAccel = xNetForce / mass;
		yAccel = yNetForce / mass;
		xVelocity += xAccel * dt;
		yVelocity += yAccel * dt;
		x = x + dt * xVelocity;
		y = y + dt * yVelocity;
		
	}

	/** Draws the body using the StdDraw library file's drawing method */
	public void draw()
	{
		StdDraw.picture(x, y, image);
	}
}