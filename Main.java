import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        do {
            taskOptions();
            System.out.print("What would you like to do? ");
            int input = sc.nextInt();

            if (input > 3) {
                System.out.println("Invalid option");
            } else {
                sc.nextLine(); // consuming line space

                switch (input) {
                    case 1:
                        if (tasks.size() > 0)
                            fetchTasks(tasks);
                        else
                            System.out.println("No tasks to show");
                        break;
                    case 2:
                        System.out.print("Enter task title: ");
                        String titleInput = sc.nextLine();
                        if (titleInput == "")
                            System.out.println("Please enter a valid title");
                        else
                            tasks.add(titleInput);
                        break;
                    case 3:
                        if (tasks.size() > 0) {
                            fetchTasks(tasks);
                            System.out.print("Enter task number to remove: ");
                            int taskIndex = sc.nextInt();
                            if (taskIndex > 0 && taskIndex - 1 <= tasks.size()) {
                                tasks.remove(taskIndex - 1);
                                System.out.println("Task removed");
                            } else
                                System.out.println("Task doesn't exists");
                        } else {
                            System.out.println("No task to remove");
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option number");
                }

                System.out.println("--------------------------------------");
            }
        } while (true);
    }

    public static void taskOptions() {
        System.out.println("Options: ");
        System.out.println("1: View tasks");
        System.out.println("2: Add a task");
        System.out.println("3: Remove a task");
        System.out.println("0: Exit");
    }

    public static void fetchTasks(ArrayList tasks) {
        System.out.println("Your tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ": " + tasks.get(i));
        }
    }
}
