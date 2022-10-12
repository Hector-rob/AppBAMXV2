package com.application.app.modules.seleccinalimentos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.application.app.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

private const val IMAGE = "image"
private const val NAME = "name"
private const val AMOUNT = "amount"

class articuloFragment() : Fragment() {
    private var image: String? = null
    private var name: String? = null
    private var amount: String? = null

    lateinit var image_view: ImageView
    lateinit var name_text: TextView
    lateinit var amount_text : TextView
    lateinit var lessBtn : Button
    lateinit var plusBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getString(IMAGE)
            name = it.getString(NAME)
            amount = it.getString(AMOUNT)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(
            R.layout.fragment_articulo,
            container,
            false
        )

        image_view = view.findViewById<ImageView>(R.id.imageArticulo)
        Picasso.get().load(image).into(image_view)

        view.findViewById<TextView>(R.id.txtArticulo).apply {
            text = name
        }

        amount_text = view.findViewById(R.id.amount)
        plusBtn = view.findViewById(R.id.plusButton)
        lessBtn = view.findViewById(R.id.lessButton)

        plusBtn.setOnClickListener {
            val prevAmount = amount_text.text.toString().toInt()
            val newAmount = prevAmount + 1
            amount_text.text = newAmount.toString()
            amount = amount_text.text.toString()
        }

        lessBtn.setOnClickListener {
            val prevAmount = amount_text.text.toString().toInt()
            if(prevAmount >= 1){
                val newAmount = prevAmount - 1
                amount_text.text = newAmount.toString()
                amount = amount_text.text.toString()
            }
        }

        return view
    }

    fun getAmount(): Int{
        return amount_text.toString().toInt()
    }

    fun getName(): String?{
        return name
    }


    companion object {
        @JvmStatic
        fun newInstance(image: String, name: String, amount: String): articuloFragment {
            val result = articuloFragment()
            val bundle = Bundle()
            bundle.putString(IMAGE, image)
            bundle.putString(NAME, name)
            bundle.putString(AMOUNT, amount)
            result.arguments = bundle

            return result
        }
    }
}