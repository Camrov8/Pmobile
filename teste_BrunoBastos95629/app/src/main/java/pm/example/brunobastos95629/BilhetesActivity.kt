package pm.example.brunobastos95629

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pm.example.brunobastos95629.databinding.ActivityBilhetesBinding
import pm.example.brunobastos95629.databinding.ActivityMainBinding

class BilhetesActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityBilhetesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bilhetes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val extras = intent.extras
        if (extras != null) {
            binding.textView2.text = extras.getString("Nome")
            binding.editTextNumber2.text = extras.getString("Bilhetes") as Editable?
        }
    }

}