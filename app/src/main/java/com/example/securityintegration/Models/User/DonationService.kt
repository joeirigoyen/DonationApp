package com.example.securityintegration.Models.User

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import java.math.BigDecimal
import java.sql.Date

class DonationService {

    val orgs : List<Org> = OrgService().getOrgs()
    val donations : List<Donation> = listOf(
        Donation(1, orgs[0], BigDecimal("500.25"), Date(2021, 12, 21)),
        Donation(1, orgs[1], BigDecimal("40.50"), Date(2021, 11, 16)),
        Donation(1, orgs[1], BigDecimal("10.00"), Date(2021, 10, 2)),
        Donation(1, orgs[2], BigDecimal("5.20"), Date(2021, 9, 1)),
        Donation(2, orgs[1], BigDecimal("400.10"), Date(2021, 8, 20)),
        Donation(2, orgs[0], BigDecimal("800.00"), Date(2021, 7, 13)),
        Donation(2, orgs[1], BigDecimal("105.50"), Date(2021, 6, 22)),
        Donation(3, orgs[0], BigDecimal("50.00"), Date(2021, 5, 14)),
        Donation(3, orgs[2], BigDecimal("7.25"), Date(2021, 4, 9)),
        Donation(3, orgs[2], BigDecimal("10.20"), Date(2021, 3, 12)),
        Donation(3, orgs[0], BigDecimal("4.30"), Date(2021, 3, 24))
    )

    fun getDonations(user: User): List<Donation> {
        return donations.filter { it.userId == user.userId }
    }

}