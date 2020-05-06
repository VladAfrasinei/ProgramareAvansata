package Lab11java.model;

import java.util.List;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue
    @Column(name="id")
    public int id;
    @Column(name="name")
    public String name;


    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getname() {
        return name;
    }

}