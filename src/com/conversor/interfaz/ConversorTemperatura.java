package com.conversor.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ConversorTemperatura extends JFrame{
	
		private JPanel contentPane;
	    private JTextField digitoConversor;
	    private JTextField resultado;
	    private JComboBox<String> comboBox;
	    private JComboBox<String> comboBox_1;

	    public ConversorTemperatura() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 450, 300);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 434, 261);
	        contentPane.add(panel);
	        panel.setLayout(null);

	        comboBox = new JComboBox<>();
	        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Celsius","Farenheit"}));
	        comboBox.setBounds(238, 80, 139, 22);
	        panel.add(comboBox);

	        comboBox_1 = new JComboBox<>();
	        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"Farenheit","Celsius"}));
	        comboBox_1.setBounds(238, 160, 139, 22);
	        panel.add(comboBox_1);

	        digitoConversor = new JTextField();
	        digitoConversor.setBounds(53, 77, 155, 29);
	        panel.add(digitoConversor);
	        digitoConversor.setColumns(10);
	        digitoConversor.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                actualizarResultado();
	            }

	            public void removeUpdate(DocumentEvent e) {
	                actualizarResultado();
	            }

	            public void changedUpdate(DocumentEvent e) {
	                actualizarResultado();
	            }
	        });

	        resultado = new JTextField();
	        resultado.setColumns(10);
	        resultado.setBounds(53, 157, 155, 29);
	        panel.add(resultado);

	        JLabel lblNewLabel = new JLabel("TEMPERATURA");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(150, 24, 150, 29);
	        panel.add(lblNewLabel);

	        JButton btnRegresar = new JButton("REGRESAR");
	        btnRegresar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
	        btnRegresar.setBounds(175, 209, 106, 29);
	        panel.add(btnRegresar);

	        // Agregar ItemListener a los JComboBox para detectar cambios en la selección
	        comboBox.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	                actualizarResultado();
	            }
	        });

	        comboBox_1.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	                actualizarResultado();
	            }
	        });
	    }

	    private void actualizarResultado() {
	        String textoIngresado = digitoConversor.getText();
	        double valor = 0.0;

	        try {
	            valor = Double.parseDouble(textoIngresado);
	        } catch (NumberFormatException ex) {
	            // Si el valor ingresado no es un número válido, se establece el resultado como vacío
	            resultado.setText("");
	            return;
	        }

	        String seleccionComboBox = comboBox.getSelectedItem().toString();
	        String seleccionComboBox1 = comboBox_1.getSelectedItem().toString();

	        ConvertirTemperatura temperatura = new ConvertirTemperatura();
	        double resultadoConvertido = 0.0;

	        
	        
	        if (seleccionComboBox.equals("Celsius") && seleccionComboBox1.equals("Farenheit")) {
	            resultadoConvertido = temperatura.ConvertirCelsiusAFahrenheit(valor);
	        } else if (seleccionComboBox.equals("Farenheit") && seleccionComboBox1.equals("Celsius")) {
	            resultadoConvertido = temperatura.ConvertirFahrenheitACelsius(valor);
	        }

	        resultado.setText(String.valueOf(resultadoConvertido));
	    
	}
}


