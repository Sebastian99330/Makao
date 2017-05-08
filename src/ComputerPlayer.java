import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(Deck deck, String name2) {
		// TODO Auto-generated constructor stub
		super(deck, name2);
	}
	
	@Override
	public void introduceYourself() {
		// TODO Auto-generated method stub
		System.out.println("I'm actually a computer.");
		super.introduceYourself();
	}
	
	@Override
	public boolean playCard(GameCard gameCard) {
		System.out.println("Gracz komputer k³adzie kartê");

		Random random = new Random();
		int index;
		boolean appropriate=true;
		do{
			index = random.nextInt(this.hand.size());	//losuje liczbê od 0 do takiej, ile mamy kart w rêku
			appropriate=gameCard.IsAppropriateOnTop(hand.get(index));
		}while(!appropriate);
		
		/* this.hand.get(index) - zdobywamy t¹ metod¹ kartê  o podanym indeksie z rêki tego(this) gracza. */
		gameCard.putCard(this.hand.get(index));	

		/*
		 * remove - po zagraniu karty na szczyt usuwamy j¹ z rêki
		 * p.s. jak siê dla tego wywo³ania metody remove da w nag³ówku playCard pierwszy argument 
		 * typu Integer zamiast prymitywnego int to nie dzia³a, lol
		 */
		this.hand.remove(index);
		System.out.println("Poprawnie zagrano kartê komputerowego gracza.");
		//this.hand.remove(this.hand.get(index));	//na wypadek gdyby wy¿sza linijka nie dzia³a³a to to dzia³a
		//this.showHand();	//i wyœwietlamy co potem mamy w rêku (nie konieczne)
		
		
		if(this.hand.size()==1){
			System.out.println("Makao!");
		}
		if(this.hand.isEmpty()){
			System.out.println("PO MAKALE !!!!!!!!!!!");
			return false;
		}
		return true;
	}

}
