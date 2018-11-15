package refactored;

import static domain.Task.getTasks;
import static java.lang.System.out;

import domain.Task;
import domain.TaskType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1_1 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        //This is the solution
        List<String> titles = filterAndExtract(tasks, task -> task.getType() == TaskType.READING, Task::getTitle);
        titles.forEach(out::println);
        //This is extra
        List<LocalDate> createdOnDates = filterAndExtract(tasks, task -> task.getType() == TaskType.READING,
            Task::getCreatedOn);
        createdOnDates.forEach(out::println);
        List<Task> filteredTasks = filterAndExtract(tasks, task -> task.getType() == TaskType.READING,
            Function.identity());
        filteredTasks.forEach(out::println);
    }

    public static <R> List<R> filterAndExtract(List<Task> tasks, Predicate<Task> filterTasks,
        Function<Task, R> extractor) {
        List<R> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (filterTasks.test(task)) {
                readingTitles.add(extractor.apply(task));
            }
        }
        return readingTitles;
    }
}
