package ForPlants;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@Entity
public class CandyModel extends PanacheEntity {

    private String name;

    private String file;

    private int listened;

    public enum Company{VS, CP};

    private Company company;





    public CandyModel(){ }

    public CandyModel(String name, String file, int listened, Company c){
        this.name = name;
        this.file = file;
        this.listened = listened;
        this.company = c;

    }

    public static int getCount(){
        return CandyModel.listAll().size();
    }






}
