# 1회차
## 객체 / 클래스 / 함수 / 메서드
<br>

### 0. java 의 특징

#### 1) 객체 지향
- 자바는 객체 지향 언어로, 객체 지향 프로그래밍을 할 수 있다.
- 객체 지향 프로그래밍이란, 객체를 정의하고, 객체간 협력을 프로그래밍하는 것이다. 즉, 객체를 만들고, 객체 사이에 일어나는 일을 구현하는 프로그래밍이다.

<br>

#### 2) Write Once, Run Anywhere
- 자바는 플랫폼에 종속되지 않는 프로그램을 만들 수 있다.
- **예를 들어 C언어로 만든 프로그램이 있다. 이 프로그램을 컴파일하게 되면 만들어진 실행파일은 컴파일한 운영체제에 맞게 만들어진다. 만약 Mac에서 컴파일했다면 이 실행파일은 Window에서 실행할 수 없다.**
- 이와 달리 java 파일을 컴파일하면, 1차적으로 class 파일이 생성되는데, 이 파일을 바이트 코드라고 한다.
- 바이트 코드는 운영체제에 맞는 완벽한 기계어가 아닌 중간 기계어로, C언어의 실행파일처럼 바로 실행시킬 수 없다.
- 이 바이트 코드를 실행하려면 운영체제에 맞는 자바 가상 머신이 필요하다. 자바 가상 머신은 바이트 코드를 운영체제에 맞는 실행파일로 바꿔준다.
- 즉 자바 가상머신과 class 파일만 있다면, 어느 환경에서나 실행파일을 실행시킬 수 있다.

<br>

