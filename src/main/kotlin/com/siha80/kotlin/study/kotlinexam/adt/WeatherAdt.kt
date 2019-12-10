package com.siha80.kotlin.study.kotlinexam.adt

sealed class Weather(emoji: String) {
    val label = "Weather is $emoji"

    companion object {
        fun navigateWhereToGoWithWeahter(weather: Weather) {
            when(weather) {
                is Rainy -> println("go to buy an umbrella")
                is Windy -> println("go to buy a coffee")
                is Sunny -> println("go to buy an ice cream")
            }
        }
    }
}

class Rainy: Weather("ㅠㅠ")
class Sunny: Weather("O")
class Windy: Weather("~")
