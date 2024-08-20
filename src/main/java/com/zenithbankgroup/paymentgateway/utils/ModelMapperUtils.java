package com.zenithbankgroup.paymentgateway.utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:20 PM
 * @project paymentgateway
 */
public class ModelMapperUtils {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <S, D> D map(final S entity, Class<D> outClazz) {
        return modelMapper.map(entity, outClazz);
    }

    public static <S, D> List<D> mapAll(final Collection<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> Set<D> mapAll(final Set<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toSet());
    }

    public static <S, D> List<D> mapAll(final List<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> Set<D> mapAllSet(final List<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toSet());
    }

    public static <S, D> List<D> mapAll(final Page<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> Page<D> mapAllPage(final Page<S> entityList, Class<D> outClazz) {
        return new PageImpl<>(entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList()));
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
