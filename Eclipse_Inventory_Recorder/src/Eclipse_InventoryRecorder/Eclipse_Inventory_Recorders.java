package Eclipse_InventoryRecorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Eclipse_Inventory_Recorders extends JFrame {

	private JPanel contentPane;
	private JTextField jtxtEnterItem;
	private JFrame frame;
	private JList jlstAddItems;
	DefaultListModel fill = new DefaultListModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());;
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eclipse_Inventory_Recorders frame = new Eclipse_Inventory_Recorders();
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
	public Eclipse_Inventory_Recorders() {
		setTitle("Inventory Recording System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		panel.setBounds(22, 11, 1300, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHowToAdd = new JLabel("How to Add, Select and Delete Record from JList");
		lblHowToAdd.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblHowToAdd.setBounds(59, 11, 1171, 56);
		panel.add(lblHowToAdd);
		
		JPanel jPanel0 = new JPanel();
		jPanel0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		jPanel0.setBounds(22, 540, 975, 94);
		contentPane.add(jPanel0);
		jPanel0.setLayout(null);
		
		JLabel jlblConfirm = new JLabel("Enter a Data");
		jlblConfirm.setFont(new Font("Tahoma", Font.BOLD, 36));
		jlblConfirm.setBounds(35, 22, 930, 61);
		jPanel0.add(jlblConfirm);
		
		JLabel lblEnterAData = new JLabel("Enter a Data");
		lblEnterAData.setBounds(28, 120, 315, 56);
		contentPane.add(lblEnterAData);
		lblEnterAData.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!jtxtEnterItem.getText().trim().equals("")) {
					fill.addElement(jtxtEnterItem.getText().trim().toUpperCase());
					jtxtEnterItem.setText("");
					jtxtEnterItem.grabFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "You must enter an item");
					jtxtEnterItem.grabFocus();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 46));
		btnNewButton.setBounds(896, 120, 426, 94);
		contentPane.add(btnNewButton);
		
		JButton btnConfirmData = new JButton("Confirm Data");
		btnConfirmData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (jlstAddItems.getSelectedIndex() != -1) {
					data = "Selected item: " + jlstAddItems.getSelectedValue();
					jlblConfirm.setText(data);
				} 
				else {
					JOptionPane.showMessageDialog(null, "You must select an item");
				}
			}
		});
		btnConfirmData.setFont(new Font("Tahoma", Font.BOLD, 46));
		btnConfirmData.setBounds(896, 225, 426, 94);
		contentPane.add(btnConfirmData);
		
		JButton btnDeleteData = new JButton("Delete Data");
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jlstAddItems.getSelectedIndex() != -1) {
					fill.removeElementAt(jlstAddItems.getAnchorSelectionIndex());
					jtxtEnterItem.grabFocus();
				} 
				else {
					JOptionPane.showMessageDialog(null, "You must select an item to be deleted");
				}
			}
		});
		btnDeleteData.setFont(new Font("Tahoma", Font.BOLD, 46));
		btnDeleteData.setBounds(896, 330, 426, 94);
		contentPane.add(btnDeleteData);
		
		JButton btnResetAllSystem = new JButton("Reset All System");
		btnResetAllSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtEnterItem.setText(null);
				jlblConfirm.setText("");
				fill.clear();
				jlstAddItems.setModel(fill);
			}
		});
		btnResetAllSystem.setFont(new Font("Tahoma", Font.BOLD, 46));
		btnResetAllSystem.setBounds(896, 435, 426, 94);
		contentPane.add(btnResetAllSystem);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Inventory Register",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			} 
		});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 46));
		btnExit.setBounds(1007, 540, 315, 94);
		contentPane.add(btnExit);
		
		jtxtEnterItem = new JTextField();
		jtxtEnterItem.setFont(new Font("Tahoma", Font.BOLD, 30));
		jtxtEnterItem.setBounds(363, 120, 523, 63);
		contentPane.add(jtxtEnterItem);
		jtxtEnterItem.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 194, 864, 335);
		contentPane.add(scrollPane);
		
		jlstAddItems = new JList();
		scrollPane.setViewportView(jlstAddItems);
		jlstAddItems.setModel(fill);
		jlstAddItems.setFont(new Font("Tahoma", Font.PLAIN, 46));
		
	}
}
