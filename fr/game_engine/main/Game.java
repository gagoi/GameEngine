package fr.game_engine.main;
import java.awt.Dimension;

import fr.game_engine.graphics.GameScene;
import fr.game_engine.graphics.IRenderable;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application{
	 
	
	private Dimension defaultDimension = new Dimension(1280, 720); // Taille par défaut de la fenêtre.
	private int defaultLayer = 3; // Nombrde de plan par défaut du rendu.

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

	/*
	 * Etat actuel du jeu.
	 */
	private Integer gameState = PAUSED;

	/*
	 * Temps entre deux mises à jours.
	 */
	private int framesFrequency = 1000 / 60;
	
	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu. Utilises les valeurs par défaut : 1280x720 et 3 Layers.
	 */
	public Game() {
	}

	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu.
	 * @param size : (width, height)
	 * @param nbLayers : nombre de plans
	 * @param fps : nombre d'images par seconde voulu
	 */
	public Game(String args[], final Dimension size, final int nbLayers, final int fps) {
		this();
		this.defaultDimension = size;
		this.defaultLayer = nbLayers;
		this.framesFrequency = 1000 / fps;
		launch(args);
	}

	/*
	 * Wrapper pour l'ajout d'éléments à la liste des éléments à dessiner.
	 */
	public void addIRenderable(IRenderable iRenderable) {
	}
	
	/*
	 * Wrapper pour la suppression d'éléments de la liste des éléments à dessiner.
	 */
	public void removeIRenderable(IRenderable iRenderable) {
	}

	@Override
	public void start(Stage stage) throws Exception {
		 Group root = new Group();

         stage.setScene(new GameScene(root, defaultDimension.getWidth(), defaultDimension.getHeight()));
         stage.show();
	}

}
