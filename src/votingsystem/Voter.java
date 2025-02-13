package votingsystem;

import exceptions.MinimumAgeException;

public class Voter extends Person {
    private final int voterID;
    private boolean voted;

    /**
     * Creates new voter
     * @param voterID - sets voter id
     * @param age - sets voter age
     * @param gender - sets voter gender
     * @param firstName - sets voter's first name
     * @param lastName - sets voter's last name
     * @param politicalParty - sets voter's political party
     * @throws MinimumAgeException - thrown if voter is under 18 years of age
     */
    public Voter(int voterID, int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);

        this.voterID = voterID;
        this.voted = false;

        // Check to see if voter is under 18, if so, don't create voter and throw error
        if (age < 18) {
            throw new MinimumAgeException("Voter’s age cannot be less than 18");
        }
    }

    /**
     * Getter for voter id
     * @return voter id number
     */
    public int getVoterID() {
        return voterID;
    }

    /**
     * Getter for voter status
     * @return boolean
     */
    public boolean hasVoted() {
        return voted;
    }

    /**
     * Toggles voted to true
     */
    public void voted() {
        this.voted = true;
    }

    /**
     * Return name of voter
     * @return First Name Last Name
     */
    @Override public String getFullName() {
        return super.firstName + " " + super.lastName;
    }
}

