# Major

### Major parent class

```java
package goodschool;

public abstract class Major {
	
	protected String name;
	protected String mandatorySubject;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMandatorySubject() {
		return mandatorySubject;
	}
	public void setMandatorySubject(String mandatorySubject) {
		this.mandatorySubject = mandatorySubject;
	}

}
```

<br>

### KoreanLanguage child class

```java
package goodschool;

public class KoreanLanguage extends Major {

	public KoreanLanguage() {
		name = "국어국문학과";
		mandatorySubject = "국어";
	}
}
```

<br>

### ComputerScience child class

```java
package goodschool;

public class ComputerScience extends Major {

	public ComputerScience() {
		name = "컴퓨터공학과";
		mandatorySubject = "수학";
	}

}
```