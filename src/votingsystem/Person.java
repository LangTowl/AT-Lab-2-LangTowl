package votingsystem;

public abstract class Person {
    private final int age;
    private final char gender;
    protected final String firstName;
    protected final String lastName;
    protected final String politicalParty;

    /**
     * Create a person - constructor
     * @param age - set person's age
     * @param gender - set person's gender
     * @param firstName - set person's first name
     * @param lastName - set person's last name
     * @param politicalParty - set person's political party
     */
    public Person(int age, char gender, String firstName, String lastName, String politicalParty) {
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;
    }

    /**
     * Getter for age
     * @return person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for gender
     * @return person's gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Abstract function to return persons name
     * @return person's name or title
     */
    public abstract String getFullName();
}