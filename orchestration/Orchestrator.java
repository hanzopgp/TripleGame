package orchestration;

import games.*;

/**
 * Orchestration d'une partie
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class Orchestrator{

  /** Déroulement de la partie
  * Tant que la méthode 'isOver' renvoie 0 on execute les mouvements
  * si 'isOver' renvoie 2 on affiche match nul
  * si 'isOver' renvoie 1 on annonce le vainqueur avec la méthode 'getWinner'
  * @param game, l'instance du jeu choisi
  */
  public void playGames(AbstractGame game){
    while(game.isOver() == 0){
      game.executeMove(game.getCurrentPlayer().chooseMove(game));
    }
    //Annonce du vainqueur
    if(game.isOver() == 2){
      System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
      System.out.println("MATCH NUL");
      System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    }else{
      System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
      System.out.println("Le gagnant est : " + game.getColorPlayer() + game.getWinner().toString() + game.resetColorPlayer());
      System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    }
  }
}
