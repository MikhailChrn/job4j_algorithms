package ru.job4j.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuickListTest {
    @Test
    void whenSortThenOk() {
        User user1 = new User(1, "11");
        User user2 = new User(1, "22");
        User user3 = new User(3, "33");
        User user4 = new User(-4, "44");
        User user5 = new User(4, "55");
        User user6 = new User(6, "66");
        Comparator<User> comparator = Comparator.comparingInt(User::getId);
        List<User> listUser = new ArrayList<>();
        listUser.add(user3);
        listUser.add(user5);
        listUser.add(user1);
        listUser.add(user4);
        listUser.add(user6);
        listUser.add(user2);
        QuickList.quickSort(listUser, comparator);
        List<Integer> result = listUser.stream().map(User::getId).toList();
        assertThat(result).containsExactly(-4, 1, 1, 3, 4, 6);
    }

    @Test
    void whenReverseOrderThenOk() {
        Comparator<Integer> comparator = (a, b) -> b - a;
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-8);
        list.add(1);
        list.add(0);
        list.add(10);
        list.add(1);
        list.add(8);
        QuickList.quickSort(list, comparator);
        System.out.println(list);
        assertThat(list).containsExactly(10, 8, 1, 1, 0, -2, -8);
    }

    @Test
    void caseWithTaskTitles() {
        Task task1 = new Task(1, "ab");
        Task task2 = new Task(2, "bc");
        Task task3 = new Task(3, "cd");
        Task task4 = new Task(4, "de");
        Task task5 = new Task(5, "ef");
        Task task6 = new Task(6, "fg");
        Comparator<Task> comparator = Comparator.comparing(Task::getTitle);
        List<Task> listTask = new ArrayList<>();
        listTask.add(task3);
        listTask.add(task5);
        listTask.add(task1);
        listTask.add(task4);
        listTask.add(task6);
        listTask.add(task2);
        QuickList.quickSort(listTask, comparator);
        List<String> result = listTask.stream().map(Task::getTitle).toList();
        assertThat(result).containsExactly("ab", "bc", "cd", "de", "ef", "fg");
    }

    private static class User {
        private Integer id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }

    private class Task {
        private Integer id;
        private String title;

        public Task(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}