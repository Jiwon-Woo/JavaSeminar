#### 1.1 배열의 필요성

- 100명의 학생이 있고, 이 학생들의 수학 점수에 대한 자료를 만들어 둔다고 가정.
- 만약 배열을 사용하지 않는다면, `학생1의 수학 점수`, `학생2의 수학점수`, ..., `학생100의 수학점수`에 대한 변수를 모두 따로따로 선언하고 활용해야하며, 학생들의 수학 점수 합을 알고 싶다면 100개의 변수를 타이핑해야하는 일이 발생.

	```java
	int	studentMath1 = 78;
	int	studentMath2 = 46;

	...

	int	studentMath100 = 97;
	```   

	```java
	int studentMathSum = studentMath1 + studentMath2 + ... + studentMath100;
	```   

<br>

- 하지만 배열을 사용한다면 위와 같은 과정이 간편해진다.

	```java
	int[]	studentMath = new int[100];
	```   

	```java
	int studentMathSum = 0;

	for (int i = 0; i < 100; i++)
		studentMathSum += studentMath[i];
	```   

<br>