import controller.MemberController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/BeanConfig.xml");
    private static MemberController controller = context.getBean("MemberController", MemberController.class);

    public static void main(String[] args) {
        controller.loginView();
    }

}
