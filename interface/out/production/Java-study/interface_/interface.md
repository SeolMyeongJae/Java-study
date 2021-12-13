# 인터페이스(interface)

## 인터페이스란?

- 인터페이스는 구현 코드 없이 추상 메서드로만 이루어져 있다.
- 모든 메서드가 public abstract 키워드를 쓰지 않아도 추상 메서드로 선언됨
- 모든 변수는 public static final 키워드를 쓰지 않아도 상수로 선언됨
- Java8부터 default 메서드, static 메서드, private 메서드가 추가됨

```java
interface 인터페이스 이름 {
    public static final float pi = 3.14F;

    public void makeSomething();
}
```

## 인터페이스 정의와 구현

Calc.java

```java
package interface_;

public interface Calc {
    double PI = 3.14;
    int ERROR = -999999999;

    int add(int num1, int num2);

    int substract(int num1, int num2);

    int times(int num1, int num2);

    int divide(int num1, int num2);
}

```

Calcuator.java

```java
package interface_;

import interface_.calc.Calc;

public abstract class Calculator implements Calc {
  @Override
  public int add(int num1, int num2) {
    return num1 + num2;
  }

  @Override
  public int substract(int num1, int num2) {
    return num1 - num2;
  }
}
```

CompeleteCalc.java

```java
package interface_;

import interface_.calc.Calculator;

public class CompleteCalc extends Calculator {
  @Override
  public int times(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public int divide(int num1, int num2) {
    if (num2 == 0) {
      return ERROR;
    }
    return num1 / num2;
  }

  public void showInfo() {
    System.out.println("모두 구현했습니다.");
  }
}
```

## 인터페이스 구현과 형 변환

- 인터페이스를 구현한 클래스는 인터페이스 형으로 선언한 변수로 형 변환할 수 있음  
  Calc calc = new CompleteCalc();
- 클래스 상속과 달리 구현 코드가 없으므로 여러 인터페이스를 구현할 수 있음
- 형 변환되는 경우 인터페이스에 선언된 메서드만 사용가능  
  **showInfo()메서드는 CompleteCalc형 변수에서만 사용 가능**

## 인터페이스가 하는 일

- 클래스나 프로그램이 제공하는 기능을 명시적으로 선언
- 일종의 클라이언트 코드와의 약속이며 클래스나 프로그램이 제공하는 명세(Specification)
- 클라이언트 프로그램은 인터페이스에 선언된 메서드 명세만 보고 이를 구현한 클래스를 사용할 수 있음
- 어떤 객체가 하나의 인터페이스 타입이라는 것은 그 인터페이스가 제공하는 모든 메서드를 구현했다는 의미임
- 인터페이스를 구현한 클래스가 여러 개가 있을 수도 있지만 어떤 클래스를 쓰더라도 인터페이스에 명시된 대로 사용할 수 있음(다형성)

> 정리.
>
> 인터페이스를 구현한 클래스를 사용할 때 구현 클래스의 상세 내용을 모르더라도 인터페이스 명세를 통해 사용할 수 있다.
>
> 구현 클래스의 내용이 변경되더라도 클래스를 사용하는 쪽에서는 코드를 수정할 필요가 없다.
>

## 인터페이스 구성요소

### 상수

- 모든 변수는 상수로 변환됨 **public static final**

```java
double PI=3.14;
        int ERROR=-999999999;
```

### 추상 메서드

- 모든 선언된 메서드는 추상 메서드로 변환됨 **public abstract**

### default 메서드 (Java8 이후)

- 구현 코드를 가지는 메서드, 인터페이스를 구현하는 클래스들에게 공통으로 사용할 수 있는 기본 메서드 역할
- default 키워드 사용

```java
default void description(){
        System.out.println("정수 계산기를 구현합니다.");
        myMethod();
        }
```

- 구현하는 클래스에서 재정의할 수 있음

```java
@Override
public void description(){
        System.out.println("CompleteCalc에서 재정의한 defalut 메서드");
        }
```

- 인터페이스를 구현한 클래스의 인스턴스가 생성 되어야 사용 가능함

### static 메서드(Java 8이후)

- 인스턴스 생성과 상관 없이 인터페이스 타입으로 사용할 수 있는 메서드

