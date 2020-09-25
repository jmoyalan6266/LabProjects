
public class MobileSprite extends Sprite {
	private double vx;
	private double vy;

	public MobileSprite(double left, double top, int width, int height, String image, double x, double y) {
		super(left, top, width, height, image);
		vx = x;
		vy = y;
	}

	@Override
	public void step(World world) {
		if (getLeft() < 0) {
			vx = Math.abs(vx);
		}
		if (getLeft() + getWidth() >= world.getWidth()) {
			vx = -Math.abs(vx);
		}
		if (getTop() < 0) {
			vy = Math.abs(vy);
		}
		if (getTop() + getHeight() >= world.getHeight()) {
			vy = -Math.abs(vy);
		}
		this.setLeft(this.getLeft()+vx);
		this.setTop(this.getTop()+vy);

	}
}
