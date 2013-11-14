package medicaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoTelefonoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoTelefono.list(params), model:[tipoTelefonoInstanceCount: TipoTelefono.count()]
    }

    def show(TipoTelefono tipoTelefonoInstance) {
        respond tipoTelefonoInstance
    }

    def create() {
        respond new TipoTelefono(params)
    }

    @Transactional
    def save(TipoTelefono tipoTelefonoInstance) {
        if (tipoTelefonoInstance == null) {
            notFound()
            return
        }

        if (tipoTelefonoInstance.hasErrors()) {
            respond tipoTelefonoInstance.errors, view:'create'
            return
        }

        tipoTelefonoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoTelefonoInstance.label', default: 'TipoTelefono'), tipoTelefonoInstance.id])
                redirect tipoTelefonoInstance
            }
            '*' { respond tipoTelefonoInstance, [status: CREATED] }
        }
    }

    def edit(TipoTelefono tipoTelefonoInstance) {
        respond tipoTelefonoInstance
    }

    @Transactional
    def update(TipoTelefono tipoTelefonoInstance) {
        if (tipoTelefonoInstance == null) {
            notFound()
            return
        }

        if (tipoTelefonoInstance.hasErrors()) {
            respond tipoTelefonoInstance.errors, view:'edit'
            return
        }

        tipoTelefonoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoTelefono.label', default: 'TipoTelefono'), tipoTelefonoInstance.id])
                redirect tipoTelefonoInstance
            }
            '*'{ respond tipoTelefonoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoTelefono tipoTelefonoInstance) {

        if (tipoTelefonoInstance == null) {
            notFound()
            return
        }

        tipoTelefonoInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoTelefono.label', default: 'TipoTelefono'), tipoTelefonoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoTelefonoInstance.label', default: 'TipoTelefono'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
