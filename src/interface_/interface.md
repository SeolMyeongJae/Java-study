# 인터페이스(interface)

## 인터페이스란?

- 인터페이스는 구현 코드 없이 추상 메소드로만 이루어져 있다.
- 모든 메소드가 public abstract 키워드를 쓰지 않아도 추상 메소드로 선언됨  
- 모든 변수는 public static final 키워드를 쓰지 않아도  상수로  선언됨 
- Java8부터 default 메소드, static 메소드, private 메소드가 추가됨

```java
interface 인터페이스 이름 {
    public static final float pi = 3.14F;
    public void makeSomething();
}
```

## 인터페이스 정의와 구현
