package edu.hillel.hw9.db;
import java.util.ArrayList;

public class DS_Mock implements DS 
{
	ArrayList<Person> pp = new ArrayList<Person>();
	DS_Mock(){
		pp.add( new Person(10, "Vasia", "Pupkin", 23) );
		pp.add( new Person(14, "kasia", "Pupkin", 23) );
		pp.add( new Person(19, "Pasia", "Pupkin", 23) );
		pp.add( new Person(22, "Sasia", "Pupkin", 23) );
		pp.add( new Person(24, "Gasia", "Pupkin", 23) );
	}
	@Override
	public void create(Person p) {
		pp.add(new Person(p.getId(),p.getfName(),p.getlName(),p.getAge()));
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void update(Person p) {
		for(Person tmp:pp){
			if(p.getId()==tmp.getId()){
				tmp.setId(p.getId());
				tmp.setfName(p.getfName());
				tmp.setlName(p.getlName());
				tmp.setAge(p.getAge());
			}
		}
	}

	@Override
	public void delete(Person p) {
		int i=0;
		for(Person tmp:pp){			
			if(p.getId()==tmp.getId()) break;
			i++;
		}
		pp.remove(i);
	}
}
