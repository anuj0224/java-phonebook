package Phonebook;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PhoneBook extends JFrame{
    private JTextField contactName,contactNumber;
    private JTextArea showContacts;
   
    
    
    public PhoneBook(){
        setTitle("Phone Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setLayout(new BorderLayout());
        
        JPanel input = new JPanel();
        
        
        input.setLayout(new GridLayout(3,2));
        
        JLabel name = new JLabel("Name:");
        contactName = new JTextField();
        
        JLabel number = new JLabel("Phone Number:");
        contactNumber = new JTextField();
        
        JButton btn = new JButton("Add Contact");
   
    
    btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                String n1 = contactName.getText();
                String n2 = contactNumber.getText();
                
                String contact = n1+" : "+n2+"\n";
                showContacts.append(contact);
                
            }
    });
    
    input.add(name);
    input.add(contactName);
    input.add(number);
    input.add(contactNumber);
    input.add( new JPanel());
    input.add(btn);
    
    showContacts = new JTextArea();
    showContacts.setEditable(true);
    
    add(input,BorderLayout.NORTH);
    add(new JScrollPane(showContacts),BorderLayout.CENTER);
            
    }
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.setVisible(true);
    }
}
