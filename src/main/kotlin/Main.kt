fun main() {
    println(commissionCalculation("Maestro", 50000000, 2500000))
}

fun commissionCalculation(cardType: String = "VK pay", amountOfPreviousTransfers: Int, transferAmount: Int) =
    when (cardType) {
        "Mastercard", "Maestro" -> commissionForMastercard(amountOfPreviousTransfers, transferAmount)
        "Visa", "Мир" -> commissionForVisa(transferAmount)
        else -> 0
    }


fun commissionForMastercard(amountOfPreviousTransfers: Int, transferAmount: Int): Int {
    val commission = 0.006
    val additionalCommission = 2000
    val calculation = (transferAmount * commission + additionalCommission) / 100
    val result: Int = if (amountOfPreviousTransfers > 7500000) calculation.toInt() else 0
    return result
}

fun commissionForVisa(transferAmount: Int): Int {
    val commission = 0.0075
    val minimumCommission = 35
    val calculation = (transferAmount * commission) /100
    val result = if (calculation.toInt() < minimumCommission) minimumCommission else calculation.toInt()
    return result
}