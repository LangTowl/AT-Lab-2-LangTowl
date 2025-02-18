import votingsystem.*;
import exceptions.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CandidateNotFoundException, MinimumAgeException, MissingCandidatesException {
        // Define candidates
        Candidate c1 = null;
        Candidate c2 = null;
        Candidate c3 = null;

        // Create new candidates & handle exceptions
        try {
            c1 = new Candidate(40, 'M', "Bobby", "Joe", "Republican");
            c2 = new Candidate(43, 'F', "Mary", "Doe", "Democrat");
            c3 = new Candidate(25, 'F', "Sue", "Stone", "Non-Affiliate");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        // Create list of candidates
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        candidates.add(c1);
        candidates.add(c2);
        candidates.add(c3);

        // Create voting machine
        VotingMachine vm = null;
        try {
            vm = new VotingMachine(candidates);
        } catch (MissingCandidatesException e) {
            System.out.println(e.getMessage());
        }

        // Create voters
        // TODO: Create 10 voters also add try catch for voters that are too young
        Voter v1 = new Voter(1234, 26, 'M', "Sam", "Brown", "Republican");

        // Vote
        try {
            vm.vote(v1, c1);
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        vm.tally();
    }
}