package user.auth.springauthorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "varchar(50) default 'Admin'")
    private String type;

    public UserRole(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
