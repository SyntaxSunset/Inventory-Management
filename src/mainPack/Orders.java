package mainPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Orders {

	private JFrame frmPlacingOrders;
	private JTable table;
	private JTextField txtSupplier;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders();
					window.frmPlacingOrders.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Orders() {
		initialize();
		BuildConnection1();
		loadTable4();
	}
	
	Connection con;
    PreparedStatement prestm;
    ResultSet rst;
    
	public void BuildConnection1() {
	 	         
	        try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryManagement", "root", "Sayan2004#");
				System.out.println("Established connection");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}    
	}
	
	
	public void loadTable4()
	{
		try {
			
			prestm = con.prepareStatement("select *from Orders ");
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
		frmPlacingOrders = new JFrame();
		frmPlacingOrders.setTitle("PLACING ORDERS");
		frmPlacingOrders.setBounds(100, 100, 898, 600);
		frmPlacingOrders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlacingOrders.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(6, 6, 886, 560);
		frmPlacingOrders.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(6, 6, 465, 182);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 453, 170);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(179, 225, 213));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(483, 6, 397, 273);
		panel.add(scrollPane_1);
		
		JTextArea Area = new JTextArea();
		scrollPane_1.setViewportView(Area);
		
		JLabel lblNewLabel_1 = new JLabel("ItemId");
		lblNewLabel_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(16, 200, 54, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(16, 253, 44, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SupplierName");
		lblNewLabel_1_2.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(16, 309, 88, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(16, 362, 66, 16);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Price");
		lblNewLabel_1_4.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(16, 412, 54, 16);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Total");
		lblNewLabel_1_5.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(16, 460, 54, 16);
		panel.add(lblNewLabel_1_5);
		
		txtSupplier = new JTextField();
		txtSupplier.setColumns(10);
		txtSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSupplier.setBackground(new Color(255, 255, 240));
		txtSupplier.setBounds(116, 299, 162, 26);
		panel.add(txtSupplier);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtId.setBackground(new Color(255, 255, 240));
		txtId.setBounds(116, 200, 162, 26);
		panel.add(txtId);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBackground(new Color(255, 255, 240));
		txtName.setBounds(116, 248, 162, 26);
		panel.add(txtName);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtQuantity.setBackground(new Color(255, 255, 240));
		txtQuantity.setBounds(116, 357, 162, 26);
		panel.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrice.setBackground(new Color(255, 255, 240));
		txtPrice.setBounds(116, 407, 162, 26);
		panel.add(txtPrice);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTotal.setBackground(new Color(255, 255, 240));
		txtTotal.setBounds(116, 455, 162, 26);
		panel.add(txtTotal);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAdd.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnAdd.setBackground(new Color(0,128,128)); 
            }
        });
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				String name = txtName.getText();
				String supplier = txtSupplier.getText();
				String Price = txtPrice.getText();
				
				try {
					prestm = con.prepareStatement("insert into Orders(ItemId, Name, SupplierName,Price)values(?,?,?,?) ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, supplier);
					prestm.setString(4, Price);
					
					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Added Successfully");
					
					loadTable4();
					
					
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
		btnAdd.setBounds(16, 508, 114, 35);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0,128,128)); 
            }
        });
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String supplier = txtSupplier.getText().trim();
				String Price = txtPrice.getText().trim();
				
				try {
					prestm = con.prepareStatement("update Orders set ItemId=?, Name=?, SupplierName=? ,Price=? where ItemId=? ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, supplier);
					prestm.setString(4, Price);
					prestm.setString(5, id);
					
					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Updated Successfully");
					
					loadTable4();
					
					
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
		btnUpdate.setBounds(153, 508, 114, 35);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnDelete.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnDelete.setBackground(new Color(0,128,128)); 
            }
        });
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtId.getText().trim();
				try {
					prestm = con.prepareStatement("delete from Orders where ItemId=? ");
					prestm.setString(1, id);
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Deleted Successfully");

					loadTable4();
					
					txtId.requestFocus();
					
					txtId.setText("");
					
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
		btnDelete.setBounds(294, 508, 114, 35);
		panel.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnClear.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnClear.setBackground(new Color(0,128,128)); 
            }
        });
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtName.setText("");
				txtSupplier.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");
				txtTotal.setText("");
			}
		});
		btnClear.setOpaque(true);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnClear.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setBounds(438, 508, 114, 35);
		panel.add(btnClear);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnOrder.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnOrder.setBackground(new Color(0,128,128)); 
            }
        });
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				String name = txtName.getText();
				String supplier = txtSupplier.getText();
				String quantity = txtQuantity.getText();
				String Price = txtPrice.getText();
				String total = txtTotal.getText();
				
				Date obj1 = new Date();
				String date = obj1.toString();
				
				try {
					prestm = con.prepareStatement("insert into Sales (ItemId, Name, SupplierName,Quantity,Price,Total,DateAndTime)values(?,?,?,?,?,?,?) ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, supplier);
					prestm.setString(4, quantity);
					prestm.setString(5, Price);
					prestm.setString(6, total);
					prestm.setString(7, date);
					
					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Ordered Successfully");
					
					//loadTable4();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnOrder.setOpaque(true);
		btnOrder.setForeground(Color.WHITE);
		btnOrder.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnOrder.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnOrder.setBackground(new Color(0, 128, 128));
		btnOrder.setBounds(483, 309, 114, 35);
		panel.add(btnOrder);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnReceipt.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnReceipt.setBackground(new Color(0,128,128)); 
            }
        });
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Area.setText("----------------------------------------------\n");
				Area.setText(Area.getText()+"                	   Order Receipt System                \n");
				Area.setText(Area.getText()+"----------------------------------------------\n");
				
				Date obj = new Date();
				String date = obj.toString();
				
				Area.setText(Area.getText()+"\n"+date+"\n\n");
				Area.setText(Area.getText()+" Item Id : "+txtId.getText()+"\n\n");
				Area.setText(Area.getText()+" Item Name : "+txtName.getText()+"\n\n");
				Area.setText(Area.getText()+" Supplier Name : "+txtSupplier.getText()+"\n\n");
				Area.setText(Area.getText()+" Total quantity : "+txtQuantity.getText()+"\n\n");
				Area.setText(Area.getText()+" Price Per Item : "+txtPrice.getText()+"\n\n");
				Area.setText(Area.getText()+"----------------------------------------------\n");
				Area.setText(Area.getText()+" Total Price : "+txtTotal.getText()+"\n");
				Area.setText(Area.getText()+"\n                                		Signature");
			}
		});
		btnReceipt.setOpaque(true);
		btnReceipt.setForeground(Color.WHITE);
		btnReceipt.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnReceipt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnReceipt.setBackground(new Color(0, 128, 128));
		btnReceipt.setBounds(699, 309, 114, 35);
		panel.add(btnReceipt);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPrint.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnPrint.setBackground(new Color(0,128,128)); 
            }
        });
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            // Use the JTextArea's print method to print its contents directly
		            boolean complete = Area.print();
		            if (complete) {
		                JOptionPane.showMessageDialog(null, "Printing Complete", "Print", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "Printing Canceled", "Print", JOptionPane.WARNING_MESSAGE);
		            }
		        } catch (Exception printException) {
		            printException.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Printing Failed: " + printException.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnPrint.setOpaque(true);
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnPrint.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnPrint.setBackground(new Color(0, 128, 128));
		btnPrint.setBounds(591, 379, 114, 35);
		panel.add(btnPrint);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSearch.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnSearch.setBackground(new Color(0,128,128)); 
            }
        });
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				
				try {
					prestm = con.prepareStatement("select *from Orders where ItemId=? ");
					
					prestm.setString(1, id);
					
					rst = prestm.executeQuery();
					
					if(rst.next()) {
						
						txtId.setText(rst.getString(1));
						txtName.setText(rst.getString(2));
						txtSupplier.setText(rst.getString(3));
						txtPrice.setText(rst.getString(4));
						
					}
					else
					{
						
						txtId.setText("");
						txtName.setText("");
						txtSupplier.setText("");
						txtPrice.setText("");
						

						txtId.requestFocus();
						
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
		btnSearch.setBounds(294, 290, 114, 35);
		panel.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnBack.setBackground(new Color(153,102,51).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnBack.setBackground(new Color(153,102,51)); 
            }
        });
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPlacingOrders.setVisible(false);
				Suppliers sp = new Suppliers();
				sp.setVisible(true);
			}
		});
		btnBack.setOpaque(true);
		btnBack.setIcon(new ImageIcon(Orders.class.getResource("/images/Exit.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBack.setBackground(new Color(153, 102, 51));
		btnBack.setBounds(742, 441, 114, 35);
		panel.add(btnBack);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnCalculate.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnCalculate.setBackground(new Color(0,128,128)); 
            }
        });
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            int quantity = Integer.parseInt(txtQuantity.getText().trim());
		            double price = Double.parseDouble(txtPrice.getText().trim());
		            double total = quantity * price;
		            txtTotal.setText(String.valueOf(total));
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.", "Input Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnCalculate.setOpaque(true);
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnCalculate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCalculate.setBackground(new Color(0, 128, 128));
		btnCalculate.setBounds(294, 451, 114, 35);
		panel.add(btnCalculate);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnShowAll.setBackground(new Color(0,128,128).darker()); 
            }

            public void mouseExited(MouseEvent evt) {
                btnShowAll.setBackground(new Color(0,128,128)); 
            }
        });
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadTable4();
				
			}
		});
		btnShowAll.setOpaque(true);
		btnShowAll.setForeground(Color.WHITE);
		btnShowAll.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnShowAll.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnShowAll.setBackground(new Color(0, 128, 128));
		btnShowAll.setBounds(591, 508, 114, 35);
		panel.add(btnShowAll);
	}

	public void setVisible(boolean b) {
		frmPlacingOrders.setVisible(b);
		
	}
}
