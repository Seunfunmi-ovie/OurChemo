package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.DispensedDrugs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DispensedDrugsRepositoryImplTest {

    @Test
    void testSaveDispensedDrugs_IncreasesCountAndSavesDispensedDrugs() {
        DispensedDrugsRepository dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setId(1);

        DispensedDrugs saved = dispensedDrugsRepository.save(dispensedDrugs);

        assertNotNull(saved);
        assertEquals(1, dispensedDrugsRepository.count());
    }

    @Test
    void testFindById_ReturnsCorrectDispensedDrugs() {
        DispensedDrugsRepository dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();

        DispensedDrugs item1 = new DispensedDrugs();
        item1.setId(1);

        DispensedDrugs item2 = new DispensedDrugs();
        item2.setId(2);

        dispensedDrugsRepository.save(item1);
        dispensedDrugsRepository.save(item2);
        DispensedDrugs found = dispensedDrugsRepository.findById(2);

        assertNotNull(found);
        assertEquals(2, found.getId());
    }

    @Test
    void testFindById_ReturnsNullIfNotFound() {
        DispensedDrugsRepository dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setId(1);
        dispensedDrugsRepository.save(dispensedDrugs);

        DispensedDrugs found = dispensedDrugsRepository.findById(99);

        assertNull(found);
    }

    @Test
    void testDeleteDispensedDrugs_DecreasesCountAndRemovesDispensedDrugs() {
        DispensedDrugsRepository dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setId(1);
        dispensedDrugsRepository.save(dispensedDrugs);

        dispensedDrugsRepository.delete(dispensedDrugs);

        assertEquals(0, dispensedDrugsRepository.count());
        assertNull(dispensedDrugsRepository.findById(1));
    }

    @Test
    void testDeleteAll_ClearsRepositoryAndResetsCount() {
        DispensedDrugsRepository dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();

        DispensedDrugs item1 = new DispensedDrugs();
        item1.setId(1);
        DispensedDrugs item2 = new DispensedDrugs();
        item2.setId(2);

        dispensedDrugsRepository.save(item1);
        dispensedDrugsRepository.save(item2);

        dispensedDrugsRepository.deleteAll();

        assertEquals(0, dispensedDrugsRepository.count());
        assertNull(dispensedDrugsRepository.findById(1));
        assertNull(dispensedDrugsRepository.findById(2));
    }
}
