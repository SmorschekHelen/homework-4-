package database;

import domain.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class DataBase {
    private static final List<User> users = new LinkedList<>();

    private DataBase(){
    }

    public static void addUser(User user){
        boolean userExists = users.stream()
                .anyMatch(userInDataBase -> userInDataBase.getLogin().equals(user.getLogin()));
        if (!userExists){
            users.add(user);
        }
    }
    public static void deleteUser(String login) {
        users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .ifPresent(users::remove);
    }
    public static void print() {
        System.out.println("--------------------------DB--------------------------");
        users.forEach(System.out::println);
    }

    public static void sort() {
        Collections.sort(users);
    }


}
