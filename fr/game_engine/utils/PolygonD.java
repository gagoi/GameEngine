package fr.game_engine.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class PolygonD {

	private ArrayList<PointD> points;

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
}
