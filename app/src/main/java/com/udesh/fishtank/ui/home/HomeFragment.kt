package com.udesh.fishtank.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.udesh.fishtank.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.apply {
            response.observe(this@HomeFragment, Observer {
                it?.let {
                    it.feeds?.let {
                        // Water Level
                        val waterLevel = it[it.size - 1].waterLevel
                        if (waterLevel != null)
                            water_tv.text = "$waterLevel%"
                        else
                            water_tv.text = "N/A"

                        // Pressure
                        val pressure = it[it.size - 1].pressure
                        if (pressure != null)
                            pressure_tv.text = "$pressure"
                        else
                            pressure_tv.text = "N/A"

                        // pH
                        val ph = it[it.size - 1].ph
                        if (ph != null)
                            ph_tv.text = "$ph"
                        else
                            ph_tv.text = "N/A"

                        // o2
                        val o2 = it[it.size - 1].o2
                        if (o2 != null)
                            o2_tv.text = "$o2"
                        else
                            o2_tv.text = "N/A"

                        // temp
                        val temp = it[it.size - 1].temperature
                        if (temp != null)
                            temp_tv.text = "$temp C"
                        else
                            temp_tv.text = "N/A"

                        // food
                        val food = it[it.size - 1].foodLeft
                        if (food != null)
                            food_tv.text = "$food%"
                        else
                            food_tv.text = "N/A"
                    }
                }
            })
            error.observe(this@HomeFragment, Observer {
                Toast.makeText(context, "Error $it", Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadFeeds()
    }

    override fun onStop() {
        super.onStop()
        viewModel.dispose()
    }

}
