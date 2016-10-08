package main.java.com.boot.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import main.java.com.boot.model.BaseEntity;

import java.util.Collection;
import java.util.List;

/**
 * Created by hao huang on 18/09/2016.
 */
public class EntitiesToArrayConverter extends BidirectionalConverter<Collection<BaseEntity>,String[]> {

    @Override
    public String[] convertTo(Collection<BaseEntity> source, Type<String[]> destinationType) {
        String[] array = new String[source.size()];
        int i=0;
        for(BaseEntity entity:source){
            array[i]=String.valueOf(entity.getId());
            i++;
        }
        return array;
    }

    @Override
    public Collection<BaseEntity> convertFrom(String[] source, Type<Collection<BaseEntity>> destinationType) {
        return null;
    }
}
