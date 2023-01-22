import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    @Test
    fun commissionCalculationForElse() {
        val cardType = "not"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(println("Неверный тип карты"), result)
    }

    @Test
    fun commissionCalculationForVisa() {
        val cardType = "Visa"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 2500000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(187, result)
    }

    @Test
    fun commissionCalculationForMir() {
        val cardType = "Мир"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun commissionCalculationForMastercard() {
        val cardType = "Mastercard"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalculationForMaestro() {
        val cardType = "Maestro"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalculationForVKPay() {
        val cardType = "VK pay"
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        when (cardType) {
            "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
            "Visa", "Мир" -> commissionForVisa(transferAmount)
            "VK pay" -> 0
            else -> println("Неверный тип карты")
        }

        val result = commissionCalculation(cardType,amountOfPreviousTransfers,transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun commissionForMastercardLimitNotExceeded() {
        val amountOfPreviousTransfers = 5000000
        val transferAmount = 250000
        val commission = 0.006
        val additionalCommission = 2000
        val calculation = (transferAmount * commission + additionalCommission) / 100
        if (amountOfPreviousTransfers > 7500000) calculation.toInt() else 0

        val result = commissionForMastercard(amountOfPreviousTransfers, transferAmount)
        assertEquals(0, result)

    }

    @Test
    fun commissionForMastercardLimitExceeded() {
        val amountOfPreviousTransfers = 50000000
        val transferAmount = 250000
        val commission = 0.006
        val additionalCommission = 2000
        val calculation = (transferAmount * commission + additionalCommission) / 100
        if (amountOfPreviousTransfers > 7500000) calculation.toInt() else 0

        val result = commissionForMastercard(amountOfPreviousTransfers, transferAmount)
        assertEquals(35, result)

    }

    @Test
    fun commissionForVisaMinimum() {
        val transferAmount = 250000
        val commission = 0.0075
        val minimumCommission = 35
        val calculation = (transferAmount * commission) / 100
        if (calculation.toInt() < minimumCommission) minimumCommission else calculation.toInt()

        val result = commissionForVisa(transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun commissionForVisaDifferent() {
        val transferAmount = 2500000
        val commission = 0.0075
        val minimumCommission = 35
        val calculation = (transferAmount * commission) / 100
        if (calculation.toInt() < minimumCommission) minimumCommission else calculation.toInt()

        val result = commissionForVisa(transferAmount)
        assertEquals(187, result)
    }
}