# Subject 02

### Card 클래스

```java
package array;

public class Card {
	
	private static int serialNumber = 1000;
	private int	cardNumber;
	
	public Card	() {
		this.cardNumber = ++serialNumber;
	}
	
	public int getCardNumber() {
		return this.cardNumber;
	}

}
```   

<br>

### CardCompany 클래스

```java
package array;

public class CardCompany {
	
	static private CardCompany companyInstance = new CardCompany();
	
	private	CardCompany() { }
	
	public static CardCompany	getCompanyInstance() {
		return companyInstance;
	}
	
	public static Card	createCard() {
		return new Card();
	}

}
```   

<br>

### main()

```java
package array;
import java.util.ArrayList;

public class CardTest {

	public static void main(String[] args) {
		
		CardCompany cardCompany = CardCompany.getCompanyInstance();
		ArrayList<Card> wallet = new ArrayList<Card>();
		
		System.out.println(CardCompany.getCompanyInstance());
		System.out.println(cardCompany);
		System.out.println();
		
		wallet.add(CardCompany.createCard());
		wallet.add(CardCompany.createCard());
		wallet.add(CardCompany.createCard());
		
		for (Card card : wallet) {
			System.out.println(card + ", " + card.getCardNumber());
		}
	}
}
```   

<br>

### 출력 결과

```
array.CardCompany@41975e01
array.CardCompany@41975e01

array.Card@3d012ddd, 1001
array.Card@6f2b958e, 1002
array.Card@1eb44e46, 1003
```   