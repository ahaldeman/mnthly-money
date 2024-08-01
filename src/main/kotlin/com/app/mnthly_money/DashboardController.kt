package com.app.mnthly_money

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DashboardController(
    private val spendingLimitRepository: SpendingLimitRepository
) {
    @GetMapping("/")
    fun showDashboard(model: Model): String {
        val spendingLimit = spendingLimitRepository.getSpendingLimit()
        model.addAttribute("spendingLimit", spendingLimit)
        return "index"
    }
}