package medicaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EnfermedadController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Enfermedad.list(params), model:[enfermedadInstanceCount: Enfermedad.count()]
    }

    def show(Enfermedad enfermedadInstance) {
        respond enfermedadInstance
    }

    def create() {
        respond new Enfermedad(params)
    }

    @Transactional
    def save(Enfermedad enfermedadInstance) {
        if (enfermedadInstance == null) {
            notFound()
            return
        }

        if (enfermedadInstance.hasErrors()) {
            respond enfermedadInstance.errors, view:'create'
            return
        }

        enfermedadInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'enfermedadInstance.label', default: 'Enfermedad'), enfermedadInstance.id])
                redirect enfermedadInstance
            }
            '*' { respond enfermedadInstance, [status: CREATED] }
        }
    }

    def edit(Enfermedad enfermedadInstance) {
        respond enfermedadInstance
    }

    @Transactional
    def update(Enfermedad enfermedadInstance) {
        if (enfermedadInstance == null) {
            notFound()
            return
        }

        if (enfermedadInstance.hasErrors()) {
            respond enfermedadInstance.errors, view:'edit'
            return
        }

        enfermedadInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Enfermedad.label', default: 'Enfermedad'), enfermedadInstance.id])
                redirect enfermedadInstance
            }
            '*'{ respond enfermedadInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Enfermedad enfermedadInstance) {

        if (enfermedadInstance == null) {
            notFound()
            return
        }

        enfermedadInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Enfermedad.label', default: 'Enfermedad'), enfermedadInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'enfermedadInstance.label', default: 'Enfermedad'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
