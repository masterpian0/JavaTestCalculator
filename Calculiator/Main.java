package Calculiator;

import java.util.Scanner;

public class Main {

    public static boolean isRomanNumber = false;

    public static boolean verificationEnteredString(String str) {

        boolean isValidString = false;

        /* Check count place and valid symbols */
        int countOfSign = 0;
        int countOfAllowedSign = 1;
        int countArabicNumbers = 0;
        int countRomanNumbers = 0;

        if (str.isEmpty()) {
            throw new RuntimeException("Stop! Values not entered!");
        }
        char[] symbolsOfString = str.toCharArray();
        for (int i = 0; i < symbolsOfString.length; i++) {

            switch (symbolsOfString[i]) {

                    /* Arabic numbers */
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    countArabicNumbers++;
                    isValidString = true;
                    continue;

                    /* Roman numbers */
                case 'I':
                case 'V':
                case 'X':
                    countRomanNumbers++;
                    isValidString = true;
                    continue;

                    /* Sign symbol */
                case '+':
                case '-':
                case '*':
                case '/':
                    countOfSign++;
                    isValidString = true;
            }
        }

        if (countOfSign > countOfAllowedSign) {
            isValidString = false;
        }

        if (symbolsOfString[0] == '+' | symbolsOfString[symbolsOfString.length-1] == '+'){
            isValidString = false;
        }

        if (symbolsOfString[symbolsOfString.length-1] == '-'){
            isValidString = false;
        }

        if (symbolsOfString[0] == '*' | symbolsOfString[symbolsOfString.length-1] == '*'){
            isValidString = false;
        }

        if (symbolsOfString[0] == '/' | symbolsOfString[symbolsOfString.length-1] == '/'){
            isValidString = false;
        }

        if ((countRomanNumbers != 0) && (countArabicNumbers != 0)){

            throw new RuntimeException("Stop! Arabic and Roman numerals together!");
        }

        /* Check roman numbers */

        if (countRomanNumbers != 0){

            isRomanNumber = true;
        }

        return isValidString;
    }

    public static void main(String[] args) {

// TODO: 1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления
//  с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку
//  (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция
//  передаются с новой строки считаются неверными.
//
// TODO: 2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими
//  (I,II,III,IV,V…) числами.
//
// TODO: 3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
//  На выходе числа не ограничиваются по величине и могут быть любыми.
//
// TODO: 4. Калькулятор умеет работать только с целыми числами.

// TODO: 5.Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
//  при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и
//  прекратить свою работу.
//
// TODO: 6. При вводе римских чисел, ответ должен быть выведен римскими цифрами,
//  соответственно, при вводе арабских - ответ ожидается арабскими.

// TODO: 7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и
//  завершает свою работу.
//
// TODO: 8. При вводе пользователем строки, не соответствующей одной из вышеописанных
//  арифметических операций, приложение выбрасывает исключение и завершает свою работу.

        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        verificationEnteredString(str);

        // Check Array
        while (verificationEnteredString(str)) {

            /* Arabic Numbers */

            if (!isRomanNumber){

            String[] parseInputIntValue = str.trim().split("\\s*[*/+-]\\s*");

                int value1 = Integer.parseInt(parseInputIntValue[0]);
                int value2 = Integer.parseInt(parseInputIntValue[1]);

                if (value1 > 10){
                    throw new RuntimeException("Stop! First operand > 10!");
                }
                if (value2 > 10){
                    throw new RuntimeException("Stop! Second operand > 10!");
                }

            String[] parsedInputStringSign = str.split("\\s*[0-9]\\s*");

                int posIndex = 1;

                if (value1 == 10) {
                    posIndex = 2;
                }

                String arithmeticOperation = parsedInputStringSign[posIndex];

                Number values = new ArabicNumber(value1, value2);

                switch (arithmeticOperation) {
                    case "+":
                        values.sum();
                        break;
                    case "-":
                        values.sub();
                        break;
                    case "*":
                        values.mul();
                        break;
                    case "/":
                        values.div();
                        break;
                }

                System.out.println("Output:\n" + values.getResult());
            }

          /* Roman Numbers */

            else {
                String[] parsedInputStringValue = str.trim().split("\\s*[*/+-]\\s*");

                String[] parsedInputStringSign = str.split("\\s*[I|V|X]\\s*");

                String arithmeticOperation = null;

                for (int i = 0; i < parsedInputStringSign.length; i++) {
                     arithmeticOperation = parsedInputStringSign[i];
                }

                Number values = new RomanNumber(parsedInputStringValue[0], parsedInputStringValue[1]);

                switch (arithmeticOperation) {
                    case "+":
                        values.sum();
                        break;
                    case "-":
                        values.sub();
                        break;
                    case "*":
                        values.mul();
                        break;
                    case "/":
                        values.div();
                        break;
                }

                System.out.println("Output:\n" + values.getStringResult());
            }

            System.out.println();
            System.out.println("Input:");
            str = scanner.nextLine();

        }
        System.out.println("You are logged out!");

    }
}
