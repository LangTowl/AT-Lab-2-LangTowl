package votingsystem;

import exceptions.MinimumAgeException;

public class Candidate extends Person {
    private int voteCount;

    /**
     * Creates a candidate - Constructor
     * @param age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     */
    public Candidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);

        if (age < 25) {
            throw new MinimumAgeException("Candidate's is ineligible due to age");
        }
    }

    public int getVoteCount() {
        return voteCount;
    }

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
