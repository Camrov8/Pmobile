package pm.pizzaria.pastas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pm.pizzaria.R
import pm.pizzaria.adapter.ImageAdapter
import pm.pizzaria.databinding.ActivityPizzasBinding

class PizzasActivity : AppCompatActivity() {
    private val bindind by lazy {
        ActivityPizzasBinding.inflate(layoutInflater)
    }

    // referencia para as imagens
    val imagesIds = arrayOf<Int>(
        R.drawable.pizza_1, R.drawable.pizza_2,
        R.drawable.pizza_3, R.drawable.pizza_4,
        R.drawable.pizza_5, R.drawable.pizza_6,
        R.drawable.pizza_7, R.drawable.pizza_8,
        R.drawable.pizza_9, R.drawable.pizza_10,
        R.drawable.pizza_11, R.drawable.pizza_12,
        R.drawable.pizza_13, R.drawable.pizza_14,
        R.drawable.pizza_15, R.drawable.pizza_16,
        R.drawable.pizza_17, R.drawable.pizza_18
    )

    // referencia para os textos
    private val textos = arrayOf(
        "Pizza Indiana", "Pizza Brunch",
        "Pizza Rainha", "Pizza Burguer",
        "Pizza Barbecue", "Pizza Funny Bacon",
        "Pizza Barbecue-Cream", "Pizza Hot Pepperoni",
        "Pizza Crispy Bacon", "Pizza Camarão",
        "Pizza Tuna", "Pizza Europa",
        "Pizza Americana", "Pizza Especial de Cogumelos",
        "Pizza Especial de Cebola", "Pizza Verdini",
        "Pizza Vegetariana", "Pizza Bananás",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)

        bindind.gridViewPizzas.adapter = ImageAdapter(this, imagesIds)

        bindind.gridViewPizzas.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, textos[position], Toast.LENGTH_SHORT).show()
        }
    }
}