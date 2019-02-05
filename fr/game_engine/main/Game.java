package fr.game_engine.main;

public class Game implements Runnable {

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

	private int gameState = PAUSED;
	private boolean isRunning;

	private Game() {
		new Thread(this, "Main thread");
	}

	private void init() {
		isRunning = true;
	}

	@Override
	public void run() {
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
		gameState = RUN;
	}

	/*
	 * Fonction de reprise du jeu après une pause.
	 */
	public void resume() {
		gameState = PAUSED;
	}
}
