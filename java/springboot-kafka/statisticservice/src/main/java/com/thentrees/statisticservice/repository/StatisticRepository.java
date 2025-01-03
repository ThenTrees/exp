package com.thentrees.statisticservice.repository;

import com.thentrees.statisticservice.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
