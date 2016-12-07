package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class Ventana extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel label;
	List<JTextField> fields = new ArrayList<>();
	private JTextField textField;
	private JButton boton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		label = new JLabel("New label");
		contentPane.add(label);
		
		boton = new JButton("crear");
		boton.addActionListener(this);
		contentPane.add(boton);
	}
	
	public void crear() {
		for (int i = 0; i < Integer.parseInt(textField.getText()); i++) {
			crearField();
		}
	}
	
	public void crearField() {
		JTextField text = new JTextField();
		text.setColumns(10);
		fields.add(text);
	}
	
	public void añadirFields() {
		for (JTextField jTextField : fields) {
			contentPane.add(jTextField);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		crear();
		label.setText(Integer.toString(fields.size()));
		añadirFields();
	}

}
