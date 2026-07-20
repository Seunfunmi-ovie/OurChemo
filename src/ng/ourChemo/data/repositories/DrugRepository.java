package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Drug;

public interface DrugRepository {
    Drug save(Drug drug);
    long count();
    void delete(Drug drug);
    void deleteAll();
    Drug findById(int id);

}
