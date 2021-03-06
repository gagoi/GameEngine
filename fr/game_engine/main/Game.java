package fr.game_engine.main;

import java.awt.Dimension;

import fr.game_engine.graphics.IRenderable;
import fr.game_engine.graphics.Window;

public class Game implements Runnable {
	
	
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
	 * Permet de savoir si le jeu est en fonctionnement ou non. Il passe à true au
	 * lancement du jeu et à false dès que la fonction stop est appelée.
	 */
	private boolean isRunning;
	
	/*
	 * Fenêtre contenant le moteur de rendu du jeu.
	 */
	private Window display;
	
	/*
	 * Temps entre deux mises à jours.
	 */
	private int framesFrequency = 1000 / 60;
	
	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu. Utilises les valeurs par défaut : 1280x720 et 3 Layers.
	 */
	public Game() {
		new Thread(this, "Main thread").start();
		waitForReady();
	}

	/*
	 * Constructeur du jeu. Ne modifier que pour ajouter des choses à faire avant le
	 * chargement du jeu.
	 * @param size : (width, height)
	 * @param nbLayers : nombre de plans
	 * @param fps : nombre d'images par seconde voulu
	 */
	public Game(final Dimension size, final int nbLayers, final int fps) {
		this();
		this.defaultDimension = size;
		this.defaultLayer = nbLayers;
		this.framesFrequency = 1000 / fps;
	}
	

	/*
	 * Fonction d'initialisation du jeu. Elle est appelée automatiquement lorsque
	 * l'on fait game.start(), où game est une variable de type Game.
	 */
	private void init() {
		isRunning = true;
		display = new Window(defaultLayer, defaultDimension);
		display.setVisible(true);
		
	}

	@Override
	public void run() {
		long lastUpdate = System.currentTimeMillis();
		
		init();
		while (isRunning) { // Tant qu'on n'a pas quitté le jeu.
			switch (gameState) { // En fonction de l'état dans lequel est le jeu.
			case PAUSED: // Si il est en pause.
				try { // On essaie de faire une pause pour limiter l'utilisation CPU.
					Thread.sleep(100);
				} catch (InterruptedException e) { // Si le thread a été interrompu (arrété) extérieurement.
					e.printStackTrace(); // On affiche l'erreur.
				}
				break;
			case RUN: // Le jeu fonctionne normalement.
				// To-Do : Faire des trucs.
				if (System.currentTimeMillis() - lastUpdate >= framesFrequency) {
					//To-Do : Faire des updates
					display.repaint();
					lastUpdate = System.currentTimeMillis();
				} else {
					try {
						Thread.sleep(System.currentTimeMillis() - lastUpdate  );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case MENU: // Le jeu est dans un menu.
				// To-Do : Faire des trucs.
				break;
			case ERROR: // Il y a eu une error.
				Thread.getAllStackTraces().forEach((t, s) -> { // On affiche la pile d'appel de chaque Thread.
					System.err.println("Trace thread : " + t + "\n" + s);
				});
				break;
			default: // Si le mode n'est pas reconnu, on passe en erreur.
				gameState = ERROR;
				break;
			}
		}
	}

	/*
	 * Fonction d'arrêt définitif du jeu.
	 */
	public void stop() {
		isRunning = false;
		// To-Do : Ajouter le nécessaire d'arret du jeu (sauvegarde ?).
	}

	/*
	 * Fontion de mise en pause du jeu (la pause peut être reprise). Il faut
	 * l'utiliser pour les menus.
	 */
	public void pause() {
		gameState = PAUSED;
	}

	/*
	 * Fonction de reprise du jeu après une pause.
	 */
	public void resume() {
		gameState = RUN;
	}
	
	/*
	 * Wrapper pour l'ajout d'éléments à la liste des éléments à dessiner.
	 */
	public void addIRenderable(IRenderable iRenderable) {
		display.addIRenderable(iRenderable);
	}
	
	/*
	 * Wrapper pour la suppression d'éléments de la liste des éléments à dessiner.
	 */
	public void removeIRenderable(IRenderable iRenderable) {
		display.removeIRenderable(iRenderable);
	}


	/*
	 * Empeche le Thread principale de travailler tant que la fenêtre n'est pas prête.
	 */
	public void waitForReady() {
		while(display == null) {
			System.out.print(""); // Don't touch it, it's working
		};
	}
}
