import java.util.*;
public abstract class Player {
	LinkedList<Card> hand;
	LinkedList<Card> availible;
	String name;
	
	public String getName() {
		return name;
	}

	public void introduceYourself(){
		System.out.println("My name is: "+getName());
	}
	
	/*
	 * showAvailibleCards pokazuje (drukuje na ekran) graczowi karty kt�re mo�e zagra� (mo�liwe �e �adn�) 
	 */
	public void showAvailibleCards(Card top){
		int count=0;
		for(Card card: hand){
			count++;
			if(card.number==top.number || card.suit==top.suit){
				System.out.print(count+" "+card+"; ");
			}
		}
		
		System.out.println();
	}
	
	
	/*
	 * getAvailible daje list� kart z r�ki gracza kt�re on mo�e po�o�y� w danym momencie.
	 */
	public LinkedList<Card> getAvailibleCards(Card top){
		availible=new LinkedList<>();
		for(Card card: hand){
			if(card.number==top.number || card.suit==top.suit){
				 availible.add(card); 
			}
		}
		return availible;
	}
	
	Player(Deck deck,String name2){
		this.name=name2;
		hand=new LinkedList<>();
		this.addHand(deck);
	}
	
	
	/*
	 * wywo�ywana na pocz�tku gry, daje 5 kart graczowi
	 */
	public void addHand(Deck deck){
		for(int i=0;i<5;i++){
			hand.add(deck.takeACard());	//metoda draw, m�g�bym j� wywo�a� ale nie ma co miesza� w kodzie
		}
	}
	
	public void draw(Deck deck){
		hand.add(deck.takeACard());
	}
	
	/*
	 * pokazuje graczowi na ekran karty jakie ma w �apie
	 */
	public void showHand(){
		int i=0;
		for(Card card: hand){
			i++;
			System.out.print(i+" "+card+"; ");
		}
		System.out.println();
	}
	
	
	/*
	 * playCard - zagrywamy kart� (k�adziemy j� na szczyt). 
	 * index to nr karty w r�ku (bo tak karty s� trzymane w r�ku, ponumerowane) //(zaraz wywali� t� linijk� z komentarza)
	 * drugi argument to nasza "g��wna karta gry", bo w ko�cu j� zast�pujemy (na ni� k�adziemy nasz� kart�).
	 */
	public abstract boolean playCard(GameCard gameCard);

}
