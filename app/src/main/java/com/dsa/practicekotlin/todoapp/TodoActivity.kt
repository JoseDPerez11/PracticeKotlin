package com.dsa.practicekotlin.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsa.practicekotlin.R
import com.dsa.practicekotlin.databinding.ActivityTodoBinding
import com.dsa.practicekotlin.todoapp.categories.CategoryAdapter
import com.dsa.practicekotlin.todoapp.categories.TaskCategory
import com.dsa.practicekotlin.todoapp.categories.TaskCategory.*
import com.dsa.practicekotlin.todoapp.tasks.Task
import com.dsa.practicekotlin.todoapp.tasks.TaskAdapter

class TodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding

    private val categories = listOf(
        Business,
        Personal,
        Programming,
        University,
        Other
    )

    private val tasks = mutableListOf(
        Task("TaskTestBusiness", TaskCategory.Business),
        Task("TaskTestPersonal", TaskCategory.Personal),
        Task("TaskTestOther", TaskCategory.Other)
    )

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var taskAdapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        binding.fabAddTask.setOnClickListener{ showDialog() }
    }

    private fun initUI() {

        categoryAdapter = CategoryAdapter(categories) { position -> updateCategories(position) }
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoryAdapter

        taskAdapter = TaskAdapter(tasks) { position -> onItemSelected(position) }
        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = taskAdapter

    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoryAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTasks() {
        // Filtrar las categorías seleccionadas
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }

        // Filtrar las tareas basadas en las categorías seleccionadas
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }

        // Actualizar las tareas en el adaptador y notificar cambios
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener{
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when(selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    getString(R.string.todo_dialog_category_university) -> University
                    getString(R.string.todo_dialog_category_programming) -> Programming
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()

    }

}