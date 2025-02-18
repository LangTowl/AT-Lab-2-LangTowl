package votingsystem;

import exceptions.MinimumAgeException;

public class Candidate extends Person {
    private int voteCount;

    /**
     * Creates a candidate - Constructor
     * @param age - set person's age
     * @param gender - set person's gender
     * @param firstName - set person's first name
     * @param lastName - set person's last name
     * @param politicalParty - set person's political party
     */
    public Candidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);

        // If candidate is less than 25, do not create candidate and throw error
        if (age < 25) {
            throw new MinimumAgeException("Candidate's age cannot be less than 25");
        } else {
            this.voteCount = 0;
        }
    }

    /**
     * Getter for vote count
     * @return - candidates vote count
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * Increase the candidates vote count
     */
    public void incrementVoteCount() {
        voteCount++;
    }

    /**
     * Determine name and political party
     * @return first and last name and political party
     */
    @Override public String getFullName() {
        return switch (super.politicalParty) {
            case "Democrat"      -> super.firstName + " " + super.lastName + " - D";
            case "Republican"    -> super.firstName + " " + super.lastName + " - R";
            case "Non-Affiliate" -> super.firstName + " " + super.lastName + " - N/A";
            default              -> super.firstName + " " + super.lastName;
        };
    }
}
