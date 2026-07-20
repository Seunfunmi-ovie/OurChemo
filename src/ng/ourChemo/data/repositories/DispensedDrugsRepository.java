package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.DispensedDrugs;

public interface DispensedDrugsRepository {
    DispensedDrugs save(DispensedDrugs dispensedDrugs);
    long count();
    void delete(DispensedDrugs dispensedDrugs);
    void deleteAll();
    DispensedDrugs findById(int id);
}
