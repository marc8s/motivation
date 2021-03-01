package com.example.motivation.repository

import com.example.motivation.infra.MotivationConstants
import java.util.*


data class  Phrase(val description: String, val category: Int)

class Mock {
    private val ALL = MotivationConstants.PHRASEFILTER.ALL
    private val MORNING = MotivationConstants.PHRASEFILTER.MORNING
    private val HAPPY = MotivationConstants.PHRASEFILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
            Phrase("Que voulez-vous la porte était gardée", HAPPY),
            Phrase("Que voulez-vous nous étions enfermés.", HAPPY),
            Phrase("Que voulez-vous la rue était barrée", HAPPY),
            Phrase("Que voulez-vous la ville était matée", HAPPY),
            Phrase("Que voulez-vous elle était affamée", HAPPY),
            Phrase("Que voulez-vous nous étions désarmés", HAPPY),
            Phrase("Não sabendo que era ", MORNING),
            Phrase("Não sabendo que era impossivel", MORNING),
            Phrase("Não sabendo que era impossivel, foi", MORNING),
            Phrase("Não sabendo que era impossivel, foi lá.", MORNING),
            Phrase("Não sabendo que era impossivel, foi lá e", MORNING),
            Phrase("Não sabendo que era impossivel, foi lá e fez.", MORNING)
    )
    fun getPhrase(categoryId: Int) : String{
        val filtered = mListPhrases.filter {
            (it.category == categoryId || categoryId == ALL)
        }

        val rand = Random().nextInt(filtered.size)
        println("Rand é $rand ")

        return filtered[rand].description

    }

}