# LambdaExcercises

# Task1

Lambdafy the code

The code first fetches all the Tasks from a utility method getTasks.
Once you have the tasks, we filter all the reading tasks and extract the title field from each.
We add extracted title to a list and then finally return all the reading titles.
# Hints
Use Predicate<T> to filter the tasks.
Use Function<T,R> for extracting the title from the Task.
Use method reference for extractor
(Good to have) Write your own Functional Interface that clearly describes the intent of the developer.


# Task2

The code prints all the reading task titles,sorted by their title length.
Java 7 developers write this kind of code every day.
To write such a simple program, we had to write 15 lines of Java code.
The bigger problem in this code is not the number of lines a developer has to write but,
that it misses the developer's intent, i.e. filtering reading tasks, sorting by title length, and transforming to String List.
- Find all reading task titles sorted by their creation date.
- Find all reading tasks sorted by creation date in reverse.
- Find distinct tasks.
- Find top 2 reading tasks sorted by creation date.
- Find all unique tags from all tasks.
- Check if all reading tasks have tag books.
- Creating a summary of all titles.

# Hint
Use Streams.

# Task3

The Collectors utility class provides a lot of static utility methods for creating collectors for most common use cases
like accumulating elements into a Collection, grouping and partitioning elements,
or summarizing elements according to various criteria.
Refactore the code using lambda.

Also write the following functions:
- Finding Task with longest title
- Count total number of tags
- Generate summary of Task titles
- Grouping tasks by type
- Grouping by TaskType and createdOn


# How to sumbit your code

- Fork the Repository and solve the tasks
- Deadline is 12 November.
- I will review the code and give you feedback individually.
- Meanwhile feel free to ask me questions related with the tasks.
- I will upload my solutions after deadline is finished.
