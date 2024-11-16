package com.app.mnthly_money

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.text.NumberFormat
import java.util.*

@Controller
class DashboardController(
    private val spendingLimitRepository: SpendingLimitRepository
) {
    @GetMapping("/")
    fun showDashboard(model: Model): String {
        val spendingLimit = spendingLimitRepository.getSpendingLimit()
        model.addAttribute("spendingLimit", formatCurrency(spendingLimit))
        return "index"
    }

    fun formatCurrency(amount: Number): String {
        val locale = Locale.of("en", "US")
        val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
        return currencyFormatter.format(amount)
    }
}