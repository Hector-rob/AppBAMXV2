package com.application.app.modules.recetas.ui

import android.content.Intent
import android.os.Bundle
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.application.app.R
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val TITULO = "title"
private const val INGREDIENTES = "ingredients"
private const val DESCRIPCION = "description"
private const val IMAGEN = "image"
private const val LINK = "link"

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
    private var image: String? = null
    private var link: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITULO)
            ingredients = it.getString(INGREDIENTES)
            description = it.getString(DESCRIPCION)
            image = it.getString(IMAGEN)
            link = it.getString(LINK)
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

        view.findViewById<ImageView>(R.id.imageView).apply {
            Glide.with(this).load(image).into(view.findViewById<ImageView>(R.id.imageView))
        }

        view.findViewById<TextView>(R.id.link).apply {
            text = link
        }





        return view
    }



    companion object {
        @JvmStatic
        fun newInstance(title: String, ingredients: String, description: String, image: String, link: String) =
            FragmentVerReceta().apply {
                arguments = Bundle().apply {
                    putString(TITULO, title)
                    putString(INGREDIENTES, ingredients)
                    putString(DESCRIPCION, description)
                    putString(IMAGEN, image)
                    putString(LINK, link)
                }
            }
    }

}