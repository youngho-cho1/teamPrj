package view;
import controller.MemberController;
import model.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
public class LoginView extends JFrame {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel joinPanel;
    private JLabel joinLabel;
    private JTextField goJoinTextField;
    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/BeanConfig.xml");
    MemberController memberController = context.getBean("MemberController", MemberController.class);
    public LoginView() {
        super("Login");
        goJoinTextField.setFont(new Font("Serif", Font.BOLD, 11));
        goJoinTextField.setForeground(Color.blue);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(e -> {
            MemberDTO member = new MemberDTO();
            member.setId(textField.getText());
            member.setPassword(new String(passwordField.getPassword()));
            try {
                int result = memberController.loginCheck(member);
                if(result == 1){
                    dispose();
                    memberController.mainView();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        goJoinTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                memberController.joinView();
            }

        });

    }

}
