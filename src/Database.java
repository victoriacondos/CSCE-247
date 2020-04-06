/**
 * @author Brett Logeais
 * Purpose: I/O for JSON files
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Database {
	
	private ArrayList<DatabaseObject> objectList;
	private String fileName;
	
	/**
	* Purpose: Constructor to initiate loading of objects into database
	* @param: fileName: name of file that is being read
	*/
	public Database(String fileName) {
		this.fileName = fileName;
		this.loadObjects();
	}
	
	/**
	* Purpose: reads file and stores objects from JSON file into array of correct type
	*/
	public void loadObjects() {
		ArrayList<DatabaseObject> objects = new ArrayList<DatabaseObject>();
		try {
			FileReader reader = new FileReader(this.fileName);
			JSONParser parser = new JSONParser();
			JSONArray objectsJSON = (JSONArray)parser.parse(reader);
			for (int i = 0; i < objectsJSON.size(); i++) {
				JSONObject objectJSON = (JSONObject)objectsJSON.get(i);
				DatabaseObject object = JSONtoObject(objectJSON);
				objects.add(object);
			}
			objectList = objects;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	*Purpose: saves objects in JSON file
	*/
	public void saveObjects() {
		JSONArray accountsJSON = new JSONArray();
		for (int i = 0; i < objectList.size(); i++) {
			accountsJSON.add(objectList.get(i).toJSON());
		}
        try (FileWriter file = new FileWriter(this.fileName)) {
            file.write(accountsJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	* Purpose: adds parameterized object to objectList
	* @param object: object being added to objectList
	*/
	public void addObject(DatabaseObject object) {
		objectList.add(object);
	}
	
	/**
	* Purpose: uses info from JSON files to create new objects of correct type
	* @param objectJSON: JSONObject that is being converted to correct object type
	* @return: correct type of object (RewardsAccount, ManagerAccount, Movie, Concert, or Theatre)
	*/
	private DatabaseObject JSONtoObject(JSONObject objectJSON) {
		DatabaseObject object;
		if (this.fileName.equals("src/accountsRewards.json")) {
			object = new RewardsAccount(objectJSON);
		} else if (this.fileName.equals("src/accountsManager.json")) {
			object = new ManagerAccount(objectJSON);
		} else if (this.fileName.equals("src/eventsMovie.json")){
			object = new Movie(objectJSON);
		} else if (this.fileName.equals("src/eventsConcert.json")){
			object = new Concert(objectJSON);
		} else if (this.fileName.equals("src/eventsTheatre.json")) {
			object = new Theatre(objectJSON);
		} else {
			object = null;
		}
		return object;
	}
	
	/**
	* Purpose: Accessor for object lists
	* @return: list of objects of a certain type
	*/
	public ArrayList<DatabaseObject> getList() {
		return objectList;
	}
	
	/**
	* Purpose: prints a numbered list of all objects in database (from start point)
	* @return int of total number of objects (from start point)
	*/
	public int printDatabase(int start) {
		int count = start;
		for (int i = 0; i < this.objectList.size(); i++) {
			System.out.println((start+i) + ")\n" + objectList.get(i) + "\n\n");
			count++;
		}
		return count;
		
	}
}
