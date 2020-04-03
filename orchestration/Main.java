package orchestration;

import games.*;
import players.*;
import java.util.Scanner;

/**
 * Classe executable main
 *
 * @author Valentin DUMAS, Tomy DEMAZEAU, Enzo DURAND
 * @version 1.0
 */
public class Main{
  public static void main(String [] args){
    //Couleur du texte
    String GREEN = "\u001B[32m";
    String CYAN = "\u001B[36m";
    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";

    //Instance d'orchestration
    Scanner sc = new Scanner(System.in);
    Orchestrator playing = new Orchestrator();

    //Création des joueurs à null
    GamePlayer player1 = null;
    GamePlayer player2 = null;

    //Si il n'y a pas les 3 args nécessaire
    if(args.length != 3){
      System.out.print(RED + "Erreur, argument manquant" + RESET);
    }

    //Vérification si le jeu ou les joueurs sont bien choisient.
    if(!args[0].equals("Nim") && !args[0].equals("TicTacToe") && !args[0].equals("ConnectFour")){
      System.out.println("Vous devez choisir entre Nim, TicTacToe ou ConnectFour");
    }

    if(!args[1].equals("Human") && !args[1].equals("MinMaxPlayer") && !args[1].equals("RandomPlayer")){
      System.out.println("Vous devez choisir pour le joueur 1 entre Human, MinMaxPlayer ou RandomPlayer");
    }

    if(!args[2].equals("Human") && !args[2].equals("MinMaxPlayer") && !args[2].equals("RandomPlayer")){
      System.out.println("Vous devez choisir pour le joueur 2 entre Human, MinMaxPlayer ou Random Player");
    }

    //Création des joueurs.
    if(args[1].equals("Human")){
      System.out.println("\nNom joueur 1 : ");
      String name1 = sc.nextLine();
      player1 = new Human(name1);
      System.out.println("Joueur 1 : " + GREEN + player1.toString() + RESET);
    }
    if(args[1].equals("RandomPlayer")){
      player1 = new RandomPlayer();
      System.out.println("Joueur 1 : " + GREEN + player1.toString() + RESET);
    }
    if(args[1].equals("MinMaxPlayer")){
      player1 = new MinMaxPlayer();
      System.out.println("Joueur 1 : " + GREEN + player1.toString() + RESET);
    }

    if(args[2].equals("Human")){
      System.out.println("\nNom joueur 2 : ");
      String name2 = sc.nextLine();
      player2 = new Human(name2);
      System.out.println("Joueur 2 : " + CYAN + player2.toString() + RESET);
    }
    if(args[2].equals("RandomPlayer")){
      player2 = new RandomPlayer();
      System.out.println("Joueur 2 : " + CYAN + player2.toString() + RESET);
    }
    if(args[2].equals("MinMaxPlayer")){
      player2 = new MinMaxPlayer();
      System.out.println("Joueur 2 : " + CYAN + player2.toString() + RESET);
    }

    /** Création des jeux.
    * Lancement du jeu du Nim
    */
    if(args[0].equals("Nim")){
      //Mise en forme
      System.out.println("\n=====================");
      System.out.println("  _   _ _           ");
      System.out.println(" | \\ | (_)          ");
      System.out.println(" |  \\| |_ _ __ ___  ");
      System.out.println(" | . ` | | '_ ` _ \\ ");
      System.out.println(" | |\\  | | | | | | |");
      System.out.println(" |_| \\_|_|_| |_| |_|");
      System.out.println("=====================\n");

      //Demande nombre d'allumette initial
      System.out.println("Nombre d'allumette au début de la partie : ");
      int initialNbMatches = sc.nextInt();
      //Demande nombre d'allumette max par tour
      System.out.println("Nombre d'allumette maximum tiré par tour : ");
      int maxMatches = sc.nextInt();
      System.out.println("\n====DEBUT DE LA PARTIE====");
      //Creation de la partie
      Nim gameN = new Nim(initialNbMatches, maxMatches, initialNbMatches, player1, player2);
      //Deroulement de la partie
      playing.playGames(gameN);
    }

    //Lancement TicTacToe
    if(args[0].equals("TicTacToe")){
      //Mise en forme
      System.out.println("\n=================================================");
      System.out.println(" _____ _        _____            _____          ");
      System.out.println("|_   _(_)      |_   _|          |_   _|         ");
      System.out.println("  | |  _  ___    | | __ _  ___    | | ___   ___ ");
      System.out.println("  | | | |/ __|   | |/ _` |/ __|   | |/ _ \\ / _ \\");
      System.out.println("  | | | | (__    | | (_| | (__    | | (_) |  __/");
      System.out.println("  \\_/ |_|\\___|   \\_/\\__,_|\\___|   \\_/\\___/ \\___|");
      System.out.println("=================================================\n");

      //Création de la partie
      TicTacToe gameT = new TicTacToe(player1, player2);
      //Déroulement de la partie
      playing.playGames(gameT);
    }

    //Lancment du Puissance 4
    if(args[0].equals("ConnectFour")){
      //Mise en forme
      System.out.println("\n======================================================");
      System.out.println("  _____       _                                _  _   ");
      System.out.println(" |  __ \\     (_)                              | || |  ");
      System.out.println(" | |__) |   _ _ ___ ___  __ _ _ __   ___ ___  | || |_ ");
      System.out.println(" |  ___/ | | | / __/ __|/ _` | '_ \\ / __/ _ \\ |__   _|");
      System.out.println(" | |   | |_| | \\__ \\__ \\ (_| | | | | (_|  __/    | |  ");
      System.out.println(" |_|    \\__,_|_|___/___/\\__,_|_| |_|\\___\\___|    |_|  ");
      System.out.println("======================================================\n");

      //Création de la partie
      ConnectFour gameP = new ConnectFour(player1, player2);
      //Déroulement de la partie
      playing.playGames(gameP);
    }
  }
}
