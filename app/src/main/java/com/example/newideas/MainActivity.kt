package com.example.newideas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import com.example.newideas.databinding.ActivityMainBinding
import kotlin.math.abs


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    lateinit var detector: GestureDetector

    var xStart: Float = 0.0f
    var xEnd: Float = 0.0f
    var yStart: Float = 0.0f
    var yEnd: Float = 0.0f

    private lateinit var binding: ActivityMainBinding

    companion object{
        var MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detector = GestureDetector(this,this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        detector.onTouchEvent(event)

        when(event?.action){

            0 -> {
                xStart = event.x
                yStart = event.y
            }

            1 -> {
                xEnd = event.x
                yEnd = event.y

                var valueX: Float = xEnd - xStart
                var valueY: Float = yEnd - yStart

                if ((abs(valueX)) > MIN_DISTANCE ){
                    if (xEnd > xStart){
                        Toast.makeText(this,"Right Gesture",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Left Gesture",Toast.LENGTH_SHORT).show()
                    }
                }

                if ((abs(valueY)) > MIN_DISTANCE){
                    if (yEnd > yStart){
                        Toast.makeText(this,"Down Gesture",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"UP Gesture",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return super.onTouchEvent(event)
    }



    override fun onDown(e: MotionEvent?): Boolean {
//        Toast.makeText(this,"On Down Gesture",Toast.LENGTH_LONG).show()
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
//        Toast.makeText(this,"On Show Press Gesture",Toast.LENGTH_LONG).show()
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
//        Toast.makeText(this,"On Single Tap UP Gesture",Toast.LENGTH_LONG).show()
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {

        return true
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float
    ): Boolean {
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Toast.makeText(this, "On Double Tap",Toast.LENGTH_LONG).show()
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return false
    }


}