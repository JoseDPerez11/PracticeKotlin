package com.dsa.practicekotlin.todoapp.categories

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dsa.practicekotlin.R
import com.dsa.practicekotlin.databinding.ItemTaskCategoryBinding

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemTaskCategoryBinding.bind(view)
    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        binding.viewContainer.setCardBackgroundColor( ContextCompat.getColor(binding.viewContainer.context, color) )

        itemView.setOnClickListener{ onItemSelected(layoutPosition) }

        when(taskCategory) {
            TaskCategory.Business -> {
                binding.tvCategoryName.text = "Negocios"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor( binding.divider.context, R.color.todo_business_category ))
            }
            TaskCategory.Personal -> {
                binding.tvCategoryName.text = "Personal"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor( binding.divider.context, R.color.todo_personal_category ))
            }
            TaskCategory.Programming -> {
                binding.tvCategoryName.text = "Programación"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.todo_programming_category))
            }
            TaskCategory.University -> {
                binding.tvCategoryName.text = "Universidad"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.todo_university_category))
            }
            TaskCategory.Other -> {
                binding.tvCategoryName.text = "Otros"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.todo_other_category))
            }
        }

    }

}