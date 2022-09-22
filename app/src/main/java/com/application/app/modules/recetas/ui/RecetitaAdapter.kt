package com.application.app.modules.recetas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R

class RecetitaAdapter (var titulos: ArrayList<String>, var ingredientes: ArrayList<String>, var listener: View.OnClickListener):
    RecyclerView.Adapter<RecetitaAdapter.RecetitaViewHolder>(){

    class RecetitaViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var titulo: TextView
        lateinit var ingrediente: TextView

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
        holder.titulo.text = titulos[position]
        holder.ingrediente.text = ingredientes[position]
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