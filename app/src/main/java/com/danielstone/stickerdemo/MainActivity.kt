package com.danielstone.stickerdemo

import android.graphics.BitmapFactory
import android.graphics.PointF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danielstone.stickerdemo.stickers.MotionView
import com.danielstone.stickerdemo.stickers.entity.ImageEntity
import com.danielstone.stickerdemo.stickers.entity.MotionEntity
import com.danielstone.stickerdemo.stickers.view.Layer

class MainActivity : AppCompatActivity(), MotionView.MotionViewCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motionView = findViewById<MotionView>(R.id.motion_view)

        motionView.setMotionViewCallback(this)

        motionView.post {
            val layer = Layer()
            val pica = BitmapFactory.decodeResource(resources, R.drawable.revive)

            val entity =
                ImageEntity(layer, pica, motionView.width, motionView.height)

            motionView.addEntityAndPosition(entity)
            entity.moveCenterTo(PointF(motionView.width * 0.2f, motionView.height * 0.2f))
        }
    }

    override fun onEntitySelected(entity: MotionEntity?) {

    }

    override fun onEntityDoubleTap(entity: MotionEntity) {

    }
}