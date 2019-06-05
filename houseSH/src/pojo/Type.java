package pojo;

import java.util.HashSet;
import java.util.Set;

public class Type {
    private Integer id;

    private String name;
    
    private Set<House> house=new HashSet<House>();

    public Set<House> getHouse() {
		return house;
	}

	public void setHouse(Set<House> house) {
		this.house = house;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}