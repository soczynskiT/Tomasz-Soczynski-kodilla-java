package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        final String testListName = "Important list";
        final String TestListDescription = "Some description.";
        TaskList testTaskList = new TaskList(testListName, TestListDescription);

        //When
        taskListDao.save(testTaskList);
        List<TaskList> allTasksLists = taskListDao.findByListName(testListName);

        //Then
        Assert.assertEquals(1, allTasksLists.size());

        //Clean
        taskListDao.delete(testTaskList.getId());

    }
}
