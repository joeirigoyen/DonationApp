package com.example.securityintegration.Models.User.Login

import com.paypal.pyplcheckout.addshipping.model.Country
import java.io.Serializable
import java.sql.Date

data class User (
    var nombre: String,
    var apellidoPaterno: String,
    var apellidoMaterno: String,
    var fecha_nacimiento: String,
    var tipo: Int,
    var rfc: String,
    var email: String,
    var password: String,
    var usuario: String,
    var membresiumIdMembresia: Int,
    var sec_q: String,
    var sec_a: String,
    var pais: String,
    var descripcion: String) : Serializable