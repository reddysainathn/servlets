import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		// It helps us to create DocumentBuilder Object(Hers its DOM parser)
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();

		// DOM parser
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();

		// Ask Browser to create a DOM tree,so we can read date and manipulate
		// it
		// Document object represents XML DOM Tree
		Document document = documentBuilder.parse("books.xml");

		// System.out.println(document.getFirstChild().getNodeName());

		Node bookStorNode = document.getFirstChild();
		// Returns List of Book Nodes
		NodeList booksListNode = bookStorNode.getChildNodes();

		for (int i = 0; i < booksListNode.getLength(); i++) {

			Node bookNode = booksListNode.item(i);
			
		

			if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(bookNode.getNodeName());

				NodeList bookNodeChildsLists = bookNode.getChildNodes();

				for (int j = 0; j < bookNodeChildsLists.getLength(); j++) {
					
					Node bookNodeChild =  bookNodeChildsLists.item(j);
					
					if(bookNodeChild.getNodeType() == Node.ELEMENT_NODE){
					
						System.out.println(bookNodeChild.getFirstChild().getTextContent());
						
//						BookStore bookStore = new BookStore();
//						
//						bookStore.setBooks(books);
					}

				}
				System.out.println();
			}

		}

	}
}
