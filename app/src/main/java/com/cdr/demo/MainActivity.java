package com.cdr.demo;

import android.os.Bundle;
import android.os.HandlerThread;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.test.myapplication.R;
import com.yanzx.lib.demo.SubClass;
import com.yanzx.lib.demo.LagExample;
import com.yanzx.lib.skating.CDT;
import static com.yanzx.lib.skating.GData.TAG;

import com.yanzx.lib.skating.Skt;
import com.yanzx.lib.skating.SktMethodNode;

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

        //初始化CDT
        HandlerThread ht = new HandlerThread("CDT_LOOPER");
        ht.start();

        //CDT需要一个后台线程的Looper, 用来处理耗时方法信息
        CDT.init(ht.getLooper());

        //设置报告生成的路径
        CDT.outputFilePath(
                getExternalFilesDir(null).getAbsolutePath()+"/LagReport.txt");

        //设置"报告"需要关注的包名, 耗时排行的报告将主要关注包名所在的类.
        //CDT.addFilter("com.yanzx.demo");
        //CDT.addFilter("com.yanzx.lib.demo");
        CDT.addFilter("com.yanzx");

        //以"创建"为Tag, 开始监听耗时方法
        CDT.startTrace("TAG_onCreate");

        //监听到某一帧超过 GData.LAG_TIME时, 触发回调
        CDT.setLagListener(new Skt.ILagListener() {
            @Override
            public boolean lagFrame(SktMethodNode lagFrame) {
                Log.e(TAG, "lagFrame");
                lagFrame.print();
                //lagFrame.printAndClear();
                Log.e(TAG, "lagFrame end");
                return true;
            }
        });

        setContentView(R.layout.activity_main);

        new LagExample();

        //输出报告文件到outputFilePath()指定的路径
        CDT.outputLagToFile();

        //开始统计帧率
        CDT.startFpsCount();

        isFPSTracing = true;

        findViewById(R.id.fps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFPSTracing){
                    CDT.endFpsCount();
                    ((Button)findViewById(R.id.fps)).setText("START FPS");
                    isFPSTracing = false;
                }else{
                    CDT.startFpsCount();
                    ((Button)findViewById(R.id.fps)).setText("END FPS");
                    isFPSTracing = true;
                }
            }
        });
    }

    private void lagListTest() {

        //获取当前已经记录的耗时方法
        LinkedList<SktMethodNode> lags = CDT.getLagMethodStack();

        Log.d(TAG, "lagListTest lags:"+lags.size());
        for(SktMethodNode l: lags){
            l.printAndClear();
        }
        Log.e(TAG, "lagListTest end");
        //输出报告文件到CDT.outputFilePath()指定的路径
        CDT.outputLagToFile();
    }

    @Override
    protected void onStart() {
        //此时, 以"开始"为标签, 监听方法耗时.
        CDT.startTrace("TAG_onStart");
        super.onStart();

        final LagExample lagExampe = new LagExample(1);

        findViewById(R.id.text_hello).post(new Runnable() {
            @Override
            public void run() {
                // 制造一个50ms的卡顿
                lagExampe.lagTest1(50);
            }
        });
        findViewById(R.id.text_hello).post(new Runnable() {
            @Override
            public void run() {
                // 制造一个30ms的卡顿
                lagExampe.lagTest1(30);
            }
        });

        findViewById(R.id.text_hello).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 制造一个130ms的卡顿
                lagExampe.lagTest1(130);

                try{
                    // 制造一个130ms的卡顿, 并且抛了一个异常.
                    lagExampe.throwTest(130);
                }catch (Exception e){}

                // 制造一个200ms的卡顿
                lagExampe.lagTest1(200);

                try{
                    // 制造一个90ms的卡顿, 并且抛了一个异常.
                    lagExampe.lagAndThrow(90);
                }catch (Exception e){}

            }
        }, 50);

        findViewById(R.id.text_hello).postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取已经收集到的卡顿, 并打印
                lagListTest();
            }
        }, 500);

        //模拟验证子类调用父类方法造成的卡顿. 统计时, 应该到统计具体的子类名称.
        new SubClass.SubClassClass2().paramThis();
        SubClass.paramThis3(null);
    }

}
