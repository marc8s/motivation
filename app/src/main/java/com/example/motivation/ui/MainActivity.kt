package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        //esconder barra de suporte
        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        //logica inicial de seleção
        imageAll.setColorFilter(resources.getColor(R.color.purple_200))
        handleNewPhrase()

        buttonNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

        if(id == R.id.buttonNewPhrase){
            handleNewPhrase()
        }else if(id in listFilter){
            handleFilter(id)
        }

    }

    private fun handleNewPhrase(){
        textPhrase.text = Mock().getPhrase(mPhraseFilter)

    }

    private fun handleFilter(id: Int){

        imageAll.setColorFilter(resources.getColor(R.color.white))
        imageHappy.setColorFilter(resources.getColor(R.color.white))
        imageMorning.setColorFilter(resources.getColor(R.color.white))

        when(id){
            R.id.imageAll ->{
                imageAll.setColorFilter(resources.getColor(R.color.purple_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imageHappy ->{
                imageHappy.setColorFilter(resources.getColor(R.color.purple_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning ->{
                imageMorning.setColorFilter(resources.getColor(R.color.purple_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }

    }
}