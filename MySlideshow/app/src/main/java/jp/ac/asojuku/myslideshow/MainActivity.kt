package jp.ac.asojuku.myslideshow

import android.media.AsyncPlayer
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    //MediaPlayer用の変数（プロパティ）
    private lateinit var player: MediaPlayer;

    //pagerを操作するために必要なアダプタークラスを内部クラスとして用意する
    class MyAdapter(fm: FragmentManager):FragmentPagerAdapter(fm){

        //アダプターに画像の情報を保持しておく
        //画像のリソースIDのリストを作る

        //ここでは定義しているがデータベースなどから読み込むのが普通
        private val resources = listOf(
            R.drawable.slide00,
            R.drawable.slide01,
            R.drawable.slide02,
            R.drawable.slide03,
            R.drawable.slide04,
            R.drawable.slide05,
            R.drawable.slide06,
            R.drawable.slide07,
            R.drawable.slide08,
            R.drawable.slide09
        );

        //指定されたページ番号（position）に相当するページのインスタンスを返す
        //ページが、今回はページのフラグメントのインスタンス
        override fun getItem(position: Int): Fragment {
            //ページ番号をリソースIDとして引き渡してImageFragmentのインスタンスを生成、リターン
            return ImageFragment.newInstance(resources[position]);
        }

        //アダプターが保持している全データ数（要素数）を返す
        override fun getCount(): Int {
            return resources.size;//resourcesリストの要素数

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //画面クラスに配置されたPagerViewのadapterプロパティに
        //このクラスも内部クラスで定義したMyAdapterのインスタンスを設定する
        this.pager.adapter = MyAdapter(this.supportFragmentManager);

        //画面のインスタンスが生成されると、タイマーのスレッドも起動させる
        //Handlerインスタンスを取得
        val handler = Handler();
        //timer処理のスレッドを起こす(5000ミリ秒間隔でタイマータスクと呼ばれる処理を実行)
        kotlin.concurrent.timer(period = 5000){
            //提起的に実行したい処理（TimerTask）
            //handlerでページャーを進める処理を実行する
            handler.post(
                //Runnableインターフェースを実装した著名クラス
                object:Runnable{
                    //実行するrunメソッド
                    override fun run() {
                        //メインスレッドの中で実行する処理を
                        //ページャーのcurrentItem(ページ番号を1つ集める。10を超えたら0に戻る)
                        //10%10=0 9%10=9 0%10=0 1%10=1//
                        pager.currentItem = (pager.currentItem + 1) % 10;
                    }
                }
            )
        }
        //MediaPlayerの変数にインスタンスを設定する
        //第一引数:次画面のインスタンス、第二引数:サウンドファイル
        this.player = MediaPlayer.create(this,R.raw.getdown);
        //BGMとしてループ再生をONにする
        this.player.isLooping = true;
    }
    //画面が表示・再表示された時のいべんとコールバックメソッド
    override fun onResume() {
        super.onResume()
        //playerのサウンドファイル再生をスタート
        this.player.start();
    }

    //画面が非表示になるときのイベントコールバックメソッド
    override fun onPause() {
        super.onPause()
        //playerのサウンドファイル再生をストップ
        this.player.pause();//一時停止
    }
}
