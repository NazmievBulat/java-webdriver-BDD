package pages;

public class Dog extends Animal{


    public Dog(String setName) {
        super(setName);
    }

    public void speak(){

        System.out.println("Dog " + name + " is barking!");
    }
}
