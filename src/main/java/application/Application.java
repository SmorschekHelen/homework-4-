package application;

import database.DataBase;
import domain.Member;
import domain.Admin;

public class Application {
    public static void main(String[] args) {

        Admin admin = new Admin("admin", "admin");
        Member member = new Member("member", "member", null);

        DataBase.addUser(member);
        DataBase.addUser(admin);

        DataBase.print();

        DataBase.sort();
        DataBase.print();

        DataBase.deleteUser("admin");
        DataBase.print();

    }


}


