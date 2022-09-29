package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.Cat;
import pages.Dog;

import java.util.Arrays;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer!";
        System.out.println(message + " " + text);
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str0, String str1) {
        str0 = "my var";
        str1 = "my VAR";
        String var = str0 + " " + str1;
        System.out.println(var);
        System.out.println(var.toUpperCase());
        System.out.println(var.length());
        System.out.println(str0.equals(str1));
        System.out.println(str0.equalsIgnoreCase(str1));
        System.out.println(str0.contains(str1));
        System.out.println(var.indexOf("a"));
    }

    @And("I work with numbers {int} and {int}")
    public void iWorkWithNumbersAnd(int num0, int num1) {

        if (num0 > num1) {
            System.out.println("Num1 is bigger than Num2");
        } else if (num0 == num1) {
            System.out.println("Num1 is equal than Num2");
        } else {
            System.out.println("Num1 is equal than Num2");

        }
    }


    @And("I open page {string}")
    public void iOpenPage(String page) {
        switch (page.toLowerCase()) {
            case "google" -> System.out.println("https://.google.com");
            case "yahoo" -> System.out.println("https://.yahoo.com");
            default -> throw new Error("Unknown url page " + page);
        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);


        }

    }

    @And("I print if number {int} is positive")
    public void iWorkWithIfElseStatement(int i) {

        if (i > 0) {
            System.out.println("Number " + i + " is positive");

        } else if (i < 0) {
            System.out.println("Number " + i + " is negative");

        } else {
            throw new Error("Number " + i + " is " + " out of boundary");
        }

    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int i) {
        switch (i) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Monday / Tuesday");
            case 3 -> System.out.println("Monday / Tuesday / Wednesday");
            case 4 -> System.out.println("Monday / Tuesday / Wednesday / Thursday");
            case 5 -> System.out.println("Monday / Tuesday / Wednesday / Thursday / Friday");
            case 6 -> System.out.println("Monday / Tuesday / Wednesday / Thursday / Friday / Saturday");
            case 7 -> System.out.println("Monday / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday");
            default -> throw new Error("Number " + i + " is " + " out of boundary");
        }
    }
    //        1) Write a function that prints all numbers from 0 up to n
