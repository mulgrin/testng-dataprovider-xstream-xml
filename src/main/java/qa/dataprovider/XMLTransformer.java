package qa.dataprovider;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// From http://stackoverflow.com/questions/19811581/how-to-convert-xml-to-html-using-xslt-in-java
public class XMLTransformer {

	public static void main( String args[] ) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Source xslDoc = new StreamSource("src/test/resources/tutorial.xsl");
			Source xmlDoc = new StreamSource("data-provider.xml");

			String outputFileName = "Suite.html";

			OutputStream htmlFile = new FileOutputStream(outputFileName);
			Transformer trasform = tFactory.newTransformer(xslDoc);
			trasform.transform(xmlDoc, new StreamResult(htmlFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
