package com.example.spendyourmoney;

public class Spending {
	int _id;
	String _name;
	int _money;
	String _description;
	String _date;
	String _type;
	
	
	public Spending(){
		
	}
	public Spending(String name, int money,String description,String Date,String type){
        
        this._name = name;
        this._money = money;
        this._description = description;
        this._date = Date;
        this._type = type;
       
    }
	
	
	 // constructor
	    public Spending(String name, int money){
	        this._name = name;
	        this._money = money;
	    }
	    public Spending(int id){
	        this._id= id;
	        
	    }
	    public int getID(){
	        return this._id;
	    }
	     
	    // setting id
	    public void setID(int id){
	        this._id = id;
	    }
	     
	    // getting name
	    public String getName(){
	        return this._name;
	    }
	     
	    // setting name
	    public void setName(String name){
	        this._name = name;
	    }
	     
	    // getting money
	    public int getMoney(){
	        return this._money;
	    }
	     
	    // setting money
	    public void setMoney(int i){
	        this._money = i;
	    }
	 // getting money
	    public String getDescription(){
	        return this._description;
	    }
	     
	    // setting money
	    public void setDescription(String description){
	        this._description = description;
	    }
		 // getting date
	    public String getDate(){
	        return this._date;
	    }
	     
	    // setting date
	    public void setDate(String date){
	        this._date = date;
	    }
	    
	    // getting type
	    public String getType(){
	        return this._type;
	    }
	     
	    // setting money
	    public void setType(String type){
	        this._type = type;
	    }
}
