
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManager {

    private List<Topic> lt = new ArrayList<>();
    private List<Course> lc = new ArrayList<>();
    private List<Learner> ll = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1.1.Add Topics to catalog
    public void addTopic() {
        System.out.print("Nhập ID của Topic: ");
        String id = sc.nextLine();
        for (Topic topic : lt) {
            if (topic.getTopicID().equalsIgnoreCase(id)) {
                System.out.println("ID đã bị trùng với chủ đề khác đang có trong ListTopic");
                return;
            }
        }
        System.out.print("Nhập tên của Topic: ");
        String name = sc.nextLine();
        System.out.print("Nhập loại (Long/Short): ");
        String type = sc.nextLine();
        
        Topic topic = new Topic(id, name, type);
        lt.add(topic);
        System.out.println("Đã thêm chủ đề thành công.");

        System.out.print("Bạn có muốn thêm Topic nữa không (Y/n): ");
        String yesOrNo = sc.nextLine();
        if (yesOrNo.trim().equalsIgnoreCase("Y")) {
            addTopic();
        } else {
            return;
        }

    }

    // 1.2.Update Topic
    public void updateTopic() {
        System.out.print("Nhập ID của Topic");
        String id = sc.nextLine();
        for (Topic topic : lt) {
            if (topic.getTopicID().trim().equalsIgnoreCase(id.trim())) {
                System.out.print("Nhập tên mới của Topic: ");
                String newName = sc.nextLine();
                System.out.print("Nhập type(String): ");
                String newType = sc.nextLine();
                System.out.print("Nhập duration(int): ");
                int newDuration = sc.nextInt();
                sc.nextLine();
                if (!newName.trim().equalsIgnoreCase("") && !newType.trim().equalsIgnoreCase("") && !(newDuration <= 0)) {
                    topic.setName(newName);
                    topic.setType(newType);
                    topic.setDuration(newDuration);
                    System.out.println("Đã cập nhật thành công");
                    return;
                } else {
                    System.out.println("Giá trị bạn nhập có cái không hợp lê");
                    return;
                }
            }
        }
    }

    // 1.3. Delete Topic
    public void deleteTopic() {
        System.out.print("Nhập ID Topic bạn muốn xóa: ");
        String id = sc.nextLine();
        for (Topic topic : lt) {
            if (topic.getTopicID().equalsIgnoreCase(id.trim())) {
                System.out.print("Bạn có chắc chắn muốn xóa Topic: " + topic.getName() + " (Y/n): ");
                String yesOrNo = sc.nextLine();
                if (yesOrNo.equalsIgnoreCase("Y")) {
                    Topic catchTopic = topic;
                    List<Topic> temp = lt;
                    temp.remove(catchTopic);
                    lt = temp;
                    System.out.println("Xóa thành công");
                    return;
                } else {
                    System.out.println("Bạn đã không xóa Topic: " + topic.getName());
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy ID của Topic bạn nhập");
    }

    //1.4 .Display all Topics
    public void displayAllTopics() {
        lt.sort(new Comparator<Topic>() {
            @Override
            public int compare(Topic o1, Topic o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Topic topic : lt) {
            System.out.println(topic);
        }
    }

    // 2.1.Add Course to Topic
    public void addCourseToTopic() {
        System.out.print("Chọn ID của Topic để add Course vào: ");
        String topicID = sc.nextLine();
        if(lt.isEmpty()){
            System.out.println("Chưa có Topic nào");
            return;
        }
        Topic catchTopic = null;
        for (Topic topic : lt) {
            if (topic.getTopicID().equalsIgnoreCase(topicID)) {
                catchTopic = topic;
                break;
            }
        }

        System.out.print("Nhập ID của Course: ");
        String id = sc.nextLine();
        for (Course course : lc) {
            if (course.getCourseID().equalsIgnoreCase(id.trim())) {
                System.out.println("Đã có Course có ID = " + id);
                return;
            }
        }
        System.out.print("Nhập tên của Course: ");
        String name = sc.nextLine();
        System.out.print("Hình thức (Online/Offline): ");
        String type = sc.nextLine();
        
        if (catchTopic != null) {
            Course course = new Course(id, name, type);
            course.setTopic(catchTopic);
            for (Topic topic : lt) {
                if (topic.equals(catchTopic)) {
                    topic.addCourseToTopic(course);
                    break;
                }
            }
            lc.add(course);
            System.out.println("Đã thêm khóa học thành công.");
        } else {
            System.out.println("Không tìm thấy chủ đề với ID này.");
        }
    }

    // 2.2 Update Course
    public void updateCourse() {
        System.out.print("Nhập ID của Course muốn update: ");
        String id = sc.nextLine();
        for (Course course : lc) {
            if (course.getCourseID().equalsIgnoreCase(id.trim())) {
                System.out.println("Old Infor: "+course.toString());
                System.out.print("Nhập tên mới của Course: ");
                String newName = sc.nextLine();
                System.out.print("Hình thức mới (Online/Offline): ");
                String newType = sc.nextLine();
                System.out.print("Nhập ngày bắt đầu mới: ");
                String newBeginDate = sc.nextLine();
                System.out.print("Nhập ngày kết thúc mới: ");
                String newEndDate = sc.nextLine();

                if (!newName.trim().equalsIgnoreCase("") && !newType.trim().equalsIgnoreCase("") && !newBeginDate.trim().equalsIgnoreCase("") && !newEndDate.trim().equalsIgnoreCase("")) {
                    course.setName(newName);
                    course.setType(newType);
                    course.setBeginDate(newBeginDate);
                    course.setEndDate(newEndDate);
                    System.out.println("Đã cập nhật thành công");
                } else {
                    System.out.println("Infor cannot blank");
                }
            }
        }
    }

    // 2.3.Delete Course
    public void deleteCourse() {
        
        System.out.print("Chọn IDTopic cần xóa Course: ");
        String id = sc.nextLine();
        System.out.print("Nhập ID của Course cần xóa: ");
        String idCourse = sc.nextLine();
        
        Course catchCourse = new Course();
        boolean isHas = false;
        for (Topic topic : lt) {
            if (topic.getTopicID().equalsIgnoreCase(id)) {
                List<Course> temp = topic.getListCourse();
                for (Course course : temp) {
                    if (course.getCourseID().equalsIgnoreCase(idCourse)) {
                        catchCourse = course;
                        temp.remove(course);
                        topic.setListCourse(temp);
                        isHas = true;
                        break;
                    }
                }
            }
        }
        if (isHas) {
            lc.remove(catchCourse); // xóa Course trong list tất cả các Course 
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    // 2.4.Display Course information
    public void displayCourseInformation() {
        for (Course course : lc) {
            List<Learner> temp = course.getLearners();
            int count = 0;
            int incomes = 0;
            for (Learner learner : temp) {
                if (learner.getScore() >= 5) {
                    count++;
                }
                incomes += course.getTuitionFee() * temp.size();
            }
            System.out.println("Course Name: "+course.getName() + ", Members: " + course.getLearners().size()+ ", Learner pass: " + count + ", incomes = " + incomes);
        }
    }

    // 3.1.Add Learner to Course
    public void addLearnerToCourse() {
        System.out.print("Nhập CourseID học viên muốn học: ");
        String courseID = sc.nextLine();
        for (Course course : lc) {
            if (course.getLearners().size() >= 35) {
                System.out.println("Course đã đủ 35 người");
                return;
            }
        }

        for (Course course : lc) {
            if (course.getCourseID().equalsIgnoreCase(courseID)) {
                System.out.print("Nhập ID của học viên: ");
                String id = sc.nextLine();
                System.out.print("Nhập Name của học viên: ");
                String name = sc.nextLine();
                Learner newLearner = new Learner(id, name);
                newLearner.setCourse(course);
                ll.add(newLearner); // add Learner vào ListLearner
                course.addLearner(newLearner); // add Learner vào Course
                System.out.println("Thêm thành công");
                return;
            }
        }
        System.out.println("ID Course không hợp lệ");
    }

    // 3.2.Enter scores for learners
    public void enterScore() {
        System.out.print("Nhập ID của sinh viên: ");
        String learnerID = sc.nextLine();
        System.out.println("Nhập ID môn học");
        String idCourse = sc.nextLine();
        System.out.print("Nhập điểm: ");
        double score = sc.nextDouble();
        sc.nextLine();
        if (score < 0 || score > 10) {
            System.out.println("Điểm = " + score + " không hợp lệ");
            return;
        }
        for (Learner learner : ll) {
            if (learner.getLearnerID().equalsIgnoreCase(learnerID) && learner.getCourse().getCourseID().equalsIgnoreCase(idCourse)) {
                learner.setScore(score);
                if (score >= 5) {
                    learner.setResult("Pass");
                } else {
                    learner.setResult("Fail");
                }

                for (Course course : lc) {
                    List<Learner> listLearnerTInCousre = course.getLearners();
                    for (Learner learner1 : listLearnerTInCousre) {
                        learner1.setScore(score);
                        if (score >= 5) {
                            learner.setResult("Pass");
                        } else {
                            learner.setResult("Fail");
                        }
                        System.out.println("Đã cập nhật điểm thành công cho sinh viên");
                        return;
                    }
                }
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID = " + learnerID);
    }

    // 3.3.Display Learner information
    public void displayLearnerInformation() {
        for (Learner learner : ll) {
            System.out.println( "ID: "+ learner.getLearnerID()+", " + learner.getName() + ": " +"Course: " +learner.getCourse().getName() + ", GPA: " + learner.getScore() + ", Result: " + learner.getResult());
        }
    }

    // 4.1.Search Topic
    public void searchTopic() {
        System.out.print("Nhập tên của Topic: ");
        String name = sc.nextLine();
        boolean isHas = false;
        for (Topic topic : lt) {
            if (topic.getName().contains(name)) {
                isHas = true;
                System.out.println(topic.toString());
            }
        }
        
        if(!isHas){
            System.out.println("KHÔNG có topic: "+name+" trong danh sách");
        }
    }

    // 4.2.Search Course
    public void searchCourseByTopic() {
        System.out.print("Nhập ID của Topic cần tìm Course: ");
        String idTopic = sc.nextLine();
        for (Course course : lc) {
            if (course.getTopic().getTopicID().equalsIgnoreCase(idTopic.trim())) {
                System.out.println(course);
            }
        }
    }

    public void searchCourseByName() {
        System.out.print("Nhập Name của Course cần tìm: ");
        String name = sc.nextLine();
        for (Course course : lc) {
            if (course.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(course);
            }
        }
    }
    
    // Extends
    public void showAllCourse(){
        int i = 0;
        for (Course course : lc) {
            i++;
            System.out.print(i +"."+ course.getName()+" ");
        }
        System.out.println("\n");
    }
}
