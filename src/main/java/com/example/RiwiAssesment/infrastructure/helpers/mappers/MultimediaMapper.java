package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RiwiAssesment.api.dto.request.MultimediaRequest;
import com.example.RiwiAssesment.api.dto.response.base.MultimediaBaseResponse;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;

@Mapper(componentModel = "spring")
public abstract class MultimediaMapper 
    implements IMapperBase<MultimediaEntity, MultimediaRequest, MultimediaBaseResponse>
{
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lessonEntity", ignore = true)
    public abstract MultimediaEntity requestToEntity(MultimediaRequest request); 
    
    public abstract List<MultimediaEntity> listRQtoListE(List<MultimediaRequest> multimedia);
}
