package pages;

public class Cat extends Animal{


    public Cat(String setName) {
        super(setName);
    }

    public void speak(){

        System.out.println("Cat " + getName() + " is meowing!");
    }

}
