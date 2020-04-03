package players;

import games.*;
import java.util.Random;

/**
 * Joueur ordinateur (coups aléatoirs)
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class RandomPlayer implements GamePlayer{
  //Création d'une instance rand, objet de type Random
  Random rand = new Random();

  /** Renvoie le coup choisi par le joueur (méthode de l'interface GamePlayer)
  * choisi un nombre aléatoire entre 1 et la taille de la list renvoyé par validMoves
  * si le coup est présent dans la liste des coups valides il est renvoyé
  * sinon on affiche un message d'erreur et on redemande un coup
  * @param game, l'instance du jeu choisi
  * @return val, le résultat du choix du nombre aléatoire sous forme d'entier
  */
  public int chooseMove(AbstractGame game){
    int val;
    do{
      val = 1 + rand.nextInt(game.validMoves().size());
    }while(game.validMoves().contains(val) == false);
    System.out.println("\n" + game.getColorPlayer() + game.getCurrentPlayer().toString() + game.resetColorPlayer() + " à jouer le coup : " + val);
    return val;
  }

  /** Renvoie le nom du joueur random
  * le nom est constitué d'un hash code généré aléatoirement
  * @return randomName, nom du joueur MinMaxPlayer sous forme d'une chaine de caractère
  */
  public String toString(){
    String randomName = "Joueur aléatoire #" + rand.hashCode();
    return randomName;
  }
}
