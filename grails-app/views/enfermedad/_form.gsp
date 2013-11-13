<%@ page import="medicaltool.Enfermedad" %>



<div class="fieldcontain ${hasErrors(bean: enfermedadInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="enfermedad.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${enfermedadInstance?.nombre}"/>
</div>

