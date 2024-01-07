package com.dsa.practicekotlin.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsa.practicekotlin.databinding.ActivityTodoBinding
import com.dsa.practicekotlin.todoapp.categories.CategoryAdapter
import com.dsa.practicekotlin.todoapp.categories.TaskCategory
import com.dsa.practicekotlin.todoapp.categories.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding

    private val categories = listOf(
        Business,
        Personal,
        Programming,
        University,
        Other
    )

    private lateinit var categoryAdapter: CategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        categoryAdapter = CategoryAdapter(categories) { position -> updateCategories(position) }
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoryAdapter
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoryAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
    }

}