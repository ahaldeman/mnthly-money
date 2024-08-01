package com.app.mnthly_money

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SpendingLimitRepository: JpaRepository<SpendingLimit, Long> {

    @Query(value = "SELECT amount FROM spending_limit ORDER BY id DESC LIMIT 1")
    fun getSpendingLimit(): Int
}