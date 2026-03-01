import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler
{
    File file = new File("tasks.txt");

    public FileHandler() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public void saveTaskInFile(Task task)
    {
        String taskRecord = convertTaskObjectIntoRecord(task);
        try
        {
            // false = overwrite, true = append
            FileWriter writer = new FileWriter("tasks.txt", true);
            writer.write(taskRecord + "\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    public void showTasks()
    {
        try
        {
            List<String> lines = Files.readAllLines(Path.of("tasks.txt"));

            if (lines.size() == 0)
            {
                System.out.println("\nThere's no tasks\n");
                return;
            }

            System.out.println("\nHere are your tasks: \n");
            for (String line : lines)
            {
                System.out.println(line + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error Showing Task: " + e.getMessage());
        }
    }

    public Task getTask(String taskTitle)
    {
        List<Task> tasks = convertTaskRecordsIntoObjects();

        for (Task task : tasks)
            if (task.getTitle().equals(taskTitle)) return task;

        return null;
    }

    public void deleteTaskRecord(Task deletedTask)
    {
        List<Task> tasks = convertTaskRecordsIntoObjects();

        tasks.removeIf(task -> task.getTitle().equals(deletedTask.getTitle()));

        applyChanges(tasks);
    }

    public boolean isTaskFound(String taskTitle)
    {
        List<Task> tasks = convertTaskRecordsIntoObjects();

        for (Task task : tasks)
            if (task.getTitle().equals(taskTitle)) return true;

        return false;
    }

    public List<Task> convertTaskRecordsIntoObjects()
    {
        List<Task> tasks = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Path.of("tasks.txt"));

            for (String line : lines)
            {
                String[] taskParts = line.split("\\|");

                String taskTitle = taskParts[0];
                int priority = convertPriorityToLevel(taskParts[1]);
                boolean isDone = Boolean.parseBoolean(taskParts[2]);
                String description = taskParts[3];

                Task task = new Task(taskTitle, priority, description);
                if (isDone) task.setDone(true);
                tasks.add(task);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error saving task: " + e.getMessage());
        }

        return tasks;
    }

    public static String convertTaskObjectIntoRecord(Task task)
    {
        return task.getTitle() + "|" + task.getPriority() + "|" + task.isDone() + "|" + task.getDescription();
    }

    public void updateTaskRecord(Task updatedTask)
    {
        List<Task> tasks = convertTaskRecordsIntoObjects();

        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getTitle().equals(updatedTask.getTitle()))
            {
                tasks.set(i, updatedTask);
                break;
            }
        }
        applyChanges(tasks);
    }

    public void applyChanges(List<Task> tasks)
    {
        try
        {
            FileWriter writer = new FileWriter("tasks.txt", false);
            for (Task task : tasks)
            {
                String taskRecord = convertTaskObjectIntoRecord(task);
                writer.write(taskRecord + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    public int convertPriorityToLevel(String Priority)
    {
        switch (Priority) {
            case "HIGH":
                return 3;
            case "MEDIUM":
                return 2;
            case "LOW":
                return 1;
            default:
                return 3;
        }
    }

}
