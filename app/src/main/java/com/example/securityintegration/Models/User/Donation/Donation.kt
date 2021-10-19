package com.example.securityintegration.Models.User.Donation

import com.example.securityintegration.Models.OrgLookup.Org
import java.math.BigDecimal
import java.sql.Date

data class Donation (val id_donacion: Int, val cantidad: Float, val fundacion: String, val fecha: String, val id_usuario: String)
