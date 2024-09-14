package com.dotseven.portfolio.domain.repository

import com.dotseven.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

}