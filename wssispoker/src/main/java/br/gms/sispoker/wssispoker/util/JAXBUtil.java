package br.gms.sispoker.wssispoker.util;

import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Classe utilitária para trabalhar com JAXb.
 */
public abstract class JAXBUtil {

	/**
	 * Dado um objeto para ser transformado em XML, com as devidas anotações
	 * JAXB, retorna um objeto Response pronto para ser devolvido pelo Rest.
	 * <p>
	 * POr default, retorna o XML sem Header, com codificação HTML code e o
	 * objeto Response setado para {@link MediaType#APPLICATION_XML}.
	 */
	public static Response getTransformResponse(Object o) {

		try {

			JAXBContext jaxb = JAXBContext.newInstance(o.getClass());
			Marshaller mars = jaxb.createMarshaller();

			// Deixa sem Head no XML
			mars.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			mars.marshal(o, sw);

			String str = EncodeUtil.escapeHTMLCode(sw.toString());

			return Response.ok(str)
					.type(MediaType.APPLICATION_XML)
					.header("Access-Control-Allow-Origin", "*")
					.build();

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}

}
