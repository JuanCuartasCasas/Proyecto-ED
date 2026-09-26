public class Estudiante {
    final String nombre;
    private final int id;
    private int edad;
    private int numeroTelefono;
    private final String correo;
    private String facultad;
    private String carrera;
    private DLL<Deporte> deportesInscritos;
    private Queue<Deporte> solicitudesPendientes;

    public Estudiante(String nombre, int id, int edad, int numeroTelefono, String correo, String facultad, String carrera){
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.facultad = facultad;
        this.carrera = carrera;
        this.deportesInscritos = new DLL<Deporte>();
        this.solicitudesPendientes = new Queue<Deporte>();

    }
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public int getEdad() {
        return edad;
    }
    public int getNumeroTelefono() {
        return numeroTelefono;
    }
    public String getCorreo() {
        return correo;
    }
    public String getFacultad() {
        return facultad;
    }
    public String getCarrera() {
        return carrera;
    }
    
}
