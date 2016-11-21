import java.util.ArrayList;

public class User{

	String name, type, key;										//user name, type and key(password)
	ArrayList<Integer> tournaments;
	
	public User(String name, String key, String type){			//constructor for coach object
		this.name = name;
		this.type = type;
		this.key = key;
		tournaments = new ArrayList<Integer>();
	}

	public String getName(){									//get coach name
		return name;
	}

	public String getType(){									//get user phone number
		return type;
	}

	public String getKey(){										//get user key
		return key;
	}

	public void setName(String name){							//set user name
		this.name = name;
	}

	public void setType(String type){							//set user type
		this.type = type;
	}

	public void setKey(String key){								//set user key
		this.key = key;
	}
}
