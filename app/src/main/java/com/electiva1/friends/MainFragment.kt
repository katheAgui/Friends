package com.electiva1.friends

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TableRow
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in 0 until tablelayout.childCount) {
            val row = tablelayout.getChildAt(i) as TableRow
            for (j in 0 until row.childCount) {
                val button = row.getChildAt(j) as ImageButton
                button.setOnClickListener{
                    famousClick(it)
                }
            }
        }
    };

    fun famousClick(view: View) {
        val button: ImageButton = view as ImageButton
        val tag: String = button.tag.toString()

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val myIntent = Intent(activity, DetallesActivity::class.java)
            myIntent.putExtra("famous_name", tag)
            startActivity(myIntent)

        } else {
            val detailsFragment = fragmentManager!!.findFragmentById(R.id.famous_detail) as DetallesFragment
            detailsFragment.displayFamous(tag)
        }
    }

}
