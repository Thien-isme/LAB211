
public class Learner {
    private String learnerID;
    private String name;
    private String dateOfBirth;
    private double score;
    private String result;
    private Course course;
    
    public Learner(String learnerID, String name) {
        this.learnerID = learnerID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.score = 0;
        this.result = result;
        this.course = course;
    }

    public String getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    

    @Override
    public String toString() {
        return "Learner{" + "learnerID=" + learnerID + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", score=" + score + ", result=" + result + '}';
    }

    
}
