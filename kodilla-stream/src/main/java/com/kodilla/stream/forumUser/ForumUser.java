package com.kodilla.stream.forumUser;

import java.time.LocalDate;

public class ForumUser {
    private final int userIdentifier;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsNo;

    public ForumUser(final int userIdentifier, final String userName, final char sex, final int year, final int month, final int day, final int postsNo) {
        this.userIdentifier = userIdentifier;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = LocalDate.of(year, month, day);
        this.postsNo = postsNo;
    }

    public int getUserIdentifier() {
        return userIdentifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsNo() {
        return postsNo;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userIdentifier=" + userIdentifier +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsNo=" + postsNo +
                '}';
    }
}