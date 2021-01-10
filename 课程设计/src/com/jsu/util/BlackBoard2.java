package com.jsu.util;

import javax.swing.*;

import com.jsu.dao.DataOperate;

import com.jsu.ui.Awardlist;
import com.jsu.ui.Awardlist2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BlackBoard2 extends JFrame implements  ActionListener {
    static int quota2;
    private final String START ="��ʼ";
    private final String STOP ="ֹͣ";
    private final JPanel panel=new JPanel(new GridLayout(5, 2));
    private JButton button;
    private JButton button_1;

    private final Lottery lottry;
    
    public BlackBoard2(int quota2){
        // �������Ե�����
        setTitle("�齱");// ���ڱ���
        setSize(1121, 500);// ���ڴ�С
        setLocationRelativeTo(null);// ���ھ���
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        for(int i = 0; i< quota2; i++){
            final JLabel label=new JLabel();
            label.setName(i+"");
            label.setFont(new Font("����",Font.PLAIN,20));
            panel.add(label);
        }

        JPanel panel2=new JPanel();
        
        
        panel2.setBounds(0, 333, 1109, 131);
        button=new JButton(START);
        button_1 = new JButton(STOP);
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lottry.stop();
        		//����Ƿ�������Lable ������ͬ
        		ArrayList<String> list=new ArrayList<>();
                for(Component comp:panel.getComponents()){
                	JLabel label=(JLabel)comp;
                	String text=label.getText();
                	boolean yesorno=list.contains(text);
                	if(!yesorno){
                		list.add(text);
                	}else{
                        System.out.println("wrong:"+text);
                    }
                }
                for(int i=0;i<list.size();i++) {
                	DataOperate.addData_award3(list.get(i));
                }
        		Awardlist2 awardlist2=new Awardlist2();
        		awardlist2.setVisible(true);
        		button_1.setEnabled(false);
        	}
        });
        button.setBounds(206, 56,82,23);
        button_1.setBounds(734, 56, 93, 23);
        button.addActionListener(this);
        panel2.setLayout(null);
        panel2.add(button);
        panel2.add(button_1);
        getContentPane().setLayout(null);
        panel.setBounds(0, 0, 1109, 335);

        getContentPane().add(panel);
        getContentPane().add(panel2);
        
        //��ȡ����
        ArrayList<String> source=new ArrayList<>();
        source= DataOperate.getData();

        lottry = new Lottery<String>(source, quota2, new SampleShow<String>() {
            @Override
            public String show(int index, String data) {
                JLabel label=BlackBoard2.this.getLabel(index);
                String oldSeatNumber = label.getText();
                label.setText(data);
                return  oldSeatNumber;
            }
        });
    }

    //��ȡLable
    public JLabel getLabel(int index){
        return (JLabel)panel.getComponent(index);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action=e.getActionCommand();
        if(action.equals(START)) {
        	lottry.start();
            button.setEnabled(false);
        }  
        
	}
    
    
}
	