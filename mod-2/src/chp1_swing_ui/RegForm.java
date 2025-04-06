package chp1_swing_ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegForm extends JFrame {
	
	JLabel nameLabel, contactLabel, genderLabel, cityLabel, commentLabel;
	JTextField nameField, contactField;
	JRadioButton maleButton, femaleButton, otherButton;
	ButtonGroup genderGroup;
	JComboBox<String> cityCombo;
	JTextArea commentArea;
	JButton submitButton, resetButton, discardButton; 
	
	public RegForm() {
		
		setTitle("Company Reg Form");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(8,2,5,5));
		
		JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 245, 245));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
		nameLabel = new JLabel("Name");
		contactLabel = new JLabel("Contact");
		genderLabel = new JLabel("Gender");
		cityLabel = new JLabel("City");
		commentLabel = new JLabel("Comment");
		
		nameField = new JTextField();
		contactField = new JTextField();
		
		maleButton = new JRadioButton("Male");
		femaleButton =new JRadioButton("Female");
		otherButton = new JRadioButton("'Other");
		
		genderGroup = new ButtonGroup();
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		genderGroup.add(otherButton);
		
		JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		genderPanel.setBackground(new Color(245, 245, 245));
		genderPanel.add(maleButton);
		genderPanel.add(femaleButton);
		genderPanel.add(otherButton);
		
		String[] cities = {"Mumbai", "Pune", "nashik", "Nagpur"};
		cityCombo = new JComboBox<>(cities);
		
		commentArea = new JTextArea(3,20);
		commentArea.setLineWrap(true);
	    commentArea.setWrapStyleWord(true);
	        
		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		discardButton = new JButton("Discard");
		
		submitButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleSubmit();
			}
			
			
		});
		
		resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleReset();
            }
		});
		
		discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
		add(nameLabel);
        add(nameField);
        add(contactLabel);
        add(contactField);
        add(genderLabel);
        add(genderPanel);
        add(cityLabel);
        add(cityCombo);
        add(commentLabel);
        add(new JScrollPane(commentArea));
        add(submitButton);
        add(resetButton);
        add(new JLabel());
        add(discardButton);
        
        setVisible(true);
	}
	
	void handleSubmit() {
        String name = nameField.getText();
        String contact = contactField.getText();
        String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : otherButton.isSelected() ? "Other" : "";
        String city = (String) cityCombo.getSelectedItem();
        String comment = commentArea.getText();

        if (name.isEmpty() || contact.isEmpty() || gender.isEmpty() || city.isEmpty() || comment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are mandatory.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
	
	void handleReset() {
        nameField.setText("");
        contactField.setText("");
        genderGroup.clearSelection();
        cityCombo.setSelectedIndex(0);
        commentArea.setText("");
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegForm());
    }

}
