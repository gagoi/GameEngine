package fr.game_engine.map;

import java.awt.geom.Point2D;
import java.util.HashMap;
import fr.game_engine.utils.Polygon;

/*
 * Classe qui contiendra les données d'un niveau du jeu
 * 
 * Basiquement l'interface ressemblera à
 * + load (file)
 * + save ()
 * + getMap () -> renvoie une HashMap avec <Polygon, position> ou <Tableau de points pour polygon, position>
 * + getPlayerPosition ()
 * (et possiblement getItemsPosition, ...)
 * 
 * En consequence :
 * + addPolygon (Polygon/Tableau de points, position) -> rajoute un polygone dans la map
 * + changePlayerPosition ()
 * 
 * -> TODO: Polygon
 */
public class Map {
	HashMap<Polygon, Point2D> map;
	Point2D playerPosition;
	
	public Map() {
		
	}
	
	public void addPolygon(Polygon p, Point2D position) {
		this.map.put(p, position);
	}
	
	public void changePlayerPosition(Point2D newPosition) {
		this.playerPosition.setLocation(newPosition);
	}
	
	public HashMap<Polygon, Point2D> getMap() {
		return this.map;
	}
	
	public Point2D getPlayerPosition() {
		return this.playerPosition;
	}
}

















