package br.com.guide_ms.domain.repository;

import br.com.guide_ms.domain.entity.Stop;

import java.util.List;

public interface StopRepository {

    Stop saveStop(Stop stop);

    default List<Stop> saveStopList(List<Stop> stopList){
        stopList.stream().map(stop -> saveStop(stop));
        return stopList;
    }

    void deleteStop(String id);

    default void deleteStopList(List<Stop> stopList){
        stopList.stream().forEach(stop -> deleteStop(stop.getId()));
    }
}
