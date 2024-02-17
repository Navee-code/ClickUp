package com.example.clickup.Fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clickup.ViewModels.GroupNoteViewModel
import com.example.clickup.R

class GroupNoteFragment : Fragment() {

    companion object {
        fun newInstance() = GroupNoteFragment()
    }

    private lateinit var viewModel: GroupNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_group_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GroupNoteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}