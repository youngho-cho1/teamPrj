package controller;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.MemberService;
import view.JoinView;
import view.LoginView;
import view.MainView;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    public void join(MemberDTO input) throws SQLException {
        memberService.join(input);
    }
    public int idCheck(MemberDTO input) throws  SQLException{
        return memberService.idCheck(input);
    }
    public int loginCheck(MemberDTO input) throws SQLException{
        return memberService.loginCheck(input);
    }
    public void joinView(){
        new JoinView();
    }
    public void loginView(){
        new LoginView();
    }
    public void mainView(){
        new MainView();
    }
}
