package games;

import players.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Jeu du ConnectFour (Puissance 4)
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class ConnectFour extends AbstractGame{
  //Couleur du texte
  public static final String GREEN = "\u001B[32m";
  public static final String CYAN = "\u001B[36m";
  public static final String RESET = "\u001B[0m";

  //Création de la grille de taille 7*6
  protected Object [][] grid = new Object [6][7];

  //Variable de symboles X et O (avec couleurs)
  protected String symboleX = CYAN + "X" + RESET;
	protected String symboleO = GREEN + "O" + RESET;
	protected String currentSymbole;

  /**Constructeur de ConnectFour
  * appel du constructeur parent de player1 et player2
  * initialisation de la grille avec la méthode gridInitializer()
  * définition du symbole courant par symboleX (X = premier joueur)
  * @param player1, instance du joueur 1
  * @param player2, insance du joueur 2
  */
  public ConnectFour(GamePlayer player1, GamePlayer player2){
    super(player1, player2);
    gridInitializer();
    this.currentSymbole = symboleX;
  }

  /**Initialisation de la grille du ConnectFour
  * on parourt toute les case de la grille d'indice i et j avec la double boucle for
  * on ajoute à chaque case le symbole "-"
  */
	public void gridInitializer(){
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = "-";
			}
		}
	}

  /**
  * Acceusseur de ConnectFour
  * @return this.symboleX, le symbole X
  * @return this.symboleO, le symbole O
  * @return this.currentSymbole, le symbole courant (X ou O)
  * @return grid, grille du jeu
  */
	public String getSymboleX(){
		return this.symboleX;
	}

	public String getSymboleO(){
		return this.symboleO;
	}

	public String getCurrentSymbole(){
		return this.currentSymbole;
	}

  public Object getGrid(){
    return grid;
  }

  /** Execution du coup
  * on execute coup 'move' dans la grille
  * on place le symbole courant à la case choisie
  * l'indice Y prend la valeur de move -1
  * l'indice X est initialisé à 5 et on decrémente de 1 temps que la case est pas '-'
  * on inverse le symbole courant
  * @param move, entier du coup choisi
  */
  public void execute(int move){
    int moveX = 5;
    int moveY = move - 1;
    while(grid[moveX][moveY] != "-"){
      moveX--;
    }

    if(getCurrentSymbole() == getSymboleX()){
      this.currentSymbole = getSymboleO();
    }else{
      this.currentSymbole = getSymboleX();
    }
    grid[moveX][moveY] = getCurrentSymbole();
  }

  /** Les coups valides
  * on créer une instance 'list', object List d'entier
  * on ajoute à la liste les coups possibles (les colonnes de 1 à 7)
  * les colonnes déjà remplis ne sont plus des coups valides
  * @return list, liste d'entier des coups valides sous forme d'un objet de type List<Integer>
  */
  public List<Integer> validMoves(){
    List<Integer> list = new ArrayList();
    for(int i = 0; i<grid.length + 1; i++){
      if(grid[0][i] == "-"){
        list.add(i+1);
      }
    }
    return list;
  }

  /** Regarde si la partie est fini
  * @return 0, Pas finie
  * @return 1, La partie est finie / un gagnant
  * @return 2, La parie est finie / match nul
  */
  public int isOver(){
    int count = 0;

    //Linges
    for(int i = 0; i<grid.length; i++){
      for(int j = 0; j<grid[i].length - 3; j++){
        if(grid[i][j] == getSymboleO() && grid[i][j+1] == getSymboleO() && grid[i][j+2] == getSymboleO() && grid[i][j+3] == getSymboleO()){
          return 1;
        }else if(grid[i][j] == getSymboleX() && grid[i][j+1] == getSymboleX() && grid[i][j+2] == getSymboleX() && grid[i][j+3] == getSymboleX()){
          return 1;
        }
      }
    }

    //Colonnes
    for(int i = 0; i<grid.length - 3; i++){
      for(int j = 0; j<grid[i].length; j++){
        if(grid[i][j] == getSymboleO() && grid[i+1][j] == getSymboleO() && grid[i+2][j] == getSymboleO() && grid[i+3][j] == getSymboleO()){
          return 1;
        }else if(grid[i][j] == getSymboleX() && grid[i+1][j] == getSymboleX() && grid[i+2][j] == getSymboleX() && grid[i+3][j] == getSymboleX()){
          return 1;
        }
      }
    }

    //Diagonales
    for(int i = 0; i<grid.length - 3; i++){
      for(int j = 0; j<grid[i].length - 3; j++){
        if(grid[i][j] == getSymboleO() && grid[i+1][j+1] == getSymboleO() && grid[i+2][j+2] == getSymboleO() && grid[i+3][j+3] == getSymboleO()){
          return 1;
        }else if(grid[i][j] == getSymboleX() && grid[i+1][j+1] == getSymboleX() && grid[i+2][j+2] == getSymboleX() && grid[i+3][j+3] == getSymboleX()){
          return 1;
        }
      }
    }
    for(int i = 0; i<grid.length - 3; i++){
      for(int j = 3; j<grid[i].length; j++){
        if(grid[i][j] == getSymboleO() && grid[i+1][j-1] == getSymboleO() && grid[i+2][j-2] == getSymboleO() && grid[i+3][j-3] == getSymboleO()){
          return 1;
        }else if(grid[i][j] == getSymboleX() && grid[i+1][j-1] == getSymboleX() && grid[i+2][j-2] == getSymboleX() && grid[i+3][j-3] == getSymboleX()){
          return 1;
        }
      }
    }

    //Match Nul
    for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != "-"){
					count++;
				}
			}
		}
    if(count == 42){
      return 2;
    }
    return 0;
  }

  /** Renvoie le gagnant de la partie
  * on inverse le joueur courant pour avoir le gagnant
  * @return getCurrentPlayer(), joueur courant de type GamePlayer
  */
  public GamePlayer getWinner(){
		if(super.currentPlayer == super.player1){
      super.currentPlayer = super.player2;
    }else{
      super.currentPlayer = super.player1;
    }
		return getCurrentPlayer();
	}

  /** Donne la situation du jeu
  * on affiche la grille du jeu
  * on donnes les coup disponibles
  */
  public void situationToString(){
		System.out.println("\n");
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("Colonnes disponible(nt) : ");
		System.out.println(validMoves());
		System.out.println(getColorPlayer() + getCurrentPlayer().toString() + resetColorPlayer() + ", dans quelle colonne voulez vous mettre le jeton ? : ");
	}

  /** Renvoie une copie du Jeu
  * on a la variable game qui est l'instance du jeu
  * @return gameCopy, une copie de la situation courante du jeu
  */
	public AbstractGame getCopy(){
		ConnectFour gameCopy = new ConnectFour(super.player1, super.player2);
    gameCopy.validMoves();
    gameCopy.player1 = super.currentPlayer;
    for(int i = 0; i<grid.length; i++){
      for(int j = 0; j<grid[i].length; j++){
        gameCopy.grid[i][j] = this.grid[i][j];
      }
    }
		return gameCopy;
	}
}
