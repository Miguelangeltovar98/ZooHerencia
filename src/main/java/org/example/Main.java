class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void sonido() {
        System.out.println("El animal hace un sonido genérico...");
    }
}

class Perro extends Animal {
    private Collar collar;

    public Perro(String nombre, Collar collar) {
        super(nombre);
        this.collar = collar;
    }

    @Override
    public void sonido() {
        System.out.println(nombre + " (Perro): ¡Guau guau!");
    }

    public void mostrarCollar() {
        System.out.println("El collar de " + nombre + " es de color: " + collar.getColor());
    }
}

class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void sonido() {
        System.out.println(nombre + " (Gato): ¡Miau miau!");
    }
}

class Collar {
    private String color;

    public Collar(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Consultorio {
    private String ubicacion;

    public Consultorio(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}

class Veterinaria {
    private Consultorio consultorio;

    public Veterinaria(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public void atender(Animal a) {
        System.out.println("Atendiendo en consultorio: " + consultorio.getUbicacion());
        a.sonido();
    }
}

class Caja<T> {
    private T objeto;

    public void guardar(T objeto) {
        this.objeto = objeto;
    }

    public T obtener() {
        return objeto;
    }
}

public class ZooHerencia {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio("Calle 123");
        Veterinaria vet = new Veterinaria(consultorio);

        Perro perro = new Perro("Firu", new Collar("Rojo"));
        Gato gato = new Gato("Misu");

        vet.atender(perro);
        vet.atender(gato);

        Animal a = new Perro("Rocky", new Collar("Azul"));

        if (a instanceof Perro) {
            Perro p = (Perro) a;
            p.mostrarCollar();
        }

        Caja<Animal> caja = new Caja<>();
        caja.guardar(gato);
        Animal guardado = caja.obtener();
        vet.atender(guardado);
    }
}