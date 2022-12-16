package com.example.nagrada.models

data class PersonModel(
    var name: String = "Имя",
    var family: String = "Фамилия",
    var login: String = "Логин",
    var password: String = "Пароль",
    var avatar: String = "Ссылка на аватар",
    var phone: String = "Номер телефона",
    var email: String = "Электронная почта",
    var telegram: String = "Телеграм",
    var theme: String = "Black",
    var token: String = "Токен",
)
