package pm.example.pizza

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IngredientesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingredientes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listviewingredientes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ListView>(R.id.listviewingredientes).setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()

        }
    }
}