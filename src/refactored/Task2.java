package refactored;

import static domain.Task.getTasks;
import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import domain.Task;
import domain.TaskType;
import java.util.Comparator;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<String> readingTasks = tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .sorted(Comparator.comparingInt(t -> t.getTitle().length()))
            .map(Task::getTitle)
            .collect(toList());

        readingTasks.forEach(out::println);
        out.println("\n");
        allDistinctTags(getTasks()).forEach(out::println);
        out.println("\n");
        allReadingTasks(getTasks()).forEach(out::println);
        out.println("\n");
        allReadingTasksSortedByCreatedOnDesc(getTasks()).forEach(out::println);
        out.println("\n");
        allDistinctTasks(getTasks()).forEach(out::println);
        out.println("\n");
        topN(getTasks(), 2).forEach(out::println);
        out.println("\n");
        out.println(countAllReadingTasks(getTasks()));
        out.println("\n");
        out.println(joinAllTaskTitles(getTasks()));
        out.println(isAllReadingTasksWithTagBooks(getTasks()));
    }

    private static List<String> allDistinctTags(List<Task> tasks) {
        return tasks.stream().flatMap(task -> task.getTags().stream()).distinct().collect(toList());
    }

    private static List<String> allReadingTasks(List<Task> tasks) {
        return tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .sorted(comparing(Task::getCreatedOn))
            .map(Task::getTitle)
            .collect(toList());
    }

    private static boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        return tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .allMatch(task -> task.getTags().contains("books"));
    }

    private static List<String> allReadingTasksSortedByCreatedOnDesc(List<Task> tasks) {
        return tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .sorted(comparing(Task::getCreatedOn).reversed())
            .map(Task::getTitle)
            .collect(toList());
    }

    private static List<Task> allDistinctTasks(List<Task> tasks) {
        return tasks.stream().distinct().collect(toList());
    }

    private static List<String> topN(List<Task> tasks, int n) {
        return tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .sorted(comparing(Task::getCreatedOn))
            .map(Task::getTitle)
            .limit(n)
            .collect(toList());
    }

    private static long countAllReadingTasks(List<Task> tasks) {
        return tasks.stream()
            .filter(task -> task.getType() == TaskType.READING)
            .count();
    }

    private static String joinAllTaskTitles(List<Task> tasks) {
        return tasks.stream()
            .map(Task::getTitle)
            .reduce((first, second) -> first + " *** " + second)
            .get();
    }
}
