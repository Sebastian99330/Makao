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
		index--;//bo komp liczy od 0 a nie 1 jak cz³owiek
		boolean keepAsking=false;
		if(index < 0 || index >= this.hand.size()){
			keepAsking=true;
		}
				
		while(keepAsking){
			keepAsking=false;
			System.out.print("Podales liczbe spoza zakresu. Jeszcze raz: ");
			index= keyboard.nextInt();
			keyboard.nextLine();
			index--;//bo komp liczy od 0 a nie 1 jak cz³owiek
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
	 * ta metoda rozni siê od ComputerPlayer'owej tym, ¿e tutaj pytamy u¿ytkownika co zrobiæ i czytamy z klawiatury opcje.
	 * dla Computera-gracza bêdzie to losowane.
	 */
	public boolean playCard(GameCard gameCard) {
		System.out.println("Gracz cz³owiek k³adzie kartê");

		boolean appropriate=true;
		int index;
		do{
			if(!appropriate){System.out.println("Podano numer karty ktorej nie mozna polozyc (nie pasuje kolor albo wysokoœæ).");}
			System.out.print("Ktora karte chcesz zagrac? ");
			index = askForIndex();	
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
		System.out.println("Poprawnie zagrano kartê.");
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
