package players;

import games.*;

/**
 * Interface pour les différents type de joueur
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public interface GamePlayer{
  /** Méthode pour choisir le coup du joueur
  * @param game, l'instance du jeu choisi
  */
  public int chooseMove(AbstractGame game);
}
