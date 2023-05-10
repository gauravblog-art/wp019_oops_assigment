import java.util.ArrayList;
import java.util.List;

abstract class Person {
    private String name;
    private String dateOfBirth;
    private boolean isIndianCitizen;

    public Person(String name, String dateOfBirth, boolean isIndianCitizen) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isIndianCitizen = isIndianCitizen;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isIndianCitizen() {
        return isIndianCitizen;
    }

    public abstract boolean isEligible();
}

class HSCExam {
    private int physicsMarks;
    private int chemistryMarks;
    private int mathematicsMarks;
    private int biologyMarks;

    public HSCExam(int physicsMarks, int chemistryMarks, int mathematicsMarks, int biologyMarks) {
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.mathematicsMarks = mathematicsMarks;
        this.biologyMarks = biologyMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public int getMathematicsMarks() {
        return mathematicsMarks;
    }

    public int getBiologyMarks() {
        return biologyMarks;
    }

    public double getPCMPercentage() {
        return (physicsMarks + chemistryMarks + mathematicsMarks) / 3.0;
    }

    public double getPCBPercentage() {
        return (physicsMarks + chemistryMarks + biologyMarks) / 3.0;
    }
}

class UGExam {
    private double cgpa;
    private int projectsCount;

    public UGExam(double cgpa, int projectsCount) {
        this.cgpa = cgpa;
        this.projectsCount = projectsCount;
    }

    public double getCGPA() {
        return cgpa;
    }

    public int getProjectsCount() {
        return projectsCount;
    }
}

class PGExam {
    private double cgpa;

    public PGExam(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Interview {
    private int score;

    public Interview(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

class Recruiter {
    public static void evaluateCandidates(List<Person> candidates) {
        for (Person candidate : candidates) {
            if (candidate.isEligible()) {
                HRExecutive.notifyCandidate(candidate, true);
            } else {
                HRExecutive.notifyCandidate(candidate, false);
            }
        }
    }
}

class HRExecutive {
    public static void notifyCandidate(Person candidate, boolean isAccepted) {
        if (isAccepted) {
            System.out.println("Congratulations, " + candidate.getName() + "! You have been selected.");
        } else {
            System.out.println("Sorry, " + candidate.getName() + ". You did not meet the eligibility criteria.");
        }
    }
}

class Candidate extends Person {
    private HSCExam hscExam;
    private UGExam ugExam;
    private PGExam pgExam;
    private Interview interview;

    public Candidate(String name, String dateOfBirth, boolean isIndianCitizen,
                     HSCExam hscExam, UGExam ugExam, PGExam pgExam, Interview interview) {
        super(name, dateOfBirth, isIndianCitizen);
       
        this.hscExam = hscExam;
        this.ugExam = ugExam;
        this.pgExam = pgExam;
        this.interview = interview;
    }

    @Override
    public boolean isEligible() {
        int birthYear = Integer.parseInt(getDateOfBirth().substring(0, 4));

        // Check eligibility criteria
        if (birthYear >= 1999 &&
                hscExam.getPCMPercentage() >= 60 &&
                (isIndianCitizen() || hscExam.getPCBPercentage() >= 50) &&
                ugExam.getCGPA() >= 8 &&
                pgExam.getCGPA() >= 8 &&
                ugExam.getProjectsCount() >= 2 &&
                interview.getScore() >= 35 &&
                isIndianCitizen()) {
            return true;
        }

        return false;
    }
}
