package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import com.example.RiwiAssesment.api.dto.request.MultimediaRequest;
import com.example.RiwiAssesment.api.dto.response.base.MultimediaBaseResponse;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T14:15:41-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class MultimediaMapperImpl extends MultimediaMapper {

    @Override
    public MultimediaBaseResponse entityToResponse(MultimediaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MultimediaBaseResponse.MultimediaBaseResponseBuilder<?, ?> multimediaBaseResponse = MultimediaBaseResponse.builder();

        multimediaBaseResponse.description( entity.getDescription() );
        multimediaBaseResponse.id( entity.getId() );
        multimediaBaseResponse.title( entity.getTitle() );
        multimediaBaseResponse.type( entity.getType() );
        multimediaBaseResponse.url( entity.getUrl() );

        return multimediaBaseResponse.build();
    }

    @Override
    public MultimediaEntity requestToEntity(MultimediaRequest request) {
        if ( request == null ) {
            return null;
        }

        MultimediaEntity.MultimediaEntityBuilder multimediaEntity = MultimediaEntity.builder();

        multimediaEntity.description( request.getDescription() );
        multimediaEntity.title( request.getTitle() );
        multimediaEntity.type( request.getType() );
        multimediaEntity.url( request.getUrl() );

        return multimediaEntity.build();
    }

    @Override
    public List<MultimediaEntity> listRQtoListE(List<MultimediaRequest> multimedia) {
        if ( multimedia == null ) {
            return null;
        }

        List<MultimediaEntity> list = new ArrayList<MultimediaEntity>( multimedia.size() );
        for ( MultimediaRequest multimediaRequest : multimedia ) {
            list.add( requestToEntity( multimediaRequest ) );
        }

        return list;
    }
}
