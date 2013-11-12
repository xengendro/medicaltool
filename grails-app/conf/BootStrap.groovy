import medicaltool.EstatusConsulta
import medicaltool.TipoCorreoElectronico
import medicaltool.TipoDireccion
import medicaltool.TipoTelefono

class BootStrap {

    def init = { servletContext ->
        loadTipoDireccion()
        loadTipoTelefono()
        loadTiposEmail()
        loadEstatusConsulta()
    }

    def loadTipoDireccion()  {
        (new TipoDireccion(nombre: 'CASA')).save(failOnError: true)
        (new TipoDireccion(nombre: 'TRABAJO')).save(failOnError: true)
        (new TipoDireccion(nombre: 'FISCAL')).save(failOnError: true)
        (new TipoDireccion(nombre: 'OTRO')).save(failOnError: true)

    }

    def loadTipoTelefono(){
        ( new TipoTelefono( nombre: 'CASA')).save(failOnError: true)
        ( new TipoTelefono( nombre: 'MOVIL')).save(failOnError: true)
        ( new TipoTelefono( nombre: 'TRABAJO')).save(failOnError: true)
        ( new TipoTelefono( nombre: 'PRINCIPAL')).save(failOnError: true)
        ( new TipoTelefono( nombre: 'OTRO')).save(failOnError: true)
    }

    def loadTiposEmail(){
        (new TipoCorreoElectronico(nombre: 'PERSONAL')).save(failOnError: true)
        (new TipoCorreoElectronico(nombre: 'TRABAJO')).save(failOnError: true)
        (new TipoCorreoElectronico(nombre: 'OTRO')).save(failOnError: true)
    }

    def loadEstatusConsulta(){
        ( new EstatusConsulta(nombre: 'EN_ESPERA')).save(failOnError: true)
        ( new EstatusConsulta(nombre: 'EN_SESION')).save(failOnError: true)
        ( new EstatusConsulta(nombre: 'TERMINADA')).save(failOnError: true)
        ( new EstatusConsulta(nombre: 'CONFIRMADA')).save(failOnError: true)
        ( new EstatusConsulta(nombre: 'NO_CONFIRMADA')).save(failOnError: true)


    }

    def destroy = {
    }
}
