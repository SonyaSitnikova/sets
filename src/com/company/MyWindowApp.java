package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * Created by Соня on 04.10.2017.
 */
public class MyWindowApp extends JFrame{
    public MyWindowApp() {
        super("Операции над множествами    ");        // Заголовок окна
        setBounds(100, 100, 800, 400); // Координаты окна и его размеры
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // при закрытии окна закроется и программа

        JPanel panel = new JPanel();panel.setLayout(null);

        JLabel label0 = new JLabel("Введите множества : ");
        JLabel label1 = new JLabel("Множество A : ");
        JLabel label2 = new JLabel("Множество B : ");
        JLabel label3 = new JLabel("Результат : ");
        JLabel label4 = new JLabel("___________________________________");

        JButton button1 = new JButton("Добавить множество A");
        JButton button2 = new JButton("Добавить множество B");
        JButton button3 = new JButton("Объединение множеств");
        JButton button4 = new JButton("Пересечение множеств");
        JButton button5 = new JButton("Разность множеств A - B");
        JButton button6 = new JButton("Разность множеств B - A");

        JTextField tf1 = new JTextField("");
        JTextField tf2 = new JTextField("");
        JTextArea ta1 = new JTextArea("");
        JTextArea ta2 = new JTextArea("");
        JTextArea ta3 = new JTextArea("");

        Insets insets = panel.getInsets();
        Dimension size;

        int tfwidth = 200;
        int tfheight = 25;
        int tawidth = 200;
        int taheight = 25;

        tf1.setBounds(30 + insets.left, 60 + insets.top, tfwidth, tfheight);
        tf2.setBounds(30 + insets.left, 120 + insets.top, tfwidth, tfheight);
        ta1.setBounds(300 + insets.left, 60 + insets.top, tawidth, taheight);
        ta2.setBounds(300 + insets.left, 120 + insets.top, tawidth, taheight);
        ta3.setBounds(570 + insets.left, 90 + insets.top, tawidth, 100);
        size = label0.getPreferredSize();label0.setBounds(30 + insets.left, 30 + insets.top, size.width, size.height);
        size = label1.getPreferredSize();label1.setBounds(300 + insets.left, 30 + insets.top, size.width, size.height);
        size = label2.getPreferredSize();label2.setBounds(300 + insets.left, 90 + insets.top, size.width, size.height);
        size = label3.getPreferredSize();label3.setBounds(570 + insets.left, 30 + insets.top, size.width, size.height);
        size = label4.getPreferredSize();label4.setBounds(570 + insets.left, 60 + insets.top, size.width, size.height);
        size = button1.getPreferredSize();button1.setBounds(30 + insets.left, 90 + insets.top, size.width, size.height);
        size = button2.getPreferredSize();button2.setBounds(30 + insets.left, 150 + insets.top, size.width, size.height);
        size = button3.getPreferredSize();button3.setBounds(300 + insets.left, 150 + insets.top, size.width, size.height);
        size = button4.getPreferredSize();button4.setBounds(300 + insets.left, 180 + insets.top, size.width, size.height);
        size = button5.getPreferredSize();button5.setBounds(300 + insets.left, 210 + insets.top, size.width, size.height);
        size = button6.getPreferredSize();button6.setBounds(300 + insets.left, 240 + insets.top, size.width, size.height);

        HashSet<String> setA = new HashSet<>();  // Создание множества А (неупорядоченное множество HashSet)
        HashSet<String> setB = new HashSet<>();  // Создание множества B (неупорядоченное множество HashSet)
        HashSet<String> setC = new HashSet<>();  // Создание множества C (неупорядоченное множество HashSet)

        button1.addActionListener(new ActionListener(){ // Добавить множество A
            public void actionPerformed(ActionEvent e) {
                String tf = tf1.getText();
                String [] set = tf.split("\\s+");
                int n = set.length;
                setA.clear();
                for (int i=0; i<n; i++){
                    setA.add(set[i]);
                }
                ta1.setText(setA.toString());
            }
        });

        button2.addActionListener(new ActionListener(){ // Добавить множество B
            public void actionPerformed(ActionEvent e) {
                String tf = tf2.getText();
                String [] set = tf.split("\\s+");
                int n = set.length;
                setB.clear();
                for (int i=0; i<n; i++){
                    setB.add(set[i]);
                }
                ta2.setText(setB.toString());
            }
        });

        button3.addActionListener(new ActionListener(){ // Объединение множеств
            public void actionPerformed(ActionEvent e) {
                label4.setText("Объединение множеств A и B");
                setC.clear();
                setC.addAll(setA);
                setC.addAll(setB);
                ta3.setText(setC.toString());
            }
        });

        button4.addActionListener(new ActionListener(){ // Пересечение множеств
            public void actionPerformed(ActionEvent e) {
                label4.setText("Пересечение множеств A и B");
                setC.clear();
                setC.addAll(setA);
                setC.retainAll(setB);
                ta3.setText(setC.toString());
            }
        });

        button5.addActionListener(new ActionListener(){ // Разность множеств A - B
            public void actionPerformed(ActionEvent e) {
                label4.setText("Разность множеств A - B");
                setC.clear();
                setC.addAll(setA);
                setC.removeAll(setB);
                ta3.setText(setC.toString());
            }
        });

        button6.addActionListener(new ActionListener(){ // Разность множеств B - A
            public void actionPerformed(ActionEvent e) {
                label4.setText("Разность множеств B - A");
                setC.clear();
                setC.addAll(setB);
                setC.removeAll(setA);
                ta3.setText(setC.toString());
            }
        });

        panel.add(button1);panel.add(button2);panel.add(button3);
        panel.add(button4);panel.add(button5);panel.add(button6);
        panel.add(label0);panel.add(label1);panel.add(label2);
        panel.add(label3);panel.add(label4);
        panel.add(ta1);panel.add(ta2);panel.add(ta3);
        panel.add(tf1);panel.add(tf2);
        add(panel);

    }
}
