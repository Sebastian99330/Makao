import java.util.Scanner;
public class HumanPlayer extends Player {
	Scanner keyboard;
	
	HumanPlayer(Deck deck, String name2) {
		// TODO Auto-generated constructor stub
		super(deck, name2);
		keyboard = new Scanner(System.in);
	}
	
	@Override
	public void introduceYourself() {
		// TODO Auto-generated method stub
		System.out.println("I'm a human!");
		super.introduceYourself();
	}
	
	/*
	 * askForIndex used in playCard method. Stands for asking user for an index of a card from his hand (simply - which card)
	 * does he want to put on the top
	 */
	public int askForIndex(){
	
		int index;
		index= keyboard.nextInt();
		keyboard.nextLine();
		index--;//bo komp liczy od 0 a nie 1 jak cz�owiek
		boolean keepAsking=false;
		if(index < 0 || index >= this.hand.size()){
			keepAsking=true;
		}
				
		while(keepAsking){
			keepAsking=false;
			System.out.print("Podales liczbe spoza zakresu. Jeszcze raz: ");
			index= keyboard.nextInt();
			keyboard.nextLine();
			index--;//bo komp liczy od 0 a nie 1 jak cz�owiek
			if(index < 0 || index >= this.hand.size()){
				keepAsking=true;
			}			
			
		}

		//keyboard.close();
		return index;
	}
	
		@Override
	/*
	 * (non-Javadoc)
	 * @see Player#playCard(int, GameCard)
	 * ta metoda rozni si� od ComputerPlayer'owej tym, �e tutaj pytamy u�ytkownika co zrobi� i czytamy z klawiatury opcje.
	 * dla Computera-gracza b�dzie to losowane.
	 */
	public boolean playCard(GameCard gameCard) {
		System.out.println("Gracz cz�owiek k�adzie kart�");

		boolean appropriate=true;
		int index;
		do{
			if(!appropriate){System.out.println("Podano numer karty ktorej nie mozna polozyc (nie pasuje kolor albo wysoko��).");}
			System.out.print("Ktora karte chcesz zagrac? ");
			index = askForIndex();	
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
		System.out.println("Poprawnie zagrano kart�.");
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
