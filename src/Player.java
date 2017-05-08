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
	 * showAvailibleCards pokazuje (drukuje na ekran) graczowi karty które mo¿e zagraæ (mo¿liwe ¿e ¿adn¹) 
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
	 * getAvailible daje listê kart z rêki gracza które on mo¿e po³o¿yæ w danym momencie.
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
	 * wywo³ywana na pocz¹tku gry, daje 5 kart graczowi
	 */
	public void addHand(Deck deck){
		for(int i=0;i<5;i++){
			hand.add(deck.takeACard());	//metoda draw, móg³bym j¹ wywo³aæ ale nie ma co mieszaæ w kodzie
		}
	}
	
	public void draw(Deck deck){
		hand.add(deck.takeACard());
	}
	
	/*
	 * pokazuje graczowi na ekran karty jakie ma w ³apie
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
	 * playCard - zagrywamy kartê (k³adziemy j¹ na szczyt). 
	 * index to nr karty w rêku (bo tak karty s¹ trzymane w rêku, ponumerowane) //(zaraz wywaliæ t¹ linijkê z komentarza)
	 * drugi argument to nasza "g³ówna karta gry", bo w koñcu j¹ zastêpujemy (na ni¹ k³adziemy nasz¹ kartê).
	 */
	public abstract boolean playCard(GameCard gameCard);

}
