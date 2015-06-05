/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class AudioPista {
    protected static final int valor_max = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public AudioPista() {
    }

    /**
     * Método para <b>establecer metadatos del spot</b>.
     * @param producto establece el nombre del producto
     * @param anunciante establece el nombre del enunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Método para <b>establecer la duración del spot</b>.
     * @param duracion que establece la duración mínima y máxima
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > valor_max) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Método para <b>establecer el nombre del archivo</b> y comprobar si existe.
     * @param nombre_archivo
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * Método que <b>programa la cola de reproducción</b>. También comprueba que el spot
     * contiene toda la información necesaria.
     * @param lasterrormsg es una propiedad pública que contiene la descripción del error
     * relacionado con el código negativo devuelto
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date fecha) {
        int resultado = CheckDatos();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int CheckDatos();

    /**
     * Método que <b>exporta la cuña completa al formato DAW</b>. También comprueba que el spot
     * contiene toda la información necesaria.
     * @param lasterrormsg
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
