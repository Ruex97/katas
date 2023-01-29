package lambdas;

public class Car {
	
	private String marca;
	private String modelo;
	private int cilindrada;
	private int potencia;
		
		public Car(String marca, String modelo, int cilindrada, int potencia) {
			this.marca = marca;
			this.modelo = modelo;
			this.cilindrada = cilindrada;
			this.potencia = potencia;
		}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
		
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
		
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", potencia=" + potencia
				+ "]";
	}
}


