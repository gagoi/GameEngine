package fr.game_engine.tests;

import java.awt.Dimension;

import fr.game_engine.main.Game;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class Main {

	// Test pour l'interface graphique
	public static void main(String[] args) {
		System.out.println("Hello World");
		new Game(args, 60, new Dimension(1280, 720)) {

			@Override
			public void init() throws Exception {
				// TODO Auto-generated method stub
				super.init();
			}
			
			@Override
			protected void update(long now, long old, long delay) {
				
				Group game = new Group();
				Group menu = new Group();
				Node n = new Circle();
				game.getChildren().add(n);
				((Group) getScene().getRoot()).getChildren().clear();
				((Group) getScene().getRoot()).getChildren().add(menu);
				
				
				
				
			}			
		};
	}
}
