package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "Simple Name 1", 'M', 1965, 06, 15, 10));
        userList.add(new ForumUser(2, "Simple Name 2", 'F', 2014, 11, 25, 0));
        userList.add(new ForumUser(3, "Simple Name 3", 'M', 1995, 03, 14, 2));
        userList.add(new ForumUser(4, "Simple Name 4", 'M', 2015, 01, 30, 1));
        userList.add(new ForumUser(5, "Simple Name 5", 'M', 1995, 10, 15, 5));
        userList.add(new ForumUser(6, "Simple Name 6", 'F', 1990, 06, 01, 0));
        userList.add(new ForumUser(7, "Simple Name 7", 'F', 1974, 06, 10, 12));
        userList.add(new ForumUser(8, "Simple Name 8", 'M', 1996, 12, 15, 0));
        userList.add(new ForumUser(9, "Simple Name 9", 'F', 1988, 02, 03, 3));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}