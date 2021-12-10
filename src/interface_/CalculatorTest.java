package interface_;

public class CalculatorTest {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;

        Calc calc = new CompleteCalc();
        System.out.println(calc.add(num1, num2));
        System.out.println(calc.substract(num1, num2));
        System.out.println(calc.times(num1, num2));
        System.out.println(calc.divide(num1, num2));

        CompleteCalc calc2 = new CompleteCalc();

        // showInfo는 CmpleteCalc에서 선언되었기 때문에 Calc형 변수에서는 사용할 수 없다
        // calc.showInfo();
        calc2.showInfo();
    }
}
