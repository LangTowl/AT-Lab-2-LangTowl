package votingsystem;

public abstract class Person {
    private int age;
    private char gender;
    protected String firstName;
    protected String lastName;
    protected String politicalParty;

    /**
     * Create a person - constructor
     * @param age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     */
    public Person(int age, char gender, String firstName, String lastName, String politicalParty) {
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    // Abstract method -> why no implementation?
    public abstract String getFullName();
}