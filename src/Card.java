
public class Card {
	String number;	//number or ace, king, queen, jack. Numer 1-10 albo as,kr�l,kr�lowa,walet
	String suit;	//
	
	//default constructor
	public Card(String number, String suit) {
		setNumber(number);
		setSuit(suit);
	}
	
	public static String[] getPossibleSuits(){
		String[] suits={"Hearts","Diamond","Spades","Clubs"};	//kolejno: kier, karo, pik, trefl
		return suits;
	}

	public static String[] getPossibleNumbers(){
		String[] ranks={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		return ranks;
	}
	
	
	@Override
	public String toString() {
		return "[" + number + ", " + suit + "]";
	}

	public String getNumber() {	return number;	}
	public boolean setNumber(String number) {	
		String[] possibleNumbers=getPossibleNumbers();
		for(Integer i=0;i<possibleNumbers.length;i++){	//lecimy po ca�ej tej tablicy
			if(number.equals(possibleNumbers[i])){	//i por�wnujemy czy kt�ry� z kolor�w to ten co my chcemy ustawi�
				this.number = number;	//jak tak to ustawiamy
				//System.out.println("Number setting succeeded");
				return true;	//i koczymy z sukcesem funkcj�
			}
		}
		
		System.out.println("Unavailible number set on a card.");		
		return false;
	}
	public String getSuit() {	return suit;	}
	
	
	///// OGARN�� NA STACK OVERFLOW: USING SETTER WITH POSSIBLE VALUES ARRAY albo co� takiego.
	public boolean setSuit(String suit) {
		String[] possibleSuits=getPossibleSuits();	//�apiemy do tablicy lokalnej mo�liwe kolory
		for(Integer i=0;i<possibleSuits.length;i++){	//lecimy po ca�ej tej tablicy
			if(suit==possibleSuits[i]){	//i por�wnujemy czy kt�ry� z kolor�w to ten co my chcemy ustawi�
				this.suit = suit;	//jak tak to ustawiamy
				//System.out.println("Suit setting succeeded");
				return true;	//i koczymy z sukcesem funkcj�
			}
		}
		System.out.println("Unavailible suit set on a card!");
		return false;		
	}
	
	
}
