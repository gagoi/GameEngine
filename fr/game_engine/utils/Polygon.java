package fr.game_engine.utils;

import java.util.ArrayList;

/*
 * Interface minimaliste pour seulement utiliser un polygon comme un tableau de points
 * 
 * -> size()
 * -> get(index)
 */
public class Polygon {
	ArrayList<Double[]> vertices;
	
	public int getVertexCount() {
		return this.vertices.size();
	}
	
	public Double[] getVertex(int index) {
		return this.vertices.get(index);
	}
}
