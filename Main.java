
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CourseManager manager = new CourseManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Topics to catalog");
            System.out.println("2. Update Topic");
            System.out.println("3. Delete Topic");
            System.out.println("4. Display all Topics");
            System.out.println("5. Add Course");
            System.out.println("6. Update Course");
            System.out.println("7. Delete Course");
            System.out.println("8. Display Course information");
            System.out.println("9. Add Learner to Course");
            System.out.println("10. Enter scores for learners");
            System.out.println("11. Display Learner information");
            System.out.println("12. Search Topic");
            System.out.println("13. Search Course By Topic");
            System.out.println("14. Search Course By Name");
            System.out.println("15. Show All Course");
            System.out.println("0. Quit");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    manager.addTopic();
                    break;
                case 2:
                    manager.updateTopic();
                    break;
                case 3:
                    manager.deleteTopic();
                    break;
                case 4:
                    manager.displayAllTopics();
                    break;

                case 5:
                    manager.addCourseToTopic();
                    break;
                case 6:
                    manager.updateCourse();
                    break;
                case 7:
                    manager.deleteCourse();
                    break;
                case 8:
                    manager.displayCourseInformation();
                    break;
                case 9:
                    manager.addLearnerToCourse();
                    break;
                case 10:
                    manager.enterScore();
                    break;
                case 11:
                    manager.displayLearnerInformation();
                    break;
                case 12:
                    manager.searchTopic();
                    break;
                case 13:
                    manager.searchCourseByTopic();
                    break;
                case 14:
                    manager.searchCourseByName();
                    break;
                    case 15:
                    manager.showAllCourse();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