#### 3) java project의 구조
- [워크스페이스/프로젝트/패키지/클래스의 개념 및 명명 규칙](https://codevang.tistory.com/76)
- java는 C언어와 달리 계층 구조가 명확한 편이다. 대략적인 폴더 구조는 아래와 같다.

	```
	|- workspace

		|- project1 `Practice`
			|- bin
				|- package1 `one`
					|- class `A.class`
					|- class `B.class`
					|- class `C.class`
				|- package2 `two`
					|- class `A.class`
					|- class `B.class`
					|- class `C.class`
			|- src
				|- package1 `one`
					|- class `A.java`
					|- class `B.java`
					|- class `C.java`
				|- package2 `two`
					|- class `A.java`
					|- class `B.java`
					|- class `C.java`

		|- project2 `Practice`
			|- bin
				|- package1 `zero`
					|- package1_1 `zeroOne`
						|- class `test.class`
					|- package1_2 `zeroTwo`
						|- class `test.class`
			|- src
				|- package1 `zero`
					|- package1_1 `zeroOne`
						|- class `test.java`
					|- package1_2 `zeroTwo`
						|- class `test.java`
	```   
	- workspace : 하나의 프로그램 단위
	- project : 하나의 실행파일 단위
	- package : 클래스를 기능별로 묶어둔 일종의 카테고리로, 하나만 있을 수도 있고, 상위/하위 패키지로 나눌 수도 있다.
	- class : 비슷한 유형의 메소드와 변수를 모아놓은 소스 코드
	- `src` 폴더 안에 패키지와 클래스가 있어야 하며, 1차적으로 컴파일 된 class파일은 `bin` 폴더 안에 저장된다.

<br>

#### 4) Shell 에서 java 컴파일 하기
- class 파일 만들기
	```
	javac [파일명].java
	```
- class 파일 실행하기
	```
	java [파일명]
	```


<br>

### 1. 객체
- (눈에 보이는) 모든 사물 + 어떤 행동을 나타내는 단어 = 어떤 대상
- 예를 들어, 자동차, 사람, 주문, 생산 모두 객체라고 할 수 있다.
- 객체는 클래스를 정의함으로써 프로그램에 구현할 수 있다.

<br>

### 2. 클래스
- 객체의 속성과 기능을 코드로 구현한 것을 클래스라고 한다.
- 위와 같은 일을 클래스를 정의한다고 표현한다.
- 클래스를 정의하려면, 클래스 이름, 속성 및 특성(멤버 변수), 기능(메서드)이 필요하다.

<br>

### 3. 함수
- 함수는 하나의 기능을 수행하는 일련의 코드를 의미한다.
- 함수를 나누지 않고 `main()`에 모두 써놓아도 작동하지만, 함수를 사용하는 편이 더 효율적이다.
- 함수를 사용하면 한 눈에 보기도 편하며, 특정 기능이 필요할 때마다 함수를 호출하여 중복코드를 방지할 수도 있다. 그리고 오류를 수정하기에도 용이하다.

<br>

### 4. 메서드
- 메서드는 함수의 한 종류로, 함수에 객체 지향 개념이 포함된 용어이다.
- 메서드는 클래스의 멤버 변수(객체 속성을 나타내는 변수)를 활용하여 클래스의 기능을 구현한다.

<br>

### 5. 객체를 클래스로 구현해보기

- 멤버 변수와 메서드가 있는 `Student` 클래스 만들기

	```java
	package classpart;
	
	public class Student {
		/* 멤버 변수 */
		int		id;
		String	name;
		int		grade;
		String	address;
		// 학번, 이름, 성적, 주소 등 모두 'Student'의 속성을 나타내는 변수


		/* 메서드 */
		public void showStudentInfo() {
			System.out.println(name + ',' + address);
		} // 멤버 변수를 활용하여 학생의 정보를 출력하는 기능을 하는 메서드

		public String getStudentName() {
			return name;
		} // 학생의 이름을 반환해주는 메서드

		public void setStudentName(String studentName) {
			name = studentName;
		} // 학생의 이름을 설정해주는 메서드
	}
	```   

<br>

### 6. 인스턴스
- 클래스를 생성한다는 것은 클래스를 실제로 사용할 수 있도록 메모리 공간을 할당받는 것이다. 이때 사용하는 메모리 공간은 힙 메모리이다.
- 인스턴스는 클래스가 메모리 공간에 생성된 상태, 혹은 실제로 생성된 클래스를 의미한다.
- 생성된 클래스의 인스턴스를 객체라고도 한다.
- 인스턴스를 생성하는 코드
	```java
	[클래스 형] [변수 이름] = new [생성자];
	```   

<br>

### 7. 생성자
- 생성자는 클래스를 생성할 때 멤버 변수를 초기화 하는 역할을 하며, 클래스를 생성할 때만 호출된다.
- 생성자의 이름은 클래스의 이름과 동일하며, 반환값은 없다. 예를 들어 `Student` 클래스의 생성자 이름은 `Student()` 이고, 매개변수는 프로그래머의 설정에 따른다.
- 클래스 내에 생성자를 선언하지 않았다면 디폴트 생성자가 자동으로 생성되는데, 이때 디폴트 생성자는 매개변수가 없다.
- 필요에 따라 매개변수가 다른 생성자를 여러개 만들 수 있다. 이처럼 생성자가 2개 이상 제공되는 경우를 생성자 오버로드라고 한다.
	* 오버로드(overload) : 객체 지향 프로그램에서 메서드 이름이 같고 매개변수만 다른 경우

<br>

### 8. 생성자가 있는 클래스 만들기
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

### 9. 인스턴스 생성하기
- `Student` 클래스를 사용하여 학생 인스턴스를 생성해보기

	```java
	Student jwoo = new Student();
	```   
	- `new` 예약어와 `Student` 클래스의 생성자 `Student()` 를 이용하여, 학생 인스턴스(또는 학생 객체)를 생성한다.
	- `Student` 클래스 자료형으로 선언한 `jwoo` 라는 참조 변수는 이 인스턴스의 메모리 주소를 가르키고 있다.

<br>

- 하나의 클래스를 사용하여 여러개의 인스턴스를 생성해보기

	```java
	Student student1 = new Student();
	Student student2 = new Student();
	Person	woo = new Person();
	Person	jiwon = new Person("jiwon");
	Person	jiwonWoo = new Person("jiwon woo", 25);
	```   
	- `student1`, `student2` 는 모두 동일한 클래스, 동일한 생성자로부터 생성되었지만, 멤버 변수의 값(속성값)은 모두 다를 수 있다.
	- `woo`, `jiwon`, `jiwonWoo` 는 모두 동일한 클래스로부터 생성되었지만, 멤버 변수의 값(속성값)은 모두 다르게 설정되었다.
	- 실제와 비교했을 때, 사람이나 학생이라는 추상어는 뜻이 하나이지만, 개개인은 여러명인 것과 같다.

<br>

### 10. main()
- `main()` 함수가 있는 클래스가 프로그램의 시작 클래스가 된다.
- 클래스가 제대로 수행되는지 테스트할 때 클래스 내부에 `main()` 함수를 만들고 실행한다.
- 클래스를 따로 만들어 `main()` 을 실행하는 방식도 있다.
- 같은 패키지 내에 `main()` 함수 만들기
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
- 현재 폴더 구조
	```
	|- workspace
		|- project `Practice`
			|- bin
				|- package `classpart`
					|- class `Student.class`
					|- class `Person.class`
					|- class `MainTest.class`
			|- src
				|- package `classpart`
					|- class `Student.java`
					|- class `Person.java`
					|- class `MainTest.java`
	```

