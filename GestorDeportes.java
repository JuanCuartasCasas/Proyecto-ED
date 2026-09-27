public class GestorDeportes {
    DLL<Deporte> deportesOfertados;
    DLL<Estudiante> estudiantesUniversidad;

    public GestorDeportes(DLL<Estudiante> estudiantesTotales){
        this.deportesOfertados = new DLL<Deporte>();
        this.estudiantesUniversidad = estudiantesTotales;
    }

    public void solicitarInscripcion(Estudiante estudiante, Deporte deporte){
        comprobarExistenciaEstudiante(estudiante);

        DLLNode<Deporte> deporteR = comprobarExistenciaDeporte(deporte);

        Deporte deporteData = deporteR.data;

        if (deporteData.getCuposDisponibles() > 0){
            deporteData.getListaInscritos().pushBack(estudiante);
            deporteData.setCuposDisponibles(deporteData.getCuposDisponibles()-1);
            estudiante.getDeportesInscritos().pushBack(deporteData);
        } else {
            deporteData.getColaEsperaInscripcion().enqueue(estudiante);
            System.out.println("Los cupos se encuentran llenos. Lo hemos puesto en cola de espera del deporte.");
        }
    }

    public void cancelarCupo (Estudiante estudiante, Deporte deporte){
        comprobarExistenciaEstudiante(estudiante);
        DLLNode<Deporte> deporteR = comprobarExistenciaDeporte(deporte);

        Deporte deporteData = deporteR.data;

        DLLNode<Deporte> nodoDeporteEnEstudiante = estudiante.getDeportesInscritos().find(deporteData);

        if (nodoDeporteEnEstudiante != null){
            estudiante.getDeportesInscritos().deleteNode(nodoDeporteEnEstudiante);;

            DLLNode<Estudiante> nodoEstudianteEnDeporte = deporteData.getListaInscritos().find(estudiante);
            if (nodoEstudianteEnDeporte != null){
                deporteData.getListaInscritos().deleteNode(nodoEstudianteEnDeporte);
            }
            deporteData.setCuposDisponibles(deporteData.getCuposDisponibles()+1);
            System.out.println("Cancelación exitosa del deporte " + deporteData.getNombreCurso() + " para el estudiante " + estudiante.getNombre());
        } else {
            System.out.println("El estudiante no se encuentra inscrito en el deporte " + deporteData.getNombreCurso());
        }
    }

    public void procesarSiguienteSolicitud(Deporte deporte){

    }

    public void reportesYConsultas(){

    }

    public void comprobarExistenciaEstudiante(Estudiante estudiante){
        DLLNode<Estudiante> nodoEstudiante = estudiantesUniversidad.find(estudiante);

        if (nodoEstudiante == null) {
            System.out.println("El estudiante no se encuentra matriculado en la universidad.");
            return;
        }
    }

    public DLLNode<Deporte> comprobarExistenciaDeporte(Deporte deporte){
        DLLNode<Deporte> nodoDeporte = deportesOfertados.find(deporte);

        if (nodoDeporte == null){
            System.out.println("El deporte no se encuentra ofertado, lo sentimos.");
            return null;
        }
        return nodoDeporte;
    }
}
