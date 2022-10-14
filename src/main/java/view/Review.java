package view;

import model.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Review extends JFrame {
    private JPanel panel1;
    private JTable table;
    private JScrollPane scrollPane;

    public Review(List<MemberDTO> list) throws HeadlessException {
        TableModel dataModel = new AbstractTableModel() {
            String[] col = {"아이디", "이름", "이메일"};

            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return col.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                String arr="";
                switch (columnIndex) {
//                    case 0 : arr = list.get(rowIndex).getId();
//                    case 1 : arr = list.get(rowIndex).getName();
//                    case 2 : arr = list.get(rowIndex).getEmail();
                };
                return arr;
            }
            @Override
            public String getColumnName(int column) {return col[column];}
        };
        table.setModel(dataModel);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        List<MemberDTO> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            MemberDTO member = new MemberDTO();
            member.setId("id " + i);
            member.setName("name " + i);
            member.setEmail("email " + i);
            list.add(member);
        }
        new Review(list);
    }
}

//package view;
//
//import javax.swing.*;
//
///**
// * JTableTest
// * User: Michael
// * Date: 11/7/10
// * Time: 4:49 PM
// */
//public class Review extends JFrame
//{
//    private JPanel panel1;
//    private JTable table;
//    private JScrollPane scrollPane;
//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame("Review");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JTable table = createTable();
//        JScrollPane scrollPane = new JScrollPane(table);
//        frame.getContentPane().add(scrollPane);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static JTable createTable()
//    {
//        String[] columnNames = {"식당 이름", "제목", "리뷰 내용", "평가 점수", "상세 보기"};
//        Object[][] data = {{"식당", "맛없어", "개맛없어", "5", "버튼"},{"식당2", "개맛없어", "진짜 개맛없어", "4", "버튼"}};
//        JTable table = new JTable(data, columnNames);
//        table.setFillsViewportHeight(true);
//
//        return table;
//    }
//}
