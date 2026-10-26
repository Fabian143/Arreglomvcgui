package modelo;

import java.util.ArrayList;

public class Numeros {
	
	private static Boolean esarreglo=true;
	public static double numeros[] = {0,0,0,0,0,0,0,0,0,0};
    public static ArrayList<Double> numeros2 = new ArrayList<>();
    
    public void limpiar() {
        for(int i = 0; i < 10; i++) {
            numeros[i] = 0;
        }
        numeros2.clear();
        esarreglo = true;
    }
	
	public void añadirElementoArreglo(int i,double numero) {
		setEsarreglo(true);
		numeros[i]=numero;
	}
	
	public void añadirElementoArray(double numero) {
		setEsarreglo(false);
		numeros2.add(numero);
	}
	
	public void eliminarInfoArreglo(int i) {
		setEsarreglo(true);
		numeros[i]=0;
	}
	
	public void eliminarInfoArray(int i) {
		setEsarreglo(false);
		numeros2.remove(i);
	}
	
	public void aleatorioArreglo(int i) {
		setEsarreglo(true);
		añadirElementoArreglo(i,(Math.random()*100));
	}
	
	public void aleatorioArray() {
		setEsarreglo(false);
		añadirElementoArray(Math.random()*100);
	}
	
	public double sumatoriaArreglo() {
		setEsarreglo(true);
		double numero=0;
		for (int i=0;i<10;i++) {
			numero += numeros[i];
		}
		return numero;
	}
	
	public double sumatoriaArray() {
		setEsarreglo(false);
		double numero=0;
		for(Double number:numeros2) {
			numero+=number;
		}
		return numero;
	}
	
	public Boolean getEsarreglo() {
		return esarreglo;
	}

	public void setEsarreglo(Boolean esarreglo) {
		Numeros.esarreglo = esarreglo;
	}
	
	 
}
