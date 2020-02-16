import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Persion persion = new Persion("hongqun", "hongqun@EXAMPLE.com");
        System.out.println(persion.getEmail().toLowerCase());

        Persion1 persion1 = new Persion1("hongqun", "hongqun@EXAMPLE.com");
        System.out.println(persion1.getEmail().map(String::toLowerCase).orElse("not provide email"));

        Persion2 persion2 = new Persion2("hongqun", null);
        System.out.println(persion2.getEmail());
    }
}

class Persion{
    private String name;
    private String email;
    public Persion(String name,String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Persion1{
    private String name;
    private String email;
    public Persion1(String name,String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

class Persion2{
    private String name;
    private String email;
    public Persion2(String name,String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Optional.ofNullable(email).map(String::toLowerCase).orElse("not provide email");
    }
}