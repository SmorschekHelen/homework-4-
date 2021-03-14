package domain;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class Admin extends User {
    private Set<Permission> permissions = new HashSet<>();

    public Admin(String login, String password) {
        super(login, password);
        permissions.add(domain.Permission.READ);
        permissions.add(domain.Permission.MODERATE);
    }

    public Set<domain.Permission> getPermissions() {
        return permissions;
    }

    public void addPermission(domain.Permission permission) {
        permissions.add(permission);
    }

    public void deletePermission(Permission permission) {
        permissions.remove(permission);
    }


    @Override
    public void logout() {

    }
}
