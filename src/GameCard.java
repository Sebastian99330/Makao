import java.util.*;

/*
 * GameCard to klasa reprezentuj¹ca t¹ g³ówn¹ kartê naszej gry, na któr¹ gracze k³ad¹ swoje karty w grze.
 */
public class GameCard {
	Vector<Card> gameCard;	//jest to wektor, bo niby wa¿na jest tylko ostatnia karta, ale jak siê skoñcz¹ karty w decku
	//to wszystkie karty spod tej g³ównej wracaj¹ spowrotem (potasowane) do decka.
	
	GameCard(){
		gameCard=new Vector<Card>();
	}
	
	
	/*
	 * isAppropriateOnTop (albo druga opcja nazwy: doesSuitTop) wywo³ywana przy ka¿dej próbie po³o¿enia karty na szczyt.
	 * czy karta jest odpowiednia na szczyt? czy próbujemy po³o¿yæ dobr¹ kartê?
	 */
	public boolean IsAppropriateOnTop(Card tryCard){
		if((tryCard.number==gameCard.lastElement().number) || (tryCard.suit==gameCard.lastElement().suit)){
			return true;
		}
		
		return false;
	};
	
	
	/*
	 * putCard k³adzie kartê na "stos" (fizycznie w ¿yciu stos, tutaj vector) tej g³ównej karty graj¹cej.
	 * Bêd¹ jej u¿ywaæ gracze podaj¹c w argumencie swoj¹ kartê której chc¹ u¿yæ, oraz na pocz¹tku gry u¿yjemy tej metody
	 * do wy³o¿enia pierwszej karty.
	 */
	public void putCard(Card card){
		gameCard.add(card);
	}
	
	/*
	 * k³adzie pierwsz¹ kartê do gry. Ró¿ni siê tym od putCard, ¿e pierwsza karta w grze musi byæ miêdzy 5 a 10. 
	 * K³adzie wiêc karty ze stosu tak d³ugo, a¿ karta bêdzie pasowaæ.
	 */
	public void putFirstCard(Deck deck){
		do{
			this.putCard(deck.takeACard());	//najpierw wyk³ada pierwsz¹ kartê z decka, a jak ona nie bêdzie pasowaæ
			//(nie bêdzie spe³niony warunek we whilu który j¹ sprawdza)
			//to robi to w kó³ko (a¿ warunek bêdzie spe³niony).
		}while	(//otwiera while (oznaczam nawiasy bo straszny ba³agan jest w tym miejscu bez tego. I tak jest)
					!(	//otwiera negacjê
							this.top().number!="Jack" && this.top().number!="Queen" && this.top().number!="King" && this.top().number!="Ace"	//pierwsza po³o¿ona karta ma nie byæ królem królow¹ itd
								&& (Integer.parseInt(this.top().number)>=5 && Integer.parseInt(this.top().number)<=10)	//i ma byæ miêdzy cyframi 5 a 10
					)//zamyka negacjê 
				);	//zamyka while
	}
	

	
	public Card top(){	//pokazuje t¹ g³ówn¹ kartê na któr¹ gracze k³ad¹ swoj¹
		return gameCard.lastElement();
	}
	
}
