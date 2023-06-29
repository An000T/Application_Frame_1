package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()

        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

    }
    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film", film)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()

    }

    private fun initNavigation() {
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

//        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
//        topAppBar.setOnMenuItemClickListener {
//            when (it.itemId) {
//                R.id.settings -> {
//                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> false
//            }
//        }
//
//        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottom_navigation.setOnNavigationItemSelectedListener {
//
//            when (it.itemId) {
//                R.id.favorites -> {
//                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.watch_later -> {
//                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.selections -> {
//                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> false
//            }






    }

}
class TopSpacingItemDecoration (private val paddingInDp: Int): RecyclerView.ItemDecoration() {
    private val Int.convertPx: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = paddingInDp.convertPx
        outRect.right = paddingInDp.convertPx
        outRect.left = paddingInDp.convertPx

    }
}

