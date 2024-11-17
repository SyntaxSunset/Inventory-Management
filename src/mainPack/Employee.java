package mainPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Employee {

	private JFrame frmEmployeeDetails;
	private JTextField txtSearch;
	private JTable table;
	private JTextField txtId;
	private JTextField txtAddress;
	private JTextField txtName;
	private JTextField txtJoining;
	private JTextField txtDateofBirth;
	private JTextField txtSalary;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JPasswordField txtPassword1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frmEmployeeDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Employee() {
		initialize();
		BuildConnection();
		loadTable2();
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
	
	public void loadTable2()
	{
		try {
			
			prestm = con.prepareStatement("select *from Employee ");
			rst = prestm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void initialize() {
		frmEmployeeDetails = new JFrame();
		frmEmployeeDetails.setForeground(new Color(255, 250, 205));
		frmEmployeeDetails.setBackground(new Color(255, 250, 205));
		frmEmployeeDetails.setTitle("EMPLOYEE DETAILS");
		frmEmployeeDetails.setBounds(100, 100, 898, 588);
		frmEmployeeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeDetails.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(6, 0, 886, 554);
		frmEmployeeDetails.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblManageEmployeeDetails = new JLabel("Manage Employee Details");
		lblManageEmployeeDetails.setBounds(210, 6, 377, 68);
		lblManageEmployeeDetails.setFont(new Font("Maku", Font.BOLD, 40));
		panel.add(lblManageEmployeeDetails);
		
		JComboBox comboBoxSearch = new JComboBox();
		comboBoxSearch.setOpaque(true);
		comboBoxSearch.setBackground(new Color(255, 255, 240));
		comboBoxSearch.setModel(new DefaultComboBoxModel(new String[] {"Search By", "EmpId", "Name", "Gender", "DateOfBirth", "Contact", "EmploymentType", "Education", "WorkShift"}));
		comboBoxSearch.setBounds(147, 86, 136, 27);
		panel.add(comboBoxSearch);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSearch.setBackground(new Color(255, 255, 240));
		txtSearch.setBounds(338, 86, 162, 26);
		panel.add(txtSearch);
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnSearch.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnSearch.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchValue = txtSearch.getText().trim();
		        String searchBy = comboBoxSearch.getSelectedItem().toString();

		        // Map combo box selection to actual column names in the Employee table
		        String column = "";
		        
		        switch (searchBy) {
	            case "EmpId":
	                column = "EmpId";
	                break;
	            case "Name":
	                column = "Name";
	                break;
	            case "Gender":
	                column = "Gender";
	                break;
	            case "DateOfBirth":
	                column = "DateOfBirth";
	                break;
	            case "Contact":
	                column = "Contact";
	                break;
	            case "EmploymentType":
	                column = "EmploymentType";
	                break;
	            case "Education":
	                column = "Education";
	                break;
	            case "WorkShift":
	                column = "WorkShift";
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Please select a valid search field.");
	                return;
	        }

		        if (column.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please select a valid search field.");
		            return;
		        }

		        if (searchValue.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a value to search.");
		            return;
		        }

		        try {
		            String query = "SELECT * FROM Employee WHERE " + column + " = ?";
		            prestm = con.prepareStatement(query);
		            prestm.setString(1, searchValue);

		            rst = prestm.executeQuery();

		            if (!rst.isBeforeFirst()) { // Check if ResultSet is empty
		                JOptionPane.showMessageDialog(null, "Employee not found.");
		                txtId.setText("");
		    		    txtName.setText("");
		    		    txtDateofBirth.setText("");
		    		    txtContact.setText("");
		    		    txtAddress.setText("");
		    		    txtSalary.setText("");
		    		    txtJoining.setText("");
		    		    txtEmail.setText("");
		            } else {
		                // Update the table with results
		            	
		                table.setModel(DbUtils.resultSetToTableModel(rst));
//		                if (column.equals("EmpId") && rst.next()) {
//		                	
//		                	
//		        		    txtId.setText(rst.getString("EmpId"));
//		        		    txtName.setText(rst.getString("Name"));
//		        		    txtDateofBirth.setText(rst.getString("DateOfBirth"));
//		        		    txtContact.setText(rst.getString("Contact"));
//		        		    txtAddress.setText(rst.getString("Address"));
//		        		    txtSalary.setText(rst.getString("Salary"));
//		        		    txtJoining.setText(rst.getString("JoiningDate"));
//		        		    txtEmail.setText(rst.getString("Email"));
//		        		    
//		        		    System.out.println("Employee found:");
//		                    System.out.println("EmpId: " + rst.getString("EmpId"));
//		                    System.out.println("Name: " + rst.getString("Name"));
//		                    System.out.println("DateOfBirth: " + rst.getString("DateOfBirth"));
//		                    System.out.println("Contact: " + rst.getString("Contact"));
//		                    System.out.println("Address: " + rst.getString("Address"));
//		                    System.out.println("Salary: " + rst.getString("Salary"));
//		                    System.out.println("Joining Date: " + rst.getString("JoiningDate"));
//		                    System.out.println("Email: " + rst.getString("Email"));
//
//		                }
		                
		                System.out.println("End");
		                
		            }
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "An error occurred while searching: " + e1.getMessage());
		        }
		    }
		});


		
		btnSearch.setOpaque(true);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch.setBackground(new Color(0, 128, 128));
		btnSearch.setBounds(552, 86, 114, 35);
		panel.add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnShowAll.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnShowAll.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadTable2();
			}
		});
		btnShowAll.setOpaque(true);
		btnShowAll.setForeground(Color.WHITE);
		btnShowAll.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnShowAll.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnShowAll.setBackground(new Color(0, 128, 128));
		btnShowAll.setBounds(678, 86, 114, 35);
		panel.add(btnShowAll);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(6, 125, 863, 172);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 851, 160);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(new Color(179, 225, 213));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("EmpId");
		lblNewLabel_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(30, 309, 54, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(30, 347, 54, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Employment Type");
		lblNewLabel_1_2.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(30, 388, 114, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(30, 429, 54, 16);
		panel.add(lblNewLabel_1_3);
		
		JComboBox <String> comboBoxGender = new JComboBox<>();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Others"}));
		comboBoxGender.setOpaque(true);
		comboBoxGender.setBackground(new Color(255, 255, 240));
		comboBoxGender.setBounds(147, 343, 162, 27);
		panel.add(comboBoxGender);
		
		JComboBox <String> comboBoxType = new JComboBox<>();
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "Full Time", "Part Time", "Contract"}));
		comboBoxType.setOpaque(true);
		comboBoxType.setBackground(new Color(255, 255, 240));
		comboBoxType.setBounds(147, 382, 162, 27);
		panel.add(comboBoxType);
		
		JComboBox <String> comboBoxUserType = new JComboBox<>();
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Select ", "Employee"}));
		comboBoxUserType.setOpaque(true);
		comboBoxUserType.setBackground(new Color(255, 255, 240));
		comboBoxUserType.setBounds(414, 465, 162, 27);
		panel.add(comboBoxUserType);
		
		JComboBox <String> comboBoxEducation = new JComboBox<>();
		comboBoxEducation.setModel(new DefaultComboBoxModel(new String[] {"Select", "B.Tech", "M.Tech", "B.Com", "B.Sc", "MBA", "BBA", "BCA"}));
		comboBoxEducation.setOpaque(true);
		comboBoxEducation.setBackground(new Color(255, 255, 240));
		comboBoxEducation.setBounds(414, 377, 162, 27);
		panel.add(comboBoxEducation);
		
		JComboBox <String> comboBoxWork = new JComboBox<>();
		comboBoxWork.setModel(new DefaultComboBoxModel(new String[] {"Select", "Morning", "Evening", "Night"}));
		comboBoxWork.setOpaque(true);
		comboBoxWork.setBackground(new Color(255, 255, 240));
		comboBoxWork.setBounds(678, 384, 162, 27);
		panel.add(comboBoxWork);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtId.setBackground(new Color(255, 255, 240));
		txtId.setBounds(147, 309, 162, 26);
		panel.add(txtId);
		
		txtAddress = new JTextField();
		txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
		txtAddress.setColumns(10);
		txtAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddress.setBackground(new Color(255, 255, 240));
		txtAddress.setBounds(147, 418, 162, 87);
		panel.add(txtAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnSave.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnSave.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String id,salary;
				String name,gender,dateofbirth,contact,employmenttype,edu,shift,address,usertype,joiningdate,email,id,salary;
				id=txtId.getText();
				name=txtName.getText();
				gender=comboBoxGender.getSelectedItem().toString();
				dateofbirth =txtDateofBirth.getText() ;
				contact=txtContact.getText();
				employmenttype=comboBoxType.getSelectedItem().toString();
				edu=comboBoxEducation.getSelectedItem().toString();
				shift=comboBoxWork.getSelectedItem().toString();
				address=txtAddress.getText();
				salary=txtSalary.getText();
				usertype=comboBoxUserType.getSelectedItem().toString();
				joiningdate=txtJoining.getText();
				email=txtEmail.getText();
				String password=new String(txtPassword1.getPassword());
				
				if(password.equals("manager123")) {
				
				try {
					prestm = con.prepareStatement("insert into Employee (EmpId, Name, Gender,DateOfBirth,Contact,EmploymentType,Education,WorkShift,Address,Salary,UserType,JoiningDate,Email)values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, gender);
					prestm.setString(4, dateofbirth);
					prestm.setString(5, contact);
					prestm.setString(6, employmenttype);
					prestm.setString(7, edu);
					prestm.setString(8, shift);
					prestm.setString(9, address);
					prestm.setString(10, salary);
					prestm.setString(11, usertype);
					prestm.setString(12, joiningdate);
					prestm.setString(13, email);
				
				
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Employee Added Successfully");
					
					loadTable2();
					
//					txtPname.setText("");
//					txtQuantity.setText("");
//					txtPrice.setText("");
//					
//					txtPname.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			 }
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Password Entered");
				}
				
			}
		});
		btnSave.setOpaque(true);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSave.setBackground(new Color(0, 128, 128));
		btnSave.setBounds(147, 517, 114, 35);
		panel.add(btnSave);
		
		JButton btnSearch_1_1 = new JButton("Update");
		btnSearch_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnSearch_1_1.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnSearch_1_1.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSearch_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchValue = txtSearch.getText().trim();
		        String searchBy = comboBoxSearch.getSelectedItem().toString();
		        String name,gender,dateofbirth,contact,employmenttype,edu,shift,address,usertype,joiningdate,email,id,salary;
				id=txtId.getText();
				name=txtName.getText();
				gender=comboBoxGender.getSelectedItem().toString();
				dateofbirth =txtDateofBirth.getText() ;
				contact=txtContact.getText();
				employmenttype=comboBoxType.getSelectedItem().toString();
				edu=comboBoxEducation.getSelectedItem().toString();
				shift=comboBoxWork.getSelectedItem().toString();
				address=txtAddress.getText();
				salary=txtSalary.getText();
				usertype=comboBoxUserType.getSelectedItem().toString();
				joiningdate=txtJoining.getText();
				email=txtEmail.getText();

		        // Map combo box selection to actual column names in the Employee table
		        String column = "";
		        
		        switch (searchBy) {
	            case "EmpId":
	                column = "EmpId";
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Please select a valid search field.");
	                return;
	        }
		        try {
		            String query = "SELECT * FROM Employee WHERE " + column + " = ?";
		            prestm = con.prepareStatement(query);
		            prestm.setString(1, searchValue);

		            rst = prestm.executeQuery();

		            if (!rst.isBeforeFirst()) { // Check if ResultSet is empty
		                JOptionPane.showMessageDialog(null, "Employee not found.");

		            } else {
		                
		                if (column.equals("EmpId") && rst.next()) {
		                	
		                	
		        		    txtId.setText(rst.getString("EmpId"));
		        		    txtName.setText(rst.getString("Name"));
		        		    txtDateofBirth.setText(rst.getString("DateOfBirth"));
		        		    txtContact.setText(rst.getString("Contact"));
		        		    txtAddress.setText(rst.getString("Address"));
		        		    txtSalary.setText(rst.getString("Salary"));
		        		    txtJoining.setText(rst.getString("JoiningDate"));
		        		    txtEmail.setText(rst.getString("Email"));
		        		    
		        		    try {
		        		    
		        		    prestm = con.prepareStatement("update Employee set Name=?, Gender=?,DateOfBirth=?,Contact=?,EmploymentType=?,Education=?,WorkShift=?,Address=?,Salary=?,UserType=?,JoiningDate=?,Email=? where EmpId=?");
							
							prestm.setString(13, id);
							prestm.setString(1, name);
							prestm.setString(2, gender);
							prestm.setString(3, dateofbirth);
							prestm.setString(4, contact);
							prestm.setString(5, employmenttype);
							prestm.setString(6, edu);
							prestm.setString(7, shift);
							prestm.setString(8, address);
							prestm.setString(9, salary);
							prestm.setString(10, usertype);
							prestm.setString(11, joiningdate);
							prestm.setString(12, email);
						
						
							prestm.executeUpdate();
							
//							JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
			                
							loadTable2();
			    		    
		        		    }catch (SQLException e1) {
		    					e1.printStackTrace();
		    				}
  
		                }
						
		                //System.out.println("End");
                
		            }
		            
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "An error occurred while searching: " + e1.getMessage());
		        }
				
				
				
			}
		});
		btnSearch_1_1.setOpaque(true);
		btnSearch_1_1.setForeground(Color.WHITE);
		btnSearch_1_1.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch_1_1.setBackground(new Color(0, 128, 128));
		btnSearch_1_1.setBounds(288, 517, 114, 35);
		panel.add(btnSearch_1_1);
		
		JButton btnSearch_1_2 = new JButton("Delete");
		btnSearch_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnSearch_1_2.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnSearch_1_2.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSearch_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtSearch.getText().trim();
				try {
					prestm = con.prepareStatement("delete from Employee where EmpId=? ");
					prestm.setString(1, id);
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Deleted Successfully");

					loadTable2();
					
					txtSearch.requestFocus();
					
					txtSearch.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch_1_2.setOpaque(true);
		btnSearch_1_2.setForeground(Color.WHITE);
		btnSearch_1_2.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch_1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch_1_2.setBackground(new Color(0, 128, 128));
		btnSearch_1_2.setBounds(441, 517, 114, 35);
		panel.add(btnSearch_1_2);
		
		JButton btnSearch_1_3 = new JButton("Clear");
		btnSearch_1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	btnSearch_1_3.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	btnSearch_1_3.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSearch_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
    		    txtName.setText("");
    		    txtDateofBirth.setText("");
    		    txtContact.setText("");
    		    txtAddress.setText("");
    		    txtSalary.setText("");
    		    txtJoining.setText("");
    		    txtEmail.setText("");
    		    
    		    txtId.requestFocus();
				
				
			}
		});
		btnSearch_1_3.setOpaque(true);
		btnSearch_1_3.setForeground(Color.WHITE);
		btnSearch_1_3.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch_1_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch_1_3.setBackground(new Color(0, 128, 128));
		btnSearch_1_3.setBounds(597, 517, 114, 35);
		panel.add(btnSearch_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Name");
		lblNewLabel_1_4.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(321, 314, 54, 16);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Date of Birth");
		lblNewLabel_1_5.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(321, 347, 84, 16);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Education");
		lblNewLabel_1_6.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(321, 388, 71, 16);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Joining Date");
		lblNewLabel_1_7.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(321, 429, 81, 16);
		panel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("User Type");
		lblNewLabel_1_8.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_8.setBounds(321, 469, 71, 16);
		panel.add(lblNewLabel_1_8);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBackground(new Color(255, 255, 240));
		txtName.setBounds(414, 314, 162, 21);
		panel.add(txtName);
		
		txtJoining = new JTextField();
		txtJoining.setColumns(10);
		txtJoining.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtJoining.setBackground(new Color(255, 255, 240));
		txtJoining.setBounds(414, 424, 162, 26);
		panel.add(txtJoining);
		
		txtDateofBirth = new JTextField();
		txtDateofBirth.setColumns(10);
		txtDateofBirth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDateofBirth.setBackground(new Color(255, 255, 240));
		txtDateofBirth.setBounds(417, 345, 162, 21);
		panel.add(txtDateofBirth);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email");
		lblNewLabel_1_4_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(597, 316, 54, 16);
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Contact");
		lblNewLabel_1_4_2.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4_2.setBounds(597, 347, 54, 16);
		panel.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Work Shift");
		lblNewLabel_1_4_3.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4_3.setBounds(597, 388, 69, 16);
		panel.add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Salary");
		lblNewLabel_1_4_4.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4_4.setBounds(597, 429, 54, 16);
		panel.add(lblNewLabel_1_4_4);
		
		JLabel lblNewLabel_1_4_5 = new JLabel("Password");
		lblNewLabel_1_4_5.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4_5.setBounds(597, 469, 69, 16);
		panel.add(lblNewLabel_1_4_5);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSalary.setBackground(new Color(255, 255, 240));
		txtSalary.setBounds(678, 424, 162, 26);
		panel.add(txtSalary);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContact.setBackground(new Color(255, 255, 240));
		txtContact.setBounds(678, 342, 162, 26);
		panel.add(txtContact);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setBackground(new Color(255, 255, 240));
		txtEmail.setBounds(678, 309, 162, 26);
		panel.add(txtEmail);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.setBackground(new Color(255, 255, 240));
		txtPassword1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword1.setBounds(678, 464, 162, 27);
		panel.add(txtPassword1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnBack.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
            	btnBack.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmEmployeeDetails.setVisible(false);
				Buttons b = new Buttons();
				b.setVisible(true);		
			}
		});
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBack.setBackground(new Color(153, 102, 51));
		btnBack.setBounds(6, 6, 114, 35);
		panel.add(btnBack);
	}
	public void setVisible(boolean b) {
		frmEmployeeDetails.setVisible(b);
	}
}
