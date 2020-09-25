/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
	/** Main method for testing.  Every class can have a main method in Java */
	public static void main(String[] args)
	{
		/*
		 * Comment out previously tested methods
		 */
		/*Picture beach = new Picture("beach.jpg");
		beach.explore(); //to show "before"
		beach.zeroBlue();
		beach.explore(); //to show "after"

		Picture blueMotorcycle = new Picture("blueMotorcycle.jpg");
		blueMotorcycle.explore(); //to show "before"
		blueMotorcycle.negate();
		blueMotorcycle.explore(); //to show "after"
	
		Picture water = new Picture("water.jpg");
		water.explore(); //to show "before"
		water.mirrorVertical();
		water.explore(); //to show "after"
			
		Picture beach = new Picture("beach.jpg");
		beach.explore(); //to show "before"
		beach.mirrorVerticalRightToLeft();
		beach.explore(); //to show "after"
		
		Picture beach = new Picture("beach.jpg");
		beach.explore(); //to show "before"
		beach.mirrorHorizontal();
		beach.explore(); //to show "after"
		
		Picture beach = new Picture("beach.jpg");
		beach.explore(); //to show "before"
		beach.mirrorHorizontalBottomToTop();
		beach.explore(); //to show "after"
		
		Picture temple = new Picture("temple.jpg");
		temple.explore(); //to show "before"
		temple.mirrorVerticalRoof();
		temple.explore(); //to show "after"
		
		Picture snowman = new Picture("snowman.jpg");
		snowman.explore(); //to show "before"
		snowman.mirrorArms();
		snowman.explore(); //to show "after"
		
		Picture seagull = new Picture("seagull.jpg");
		seagull.explore(); //to show "before"
		seagull.mirrorGull();
		seagull.explore(); //to show "after"
		
		Picture swan = new Picture("swan.jpg");
		swan.explore(); //to show "before"
		swan.edgeDetection(20);
		swan.explore(); //to show"after"
		*/
		Picture water = new Picture("water.jpg");
		water.explore(); //to show "before"
		water.greyscale();
		water.explore(); //to show "after"

		
		
		
		
		
		createCollage(); //LEAVE COMMENTED FOR NOW
	}
	
	/** Method to create a collage of several pictures */
	public static void createCollage()
	{
		Picture pic = new Picture(800, 800); //blank picture, 800 x 800 pixels
		
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		
		pic.copy(flower1,0,0);
		pic.copy(flower2,100,0);
		pic.copy(flower1,200,0);
		
		Picture flowerNoBlue = new Picture(flower2);
		
		flowerNoBlue.zeroBlue();
		pic.copy(flowerNoBlue,300,0);
		pic.copy(flower1,400,0);
		pic.copy(flower2,500,0);
		pic.mirrorVertical();
		
		pic.explore();
	}
}