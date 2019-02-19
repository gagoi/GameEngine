package fr.game_engine.utils;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
 * Interface minimaliste pour seulement utiliser un polygon comme un tableau de points
 * 
 * -> size()
 * -> get(index)
 */
public class Polygon {
	ArrayList<Point2D> vertices;
	
	public int getVertexCount() {
		return this.vertices.size();
	}
	
	public Point2D getVertex(int index) {
		return this.vertices.get(index);
	}
}
