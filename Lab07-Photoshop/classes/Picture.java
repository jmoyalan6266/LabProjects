import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				/*
				 * pixelObj is a reference to a Pixel object
				 * 
				 * explore the Pixel class to see what methods it has
				 */
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed from to the specified rowStart and colStart in the
	 * current picture
	 * 
	 * @param from
	 *            the picture to copy from
	 * @param rowStart
	 *            the start row to copy to
	 * @param colStart
	 *            the start col to copy to
	 */
	public void copy(Picture from, int rowStart, int colStart) {
		Pixel[][] toPic = this.getPixels2D();
		Pixel[][] fromPic = from.getPixels2D();

		for (int row = 0; row < fromPic.length ; row++) {

			for (int col = 0; col < fromPic[row].length; col++) {
				toPic[rowStart + row][colStart + col].setColor(fromPic[row][col].getColor());
			}

		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}

	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());

			}
		}

	}

	public void greyscale() {
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				double r = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
				int avg = (int) (r / 2);
				pixelObj.setRed(avg);
				pixelObj.setGreen(avg);
				pixelObj.setBlue(avg);
			}
		}

	}

	public void showFish() {
		Pixel[][] pixels = this.getPixels2D();

		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getRed() < 20) {
					double r = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
					int avg = (int) (r / 2);
					pixelObj.setRed(avg);
					pixelObj.setGreen(avg);
					pixelObj.setBlue(avg);
				}
			}
		}

	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int row = 0; row < pixels.length; row++) {
			for (int col = pixels[0].length - 1; col > width / 2; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel topPixel = null;
		Pixel bottomPixel = null;

		int length = pixels.length;

		for (int row = 0; row < length / 2; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBottomToTop() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel topPixel = null;
		Pixel bottomPixel = null;

		int length = pixels.length;

		for (int row = length - 1; row > length / 2; row--) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRoof() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int row = 0; row < 170; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel topPixel = null;
		Pixel bottomPixel = null;

		int length = pixels.length;

		for (int row = 163; row < 196; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[length + 89 - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	public void mirrorGull()
	{
		Pixel[][] pixels = this.getPixels2D();

		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int row = 235; row < 330 ; row++) {
			for (int col = 230; col < 350; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width + 50 - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	public void edgeDetection(int edgeDist)
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel centPixel = null;
		Pixel rightPixel = null;

		Pixel botPixel = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0 ; col < pixels[row].length - 1 ; col++) {
				centPixel = pixels[row][col];
				rightPixel = pixels[row][col+1];
				botPixel =  pixels[row + 1][col];
				if ((centPixel.colorDistance(rightPixel.getColor()) > edgeDist)||(centPixel.colorDistance(botPixel.getColor()) > edgeDist))
				{
					centPixel.setColor(Color.black);
				}
				else
				{
					centPixel.setColor(Color.white);
				}
			}
	


		}
	}

}

// this } is the end of class Picture, put all new methods before this
