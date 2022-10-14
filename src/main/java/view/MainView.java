package view;
import controller.MemberController;
import model.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import javax.swing.*;
import java.sql.SQLException;

public class MainView extends JFrame {
    private JPanel panel1;
    private JToolBar toolbar;
    private JButton map;
    private JButton logout;
    private JComboBox comboBox1;
    private JTextField textField1;
    private ImageIcon image1;
    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/BeanConfig.xml");
    MemberController memberController = context.getBean("MemberController", MemberController.class);
    public MainView(){
        super("Main");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "로그아웃하셨습니다.");
            dispose();
            memberController.loginView();
        });
    }
    }

