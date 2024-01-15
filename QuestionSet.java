package oasis_infobyte;


import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QuestionSet extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int currentQuestionIndex=0;
	private String[] Questions= {
			"1.Number of Primative Datatypes in java?",//8
			"2.What is Size of float and double in java?",//32 64
			"3.An interface with no fields or methods is known as a ______.",//21
			"4.Which of the following is not a Java features?",//2
			"5.The \\u0021 article referred to as a",//5
			"6._____ is used to find and fix bugs in the Java programs.",//6
			"7.Which of the following is a valid declaration of a char?",//7
			"8.What is the return type of the hashCode() method in the Object class?",//8
			 "9.Which of the following is a valid long literal?",//9
			 "10.What does the expression float a = 35 / 0 return?"//10
	};
	private String [] Options={
		"3","5","8","9",//8
		"32 amd 64"," 32 and 32","64 and 32"," 64 and 64",//1
		
	"Runnable Interface" ,"Marker Interface","Abstract Interface","CharSequence Interface",
	"Dynamic" ,"Architecture Neutral","Use of pointers","Object-oriented",//3
	"Unicode escape sequence","Octal escape","Hexadecimal","Line feed",//1
	"JVM","JRE","JDK","JDB",//4
	"char ch = 'utea';","char ca = 'tea';","char cr = u0223;","char cc = 'itea';" , //1
	"Object","int","long","void",
	"ABH8097", "L990023", "904423", "0xnf029L",
	"0", "Not a Number", "Infinity", "Run time exception"	,//3
	
	
	};
	private int[] correctAnswer= {2,0,0,2,0,3,0,1,3,2
			
	};
    private int score=0;
	private JLabel questionLable1;
	private ButtonGroup optionGroup;
	private JRadioButton[] optionButtons;
	JButton Next,Prev,Submit,End;
	private Timer timer;
	private JLabel timeLable;
	private int timeRemaining=120;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				new QuestionSet().setVisible(true);
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	public QuestionSet() {
	
		timeLable=new JLabel("TimeRemaining: 02:00");
		timeLable.setFont(new Font("Tahoma",Font.PLAIN,18));
		timer=new Timer(1000, new TimerListener());
		questionLable1=new JLabel();
		questionLable1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		optionGroup=new ButtonGroup();
		optionButtons=new JRadioButton[4];
		JPanel questionPanel=new JPanel(new GridLayout(5,1));
		questionPanel.add(timeLable);
		
		questionPanel.add(questionLable1);
		for(int i=0;i<4;i++) {
			optionButtons[i]=new JRadioButton();
			optionButtons[i].setFont(new Font("Tahoma",Font.PLAIN,22));
			optionGroup.add(optionButtons[i]);
			questionPanel.add(optionButtons[i]);
		}
		
		

		
		JPanel buttonpanel=new JPanel(new FlowLayout());
		buttonpanel.setFont(new Font("Tahoma",Font.PLAIN,32
				));
		Prev=new JButton ("Previous");
		Submit=new JButton("Submit");
		
		
		buttonpanel.add(Prev,BorderLayout.WEST);
		buttonpanel.add(Submit,BorderLayout.CENTER);
		
		getContentPane().add(questionPanel , BorderLayout.CENTER);
		getContentPane().add(buttonpanel,BorderLayout.SOUTH);
		Next=new JButton("Next");
		buttonpanel.add(Next,BorderLayout.EAST);
		End=new JButton("Logout");
		End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		End.setForeground(new Color(255, 0, 0));
		buttonpanel.add(End,BorderLayout.PAGE_END);
		
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentQuestionIndex < Questions.length-1) {
					currentQuestionIndex++;
					displayQuestion();
					
				}
				
			}
		});
     Prev.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 if(currentQuestionIndex >0) {
    			 currentQuestionIndex --;
    			 displayQuestion();
    		 }
    	 }
     });	
     Submit.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 JOptionPane.showMessageDialog(QuestionSet.this,"Answer Submitted");
    		 checkAnswer();
    		 
    	 }

      });
    
     displayQuestion();
     setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     addWindowListener(new java.awt.event.WindowAdapter() {
    	 public void windowClosing(java.awt.event.WindowEvent windowEvent) {
    		 logout();
    		 checkAnswer();
    	 }
     });
	startTimer();
	}
	
     
    private void displayQuestion()
     {
    	questionLable1.setText(Questions[currentQuestionIndex]);
    	for(int i=0;i<4;i++) {
    		optionButtons[i].setText(Options[currentQuestionIndex*4+i]);
    		optionButtons[i].setSelected(false);}
    		
    		
    	}
    	private void startTimer () {
    		timer=new Timer(1000,new TimerListener());
    		timer.start();
    	}
    	
    	public class TimerListener implements ActionListener {
    		int timeRemaining = 120;
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    	// TODO Auto-generated method stub
    	if(timeRemaining >0) {
    		timeRemaining--;
    		int minutes=timeRemaining/60;
    		int seconds=timeRemaining %60;
    		timeLable.setText("Time Remaining: "+String.format("%02d:%02d", minutes,seconds));
    	}
    	else {
    		stopTimer();
    		checkAnswer();
    		  JOptionPane.showMessageDialog(QuestionSet.this, "Time is up! Exam submitted.\nScore: " + score);
    		  System.exit(0);
    	}
    		}

    	}
    	
    	
    	
    	private void checkAnswer() {
    		for (int i=0;i <4;i++) {
    			if(optionButtons[i].isSelected()&&i==correctAnswer[currentQuestionIndex]) {
    				score++;
    				break;
    			}
    		}
    		if(currentQuestionIndex < Questions.length-1) {
    			currentQuestionIndex++;
    			displayQuestion();
    		}
    		else {
    			stopTimer();
    			JOptionPane.showMessageDialog(QuestionSet.this,"Exam Submitted!\nscore:"+score);
    		}
     
     
    	}
     
    	
    		private void stopTimer() {
    			timer.stop();
    			timeLable.setText("Time Remaining: 02:00");
    			
    		}
    		private void logout() {
    			stopTimer();
    		int option=JOptionPane.showConfirmDialog(QuestionSet.this,"Are you sure you want to logout?","LogoutConfirmation",JOptionPane.YES_NO_OPTION);
    		if(option==JOptionPane.YES_OPTION) {
    			JOptionPane.showMessageDialog(QuestionSet.this,"Exam Submitted!\nscore:"+score);
    			System.exit(0);
    		}
    		else{
    			startTimer();
    		}
    		}
    		

	}

