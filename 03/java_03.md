# 3회차

## 목차
1. [참조형 변수](#1.-참조형-변수)
2. [this의 활용](#2.-this의-활용)
3. [static의 의미](#3.-static의-의미)
4. [클래스 변수 및 클래스 메서드](#4.-클래스-변수-및-클래스-메서드)
5. [싱글톤 패턴](#5.-싱글톤-패턴)
6. [객체간의 협력](#6.-객체간의-협력)

<br>

### 1. 참조형 변수
- 변수에는 크기가 정해진 기본 자료형(`int`, `double`, `boolean`, `char` 등)으로 선언하는 변수가 있고, 클래스 자료형(`String` 등)으로 선언하는 참조 자료형 변수가 있다.

<br>

### 2. this의 활용
- `this` : 생성된 인스턴스 스스로를 가리키는 예약어

1. 자신의 메모리를 가르키는 `this`
2. 생성자에서 다른 생성자를 호출하는 `this`
3. 자신의 주소를 반환하는 `this`

<br>

### 3. static의 의미
- 같은 클래스로부터 생성된 인스턴스가 공유하는 변수를 static 변수라고 한다. 즉 클래스 전반에서 공통으로 사용하는 변수이다.

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
	외부 클래스에서는 SingleTone 클래스의 인스턴스를 생성할 수 없으므로, public으로 선언한 `getInstance()` 함수를 통해 인스턴스의 메모리 주소를 확인해본다. `single1`과 `single2`에 모두 같은 메모리 주소가 저장되어있음을 알 수 있다. 즉, SingleTone 클래스의 인스턴스는 유일하다.

<br>

### 6. 객체간의 협력
- 코드 구현해보기

