/**
* author: Brett Logeais
* Purpose: base class for objects to be stored in a database
*/
import org.json.simple.JSONObject;

public abstract class DatabaseObject {

	/**
	* Purpose: to create a JSONObject from a DatabaseObject
	*/
	public abstract JSONObject toJSON();
}
