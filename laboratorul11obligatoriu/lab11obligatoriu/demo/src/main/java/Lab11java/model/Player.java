package Lab11java.model;


import javax.persistence.*;


@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue
    @Column(name="id")
    public int id;
    @Column(name="name")
    public String name;


    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}