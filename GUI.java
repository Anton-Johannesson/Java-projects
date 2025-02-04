/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
    
    private JFrame frame;
    private JPanel panel;
    private JButton addAccount;
    private JButton removeAccount;
    private JButton findHolder;
    private JButton deposit;
    private JButton withdraw;
    private JButton listAccounts;
    private JTextArea textArea;

    public GUI(){

        //BankAccount bankAccount = new BankAccount(holderName, holderId);

        this.frame = new JFrame("Bank");
        this.panel = new JPanel();
        this.addAccount = new JButton("Add Account");
        this.addAccount.addActionListener((e) -> System.out.println(e));
        this.removeAccount = new JButton("Remove Account");
        this.findHolder = new JButton("Find Holder");

        this.deposit = new JButton("Deposit");
        this.deposit.addActionListener((_) -> System.out.println("clicked"));

        this.withdraw = new JButton("Withdraw");
        this.listAccounts = new JButton("List Accounts");
        this.textArea = new JTextArea(10, 20);
    }
    private void createComponents(Container container){
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(textArea, BorderLayout.CENTER);
        panel.add(addAccount);
        panel.add(removeAccount);
        panel.add(findHolder);
        panel.add(deposit);
        panel.add(withdraw);
        panel.add(listAccounts);
    }

    public void run(){
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }    
}


*/