package ss20_case_study.service;

import ss20_case_study.model.Contract;

public interface IContractService extends Service {
    void generateContract(Contract contract);
    void signContract(Contract contract);
}
