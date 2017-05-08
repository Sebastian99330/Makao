
public class Card {
	String number;	//number or ace, king, queen, jack. Numer 1-10 albo as,król,królowa,walet
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
		for(Integer i=0;i<possibleNumbers.length;i++){	//lecimy po ca³ej tej tablicy
			if(number.equals(possibleNumbers[i])){	//i porównujemy czy któryœ z kolorów to ten co my chcemy ustawiæ
				this.number = number;	//jak tak to ustawiamy
				//System.out.println("Number setting succeeded");
				return true;	//i koczymy z sukcesem funkcjê
			}
		}
		
		System.out.println("Unavailible number set on a card.");		
		return false;
	}
	public String getSuit() {	return suit;	}
	
	
	///// OGARN¥Æ NA STACK OVERFLOW: USING SETTER WITH POSSIBLE VALUES ARRAY albo coœ takiego.
	public boolean setSuit(String suit) {
		String[] possibleSuits=getPossibleSuits();	//³apiemy do tablicy lokalnej mo¿liwe kolory
		for(Integer i=0;i<possibleSuits.length;i++){	//lecimy po ca³ej tej tablicy
			if(suit==possibleSuits[i]){	//i porównujemy czy któryœ z kolorów to ten co my chcemy ustawiæ
				this.suit = suit;	//jak tak to ustawiamy
				//System.out.println("Suit setting succeeded");
				return true;	//i koczymy z sukcesem funkcjê
			}
		}
		System.out.println("Unavailible suit set on a card!");
		return false;		
	}
	
	
}
