package games;

import players.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Jeu du TicTacToe (Morpion)
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class TicTacToe extends AbstractGame{
	//Couleur du texte
  public static final String GREEN = "\u001B[32m";
  public static final String CYAN = "\u001B[36m";
  public static final String RESET = "\u001B[0m";

  //Creation de la grille
	protected Object [][] grid = new Object [3][3];

  //Variable des symboles X et O (avec couleurs)
	protected String symboleX = CYAN + "X" + RESET;
	protected String symboleO = GREEN + "O" + RESET;
	protected String currentSymbole;

	/**Constructeur de TicTacToe
  * appel du constructeur parent de player1 et player2
  * initialisation de la grille avec la méthode gridInitializer()
  * définition du symbole courant par symboleX (X = premier joueur)
  * @param player1, instance du joueur 1 objet de type GamePlayer
  * @param player2, insance du joueur 2 objet de type GamePlayer
  */
	public TicTacToe(GamePlayer player1, GamePlayer player2){
		super(player1, player2);
		gridInitializer();
		this.currentSymbole = symboleX;
	}

	/**Initialisation de la grille du Tic tac toe
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
   * Acceusseur de TicTacToe
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
  * on convertit le nombre 'move' en coordonnée x, y pour les indices de la case
  * on inverse le le symbole courant
  * @param move, entier du coup choisi
  */
	public void execute(int move) {
		int moveX = 0;
		int moveY = (move+2)%3;

		if(move >= 0 || move <= 9){
			if(move <= 3 && move > 0) {
				moveX = 0;
			}else if(move >= 4 && move <= 6) {
				moveX = 1;
			}else if(move <= 9 && move >= 7) {
				moveX = 2;
			}
			if (grid[moveX][moveY] == "-") {
				if(getCurrentSymbole() == getSymboleX()){
					this.currentSymbole = getSymboleO();
				}else{
					this.currentSymbole = getSymboleX();
				}
				grid[moveX][moveY] = getCurrentSymbole();
			}
		}
	}

  /** Les coups valides
  * on créer une instance 'list', object List d'entier
  * on ajoute à la liste les coups possibles (ou la case = '-')
  * i*3+j+1 permet de convertir les indices de la case en numéro de case (de 1 à 9)
  * @return list, liste d'entier des coups valides sous forme d'un objet de type List<Integer>
  */
	public List<Integer> validMoves(){
		List<Integer> list = new ArrayList();
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j] == "-"){
					list.add(i*3+j+1);
				}
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

		//Lignes
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == getSymboleX() && grid[i][1] == getSymboleX() && grid[i][2] == getSymboleX()) {
				return 1;
			}else if (grid[i][0] == getSymboleO() && grid[i][1] == getSymboleO() && grid[i][2] == getSymboleO()){
				return 1;
			}
		}

		//Colonnes
		for (int i = 0; i < grid.length; i++) {
			if (grid[0][i] == getSymboleX() && grid[1][i] == getSymboleX() && grid[2][i] == getSymboleX()) {
				return 1;
			}else if (grid[0][i] == getSymboleO() && grid[1][i] == getSymboleO() && grid[2][i] == getSymboleO()){
				return 1;
			}
		}

		//Diagonales
		if (grid[0][0] == getSymboleX() && grid[1][1] == getSymboleX() && grid[2][2] == getSymboleX()) {
			return 1;
		}else if (grid[0][0] == getSymboleO() && grid[1][1] == getSymboleO() && grid[2][2] == getSymboleO()) {
			return 1;
		}else if(grid[0][2] == getSymboleX() && grid[1][1] == getSymboleX() && grid[2][0] == getSymboleX()){
			return 1;
		}else if(grid[0][2] == getSymboleO() && grid[1][1] == getSymboleO() && grid[2][0] == getSymboleO()){
			return 1;
		}

		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != "-") {
					count++;
				}
			}
		}

		if (count == 9){
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
		System.out.println("Case(s) disponible(nt) : ");
		System.out.println(validMoves());
		System.out.println(getColorPlayer() + getCurrentPlayer().toString() + resetColorPlayer() + ", Quel case voulez-vous jouer ? : ");
	}

  /** Renvoie une copie du Jeu
  * on a la variable game qui est l'instance du jeu
  * @return gameCopy, une copie de la situation courante du jeu
  */
	public AbstractGame getCopy(){
		TicTacToe gameCopy = new TicTacToe(super.player1, super.player2);
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
