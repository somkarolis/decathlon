package lt.somka.decathlon.output;

import lt.somka.decathlon.Participant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

public class XMLWriter {
    private Map<Participant, String> placedParticipants;
    private String output;

    public XMLWriter() {
    }

    public void writeXML(Map<Participant, String> placedParticipants) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            ProcessingInstruction pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"decathlon.xsl\"");
            //add elements to Document
            Element rootElement =
                    doc.createElement("participants");
            //append root element to document
            doc.appendChild(rootElement);
            //add stylesheet to document
            doc.insertBefore(pi, rootElement);

            for (Map.Entry<Participant, String> entry : placedParticipants.entrySet()) {
                rootElement.appendChild(getParticipant(doc, entry.getValue(), entry.getKey().getName(), entry.getKey().getResults().get(0),
                        entry.getKey().getResults().get(1), entry.getKey().getResults().get(2),
                        entry.getKey().getResults().get(3), entry.getKey().getResults().get(4),
                        entry.getKey().getResults().get(5), entry.getKey().getResults().get(6),
                        entry.getKey().getResults().get(7), entry.getKey().getResults().get(8),
                        entry.getKey().getResults().get(9), entry.getKey().getScore()));
            }

            //for output to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            //write to file
            StreamResult file = new StreamResult(new File("/Users/somka/Documents/Java/decathlon/" + output + ".xml"));

            //write data
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getParticipant(Document doc, String place, String name, String result1, String result2,
                                       String result3, String result4, String result5, String result6, String result7,
                                       String result8, String result9, String result10, int score) {
        Element participant = doc.createElement("participant");

        //set id attribute
        participant.appendChild(getParticipantElements(doc, participant, "place", place));

        //create name element
        participant.appendChild(getParticipantElements(doc, participant, "Name", name));

        //create result elements
        participant.appendChild(getParticipantElements(doc, participant, "Event1", result1));
        participant.appendChild(getParticipantElements(doc, participant, "Event2", result2));
        participant.appendChild(getParticipantElements(doc, participant, "Event3", result3));
        participant.appendChild(getParticipantElements(doc, participant, "Event4", result4));
        participant.appendChild(getParticipantElements(doc, participant, "Event5", result5));
        participant.appendChild(getParticipantElements(doc, participant, "Event6", result6));
        participant.appendChild(getParticipantElements(doc, participant, "Event7", result7));
        participant.appendChild(getParticipantElements(doc, participant, "Event8", result8));
        participant.appendChild(getParticipantElements(doc, participant, "Event9", result9));
        participant.appendChild(getParticipantElements(doc, participant, "Event10", result10));

        //create score element
        participant.appendChild(getParticipantElements(doc, participant, "Score", "" + score));

        return participant;
    }

    //utility method to create text node
    private static Node getParticipantElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
