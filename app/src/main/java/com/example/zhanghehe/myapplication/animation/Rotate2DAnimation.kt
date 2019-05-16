package com.example.zhanghehe.myapplication.animation

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.Transformation

class Rotate2DAnimation(val fromDegreses:Float,val toDegrees:Float,val centerX:Float,val centerY:Float,val depthZ:Float,val reverse:Boolean):Animation(){


    private lateinit var mCamera: Camera

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCamera=Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val degrees=fromDegreses+((toDegrees-fromDegreses)*interpolatedTime)
        val matrix=t?.matrix
        mCamera.save()
        if(reverse){
            mCamera.translate(0.0f,0.0f,depthZ*interpolatedTime)
        }else{
            mCamera.translate(0.0f,0.0f,depthZ*(1.0-interpolatedTime).toFloat())
        }
        mCamera.rotateY(degrees)
        mCamera.getMatrix(matrix)
        mCamera.restore()
        matrix?.preTranslate(-centerX,-centerY)
        matrix?.postTranslate(centerX,centerY)

    }
}