import java.awt.*;
import java.awt.event.*;
 
 
class Calc implements ActionListener
{
    Frame f;
    TextField t;
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    Button b9,b0,bdiv,bmul,bsub,badd;
    Button bdec,beq,bdel,bclr;
 
    static double a=0,b=0,result=0;
    static int operator=0;
 
    Calc()
    {
        f=new Frame("Calculator");
        t=new TextField();
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        b6=new Button("6");
        b7=new Button("7");
        b8=new Button("8");
        b9=new Button("9");
        b0=new Button("0");
        bdiv=new Button("/");
        bmul=new Button("*");
        bsub=new Button("-");
        badd=new Button("+");
        bdec=new Button(".");
        beq=new Button("=");
        bdel=new Button("Delete");
        bclr=new Button("Clear");
        
        t.setBounds(30,40,280,30);
        b7.setBounds(40,100,50,40);
        b8.setBounds(110,100,50,40);
        b9.setBounds(180,100,50,40);
        bmul.setBounds(250,100,50,40);
        
        b4.setBounds(40,170,50,40);
        b5.setBounds(110,170,50,40);
        b6.setBounds(180,170,50,40);
        bdiv.setBounds(250,170,50,40);
        
        b1.setBounds(40,240,50,40);
        b2.setBounds(110,240,50,40);
        b3.setBounds(180,240,50,40);
        badd.setBounds(250,240,50,40);
        
        bdec.setBounds(40,310,50,40);
        b0.setBounds(110,310,50,40);
        beq.setBounds(180,310,50,40);
        bsub.setBounds(250,310,50,40);
        
        bdel.setBounds(60,380,100,40);
        bclr.setBounds(180,380,100,40);
        
        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
        f.add(bdel);
        f.add(bclr);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350,500);
        f.setResizable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
            t.setText(t.getText().concat("1"));
        
        if(e.getSource()==b2)
            t.setText(t.getText().concat("2"));
        
        if(e.getSource()==b3)
            t.setText(t.getText().concat("3"));
        
        if(e.getSource()==b4)
            t.setText(t.getText().concat("4"));
        
        if(e.getSource()==b5)
            t.setText(t.getText().concat("5"));
        
        if(e.getSource()==b6)
            t.setText(t.getText().concat("6"));
        
        if(e.getSource()==b7)
            t.setText(t.getText().concat("7"));
        
        if(e.getSource()==b8)
            t.setText(t.getText().concat("8"));
        
        if(e.getSource()==b9)
            t.setText(t.getText().concat("9"));
        
        if(e.getSource()==b0)
            t.setText(t.getText().concat("0"));
        
        if(e.getSource()==bdec)
            t.setText(t.getText().concat("."));
        
        if(e.getSource()==badd)
        {  
            a=Double.parseDouble(t.getText());
            operator=1;
            t.setText("");
        } 
        
        if(e.getSource()==bsub)
        {
            a=Double.parseDouble(t.getText());
            operator=2;
            t.setText("");
        }
        
        if(e.getSource()==bmul)
        {
            a=Double.parseDouble(t.getText());
          
            operator=3;
            t.setText("");
        }
        
        if(e.getSource()==bdiv)
        {
            a=Double.parseDouble(t.getText());
                       operator=4;
            t.setText("");
        }
        
        if(e.getSource()==beq)
        {
            b=Double.parseDouble(t.getText());
            //t.setText(t.getText().concat(" = "));        
            switch(operator)
            {
                case 1: result=a+b;
                    break;
        
                case 2: result=a-b;
                    break;
        
                case 3: result=a*b;
                    break;
        
                case 4: result=a/b;
                    break;
        
                default: result=0;
            }
        
           t.setText(""+result);
        }
        
        if(e.getSource()==bclr)
            t.setText("");
        
        if(e.getSource()==bdel)
        {
            String s=t.getText();
            t.setText("");
            for(int i=0;i<s.length()-1;i++)
            t.setText(t.getText()+s.charAt(i));
        }        
    }
}
public class Calculator_Demo
{
    public static void main(String args[])
    {
       Calc c=  new Calc();
    }
}

