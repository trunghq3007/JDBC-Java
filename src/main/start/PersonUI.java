/**
 * 
 */
package main.start;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @description:
 * @author: Admin
 * @time: 11:12:16 AM
 * @date: Mar 19, 2018
 */
public class PersonUI extends JPanel {
	private JTextField idField = new JTextField(10);
	private JTextField fNameField = new JTextField(30);
	private JTextField mNameField = new JTextField();
	private JTextField lNameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField phoneField = new JTextField();

	private JButton createButton = new JButton("New");
	private JButton updateButton = new JButton("updateButton");
	private JButton deleteButton = new JButton("deleteButton");
	private JButton firstButton = new JButton("firstButton");
	private JButton prevButton = new JButton("prevButton");
	private JButton nextButton = new JButton("nextButton");
	private JButton lastButton = new JButton("lastButton");

	private PersonBean bean = new PersonBean();
	private JTable table_1;

	public PersonUI() {
		setBorder(new TitledBorder(new EtchedBorder(), "Person Details"));
		setLayout(null);
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(initFields());
		add(initButtons());

		//
		setFieldData(bean.moveFirst());
	}

	private JPanel initButtons() {
		JPanel panel = new JPanel();
		panel.setBounds(312, 274, 63, 21);
		// panel.setLayout(null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		createButton.setBounds(91, 308, 71, 21);
		createButton.addActionListener(new ButtonHandler());
		add(createButton);

		updateButton.setBounds(172, 308, 114, 21);
		add(updateButton, "wrap");

		deleteButton.setBounds(298, 308, 114, 21);
		add(deleteButton, "wrap");

		firstButton.setBounds(422, 308, 100, 21);
		add(firstButton, "wrap");

		prevButton.setBounds(537, 308, 100, 21);
		add(prevButton, "wrap");

		nextButton.setBounds(647, 308, 92, 21);
		add(nextButton, "wrap");

		lastButton.setBounds(749, 308, 101, 21);
		add(lastButton, "wrap");

		/*
		 * private int personId; private String firstName; private String middleName;
		 * private String lastName; private String email; private String phone;
		 */

		String[] titles = new String[] { "personId", "firstName", "middleName", "lastName", "email", "phone" };
		Object[][] objects = new Object[][] {

				{ 1, "JSP & Servlet", "Tùng Dương", "a", "c", "d" }

		};
		/*
		 * String[] titles = new String[] { "STT", "Môn học", "Tác giả",
		 * "Tổng số bài viết" };
		 * 
		 * Object[][] objects = new Object[][] { { 1, "JSP & Servlet", "Tùng Dương", 22
		 * }, { 2, "Spring Framework", "Tùng Dương", 15 }, { 3, "Struts Framework",
		 * "Công Minh", 7 } };
		 */
		table_1 = new JTable(objects, titles);
		table_1.setBounds(6, 360, 844, 321);
		add(table_1);

		// ...
		// panel.add(lastButton);
		// lastButton.addActionListener(new ButtonHandler());
		return panel;
	}

	private JPanel initFields() {
		JPanel panel = new JPanel();
		panel.setBounds(6, 15, 844, 259);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel label = new JLabel("ID");
		label.setBounds(371, 8, 10, 13);
		panel1.add(label, "wrap");
		idField.setBounds(386, 5, 86, 19);
		panel1.add(idField);
		idField.setEnabled(false);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 2, 0, 0));
		panel2.add(new JLabel("First Name"), "align label");
		panel2.add(fNameField, "wrap");

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(0, 2, 0, 0));
		panel3.add(new JLabel("Midle Name"), "align label");
		panel3.add(mNameField, "wrap");

		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(0, 2, 0, 0));
		panel4.add(new JLabel("Last Name"), "align label");
		panel4.add(lNameField, "wrap");

		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(0, 2, 0, 0));
		panel5.add(new JLabel("Email"), "align label");
		panel5.add(emailField, "wrap");

		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(0, 2, 0, 0));
		panel6.add(new JLabel("Phone"), "align label");
		panel6.add(phoneField, "wrap");

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		return panel;
	}

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

	private void setFieldData(Person p) {
		idField.setText(String.valueOf(p.getPersonId()));
		fNameField.setText(p.getFirstName());
		mNameField.setText(p.getMiddleName());
		lNameField.setText(p.getLastName());
		emailField.setText(p.getEmail());
		phoneField.setText(p.getPhone());
	}

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
				if (bean.create(p) != null)
					JOptionPane.showMessageDialog(null, "New person created successfully.");
				createButton.setText("New...");
				break;
			case "New...":
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
				if (bean.update(p) != null)
					JOptionPane.showMessageDialog(null,
							"Person with ID:" + String.valueOf(p.getPersonId() + " is updated successfully"));
				break;
			case "Delete":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot delete an empty record");
					return;
				}
				p = bean.getCurrent();
				bean.delete();
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
}
