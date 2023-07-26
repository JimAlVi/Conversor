package com.conversor.interfaz;

public class ConvertirTemperatura {
	
	public double ConvertirCelsiusAFahrenheit (double valor) {
		double CelsiusAFahrenheit = (valor*9/5)+32;
		return CelsiusAFahrenheit;
	}
	
	public double ConvertirFahrenheitACelsius (double valor) {
		double FahrenheitACelsius= (valor-32)*5/9;
		return FahrenheitACelsius;
	}

}
