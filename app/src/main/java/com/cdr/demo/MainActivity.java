package com.cdr.demo;

import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import com.test.demo.R;
//import com.yanzx.lib.demo.LagExample;
//import com.yanzx.lib.demo.SubClass;
//import com.yanzx.lib.skating.CDR;
//import com.yanzx.lib.skating.Skt;
//import com.yanzx.lib.skating.SktMethodNode;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    boolean isFPSTracing = false;

    /**
     * //监听到一帧超过{@link com.yanzx.lib.skating.GData#LAG_TIME}
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //初始化Skt
//        HandlerThread ht = new HandlerThread("SKT_LOOPER");
//        ht.start();
//
//        //SKT需要一个后台线程的Looper, 用来处理耗时方法信息
//        CDR.init(ht.getLooper());
//
//        //设置报告生成的路径
//        CDR.outputFilePath(
//                getExternalFilesDir(null).getAbsolutePath()+"/LagReport.txt");
//
//        //设置"报告"需要关注的包名, 耗时排行的报告将主要关注包名所在的类.
//        //Skt.addFilter("com.yanzx.demo");
//        //Skt.addFilter("com.yanzx.lib.demo");
//        CDR.addFilter("com.yanzx");
//
//        //以"创建"为Tag, 开始监听耗时方法
//        CDR.startTrace("TAG_onCreate");
//
//        //监听到某一帧超过 GData.LAG_TIME时, 触发回调
//        CDR.setLagListener(new Skt.ILagListener() {
//            @Override
//            public boolean lagFrame(SktMethodNode lagFrame) {
//                Log.e("SKT", "lagFrame");
//                lagFrame.print();
//                //lagFrame.printAndClear();
//                Log.e("SKT", "lagFrame end");
//                return true;
//            }
//        });
//
//        setContentView(R.layout.activity_main);
//
//        new LagExample();
//
//        //输出报告文件到outputFilePath()指定的路径
//        CDR.outputLagToFile();
//
//        //开始统计帧率
//        CDR.startFpsCount();
//
//        isFPSTracing = true;
//
//        findViewById(R.id.fps).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isFPSTracing){
//                    CDR.endFpsCount();
//                    ((Button)findViewById(R.id.fps)).setText("START FPS");
//                    isFPSTracing = false;
//                }else{
//                    CDR.startFpsCount();
//                    ((Button)findViewById(R.id.fps)).setText("END FPS");
//                    isFPSTracing = true;
//                }
//            }
//        });
    }

    private void lagListTest() {

//        //获取当前已经记录的耗时方法
//        LinkedList<SktMethodNode> lags = CDR.getLagMethodStack();
//
//        Log.d("SKT", "lagListTest lags:"+lags.size());
//        for(SktMethodNode l: lags){
//            l.printAndClear();
//        }
//        Log.e("SKT", "lagListTest end");
//        //输出报告文件到Skt.outputFilePath()指定的路径
//        CDR.outputLagToFile();
    }

    @Override
    protected void onStart() {
//        //此时, 以"开始"为标签, 监听方法耗时.
//        CDR.startTrace("TAG_onStart");
        super.onStart();
//
//        final LagExample lagExampe = new LagExample(1);
//
//        findViewById(R.id.text_hello).post(new Runnable() {
//            @Override
//            public void run() {
//                // 制造一个50ms的卡顿
//                lagExampe.lagTest1(50);
//            }
//        });
//        findViewById(R.id.text_hello).post(new Runnable() {
//            @Override
//            public void run() {
//                // 制造一个30ms的卡顿
//                lagExampe.lagTest1(30);
//            }
//        });
//
//        findViewById(R.id.text_hello).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // 制造一个130ms的卡顿
//                lagExampe.lagTest1(130);
//
//                try{
//                    // 制造一个130ms的卡顿, 并且抛了一个异常.
//                    lagExampe.throwTest(130);
//                }catch (Exception e){}
//
//                // 制造一个200ms的卡顿
//                lagExampe.lagTest1(200);
//
//                try{
//                    // 制造一个90ms的卡顿, 并且抛了一个异常.
//                    lagExampe.lagAndThrow(90);
//                }catch (Exception e){}
//
//            }
//        }, 50);
//
//        findViewById(R.id.text_hello).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //获取已经收集到的卡顿, 并打印
//                lagListTest();
//            }
//        }, 500);
//
//        //模拟验证子类调用父类方法造成的卡顿. 统计时, 应该到统计具体的子类名称.
//        new SubClass.SubClassClass2().paramThis();
//        SubClass.paramThis3(null);
    }

}
