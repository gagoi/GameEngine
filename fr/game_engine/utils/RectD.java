package fr.game_engine.utils;

public class RectD extends PolygonD {

	public RectD(double x, double y, double width, double height) {
		super(new PointD[] { new PointD(x, y), new PointD(x + width, y), new PointD(x + width, y + height),
				new PointD(x, y + width) });
	}
	
	@Override
	public void addPoint(PointD p) {
		//RIEN on ne peut pas ajouter de point.
	}
}
