package medicaltool

class Paciente {

    String nombre
    String apellidoPaterno
    String apellidoMaterno



    static hasMany = [ direcciones: Direccion, telefonos: Telefono, correos:CorreoElectronico, fotos:FotoPerfil]
    static constraints = {
    }
}
