package votingsystem;

import exceptions.CandidateNoteFoundException;
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
        this.candidates = candidates;

        // Check to see if candidate list is empty, if so, don't create object and throw error
        if (candidates.isEmpty()) {
            throw new MissingCandidatesException("The candidate list cannot be null or empty");
        }
    }

    /**
     * If voter hasn't voted and their candidate exists, increase that candidates vote count
     * @param v - Voter obj.
     * @param c - Candidate obj.
     * @throws CandidateNoteFoundException - If candidate not found
     */
    public void vote(Voter v, Candidate c) throws CandidateNoteFoundException {
        // Vote only counts if voter hasn't voted
        if (v.hasVoted()) {
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
            throw new CandidateNoteFoundException("Candidate does not exist in the candidates collection");
        }
    }

    /**
     * Tally results
     */
    public void tally() {
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getFullName() + " has " + candidate.getVoteCount() + " votes.");
        }
    }
}
