import java.io.File;
import java.util.Scanner;

public class TaskManager
{
    private Scanner scanner;
    private FileHandler file;

    TaskManager(Scanner scanner, FileHandler file)
    {
        this.scanner = scanner;
        this.file = file;
    }

    public void addTask()
    {
        System.out.println("What is your task? ");
        String taskTitle = scanner.nextLine();

        System.out.println("\nChoose Your Task Priority:");
        System.out.println("High   -> 3");
        System.out.println("Medium -> 2");
        System.out.println("Low    -> 1");

        int taskPriority = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nDo you any description/details for this task? ");
        String taskDescription = scanner.nextLine();

        Task task = new Task(taskTitle, taskPriority, taskDescription);


        file.saveTaskInFile(task);

        System.out.println("\nTask Added Successfully :)\n");
    }

    public void deleteTask()
    {
        System.out.println("Please Enter You task Title?");
        String taskTitle = scanner.nextLine();

        while(!file.isTaskFound(taskTitle))
        {
            System.out.println("Task Not Found, please enter a valid task: ");
            taskTitle = scanner.nextLine();
        }

        Task task = file.getTask(taskTitle);

        System.out.println("Are You sure you want to delete this task? (Y/N)");
        String answer = scanner.next();

        if (answer.toLowerCase().equals("y"))
        {
            file.deleteTaskRecord(task);
            System.out.println("Task Deleted Successfully!\n");
        }
    }

    public void markTask()
    {
        System.out.println("Please Enter You task Title?");
        String taskTitle = scanner.nextLine();

        while(!file.isTaskFound(taskTitle))
        {
            System.out.println("Task Not Found, please enter a valid task: ");
            taskTitle = scanner.nextLine();
        }

        Task task = file.getTask(taskTitle);

        System.out.println("Are You sure you want to mark this task as finished? (Y/N)");
        String answer = scanner.next();

        if (answer.toLowerCase().equals("y"))
        {
            task.setDone(true);
            file.updateTaskRecord(task);

            System.out.println("Do You want to delete this task? (Y/N)");
            answer = scanner.next();

            if (answer.toLowerCase().equals("y"))
            {
                file.deleteTaskRecord(task);
                System.out.println("Task Deleted Successfully!\n");
            }
        }
    }
}
