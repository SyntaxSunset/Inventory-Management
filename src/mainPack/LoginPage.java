package mainPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class LoginPage {

	private JFrame frmInventoryManagementLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmInventoryManagementLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryManagementLogin = new JFrame();
		frmInventoryManagementLogin.setFont(new Font("Annai MN", Font.BOLD, 14));
		frmInventoryManagementLogin.setTitle("INVENTORY MANAGEMENT LOGIN PAGE");
		frmInventoryManagementLogin.setBounds(100, 100, 760, 473);
		frmInventoryManagementLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryManagementLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(6, 6, 313, 433);
		frmInventoryManagementLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel.setBounds(25, 87, 224, 73);
		panel.add(lblNewLabel);
		
		JLabel lblManager = new JLabel("Manager...");
		lblManager.setForeground(new Color(255, 255, 255));
		lblManager.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 45));
		lblManager.setBounds(89, 141, 203, 73);
		panel.add(lblManager);
		
		JLabel lblNewLabel_3 = new JLabel("“The line between disorder");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Zapfino", Font.PLAIN, 15));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(25, 236, 267, 73);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("and order lies in logistics\"");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Zapfino", Font.PLAIN, 15));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(57, 267, 267, 73);
		panel.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(320, 6, 459, 433);
		frmInventoryManagementLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_1.setFont(new Font("Maku", Font.BOLD, 36));
		lblNewLabel_1.setBounds(161, 122, 107, 61);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(46, 139, 87));
		lblNewLabel_2.setFont(new Font("Maku", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(45, 222, 107, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_2_1.setFont(new Font("Maku", Font.PLAIN, 27));
		lblNewLabel_2_1.setBounds(45, 283, 107, 25);
		panel_1.add(lblNewLabel_2_1);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsername.setBackground(new Color(226, 244, 237));
		txtUsername.setOpaque(true);
		txtUsername.setForeground(new Color(0, 0, 0));
		txtUsername.setBounds(161, 228, 153, 26);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setBackground(new Color(226, 244, 237));
		txtPassword.setBounds(161, 283, 153, 25);
		panel_1.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setIcon(new ImageIcon(LoginPage.class.getResource("/images/login.png")));
		btnNewButton.setBackground(new Color(179, 225, 213));
		btnNewButton.setBounds(151, 351, 117, 29);
		panel_1.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnNewButton.setBackground(new Color(179, 225, 213).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnNewButton.setBackground(new Color(179, 225, 213)); // Revert to original color
            }
        });
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("manager@gmail.com") && password.equals("manager123")) {
                    JOptionPane.showMessageDialog(frmInventoryManagementLogin, "Login successful!");
                    frmInventoryManagementLogin.setVisible(false);
                    
                    Buttons bt = new Buttons();
                    bt.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frmInventoryManagementLogin, "Invalid Credentials!");
                }
            }
        });
    }

	public void setVisible(boolean b) {
		frmInventoryManagementLogin.setVisible(b);
		
	}
}
