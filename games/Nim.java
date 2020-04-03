package games;

import players.GamePlayer;
import java.util.List;
import java.util.ArrayList;

/**
 * Jeu du Nim
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class Nim extends AbstractGame{
  //Couleur du texte
  public static final String GREEN = "\u001B[32m";
  public static final String CYAN = "\u001B[36m";
  public static final String RESET = "\u001B[0m";

  //Nombre d'allumette en début de partie
  protected int initialNbMatches;

  //Maximum d'allumette retiré par coup
  protected int maxMatches;

  //Nombre courant d'allumette (= nombre initial au début)
  protected int nbMatches = initialNbMatches;

  /**Constructeur de ConnectFour
  * appel du constructeur parent de player1 et player2
  * @param initialNbMatches, nombre d'alluemette initial sous forme d'entier
  * @param maxMatches, nombre max d'allumette jouer par coup sous forme d'entier
  * @param player1, instance du joueur 1 objet de type GamePlayer
  * @param player2, insance du joueur 2 objet de type GamePlayer
  */
  public Nim(int initialNbMatches, int maxMatches, int nbMatches, GamePlayer player1, GamePlayer player2){
    super(player1, player2);
    this.initialNbMatches = initialNbMatches;
    this.maxMatches = maxMatches;
    this.nbMatches = nbMatches;
  }

  /**
  * Acceusseur de Nim
  * @return this.initialNbMatches, nombre d'alluemette initial sous forme d'entier
  * @return this.maxMatches, nombre max d'allumette jouer par coup sous forme d'entier
  */
  public int getInitialNbMatches(){
    return this.initialNbMatches;
  }
  public int getNbMatches(){
    return this.nbMatches;
  }

  /** Execute le coup
  * retir au nombre d'allumette courant le nombre d'allumette que le joueur à choisie
  * @param move, entier du coup choisi sous forme d'entier
  */
  public void execute(int move){
    this.nbMatches -= move;
  }

  /** Les coups valides
  * on créer une instance 'list', object List d'entier
  * on ajoute à la liste les coups possibles (entre 1 et le nombre max d'allumette joué)
  * @return list, liste d'entier des coups valides sous forme d'un objet de type List<Integer>
  */
  public List<Integer> validMoves(){
    List<Integer> list = new ArrayList();
    for(int i=1; i<=this.maxMatches; i++){
      list.add(i);
    }
    return list;
  }

  /** Regarde si la partie est fini
  * @return 0, Pas finie
  * @return 1, La partie est finie / un gagnant
  */
  public int isOver(){
    if(this.nbMatches <= 0){
      return 1;
    }else{
      return 0;
    }
  }

  /** Renvoie le gagnant de la partie
  * on renvoie le joueur courant
  * @return getCurrentPlayer(), joueur courant de type GamePlayer
  */
  public GamePlayer getWinner(){
    return getCurrentPlayer();
  }

  /** Donne la situtation du jeu
  * donne le nombre d'allumette restante (nbMatches)
  */
  public void situationToString(){
    System.out.println("\nLe nombre d'allumette restante est : " + this.nbMatches);
    System.out.println("\n" + getColorPlayer() + getCurrentPlayer().toString() + resetColorPlayer() + " tire un nombre d'allumette entre 1 et " + this.maxMatches);
  }

  /** Renvoie une copie du Jeu
  * on a la variable game qui est l'instance du jeu
  * @return game, une copie de la situation courante du jeu
  */
  public AbstractGame getCopy(){
    Nim game = new Nim(this.initialNbMatches, this.maxMatches, this.nbMatches, super.player1, super.player2);
    game.nbMatches = this.nbMatches;
    game.currentPlayer = super.currentPlayer;
    return game;
  }
}
