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

    public void setUsersNo(int usersNo) {
        this.usersNo = usersNo;
    }

    public void setPostsNo(int postsNo) {
        this.postsNo = postsNo;
    }

    public void setCommentsNo(int commentsNo) {
        this.commentsNo = commentsNo;
    }

    public void setAveragePostPerUserNo(double averagePostPerUserNo) {
        this.averagePostPerUserNo = averagePostPerUserNo;
    }

    public void setAverageCommentsPerUserNo(double averageCommentsPerUserNo) {
        this.averageCommentsPerUserNo = averageCommentsPerUserNo;
    }

    public void setAverageCommentsPerPostsNo(double averageCommentsPerPostsNo) {
        this.averageCommentsPerPostsNo = averageCommentsPerPostsNo;
    }


    public void calculateAdvStatistics() {
        int usersNo = 0;
        for (String userName : statistics.usersNames()) {
            usersNo++;
        }
        this.setUsersNo(usersNo);

        if (this.getUsersNo() > 0) {
            this.setPostsNo(statistics.postsCount());
            this.setAveragePostPerUserNo(this.getPostsNo() / (double) this.getUsersNo());

            if (this.getPostsNo() > 0) {
                this.setCommentsNo(statistics.commentsCount());
                this.setAverageCommentsPerUserNo(this.getCommentsNo() / (double) this.getUsersNo());
                this.setAverageCommentsPerPostsNo(this.getCommentsNo() / (double) this.getPostsNo());
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