package ru.example.studentdatastore

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import ru.example.studentdatastore.adapter.ListAdapter

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lifecycleScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.headManFlow.collectOnCreate(this) { headman ->
            val textView = findViewById<TextView>(R.id.headman_text)
            textView.text = if(headman == null) "No data" else {
                String.format("%s group: %s, university: %s", headman.student.name, headman.group.name, headman.university.name)
            }
        }
        viewModel.groupsFlow.collectOnCreate(this) { groups ->
            val groupsRecycler = findViewById<RecyclerView>(R.id.groups_recycler)
            groupsRecycler.layoutManager = LinearLayoutManager(this)
            groupsRecycler.adapter = ListAdapter(groups) { view ->
                val id = view.tag as Long
                viewModel.onChangeGroupClicked(id)
            }
        }

        viewModel.universitiesFlow.collectOnCreate(this) { universities ->
            val universityRecycler = findViewById<RecyclerView>(R.id.universities_recycler)
            universityRecycler.layoutManager = LinearLayoutManager(this)
            universityRecycler.adapter = ListAdapter(universities) { view ->
                val id = view.tag as Long
                viewModel.onChangeUniversityClicked(id)
            }
        }

        val loadButton = findViewById<Button>(R.id.load_button)
        loadButton.setOnClickListener { viewModel.onLoadDataClicked()}
    }
}