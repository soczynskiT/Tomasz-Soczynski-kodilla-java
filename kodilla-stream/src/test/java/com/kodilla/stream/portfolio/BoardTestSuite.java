package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        final User user1 = new User("developer1", "John Smith");
        final User user2 = new User("projectmanager1", "Nina White");
        final User user3 = new User("developer2", "Emilia Stephanson");
        final User user4 = new User("developer3", "Konrad Bridge");
        //task
        final Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        final Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(13),
                LocalDate.now().minusDays(5));
        final Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        final Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        final Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        final Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        final TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);

        final TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);

        final TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        final Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        final Board project = prepareTestData();
        //When
        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        final Board project = prepareTestData();
        //When
        final User user = new User("developer1", "John Smith");
        final List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        final Board project = prepareTestData();

        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        final long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }

    /*First method with two streams*/
    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        final Board project = prepareTestData();

        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        final double daysSum = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(f -> f.getTasks().stream())
                .mapToDouble(t -> LocalDate.from(t.getCreated()).until(LocalDate.now(), ChronoUnit.DAYS))
                .reduce(0.0, (sum, current) -> sum += current);
        final double tasksNo = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .mapToDouble(f -> f.getTasks().size())
                .sum();
        final double average = daysSum / tasksNo;
        //Then
        Assert.assertTrue(average == 23.0 / 3.0);
    }

    /*Second method with "star" - one stream*/
    @Test
    public void testAddTaskListAverageWorkingOnTask2() {
        //Given
        final Board project = prepareTestData();

        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));

        double average = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .mapToDouble(d -> LocalDate.from(d.getCreated()).until(LocalDate.now(), ChronoUnit.DAYS))
                .average().getAsDouble();
        //Then
        Assert.assertTrue(average == 23.0 / 3.0);
    }
}