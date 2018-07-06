package com.udesh.fishtank.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udesh.fishtank.R
import com.udesh.fishtank.data.Repository
import kotlinx.android.synthetic.main.bottom_sheet.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val repository: Repository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        action_add_food.setOnClickListener{
            repository.setOperation(Repository.Operation.FOOD).subscribe({}, {})
        }

        action_change_water.setOnClickListener{
            repository.setOperation(Repository.Operation.WATER).subscribe({}, {})
        }
    }
}
