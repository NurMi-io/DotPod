package com.nurmi.dotpod

object NothingScript {
    fun controlDevice() {
        println("Device control logic here")
        
        class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            // 여기에 FAB 클릭 시 실행할 코드를 작성하세요.
            Toast.makeText(this, "FAB 클릭됨", Toast.LENGTH_SHORT).show()
        }
    }
        }
    }
}
