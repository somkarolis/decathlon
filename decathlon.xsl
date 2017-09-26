<?xml version="1.0" encoding="UTF-8" standalone="no"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
    <html>
        <body>
            <h2>Decathlon results</h2>
            <table border="1">
                <tr bgcolor="#FF8000">
                    <th>Place</th>
                    <th>Name</th>
                    <th>100m</th>
                    <th>Long jump</th>
                    <th>Shot put</th>
                    <th>High jump</th>
                    <th>400m</th>
                    <th>110m hurdles</th>
                    <th>Discus throw</th>
                    <th>Pole vault</th>
                    <th>Javelin throw</th>
                    <th>1500m</th>
                    <th>Score</th>
                </tr>
                <xsl:for-each select="participants/participant">
                    <tr>
                        <td><xsl:value-of select="place"/></td>
                        <td><xsl:value-of select="Name"/></td>
                        <td><xsl:value-of select="Event1"/></td>
                        <td><xsl:value-of select="Event2"/></td>
                        <td><xsl:value-of select="Event3"/></td>
                        <td><xsl:value-of select="Event4"/></td>
                        <td><xsl:value-of select="Event5"/></td>
                        <td><xsl:value-of select="Event6"/></td>
                        <td><xsl:value-of select="Event7"/></td>
                        <td><xsl:value-of select="Event8"/></td>
                        <td><xsl:value-of select="Event9"/></td>
                        <td><xsl:value-of select="Event10"/></td>
                        <td><xsl:value-of select="Score"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>