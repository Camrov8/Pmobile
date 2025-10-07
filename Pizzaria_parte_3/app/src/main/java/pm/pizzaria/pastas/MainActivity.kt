package pm.pizzaria.pastas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pm.pizzaria.R
import pm.pizzaria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listViewIngredientes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.materialToolbar)
    }

    fun verIngredientes(view: View) {
        startActivity(Intent(this, IngredientesActivity::class.java))
    }
    fun verPizzas(view: View) {
        startActivity(Intent(this, PizzasActivity::class.java))
    }
    fun verPastas(view: View) {
        startActivity(Intent(this, PastasActivity::class.java))
    }
    fun verSobremesas(view: View) {

    }
}