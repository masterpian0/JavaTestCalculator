package Calculiator;

public class ArabicNumber extends Number {
    private int value1;
    private int value2;
    private int result;

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public ArabicNumber(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void sum() {
        this.result = value1 + value2;
    }

    @Override
    public void sub() {
        this.result = value1 - value2;
    }

    @Override
    public void mul() {
        this.result = value1 * value2;
    }

    @Override
    public void div() {
        try{
            this.result = value1 / value2;
        } catch (ArithmeticException e) {
            System.out.print("Stop! Division by zero!");
            return;
        }
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }
}
