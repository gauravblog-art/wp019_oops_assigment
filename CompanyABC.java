import java.util.ArrayList;
import java.util.List;

public class CompanyABC {
    public static void main(String[] args) {
        // Create sample candidates
        Candidate candidate1 = new Candidate("Gaurav Kumar Mishra", "2000-05-15", true,
                new HSCExam(80, 75, 85, 90),
                new UGExam(8.5, 3),
                new PGExam(8.2),
                new Interview(40));

        Candidate candidate2 = new Candidate("Saurabh Kumar Mishra", "1998-09-20", true,
                new HSCExam(70, 65, 80, 75),
                new UGExam(7.8, 1),
                new PGExam(8.7),
                new Interview(30));

        // Create a list of candidates
        List<Person> candidates = new ArrayList<>();
        candidates.add(candidate1);
        candidates.add(candidate2);

        // Evaluate candidates
        Recruiter.evaluateCandidates(candidates);
    }
}
