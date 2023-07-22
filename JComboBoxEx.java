import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class MyFrame extends JFrame implements ActionListener
{
   private JTextField txt_name;
   private JComboBox <String> jcb_gender;
   private JComboBox <String> jcb_nat;
   private JButton btn;
   private Vector<String>v;
   public MyFrame()
   {

      this.setLayout(new GridLayout(4,2));
      this.add(new JLabel("Enter Name :"));
      txt_name=new JTextField();
      this.add(txt_name);

      this.add(new JLabel("Select Gender:"));
      jcb_gender=new JComboBox <String>();
      this.add(jcb_gender);
      jcb_gender.addItem("Select Gender");
      jcb_gender.addItem("MALE");
      jcb_gender.addItem("FEMALE");

      this.add(new JLabel("Select Nationality"));
      v=new Vector <String>();
      String arr[]={"Select Nationality","INDIAN","GERMAN","AMERICAN"};
      for(String item :arr)
         v.add(item);
      jcb_nat=new JComboBox<String>(v);
      this.add(jcb_nat);

      this.add(new JLabel(""));
      btn =new JButton("SUBMIT");
      this.add(btn);
      btn.addActionListener(this);
      

      this.setVisible(true);
      this.setSize(400,200);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
   @Override
   public void actionPerformed(ActionEvent e)
   {
      String error_msg="";
      String name=txt_name.getText().trim().toUpperCase();
      if(name.length()==0)
         error_msg=error_msg+"Name is required!\n";

      if(jcb_gender.getSelectedIndex()==0)
         error_msg=error_msg+"Gender is required!\n";

      if(jcb_nat.getSelectedIndex()==0)
         error_msg=error_msg+"Nationality is required!\n";
      if(error_msg=="")
      {
         String gender =jcb_gender.getSelectedItem().toString();
         String nat=jcb_nat.getSelectedItem().toString();
          JOptionPane.showMessageDialog(this,"Name : "+name+"\nGender : "+gender+"\nNationality : "+nat);

      }
      else
         JOptionPane.showMessageDialog(this,error_msg);
   }
}

class JComboBoxEx
{
   public static void main(String[] args) 
   {
      new MyFrame();
   }
}