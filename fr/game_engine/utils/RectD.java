package fr.game_engine.utils;

public class RectD extends PolygonD {

	public RectD(double x, double y, double width, double height) {
		super(new PointD[] { new PointD(x, y), new PointD(x + width, y), new PointD(x + width, y + height),
				new PointD(x, y + width) });
	}

	@Override
	public void addPoint(PointD p) {
		// RIEN on ne peut pas ajouter de point.
	}

	public double getX() {
		return this.points.get(0).getX();
	}

	public double getY() {
		return this.points.get(0).getY();
	}

	public double getWidth() {
		return this.points.get(1).getX() - this.points.get(0).getX();
	}

	public double getHeight() {
		return this.points.get(2).getY() - this.points.get(0).getY();
	}
}
