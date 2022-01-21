package pages;

public class Animal {
    //fields
    protected String name;

    //constructor
    public Animal(String setName) {
        setName("nameless one");

    }

    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Whatereve");
        }

    }

    public String getName() {
        return name;

    }
    //methods

    public void walk() {

        System.out.println(getClass() + " " + name + " is walking!");
    }

    public void eat(String what) {

        System.out.println(getClass() + " " + name + " is eating " + what + "!");
    }
}
