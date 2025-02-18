package votingsystem;

import exceptions.CandidateNotFoundException;
import exceptions.MissingCandidatesException;
import java.util.ArrayList;

public class VotingMachine {
    public ArrayList<Candidate> candidates;

    /**
     * Generates a new voting machine
     * @param candidates list of candidates
     * @throws MissingCandidatesException thrown if list of candidates is empty
     */
    public VotingMachine(ArrayList<Candidate> candidates) throws MissingCandidatesException {
        // Check to see if candidate list is empty, if so, don't create object and throw error
        if (candidates.isEmpty()) {
            throw new MissingCandidatesException("The candidate list cannot be null or empty");
        } else {
            this.candidates = candidates;
        }
    }

    /**
     * If voter hasn't voted and their candidate exists, increase that candidates vote count
     * @param v - Voter obj.
     * @param c - Candidate obj.
     * @throws CandidateNotFoundException - If candidate not found
     */
    public void vote(Voter v, Candidate c) throws CandidateNotFoundException {
        // Vote only counts if voter hasn't voted
        if (!v.hasVoted()) {
            // Loop through candidates to find voter's choice
            for (Candidate candidate : candidates) {
                // Check for match and execute operation
                if (candidate.getFullName().equals(c.getFullName())) {
                    candidate.incrementVoteCount();
                    v.voted();
                    return;
                }
            }

            // If loop finishes without finding match, candidate doesn't exist
            throw new CandidateNotFoundException("Candidate does not exist in the candidates collection");
        }
    }

    /**
     * Tally results
     */
    public void tally() {

        int max = -1;
        Candidate winner = null;

        for (Candidate candidate : candidates) {
            System.out.println(candidate.getFullName() + " has " + candidate.getVoteCount() + " votes.");

            if (candidate.getVoteCount() > max) {
                winner = candidate;
                max = candidate.getVoteCount();
            }
        }

        if (winner != null) {
            System.out.println(winner.getFullName() + " has won with " + winner.getVoteCount() + " votes.");
        } else {
            System.out.println("No winner found.");
        }
    }
}
