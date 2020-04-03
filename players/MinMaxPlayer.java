package players;

import games.*;
import java.util.Random;

/**
 * Joueur ordinateur (coups calculés et intellignents)
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class MinMaxPlayer implements GamePlayer{

  Random rand = new Random();

  /** Retourne le coup choisie par l'algo
  * on verifie que le coup choisi est bien dans la liste des coups valides
  * @param game, l'instance du jeu choisi
  * @return val, le résultat de la méthode negamax sous forme d'entier
  */
  public int chooseMove(AbstractGame game){
    int val;
    do{
      val = negamax(game, game.getCurrentPlayer());
    }while(game.validMoves().contains(val) == false);
    System.out.println("\n" + game.getColorPlayer() + game.getCurrentPlayer().toString() + game.resetColorPlayer() + " à jouer le coup : " + val);
		return val;
	}

  /** Algorithme negmax du cours
  * @param s, l'instance du jeu choisi
  * @param j, l'instance du joueur courant
  * @return mc, le meilleur coup possible sous forme d'entier
  */
  public int negamax(AbstractGame s, GamePlayer j){
    int mv = -1;
    Integer mc = null;
    for(int c:s.validMoves()){
      AbstractGame sp = s.getCopy();
      sp.executeMove(c);
      GamePlayer jp = sp.getCurrentPlayer();
      int vp = evaluer(sp, jp);
      if (vp > mv){
        mv = vp;
        mc = c;
      }
    }
    return mc;
  }

  /** Algorithme evaluer du cours
  * @param game, l'instance du jeu choisi
  * @param player, l'instance du joueur courant
  * @return res, le meilleur coup possible sous forme d'entier
  * @return 1, si le joueur courant est gagnant sous forme d'entier
  * @return -1, si le joueur courant est perdant sous forme d'entier
  * @return 0, si match nul sous forme d'entier
  */
  public int evaluer(AbstractGame s, GamePlayer j){
		if(s.getWinner() == j && s.isOver() == 1 && s.getWinner() != null){
      return 1;
    } else if(s.getWinner() != j && s.isOver() == 0 && s.getWinner() != null){
      return -1;
    } else if(s.isOver() == 2){
      return 0;
    }
		else {
			int res = -1;
			for(int c:s.validMoves()) {
        AbstractGame sp = s.getCopy();
        sp.executeMove(c);
        GamePlayer jp = sp.getCurrentPlayer();
        int vp = -evaluer(sp, jp);
				res = Math.max(res, vp);
			}
			return res;
		}
	}

  /** Donne le nom du joueur MinMaxPlayer
  * le nom est constitué d'un hash code généré aléatoirement
  * @return randomName, nom du joueur MinMaxPlayer sous forme d'une chaine de caractère
  */
  public String toString(){
    String randomName = "Joueur aléatoire #" + rand.hashCode();
    return randomName;
  }
}
