package my.spring.shiro.demo.model;

import java.util.List;

public class Role {
    private int id;
    private String name;
    private List<Perm> perms;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", perms=" + perms +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerms(List<Perm> perms) {
        this.perms = perms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Perm> getPerms() {
        return perms;
    }


}
