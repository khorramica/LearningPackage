package ir.khorrami.learningpackage.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    @NonNull
    private int id;

    @ColumnInfo(name = "FirstName")
    @NonNull
    private String firstName;

    @ColumnInfo(name = "Lastname")
    @NonNull
    private String lastName;

    public Employee(@NonNull String firstName,@NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
