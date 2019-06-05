package pojo;

import java.util.HashSet;
import java.util.Set;

public class District {
    private Integer id;

    private String name;
    
    private Set<Street> street=new HashSet<Street>();

	public Set<Street> getStreet() {
		return street;
	}

	public void setStreet(Set<Street> street) {
		this.street = street;
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