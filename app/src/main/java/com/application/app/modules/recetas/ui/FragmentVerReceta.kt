package com.application.app.modules.recetas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.application.app.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val TITULO = "title"
private const val INGREDIENTES = "ingredients"
private const val DESCRIPCION = "description"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentVerReceta.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentVerReceta : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var ingredients: String? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITULO)
            ingredients = it.getString(INGREDIENTES)
            description = it.getString(DESCRIPCION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_ver_receta, container, false)

        view.findViewById<TextView>(R.id.txtH).apply {
            text = title
        }

        view.findViewById<TextView>(R.id.txtDescription2).apply {
            text = ingredients
        }

        view.findViewById<TextView>(R.id.txtDescription3).apply {
            text = description
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, ingredients: String, description: String) =
            FragmentVerReceta().apply {
                arguments = Bundle().apply {
                    putString(TITULO, title)
                    putString(INGREDIENTES, ingredients)
                    putString(DESCRIPCION, description)
                }
            }
    }
}