```java
static int total(int[]arr){
        int total=0;
        for(int i:arr){
        total+=1;
        }
        myStaticMethod();
        return total;
        }
```

### private 메서드(Java 9이후)

- 인터페이스를 구현한 클래스에서 사용하거나 재정의할 수 없음
- 인터페이스 내부에서만 사용하기 위해 구현하는 메서드
- default 메서드나 static 메서드에서 사용함

```java
private void myMethod(){
        System.out.println("private method");
        }

private static void myStaticMethod(){
        System.out.println("private static method");
        }
```

# 여러 인터페이스 구현, 인터페이스 상속

## 여러 인터페이스 구현

- 자바의 인터페이스는 구현 코드가 없으므로 하나의 클래스가 여러 인터페이스를 구현할 수 있음
- 디폴트 메서드가 중복되는 경우 구현하는 클래스에서 재정의해야함
- 여러 인터페이스를 구현한 클래스는 인터페이스 타입으로 형 변환 되는 경우 해당 인터페이스에서 선언된 메서드만 사용가능

Sell.java

```java
public interface Sell {
    void sell();

    default void order() {
        System.out.println("sell order ");
    }
}
```

Buy.java
```java
public interface Buy {
    void buy();

    default void order() {
        System.out.println("buy order");
    }
}
```

Customer.java
```java
public class Customer implements Sell, Buy {
    @Override
    public void buy() {
        System.out.println("customer buy");
    }

    @Override
    public void sell() {
        System.out.println("customer sell");
    }

    @Override
    public void order() {
        System.out.println("customer order");
    }

    public void hello() {
        System.out.println("hello");
    }
}
```

## 인터페이스 상속
- 인터페이스 사이에도 상속을 사용할 수 있음
- extends 키워드 사용
- 인터페이스는 다중 상속이 가능하고 구현 코드의 상속이 아니므로 타입 상속이라고 함

X.java
```java
public interface X {
    void x();
}
```

y.java
```java
public interface Y {
    void y();
}
```

MyInterface.java
```java
public interface MyInterface extends X, Y {
    void myMethod();
}
```

MyClass.java
```java
public class MyClass implements MyInterface {
    @Override
    public void x() {
        System.out.println("x()");
    }
    
    @Override
    public void y() {
        System.out.println("y()");
    }
    
    @Override
    public void myMethod() {
        System.out.println("myMethod()");
    }
}
```
MyClassTest.java
```java
public class MyClassTest {
    public static void main(String[] args) {
        MyClass mClass = new MyClass();
        X xClass = mClass;
        xClass.x();

        Y yClass = mClass;
        yClass.y();

        MyClass iClass = mClass;
        iClass.x();
        iClass.y();
        iClass.myMethod();
    }
}
```
## 클래스 상속과 인터페이스 구현 함께 쓰기
- 실무에서 프레임워크나 오픈소스와 함께 연동되는 구현을 하게 되면 클래스 상속과 인터페이스의 구현을 같이 사용하는 경우가 많음 

Shelf.java
```java
import java.util.ArrayList;

public class Shelf {
    protected ArrayList<String> shelf;

    public Shelf() {
        shelf = new ArrayList();
    }

    public ArrayList<String> getShelf() {
        return shelf;
    }

    public int getCount() {
        return shelf.size();
    }
}
```
Queue.java
```java
public interface Queue {
    void enQueue(String title);
    String deQueue();
    int getSize();
}
```
BookShelf.java
```java
public class BookShelf extends Shelf implements Queue{

    @Override
    public void enQueue(String title) {
        shelf.add(title);
    }

    @Override
    public String deQueue() {
        return shelf.remove(0);
    }

    @Override
    public int getSize() {
        return getCount();
    }
}
```
BookShelfTest.java
```java
public class BookShelfTest {
    public static void main(String[] args) {
        Queue bookQueue = new BookShelf();
        bookQueue.enQueue("토지1");
        bookQueue.enQueue("토지2");
        bookQueue.enQueue("토지3");
        bookQueue.enQueue("토지4");
        bookQueue.enQueue("토지5");

        System.out.println(bookQueue.getSize());
        System.out.println(bookQueue.deQueue());
    }
}
```