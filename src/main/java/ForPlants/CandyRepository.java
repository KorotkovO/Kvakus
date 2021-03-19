package ForPlants;

import org.springframework.data.repository.CrudRepository;

public interface CandyRepository extends CrudRepository<CandyModel, Long> {


    CandyModel findByName (String name);

    void deleteByName(String name);


}
