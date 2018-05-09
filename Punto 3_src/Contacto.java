import javax.swing.JOptionPane;




public class Contacto {
    private String nombre;
    private String apellidoPaterno;
    private String telefono;
    private String mail;
    

    public Contacto(String nombre, String apellidoPaterno,  String telefono, String mail) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.telefono = telefono;
        this.mail = mail;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setmail(String mail) {
        this.mail = mail;
    }

    

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String gettelefono() {
        return telefono;
    }

    public String getmail() {
        return mail;
    }

    
    
    @Override
    public String toString() {
        String aux="";
        aux += "Nombre: " + nombre + " " +
                apellidoPaterno + " " + telefono + " "+
                mail ;
        return aux;
    }
    
     @Override
    public boolean equals(Object O){
    	
    	
        Contacto a = (Contacto) O;
        
        return (this.nombre.equals(a.nombre) && 
                this.apellidoPaterno.equals(a.apellidoPaterno) &&
                this.telefono.equals(a.telefono)) && 
                this.mail.equals(a.mail); 
    }
    
 
}
