# Triple game

## Table des matières
1. [Auteurs](#projet-conçu-par-)
2. [Utilisation](#utilisation-)
2. [Regles du jeu](#regles-du-jeu-)
5. [Liens utiles](#liens-utiles-)

## Projet conçu par : 

- Valentin Dumas : 21706521, groupe 4B L2 informatique
- Enzo Durand : 21510242, groupe 4B L2 informatique
- Tomy Demazeau : 21705284, groupe 4B L2 informatique

## Utilisation :

- Dans le terminal, se placer dans le répertoire du fil rouge
- Compiler les fichiers .java avec "javac -d build */*.java"
- Lancer le fichier exécutable Main avec "java -cp build/ orchestration.Main ..."
- Après Main, il faut mettre les arguments.
	Argument n°1 - Le jeu, choisir entre Nim, TicTacToe et ConnectFour
	Argument n°2 - Le type du premier joueur, choisir entre Human, RandomPlayer et MinMaxPlayer
	Argument n°3 - Le type du deuxième joueur, choisir entre Human, RandomPlayer et MinMaxPlayer
- Si vous choisissez un ou deux joueurs Human, le programme demande ensuite le nom de chaque joueur

## Regles du jeu :

- Pour le jeu du Nim :
	- Entrer le nombre d'allumette en debut de partie
	- Entrer ensuite le nombre maximum d'allumette que l'on peut jouer par coup
	- Enfin chaque joueur entre un coup compris entre 1 et le nombre max d'allumette par coup
- Pour le TicTacToe :
	- Entrer à chaque tour un coup présent dans la liste des coups disponibles affiché en dessous
- Pour le ConnectFour :
	- Entrer à chaque tour un coup présent dans la liste des coups disponibles affiché en dessous

## Liens utiles :

- https://en.wikipedia.org/wiki/Minimax
