# 4회차

## 목차
1. [배열](#1.-배열)
2. [객체 배열](#2.-객체-배열)
3. [배열의 복사](#3.-배열의-복사)
4. [ArrayList](#4.-ArrayList)

<br><br>


## 1. 배열

<img src="https://player.slidesplayer.org/60/11187470/slides/slide_22.jpg" width="50%" height="50%"><img src="https://player.slidesplayer.org/60/11187470/slides/slide_30.jpg" width="50%" height="50%">

- 자료형이 같은 자료가 연속으로 나열된 자료구조.
- 배열을 이루고 있는 자료들을 배열의 요소라고 한다.
- 배열의 요소들은 실제 메모리 상에서도 이웃해있다. (물리적 위치와 논리적 위치가 같다.)
- 즉, 배열의 `k`번째 요소라는 것은 `j`번째 인덱스로부터 실제 메모리 상에서 `|k - j| * 자료형의 크기(byte)` 만큼 떨어져 있다는 의미다.
- `int`형인 `i` 배열을 예로 들자면, `i[2]`가 `i[1]`로부터 `4byte` 다음 메모리 주소에 위치하고 있는 것.
- 자바의 배열은 클래스로 구현되어 있으므로, 배열 객체를 생성하여 이용할 수 있다.

<br>

### 1.1 배열의 생성

- 배열은 하나의 클래스로, `new`를 활용하여 배열 객체를 생성할 수 있고, 배열 변수에 배열 인스턴스의 주소값이 담긴다.
- 다른 클래스처럼 배열 객체 또한 배열 클래스 내에 있는 속성과 메서드를 활용할 수 있다.
- 배열 객체를 생성하지 않고 배열 변수만 선언 하게 되면, 배열 변수는 `null` 값을 가지게 된다.
- 배열 객체의 생성은 힙 메모리에서 이루어지고, 배열 변수는 참조만 하기 때문에 하나의 배열 객체를 가리키는 배열 변수는 여러개일 수도 있다.

<img src="https://player.slidesplayer.org/60/11187470/slides/slide_24.jpg" width="50%" height="50%"><img src="https://player.slidesplayer.org/60/11187470/slides/slide_26.jpg" width="50%" height="50%">

<br>

### 1.2 배열의 선언 및 초기화

- 초기값을 설정해주지 않고 배열 선언 하기

	```java
	int[]	math = new int[5];
	int english[] = new int[5];
	```   

	- 초기값을 따로 지정해주지 않으면, 배열의 자료형에 따라 배열 요소의 초기값이 설정된다.
	- 자료형이 `int`라면, `0`으로, `double`이나 `float` 라면 `0.0`, `객체 배열`이라면 `null`로 초기화.

<br>

- 선언과 동시에 초기값을 설정해주기

	```java
	int[]	math = new int[] {78, 46, 98, 22, 100};
	int[]	english = {10, 20, 30, 40, 50};
	```   

	- 값을 넣어 초기화해줄 경우 `new int[]`의 대괄호에 자료형의 개수를 적으면 오류가 발생하므로 적지 말것.
	- 초기값을 넣어주는 동시에 배열을 선언할 때는 `new int[]`을 생략해도 되지만, 만약 선언과 초기값의 대입이 다른 라인에서 이루어진다면 `new int[]`을 생략할 수 없다.

<br>

### 1.3 배열의 사용

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



<br><br>

## 2. 객체 배열

- 배열의 요소가 객체인 배열로, 기본 자료형 배열과 사용법이 약간 다르다.
- 기본 자료형 배열 요소에는 그 자료형에 해당하는 실제 값이 담기지만 객체 배열에는 생성된 인스턴스의 주소가 담긴다.
- 기본 자료형 배열(위)과 객체 배열(아래)의 차이
<img src="https://resources.codeonweb.com/bucket/cached/72/d5/72d54e7bc14f44296675d610d8ead80d@2x.png" width="60%" height="60%">
<img src="https://resources.codeonweb.com/bucket/cached/ca/cb/cacbe097dac93685cf7e25183b234643@2x.png" width="60%" height="60%">

<br>

### 2.1 객체 배열 사용하기

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

### 2.2 객체 배열 사용 예제

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

## 3. 배열의 복사

- 배열의 복사에는 두가지 방법이 있다.
- 첫번째로 `for` 반복문을 사용하여 각 배열의 요소값을 복사하는 방법이 있다.
- 두번째는 `System.arraycopy()` 메서드를 활용하는 것이다.

<br>

### 3.1 System.arraycopy()

- 함수의 원형

	```java
	System.arraycopy(src, srcPos, dest, destPos, length)
	```   

- 매개변수

	|매개 변수|의미|
	|:--:|:--|
	|`src`|복사할 배열 이름|
	|`srcPos`|복사할 배열의 첫 번째 인덱스 위치|
	|`dest`|복사해서 붙여 넣을 대상 배열 이름|
	|`destPos`|복사해서 대상 배열에 붙여 넣기를 시작할 인덱스 위치|
	|`length`|`src`에서 `dest`로 복사할 요소의 개수|

- `System.arraycopy()` 사용 예제

	- `ArrayTest.java`
		```java
		package array;

		public class ArrayTest {

			public static void main(String[] args) {
				
				int[]	math = {78, 46, 98, 22, 100};
				int[]	english = {10, 20, 30, 40, 50};
				
				System.arraycopy(math, 1, english, 2, 2);
				
				for (int i = 0; i < math.length; i++) {
					System.out.print(math[i] + " ");
				}
				
				System.out.println();
				
				for (int i = 0; i < english.length; i++) {
					System.out.print(english[i] + " ");
				}
			}
		}
		```   

	- 출력 결과

		```
		78 46 98 22 100 
		10 20 46 98 50 
		```   

<br>

### 3.2 객체 배열의 복사

- 기본 자료형 배열과 마찬가지로 객체 배열 또한 `System.arraycopy()` 메서드로 배열 요소를 복사할 수 있다.
- 다만 객체 배열의 요소는 객체의 메모리 주소이므로, 기본 자료형 배열처럼 실제 자료값이 복사되는게 아니라 객체의 메로리 주소가 복사된다.
- 객체 배열을 `System.arraycopy()` 메서드로 복사해보기
	- `ArrayTest.java`

		```java
		package array;

		public class ArrayTest {

			public static void main(String[] args) {
				
				Student[] cadet = new Student[5];
				Student[] student = new Student[5];
				
				cadet[0] = new Student("gyeon");
				cadet[1] = new Student("jwoo");
				cadet[2] = new Student("seuhan");
				cadet[3] = new Student("sjin");
				cadet[4] = new Student("sushin");
				
				
				for (int i = 0; i < cadet.length; i++) {
					System.out.println(cadet[i] + ", " + cadet[i].getStudentID());
				}
				for (int i = 0; i < student.length; i++) {
					System.out.println(student[i]);
				}
				
				System.out.println();
				System.arraycopy(cadet, 0, student, 0, 5);
				
				for (int i = 0; i < cadet.length; i++) {
					System.out.println(cadet[i] + ", " + cadet[i].getStudentID());
					System.out.println(student[i] + ", " + student[i].getStudentID());
				}
			}
		}
		```   

	- 출력 결과

		```
		array.Student@41975e01, gyeon
		array.Student@1ee0005, jwoo
		array.Student@75a1cd57, seuhan
		array.Student@3d012ddd, sjin
		array.Student@6f2b958e, sushin
		null
		null
		null
		null
		null

		array.Student@41975e01, gyeon
		array.Student@41975e01, gyeon
		array.Student@1ee0005, jwoo
		array.Student@1ee0005, jwoo
		array.Student@75a1cd57, seuhan
		array.Student@75a1cd57, seuhan
		array.Student@3d012ddd, sjin
		array.Student@3d012ddd, sjin
		array.Student@6f2b958e, sushin
		array.Student@6f2b958e, sushin
		```   

<br>

### 3.3 얕은 복사

<br>


## 4. ArrayList

<br>

