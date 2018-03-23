/**
 * 
 */
package main.start;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @description:
 * @author: Admin
 * @time: 11:12:16 AM
 * @date: Mar 19, 2018
 */
public class PersonUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idField = new JTextField(10);
	private JTextField fNameField = new JTextField(30);
	private JTextField mNameField = new JTextField();
	private JTextField lNameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField phoneField = new JTextField();

	private JButton createButton = new JButton("New");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	private JButton firstButton = new JButton("First");
	private JButton prevButton = new JButton("Previous");
	private JButton nextButton = new JButton("Next");
	private JButton lastButton = new JButton("Last");

	private PersonBean bean = new PersonBean();
	private JTable tablePerson;
	TableModel tableModel;

	public PersonUI() {
		setBorder(new TitledBorder(new EtchedBorder(), "Person Details"));
		// setLayout(null);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(initFields());
		add(initButtons());
		add(new JScrollPane(initTablePerson()));

		//
		setFieldData(bean.moveFirst());
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 */
	private JPanel initButtons() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 10, 0));
		createButton.setBounds(91, 308, 71, 21);
		createButton.addActionListener(new ButtonHandler());
		panel.add(createButton);

		updateButton.setBounds(172, 308, 114, 21);
		updateButton.addActionListener(new ButtonHandler());
		panel.add(updateButton, "wrap");
		deleteButton.addActionListener(new ButtonHandler());

		deleteButton.setBounds(298, 308, 114, 21);
		panel.add(deleteButton, "wrap");

		firstButton.setBounds(422, 308, 100, 21);
		firstButton.addActionListener(new ButtonHandler());
		panel.add(firstButton, "wrap");

		prevButton.setBounds(537, 308, 100, 21);
		prevButton.addActionListener(new ButtonHandler());
		panel.add(prevButton, "wrap");

		nextButton.setBounds(647, 308, 92, 21);
		nextButton.addActionListener(new ButtonHandler());
		panel.add(nextButton, "wrap");

		lastButton.addActionListener(new ButtonHandler());
		lastButton.setBounds(749, 308, 101, 21);
		panel.add(lastButton, "wrap");

		return panel;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 */
	private JTable initTablePerson() {

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("personId");
		columns.add("firstName");
		columns.add("middleName");
		columns.add("lastName");
		columns.add("email");
		columns.add("phone");

		for (int i = 0; i < bean.getListPerson().size(); i++) {
			String id = String.valueOf(bean.getListPerson().get(i).getPersonId());
			String firstName = bean.getListPerson().get(i).getFirstName();
			String middleName = bean.getListPerson().get(i).getMiddleName();
			String lastName = bean.getListPerson().get(i).getLastName();
			String email = bean.getListPerson().get(i).getEmail();
			String phone = bean.getListPerson().get(i).getPhone();

			values.add(new String[] { id, firstName, middleName, lastName, email, phone });
		}

		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

		tablePerson = new JTable(tableModel);
		tablePerson.setBounds(6, 360, 844, 321);
		JScrollPane scrollPane = new JScrollPane(tablePerson);
		tablePerson.setFillsViewportHeight(true);
		return tablePerson;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 */
	private JPanel initFields() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(400, 300));
		panel.setBorder(new EmptyBorder(10, 0, 30, 0));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2, 0, 0));
		panel1.setBorder(new EmptyBorder(10, 0, 10, 0));

		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel1.add(label, "wrap");
		idField.setBounds(386, 5, 86, 19);
		panel1.add(idField);
		idField.setEnabled(false);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 2, 0, 0));
		panel2.setBorder(new EmptyBorder(10, 0, 10, 0));
		JLabel label_1 = new JLabel("First Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label_1, "align label");
		panel2.add(fNameField, "wrap");

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(0, 2, 0, 0));
		panel3.setBorder(new EmptyBorder(10, 0, 10, 0));
		JLabel label_2 = new JLabel("Midle Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(label_2, "align label");
		panel3.add(mNameField, "wrap");

		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(0, 2, 0, 0));
		panel4.setBorder(new EmptyBorder(10, 0, 10, 0));
		JLabel label_3 = new JLabel("Last Name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(label_3, "align label");
		panel4.add(lNameField, "wrap");

		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(0, 2, 0, 0));
		panel5.setBorder(new EmptyBorder(10, 0, 10, 0));
		JLabel label_4 = new JLabel("Email");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(label_4, "align label");
		panel5.add(emailField, "wrap");

		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(0, 2, 0, 0));
		panel6.setBorder(new EmptyBorder(10, 0, 10, 0));
		JLabel label_5 = new JLabel("Phone");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel6.add(label_5, "align label");
		panel6.add(phoneField, "wrap");

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		return panel;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 */
	private Person getFieldData() {
		Person p = new Person();
		p.setPersonId(Integer.parseInt(idField.getText()));
		p.setFirstName(fNameField.getText());
		p.setMiddleName(mNameField.getText());
		p.setLastName(lNameField.getText());
		p.setEmail(emailField.getText());
		p.setPhone(phoneField.getText());
		return p;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param p
	 */
	private void setFieldData(Person p) {
		idField.setText(String.valueOf(p.getPersonId()));
		fNameField.setText(p.getFirstName());
		mNameField.setText(p.getMiddleName());
		lNameField.setText(p.getLastName());
		emailField.setText(p.getEmail());
		phoneField.setText(p.getPhone());
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 */
	private boolean isEmptyFieldData() {
		return (fNameField.getText().trim().isEmpty() && mNameField.getText().trim().isEmpty()
				&& lNameField.getText().trim().isEmpty() && emailField.getText().trim().isEmpty()
				&& phoneField.getText().trim().isEmpty());
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Person p = getFieldData();

			switch (e.getActionCommand()) {
			case "Save":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot create an empty record");
					return;
				}
				if (bean.create(p) != null) {

					refreshData();
					JOptionPane.showMessageDialog(null, "New person created successfully.");
				}

				createButton.setText("New");
				break;
			case "New":
				p.setPersonId(new Random().nextInt(Integer.MAX_VALUE) + 1);
				p.setFirstName("");
				p.setMiddleName("");
				p.setLastName("");
				p.setEmail("");
				p.setPhone("");
				setFieldData(p);
				createButton.setText("Save");
				break;
			case "Update":

				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot update an empty record");
					return;
				}
				// p = getFieldData();

				if (bean.update(p) != null) {

					refreshData();
					JOptionPane.showMessageDialog(null,
							"Person with ID:" + String.valueOf(p.getPersonId() + " is updated successfully"));
				}

				break;
			case "Delete":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot delete an empty record");
					return;
				}
				bean.delete();
				refreshData();
				JOptionPane.showMessageDialog(null,
						"Person with ID:" + String.valueOf(p.getPersonId() + " is deleted successfully"));
				break;
			case "First":
				setFieldData(bean.moveFirst());
				break;
			case "Previous":
				setFieldData(bean.movePrevious());
				break;
			case "Next":
				setFieldData(bean.moveNext());
				break;
			case "Last":
				setFieldData(bean.moveLast());
				break;
			default:
				JOptionPane.showMessageDialog(null, "invalid command");
			}

		}
	}

	private void refreshData() {
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("personId");
		columns.add("firstName");
		columns.add("middleName");
		columns.add("lastName");
		columns.add("email");
		columns.add("phone");

		for (int i = 0; i < bean.getListPerson().size(); i++) {
			String id = String.valueOf(bean.getListPerson().get(i).getPersonId());
			String firstName = bean.getListPerson().get(i).getFirstName();
			String middleName = bean.getListPerson().get(i).getMiddleName();
			String lastName = bean.getListPerson().get(i).getLastName();
			String email = bean.getListPerson().get(i).getEmail();
			String phone = bean.getListPerson().get(i).getPhone();

			values.add(new String[] { id, firstName, middleName, lastName, email, phone });
		}

		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		tablePerson.setModel(tableModel);

	}
}
