package com.siha80.kotlin.study.kotlinexam.adt

sealed class OptionAdt<out A> {
    companion object {
        fun <A> apply(data: A): OptionAdt<A> {
            if(data == null) {
                return None
            } else {
                return Some(data)
            }
        }
    }
}
data class Some<A>(val a: A): OptionAdt<A>()
object None: OptionAdt<Nothing>()