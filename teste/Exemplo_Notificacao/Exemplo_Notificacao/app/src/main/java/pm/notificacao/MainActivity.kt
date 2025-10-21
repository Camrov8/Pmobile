package pm.notificacao

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun lancarNotificacao(view: View) {
        val channelId = "ua"
        val notificationId = 123
        val notificationManager = getSystemService(NotificationManager::class.java)

        // 0. Redirecionar + Envio de dados
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("id",notificationId)
            putExtra("titulo","Nova notificação")
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // 1. Criar a notificação
        val logo = BitmapFactory.decodeResource(resources, R.drawable.ua)
        val notification = NotificationCompat.Builder(this, channelId)
            .setLargeIcon(logo)
            .setSmallIcon(R.drawable.ua)
            .setContentTitle("Teste de notificação")
            .setContentText("Exemplo")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        // 2. Criar o canal
        val channel = NotificationChannel(
            channelId,
            "Prog. Mobile",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Exemplo de notificações"
        }
        notificationManager.createNotificationChannel(channel)

        // 3. Lançar a notificação
        notificationManager.notify(notificationId, notification)
    }
}