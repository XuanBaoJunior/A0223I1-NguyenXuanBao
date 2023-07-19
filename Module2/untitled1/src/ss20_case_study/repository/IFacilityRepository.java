package ss20_case_study.repository;

import ss20_case_study.model.Facility;

import java.util.List;

public interface IFacilityRepository extends Repository {
    Facility getFacilityById(String id);
    List<Facility> getAllFacilities();
}
