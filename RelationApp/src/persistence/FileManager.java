package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import control.ConstantList;
import model.Person;

public class FileManager {

	public static void writeUser(String path, ArrayList<Person> list) {
		Element root = new Element(ConstantList.USERS);
		Document doc = new Document(root);
		for (Person person : list) {
			Element user = new Element(ConstantList.USER);
			Element id = new Element(ConstantList.ID).setText(person.getId() + "");
			Element photo = new Element(ConstantList.PHOTO).setText(person.getPhoto());
			Element name = new Element(ConstantList.NAME).setText(person.getName());
			Element birthDate = new Element(ConstantList.BIRTHDATE_XML).setText(person.getBirthDate());
			Element gender = new Element(ConstantList.GENDER_XML).setText(person.getGender().toString() + "");
			Element ocupation = new Element(ConstantList.OCUPATION_XML).setText(person.getOcupation().toString());
			user.addContent(id);
			user.addContent(photo);
			user.addContent(name);
			user.addContent(birthDate);
			user.addContent(gender);
			user.addContent(ocupation);
			doc.getRootElement().addContent(user);
		}	
		try {
			FileWriter fileWriter = new FileWriter(path);
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.setFormat(Format.getCompactFormat());
			xmlOutputter.output(doc, fileWriter);
			fileWriter.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static ArrayList<Person> loadUsers(String fileName) {
		ArrayList<Person> users = new ArrayList<Person>();
		Person user = null;
		SAXBuilder builder = new SAXBuilder();
	    try {
	        Document document = (Document) builder.build(new File(fileName));
	        Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
	        List<Element> userFileList = ((org.jdom2.Element) rootNode).getChildren(ConstantList.USER);
	        for (Element matchElement : userFileList) {
	        	int id = Integer.parseInt(matchElement.getChildTextTrim(ConstantList.ID));
	        	String photo = matchElement.getChildTextTrim(ConstantList.PHOTO);
	        	String name = matchElement.getChildTextTrim(ConstantList.NAME);
	        	String birthDate = matchElement.getChildTextTrim(ConstantList.BIRTHDATE_XML);
	        	String gender = matchElement.getChildTextTrim(ConstantList.GENDER_XML);
	        	String ocupation = matchElement.getChildTextTrim(ConstantList.OCUPATION_XML);
	        	user = new Person(id, photo, name, birthDate, gender, ocupation);
	            users.add(user);
	        }
	    }catch (IOException io) {
	        System.err.println(io.getMessage());
	    }catch (JDOMException jdomex) {
	        System.err.println(jdomex.getMessage());
	    } catch (ParseException e) {
	        System.err.println(e.getMessage());
		}
		return users;
	}
}