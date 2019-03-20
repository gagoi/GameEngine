package fr.game_engine.main;

import java.awt.Dimension;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Game extends Application {

	private Dimension defaultDimension = new Dimension(1280, 720); // Taille par défaut de la fenêtre.

	/*
	 * Ce sont les modes par défaut que le jeu peut avoir.
	 * 
	 * To-Do : - ajouter la possibilité d'avoir plus de modes possibles soit par le
	 * user soit directement dans la librairie (qu'est ce qui peut etre pertinant
	 * ?). - ajouter des events sur ces changements d'états.
	 */
	public static final int ERROR = -1;
	public static final int PAUSED = 0;
	public static final int RUN = 1;
	public static final int MENU = 2;
	protected final long DELAY_UPS;

	private Scene scene;

	/*
	 * Etat actuel du jeu.
	 */
	private Integer gameState = PAUSED;

	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu. Utilises les valeurs par défaut : 1280x720 et 3 Layers.
	 */
	public Game(int ups) {
		DELAY_UPS = 1000 / ups;
	}

	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu.
	 * 
	 * @param size : (width, height)
	 * 
	 * @param ups : nombre de mise à jour par seconde voulu
	 */
	public Game(String args[], int ups, final Dimension size) {
		this(ups);
		this.defaultDimension = size;
		launch(args);
	}

	/*
	 * Wrapper pour l'ajout d'éléments à la liste des éléments à dessiner.
	 */
	public void addElement(Node element) {
		((Group) this.getScene().getRoot()).getChildren().add(element);
	}

	/*
	 * Wrapper pour la suppression d'éléments de la liste des éléments à dessiner.
	 */
	public void removeElement(Node element) {
		((Group) this.getScene().getRoot()).getChildren().remove(element);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		scene = new Scene(root, defaultDimension.getWidth(), defaultDimension.getHeight());
		stage.setScene(scene);
		stage.show();

		AnimationTimer timer = new AnimationTimer() {
			long prevU = 0;

			@Override
			public void handle(long now) {
				if (prevU == 0) {
					prevU = now;
					return;
				} else {
					if (now - prevU >= DELAY_UPS) {
						update(now, prevU, now - prevU);
						prevU = now;
					}
				}
			}
		};
		timer.start();
		
	}

	protected abstract void update(long now, long old, long delay);
	
	public Scene getScene() {
		return scene;
	}

}
