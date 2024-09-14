package com.dotseven.portfolio.domain.repository

import com.dotseven.portfolio.domain.entity.Achievement
import com.dotseven.portfolio.domain.entity.Experience
import com.dotseven.portfolio.domain.entity.Introduction
import com.dotseven.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {

}