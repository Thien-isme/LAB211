import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Course {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    private String courseID;
    private String name;
    private String type;  // Online or Offline
    private String title;
    private String beginDate;
    private String endDate;
    private double tuitionFee;
    private Topic topic;
    private List<Learner> learners;

    public Course() {
    }

    
    public Course(String courseID, String name, String type) {
        this.courseID = courseID;
        this.name = name;
        this.type = type;
        this.title = title;
        this.beginDate = (rd.nextInt(3)+1)+"";
        this.endDate = (rd.nextInt(3)+29)+"";
        this.tuitionFee = 500;
        this.topic = topic;
        this.learners = new ArrayList<>();
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Learner> getLearners() {
        return learners;
    }

    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }

    public void addLearner(Learner learner) {
        learners.add(learner);
    }

    public void enterScore(String learnerID, double score) {
        for (Learner learner : learners) {
            if (learner.getLearnerID().equalsIgnoreCase(learnerID)) {
                learner.setScore(score);
            }
        }
    }

    public void displayLearnerInformation() {
        for (Learner learner : learners) {
            System.out.println(learner);
        }
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", name=" + name + ", type=" + type + ", title=" + title + ", beginDate=" + beginDate + ", endDate=" + endDate + ", tuitionFee=" + tuitionFee + ", topic=" + topic.getName() + ", Members=" + learners.size() + '}';
    }

    
}
