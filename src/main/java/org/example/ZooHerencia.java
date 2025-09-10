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