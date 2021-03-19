package ForPlants;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class CandyModel {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String file;

    private int listened;

    private String company;


    public CandyModel(){}



    public CandyModel(String name, String file, int listened, String company){
        this.name = name;
        this.file = file;
        this.listened = listened;
        this.company = company;

    }





}
