import java.util.Random;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Bienvenido!");
		System.out.println("Ingrese su nombre por favor: ");
		String nombre=scan.nextLine();
		System.out.println("Ingrese su edad por favor: ");
		int edad=scan.nextInt();
		System.out.println("Ingrese su sexo por favor: ");
		char sexo=scan.next().charAt(0);
		System.out.println("Ingrese su peso en Kg por favor: ");
		int peso=scan.nextInt();
		System.out.println("Ingrese su altura en m. por favor: ");
		double altura=scan.nextDouble();
		
		Persona persona1=new Persona(nombre,edad,sexo,peso,altura,"Soltero");
		Persona persona2=new Persona(edad,sexo);
		persona2.setNombre(nombre);
		persona2.setPeso(180);
		persona2.setAltura(1.70);
		Persona persona3=new Persona();
		persona3.setEdad(14);
		persona3.setSexo('F');
		persona3.setPeso(81.0);//kg
		persona3.setAltura(1.72);
		persona3.setEstado("Casada");
	
		System.out.println(persona1.toString());
		System.out.println("Estado del peso: "+persona1.calcularIMC());
		System.out.println("¿Es mayor de edad?: "+(persona1.esMayorDeEdad()?"si\n":"no\n"));
		
		System.out.println(persona2.toString());
		System.out.println("Estado del peso: "+persona2.calcularIMC());
		System.out.println("¿Es mayor de edad?: "+(persona2.esMayorDeEdad()?"si\n":"no\n"));
		
		System.out.println(persona3.toString());
		System.out.println("Estado del peso: "+persona3.calcularIMC());
		System.out.println("¿Es mayor de edad?: "+(persona3.esMayorDeEdad()?"si\n":"no\n"));
		
	}
}
class Persona{
	//Atributos
	private String nombre;
	private int edad;
	private int CI;
	private char sexo;//H hombre M mujer
	private double peso;
	private double altura;
	private String estado;
	//Constantes
	private static final char M='M';
	private static final int PESO_BAJO=-1;	
	private static final int PESO_IDEAL=0;
	private static final int SOBREPESO=1;
					
	//Constructores
	public Persona() {
		nombre="";
		edad=0;
		CI=0;
		sexo=M; //por defecto masculino
		peso=0.0;
		altura=0.0;
		estado="";
		CI=generaCI();
	}
	public Persona(int edad, char sexo) {
		nombre="";
		this.edad=edad;
		CI=0;
		this.sexo=sexo;
		peso=0.0;
		altura=0.0;
		estado="";
		CI=generaCI();
	}
	public Persona(String nombre,int edad,char sexo,double peso,double altura,String estado) {
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.estado=estado;
		CI=generaCI();
	}
	public int calcularIMC() {
		double pesoActual=peso/Math.pow(altura, 2);
		if(pesoActual < 20)
			return PESO_BAJO;
		else if(pesoActual >= 20 && pesoActual <= 25)
			return PESO_IDEAL;
		else if(pesoActual > 25)
			return SOBREPESO;
		else return 99999;
	}
	public boolean esMayorDeEdad() {
		if(edad>=0 && edad<18)
			return false;
		return true;
	}
	private boolean comprobarSexo(char sexo) {
		if(this.sexo==sexo)
			return true;
		this.sexo=M;
		return false;
	}
	@Override
	public String toString() {
		String datos="Nombre: "+nombre
				+"\nEdad: "+edad
				+"\nCI: "+CI
				+"\nSexo: "+sexo
				+"\nPeso: "+peso
				+"\nAltura: "+altura
				+"\nEstado: "+estado+"";
		return datos;
	}
	private int generaCI() {
		int numero=0;
		String aux="";
		Random rand=new Random(System.nanoTime());
		for(int i=0;i<8;i++)
			aux+=rand.nextInt(9);
		numero=Integer.parseInt(aux);
		return numero;
	}
	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}