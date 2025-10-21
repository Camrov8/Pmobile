package pm.pizzaria.pastas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatCheckedTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pm.pizzaria.R
import pm.pizzaria.databinding.ActivityIngredientesBinding

class IngredientesActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityIngredientesBinding.inflate(layoutInflater)
    }

    private lateinit var ingredientes : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listViewIngredientes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ingredientes = resources.getStringArray(R.array.ingredientes)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_multiple_choice,
            ingredientes)

        binding.listViewIngredientes.adapter = adapter
        binding.listViewIngredientes.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        binding.listViewIngredientes.setOnItemClickListener { parent, view, position, id ->
            if( (view as AppCompatCheckedTextView).isChecked ) {
                Toast.makeText(this, ingredientes[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}