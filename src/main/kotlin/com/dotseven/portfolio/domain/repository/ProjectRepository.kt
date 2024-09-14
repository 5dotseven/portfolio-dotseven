package com.dotseven.portfolio.domain.repository

import com.dotseven.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {

}