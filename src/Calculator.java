import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
    // declare some attributes

    JFrame frame;
    JTextField tf;
    JButton[] numberButtons = new JButton[10]; // from 0 to 9;
    JButton[] operationButton = new JButton[8]; 
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton,clrButton;
    JPanel panel;
    
    boolean finish = false;

    Font myFont = new Font("Times New Roman",Font.BOLD,30);

    double num1 = 0, num2 = 0, res = 0;
    char operator;
    

    Calculator()
    {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        tf = new JTextField();
        tf.setBounds(50,25,300,50);
        tf.setFont(myFont);
        tf.setEditable(false);
        tf.setEnabled(true);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        operationButton[0] = addButton;
        operationButton[1] = subButton;
        operationButton[2] = mulButton;
        operationButton[3] = divButton;
        operationButton[4] = decButton;
        operationButton[5] = eqButton;
        operationButton[6] = delButton;
        operationButton[7] = clrButton;

        for(int i = 0;i < 8;i++) // for operation button
        {
            operationButton[i].addActionListener(this);
            operationButton[i].setFont(myFont);
            operationButton[i].setFocusable(false);
        }

        for(int i = 0;i < 10;i++) // for number button
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
         

        // positioning
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(tf);
        frame.setVisible(true);

       
    }

    public void actionPerformed(ActionEvent e)
    {

        for(int i =0;i < 10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                if(finish)
                {
                    tf.setText("");
                    finish = false;
                }
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }


        // do for each operation button
        /*
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
         */

        if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble(tf.getText());
            operator = '+';
            tf.setText(" ");
        }

        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(tf.getText());
            operator = '-';
            tf.setText(" ");
        }

        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(tf.getText());
            operator = '*';
            tf.setText(" ");
        }

        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(tf.getText());
            operator = '/';
            tf.setText(" ");
        }

        if(e.getSource() == decButton)
        {
            tf.setText(tf.getText().concat("."));
        }

        if(e.getSource() == eqButton)
        {
            num2 = Double.parseDouble(tf.getText());
            switch (operator)
            {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1*num2;
                    break;
                case '/':
                    res = num1/num2;
                    break;
            }

            tf.setText(String.valueOf(res));
            finish = true;
        }

        if(e.getSource() == delButton)
        {
            String temp = tf.getText();
            tf.setText("");
            for(int i =0;i < temp.length()-1;i++)
            {
                tf.setText(tf.getText().concat(String.valueOf(temp.charAt(i))));
            }
        }

        if(e.getSource() == clrButton)
        {
            tf.setText(" ");
        }

        
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}