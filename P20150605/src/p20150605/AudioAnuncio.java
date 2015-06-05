package p20150605;
import java.util.Date;
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

public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * El constructor de la clase
     */    
    public AudioAnuncio ()
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
        

    protected int CheckDatos() {
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
        return resultado;
    }
     /**
     * Método que <b>exporta la cuña completa al formato DAW</b>. También comprueba que el spot 
     * contiene toda la información necesaria.
     * @param lasterrormsg 
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = CheckDatos();
        
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
