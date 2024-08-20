package com.example.RiwiAssesment.infrastructure.abstract_services;

import com.example.RiwiAssesment.infrastructure.abstract_services.crud.ICreate;
import com.example.RiwiAssesment.infrastructure.abstract_services.crud.IDelete;
import com.example.RiwiAssesment.infrastructure.abstract_services.crud.IFindAll;
import com.example.RiwiAssesment.infrastructure.abstract_services.crud.IFindById;
import com.example.RiwiAssesment.infrastructure.abstract_services.crud.IUpdate;

public interface IGenericService<E,ID,RQ,RS> 
    extends IFindAll<RS>, IFindById<ID,RS>, ICreate<RQ,RS>,IUpdate<ID,RQ,RS>, IDelete<ID>
{
    public E find(ID id);
}
