# 3회차

## 목차
0. [Mydate 구현](#0.-Mydate-구현-;-입력값이-유효한-날짜인지-판단하기)
1. [참조형 변수](#1.-참조형-변수)
2. [this의 활용](#2.-this의-활용)
3. [static의 의미](#3.-static의-의미)
4. [클래스 변수 및 클래스 메서드](#4.-클래스-변수-및-클래스-메서드)
5. [싱글톤 패턴](#5.-싱글톤-패턴)
6. [객체간의 협력](#6.-객체간의-협력)

<br>

### 0. Mydate 구현 ; 입력값이 유효한 날짜인지 판단하기

- `MyDate.java`

	```java
	package date;

	public class MyDate {
		
		int	day;
		int	month;
		int	year;
		boolean	leapYear;
		int	lastDay;

		public	MyDate(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.leapYear = this.setLeapYear();
			this.lastDay = this.setLastDay();
		}
		
		private boolean	setLeapYear() {
			boolean isLeapYear = false;
			
			if (this.year > 0 && this.year % 4 == 0) {
				isLeapYear = true;
				if (this.year % 100 == 0 && this.year % 400 != 0) {
					isLeapYear = false;
				}
			}
			return isLeapYear;
		}
		
		private int	setLastDay() {
			int[]	day31 = {1, 3, 5, 7, 8, 10, 12};
			
			if (this.month ==2) {
				if (this.leapYear == true) {
					return 29;
				}
				return 28;
			}
			for(int i = 0; i < 7; i++) {
				if (this.month == day31[i])
					return 31;
			}
			return 30;
		}
		
		public String	isValid() {
			int	valid = 1;
			
			if (this.year < 1) {
				valid = 0;
			}
			if (this.month < 1 || this.month > 12) {
				valid = 0;
			}
			if (this.day < 1 || this.day > this.lastDay) {
				valid = 0;
			}
			if (valid == 0) {
				return("유효하지 않은 날짜입니다.");
			}
			else {
				return("유효한 날짜입니다.");
			}
		}

	}
	```   

- `MyDateTest.java`

	```java
	package date;

	public class MyDateTest {

		public static void main(String[] args) {
			
			MyDate date1 = new MyDate(30, 2, 2000);
			System.out.println(date1.isValid());
			MyDate date2 = new MyDate(2, 10, 2006);
			System.out.println(date2.isValid());

		}
	}
	```   

- 출력결과

	```
	유효하지 않은 날짜입니다.
	유효한 날짜입니다.
	```   

<br>

### 1. 참조형 변수
- 변수에는 크기가 정해진 기본 자료형(`int`, `double`, `boolean`, `char` 등)으로 선언하는 변수가 있고, 클래스 자료형(`String`, 직접 만든 클래스 등)으로 선언하는 참조 자료형 변수가 있다.
- 기본 자료형 변수에는 자료형에 맞는 실제 값이 저장된다. 예를 들어 `int i = 10;`로 선언된 변수 `i`가 있다면 `int`형의 크기인 4바이트의 공간이 할당되고, 그 공간에 정수 `10`이 저장되는 것이다.
- 하지만 참조형 변수는 이와 달리 주소값이 저장된다. 예를 들어 `Person jwoo = new Person();`처럼 클래스 Person 자료형 변수가 있다면, 이 변수에는 인스턴스의 주소값이 저장된다. 그래서 변수를 출력해보면 메모리 주소가 나오는 것을 알 수 있다.

- `BirthDay.java`

	```java
	package person;

	public class BirthDay {
		int	day;
		int	month;
		int	year;
	}
	```   

- `Person.java`

	```java
	package person;

	public class Person {
		String	name;
		int		id;
		BirthDay	birthDay = new BirthDay();
	}
	```   

- `PersonTest.java`

	```java
	package person;

	public class PersonTest {

		public static void main(String[] args) {
			Person jwoo = new Person();
			
			jwoo.name = "jwoo";
			jwoo.id = 20175966;
			jwoo.birthDay.day = 7;
			jwoo.birthDay.month = 6;
			jwoo.birthDay.year = 1997;
			
			System.out.println(jwoo);
			System.out.println(jwoo.name);
			System.out.println(jwoo.id);
			System.out.println(jwoo.birthDay.day + "/" + jwoo.birthDay.month + "/" + jwoo.birthDay.year);
		}
	}
	```   

- 출력 결과

	```
	person.Person@c2e1f26
	jwoo
	20175966
	7/6/1997
	```   



<br>

### 2. this의 활용
* `this` : 생성된 인스턴스 스스로를 가리키는 예약어

1. 자신의 메모리를 가르키는 `this`

	- `Birth.java`

		```java
		package thistest;

		import	date.MyDate;

		public class Birth {
			String	name;
			MyDate	birthDay;
			
			public Birth(String name) {
				this.name = name;
			}
			
			public void	printThis() {
				System.out.println(this);
			}
			
			public void	printName() {
				System.out.println("name : " + name);
				System.out.println("this.name : " + this.name);
			}
		}
		```   

	- `ThisTest.java`

		```java
		package thistest;

		public class ThisTest {

			public static void main(String[] args) {
				
				Birth	birthDay = new Birth("jwoo");
				
				System.out.println(birthDay);
				birthDay.printThis();
				System.out.println(birthDay.name);
				birthDay.printName();
			}
		}
		```   

	- 출력 결과

		```
		thistest.Birth@41975e01
		thistest.Birth@41975e01
		jwoo
		name : jwoo
		this.name : jwoo
		```   
	
	클래스 내에 `this`를 출력해주는 함수를 만들어둔다. `main()` 안에서 생성자로 새로운 인스턴스를 생성하고, 그 인스턴스를 가르키는 참조변수 `birthday`를 출력한 값과 `printThis()` 메서드를 통해 출력된 값은 동일하다. 그리고 `printName()` 을 통해 인스턴수 변수 `name`과 `this.name` 출력값 또한 동일하며, `this.name` 은 `birthday.name` 와 같은 의미임을 확인해볼 수 있다.

<br>

2. 생성자에서 다른 생성자를 호출하는 `this`

	- `Birth.java`

		```java
		package thistest;

		import	date.MyDate;

		public class Birth {
			String	name;
			MyDate	birthDay;
			
			public Birth() {
				this("jwoo");
			}
			
			public Birth(String name) {
				this.name = name;
			}
			
			public Birth(String name, MyDate birthDay) {
				this.name = name;
				this.birthDay = birthDay;
			}
		}
		```   

	- `ThisTest.java`

		```java
		package thistest;

		public class ThisTest {

			public static void main(String[] args) {
				
				Birth	birthDay1 = new Birth();
				Birth	birthDay2 = new Birth("jiwon");
				
				System.out.println(birthDay1.name);
				System.out.println(birthDay2.name);
			}
		}
		```   
	
	- 출력 결과

		```
		jwoo
		jiwon
		```   

	생성자가 여러개인 상황에서는 `this()`을 사용하여 다른 생성자를 호출할 수 있다. 위와 같은 경우 `this("jwoo")` 를 사용하면, `Birth(String name)`를 호출한 것이다.

<br>

3. 자신의 주소를 반환하는 `this`

	- `Birth.java`

		```java
		package thistest;

		import	date.MyDate;

		public class Birth {
			String	name;
			MyDate	birthDay;
			
			public Birth returnThis() {
				return(this);
			}
			
			public void printThis() {
				System.out.println(this);
			}
		}
		```   

	- `ThisTest.java`

		```java
		package thistest;

		public class ThisTest {

			public static void main(String[] args) {
				
				Birth birthDay = new Birth();
				
				System.out.println(birthDay);
				System.out.println(birthDay.returnThis());
				birthDay.printThis();
			}
		}
		```   

	- 출력 결과

		```
		thisTest.Birth@c2e1f26
		thisTest.Birth@c2e1f26
		thisTest.Birth@c2e1f26
		```   
	
	클래스 내에 `this`를 반환하는 함수와 출력해주는 함수를 만들어둔다. `main` 안에서 생성자로 새로운 인스턴스를 생성하고, 그 인스턴스를 가르키는 참조변수 `birthday`와 `this`를 반환해주는 `returnThis`의 리턴값을 출력해서 비교해보면 동일한 값이 출력되는 것을 알 수 있다. 메서드 내에서 `this`를 출력하는 `printThis` 함수 또한 같은 메모리 주소를 출력한다. `this` 가 생성된 인스턴스의 자신을 가리킨다는 것을 확인해볼 수 있다.

<br>

### 3. static의 의미
- 사전적으로 고정된, 정적인, 과 같은 의미를 갖고 있다.
- 같은 클래스로부터 생성된 인스턴스가 공유하는 변수를 static 변수라고 한다. 즉 클래스 전반에서 공통으로 사용하는 변수로, 객체가 아닌 클래스에 고정되어 있는 변수라는 의미다. (static 함수도 마찬가지)
- 선언된 static 멤버들은 heap 영역이 아니라 static 영역에 존재하기 때문에 GC가 메모리를 수거해주지 않는다. 따라서 static 변수를 너무 많이 사용하게 되면 성능이 떨어진다.

<br>

### 4. 클래스 변수 및 클래스 메서드

- 클래스 변수
	- 다른 멤버 변수(인스턴스 변수)처럼 클래스 내부에 선언하며, 앞에 `static` 예약어를 붙인다.
	- 일반 멤버 변수는 생성자에 의해 인스턴스가 생성될 때마다 힙 메모리 공간에 새로 생성되지만, 클래스 변수는 힙 메모리 영역이 아닌 데이터 영역에 프로그램 실행시 딱 한 번 생성된다.
	- 클래스 변수는 인스턴스명뿐만 아니라, 인스턴스 생성 여부와 상관없이 클래스명을 참조하여 사용할 수 있다.
	- 클래스 변수의 값은 같은 클래스에 의해 생성된 모든 인스턴스가 공유한다.

- 클래스 함수
	- 인스턴스 변수를 위한 메서드를 인스턴스 메서드라고 부르며, 인스턴스 메서드는 인스턴스가 생성될 때 만들어져, 인스턴스를 생성한 이후에 이용할 수 있다. 이처럼 클래스 변수를 활용하기 위한 메서드 또한 존재하는데, 이를 클래스 함수라 부른다. 클래스 변수처럼 함수 이름 앞에 `static` 예약어를 붙인다.
	- 인스턴스 메서드와 달리 인스턴스를 생성하지 않고도 사용가능하며, 인스턴스 생성 여부와 상관없이 클래스명을 참조하여 사용한다.
	- 클래스 함수 내에서는 인스턴스 생성 후에 호출할 수 있는 인스턴스 변수를 활용하면 오류가 발생하니 주의할 것. 반대로 인스턴스 메서드에서 클래스 변수를 사용하는 건 문제가 되지 않는다.

<br>

### 5. 싱글톤 패턴

- 싱글톤 패턴은 프로그램에서 인스턴스를 딱 하나만 구현하는 디자인 패텬이다. 이전에 공부한 접근제어자와 static을 활용하여 싱글톤 패턴을 구현할 수 있다.

- `SingleTone.java`

	```java
	package constructor;

	public class SingleTone {
		private static SingleTone singletone = new SingleTone();
		private SingleTone() {};
		
		public static SingleTone getInstance() {
			if (singletone == null) {
				singletone = new SingleTone();
			}
			return singletone;
		}
	}
	```   

	우선, 생성자를 private으로 선언한다. private이므로 이 생성자는 클래스 내에서만 활용할 수 있다. 즉 외부에서는 생성자를 통해 새로운 인스턴스를 만들 수 없는 것이다. 그러므로 클래스 내에서 인스턴스를 생성하고, 이 인스턴스를 클래스 변수가 가리키게 한다. 그러면 이 인스턴스는 프로그램 내에서 SingleTone 클래스의 유일한 인스턴스가 된다.

- `ConstructorTest.java`

	```java
	package constructor;

	public class ConstructorTest {

		public static void main(String[] args) {

			SingleTone single1 = SingleTone.getInstance();
			SingleTone single2 = SingleTone.getInstance();
			System.out.println(single1);
			System.out.println(single2);
			System.out.println(single1 == single2);
			System.out.println(single1.equals(single2));
		}
	}
	```   

- 출력 결과
	```
	constructor.SingleTone@1ee0005
	constructor.SingleTone@1ee0005
	true
	true
	```   

외부 클래스에서는 SingleTone 클래스의 인스턴스를 생성할 수 없으므로, public으로 선언한 `getInstance()` 함수를 통해 인스턴스의 메모리 주소를 확인해본다. `single1`과 `single2`에 모두 같은 메모리 주소가 저장되어있음을 알 수 있다. 즉, SingleTone 클래스의 인스턴스는 유일하다.

<br>

### 6. 객체간의 협력

- 학생이 스타벅스에 가서 커피를 사먹는다면?

- `Starbucks.java`

	```java
	package cooperation;

	public class Starbucks {
		static int	storeNumber;
		String	storeName;
		int orderNumber;
		int	money;
		int coffeeBean;
		boolean	open;
		
		public	Starbucks (String name) {
			storeNumber++;
			this.storeName = name.concat(Integer.toString(storeNumber));
			this.orderNumber = 0;
			this.money = 1000000;
			this.coffeeBean = 100;
			this.open = true;
		}
		
		public int	howMuch(int cup) {
			if (cup <= 0)
			{
				System.out.println("커피는 1잔 이상만 주문할 수 있습니다.");
				return -1;
			}
			if (this.coffeeBean == 0)
			{
				System.out.println("재료가 다 소진되었습니다.");
				return 0;
			}
			if (this.coffeeBean < cup)
			{
				System.out.println("주문하신 양보다 재료가 부족합니다.");
				return -1;
			}
			System.out.println("주문하신 커피 " + cup + "잔은 총 " + 4100 * cup + "원 입니다.");
			return 4100 * cup;
		}
		
		public int	makeCoffee(int cup) {
			this.orderNumber++;
			this.coffeeBean -= cup;
			this.money += 4100 * cup;
			System.out.println("주문번호 "+ this.orderNumber + "님 주문하신 커피 " + cup + "잔이 제조되었습니다!");
			return this.orderNumber;
		}
		
		public void	orderCoffeeBean(int order) {
			if (order <= 0)
			{
				System.out.println("커피 원두는 하나 이상만 주문할 수 있습니다.");
				return;
			}
			if (this.money < 500 * order)
			{
				System.out.println("스타벅스의 예산이 부족합니다.");
				return;
			}
			this.coffeeBean += order;
			this.money -= 500 * order;
			System.out.println("커피 원두 " + order + " 개를 주문 완료하였습니다.");
		}
		
		public boolean	isOpen() {
			if (this.open == true) {
				System.out.println(this.storeName + " 스타벅스가 영업 중입니다.");
			}
			else {
				System.out.println(this.storeName + " 스타벅스가 영업이 종료되었습니다.");
			}
			return this.open;
		}
		
		public void	showInfo() {
			this.isOpen();
			System.out.println(this.storeName + " 스타벅스의 잔고는 " + this.money + "원, 커피 원두 재고는 " + this.coffeeBean + "개 남았습니다.");
		}

	}
	```   

- `Student.java`

	```java
	package cooperation;

	public class Student {
		public String	studentName;
		public int	money;
		public int	lastOrderNumber;
		public int	drinkCoffee;
		
		public Student(String studentName, int money) {
			this.studentName = studentName;
			this.money = money;
			this.lastOrderNumber = 0;
		}
		
		public void buyStarbucks(Starbucks starbucks, int cup) {
			int	price;
			
			if (starbucks.isOpen() == false) {
				System.out.println("커피를 살 수 없습니다.");
				return;
			}
			price = starbucks.howMuch(cup);
			if (price == -1) {
				System.out.println("다시 주문해주세요.");
				return;
			}
			if (price == 0) {
				System.out.println("다음에 다시 방문해주세요.");
				return;
			}
			if (this.money < price) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			this.drinkCoffee += cup;
			this.money -= price;
			this.lastOrderNumber = starbucks.makeCoffee(cup);
		}
		
		public void	showInfo() {
			System.out.println("현재 " + this.studentName + "이(가) 가지고 있는 금액은 " + this.money + "원 입니다.");
			System.out.println("현재 " + this.studentName + "은(는) 커피를 " + this.drinkCoffee + "잔 마셨습니다.");
		}

	}
	```   

- `CooperationTest.java`

	```java
	package cooperation;

	public class CooperationTest {

		public static void main(String[] args) {
			Starbucks GaepoStarbucks = new Starbucks("Gaepo");
			Starbucks SeochoStarbucks = new Starbucks("Seocho");
			Student jwoo = new Student("jwoo", 20000);
			
			jwoo.buyStarbucks(SeochoStarbucks, 1);
			jwoo.showInfo();
			System.out.println();
			jwoo.buyStarbucks(GaepoStarbucks, 2);
			jwoo.showInfo();
			System.out.println();
			jwoo.buyStarbucks(GaepoStarbucks, 2);
			jwoo.showInfo();
			System.out.println();
			jwoo.buyStarbucks(SeochoStarbucks, 1);
			jwoo.showInfo();
			System.out.println();
			jwoo.buyStarbucks(SeochoStarbucks, 1);
			jwoo.showInfo();
			System.out.println();
			GaepoStarbucks.showInfo();
			SeochoStarbucks.showInfo();
		}

	}
	```   

- 출력 결과
	```
	Seocho2 스타벅스가 영업 중입니다.
	주문하신 커피 1잔은 총 4100원 입니다.
	주문번호 1님 주문하신 커피 1잔이 제조되었습니다!
	현재 jwoo이(가) 가지고 있는 금액은 15900원 입니다.
	현재 jwoo은(는) 커피를 1잔 마셨습니다.

	Gaepo1 스타벅스가 영업 중입니다.
	주문하신 커피 2잔은 총 8200원 입니다.
	주문번호 1님 주문하신 커피 2잔이 제조되었습니다!
	현재 jwoo이(가) 가지고 있는 금액은 7700원 입니다.
	현재 jwoo은(는) 커피를 3잔 마셨습니다.

	Gaepo1 스타벅스가 영업 중입니다.
	주문하신 커피 2잔은 총 8200원 입니다.
	잔액이 부족합니다.
	현재 jwoo이(가) 가지고 있는 금액은 7700원 입니다.
	현재 jwoo은(는) 커피를 3잔 마셨습니다.

	Seocho2 스타벅스가 영업 중입니다.
	주문하신 커피 1잔은 총 4100원 입니다.
	주문번호 2님 주문하신 커피 1잔이 제조되었습니다!
	현재 jwoo이(가) 가지고 있는 금액은 3600원 입니다.
	현재 jwoo은(는) 커피를 4잔 마셨습니다.

	Seocho2 스타벅스가 영업 중입니다.
	주문하신 커피 1잔은 총 4100원 입니다.
	잔액이 부족합니다.
	현재 jwoo이(가) 가지고 있는 금액은 3600원 입니다.
	현재 jwoo은(는) 커피를 4잔 마셨습니다.

	Gaepo1 스타벅스가 영업 중입니다.
	Gaepo1 스타벅스의 잔고는 1008200원, 커피 원두 재고는 98개 남았습니다.
	Seocho2 스타벅스가 영업 중입니다.
	Seocho2 스타벅스의 잔고는 1008200원, 커피 원두 재고는 98개 남았습니다.
	```   
