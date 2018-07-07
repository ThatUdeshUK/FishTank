package com.udesh.fishtank.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.udesh.fishtank.R
import com.udesh.fishtank.data.Repository
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val repository: Repository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBehaviour = BottomSheetBehavior.from(bottom_sheet)
        action_toolbar.setOnClickListener {
            bottomBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
        }

        action_add_food.setOnClickListener{
            repository.setOperation(Repository.Operation.FOOD).subscribe({}, {})
        }

        action_change_water.setOnClickListener{
            repository.setOperation(Repository.Operation.WATER).subscribe({}, {})
        }
    }
}
