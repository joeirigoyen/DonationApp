package com.example.securityintegration.Models.User

import com.example.securityintegration.Models.OrgLookup.Org
import java.math.BigDecimal
import java.sql.Date

class Donation (val userId: Int, val destination: Org, val amount: BigDecimal, val date: Date)