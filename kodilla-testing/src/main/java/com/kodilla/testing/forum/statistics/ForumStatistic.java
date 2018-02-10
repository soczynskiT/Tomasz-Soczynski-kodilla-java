package com.kodilla.testing.forum.statistics;

import java.util.HashMap;

public class ForumStatistic {
    private int usersNo;
    private int postsNo;
    private int commentsNo;
    private double averagePostPerUserNo;
    private double averageCommentsPerUserNo;
    private double averageCommentsPerPostsNo;
    private Statistics statistics;

    public ForumStatistic(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getUsersNo() {
        return usersNo;
    }

    public int getPostsNo() {
        return postsNo;
    }

    public int getCommentsNo() {
        return commentsNo;
    }

    public double getAveragePostPerUserNo() {
        return averagePostPerUserNo;
    }

    public double getAverageCommentsPerUserNo() {
        return averageCommentsPerUserNo;
    }

    public double getAverageCommentsPerPostsNo() {
        return averageCommentsPerPostsNo;
    }

    public void calculateAdvStatistics() {
        for (String userName : statistics.usersNames()) {
            usersNo++;
        }

        if (this.getUsersNo() > 0) {
            postsNo = statistics.postsCount();
            averagePostPerUserNo = this.getPostsNo() / (double) this.getUsersNo();

            if (this.getPostsNo() > 0) {
                commentsNo = statistics.commentsCount();
                averageCommentsPerUserNo = this.getCommentsNo() / (double) this.getUsersNo();
                averageCommentsPerPostsNo = this.getCommentsNo() / (double) this.getPostsNo();
            }
        }
    }

    public String showStatistics() {
        final HashMap<String, Double> statisticPreview = new HashMap<>();
        statisticPreview.put("Forum users quantity: ", (double) this.getUsersNo());
        statisticPreview.put("Forum posts quantity: ", (double) this.getPostsNo());
        statisticPreview.put("Forum comments quantity: ", (double) this.getCommentsNo());
        statisticPreview.put("Average posts no per user: ", this.getAveragePostPerUserNo());
        statisticPreview.put("Average comments no per user: ", this.getAverageCommentsPerUserNo());
        statisticPreview.put("Average comments no per post: ", this.getAverageCommentsPerPostsNo());
        return statisticPreview.toString();
    }
}