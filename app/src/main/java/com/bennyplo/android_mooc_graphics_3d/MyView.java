package com.bennyplo.android_mooc_graphics_3d;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {
    private Paint redPaint,bluePaint,pinkPaint,greenPaint,lightBluePaint; //paint object for drawing the lines
    private Coordinate[]cube_vertices;//the vertices of a 3D cube
    private Coordinate[]draw_cube_vertices;//the vertices for drawing a 3D cube
    private Canvas canvas = null;
    private Animation anim;
    private Activity mContext;

    public MyView(final Activity context) {
        super(context, null);
        this.mContext = context;
        final MyView thisview=this;


        //create the paint object
        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.FILL);//Stroke
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(2);

        bluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setStyle(Paint.Style.FILL);//Stroke
        bluePaint.setColor(Color.BLUE);
        bluePaint.setStrokeWidth(2);

        pinkPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pinkPaint.setStyle(Paint.Style.FILL);//Stroke
        pinkPaint.setColor(Color.parseColor("#FF4081"));
        pinkPaint.setStrokeWidth(2);

        greenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        greenPaint.setStyle(Paint.Style.FILL);//Stroke
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStrokeWidth(2);

        lightBluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lightBluePaint.setStyle(Paint.Style.FILL);//Stroke
        lightBluePaint.setColor(Color.parseColor("#5DD4E3"));
        lightBluePaint.setStrokeWidth(2);

        //create a 3D cube
        cube_vertices = new Coordinate[8];
        cube_vertices[0] = new Coordinate(-1, -1, -1, 1);
        cube_vertices[1] = new Coordinate(-1, -1, 1, 1);
        cube_vertices[2] = new Coordinate(-1, 1, -1, 1);
        cube_vertices[3] = new Coordinate(-1, 1, 1, 1);
        cube_vertices[4] = new Coordinate(1, -1, -1, 1);
        cube_vertices[5] = new Coordinate(1, -1, 1, 1);
        cube_vertices[6] = new Coordinate(1, 1, -1, 1);
        cube_vertices[7] = new Coordinate(1, 1, 1, 1);

        draw_cube_vertices=translate(cube_vertices,4,4,4);
        draw_cube_vertices=scale(draw_cube_vertices,90,60,60);

    }

    private  void DrawLinePairs(Canvas canvas, Coordinate[] vertices, int start, int end, Paint paint)
    {//draw a line connecting 2 points
        //canvas - canvas of the view
        //points - array of points
        //start - index of the starting point
        //end - index of the ending point
        //paint - the paint of the line
        Log.d("MyView", "DrawLinePairs: "+(int)vertices[start].x+"-"+(int)vertices[start].y+"-"+(int)vertices[end].x+"-"+(int)vertices[end].y);

        canvas.drawLine((int)vertices[start].x,(int)vertices[start].y,(int)vertices[end].x,(int)vertices[end].y,paint);
    }

    private void DrawCube(Canvas canvas)
    {//draw a cube on the screen

        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, bluePaint);
    }
    private void DrawCubeHead(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,9,16,4);
        draw_cube_vertices=scale(draw_cube_vertices,40,20,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, pinkPaint);
    }

    private void DrawCubeLeftHand1(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2.7,5.9,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,70,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, bluePaint);
    }

    private void DrawCubeRightHand1(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,11.8,5.9,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,70,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, bluePaint);
    }

    private void DrawCubeRightHand2(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,11.8,7.9,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,70,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, greenPaint);
    }

    private void DrawCubeLeftHand2(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2.7,7.9,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,70,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, greenPaint);
    }


    private void DrawCubeRightHand3(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,11.8,32,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,20,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, lightBluePaint);
    }

    private void DrawCubeLeftHand3(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2.7,32,0);
        draw_cube_vertices=scale(draw_cube_vertices,50,20,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, lightBluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, lightBluePaint);
    }

    private void DrawCubeMiddle(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2,11.7,0);
        draw_cube_vertices=scale(draw_cube_vertices,180,60,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, pinkPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, pinkPaint);
    }

    private void DrawCubeLeftLeg1(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,4,10.5,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,80,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, bluePaint);
    }

    private void DrawCubeRightLeg1(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,8,10.5,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,80,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, bluePaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, bluePaint);
    }

    private void DrawCubeLeftLeg2(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,4,11.2,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,90,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, greenPaint);
    }

    private void DrawCubeRightLeg2(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,8,11.2,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,90,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, greenPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, greenPaint);
    }

    private void DrawCubeLeftFoot(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,4,32.4,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,35,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, redPaint);
    }

    private void DrawCubeRightFoot(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,8,32.4,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,35,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 1, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 3, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 2, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 0, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 4, 5, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 5, 7, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 7, 6, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 6, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 2, 6, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 3, 7, redPaint);
    }


    private void DrawLine(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2,18,4);
        draw_cube_vertices=scale(draw_cube_vertices,180,20,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, redPaint);
    }

    private void DrawLine1(Canvas canvas)
    {//draw a cube on the screen
        draw_cube_vertices=translate(cube_vertices,2,33,4);
        draw_cube_vertices=scale(draw_cube_vertices,180,20,0);
        DrawLinePairs(canvas, draw_cube_vertices, 0, 4, redPaint);
        DrawLinePairs(canvas, draw_cube_vertices, 1, 5, redPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw objects on the screen
        super.onDraw(canvas);
        this.canvas = canvas;
//        //Starts the animation to rotate the circle.
//        if (anim == null) {
//            createAnimationIn(canvas);
//        }
        DrawCube(this.canvas );//draw a cube onto the screen
        DrawCubeHead(this.canvas );
        DrawLine(this.canvas );
        DrawCubeLeftHand1(this.canvas );
        DrawCubeRightHand1(this.canvas );
        DrawCubeLeftHand2(this.canvas );
        DrawCubeRightHand2(this.canvas );
        DrawCubeLeftHand3(this.canvas );
        DrawCubeRightHand3(this.canvas );
        DrawCubeMiddle(this.canvas );
        DrawCubeLeftLeg1(this.canvas );
        DrawCubeRightLeg1(this.canvas );
        DrawCubeLeftLeg2(this.canvas );
        DrawCubeRightLeg2(this.canvas );
        DrawCubeLeftFoot(this.canvas );
        DrawCubeRightFoot(this.canvas );
        DrawLine1(this.canvas );

        //////////////////////////////////////////
        // Add Timer to Enable ANimation...///

        Timer timer = new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                //add your code to rotate the object about the axis
                draw_cube_vertices=rotate(draw_cube_vertices,180,"y");
                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        invalidate();//update the view
                    }
                });

            }
        };
        timer.scheduleAtFixedRate(task,5000,5000);

    }

    private void createAnimationIn(Canvas canvas) {
//        ObjectAnimator animation = ObjectAnimator.ofFloat(canvas, "rotation", 0.0f, 360f);
//        animation.setDuration(36000);
//        animation.setRepeatCount(ObjectAnimator.INFINITE);
//        animation.setInterpolator(new AccelerateDecelerateInterpolator());
//        animation.start();
        anim = new RotateAnimation(0, 360,  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setRepeatMode(Animation.RESTART);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(2000L);
        startAnimation(anim);
    }
    private void createAnimationOut(Canvas canvas) {
//        ObjectAnimator animation = ObjectAnimator.ofFloat(canvas, "rotation", 0.0f, 360f);
//        animation.setDuration(36000);
//        animation.setRepeatCount(ObjectAnimator.INFINITE);
//        animation.setInterpolator(new AccelerateDecelerateInterpolator());
//        animation.start();
        anim = new RotateAnimation(90, 0,  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //anim.setRepeatMode(Animation.RESTART);
        //anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(1000L);
        startAnimation(anim);
    }
    //*********************************
    //matrix and transformation functions
    public double []GetIdentityMatrix()
    {//return an 4x4 identity matrix
        double []matrix=new double[16];
        matrix[0]=1;matrix[1]=0;matrix[2]=0;matrix[3]=0;
        matrix[4]=0;matrix[5]=1;matrix[6]=0;matrix[7]=0;
        matrix[8]=0;matrix[9]=0;matrix[10]=1;matrix[11]=0;
        matrix[12]=0;matrix[13]=0;matrix[14]=0;matrix[15]=1;
        return matrix;
    }
    public Coordinate Transformation(Coordinate vertex,double []matrix)
    {//affine transformation with homogeneous coordinates
        //i.e. a vector (vertex) multiply with the transformation matrix
        // vertex - vector in 3D
        // matrix - transformation matrix
        Coordinate result=new Coordinate();
        result.x=matrix[0]*vertex.x+matrix[1]*vertex.y+matrix[2]*vertex.z+matrix[3];
        result.y=matrix[4]*vertex.x+matrix[5]*vertex.y+matrix[6]*vertex.z+matrix[7];
        result.z=matrix[8]*vertex.x+matrix[9]*vertex.y+matrix[10]*vertex.z+matrix[11];
        result.w=matrix[12]*vertex.x+matrix[13]*vertex.y+matrix[14]*vertex.z+matrix[15];
        return result;
    }
    public Coordinate[]Transformation(Coordinate []vertices,double []matrix)
    {   //Affine transform a 3D object with vertices
        // vertices - vertices of the 3D object.
        // matrix - transformation matrix
        Coordinate []result=new Coordinate[vertices.length];
        for (int i=0;i<vertices.length;i++)
        {
           result[i]=Transformation(vertices[i],matrix);
           result[i].Normalise();
        }
        return result;
    }
    //***********************************************************
    //Affine transformation
    public Coordinate []translate(Coordinate []vertices,double tx,double ty,double tz)
    {
        double []matrix=GetIdentityMatrix();
        matrix[3]=tx;
        matrix[7]=ty;
        matrix[11]=tz;
        return Transformation(vertices,matrix);
    }
    private Coordinate[]scale(Coordinate []vertices,double sx,double sy,double sz)
    {
        double []matrix=GetIdentityMatrix();
        matrix[0]=sx;
        matrix[5]=sy;
        matrix[10]=sz;
        return Transformation(vertices,matrix);
    }

    private Coordinate[]share(Coordinate []vertices,double hx,double hy)
    {
        double []matrix=GetIdentityMatrix();
        matrix[2]=hx;
        matrix[6]=hy;
        return Transformation(vertices,matrix);
    }
    private Coordinate[]rotate(Coordinate []vertices,int angle,String axis)
    {
        double []matrix=GetIdentityMatrix();
        if(axis.contentEquals("x")) {
            matrix[5] = Math.cos(angle);
            matrix[6] = -(Math.sin(angle));
            matrix[9] = Math.sin(angle);
            matrix[10] = Math.cos(angle);
        }else if(axis.contentEquals("y")){
            matrix[0] = Math.cos(angle);
            matrix[2] = Math.sin(angle);
            matrix[8] = -(Math.sin(angle));
            matrix[10] = Math.cos(angle);
        }else if(axis.contentEquals("z")){
            matrix[0] =  Math.cos(angle);
            matrix[1] = -(Math.sin(angle));
            matrix[4] = Math.sin(angle);
            matrix[5] = Math.cos(angle);
        }
        return Transformation(vertices,matrix);
    }


}