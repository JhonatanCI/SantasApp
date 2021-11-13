package model;

import java.util.ArrayList;

public class SantasApp{

	private ArrayList <Child> whiteList;

	public SantasApp(){

		whiteList= new ArrayList <Child> ();
		
	}

	public void createChild(String name, String lastName, int age, String direction, String country, String wish){
		boolean finish = false;
		Child child = new  Child(name, lastName, age, direction, country, wish);
		if (!whiteList.isEmpty()) {
			for (int i=0;i<whiteList.size() && !finish;i++ ){
				if (whiteList.get(i).compareTo(child)<0) {
					whiteList.add(i,child);
					finish=true;
				}
			}if (finish == false) {
				whiteList.add(child);
			}

		}else {
			whiteList.add(child);
		}
	}

	public void changeList(String name, String lastName){
		Child child;                                            
		int i = foundPositionForName(name, lastName);
		child = whiteList.get(i);
		if ((child.getName()).equalsIgnoreCase(name)) {
			child.setStatus(List.NAUGTHYCHILD);
		}else{
			child.setStatus(List.GOODCHILD);
		}
	}

	public void deleteChild(String name, String lastName){
		Child child;
		boolean finish = false;
		int i = foundPositionForName(name, lastName);
		whiteList.remove(i);
	}

	public boolean foundPositionWhite(){
		boolean out = whiteList.isEmpty();

		return out;
	}

	public String showList(int list){
		String out = "";
		Child child;
		for (int i=0;i<whiteList.size();i++ ){
			child = whiteList.get(i);
			if (list==1 && child.getStatus()==List.GOODCHILD) {

					out+=whiteList.get(i);

			}else if (list==2 && child.getStatus()==List.NAUGTHYCHILD) {

					out+=whiteList.get(i);
				
			}

				
		}
		return out;
	}

	public int foundPositionForName(String name, String lastName){
		int position = -1;
		Child child;
		boolean finish = false;
		for (int i=0;i<whiteList.size() && !finish;i++ ) {
			child = whiteList.get(i);
			if ((child.getName()).equalsIgnoreCase(name) && (child.getLastName()).equalsIgnoreCase(lastName)) {
					
					finish = true;
					position=i;

				}	
		}

		return position;
	}

	public String showChild(String name, String lastName){
		String out = ""; 
		int i = foundPositionForName(name, lastName);
		out += whiteList.get(i);

		return out;
	}

	public boolean existList(int list){
		boolean out = false;
		Child child;
		for (int i=0;i<whiteList.size();i++ ){
			child = whiteList.get(i);
			if (list==1 && child.getStatus()==List.GOODCHILD) {

					out= true;

			}else if (list==2 && child.getStatus()==List.NAUGTHYCHILD){

				out= true;

			}
		}

		return out;

	}
}