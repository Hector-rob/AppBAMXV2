package com.application.app.modules.recetas.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R


class RecetitaAdapter (private var recetasList: ArrayList<Receta>, val listener: View.OnClickListener) : RecyclerView.Adapter<RecetitaAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetitaAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_new_receta, parent, false)

        itemView.setOnClickListener(listener)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecetitaAdapter.MyViewHolder, position: Int) {

        val receta: Receta = recetasList[position]
        holder.titulo.text = receta.title
        holder.ingredientes.text = receta.ingredients
    }

    override fun getItemCount(): Int {
        return recetasList.size
    }


    public class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val titulo : TextView = itemView.findViewById(R.id.receta_titulo)
        val ingredientes : TextView = itemView.findViewById(R.id.receta_ingredientes)
    }

    public fun setFilteredList(filteredList: ArrayList<Receta>){

        this.recetasList = filteredList

        //recetasList = filteredList

        notifyDataSetChanged()

    }





}

/*
class RecetitaAdapter (var titulos: ArrayList<String>, var ingredientes: ArrayList<String>, var listener: View.OnClickListener):
    RecyclerView.Adapter<RecetitaAdapter.RecetitaViewHolder>(){

    class RecetitaViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var titulo: TextView
        var ingrediente: TextView

        init {
            titulo = itemView.findViewById(R.id.receta_titulo)
            ingrediente = itemView.findViewById(R.id.receta_ingredientes)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_new_receta, parent, false)
        val viewHolder = RecetitaViewHolder(view)

        view.setOnClickListener(listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecetitaViewHolder, position: Int) {

        //aquí un for por elemento en range de 0 a getitemcount y le vas sumando 1

        //for (i in 0 until titulos.size){
            holder.titulo.text = titulos[position]
            holder.ingrediente.text = ingredientes[position]
        //}
        //holder.titulo.text = titulos[1]
        //holder.ingrediente.text = ingredientes[1]

        Log.wtf("Firestore", "adapter: $position")
    }

    override fun getItemCount(): Int {
        return titulos.size
    }
    /*
       Context context;
       ArrayList<Recetita> recetitaArrayList;

       public RecetitaAdapter(Context context, ArrayList<Recetita> recetitaArrayList) {
           this.context = context;
           this.recetitaArrayList = recetitaArrayList;
       }

       @NonNull
       @Override
       public RecetitaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

           View v = LayoutInflater.from(context).inflate(R.layout.row_new_receta, parent, false);
           return new MyViewHolder(v);
       }

       @Override
       public void onBindViewHolder(@NonNull RecetitaAdapter.MyViewHolder holder, int position) {

           Recetita recetita = recetitaArrayList.get(position);
           holder.title.setText(recetita.title);
           holder.ingredients.setText(recetita.ingredients);
       }

       @Override
       public int getItemCount() {
           return recetitaArrayList.size();
       }

       public static  class MyViewHolder extends RecyclerView.ViewHolder{

           TextView title, ingredients;

           public MyViewHolder(@NonNull View itemView) {
               super(itemView);
               title = itemView.findViewById(R.id.receta_titulo);
               ingredients = itemView.findViewById(R.id.receta_ingredientes);


           }
       }

        */
}

 */