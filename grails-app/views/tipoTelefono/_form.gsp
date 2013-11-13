<%@ page import="medicaltool.TipoTelefono" %>



<div class="fieldcontain ${hasErrors(bean: tipoTelefonoInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="tipoTelefono.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${tipoTelefonoInstance?.nombre}"/>
</div>

