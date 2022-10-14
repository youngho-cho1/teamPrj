package view;

import controller.MemberController;
import model.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.MemberService;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.*;
import java.lang.reflect.Member;
import java.sql.SQLException;

public class JoinView extends JFrame {
    private JPanel joinPanel;
    private JButton IdCheck;
    private JTextField NameText;
    private JComboBox VeganBox;
    private JButton VeganCheck;
    private JComboBox TellBox;
    private JTextField TellText2;
    private JTextField EmailText;
    private JComboBox EmailBox;
    private JTextField IdText;
    private JButton Back;
    private JButton Join;
    private JTextField TellText1;
    private JTextField ZipcodeText;
    private JPasswordField PwdText;
    private JPasswordField PasswordCheck;
    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/BeanConfig.xml");;
    MemberController memberController = context.getBean("MemberController", MemberController.class);
    public JoinView() {
        super("Join");
        setContentPane(joinPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        //전화번호 입력 체크
        TellText1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.getSource();
                int textLeng = TellText1.getText().length();
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    JOptionPane.showMessageDialog(null, "숫자만 입력해주세요!!");
                    TellText1.setText("");
                    e.consume();
                    return;
                }
            }
        });
        //전화번호 입력 체크
        TellText2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.getSource();
                int textLeng = TellText1.getText().length();
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    JOptionPane.showMessageDialog(null, "숫자만 입력해주세요!!");
                    TellText1.setText("");
                    e.consume();
                    return;
                }
            }
        });
        // 중복확인 체크
        IdCheck.addActionListener(e -> {
            MemberDTO member = new MemberDTO();
            member.setId(IdText.getText());
            MemberService service = context.getBean("MemberService", MemberService.class);

            int result = 0;
            try {
                result = memberController.idCheck(member);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if(result == 1){
                IdText.setText("");
            }
        });
        Back.addActionListener(e -> {
            dispose();
            memberController.loginView();
        });
        //패스워드 초점 잃을때
        PasswordCheck.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println(e);
            }
            public void focusLost(FocusEvent e){
                if(!new String(PwdText.getPassword()).equals(new String(PasswordCheck.getPassword()))){
                    JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인 정보가 맞지 않습니다.");
                    PwdText.setText("");
                    PasswordCheck.setText("");
                }
            }
        });
        Join.addActionListener(e -> {
            MemberDTO input = new MemberDTO();
            input.setId(IdText.getText());
            input.setPassword(new String(PwdText.getPassword()));
            input.setName(NameText.getText());
            input.setEmail(EmailText.getText()+'@'+EmailBox.getSelectedItem());
            input.setContact(TellBox.getSelectedItem()+TellText1.getText()+TellText2.getText());
            input.setAddress(ZipcodeText.getText());
            input.setVegan((String) VeganBox.getSelectedItem());

            try {
                memberController.join(input);
                dispose();
                memberController.loginView();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });

    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
