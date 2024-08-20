package com.example.RiwiAssesment.infrastructure.abstract_services.crud;

public interface IFindById<ID, RS> {
    public RS findById(ID id);   
}
