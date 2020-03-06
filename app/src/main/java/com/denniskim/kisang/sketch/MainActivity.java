package com.denniskim.kisang.sketch;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import android.app.AlertDialog;
import  android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smallestBrush = getResources().getInteger(R.integer.smallest_size);
        smallerBrush = getResources().getInteger(R.integer.smaller_size);
        smallBrush = getResources().getInteger(R.integer.small_size);
        moremediumBrush=getResources().getInteger(R.integer.moremedium_size);
        mostmediumBrush=getResources().getInteger(R.integer.mostmedium_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
        largerBrush=getResources().getInteger(R.integer.morelarge_size);
        largestBrush=getResources().getInteger(R.integer.mostlarge_size);
        setContentView(R.layout.activity_main);
        drawView = (DrawingView) findViewById(R.id.drawing);
        drawBtn = (ImageButton) findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);
        drawView.setBrushSize(mostmediumBrush);
        eraseBtn = (ImageButton) findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);
        newBtn = (ImageButton) findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);
        saveBtn = (ImageButton) findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);
        colorPallet =(ImageButton) findViewById(R.id.colorPallete);
        colorPallet.setColorFilter(Color.parseColor("#8ec9ef"));
        colorPallet.setOnClickListener(this);
        checkStoragePermission();
    }

    private DrawingView drawView;
    private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn, colorPallet;
    private float smallBrush, smallerBrush, smallestBrush,mostmediumBrush,moremediumBrush,mediumBrush,largeBrush,largerBrush,largestBrush;
    final int PERMISSION_REQUEST_CODE=1;

    //requesting storage permission
    private void checkStoragePermission(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            //do nothing
        }else{
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onClick(View view) {
        //respond to clicks
        if (view.getId() == R.id.draw_btn) {
            //draw button clicked
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Brush size");
            brushDialog.setContentView(R.layout.brush_chooser);
            ImageButton smallestBtn = (ImageButton) brushDialog.findViewById(R.id.smallest_brush);
            smallestBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(smallestBrush);
                    drawView.setLastBrushSize(smallestBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton smallerBtn = (ImageButton) brushDialog.findViewById(R.id.smaller_brush);
            smallerBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(smallerBrush);
                    drawView.setLastBrushSize(smallerBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton smallBtn = (ImageButton) brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(smallBrush);
                    drawView.setLastBrushSize(smallBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton mostmediumBtn = (ImageButton) brushDialog.findViewById(R.id.mostmedium_brush);
            mostmediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(mostmediumBrush);
                    drawView.setLastBrushSize(mostmediumBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton moremediumBtn = (ImageButton) brushDialog.findViewById(R.id.moremedium_brush);
            moremediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(moremediumBrush);
                    drawView.setLastBrushSize(moremediumBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton) brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(mediumBrush);
                    drawView.setLastBrushSize(mediumBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton) brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(largeBrush);
                    drawView.setLastBrushSize(largeBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton largerBtn = (ImageButton) brushDialog.findViewById(R.id.larger_brush);
            largerBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(largerBrush);
                    drawView.setLastBrushSize(largerBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton largestBtn = (ImageButton) brushDialog.findViewById(R.id.largest_brush);
            largestBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setBrushSize(largestBrush);
                    drawView.setLastBrushSize(largestBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
        } else if (view.getId() == R.id.erase_btn) {
            //switch to erase-chose size
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Eraser size:");
            brushDialog.setContentView(R.layout.brush_chooser);
            ImageButton smallestBtn = (ImageButton) brushDialog.findViewById(R.id.smallest_brush);
            smallestBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallestBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton smallerBtn = (ImageButton) brushDialog.findViewById(R.id.smaller_brush);
            smallerBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallerBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton smallBtn = (ImageButton) brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mostmediumBtn = (ImageButton) brushDialog.findViewById(R.id.mostmedium_brush);
            mostmediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mostmediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton moremediumBtn = (ImageButton) brushDialog.findViewById(R.id.moremedium_brush);
            moremediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(moremediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton) brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton) brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largerBtn = (ImageButton) brushDialog.findViewById(R.id.larger_brush);
            largerBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largerBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largestBtn = (ImageButton) brushDialog.findViewById(R.id.largest_brush);
            largestBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largestBrush);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
        } else if (view.getId() == R.id.new_btn) {
            //new button
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("New drawing");
            newDialog.setMessage("Start new drawing?");
            newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    drawView.startNew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();
        } else if (view.getId() == R.id.save_btn) {
            //save drawing
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device gallery?");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialog, int which) {
                        try {
                            drawView.setDrawingCacheEnabled(true);
                            Bitmap bitmap = drawView.getDrawingCache();
                            File image = null;
                            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                                File file = new File(Environment.getExternalStorageDirectory(), "Sketch");
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                //calendar instance to get time in milliseconds
                                Calendar calendar = Calendar.getInstance();
                                image = new File(file.getAbsolutePath() + file.separator + ("Sketch-" + calendar.getTimeInMillis()) + ".png");
                                Toast savedToast = Toast.makeText(getApplicationContext(), "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                                savedToast.show();

                                FileOutputStream ostream = new FileOutputStream(image);
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                                ostream.flush();
                                ostream.close();
                                MediaScannerConnection.scanFile(getApplicationContext(), new String[]{image.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                                    public void onScanCompleted(String path, Uri uri) {
                                        //scanned successfully
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "Oops! Image could not be saved,restart app and allow storage ", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                    }

            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            saveDialog.show();
        } else if (view.getId() == R.id.colorPallete) {
            final Dialog chooseColor = new Dialog(this);


            chooseColor.setContentView(R.layout.painto_show);
            LinearLayout paintLayout = (LinearLayout) chooseColor.findViewById(R.id.paint_colors);
             currPaint = (ImageButton) paintLayout.getChildAt(0);
            //Button onClicks
          ImageButton color1=(ImageButton)  chooseColor.findViewById(R.id.color1);
            color1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view == currPaint) {
                        chooseColor.dismiss();
                    }
                }
            });
            final ImageButton color2=(ImageButton)  chooseColor.findViewById(R.id.color2);
            color2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color3=(ImageButton)  chooseColor.findViewById(R.id.color3);
            color3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                        //use chosen color
                        drawView.setErase(false);
                        drawView.setBrushSize(drawView.getLastBrushSize());
                        if (view != currPaint) {
                            //updateColor
                            ImageButton imgView = (ImageButton) view;
                            String color = view.getTag().toString();
                            drawView.setColor(color);
                            colorPallet.setColorFilter(Color.parseColor(color));
                            imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                            currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                            currPaint = (ImageButton) view;
                            chooseColor.dismiss();
                    }
                }
            });
            ImageButton color4=(ImageButton)  chooseColor.findViewById(R.id.color4);
            color4.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color5=(ImageButton)  chooseColor.findViewById(R.id.color5);
            color5.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color6=(ImageButton)  chooseColor.findViewById(R.id.color6);
            color6.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color7=(ImageButton)  chooseColor.findViewById(R.id.color7);
            color7.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color8=(ImageButton)  chooseColor.findViewById(R.id.color8);
            color8.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color9=(ImageButton)  chooseColor.findViewById(R.id.color9);
            color9.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color10=(ImageButton)  chooseColor.findViewById(R.id.color10);
            color10.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                        //use chosen color
                        drawView.setErase(false);
                        drawView.setBrushSize(drawView.getLastBrushSize());
                        if (view != currPaint) {
                            //updateColor
                            ImageButton imgView = (ImageButton) view;
                            String color = view.getTag().toString();
                            drawView.setColor(color);
                            colorPallet.setColorFilter(Color.parseColor(color));
                            imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                            currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                            currPaint = (ImageButton) view;
                    }
                    chooseColor.dismiss();
                }
            });
            ImageButton color11=(ImageButton)  chooseColor.findViewById(R.id.color11);
            color11.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color12=(ImageButton)  chooseColor.findViewById(R.id.color12);
            color12.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color13=(ImageButton)  chooseColor.findViewById(R.id.color13);
            color13.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color14=(ImageButton)  chooseColor.findViewById(R.id.color14);
            color14.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color15=(ImageButton)  chooseColor.findViewById(R.id.color15);
            color15.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color16=(ImageButton)  chooseColor.findViewById(R.id.color16);
            color16.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color17=(ImageButton)  chooseColor.findViewById(R.id.color17);
            color17.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            ImageButton color18=(ImageButton)  chooseColor.findViewById(R.id.color18);
            color18.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use chosen color
                    drawView.setErase(false);
                    drawView.setBrushSize(drawView.getLastBrushSize());
                    if (view != currPaint) {
                        //updateColor
                        ImageButton imgView = (ImageButton) view;
                        String color = view.getTag().toString();
                        drawView.setColor(color);
                        colorPallet.setColorFilter(Color.parseColor(color));
                        imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint_pressed,null));
                        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.paint,null));
                        currPaint = (ImageButton) view;
                        chooseColor.dismiss();
                    }
                }
            });
            chooseColor.show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults){
if(requestCode== PERMISSION_REQUEST_CODE){
    if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
        Toast.makeText(getApplicationContext(),"Storage Permission granted",Toast.LENGTH_SHORT);
    }else{
        Toast.makeText(getApplicationContext(),"Storage Permission denied",Toast.LENGTH_SHORT);
    }
}
    }
}
