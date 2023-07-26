package com.conversor.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica frame = new InterfazGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public InterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(216, 5, 1, 1);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONVERSOR");
		lblNewLabel.setForeground(new Color(85, 85, 85));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(157, 37, 127, 24);
		panel_1.add(lblNewLabel);
		
		JButton btnMonedas = new JButton("Monedas");
		btnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversor moneda = new Conversor();
				moneda.setVisible(true);
				moneda.setLocationRelativeTo(null);
							
			}
		});
		btnMonedas.setBounds(28, 87, 156, 100);
		panel_1.add(btnMonedas);
		
		JButton btnTemperatura = new JButton("Temperatura");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorTemperatura temperatura = new ConversorTemperatura();
				temperatura.setVisible(true);
				temperatura.setLocationRelativeTo(null);
			}
		});
		btnTemperatura.setBounds(241, 87, 161, 100);
		panel_1.add(btnTemperatura);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(InterfazGrafica.class.getResource("/com/conversor/imagenes/blue-dark.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		panel_1.add(lblNewLabel_1);
		
	}
}
