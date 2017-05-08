import java.util.*;

public class Deck {
	public Vector<Card> deck;
	
	Deck(){
		deck=new Vector<Card>();	//tworzy pusty deck
		fillDeck();	//dlatego musimy go wype³niæ 52 kartami
	}	


	/**
	 * uyufgu
	 * @return
	 */
	/*
	 * ile mamy kart w decku
	 */
	Integer size(){
		return deck.size();
	}
	
	
	/*
	 * niby getter z którego i tak nie bêdê korzysta³ bo mi siê nie chce
	 */
	public Vector<Card> getDeck() {
		return deck;
	}

	/*
	 * zdejmuje kartê ze stosu decka (faktycznie wektora). Czyli po prostu dobranie karty dla gracza, 
	 * albo na po³o¿enie pierwszej karty w grze.  
	 */
	public Card takeACard(){
		return deck.remove(deck.size()-1);
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	/*
	 * wype³nia decka na pocz¹tku gry 52 kartami.
	 */
	private void fillDeck(){
		for (String suit : Card.getPossibleSuits() ) {	//leci po wszystkich kolorach
			for (String number : Card.getPossibleNumbers() ) {	//dla ka¿dego koloru leci po wszystkich numerach
				deck.add(new Card (number.toString(),suit));	//tworzy ka¿d¹ kartê i k³adzie na decka
			}
		}
	}
}
