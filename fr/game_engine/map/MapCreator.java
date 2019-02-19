package fr.game_engine.map;

import javax.swing.JFrame;

/*
 * MapCreator -> Fenetre pour cr�er des levels 2D
 * 
 * Objectif: ne pas a avoir a cr�er les levels par un �diteur d'image
 * -> cr�er les levels visuellement en placant des points repr�sentant les polygones du niveau
 * 
 * Implique:
 * 		- une gestion de "cam�ra" pour se bouger dans le niveau (+ zoom/dezoom)
 * 		- gestion de clics
 * 		- ...
 */
public class MapCreator extends JFrame {

	public MapCreator() {
		this.setTitle("MapCreator");
	    this.setSize(400, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    this.setVisible(true);
	}

}
