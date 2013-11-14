package medicaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoDireccionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoDireccion.list(params), model: [tipoDireccionInstanceCount: TipoDireccion.count()]
    }

    def show(TipoDireccion tipoDireccionInstance) {
        respond tipoDireccionInstance
    }

    def create() {
        respond new TipoDireccion(params)
    }

    @Transactional
    def save(TipoDireccion tipoDireccionInstance) {
        if (tipoDireccionInstance == null) {
            notFound()
            return
        }

        if (tipoDireccionInstance.hasErrors()) {
            respond tipoDireccionInstance.errors, view: 'create'
            return
        }

        tipoDireccionInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDireccionInstance.label', default: 'TipoDireccion'), tipoDireccionInstance.id])
                redirect tipoDireccionInstance
            }
            '*' { respond tipoDireccionInstance, [status: CREATED] }
        }
    }

    def edit(TipoDireccion tipoDireccionInstance) {
        respond tipoDireccionInstance
    }

    @Transactional
    def update(TipoDireccion tipoDireccionInstance) {
        if (tipoDireccionInstance == null) {
            notFound()
            return
        }

        if (tipoDireccionInstance.hasErrors()) {
            respond tipoDireccionInstance.errors, view: 'edit'
            return
        }

        tipoDireccionInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoDireccion.label', default: 'TipoDireccion'), tipoDireccionInstance.id])
                redirect tipoDireccionInstance
            }
            '*' { respond tipoDireccionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoDireccion tipoDireccionInstance) {

        if (tipoDireccionInstance == null) {
            notFound()
            return
        }

        tipoDireccionInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoDireccion.label', default: 'TipoDireccion'), tipoDireccionInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoDireccionInstance.label', default: 'TipoDireccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
