package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.DispensedDrugs;
import java.util.ArrayList;
import java.util.List;

public class DispensedDrugsRepositoryImpl implements DispensedDrugsRepository {

    private final List<DispensedDrugs> drugList = new ArrayList<>();

    @Override
    public DispensedDrugs save(DispensedDrugs dispensedDrugs) {
        delete(dispensedDrugs);
        drugList.add(dispensedDrugs);
        return dispensedDrugs;
    }

    @Override
    public long count() {
        return drugList.size();
    }

    @Override
    public void delete(DispensedDrugs dispensedDrugs) {
        drugList.remove(dispensedDrugs);
    }

    @Override
    public void deleteAll() {
        drugList.clear();
    }

    @Override
    public DispensedDrugs findById(int id) {
        for (DispensedDrugs drug : drugList) {
            if (drug.getId() == id) {
                return drug;
            }
        }
        return null;
    }
}
