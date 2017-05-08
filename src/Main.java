import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		System.out.println("No to zaczynamy...");
		Game g=new Game();
		System.out.println(g.gameCard.top());
		
		Player humanPlayer = new HumanPlayer(g.deck, "Sebson");
		Player computerPlayer=new ComputerPlayer(g.deck, "Kompiuter");
		Player mainPlayer=computerPlayer;
		boolean continuePlaying=true;
		while(continuePlaying){
			if(mainPlayer==humanPlayer){	//zamieniamy graczy bo na zmiane maj� wykonywa� ruchy
				//u�y� equalsa
				mainPlayer=computerPlayer;
			}
			else{
				mainPlayer=humanPlayer;
			}
			System.out.println();			
			System.out.println("----------------------------------------------------------");
			System.out.println("Ruch "+mainPlayer.getName());
			System.out.println("Karta top: "+g.gameCard.top());	//WY�WIETLAMY KARTE
			
			LinkedList<Card> availible=mainPlayer.getAvailibleCards(g.gameCard.top());
			if(availible.isEmpty()){
				mainPlayer.draw(g.deck);
				availible=mainPlayer.getAvailibleCards(g.gameCard.top());
				System.out.println("Dobrano kart�.");
			}

			System.out.println("Masz w reku: "+mainPlayer.hand.size()+" kart.");
			System.out.print("R�ka: ");
			mainPlayer.showHand();						//WY�WIETLAMY R�K�
			System.out.print("Mozesz zagrac: ");
			mainPlayer.showAvailibleCards(g.gameCard.top());	//RYSUJEMY MO�LIWE DO ZAGRANIA KARTY PO DOBRANIU
			
			if(!availible.isEmpty()){				
				System.out.println();
				continuePlaying=mainPlayer.playCard(g.gameCard);		//PYTAMY U�YTKOWIKA JAK� KARTE CHCE ZAGRA�
			}
			
		}
		System.out.println("**************************************");
		System.out.println("Gratulacje! Wygrywa gracz: ");
		mainPlayer.introduceYourself();
	}
}