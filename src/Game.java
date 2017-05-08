
/*
 * Klasa gra. Do ogarniania ca³ej gry. Bêdzie tu deck, œrodkowa karta (g³ówna na któr¹ gracze k³ad¹ karty), 
 * gracze.
 */
public class Game {
	GameCard gameCard;	//to ta œrodkowa karta na któr¹ k³adzie siê swoje karty.
	Deck deck;	//deck 52 kart
	
	
	Game(){
		gameCard=new GameCard();	//tworzymy faktyczny obiekt tej karty (faktycznie: stosu kart), bo wy¿ej jest tylko referencja
		//System.out.println("Game constructor.");
		deck=new Deck();	//bierzemy do naszej gry deck kart (bo wy¿ej jest tylko referencja)
		deck.shuffle();	//tasujemy decka
		gameCard.putFirstCard(deck);	//i wyk³adamy pierwsz¹ kartê z deck'a na œrodek, do gry.	
	}
	
	
	
}