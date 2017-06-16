package com.bwei.retrofitdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SpanableActivity extends Activity {

    private TextView textView;



    public static int[] resIDs = new int[] { R.mipmap.emo1, R.mipmap.emo2, R.mipmap.emo3, R.mipmap.emo4};

    public static String[] smileArray = { "[干嘛]", "[鼓掌]", "[握手]", "[发疯]"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanable);


        textView = (TextView) findViewById(R.id.textview);


        String content = "你好，[干嘛]吃饭了吗[握手][握手][握手][握手][握手][握手]" ;

        textView.setText(toImageSpan(this,content,resIDs,smileArray));


//        SpannableString spannableString = new SpannableString(content);

//        背景色 BackgroundColorSpan
//        spannableString.setSpan(new BackgroundColorSpan(Color.GRAY),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//        ForegroundColorSpan 前景色
//        spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        //下划线
//        spannableString.setSpan(new UnderlineSpan(),0,4,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        //显示图片
//        Drawable drawable =  getResources().getDrawable(R.mipmap.ic_launcher);
//
//        drawable.setBounds(0,0,50,50);
//
//        spannableString.setSpan(new ImageSpan(drawable),0,1,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        // 加粗 倾斜

//        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),0,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);



        //下标
//        spannableString.setSpan(new SubscriptSpan(),0,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);



//        上标
//        spannableString.setSpan(new SuperscriptSpan(),3,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        //打开网页
//        textView.setMovementMethod(new LinkMovementMethod());
//        spannableString.setSpan(new URLSpan("http://www.baidu.com"),4,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//
//                System.out.println("onClick = " + widget);
//            }
//
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                System.out.println("ds = " + ds);
//                ds.setColor(Color.RED);
//                ds.setUnderlineText(false);
//
//            }
//        };
//
//        spannableString.setSpan(clickableSpan,3,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//
//
//        textView.setText(spannableString);
//
//        textView.setMovementMethod(new LinkMovementMethod());
//


//        EditText editText = (EditText) findViewById(R.id.edit_text) ;
//
//        SpannableString spannableString1 = new SpannableString("1234567890");
//
//        spannableString1.setSpan(new BackgroundColorSpan(Color.GRAY),0,3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//
//
//        editText.setText(spannableString1);




    }



    public static SpannableString toImageSpan(Context context, String content, int[] emoImg, String[] emoText) {
        SpannableString ss = new SpannableString(content);
        for (int i = 0; i < emoText.length; i++) {
            int startPos = 0;
            String rep = emoText[i];
            int fromPos = 0;
            while ((startPos = content.indexOf(rep, fromPos)) != -1) {
                fromPos = startPos + rep.length();
                Bitmap bit = BitmapFactory.decodeResource(context.getResources(),emoImg[i]);

                BitmapDrawable bitmapDrawable = new BitmapDrawable(bit);
                bitmapDrawable.setBounds(0, 0, 50,50);
                ImageSpan span = new ImageSpan(bitmapDrawable);
                ss.setSpan(span, startPos, fromPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return ss;
    }

}
