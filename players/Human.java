package players;

import games.*;
import java.util.Scanner;

/**
 * Joueur humain
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class Human implements GamePlayer{

  //Couleur du texte
  public static final String RED = "\u001B[31m";
  public static final String RESET = "\u001B[0m";

  //Création de l'instance sc, objet de type Scanner
  Scanner sc = new Scanner(System.in);
  protected String name;

  /**
  * Constructeur de Human
  * @param name, nom du joueur Human
  */
  public Human(String name){
    this.name = name;
  }

  /** Renvoie le nom du joueur
  * @return randomName, nom du joueur Human sous forme d'une chaine de caractère
  */
  public String toString(){
    return this.name;
  }

  /** Renvoie le coup choisi par le joueur (méthode de l'interface GamePlayer)
  * Demande à chaque tour le coup que le joueur veut joueur
  * si le coup est présent dans la liste des coups valides il est renvoyé
  * sinon on affiche un message d'erreur et on redemande un coup
  * @param game, l'instance du jeu choisi
  * @return val, le coup choisi par le joueur sous forme d'un entier
  */
  public int chooseMove(AbstractGame game){
    int move = -1;
    do{
      game.situationToString();
      move = sc.nextInt();
      if(game.validMoves().contains(move) == false){
        System.out.println(RED + "Erreur, coup non valide, recommencer !" + RESET);
      }
    }while(game.validMoves().contains(move) == false);
    return move;
  }
}