//        2) Write a function that supports also negative numbers
//        3) Write a function that prints all integer array
//        4) Write a function that prints all even numbers from integer array
//        5) Write a function that checks if array is empty
//        6) Write a function that checks if array contains another element

    @And("I print all numbers 0 to {int}")
    public void iWorkWithHW(int n) {


        for (int i = 0; i <= n; i++) {
            System.out.println("I print " + i + " number");

        }
    }

    @And("I print all negative numbers {int} to 0")
    public void iPrintAllNegativeNumbersIntTo(int n) {


        for (int i = -n; i >= 0; i--) {
            System.out.println("I print " + -i + " number");

        }
    }

    @And("I print all integer arrays")
    public void iPrintAllIntegerArrays() {
        int[] intArray = new int[5];
        intArray[0] = 100;
        intArray[1] = 10;
        intArray[2] = 1;
        intArray[3] = -100;
        intArray[4] = 5;
        for (int i = 0; i < intArray.length; i++)

            System.out.println(i);


        //System.out.println(Arrays.toString(intArray));

    }

    @And("I print all integer even numbers from integer array")
    public void iPrintAllIntegerEvenNumbersFromIntegerArray() {
        int[] intArray = new int[5];
        intArray[0] = 100;
        intArray[1] = 10;
        intArray[2] = 1;
        intArray[3] = -100;
        intArray[4] = 5;

        System.out.println(Arrays.toString(intArray));


    }

    @And("I print int {int} and I want to check it is empty")
    public void iPrintIntAndIWantToCheckItIsEmpty(int n) {

        int[] intArray = new int[5];
        intArray[0] = 100;
        intArray[1] = 10;
        intArray[3] = -100;
        intArray[4] = 5;

        System.out.println(intArray.length);

        if ((intArray[n]) == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty, and contains " + intArray[n]);
        }

    }

    @And("I print integer {int} and I want to check it is contains this {int}")
    public void iPrintIntAndIWantToCheckItIsContainsThere(int n, int m) {

        int[] intArray = new int[5];
        intArray[0] = 100;
        intArray[1] = 10;
        intArray[2] = 1;
        intArray[3] = -100;
        intArray[4] = 3;

        if (intArray[n] == m) {
            System.out.println("Integer " + n + " contains this " + intArray[n] + " element");
        } else {
            System.out.println("Integer " + n + " is not contains " + m + " element");
        }
    }

    @And("I solve Java task")
    public void iSolveJavaTask() {
    }

    @And("I write a program that prints the sum of the numbers 1 to {int}")
    public void iWriteAProgramThatPrintsTheSumOfTheNumbersTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;


        }
        System.out.println("sum = " + sum);

    }

    @And("I write a program that prints the sum only multiples of three or five of the numbers 1 to {int}")
    public void iWriteAProgramThatPrintsTheSumOnlyMultiplesOfThreeOrFiveOfTheNumbersTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                sum = sum + i;

            }


        }
        System.out.println("sum = " + sum);

    }

    @And("I write a program that takes a number {int} and gives the possibility to chose between computing the {string}")
    public void iWriteAProgramThatTakesANumberAndGivesThePossibilityToChoseBetweenComputingThe(int n, String option) {
        if (option.equals("sum")) {

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum = sum + i;

            }
            System.out.println("sum = " + sum);

        } else {
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product = product * i;
            }
            System.out.println("product = " + product);

        }
    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {
//        toSwap(3, 5);
//
//    }
//        void printDivBy3And4 ( int num){
//            if (num % 3 == 0 && num % 4 == 0) {
//                System.out.println();
//            }


    }
    @And("I work with Arrays")
    public void iWorkWithArrays() {


//        int[] arr = {5, 3, 2, 8, 4, 1};
//        sortArr(arr);
//
//
//
//    }
//
//    private void sortArr(int[] arr)
//    {
//        for (int j = 0; j < arr.length - 1; j++){
//
//
//        int idxMin = j;
//        int min = arr[idxMin];
//
//        for (int i = j + 1; i < arr.length; i++){
//            if (arr[i] < min){
//                min = arr[i];
//                idxMin = i;
//            }
//
//        }
//
//        //System.out.println("min = " + min);
//        int temp = arr[j];
//        arr[j] = min;
//        arr[idxMin] = temp;
//        System.out.println(Arrays.toString(arr));
//        }


        //  You have an array of numbers.
//  Your task is to sort odd numbers in ascending order
//  but even numbers must be on their places.
//  Example:
//  input:  [5, 3, 2, 8, 4, 1]
//  output: [1, 3, 2, 8, 4, 5]

//        int[] arr = {5, 3, 2, 8, 4, 1};
//        sortArr(arr);


//        private void sortArr ( int[] arr){
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] % 2 == 0) {
//                    continue;
//                }
//
//
//                int idxMin = j;
//                int min = arr[idxMin];
//
//                for (int i = j + 1; i < arr.length; i++) {
//                    if (arr[i] < min && arr[i] % 2 != 0) {
//                        min = arr[i];
//                        idxMin = i;
//                    }
//
//                }
//
//                //System.out.println("min = " + min);
//                int temp = arr[j];
//                arr[j] = min;
//                //if (arr[j] % 2 != 0) {
//                arr[idxMin] = temp;
//            }
//            System.out.println(Arrays.toString(arr));
//        }


    }


    @And("I create multiplication table for numbers up to {int}")
    public void iCreateMultiplicationTable(int n) {

            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= n; x++) {
                    System.out.print(x * y + "\t");

                }
                System.out.println();

            }
        }

    @And("I work with Arrays of lists")
    public void iWorkWithArraysOfLists() {

        //        Write a function that combines two arrays (lists) by alternating taking elements,
//        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
//        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].

        int[] arr1 = {0,5,8, 9, 1};
        int[] arr2 = {1,2,3};

        solveIt(arr1, arr2);

    }

    private void solveIt(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] res = new int[len];
        int min_len = arr1.length < arr2.length ? arr1.length : arr2.length;


        for (int k = 0; k < min_len * 2; k = k + 2){
            if (k < arr1.length){
                res[k] = arr1[k / 2];
                res[k + 1] = arr2[k / 2];

            }
            for (int idx = min_len; idx < arr1.length; idx++){

                int res_idx = min_len * 2 + idx - min_len;
                res[res_idx] = arr1[idx];


            }



        }
        System.out.println(Arrays.toString(res));
    }


    @And("I work with Classes")
    public void iWorkWithClasses() {
        Cat cat = new Cat("Tom");
        cat.eat("fish");
        cat.walk();

        Dog dog = new Dog("Bobby");
        dog.eat("meet");
        dog.walk();
    }
}











