import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World
{
	public static void main(String[] args)
	{
		Display display = new Display(500, 500);
		display.run();
	}

	private List<Sprite> sprites;
	private int width;
	private int height;

	/** make a World with a default size 500 x 500 */
	public World()
	{
		this(500, 500);
		
	
	}

	public World(int width, int height)
	{
		this.width = width;
		this.height = height;

		this.sprites = new ArrayList<>();
		Sprite a = new StationarySprite (50, 50, 5, 5, "square.png");
		Sprite b = new StationarySprite (200.0, 200.0, 100, 100, "square.png");
		sprites.add(a);
		sprites.add(b);
		Sprite c = new MobileSprite (100, 100, 50, 50, "circle.png", 20, 10);
		Sprite d = new MobileSprite (150, 150, 50, 50, "circle.png", 10, 20);
		sprites.add(c);
		sprites.add(d);
		Sprite e = new HeavySprite (200, 100, 50, 50, "triangle.png", 30, 2);
		Sprite f = new HeavySprite (250, 300, 50, 50, "triangle.png", 10, 1);
		sprites.add(e);
		sprites.add(f);
		Sprite g = new DyingSprite (120, 100, 50, 50, "triangle.png", 30, 2);
		Sprite h = new DyingSprite (10, 300, 50, 50, "triangle.png", 10, 1);
		sprites.add(g);
		sprites.add(h);
		

		/*
		 * Student code here
		 */
	}

	public void stepAll()
	{
		for (int i = 0; i < sprites.size(); i++)
		{
			Sprite s = sprites.get(i);

			s.step(this);
			if (!s.getAlive())
			{
				sprites.remove(s);
			}
		}
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getNumSprites()
	{
		return sprites.size();
	}

	public Sprite getSprite(int index)
	{
		return sprites.get(index);
	}

	public void mouseClicked(int x, int y)
	{
		System.out.println("mouseClicked:  " + x + ", " + y);
	}

	/**
	 * the display instructs the World (which contains all the Sprites)
	 * which key has been pressed
	 */
	public void keyPressed(int key)
	{
		System.out.println("key pressed: " + key);
	}

	public void keyReleased(int key)
	{
		System.out.println("key released: " + key);
	}

	public String getTitle()
	{
		return "World";
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		for (int i = 0; i < sprites.size(); i++)
		{
			Sprite sprite = sprites.get(i);
			g.drawImage(Display.getImage(sprite.getImage()),
					(int)sprite.getLeft(), (int)sprite.getTop(),
					sprite.getWidth(), sprite.getHeight(), null);
		}
	}
}
