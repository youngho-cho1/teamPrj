package service;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import view.JoinView;

import javax.swing.*;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberService extends JFrame {
    private final MemberDAO memberdao;
    public int loginCheck(MemberDTO input) {
        int count = memberdao.selectCount(input);

        if (count == 1)
            JOptionPane.showMessageDialog(null, "로그인 성공");
        else
            JOptionPane.showMessageDialog(null, "로그인 실패");
        return count;
    }
    public int idCheck(MemberDTO input) {
        int count = memberdao.selectIdCount(input);

        if (count == 0)
            JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
        else
            JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
        return count;
    }
    public void join(MemberDTO input) throws SQLException {
        int cnt = memberdao.insert(input);

        if (cnt == 1)
            JOptionPane.showMessageDialog(null, "회원가입을 성공하셨습니다");

        else{
            JOptionPane.showMessageDialog(null, "회원가입을 실패하셨습니다.");
        }

    }
}
