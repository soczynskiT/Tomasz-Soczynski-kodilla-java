package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuit {
    private static int testCounter = 0;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting main test for ForumStatistics");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finishing main test for ForumStatistics");
    }

    @Before
    public void before() {
        testCounter++;
        System.out.println("starting test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("Closing test #" + testCounter);
    }

    @Test /*Test checking behavior of main method with posts quantity value = 0 */
    public void testCalculateAdvStatisticsForNullPostsCount() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("User");
        int postsQuantity = 0;
        int commentsQuantity = 1;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 0);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 0);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 0);
    }

    @Test /*Test checking behavior of main method with posts quantity value = 1000 */
    public void testCalculateAdvStatisticsForRequestedPostsCount() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("User");
        int postsQuantity = 1000;
        int commentsQuantity = 1000;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 1000);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 1000);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 1);
    }

    @Test /*Test checking behavior of main method with comments quantity value = 0 */
    public void testCalculateAdvStatisticsForNullCommentsCount() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("User");
        int postsQuantity = 10;
        int commentsQuantity = 0;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 10);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 0);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 0);
    }

    @Test /*Test checking behavior of main method with comments quantity value is less than posts quantity */
    public void testCalculateAdvStatisticsCommentsNoLessThanPostsNoCount() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("User");
        int postsQuantity = 10;
        int commentsQuantity = 1;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 10);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 1);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 0.1);
    }

    @Test /*Test checking behavior of main method with comments quantity value is bigger than posts quantity */
    public void testCalculateAdvStatisticsCommentsNoBiggerThanPostsNoCount() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("User");
        int postsQuantity = 1;
        int commentsQuantity = 10;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 1);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 10);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 10);
    }

    @Test /*Test checking behavior of main method for 0 users value */
    public void testCalculateAdvStatisticsForNullUsersList() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        int postsQuantity = 10;
        int commentsQuantity = 1;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 0);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 0);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 0);
    }

    @Test /*Test checking behavior of main method for requested users number */
    public void testCalculateAdvStatisticsForRequestedUsersNo() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        int postsQuantity = 10;
        int commentsQuantity = 1;

        when(statisticMock.postsCount()).thenReturn(postsQuantity);
        when(statisticMock.commentsCount()).thenReturn(commentsQuantity);
        when(statisticMock.usersNames()).thenReturn(usersNames);

        ForumStatistic forumStatistic = new ForumStatistic(statisticMock);
        //When
        forumStatistic.calculateAdvStatistics();
        //Then
        Assert.assertTrue(forumStatistic.getAveragePostPerUserNo() == 0.1);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerUserNo() == 0.01);
        Assert.assertTrue(forumStatistic.getAverageCommentsPerPostsNo() == 0.1);
    }
}