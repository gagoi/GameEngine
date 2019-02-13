package fr.game_engine.map;

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
	HashMap<Polygon, Double[]> map;
	Double[] playerPosition;
	
	public Map() {
		
	}
	
	public void addPolygon(Polygon p, Double[] position) {
		this.map.put(p, position);
	}
	
	public void changePlayerPosition(Double[] newPosition) {
		this.playerPosition = newPosition;
	}
	
	public HashMap<Polygon, Double[]> getMap() {
		return this.map;
	}
	
	public Double[] getPlayerPosition() {
		return this.playerPosition;
	}
}

















