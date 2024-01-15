package oasis_infobyte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Color;
public class OnlineStdExam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tid;
	private JPasswordField tpass;

	private HashMap<String,String>idPasswordMap;
	int timeRemaining=120;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	new	OnlineStdExam();
	}

	/**
	 * Create the frame.
	 */
	public OnlineStdExam() {
	
		idPasswordMap=new HashMap<>();
		idPasswordMap.put("std1","pass1" );
		idPasswordMap.put("std2", "pass2");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 788, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginPanel=new JPanel();
		loginPanel.setBounds(48, 97,695,145);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lid = new JLabel("Std_Id");
		lid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lid.setBounds(101,8,73,35);
        loginPanel.add(lid);
        
        JLabel lpass = new JLabel("Std_Pass");
		lpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lpass.setBounds(91,69,94,21);
		loginPanel.add(lpass);
		
		tid = new JTextField();
		tid.setBounds(239,11,205,35);
		loginPanel.add(tid);
		tid.setColumns(10);
		
		tpass = new JPasswordField();
		tpass.setBounds(239,66,205,35);
		loginPanel.add(tpass);

        //panel for buttons
		JPanel buttonPanel=new JPanel();
		buttonPanel.setBounds(120, 285, 509, 55);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton blogin = new JButton("Login");
		blogin.setForeground(new Color(0, 255, 0));
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId=tid.getText();
				String enterPassword=new String(tpass.getPassword());
				if(idPasswordMap.containsKey(studentId)) {
					String storePassword=idPasswordMap.get(studentId);
					if(enterPassword.endsWith(storePassword)) {
						QuestionSet anotherFrame = new QuestionSet();
		                anotherFrame.setVisible(true);
		                OnlineStdExam.this.setVisible(false);
		                blogin.setEnabled(false);
					}
					else {
						JOptionPane.showMessageDialog(OnlineStdExam.this,"Invalid Pass!\nTry after sometime");
						System.exit(0);
					}
					
				}

				else {
					JOptionPane.showMessageDialog(OnlineStdExam.this,"Invalid Id!\nTry after sometime");
					System.exit(0);
				}
				
               
                
                
			}

		
		});
		blogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		blogin.setBounds(191, 11, 128, 32);
		buttonPanel.add(blogin);
		
		
		
		
		
		
				
		JButton bupdate = new JButton("Update");
		bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId=tid.getText();
				String newPassword=new String(tpass.getPassword());
				if (!studentId.isEmpty() && !newPassword.isEmpty()) {
                    idPasswordMap.put(studentId, newPassword);
                    JOptionPane.showMessageDialog(OnlineStdExam.this,"ID and Password Updated Successfully!!!");
                } else {
                	JOptionPane.showMessageDialog(OnlineStdExam.this,"Please Enter Valid ID and pass");
                }
			}
		});
		bupdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bupdate.setBounds(10,11,117,32);
		buttonPanel.add(bupdate);
		
		JButton bquit = new JButton("Quit");
		bquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(OnlineStdExam.this,"Are you sure??\n Do you want to Quit??");
				System.exit(0);
			}
			
			
		});
		bquit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bquit.setBounds(361,11,106,32);
		buttonPanel.add(bquit);
		
		
		JLabel lblNewLabel = new JLabel("Login To Exam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(290, 31, 194, 32);
		contentPane.add(lblNewLabel);

	}
	
	
}
