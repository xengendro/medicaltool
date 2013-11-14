<%@ page import="medicaltool.TipoDireccion" %>



<div class="fieldcontain ${hasErrors(bean: tipoDireccionInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="tipoDireccion.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${tipoDireccionInstance?.nombre}"/>
</div>

