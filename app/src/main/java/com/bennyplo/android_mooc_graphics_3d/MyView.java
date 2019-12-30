package com.bennyplo.android_mooc_graphics_3d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyView extends View {
    private Paint redPaint,bluePaint,pinkPaint,greenPaint,lightBluePaint; //paint object for drawing the lines
    private Coordinate[]cube_vertices;//the vertices of a 3D cube
    private Coordinate[]draw_cube_vertices;//the vertices for drawing a 3D cube
    public MyView(Context context) {
        super(context, null);
        final MyView thisview=this;
        //create the paint object
        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//Stroke
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(2);

        bluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setStyle(Paint.Style.STROKE);//Stroke
        bluePaint.setColor(Color.BLUE);
        bluePaint.setStrokeWidth(2);

        pinkPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pinkPaint.setStyle(Paint.Style.STROKE);//Stroke
        pinkPaint.setColor(Color.parseColor("#FF4081"));
        pinkPaint.setStrokeWidth(2);

        greenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        greenPaint.setStyle(Paint.Style.STROKE);//Stroke
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStrokeWidth(2);

        lightBluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lightBluePaint.setStyle(Paint.Style.STROKE);//Stroke
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
        thisview.invalidate();//update the view
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
        draw_cube_vertices=translate(cube_vertices,3.8,13.7,0);
        draw_cube_vertices=scale(draw_cube_vertices,60,60,0);
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
        DrawCube(canvas);//draw a cube onto the screen
        DrawCubeHead(canvas);
        DrawLine(canvas);
        DrawCubeLeftHand1(canvas);
        DrawCubeRightHand1(canvas);
        DrawCubeLeftHand2(canvas);
        DrawCubeRightHand2(canvas);
        DrawCubeLeftHand3(canvas);
        DrawCubeRightHand3(canvas);
        DrawCubeMiddle(canvas);
        DrawCubeLeftLeg1(canvas);
        DrawLine1(canvas);
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


}