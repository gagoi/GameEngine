package fr.game_engine.map;

import java.util.HashMap;
import java.util.Vector;

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
	HashMap<Integer[], Vector<Double>> map;
	Vector<Double> playerPosition;
	
	public Map() {
		
	}
	
	public HashMap<Integer[],Vector<Double>> getMap() {
		return map;
	}
	
	public Vector<Double> getPlayerPosition() {
		return playerPosition;
	}
}

















