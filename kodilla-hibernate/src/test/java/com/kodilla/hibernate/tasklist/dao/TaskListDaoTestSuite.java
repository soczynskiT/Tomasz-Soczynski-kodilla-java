package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private TaskDao taskDao;

    @Transactional
    @Test
    public void testFindByListName() {
        //Given
        final String testListName = "Important list";
        final String TestListDescription = "Some description.";
        final TaskList testTaskList = new TaskList(testListName, TestListDescription);

        //When
        taskListDao.save(testTaskList);
        final Long testListId = testTaskList.getId();
        final List<TaskList> allTasksLists = taskListDao.findByListName(testListName);

        //Then
        Assert.assertEquals(1, allTasksLists.size());

        //Clear
        taskListDao.delete(testListId);
    }

    @Transactional
    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("ToDo list", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        final Long id = taskList.getId();

        //Then
        Assert.assertNotEquals(null, id);

        //Clean
        taskListDao.delete(id);
    }

    @Transactional
    @Test
    public void testNamedQueries() {
        //Given
        final Task task1 = new Task("Test: Study Hibernate", 3);
        final Task task2 = new Task("Test: Practice Named Queries", 6);
        final Task task3 = new Task("Test: Study native queries", 7);
        final Task task4 = new Task("Test: Make some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        final TaskList taskList = new TaskList("ToDo list", "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        Long id = taskList.getId();

        //When
        final List<Task> longTasks = taskDao.retrieveLongTasks();
        final List<Task> shortTasks = taskDao.retrieveShortTasks();
        final List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        final List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
        }
    }
}