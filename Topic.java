
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Topic {
    Random rd = new Random();
    private String topicID;
    private String name;
    private String type;  // Long-term or Short-term
    private String title;
    private int duration;
    private List<Course> listCourse;

    public Topic() {
    }
    
    
    public Topic(String topicID, String name, String type) {
        this.topicID = topicID;
        this.name = name;
        this.type = type;
        this.title = title;
        this.duration = rd.nextInt(10)+20;
        this.listCourse = new ArrayList<>();
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }
    
    

    public void addCourseToTopic(Course course) {
        listCourse.add(course);
    }
    
    

    @Override
    public String toString() {
        return "Topic{" + "ID=" + topicID + ", Name=" + name + ", Type=" + type + ", Title=" + title + ", Duration=" + duration + " days}";
    }
}
