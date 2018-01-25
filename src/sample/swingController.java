package sample;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class swingController extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAcc;
	private JTextField txtBalance;
	protected int count=1;
	

	/**
	 * Launch the application.
	 */
	String fun()
	{
	 JFrame frame = new JFrame();
     String name = JOptionPane.showInputDialog("Enter the navigation path please");
      JOptionPane.showMessageDialog(frame, "The path entered is: " + name + '!');
	return name;
	}
	
	String HeaderTitle()
	{
	 JFrame frame = new JFrame();
	 frame.setSize(new Dimension(480, 10));
     String titleName = JOptionPane.showInputDialog("Enter Slide Title");
      JOptionPane.showMessageDialog(frame, "The Tite entered is: " + titleName + '!');
	return titleName;
	}
	
}

