package games;

import players.GamePlayer;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe abstraite pour les diférents jeu (avec les méthodes)
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public abstract class AbstractGame{
  //Couleur du texte
  public static final String GREEN = "\u001B[32m";
  public static final String CYAN = "\u001B[36m";
  public static final String RESET = "\u001B[0m";

  //Couleur du joueur courant(vert au début)
  protected String colorPlayer = GREEN;

  //Initialisation des deux joueurs (player1 et player 2)
  protected GamePlayer player1;
	protected GamePlayer player2;
	protected GamePlayer currentPlayer;

  /** Constructeur
  * initiation des variables
  * @param player1, instance du joueur 1
  * @param player2, insance du joueur 2
  */
  public AbstractGame(GamePlayer player1, GamePlayer player2){
    this.player1 = player1;
    this.player2 = player2;
    this.currentPlayer = player1;
    this.colorPlayer = colorPlayer;
  }

  /**
  * Classes abstraite
  */
  public abstract void execute(int move); //Méthode abastraite qui execute un coup
  public abstract List<Integer> validMoves(); //Liste des coups valides
  public abstract void situationToString(); //Indique au joueur la situation du jeu.
  public abstract int isOver(); //Vérifie si la jeu est fini (gagné par un des deux joueurs).
  public abstract GamePlayer getWinner(); //Renvoie le gagnant de la partie.
  public abstract AbstractGame getCopy(); //Renvoie une copy de l'objet avec une nouvelle instance.

  /**
  * Retroune le joueur courant
  * @return this.currentPlayer, instance du joueur courant sous forme d'objet de type GamePlayer
  */
  public GamePlayer getCurrentPlayer(){
    return this.currentPlayer;
  }

  /**
  * Retroune la couleur du joueur courant
  * @return this.colorPlayer, la couleur du joueur courant
  */
  public String getColorPlayer(){
    return this.colorPlayer;
  }

  /**
  * Reset la couleur du texte
  * @return RESET, variable de reinitialisation de la couleur
  */
  public String resetColorPlayer(){
    return RESET;
  }

  /**
  * Execute le coup et change le joueur courant
  * @param move, entier du coup choisi
  */
  public void executeMove(int move){
    execute(move);
    if(getCurrentPlayer() == this.player1){
      this.currentPlayer = this.player2;
      this.colorPlayer  = CYAN;
    }else{
      this.currentPlayer = this.player1;
      this.colorPlayer = GREEN;
    }
  }
}
