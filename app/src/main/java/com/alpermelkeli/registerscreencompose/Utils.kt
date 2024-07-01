package com.alpermelkeli.registerscreencompose

fun isEmailValid(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    return emailRegex.matches(email)
}
fun isPhoneNumberValid(phoneNumber: String): Boolean {
    val phoneRegex = "^[+]?[0-9\\-\\s()]{7,15}$".toRegex()
    return phoneRegex.matches(phoneNumber)
}
fun isPasswordValid(password: String): Boolean {
    return password.length >= 8
}