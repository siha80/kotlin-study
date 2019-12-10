package com.siha80.kotlin.study.kotlinexam.adt

import org.junit.jupiter.api.Test


class WeatherAdtTest {
    @Test
    fun `sunny weather should go to buy ice cream`() {
        val weather = Sunny()

        Weather.navigateWhereToGoWithWeahter(weather)
    }
}