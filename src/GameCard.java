import java.util.*;

/*
 * GameCard to klasa reprezentuj�ca t� g��wn� kart� naszej gry, na kt�r� gracze k�ad� swoje karty w grze.
 */
public class GameCard {
	Vector<Card> gameCard;	//jest to wektor, bo niby wa�na jest tylko ostatnia karta, ale jak si� sko�cz� karty w decku
	//to wszystkie karty spod tej g��wnej wracaj� spowrotem (potasowane) do decka.
	
	GameCard(){
		gameCard=new Vector<Card>();
	}
	
	
	/*
	 * isAppropriateOnTop (albo druga opcja nazwy: doesSuitTop) wywo�ywana przy ka�dej pr�bie po�o�enia karty na szczyt.
	 * czy karta jest odpowiednia na szczyt? czy pr�bujemy po�o�y� dobr� kart�?
	 */
	public boolean IsAppropriateOnTop(Card tryCard){
		if((tryCard.number==gameCard.lastElement().number) || (tryCard.suit==gameCard.lastElement().suit)){
			return true;
		}
		
		return false;
	};
	
	
	/*
	 * putCard k�adzie kart� na "stos" (fizycznie w �yciu stos, tutaj vector) tej g��wnej karty graj�cej.
	 * B�d� jej u�ywa� gracze podaj�c w argumencie swoj� kart� kt�rej chc� u�y�, oraz na pocz�tku gry u�yjemy tej metody
	 * do wy�o�enia pierwszej karty.
	 */
	public void putCard(Card card){
		gameCard.add(card);
	}
	
	/*
	 * k�adzie pierwsz� kart� do gry. R�ni si� tym od putCard, �e pierwsza karta w grze musi by� mi�dzy 5 a 10. 
	 * K�adzie wi�c karty ze stosu tak d�ugo, a� karta b�dzie pasowa�.
	 */
	public void putFirstCard(Deck deck){
		do{
			this.putCard(deck.takeACard());	//najpierw wyk�ada pierwsz� kart� z decka, a jak ona nie b�dzie pasowa�
			//(nie b�dzie spe�niony warunek we whilu kt�ry j� sprawdza)
			//to robi to w k�ko (a� warunek b�dzie spe�niony).
		}while	(//otwiera while (oznaczam nawiasy bo straszny ba�agan jest w tym miejscu bez tego. I tak jest)
					!(	//otwiera negacj�
							this.top().number!="Jack" && this.top().number!="Queen" && this.top().number!="King" && this.top().number!="Ace"	//pierwsza po�o�ona karta ma nie by� kr�lem kr�low� itd
								&& (Integer.parseInt(this.top().number)>=5 && Integer.parseInt(this.top().number)<=10)	//i ma by� mi�dzy cyframi 5 a 10
					)//zamyka negacj� 
				);	//zamyka while
	}
	

	
	public Card top(){	//pokazuje t� g��wn� kart� na kt�r� gracze k�ad� swoj�
		return gameCard.lastElement();
	}
	
}
