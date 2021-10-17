package com.example.securityintegration.Models.User

import com.paypal.pyplcheckout.addshipping.model.Country
import java.sql.Date

data class User (
    var nombre: String,
    var apellidoPaterno: String,
    var apellidoMaterno: String,
    var fecha_nacimiento: String,
    var tipo: String,
    var rfc: String,
    var email: String,
    var password: String,
    var membresiumIdMembresia: String,
    var sec_q: String,
    var sec_a: String)