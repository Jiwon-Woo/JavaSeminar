# 2회차

## 목차
1. [인스턴스](#1.-인스턴스)
2. [생성자와 생성자 오버로딩](#2.-생성자와-생성자-오버로딩)
3. [참조변수와 참조값](#3.-참조변수와-참조값)
4. [스태틱](#4.-스태틱)
5. [T 메모리 구조](#5.-T-메모리-구조)
6. [접근 제어자와 정보 은닉](#6.-접근-제어자와-정보-은닉)
7. [캡슐화](#7.-캡슐화)
<!-- 8. String -->

<br>

### 1. 인스턴스
- 클래스를 생성한다는 것은 클래스를 실제로 사용할 수 있도록 메모리 공간을 할당받는 것이다. 이때 사용하는 메모리 공간은 힙 메모리이다.
- 인스턴스는 클래스가 메모리 공간에 생성된 상태, 혹은 실제로 생성된 클래스를 의미한다.
- 생성된 클래스의 인스턴스를 객체라고도 한다.
- 인스턴스를 생성하는 코드
	```java
	[클래스 형] [참조 변수] = new [생성자];
	```   

<br>

### 2. 생성자와 생성자 오버로딩
- 생성자는 클래스를 생성할 때 멤버 변수를 초기화 하는 역할을 하며, 클래스를 생성할 때만 호출된다.
- 생성자의 이름은 클래스의 이름과 동일하며, 반환값은 없다. 예를 들어 `Student` 클래스의 생성자 이름은 `Student()` 이고, 매개변수는 프로그래머의 설정에 따른다.
- 클래스 내에 생성자를 선언하지 않았다면 디폴트 생성자가 자동으로 생성되는데, 이때 디폴트 생성자는 매개변수가 없다.
- 필요에 따라 매개변수가 다른 생성자를 여러개 만들 수 있다. 이처럼 생성자가 2개 이상 제공되는 경우를 생성자 오버로드라고 한다.
	* 오버로드(overload) : 객체 지향 프로그램에서 메서드 이름이 같고 매개변수만 다른 경우

<br>

### 2.5 생성자가 있는 클래스 만들기
- `Person` 클래스 만들기

	```java
	package classpart;

	public class Person {
		String	name;
		int		height;
		double	weight;
		char	gender;
		boolean	married;
		int		child;
		int		age;

		/* 생성자 1 */
		public Person() {};

		/* 생성자 2 */
		public Person(String name) {
			this(name, 0);
		};	// this(name, 0) == Person(name, age)
			// 만들어둔 또다른 생성자, '생성자 3'를 활용

		/* 생성자 3 */
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		};

		Person returnItSelf() {
			return this;
		}	// 자기 자신을 반환하는 메서드
			// 반환값을 출력해보면 인스턴스의 메모리 주소가 담겨있음

		public void setPersonInfo(String name, int age) {
			this.name = name;
			this.age = age;
		}	// 오버로드

		public void setPersonInfo(int height, double weight) {
			this.height = height;
			this.weight = weight;
		}	// 오버로드

		public void setPersonFamily(boolean married, int child) {
			this.married = married;
			this.child = child;
		}

		public void printPersonInfo() {
			System.out.println("age : " + this.age);
			System.out.println("name : " + this.name);
			System.out.println("married : " + this.married);
			System.out.println("child : " + this.child);
		}
	}
	```   
	* `this` : 생성된 인스턴스 스스로를 가리키는 예약어

<br>

### 3. 참조변수와 참조값
- 인스턴스를 생성하는 코드
	```java
	Student jwoo = new Student();
	```   
- `new` 예약어와 `Student` 클래스의 생성자 `Student()` 를 이용하여, 학생 인스턴스(또는 학생 객체)를 생성한다.
- `Student` 클래스 자료형으로 선언한 `jwoo` 라는 변수는 이 인스턴스의 메모리 주소를 가르키고 있다.
- 이렇게 인스턴스를 가르키는 클래스형 변수를 참조 변수라고 하며, 참조 변수에 담겨있는 인스턴스의 주소 값을 참조 값이라고 한다.

<br>

### 3.5 인스턴스를 생성하여 활용해보기

- 하나의 클래스를 사용하여 여러개의 인스턴스를 생성해보기

	```java
	Student student1 = new Student();
	Student student2 = new Student();
	Person	woo = new Person();
	Person	jiwon = new Person("jiwon");
	Person	jiwonWoo = new Person("jiwon woo", 25);
	```   
	- `student1`, `student2` 는 모두 동일한 클래스, 동일한 생성자로부터 생성되었지만, 멤버 변수의 값은 모두 다를 수 있다.
	- `woo`, `jiwon`, `jiwonWoo` 는 모두 동일한 클래스로부터 생성되었지만, 멤버 변수의 값은 모두 다르게 설정되었다.
	- 실제와 비교했을 때, 사람이나 학생이라는 추상어는 뜻이 하나이지만, 개개인은 여러명인 것과 같다.

<br>

- 인스턴스를 생성하고 활용해보기

	```java
	package classpart;

	public class MainTest {
		public static void main(String[] args) {
			Person	james = new Person("James", 40);
			Person	man = new Person("Man");
			
			james.setPersonFamily(true, 3);
			man.setPersonFamily(false, 1);
			james.printPersonInfo();
			System.out.println("-------------");
			man.printPersonInfo();
			System.out.println("-------------");
			System.out.println(man.returnItSelf());
			System.out.println(james.returnItSelf());
		}
	}
	```   
<br>

### 4. 스태틱
- 스태틱 변수
	- 다른 멤버 변수(인스턴스 변수)처럼 클래스 내부에 선언하며, 앞에 `static` 을 붙인다.
	- 스태틱이 아닌 일반 멤버 변수는 생성자에 의해 인스턴스가 생성될 때마다 힙 메모리 공간에 새로 생성되지만, 스태틱 변수는 힙 메모리 영역이 아닌 데이터 영역에 프로그램 실행시 딱 한 번 생성된다.
	- 스태틱 변수는 인스턴스 변수와 달리 인스턴스명이 아니라, 클래스명을 참조하여 사용할 수 있다.
	- 스태틱 변수의 값은 같은 클래스에 의해 생성된 모든 인스턴스가 공유한다.
- 스태틱 함수
	- 일반 멤버 변수를 위한 메서드를 인스턴스 메서드라고 부르며, 인스턴스 메서드는 인스턴스가 생성될 때 만들어져, 인스턴스를 생성한 이후에 이용할 수 있다.
	- 스태틱 변수를 활용하기 위한 메서드 또한 존재하는데, 이를 스태틱 함수라 부른다. 변수처럼 함수 이름 앞에 `static`을 붙인다.
	- 인스턴스 메서드와 달리, 인스턴스를 생성하지 않고도 사용가능하며, 클래스명을 참조하여 사용한다.
	- 스태틱 함수 내에서는 인스턴스 생성 후에 사용할 수 있는 인스턴스 변수를 활용하면 오류가 발생하니 주의할 것

<br>

### 5. T 메모리 구조
- `stack` 영역   
	- 스태틱이 아닌 함수와 지역변수가 사용하는 메모리 공간이다.
	- LIFO 구조로, 호출되는 함수 순서대로 스택에 쌓이며, 맨 마지막에 호출된 함수부터 반환된다.
	- 함수는 각자 다른 스택 메모리 공간을 부여받기 때문에 각 함수의 지역변수끼리는 이름이 같아도 상관없다.
	- 메서드가 종료되는 순간 함수에 할당되었던 메모리 공간은 자동으로 해제된다.
- `heap` 영역   
	- 동적 메모리 공간으로, 인스턴스(인스턴스 변수 및 인스턴스 메소드)를 저장하는 공간이다.
	- C언어와 달리 java에서는 Garbage Collector가 자동으로 메모리를 해제해준다.
	- 생성자를 호출하면, 인스턴스의 메모리 주소를 가리키는 참조변수는 스택 메모리에, 인스턴스는 힙 메모리에 생성된다.
	- 인스턴스들은 각자 다른 힙 메모리 공간에 생성되기 때문에 각 인스턴스의 멤버 변수는 서로 간섭이 없다.
- `static` 영역 (데이터 영역)   
	- 클래스와 스태틱 변수 및 메서드, 상수와 문자열이 생성되는 공간이다.
	- 인스턴스가 힙메모리에 생성되는 것과는 관련없이 스태틱 변수와 함수는 프로그램 처음부터 이 메모리에 생성되므로, 인스턴스 생성 없이도 스태틱 변수와 함수를 활용할 수 있는 것이다.

<br>

### 6. 접근 제어자와 정보 은닉
- 변수나 메서드, 생성자에 대한 접근 권한을 지정해줄 수 있는 예약어   
- 접근 제어자의 종류

	|접근 제어자|설명|
	|:--:|:--:|
	|`public`|외부/내부 클래스 어디에서나 접근 가능|
	|`protected`|같은 클래스 내부와 상속 관계의 클래스에서만 접근 가능|
	|`private`|같은 클래스 내부에서만 접근 가능|
	|아무것도 없는 경우|디폴트. 같은 클래스 내부에서만 접근 가능|

- 클래스 내부에서 사용할 변수와 메서드를 `private`으로 선언하여 외부에서의 접근을 막는 것을 정보은닉이라고 한다.
- `private`으로 선언한 변수, 메서드, 클래스를 외부에서 사용하려면, 값을 얻는 `get()` 메서드와 값을 설정해주는 `set()` 메서드를 활용하면 된다.

<br>

### 7. 캡슐화
- 객체의 속성과 기능(연관있는 변수와 메서드)를 하나의 클래스로 묶는 작업을 말한다. 단순히 클래스를 만드는 작업을 넘어 실제 구현내용을 외부에 감추는 의미까지 포함하고 있는 것이 캡슐화이다.
- 외부 객체는 객체의 내부 구조를 알 수 없으며, 객체가 노출하는 변수와 메소드만 이용가능하다. 어떤 것을 노출할지는 접근 제어자를 활용하여 결정한다.
- 캡슐화 된 객체는 정보 은닉되어 있기 때문에 외부에 의해 변경이 발생할 때 오류가 발생할 확률이 낮아진다.
	- 변수를 `public`으로 선언하는 것과 `private`으로 선언한 뒤 `public` 메소드를 제공하는 것의 차이