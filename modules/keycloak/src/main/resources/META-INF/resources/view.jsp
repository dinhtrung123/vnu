<%@page import="org.oep.core.service.util.LiferayOrganizationUtil"%>
<%@page import="keycloak.portlet.KeycloakUtilTemp"%>
<%@page import="keycloak.portlet.ToolUtil"%>
<%@page import="keycloak.portlet.testKeycloak"%>
<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<style type="text/css">
#map { width: 788px; height: 395px; }
</style>
<p>
	<b><liferay-ui:message key="keycloak.caption"/></b>
</p>
<div id="<portlet:namespace/>map">
	<p>ass</p>
</div>
<script src="http://dev.openlayers.org/releases/OpenLayers-2.11/lib/OpenLayers.js" type="text/javascript"></script>
<script defer="defer" type="text/javascript">
	var map = new OpenLayers.Map('<portlet:namespace/>map');
    var wms = new OpenLayers.Layer.WMS( "OpenLayers WMS",
        "http://vmap0.tiles.osgeo.org/wms/vmap0", {layers: 'basic'} );
    map.addLayer(wms);
    map.zoomToMaxExtent();
</script>