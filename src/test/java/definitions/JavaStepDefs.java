package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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
}

