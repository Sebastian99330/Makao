
/*
 * Klasa gra. Do ogarniania ca�ej gry. B�dzie tu deck, �rodkowa karta (g��wna na kt�r� gracze k�ad� karty), 
 * gracze.
 */
public class Game {
	GameCard gameCard;	//to ta �rodkowa karta na kt�r� k�adzie si� swoje karty.
	Deck deck;	//deck 52 kart
	
	
	Game(){
		gameCard=new GameCard();	//tworzymy faktyczny obiekt tej karty (faktycznie: stosu kart), bo wy�ej jest tylko referencja
		//System.out.println("Game constructor.");
		deck=new Deck();	//bierzemy do naszej gry deck kart (bo wy�ej jest tylko referencja)
		deck.shuffle();	//tasujemy decka
		gameCard.putFirstCard(deck);	//i wyk�adamy pierwsz� kart� z deck'a na �rodek, do gry.	
	}
	
	
	
}