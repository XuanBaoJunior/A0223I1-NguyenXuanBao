package ss20_case_study.repository;

import ss20_case_study.model.Contract;

import java.util.List;

public interface IContractRepository extends Repository{
    Contract getContractById(String id);
    List<Contract> getAllContracts();
}
