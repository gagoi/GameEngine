package fr.game_engine.utils;

public class PointD implements IMovable {

	private double x, y;

	public PointD(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	@Override
	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
}
