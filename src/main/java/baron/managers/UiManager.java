package baron.managers;

import java.util.List;

import baron.models.BaseModel;
import baron.models.Task;
/**
 * Manages all output by the bot
 */
public class UiManager {

    private static String formatOutput(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        return sb.toString();
    }
    /**
     * Informs user of added content but does not add anything itself
     *
     * @param task  Task added
     * @param count count of tasks currently in list after modification
     */
    public static String add(BaseModel task, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("Got it, I've added this task: \n  " + task);
        sb.append("\n");
        sb.append("Now you have " + count + " tasks in the list");
        return formatOutput(sb.toString());
    }

    /**
     * Informs user of deleted content
     *
     * @param item  Item added
     * @param count count of tasks currently in list after modification
     */
    public static <T> String delete(T item, int count) {
        String output = "Noted, I've removed this item: \n  " + item;
        output += "\nNow you have " + count + " items in the list";
        return formatOutput(output);
    }

    /**
     * Lists all tasks currently available in a pretty format
     */
    public static <T> String list(List<T> items) {
        if (items.size() == 0) {
            return formatOutput("You have no items. Add something, you serf.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append((i + 1) + ". " + items.get(i));
            sb.append("\n");
        }
        return formatOutput(sb.toString());
    }

    /**
     * Lists all commands and their descirptions
     */
    public static String help() {
        StringBuilder sb = new StringBuilder();
        sb.append("tasks: Lists all tasks\n");
        sb.append("clients: Lists all clients\n");
        sb.append("todo NAME: Creates a todo with the specified name\n");
        sb.append("deadline NAME /by d/M/yyy - Creates a deadline with a specified date. "
                  + "E.g. deadline Math homework /by 9/12/2024: Lists all tasks\n");
        sb.append("event NAME /from FROM /to TO: Creates an event with a specified from and to\n");
        sb.append("mark INDEX: Marks a specified task as done. E.g. mark 1\n");
        sb.append("unmark INDEX: Marks a specified task as not done. E.g. unmark 1\n");
        sb.append("delete INDEX: Deletes a specified task. E.g. delete 1\n");
        sb.append("discharge INDEX: Deletes a specified client. E.g. discharge 1\n");
        return formatOutput(sb.toString());
    }

    /**
     * Prints output for when user finds tasks
     *
     * @param tasks tasks to print out
     */
    public static String find(List<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        if (tasks.size() == 0) {
            return formatOutput("No tasks found. Maybe try another term, peasant.");
        }
        sb.append("Here are the matching tasks in your list:");
        sb.append("\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i));
            sb.append("\n");
        }
        return formatOutput(sb.toString());
    }

    /**
     * Marks the specified task
     *
     * @param task   Task to mark
     * @param isDone mark whether task is done or not
     */
    public static String mark(Task task, boolean isDone) {
        String doneStr = isDone ? "done" : "not done";
        String output = "Okay, I've marked this task as " + doneStr + ": \n" + task;
        return formatOutput(output);
    }
}
