<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<head>
				<title>XML XSL Example</title>
				<style type="text/css">
					table, td, th
					{
					border:1px solid green;
					}
					th
					{
					background-color:green;
					color:white;
					}
				</style>
			</head>
			<body>
				<h2>Test Suite</h2>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<xsl:template match="suite/tests">
		<h2>My Tests</h2>
		<table border="1">
			<tr>
				<th>enabled</th>
				<th>testname</th>
				<th>environment</th>
				<th>testLocale</th>
				<th>browser</th>
				<th>arg</th>
				<th>arg</th>
				<th>arg</th>
				<th>arg</th>
				<th>arg</th>
			</tr>
			<xsl:for-each select="test">
				<tr>
					<xsl:for-each select="reqArgs/argsWrapper">
						<td>
  					  <xsl:value-of select="boolean" />
							<xsl:value-of select="string" />
						</td>
					</xsl:for-each>
					<xsl:for-each select="optArgs/argsWrapper/entry">
						<td>
							<xsl:value-of select="string[1]" />
						</td>
					</xsl:for-each>
				</tr>
			</xsl:for-each>
		</table>
		<h4>The End.</h4>
	</xsl:template>

</xsl:stylesheet>
