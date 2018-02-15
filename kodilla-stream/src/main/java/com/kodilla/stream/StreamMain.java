package com.kodilla.stream;


import com.kodilla.stream.forumUser.Forum;
import com.kodilla.stream.forumUser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        final Forum theForum = new Forum();
        Map<Integer, ForumUser> resultMapOfForumUsers = theForum.getUserList().stream()
                .filter(f -> f.getSex() == 'M')
                .filter(f -> LocalDate.from(f.getBirthDate()).until(LocalDate.now(), ChronoUnit.YEARS) >= 20)
                .filter(f -> f.getPostsNo() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserIdentifier, user -> user));

        System.out.println("Result map:");
        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        /*Checking every filter */
        System.out.println("\nFiltering users by sex = 'M':");
        final List<ForumUser> listSortedBySex = theForum.getUserList().stream()
                .filter(f -> f.getSex() == 'M')
                .collect(Collectors.toList());
        listSortedBySex.stream()
                .forEach(System.out::println);

        System.out.println("\nFiltering users by years old >= 20:");
        final List<ForumUser> listSortedByYears = listSortedBySex.stream()
                .filter(f -> LocalDate.from(f.getBirthDate()).until(LocalDate.now(), ChronoUnit.YEARS) >= 20)
                .collect(Collectors.toList());
        listSortedByYears.stream()
                .forEach(System.out::println);

        System.out.println("\nFiltering users by posts no >=1:");
        final List<ForumUser> listSortedByPostsNo = listSortedByYears.stream()
                .filter(f -> f.getPostsNo() >= 1)
                .collect(Collectors.toList());
        listSortedByPostsNo.stream()
                .forEach(System.out::println);

        System.out.println("\nChanging filtered list to Map:");
        final Map<Integer, ForumUser> mapOfFilteredUsers = listSortedByPostsNo.stream()
                .collect(Collectors.toMap(ForumUser::getUserIdentifier, user -> user));
        mapOfFilteredUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .forEach(System.out::println);
    }
}