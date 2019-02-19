package fr.game_engine.map;

import javax.swing.JFrame;

/*
 * MapCreator -> Fenetre pour créer des levels 2D
 * 
 * Objectif: ne pas a avoir a créer les levels par un éditeur d'image
 * -> créer les levels visuellement en placant des points représentant les polygones du niveau
 * 
 * Implique:
 * 		- une gestion de "caméra" pour se bouger dans le niveau (+ zoom/dezoom)
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
