/**
 * 
 */
package main.start;

import javax.swing.JFrame;

/**
 * @description:
 * @author: Admin
 * @time: 5:52:39 PM
 * @date: Mar 19, 2018
 */
public class AppMain {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.getContentPane().setLayout();
		f.getContentPane().add(new PersonUI());
		//f.setSize(1200, 580);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setVisible(true);
	}
}
