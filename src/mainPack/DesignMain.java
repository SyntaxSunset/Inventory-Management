package mainPack;

import java.sql.*;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class DesignMain {

	private JFrame frmProductManagement;
	private JTextField txtPname;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtSearchId;
	private JTable table;
	private JTextField txtSellId;
	private JTextField txtSellQuantity;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignMain window = new DesignMain();
					window.frmProductManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesignMain() {
		initialize();
		BuildConnection();
		loadTable();
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
	
	public void loadTable()
	{
		try {
			prestm = con.prepareStatement("select *from Product_Table ");
			rst = prestm.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProductManagement = new JFrame();
		frmProductManagement.setResizable(false);
		frmProductManagement.setTitle("PRODUCT MANAGEMENT");
		frmProductManagement.getContentPane().setBackground(new Color(255, 255, 204));
		frmProductManagement.setBackground(new Color(255, 255, 255));
		frmProductManagement.setBounds(100, 100, 780, 715);
		frmProductManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Product Management System");
		lblNewLabel.setBounds(136, 6, 483, 59);
		lblNewLabel.setFont(new Font("Maku", Font.BOLD, 40));
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 77, 265, 291);
		panel.setBackground(new Color(255, 215, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add Items", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 33, 95, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Mali", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(20, 85, 95, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price Per Item");
		lblNewLabel_1_2.setFont(new Font("Mali", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(20, 142, 95, 16);
		panel.add(lblNewLabel_1_2);
		
		txtPname = new JTextField();
		txtPname.setBackground(new Color(255, 255, 240));
		txtPname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPname.setBounds(127, 28, 114, 26);
		panel.add(txtPname);
		txtPname.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBackground(new Color(255, 255, 240));
		txtQuantity.setColumns(10);
		txtQuantity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtQuantity.setBounds(127, 80, 114, 26);
		panel.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(new Color(255, 255, 240));
		txtPrice.setColumns(10);
		txtPrice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrice.setBounds(127, 137, 114, 26);
		panel.add(txtPrice);
		
		JButton btnAdditem = new JButton("Add Item");
		btnAdditem.setForeground(new Color(255, 255, 255));
		btnAdditem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAdditem.setOpaque(true);
		btnAdditem.setBackground(new Color(0, 128, 128));
		btnAdditem.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAdditem.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            public void mouseExited(MouseEvent evt) {
                btnAdditem.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnAdditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name,quantity,price;
				name=txtPname.getText();
				quantity=txtQuantity.getText();
				price = txtPrice.getText();
				
				try {
					prestm = con.prepareStatement("insert into Product_Table(ProductName, Quantity, PricePerItem)values(?,?,?) ");
					
					prestm.setString(1, name);
					prestm.setString(2, quantity);
					prestm.setString(3, price);
					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Added Successfully");
					
					loadTable();
					
					txtPname.setText("");
					txtQuantity.setText("");
					txtPrice.setText("");
					
					txtPname.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdditem.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnAdditem.setBounds(20, 208, 114, 35);
		panel.add(btnAdditem);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setOpaque(true);
		btnClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnClear.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnClear.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPname.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");
				
				txtPname.requestFocus();
			}
		});
		btnClear.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnClear.setBounds(146, 208, 113, 35);
		panel.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 391, 265, 115);
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBorder(new TitledBorder(null, "Item Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel txtnewsearch = new JLabel("Enter Item ID");
		txtnewsearch.setFont(new Font("Mali", Font.PLAIN, 13));
		txtnewsearch.setBounds(6, 27, 92, 16);
		panel_1.add(txtnewsearch);
		
		txtSearchId = new JTextField();
		txtSearchId.setBackground(new Color(255, 255, 240));
		txtSearchId.setColumns(10);
		txtSearchId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSearchId.setBounds(110, 22, 114, 26);
		panel_1.add(txtSearchId);
		
		JButton btnSearch = new JButton("Search In Inventory");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSearch.setBackground(new Color(0, 128, 128));
		btnSearch.setOpaque(true);
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
				
					String SearchId = txtSearchId.getText();
					
					try {
						prestm = con.prepareStatement("select *from Product_Table where ID=? ");
						
						prestm.setString(1, SearchId);
						
						rst = prestm.executeQuery();
						
						if(rst.next()) {
							
							txtPname.setText(rst.getString(2));
							txtQuantity.setText(rst.getString(3));
							txtPrice.setText(rst.getString(4));
							
						}
						else
						{
							txtPname.setText("");
							txtQuantity.setText("");
							txtPrice.setText("");
							
							txtSearchId.setText("");
							
							txtPname.requestFocus();
							
							JOptionPane.showMessageDialog(null,"Item Not Found");
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
			}
		});
		btnSearch.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSearch.setBounds(58, 63, 142, 35);
		panel_1.add(btnSearch);
		
		table = new JTable();
		table.setBounds(6, 108, 1, 1);
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(38, 518, 265, 101);
		panel_2.setBackground(new Color(255, 215, 0));
		panel_2.setBorder(new TitledBorder(null, "Modify Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setOpaque(true);
		btnUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnUpdate.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name,quantity,price,id;
				name=txtPname.getText();
				quantity=txtQuantity.getText();
				price = txtPrice.getText();
				id=txtSearchId.getText();
				
				try {
					prestm = con.prepareStatement("update Product_Table set ProductName=?, Quantity=?, PricePerItem=? where ID=? ");
					
					prestm.setString(1, name);
					prestm.setString(2, quantity);
					prestm.setString(3, price);
					prestm.setString(4, id);

					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Updated Successfully");
					
					loadTable();
					
					txtPname.setText("");
					txtQuantity.setText("");
					txtPrice.setText("");
					
					txtPname.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnUpdate.setBounds(18, 39, 114, 35);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnDelete.setBackground(new Color(0, 128, 128));
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnDelete.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnDelete.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtSearchId.getText();
				try {
					prestm = con.prepareStatement("delete from Product_Table where ID=? ");
					prestm.setString(1, id);
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Item Deleted Successfully");

					loadTable();
					
					txtPname.setText("");
					txtQuantity.setText("");
					txtPrice.setText("");
					
					txtPname.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnDelete.setBounds(144, 39, 114, 35);
		panel_2.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(630, 41, 114, 35);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnExit.setBackground(new Color(0, 128, 128));
		btnExit.setOpaque(true);
		btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnExit.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnExit.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(315, 391, 432, 211);
		panel_4.setBackground(new Color(255, 215, 0));
		panel_4.setBorder(new TitledBorder(null, "Sell Items", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Item ID");
		lblNewLabel_3.setFont(new Font("Mali", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(17, 42, 116, 16);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1.setFont(new Font("Mali", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(17, 116, 95, 16);
		panel_4.add(lblNewLabel_1_1_1);
		
		txtSellId = new JTextField();
		txtSellId.setBackground(new Color(255, 255, 240));
		txtSellId.setColumns(10);
		txtSellId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSellId.setBounds(145, 38, 136, 26);
		panel_4.add(txtSellId);
		
		txtSellQuantity = new JTextField();
		txtSellQuantity.setBackground(new Color(255, 255, 240));
		txtSellQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String sellId = txtSellId.getText();
				String sellQuantity = 	txtSellQuantity.getText();
				
				try {
					prestm = con.prepareStatement("select *from Product_Table where ID=? ");
					
					prestm.setString(1, sellId);
					
					rst = prestm.executeQuery();
					
					if(rst.next()) {
						
						if(Integer.parseInt(sellQuantity)<=Integer.parseInt(rst.getString(3)))
						{
						
						txtPname.setText(rst.getString(2));
						txtQuantity.setText(rst.getString(3));
						txtPrice.setText(rst.getString(4));
						}
						else
						{
							txtPname.setText("");
							txtQuantity.setText("");
							txtPrice.setText("");
							JOptionPane.showMessageDialog(null,"Enough Item Not Present");
							txtSellQuantity.setText("");
							
							txtSellQuantity.requestFocus();
							
						}
					}
					else
					{
						txtPname.setText("");
						txtQuantity.setText("");
						txtPrice.setText("");
						
						txtPname.requestFocus();
						
						JOptionPane.showMessageDialog(null,"Item Not Found");
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtSellQuantity.setColumns(10);
		txtSellQuantity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSellQuantity.setBounds(145, 112, 136, 26);
		panel_4.add(txtSellQuantity);
		
		JButton btnSellItem = new JButton("Sell Items");
		btnSellItem.setForeground(new Color(255, 255, 255));
		btnSellItem.setOpaque(true);
		btnSellItem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSellItem.setBackground(new Color(0, 128, 128));
		btnSellItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnSellItem.setBackground(new Color(0, 128, 128).darker()); // Change to darker shade on hover
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnSellItem.setBackground(new Color(0, 128, 128)); // Revert to original color
            }
        });
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name ,quantity ,price ,id,sellQuantity;
				name=txtPname.getText();
				quantity=txtQuantity.getText();
				price = txtPrice.getText();
				id=txtSellId.getText();
				sellQuantity=txtSellQuantity.getText();
				
				int quantity1 = Integer.parseInt(txtSellQuantity.getText().trim());
	            double price1 = Double.parseDouble(txtPrice.getText().trim());
	            double total = quantity1 * price1;
	            String total1 = String.valueOf(total);
	          
				
				Integer diffOfQuantity = Integer.parseInt(quantity)-Integer.parseInt(sellQuantity);
				
				
				try {
					
					Date obj = new Date();
					String date = obj.toString();
					
					prestm = con.prepareStatement("update Product_Table set Quantity=? where ID=? ");
					
					prestm.setString(1, diffOfQuantity.toString());
					prestm.setString(2, id);

					
					prestm.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Items Sold!!");
					
					prestm = con.prepareStatement("insert into Sold (ItemId,Name,Quantity,PricePerItem,Total,DateAndTime) values (?,?,?,?,?,?) ");
					
					prestm.setString(1, id);
					prestm.setString(2, name);
					prestm.setString(3, sellQuantity);
					prestm.setString(4, price);
					prestm.setString(5, total1);
					prestm.setString(6, date);
					
					prestm.executeUpdate();
					
					loadTable();
					
					txtPname.setText("");
					txtQuantity.setText("");
					txtPrice.setText("");
					
					txtSellId.setText("");
					txtSellQuantity.setText("");
					
					
					txtSellId.requestFocus();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSellItem.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnSellItem.setBounds(297, 59, 114, 57);
		panel_4.add(btnSellItem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(314, 77, 430, 291);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 418, 279);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(179, 225, 213));
		table_1.setGridColor(new Color(0, 0, 0));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table_1);
		frmProductManagement.getContentPane().setLayout(null);
		frmProductManagement.getContentPane().add(lblNewLabel);
		frmProductManagement.getContentPane().add(btnExit);
		frmProductManagement.getContentPane().add(panel);
		frmProductManagement.getContentPane().add(panel_3);
		frmProductManagement.getContentPane().add(panel_1);
		frmProductManagement.getContentPane().add(panel_2);
		frmProductManagement.getContentPane().add(panel_4);
		
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
				
				frmProductManagement.setVisible(false);
				Buttons b = new Buttons();
				b.setVisible(true);
			}
		});
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 14));
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBack.setBackground(new Color(153, 102, 51));
		btnBack.setBounds(0, 6, 114, 35);
		frmProductManagement.getContentPane().add(btnBack);
		frmProductManagement.setVisible(false);
	}

	public void setVisible(boolean b) {
		frmProductManagement.setVisible(b);
	}
}
