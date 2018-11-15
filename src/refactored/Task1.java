package refactored;

import static domain.Task.getTasks;
import static java.lang.System.out;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * We can also write our own Functional Interface that clearly describes the intent of the developer.
 * We can create an interface TaskExtractor that extends Function interface.
 * The input type of interface is fixed to Task and output type depend on the implementing lambda.
 * This way the developer will only have to worry about the result type, as input type will always remain Task.
 *
 */
interface TaskExtractor<R> extends Function<Task, R> {

    static TaskExtractor<Task> identityOp() {
        return t -> t;
    }
}

public class Task1 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<Task> filteredTasks = filterAndExtract(tasks, task -> task.getType() == TaskType.READING,
            TaskExtractor.identityOp());
        filteredTasks.forEach(out::println);
    }

    public static <R> List<R> filterAndExtract(List<Task> tasks, Predicate<Task> filterTasks,
        TaskExtractor<R> extractor) {
        List<R> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (filterTasks.test(task)) {
                readingTitles.add(extractor.apply(task));
            }
        }
        return readingTitles;
    }

}
