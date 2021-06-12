# 2회차

## 목차
1. [인스턴스](1.-인스턴스)
2. [생성자와 생성자 오버로딩](#2.-생성자와-생성자-오버로딩)
3. [참조변수와 참조값](#4.-참조변수와-참조값)
4. [정보은닉과 캡슐화](#6.-정보은닉과-캡슐화)
5. [접근 제어자](7.-접근-제어자)
6. [스태틱 함수와 인스턴스 함수](8.-스태틱-함수와-인스턴스-함수)
7. String

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

### 3. 생성자가 있는 클래스 만들기
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

### 4. 참조변수와 참조값
- 인스턴스를 생성하는 코드
	```java
	Student jwoo = new Student();
	```   
- `new` 예약어와 `Student` 클래스의 생성자 `Student()` 를 이용하여, 학생 인스턴스(또는 학생 객체)를 생성한다.
- `Student` 클래스 자료형으로 선언한 `jwoo` 라는 변수는 이 인스턴스의 메모리 주소를 가르키고 있다.
- 이렇게 인스턴스를 가르키는 클래스형 변수를 참조 변수라고 하며, 참조 변수에 담겨있는 인스턴스의 주소 값을 참조 값이라고 한다.

<br>

### 5. 인스턴스를 생성하여 활용해보기
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

### 5.