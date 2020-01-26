package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tanks")
public class Tank {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "OWNER")
    private String Owner;

    @Column(name = "TYPE")
    private String Type;

    public String getName() {
        return Name;
    }

    public Long getId() {
        return Id;
    }

    public Tank setId(Long id) {
        Id = id;
        return this;
    }

    public Tank setName(String name) {
        Name = name;
        return this;
    }

    public String getOwner() {
        return Owner;
    }

    public Tank setOwner(String owner) {
        Owner = owner;
        return this;
    }

    public String getType() {
        return Type;
    }

    public Tank setType(String type) {
        Type = type;
        return this;
    }
}
