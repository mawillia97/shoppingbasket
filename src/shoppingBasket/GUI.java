package shoppingBasket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;


public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField totalField;
	private JTextField noProductField;
	private JTextField noItemsField;
	private JTextField productNameField;
	private JTextField latestPriceField;

	private final static ShoppingBasket sb = new ShoppingBasket();
	private final static JTextArea basketField = new JTextArea();
	
	private static final String DEFAULT_TOTAL_PRICE = ("0");
	private static final String DEFAULT_NO_ITEMS = ("0");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		final JPanel removePane = new JPanel();
		removePane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setTitle("QA Shopping Basket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdd = new JButton("Add");

		btnAdd.setBounds(324, 28, 100, 23);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(324, 104, 100, 23);
		contentPane.add(btnRemove);

		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {			
				sb.removeAllItem(getName());
			}
		});

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(324, 138, 100, 23);
		contentPane.add(btnEdit);

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {			
				
			}
		});

		JButton btnClearBasket = new JButton("Clear Basket");
		btnClearBasket.setBounds(324, 172, 100, 23);
		contentPane.add(btnClearBasket);

		btnClearBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {			
				sb.clearList();
				basketField.setText("");
				
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {			
				System.exit(0);
			}
		});

		final JDialog removeFrame = new JDialog();

		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {	

				removeFrame.getContentPane().add(removePane);
				removeFrame.setBounds(200, 200, 150, 200);
				removeFrame.setVisible(true);
			}
		});

		btnExit.setBounds(324, 257, 100, 23);
		contentPane.add(btnExit);

		JLabel lblNoItems = new JLabel("No. Items");
		lblNoItems.setBounds(24, 261, 56, 14);
		contentPane.add(lblNoItems);

		JLabel lblTotalPro = new JLabel("No. Product");
		lblTotalPro.setBounds(210, 261, 56, 14);
		contentPane.add(lblTotalPro);

		noProductField = new JTextField();
		noProductField.setBounds(260, 258, 30, 20);
		contentPane.add(noProductField);
		noProductField.setColumns(3);
		noProductField.setText(DEFAULT_TOTAL_PRICE);
		noProductField.setEditable(false);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(110, 261, 56, 14);
		contentPane.add(lblTotal);

		totalField = new JTextField();
		totalField.setBounds(140, 258, 60, 20);
		contentPane.add(totalField);
		totalField.setColumns(2);
		totalField.setText(DEFAULT_TOTAL_PRICE);
		totalField.setEditable(false);
		noItemsField = new JTextField();
		noItemsField.setBounds(78, 258, 30, 20);
		contentPane.add(noItemsField);
		noItemsField.setColumns(10);
		noItemsField.setText(DEFAULT_NO_ITEMS);
		noItemsField.setEditable(false);

		basketField.setBounds(10, 76, 304, 174);
		contentPane.add(basketField);
		basketField.setEditable(false);

		JLabel lblBasket = new JLabel("Basket");
		lblBasket.setBounds(10, 60, 46, 14);
		contentPane.add(lblBasket);

		productNameField = new JTextField();
		productNameField.setBounds(10, 29, 86, 20);
		contentPane.add(productNameField);
		productNameField.setColumns(10);

		latestPriceField = new JTextField();
		latestPriceField.setColumns(10);
		latestPriceField.setBounds(219, 29, 86, 20);
		contentPane.add(latestPriceField);

		final JSpinner quantitySpinner = new JSpinner();
		quantitySpinner.setBounds(123, 29, 86, 20);
		contentPane.add(quantitySpinner);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {			
				sb.addItem(productNameField.getText(), Double.parseDouble(latestPriceField.getText()),(Integer) quantitySpinner.getValue());
				basketField.append(sb.showBasket());
			}
		});

		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(10, 11, 70, 14);
		contentPane.add(lblProductName);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(123, 11, 70, 14);
		contentPane.add(lblQuantity);

		JLabel lblLatestPrice = new JLabel("Latest Price");
		lblLatestPrice.setBounds(219, 11, 70, 14);
		contentPane.add(lblLatestPrice);	
	}
}