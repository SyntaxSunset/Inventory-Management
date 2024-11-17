package mainPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Suppliers {

	private JFrame frame;
	private JTable table;
	private JTextField txtSuppId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtContact;
	private JTextField txtNumber;
	private JTextField txtItems;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppliers window = new Suppliers();
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
	public Suppliers() {
		initialize();
		BuildConnection();
		loadTable3();
	}
	
	Connection con;
    PreparedStatement prestm;
    ResultSet rst;
    
	public void BuildConnection() {
	 	         
	        try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryManagement", "root", "Sayan2004#");
				System.out.println("Established connection");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}    
	}
	
	public void loadTable3()
	{
		try {
			
			prestm = con.prepareStatement("select *from Supplier ");
			rst = prestm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 894, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(6, 6, 882, 558);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblManageSupplierDetails = new JLabel("Manage Supplier Details");
		lblManageSupplierDetails.setFont(new Font("Maku", Font.BOLD, 40));
		lblManageSupplierDetails.setBounds(252, 6, 377, 68);
		panel.add(lblManageSupplierDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(6, 91, 870, 132);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 858, 120);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(179, 225, 213));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("SuppId");
		lblNewLabel_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(26, 235, 54, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(26, 288, 54, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(26, 340, 54, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact");
		lblNewLabel_1_3.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(26, 425, 54, 16);
		panel.add(lblNewLabel_1_3);
		
		txtSuppId = new JTextField();
		txtSuppId.setColumns(10);
		txtSuppId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSuppId.setBackground(new Color(255, 255, 240));
		txtSuppId.setBounds(93, 230, 162, 26);
		panel.add(txtSuppId);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBackground(new Color(255, 255, 240));
		txtName.setBounds(93, 283, 162, 26);
		panel.add(txtName);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddress.setBackground(new Color(255, 255, 240));
		txtAddress.setBounds(93, 335, 162, 50);
		panel.add(txtAddress);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContact.setBackground(new Color(255, 255, 240));
		txtContact.setBounds(93, 420, 162, 26);
		panel.add(txtContact);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Items");
		lblNewLabel_1_3_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(297, 235, 54, 16);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Number of Items");
		lblNewLabel_1_3_2.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(297, 288, 107, 16);
		panel.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Mail");
		lblNewLabel_1_3_3.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3_3.setBounds(297, 352, 54, 16);
		panel.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Status");
		lblNewLabel_1_3_4.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3_4.setBounds(297, 425, 54, 16);
		panel.add(lblNewLabel_1_3_4);
		
		txtNumber = new JTextField();
		txtNumber.setColumns(10);
		txtNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNumber.setBackground(new Color(255, 255, 240));
		txtNumber.setBounds(419, 283, 162, 26);
		panel.add(txtNumber);
		
		txtItems = new JTextField();
		txtItems.setColumns(10);
		txtItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtItems.setBackground(new Color(255, 255, 240));
		txtItems.setBounds(419, 230, 162, 26);
		panel.add(txtItems);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtMail.setBackground(new Color(255, 255, 240));
		txtMail.setBounds(419, 347, 162, 26);
		panel.add(txtMail);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Select", "Active", "Inactive"}));
		comboBoxStatus.setBounds(419, 421, 162, 27);
		panel.add(comboBoxStatus);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAdd.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnAdd.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id,name,address,contact,items,number,mail,status;
				
				id=txtSuppId.getText();
				name=txtName.getText();
				address=txtAddress.getText();
				contact = txtContact.getText();
				items=txtItems.getText();
				number=txtNumber.getText();
				mail=txtMail.getText();
				status=comboBoxStatus.getSelectedItem().toString();
				
				try {
					prestm = con.prepareStatement("insert into Supplier(SuppId, Name, Address,Contact,Items,NumberofItems,Mail,Status)values(?,?,?,?,?,?,?,?) ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, address);
					prestm.setString(4, contact);
					prestm.setString(5, items);
					prestm.setString(6, number);
					prestm.setString(7, mail);
					prestm.setString(8, status);
					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Supplier Added Successfully");
					
					loadTable3();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnAdd.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAdd.setBackground(new Color(0, 128, 128));
		btnAdd.setBounds(20, 486, 114, 35);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,name,address,contact,items,number,mail,status;
				
				id=txtSuppId.getText();
				name=txtName.getText();
				address=txtAddress.getText();
				contact = txtContact.getText();
				items=txtItems.getText();
				number=txtNumber.getText();
				mail=txtMail.getText();
				status=comboBoxStatus.getSelectedItem().toString();
				

				
				try {
					prestm = con.prepareStatement("update Supplier set SuppId=?, Name=?, Address=?,Contact=?,Items=?,NumberofItems=?,Mail=?,Status=? where SuppId=? ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, address);
					prestm.setString(4, contact);
					prestm.setString(5, items);
					prestm.setString(6, number);
					prestm.setString(7, mail);
					prestm.setString(8, status);
					prestm.setString(9, id);

					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Supplier Updated Successfully");
					
					loadTable3();
					
					txtSuppId.setText("");
					txtName.setText("");
					txtAddress.setText("");
					txtContact.setText("");
					txtItems.setText("");
					txtNumber.setText("");
					txtMail.setText("");
								
					txtSuppId.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				
			}
		});
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnUpdate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setBounds(180, 486, 114, 35);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnDelete.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnDelete.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtSuppId.getText().trim();
				try {
					prestm = con.prepareStatement("delete from Supplier where SuppId=? ");
					prestm.setString(1, id);
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Supplier Deleted Successfully");

					loadTable3();
					
					txtSuppId.requestFocus();
					
					txtSuppId.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnDelete.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnDelete.setBackground(new Color(0, 128, 128));
		btnDelete.setBounds(340, 486, 114, 35);
		panel.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnClear.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnClear.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtSuppId.setText("");
				txtName.setText("");
				txtAddress.setText("");
				txtContact.setText("");
				txtItems.setText("");
				txtNumber.setText("");
				txtMail.setText("");
				//status=comboBoxStatus.getSelectedItem().toString();
				
				
			}
		});
		btnClear.setOpaque(true);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnClear.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setBounds(499, 486, 114, 35);
		panel.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnBack.setBackground(new Color(153, 102, 51).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnBack.setBackground(new Color(153, 102, 51)); 
            }
        });
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Buttons b = new Buttons();
				b.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Suppliers.class.getResource("/images/Exit.png")));
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBack.setBackground(new Color(153, 102, 51));
		btnBack.setBounds(20, 6, 114, 35);
		panel.add(btnBack);
		
		JButton btnOrder = new JButton("ORDER");
		btnOrder.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnOrder.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnOrder.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Orders o = new Orders();
				o.setVisible(true);
			}
		});
		btnOrder.setOpaque(true);
		btnOrder.setForeground(Color.WHITE);
		btnOrder.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnOrder.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnOrder.setBackground(new Color(0,128,128));
		btnOrder.setBounds(698, 312, 114, 73);
		panel.add(btnOrder);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Suppliers.class.getResource("/images/dsg2 Background Removed.png")));
		lblNewLabel.setBounds(520, 6, 356, 546);
		panel.add(lblNewLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSearch.setBackground(new Color(0, 128, 128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnSearch.setBackground(new Color(0, 128, 128)); 
            }
        });
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtSuppId.getText();
				
				try {
					prestm = con.prepareStatement("select *from Supplier where SuppId=? ");
					
					prestm.setString(1, id);
					
					rst = prestm.executeQuery();
					
					if(rst.next()) {
						
						txtSuppId.setText(rst.getString(1));
						txtName.setText(rst.getString(2));
						txtAddress.setText(rst.getString(3));
						txtContact.setText(rst.getString(4));
						txtItems.setText(rst.getString(5));
						txtNumber.setText(rst.getString(6));
						txtMail.setText(rst.getString(7));
						
					}
					else
					{
						
						txtSuppId.setText("");
						txtName.setText("");
						txtAddress.setText("");
						txtContact.setText("");
						txtItems.setText("");
						txtNumber.setText("");
						txtMail.setText("");

						txtSuppId.requestFocus();
						
						JOptionPane.showMessageDialog(null,"Item Not Found");
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setOpaque(true);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch.setBackground(new Color(0, 128, 128));
		btnSearch.setBounds(20, 53, 114, 35);
		panel.add(btnSearch);
	}

	public void setVisible(boolean b) {
		
		frame.setVisible(b);
		
	}
}
