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
		System.out.println("Gracz komputer k�adzie kart�");

		Random random = new Random();
		int index;
		boolean appropriate=true;
		do{
			index = random.nextInt(this.hand.size());	//losuje liczb� od 0 do takiej, ile mamy kart w r�ku
			appropriate=gameCard.IsAppropriateOnTop(hand.get(index));
		}while(!appropriate);
		
		/* this.hand.get(index) - zdobywamy t� metod� kart�  o podanym indeksie z r�ki tego(this) gracza. */
		gameCard.putCard(this.hand.get(index));	

		/*
		 * remove - po zagraniu karty na szczyt usuwamy j� z r�ki
		 * p.s. jak si� dla tego wywo�ania metody remove da w nag��wku playCard pierwszy argument 
		 * typu Integer zamiast prymitywnego int to nie dzia�a, lol
		 */
		this.hand.remove(index);
		System.out.println("Poprawnie zagrano kart� komputerowego gracza.");
		//this.hand.remove(this.hand.get(index));	//na wypadek gdyby wy�sza linijka nie dzia�a�a to to dzia�a
		//this.showHand();	//i wy�wietlamy co potem mamy w r�ku (nie konieczne)
		
		
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
