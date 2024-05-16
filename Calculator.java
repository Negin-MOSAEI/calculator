import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    //add
    JButton[] functionButton = new JButton[10];
    JButton addButton, minButton,negButton,mulButton,divButton;
    JButton decButton, equButton,delButton,clrButton,facButton;
    JPanel panel;
    Font myFont=new Font("Ink Free",Font.BOLD,30);
    double number1=0,number2=0,result=0;
    char operator;
    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,650);
        frame.setLayout(null);
        textField= new JTextField();
        textField.setBounds(75,25,300,50);
        textField.setEditable(false);
        addButton=new JButton("+");
        minButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Del");
        clrButton=new JButton("Clr");
        facButton=new JButton("!");
        negButton=new JButton("negative");
        functionButton[0]=addButton;
        functionButton[1]=negButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=equButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        functionButton[8]=facButton;
        functionButton[9]=minButton;
        for (int i=0;i<10;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }
        for (int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        panel=new JPanel();
        panel.setBounds(25,100,400,400);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(Color.blue);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(minButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(facButton);
        panel.add(negButton);
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==addButton){
            number1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==minButton){
            number1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            number1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            number1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==facButton){
            number1=Double.parseDouble(textField.getText());
            int temp=1;
            for(int i=1;i<=number1;i++)
                temp*=i;
            textField.setText(Integer.toString(temp));
        }
        if(e.getSource()==equButton){
            number2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1=result;
        }
        if (e.getSource()==clrButton){
            textField.setText("");
        }
        if (e.getSource()==delButton){
            String temp=textField.getText();
            textField.setText("");
            for(int i=0;i<temp.length()-1;i++){
                textField.setText(textField.getText()+temp.charAt(i));
            }
        }
        if (e.getSource()==decButton){
            textField.setText((textField.getText().concat(".")));
        }
        if (e.getSource()==negButton){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }}
