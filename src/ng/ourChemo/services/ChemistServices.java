package ng.ourChemo.services;

import ng.ourChemo.data.models.DispensedDrugs;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.UpdateDrugRequest;

import java.util.List;

public interface ChemistServices {
    String addDrug(AddDrugRequest request);
    String updateDrug(UpdateDrugRequest request);
    String dispensedDrugs (List<DispensedDrugs> dispenses);
    String deleteDrug(int id);


}
