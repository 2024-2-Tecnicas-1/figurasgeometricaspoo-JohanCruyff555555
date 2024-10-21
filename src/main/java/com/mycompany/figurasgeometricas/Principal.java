import java.util.Scanner;

abstract class FiguraGeometrica {
    protected String nombre;
    protected String color;

    public FiguraGeometrica(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public abstract double obtenerArea();
    public abstract double obtenerPerimetro();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(String nombre, String color, double radio) {
        super(nombre, color);
        this.radio = radio;
    }

    @Override
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double obtenerPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Rectangulo extends FiguraGeometrica {
    private double lado1;
    private double lado2;

    public Rectangulo(String nombre, String color, double lado1, double lado2) {
        super(nombre, color);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double obtenerArea() {
        return lado1 * lado2;
    }

    @Override
    public double obtenerPerimetro() {
        return 2 * (lado1 + lado2);
    }
}

class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(String nombre, String color, double base, double altura) {
        super(nombre, color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double obtenerArea() {
        return (base * altura) / 2;
    }

    @Override
    public double obtenerPerimetro() {
        return 3 * base; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la figura:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el color de la figura:");
        String color = scanner.nextLine();

        System.out.println("Ingrese el tipo de figura (1: Circulo, 2: Rectángulo, 3: Triángulo):");
        int tipoFigura = scanner.nextInt();
        FiguraGeometrica figura = null;

        switch (tipoFigura) {
            case 1:
                System.out.println("Ingrese el radio del círculo:");
                double radio = scanner.nextDouble();
                figura = new Circulo(nombre, color, radio);
                break;
            case 2:
                System.out.println("Ingrese el valor del lado 1 del rectángulo:");
                double lado1 = scanner.nextDouble();
                System.out.println("Ingrese el valor del lado 2 del rectángulo:");
                double lado2 = scanner.nextDouble();
                figura = new Rectangulo(nombre, color, lado1, lado2);
                break;
            case 3:
                System.out.println("Ingrese el valor de la base del triángulo:");
                double base = scanner.nextDouble();
                System.out.println("Ingrese el valor de la altura del triángulo:");
                double altura = scanner.nextDouble();
                figura = new Triangulo(nombre, color, base, altura);
                break;
            default:
                System.out.println("Tipo de figura no válido.");
                return;
        }

        System.out.printf("El área de la figura %s es: %.2f%n", figura.getNombre(), figura.obtenerArea());
        System.out.printf("El perímetro de la figura %s es: %.2f%n", figura.getNombre(), figura.obtenerPerimetro());
    }
}
    

