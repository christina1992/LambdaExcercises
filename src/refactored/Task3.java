package refactored;

import static domain.Task.getTasks;
import static java.lang.System.out;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import domain.Task;
import domain.TaskType;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Task3 {

    public static void main(String[] args) {
        allTitles(getTasks()).forEach(out::println);
        out.println(taskWithLongestTitle(getTasks()));
        out.println("\n");
        uniqueTitles(getTasks()).forEach(out::println);
        out.println("\n");
        Map<TaskType, List<Task>> taskTypeTaskMap = groupTasksByType(getTasks());
        taskTypeTaskMap.forEach((key, value) -> out.println(String.format("%s =>> %s", key, value)));
        out.println("\n");
        out.println(titleSummary(getTasks()));
        out.println(totalTagCount(getTasks()));
    }

    private static List<String> allTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(toList());
    }

    private static Set<String> uniqueTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(toSet());
    }

    private static Map<TaskType, List<Task>> groupTasksByType(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType));
    }

    private static Map<TaskType, Map<LocalDate, List<Task>>> groupTasksByTypeAndCreationDate(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType, groupingBy(Task::getCreatedOn)));
    }

    private static String titleSummary(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(joining(";"));
    }

    private static Task taskWithLongestTitle(List<Task> tasks) {
        return tasks.stream().collect(
            collectingAndThen(maxBy(Comparator.comparingInt(t -> t.getTitle().length())), Optional::get));
    }

    private static int totalTagCount(List<Task> tasks) {
        return tasks.stream().mapToInt(task -> task.getTags().size()).sum();
    }
}
