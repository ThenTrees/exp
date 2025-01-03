package com.thentrees.statisticservice.service;

import com.thentrees.statisticservice.model.Statistic;
import com.thentrees.statisticservice.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @KafkaListener(id = "statisticGroup", topics = "statistic")
    public void listen(Statistic statistic){
        log.info("Statistic received: {}", statistic.getMessage());
        statisticRepository.save(statistic);
    }
}
