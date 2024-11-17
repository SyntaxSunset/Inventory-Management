package mainPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Buttons {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buttons window = new Buttons();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Buttons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(6, 6, 830, 554);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnProduct.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnProduct.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				DesignMain dm = new DesignMain();
				dm.setVisible(true);
			}
		});
		btnProduct.setOpaque(true);
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnProduct.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnProduct.setBackground(new Color(0, 128, 128));
		btnProduct.setBounds(125, 109, 187, 59);
		panel.add(btnProduct);
		
		JLabel lblNewLabel = new JLabel("Inventory Management System");
		lblNewLabel.setFont(new Font("Maku", Font.BOLD, 40));
		lblNewLabel.setBounds(169, 6, 483, 59);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(461, 6, 363, 542);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Buttons.class.getResource("/images/inventorymain.png")));
		lblNewLabel_1.setBounds(0, 6, 357, 471);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Everyone is a customer for somebody");
		lblNewLabel_3.setFont(new Font("Noteworthy", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(6, 400, 351, 61);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(", or a supplier to somebody");
		lblNewLabel_3_1.setFont(new Font("Noteworthy", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(92, 443, 265, 61);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Buttons.class.getResource("/images/product.png")));
		lblNewLabel_2.setBounds(48, 109, 46, 59);
		panel.add(lblNewLabel_2);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnEmployee.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
                btnEmployee.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Employee em = new Employee();
				em.setVisible(true);
			}
		});
		btnEmployee.setOpaque(true);
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnEmployee.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnEmployee.setBackground(new Color(0, 128, 128));
		btnEmployee.setBounds(125, 197, 187, 59);
		panel.add(btnEmployee);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSupplier.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
                btnSupplier.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Suppliers su = new Suppliers();
				su.setVisible(true);
				
			}
		});
		btnSupplier.setOpaque(true);
		btnSupplier.setForeground(Color.WHITE);
		btnSupplier.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSupplier.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSupplier.setBackground(new Color(0, 128, 128));
		btnSupplier.setBounds(125, 277, 187, 59);
		panel.add(btnSupplier);
		
		JButton btnSales = new JButton("Sales");
		btnSales.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSales.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
                btnSales.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Sales sa = new Sales();
				sa.setVisible(true);
				
			}
		});
		btnSales.setOpaque(true);
		btnSales.setForeground(Color.WHITE);
		btnSales.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSales.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSales.setBackground(new Color(0, 128, 128));
		btnSales.setBounds(125, 364, 187, 59);
		panel.add(btnSales);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Buttons.class.getResource("/images/Users.png")));
		lblNewLabel_2_1.setBounds(48, 197, 46, 59);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Buttons.class.getResource("/images/Orders.png")));
		lblNewLabel_2_1_1.setBounds(48, 277, 46, 59);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(Buttons.class.getResource("/images/View-orders.png")));
		lblNewLabel_2_1_2.setBounds(48, 364, 46, 59);
		panel.add(lblNewLabel_2_1_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnLogout.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
                btnLogout.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				LoginPage lp = new LoginPage();
				lp.setVisible(true);
			}
		});
		btnLogout.setIcon(new ImageIcon(Buttons.class.getResource("/images/Exit.png")));
		btnLogout.setOpaque(true);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnLogout.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnLogout.setBackground(new Color(0, 128, 128));
		btnLogout.setBounds(22, 489, 187, 59);
		panel.add(btnLogout);
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
