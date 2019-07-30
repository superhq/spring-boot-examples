package my.spring.shiro.demo.model;

public class Perm {
    @Override
    public String toString() {
        return "Perm{" +
                "id=" + id +
                ", perm='" + perm + '\'' +
                '}';
    }

    private int id;
    private String perm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setperm(String perm) {
        this.perm = perm;
    }

    public String getperm() {
        return perm;
    }
    
}
