package com.example.apirecycler_jan27.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apirecycler_jan27.databinding.FragmentTodoBinding
import com.example.apirecycler_jan27.view.adapter.TodoAdapter
import com.example.apirecycler_jan27.model.network.ApiManager
import com.example.apirecycler_jan27.model.network.models.Todo
import com.example.apirecycler_jan27.model.repository.TodoRepository
import com.example.apirecycler_jan27.viewmodel.TodoViewModel

class TodoFragment: Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!

    private val viewModel: TodoViewModel by activityViewModels {
        TodoViewModel.Factory(TodoRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            viewModel.todos.observe(viewLifecycleOwner){todos ->
                todoRv.apply {
                    adapter = TodoAdapter(todos as MutableList<Todo>)
                    layoutManager = LinearLayoutManager(requireContext())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}