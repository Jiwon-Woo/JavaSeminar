# 4회차

## 목차
1. [배열](#1.-배열)
2. [객체 배열](#2.-객체-배열)
3. [배열의 복사](#3.-배열의-복사)
4. [ArrayList](#4.-ArrayList)

<br><br>


### 1. 배열

![배열의 형태와 필요성](https://player.slidesplayer.org/60/11187470/slides/slide_22.jpg)

- 자료형이 같은 자료가 연속으로 나열된 자료구조.
- 배열을 이루고 있는 자료들을 배열의 요소라고 한다.
- 배열의 요소들은 실제 메모리 상에서도 이웃해있다.

<br>

#### 1.1 배열의 생성

- 배열은 하나의 클래스로, `new`를 활용하여 배열 객체를 생성.
- `studentMath` 과 같은 배열 변수에 배열 인스턴스의 주소값이 담긴다.
- 배열 객체를 생성하지 않고 배열 변수만 선언 하게 되면, 배열 변수는 `null` 값을 가지게 된다.
- 다른 클래스처럼 배열 객체 또한 배열 클래스 내에 있는 속성과 메서드를 활용할 수 있다.

![배열의 선언과 생성](https://player.slidesplayer.org/60/11187470/slides/slide_24.jpg){: width="200" height="150"}

<br>

#### 1.3 배열의 선언 및 초기화

- 초기값을 설정해주지 않고 배열 선언 하기

	```java
	int[]	math = new int[5];
	int english[] = new int[5];
	```   

	- 초기값을 따로 지정해주지 않으면, 배열의 자료형에 따라 초기값이 설정된다.
	- 자료형이 `int`라면, `0`으로, `double`이나 `float` 라면 `0.0`, `객체 배열`이라면 `null`로 초기화.

<br>

- 선언과 동시에 초기값을 설정해주기

	```java
	int[]	math = new int[] {78, 46, 98, 22, 100};
	int[]	english = {1, 2, 3, 4, 5};
	```   

	- 값을 넣어 초기화해줄 경우 `new int[]`의 대괄호에는 자료형의 개수를 적으면 오류가 발생.
	- 초기값을 넣어주는 동시에 배열을 선언할 때는 `new int[]`을 생략해도 되지만, 만약 선언과 초기값의 대입이 다른 라인에서 이루어진다면 `new int[]`을 생략할 수 없다.

<br>

#### 1.4 배열의 사용

- 배열을 선언할 때 사용했던 `[]`를 인덱스 연산자라고 한다.
- 배열은 `[]`을 통해 배열의 요소에 접근할 수 있다.
- `math[i]` 는 `math` 라는 배열의 `i` 번째 요소라는 뜻이다.
- 인덱스 연산자를 활용하여 `i`번째 값을 얻거나 바꿀수 있다.
	```java
	int mathSum = 0;

	for (int i = 0; i < 5; i++)
		mathSum += math[i];
	```   
	```java
	for (int i = 0; i < 5; i++)
		math[i] = 100;
	```   
- 배열은 물리적 위치와 논리적 위치가 같은 자료구조. 
- 배열의 `i`번째 요소라는 것은 `j`번째 인덱스로부터 실제 메모리 상에서 `|i - j| * 자료형의 크기(byte)` 만큼 떨어져 있다는 의미다.
- `int`형인 `math` 배열을 예로 들자면, `math[2]`가  `math[1]`로부터 `4byte` 다음 메모리 주소에 위치하고 있는 것.

<br><br>

### 2. 객체 배열

#### 2.1 객체 배열의 정의

- 배열의 요소가 객체인 배열
- 기본 자료형 배열 요소에는 그 자료형에 해당하는 실제 값이 담기지만 객체 배열에는 생성된 인스턴스의 주소가 담긴다.
- 객체 배열은 기본 자료형 배열과 사용법이 약간 다르다.

<br>

#### 2.2 객체 배열 사용하기

- `Student` 클래스

	```java
	package array;

	public class Student {
		
		private	String	id;
		
		public Student(String id) {
			this.id = id;
		}
		
		public String	getStudentID() {
			return this.id;
		}
	}
	```   

<br>

- 객체 배열 선언하기

	```java
	Student[] cadet = new Student[5];
	```   

	- 클래스 명과 `[]`을 사용하여 객체 배열을 선언.
	- `new`를 사용하여 선언하지만, 이때는 `Stduent` 인스턴스가 생성되는 게 아니라 인스턴스의 메모리 주소가 담길 공간이 `[]`안의 개수 만큼 생성.
	- 배열의 요소는 모두 `null`로 초기화 되어있다.
	- 객체 배열은 클래스의 인스턴스를 생성하여 그 메모리 주소를 배열의 요소에 담아주는 방식으로 사용.

<br>

- 객체 배열에 인스턴스를 생성하고 저장하기

	```java
	cadet[0] = new Student("gyeon");
	cadet[1] = new Student("jwoo");
	cadet[2] = new Student("seuhan");
	cadet[3] = new Student("sjin");
	cadet[4] = new Student("sushin");
	```   

<br>

#### 2.2 객체 배열 사용 예제

- `ArrayTest.java`

	```java
	package array;

	public class ArrayTest {

		public static void main(String[] args) {
			
			Student[] cadet = new Student[5];
			
			cadet[0] = new Student("gyeon");
			cadet[1] = new Student("jwoo");
			cadet[2] = new Student("seuhan");
			cadet[3] = new Student("sjin");
			cadet[4] = new Student("sushin");
			
			System.out.println(cadet);
			
			for (int i = 0; i < cadet.length; i++) {
				System.out.println(cadet[i] + ", " + cadet[i].getStudentID());
			}
		}
	}
	```   

<br>

- 출력 결과
	```
	[Larray.Student;@41975e01
	array.Student@1ee0005, gyeon
	array.Student@75a1cd57, jwoo
	array.Student@3d012ddd, seuhan
	array.Student@6f2b958e, sjin
	array.Student@1eb44e46, sushin
	```   

<br><br>

### 3. 배열의 복사

<br>


### 4. ArrayList

<br>

