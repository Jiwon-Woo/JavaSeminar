# Practice 08

<br>

### Animal 추상 클래스

```java
package animal;

public abstract class Animal {

	public abstract void description();
	
	public void eat() {
		System.out.println("먹이를 먹습니다.");
	}
	
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
}
```   

<br>

### LandAnimal 인터페이스
```java
package animal;

public interface LandAnimal {

	void walk();
}
```   

<br>

### MarineAnimal 인터페이스
```java
package animal;

public interface MarineAnimal {

	void swim();
}
```   

<br>

### Cat 클래스

> `Animal` 추상 클래스를 상속받고, `LandAnimal` 인터페이스를 구현

```java
package animal;

public class Cat extends Animal implements LandAnimal {

	@Override
	public void description() {
		System.out.println("이 동물은 고양이입니다.");
	}
	
	@Override
	public void walk() {
		System.out.println("고양이가 살금살금 걷습니다.");
	}

}
```   

<br>

### Whale 클래스

> `Animal` 추상 클래스를 상속받고, `MarineAnimal` 인터페이스를 구현

```java
package animal;

public class Whale extends Animal implements MarineAnimal {

	@Override
	public void description() {
		System.out.println("이 동물은 고래입니다.");
	}
	
	@Override
	public void swim() {
		System.out.println("고래가 바다를 헤엄칩니다.");
	}

}
```   

<br>

### Duck 클래스

> `Animal` 추상 클래스를 상속받고, `LandAnimal` 과 `MarineAnimal` 인터페이스를 구현

```java
package animal;

public class Duck extends Animal implements LandAnimal, MarineAnimal {

	@Override
	public void description() {
		System.out.println("이 동물은 오리입니다.");
	}
	
	@Override
	public void walk() {
		System.out.println("오리가 뒤뚱뒤뚱 걷습니다.");
	}
	
	@Override
	public void swim() {
		System.out.println("오리가 연못에서 헤엄칩니다.");
	}

}
```   

<br>

### 출력 테스트

> `AnimalTest.java`

```java
package animal;
import java.util.ArrayList;

public class AnimalTest {

	public static void main(String args[]) {
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		animalList.add(new Cat());
		animalList.add(new Duck());
		animalList.add(new Whale());
		
		for (Animal animal : animalList) {
			System.out.println("====================");
			animal.description();
			animal.eat();
			animal.sleep();
			if (animal instanceof LandAnimal) {
				LandAnimal land = (LandAnimal)animal;
				land.walk();
			}
			if (animal instanceof MarineAnimal) {
				MarineAnimal marine = (MarineAnimal)animal;
				marine.swim();
			}
		}
		System.out.println("====================");
	}
}

```   

> 출력결과

```
====================
이 동물은 고양이입니다.
먹이를 먹습니다.
잠을 잡니다.
고양이가 살금살금 걷습니다.
====================
이 동물은 오리입니다.
먹이를 먹습니다.
잠을 잡니다.
오리가 뒤뚱뒤뚱 걷습니다.
오리가 연못에서 헤엄칩니다.
====================
이 동물은 고래입니다.
먹이를 먹습니다.
잠을 잡니다.
고래가 바다를 헤엄칩니다.
====================
```   
