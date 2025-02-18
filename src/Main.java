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
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c2 = new Candidate(22, 'F', "Mary", "Doe", "Democrat");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c3 = new Candidate(28, 'F', "Sue", "Stone", "Non-Affiliate");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        // Create list of candidates
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        if (c1 != null) { candidates.add(c1); }
        if (c2 != null) { candidates.add(c2); }
        if (c3 != null) { candidates.add(c3); }

        // Create voting machine
        VotingMachine vm = null;
        try {
            vm = new VotingMachine(candidates);
        } catch (MissingCandidatesException e) {
            System.out.println(e.getMessage());
        }

        // Create voters
        Voter v1 = null;
        Voter v2 = null;
        Voter v3 = null;
        Voter v4 = null;
        Voter v5 = null;

        try {
            v1 = new Voter(1234, 30, 'M', "Sam", "Smith", "Republican");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            v2 = new Voter(4567, 20, 'F', "Jill", "Elizabeth", "Democrat");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            v3 = new Voter(1342, 17, 'M', "Bob", "Guy", "Republican");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            v4 = new Voter(5134, 99, 'F', "Sarah", "Lyn", "Democrat");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            v5 = new Voter(1983, 37, 'M', "Cleveland", "Brown", "Non-Affiliate");
        } catch (MinimumAgeException e) {
            System.out.println(e.getMessage());
        }

        // Vote
        try {
            if (v1 != null && c1 != null) { vm.vote(v1, c1); }
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (v2 != null && c2 != null) { vm.vote(v2, c2); }
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (v3 != null && c3 != null) { vm.vote(v3, c3); }
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (v4 != null && c3 != null) { vm.vote(v4, c3); }
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (v5 != null && c3 != null) { vm.vote(v5, c3); }
        } catch (CandidateNotFoundException e) {
            System.out.println(e.getMessage());
        }

        vm.tally();
    }
}