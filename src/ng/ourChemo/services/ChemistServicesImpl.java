package ng.ourChemo.services;

import ng.ourChemo.data.models.DispensedDrugs;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.repositories.DrugRepository;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.UpdateDrugRequest;

import java.util.List;


public class ChemistServicesImpl  implements  ChemistServices {
    private final DrugRepository drugRepository;

    public ChemistServicesImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public String addDrug(AddDrugRequest request) {
        Drug drug = new Drug();
        drug.setName(request.getDrugName());
        drug.setBrand(request.getDrugBrand());
        drug.setPrice(request.getDrugPrice());
        drugRepository.save(drug);
        return ("Drugs Added Successfully");
    }

    @Override
    public String updateDrug(UpdateDrugRequest request) {
        Drug drug = drugRepository.findById(request.getDrugId());
        if (drug == null) {
            throw new IllegalArgumentException("Drug not found with ID: " + request.getDrugId());
        }
        drug.setName(request.getDrugName());
        drug.setBrand(request.getDrugBrand());
        drug.setPrice(request.getDrugPrice());
        drugRepository.save(drug);

        return ("Updated Drugs Succesfully");

    }
    @Override
    public String deleteDrug(int id){
        Drug drug = drugRepository.findById(id);
        if(drug == null){
            throw new IllegalArgumentException("Drug not found: " + id);
        }
        drugRepository.delete(drug);
        return "Drug Deleted Succesfully";
    }
    @Override
    public String dispensedDrugs(List<DispensedDrugs>dispenses){
        if (dispenses == null || dispenses.isEmpty()) {
            throw new IllegalArgumentException("Dispense list cannot be empty");
        }
        return "Drug Dispensed Successfully";
    }
}
