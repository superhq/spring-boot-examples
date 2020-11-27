import java.lang.annotation.Annotation;

public class Main {
    @MyAnnotation
    public void test(){
        System.out.println("annotation test");
    }
    public static void main(String[] args) throws NoSuchMethodException {
        Main obj = new Main();
        obj.test();
        Annotation[] anns = obj.getClass().getMethod("java-base/test").getAnnotations();
        for (Annotation ann: anns
             ) {
            System.out.println(ann.toString());
        }
    }
}
