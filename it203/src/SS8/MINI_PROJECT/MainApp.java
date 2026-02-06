package SS8.MINI_PROJECT;

public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        int choice;

        do {
            manager.showMenu();
            choice = manager.readMenuChoice();

            switch (choice) {
                case 1:
                    manager.addStudentFlow();
                    break;
                case 2:
                    manager.showAll();
                    break;
                case 3:
                    manager.searchFlow();
                    break;
                case 4:
                    manager.updateStudentFlow();
                    break;
                case 5:
                    manager.deleteStudentFlow();
                    break;
                case 6:
                    manager.sortFlow();
                    break;
                case 7:
                    manager.findByRankFlow();
                    break;
                case 8:
                    manager.statistic();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:

            }
        } while (choice != 9);
    }
}
