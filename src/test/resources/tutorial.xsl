<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
<head>
<title>XML XSL Example</title>
<style type="text/css">
body
{
margin:10px;
background-color:#ccff00;
font-family:verdana,helvetica,sans-serif;
}

.tutorial-name
{
display:block;
font-weight:bold;
}

.tutorial-url
{
display:block;
color:#636363;
font-size:small;
font-style:italic;
}
</style>
</head>
<body>
<h2>Test Suite</h2>
<p>The test suite!</p>
  <xsl:apply-templates/>
</body>
</html>
</xsl:template>

<xsl:template match="tests">
  <span class="test"><xsl:value-of select="test"/></span>
  <span class="required"><xsl:value-of select="reqArgs"/></span>
  <span class="optional"><xsl:value-of select="optArgs"/></span>
</xsl:template>

</xsl:stylesheet>
