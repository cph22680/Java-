package com.jsu.util;

import javax.swing.*;

import com.jsu.dao.DataOperate;

import com.jsu.ui.Awardlist;
import com.jsu.ui.Awardlist3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BlackBoard3 extends JFrame implements  ActionListener {
    static int quota3;
    private final String START ="开始";
    private final String STOP ="停止";
    private final JPanel panel=new JPanel(new GridLayout(5, 2));
    private JButton button;
    private JButton button_1;

    private final Lottery lottry;
    

    public BlackBoard3(int quota3){
        // 窗口属性的设置
        setTitle("抽奖");// 窗口标题
        setSize(1121, 500);// 窗口大小
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        for(int i = 0; i< quota3; i++){
            final JLabel label=new JLabel();
            label.setName(i+"");
            label.setFont(new Font("宋休",Font.PLAIN,20));
            panel.add(label);
        }

        JPanel panel2=new JPanel();
        
        
        panel2.setBounds(0, 333, 1109, 131);
        button=new JButton(START);
        button_1 = new JButton(STOP);
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lottry.stop();
        		//检查是否有两个Lable 内容相同
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
                	DataOperate.addData_award4(list.get(i));
                }
        		Awardlist3 awardlist3=new Awardlist3();
        		awardlist3.setVisible(true);
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
        
        //抽取样本
        ArrayList<String> source=new ArrayList<>();
        source= DataOperate.getData();

        lottry = new Lottery<String>(source, quota3, new SampleShow<String>() {
            @Override
            public String show(int index, String data) {
                JLabel label=BlackBoard3.this.getLabel(index);
                String oldSeatNumber = label.getText();
                label.setText(data);
                return  oldSeatNumber;
            }
        });
    }

    //获取Lable
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
	