<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
</head>

<body>
<table width="100%"  style= " border: 1px solid #CCC;
    border-collapse: collapse" >
    <thead>
    <tr>
        <td rowspan="3" width="224px">
            <tiles:insertAttribute name="menu" /></td>
        <td height="30px">
            <tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td style="vertical-align: top" >
            <tiles:insertAttribute name="body" /></td>
    </tr>
    <tr  height="10px">
        <td colspan="2">
            <tiles:insertAttribute name="footer" /></td>
    </tr>
    </thead>
</table>
</body>
</html>
