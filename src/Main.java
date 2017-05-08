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
			if(mainPlayer==humanPlayer){	//zamieniamy graczy bo na zmiane maj¹ wykonywaæ ruchy
				//u¿yæ equalsa
				mainPlayer=computerPlayer;
			}
			else{
				mainPlayer=humanPlayer;
			}
			System.out.println();			
			System.out.println("----------------------------------------------------------");
			System.out.println("Ruch "+mainPlayer.getName());
			System.out.println("Karta top: "+g.gameCard.top());	//WYŒWIETLAMY KARTE
			
			LinkedList<Card> availible=mainPlayer.getAvailibleCards(g.gameCard.top());
			if(availible.isEmpty()){
				mainPlayer.draw(g.deck);
				availible=mainPlayer.getAvailibleCards(g.gameCard.top());
				System.out.println("Dobrano kartê.");
			}

			System.out.println("Masz w reku: "+mainPlayer.hand.size()+" kart.");
			System.out.print("Rêka: ");
			mainPlayer.showHand();						//WYŒWIETLAMY RÊKÊ
			System.out.print("Mozesz zagrac: ");
			mainPlayer.showAvailibleCards(g.gameCard.top());	//RYSUJEMY MO¯LIWE DO ZAGRANIA KARTY PO DOBRANIU
			
			if(!availible.isEmpty()){				
				System.out.println();
				continuePlaying=mainPlayer.playCard(g.gameCard);		//PYTAMY U¯YTKOWIKA JAK¥ KARTE CHCE ZAGRAÆ
			}
			
		}
		System.out.println("**************************************");
		System.out.println("Gratulacje! Wygrywa gracz: ");
		mainPlayer.introduceYourself();
	}
}