package main;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class consle {
	static JTextArea consle;
	static JFrame frame;
	static JScrollPane scrollPane;
	public consle() {
		frame=new JFrame("Consle");
		consle=new JTextArea();
		consle.setEditable(false);
		consle.setFont(new Font("Î¢ÈíÑÅºÚ",0,16));
		consle.addKeyListener(new MyListener());
		scrollPane=new JScrollPane(consle);
		frame.getContentPane().setLayout(new GridLayout());
		frame.getContentPane().add(scrollPane);
		frame.addKeyListener(new MyListener());
		scrollPane.addKeyListener(new MyListener());
		frame.setVisible(true);
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void out(String text){
		consle.setText(consle.getText()+text+"\n");
		consle.update(consle.getGraphics());
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
}

