
public class HeavySprite extends MobileSprite {
	private double vx;
	private double vy;
	public HeavySprite(double left, double top, int width, int height, String image, double x, double y) {
		super(left, top, width, height, image, x , y);
	}
	@Override
	public void step(World world) {
		super.step(world);
		this.setTop(this.getTop()-.1);
		
	}
	
}
