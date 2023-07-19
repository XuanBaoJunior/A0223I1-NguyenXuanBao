package ss20_case_study.service;

import ss20_case_study.model.Facility;

public interface IFacilityService<Facility> extends Service{
    void checkAvailability(Facility facility);
    void bookFacility(Facility facility);
}
