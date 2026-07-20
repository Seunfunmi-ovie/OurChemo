package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Drug;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrugRepositoryImplTest {

    @Test
    void testSaveDrug_IncreasesCountAndSavesDrug() {
        DrugRepository drugRepository = new DrugRepositoryImpl();
        Drug drug = new Drug();
        drug.setId(1);
        drug.setName("DrugA");

        Drug savedDrug = drugRepository.save(drug);

        assertNotNull(savedDrug);
        assertEquals(1, drugRepository.count());
    }

    @Test
    void testFindById_ReturnsCorrectDrug() {
        DrugRepository drugRepository = new DrugRepositoryImpl();

        Drug drug1 = new Drug();
        drug1.setId(1);
        drug1.setName("DrugA");

        Drug drug2 = new Drug();
        drug2.setId(2);
        drug2.setName("DrugB");

        drugRepository.save(drug1);
        drugRepository.save(drug2);

        Drug foundDrug = drugRepository.findById(2);

        assertNotNull(foundDrug);
        assertEquals(2, foundDrug.getId());
        assertEquals("DrugB", foundDrug.getName());
    }

    @Test
    void testFindById_ReturnsNullIfNotFound() {
        DrugRepository drugRepository = new DrugRepositoryImpl();
        Drug drug = new Drug();
        drug.setId(1);
        drugRepository.save(drug);

        Drug foundDrug = drugRepository.findById(99);

        assertNull(foundDrug);
    }

    @Test
    void testDeleteDrug_DecreasesCountAndRemovesDrug() {
        DrugRepository drugRepository = new DrugRepositoryImpl();
        Drug drug = new Drug();
        drug.setId(1);
        drugRepository.save(drug);

        drugRepository.delete(drug);

        assertEquals(0, drugRepository.count());
        assertNull(drugRepository.findById(1));
    }

    @Test
    void testDeleteAll_ClearsRepositoryAndResetsCount() {
        DrugRepository drugRepository = new DrugRepositoryImpl();

        Drug drug1 = new Drug();
        drug1.setId(1);
        Drug drug2 = new Drug();
        drug2.setId(2);

        drugRepository.save(drug1);
        drugRepository.save(drug2);

        drugRepository.deleteAll();

        assertEquals(0, drugRepository.count());
        assertNull(drugRepository.findById(1));
        assertNull(drugRepository.findById(2));
    }
}
