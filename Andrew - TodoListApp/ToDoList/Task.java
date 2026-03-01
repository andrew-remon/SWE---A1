public class Task
{
    public enum Priority
    {
        HIGH,
        MEDIUM,
        LOW;

    public static Priority setPriority(int level)
    {
        switch(level)
        {
            case 1:
                return LOW;
            case 2:
                return MEDIUM;
            case 3:
                return HIGH;
            default:
                return LOW;
        }
    }
    }

    private String title;
    private String description;
    private Priority priority;
    private boolean isDone;

    Task(String title, int priorityLevel, String description)
    {
        this.title = title;
        this.priority = Priority.setPriority(priorityLevel);
        this.description = description;
        this.isDone = false;
    }

    Task() {}

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String newDescription)
    {
        description = newDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDone(boolean state)
    {
        isDone = state;
    }

    public boolean isDone() { return isDone; }

    public Priority getPriority() { return priority; }
}
