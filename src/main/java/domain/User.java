package domain;

import java.util.Objects;

public abstract class User implements Logo, Comparable<User> {
    protected String login;
    protected String password;
    private boolean logged;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean login() {

        if (!logged) {
            logged = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(User user) {
        int result = this.login.compareTo(user.getLogin());
        result = result == 0 ? this.password.compareTo(user.getPassword()) : result;
        result = result == 0 ? (this.logged == user.isLogged() ? 0 : 1) : result;
        return result;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        User user = (User) that;
        return logged == user.logged
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, logged);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", logged=" + logged +
                '}';

    }
}


