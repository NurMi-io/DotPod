import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val view = findViewById<View>(R.id.colorView) // colorView는 색상을 변경할 뷰의 ID입니다.

        view.setOnClickListener {
            // 랜덤 색상 생성
            val randomColor = Color.argb(
                255, // 알파값
                Random.nextInt(256), // 빨간색 성분
                Random.nextInt(256), // 초록색 성분
                Random.nextInt(256) // 파란색 성분
            )
            view.setBackgroundColor(randomColor) // 배경색 설정
        }
    }
}
