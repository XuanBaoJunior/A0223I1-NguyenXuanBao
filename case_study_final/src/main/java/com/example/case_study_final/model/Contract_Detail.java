package com.example.case_study_final.model;

public class Contract_Detail {
    private int contract_detail_id;
    private Contract contract_id;
    private int attach_service_id;

    public Contract_Detail() {
    }

    public Contract_Detail(int contract_detail_id, Contract contract_id, int attach_service_id) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract_id() {
        return contract_id;
    }

    public void setContract_id(Contract contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attach_service_id = attach_service_id;
    }
}
