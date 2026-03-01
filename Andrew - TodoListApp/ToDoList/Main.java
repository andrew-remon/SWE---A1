import java.io.File;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void Program()
    {
        System.out.println("Welcome To Tasky - Your todo list app :)\n");
        System.out.println("What do you want to do...\n");
        System.out.println("[1] Add task.");
        System.out.println("[2] Delete task.");
        System.out.println("[3] Finish task.");
        System.out.println("[4] Show tasks List.");
        System.out.println("[5] Exit.");
    }

    public static String enterChoice()
    {
        System.out.print("Your Choice: ");
        String choice = scanner.next();
        return choice;
    }
    public static void main(String[] args)
    {
        FileHandler fileHandler = new FileHandler();
        TaskManager taskManager = new TaskManager(scanner, fileHandler);

        while (true)
        {
            Program();
            String choice = enterChoice();

            switch (choice)
            {
                case "1":
                    taskManager.addTask(); break;
                case "2":
                    taskManager.deleteTask(); break;
                case "3":
                    taskManager.markTask(); break;
                case "4":
                    fileHandler.showTasks(); break;
                case "5":
                    System.out.println("Goodbye!\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.\n");
            }

            System.out.println("------------------------------------------");
        }
    }
}
