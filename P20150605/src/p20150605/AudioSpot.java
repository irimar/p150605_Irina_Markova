package p20150605;
/**
 * Clase destinada a la <b>gestión de las cuñas de anuncios publicitarios en radio</b>.
 * 
 * Cada objeto de esta clase es una cuña diferente capaz de almacenar metadatos sobre el anuncio 
 * y una referencia al archivo de audio que lo contiene.
 * 
 * @author Irina Markova
 * @version 0.0.1
 * @see P20150605
 * 
 */
import java.io.File;

public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public String lasterrormsg;
    
    /**
     * El constructor de la clase
     */    
    public AudioSpot ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
        
    /**
     * Método para <b>establecer metadatos del spot</b>.
     * @param producto establece el nombre del producto
     * @param anunciante establece el nombre del enunciante
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
        
    /**
     * Método para <b>establecer la duración del spot</b>.
     * @param duracion que establece la duración mínima y máxima
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
        
    /**
     * Método para <b>establecer el nombre del archivo</b> y comprobar si existe.
     * @param nombre_archivo
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
        
    /**
     * Método que <b>programa la cola de reproducción</b>. También comprueba que el spot 
     * contiene toda la información necesaria.
     * @param lasterrormsg es una propiedad pública que contiene la descripción del error
     * relacionado con el código negativo devuelto
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }     
        }
        else
            return resultado;
    }
     /**
     * Método que <b>exporta la cuña completa al formato DAW</b>. También comprueba que el spot 
     * contiene toda la información necesaria.
     * @param lasterrormsg 
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
