import java.util.*;

public class Deck {
	public Vector<Card> deck;
	
	Deck(){
		deck=new Vector<Card>();	//tworzy pusty deck
		fillDeck();	//dlatego musimy go wype�ni� 52 kartami
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
	 * niby getter z kt�rego i tak nie b�d� korzysta� bo mi si� nie chce
	 */
	public Vector<Card> getDeck() {
		return deck;
	}

	/*
	 * zdejmuje kart� ze stosu decka (faktycznie wektora). Czyli po prostu dobranie karty dla gracza, 
	 * albo na po�o�enie pierwszej karty w grze.  
	 */
	public Card takeACard(){
		return deck.remove(deck.size()-1);
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	/*
	 * wype�nia decka na pocz�tku gry 52 kartami.
	 */
	private void fillDeck(){
		for (String suit : Card.getPossibleSuits() ) {	//leci po wszystkich kolorach
			for (String number : Card.getPossibleNumbers() ) {	//dla ka�dego koloru leci po wszystkich numerach
				deck.add(new Card (number.toString(),suit));	//tworzy ka�d� kart� i k�adzie na decka
			}
		}
	}
}
