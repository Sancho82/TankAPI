package entity;

import javax.persistence.*;

@Entity
@Table(name = "tanks")
public class Tank {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long tankId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "TYPE")
    private String type;

    public String getName() {
        return name;
    }

    public Long getTankId() {
        return tankId;
    }

    public Tank setTankId(Long id) {
        this.tankId = id;
        return this;
    }

    public Tank setName(String name) {
        this.name = name;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public Tank setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getType() {
        return type;
    }

    public Tank setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "Name='" + name + '\'' +
                ", Owner='" + owner + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}
