package com.dotseven.portfolio.domain.repository

import com.dotseven.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}