package fr.game_engine.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class PolygonD implements IMovable {

	protected ArrayList<PointD> points;

	public PolygonD() {
		points = new ArrayList<PointD>(3);
	}

	public PolygonD(PointD[] points) {
		this();
		this.points.addAll(Arrays.asList(points));
	}

	public void addPoint(PointD p) {
		if (null != p && !points.contains(p))
			points.add(p);
	}

	public boolean contains(PointD p) {
		return false; // TODO
	}

	@Override
	final public void move(double dx, double dy) {
		for (PointD pointD : points) {
			pointD.move(dx, dy);
		}
	}
}
