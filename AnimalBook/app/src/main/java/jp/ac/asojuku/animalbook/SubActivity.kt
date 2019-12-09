package jp.ac.asojuku.animalbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }

    //画面の表示・再表示のイベントのコールバックメソッド
    override fun onResume() {
        super.onResume()
        //ライオンボタンがクリックされた時のコールバックメソッドのリスナーを設定
        this.lionButton.setOnClickListener {
            //クリックされた時の処理
            val fragment = LionFragment();//ライオンフラグメントクラスのインスタンスを生成
            //このがめんを操作できるフラグメントマネージャーを取得
            val fragmentManager= this.supportFragmentManager;//変数に代入
            //フラグメント切り替えのためにフラグメント操作のトランザクションを開始
            val fragmentTransaction= fragmentManager.beginTransaction();
            //トランザクションは開始されたので、フラグメントに関する操作をしていく
            //fragmentTransaction.replace(R.id.container,fragment).チェーンできる
            fragmentTransaction.replace(R.id.container,fragment) //画面の「id:container」部分にフラグメントを切り替え
                .addToBackStack(null) //元のフラグメントをバックスタックに保存（今回は何もしない）
                .commit();//トランザクション終了
        }

        //カバボタンがクリックされた時のコールバックメソッドのリスナーを設定
        this.hippoButton.setOnClickListener {
            //クリックされた時の処理
            val fragment = HippoFragment();//カバフラグメントクラスのインスタンスを生成
            //このがめんを操作できるフラグメントマネージャーを取得
            val fragmentManager= this.supportFragmentManager;//変数に代入
            //フラグメント切り替えのためにフラグメント操作のトランザクションを開始
            val fragmentTransaction= fragmentManager.beginTransaction();
            //トランザクションは開始されたので、フラグメントに関する操作をしていく
            //fragmentTransaction.replace(R.id.container,fragment).チェーンできる
            fragmentTransaction.replace(R.id.container,fragment) //画面の「id:container」部分にフラグメントを切り替え
                .addToBackStack(null) //元のフラグメントをバックスタックに保存（今回は何もしない）
                .commit();//トランザクション終了
        }

        //キリンボタンがクリックされた時のコールバックメソッドのリスナーを設定
        this.giraffeButton.setOnClickListener {
            //クリックされた時の処理
            val fragment = GiraffeFragment();//カバフラグメントクラスのインスタンスを生成
            //このがめんを操作できるフラグメントマネージャーを取得
            val fragmentManager = this.supportFragmentManager;//変数に代入
            //フラグメント切り替えのためにフラグメント操作のトランザクションを開始
            val fragmentTransaction = fragmentManager.beginTransaction();
            //トランザクションは開始されたので、フラグメントに関する操作をしていく
            //fragmentTransaction.replace(R.id.container,fragment).チェーンできる
            fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」部分にフラグメントを切り替え
                .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない）
                .commit();//トランザクション終了
        }

        //メイン画面へ戻るボタンがクリックされたイベントのコールバックメソッドを設定
        this.backButton.setOnClickListener {
            //ボタンがクリックされた時の処理
            //画面を破棄することで前の画面を表示する
            this.finish(); //自分自身を破棄するためのメソッドを実行
        }
        

        //タイトルフラグメントのタイトル文字列を設定
        val fragment = this.titleFragmenr as? TitleFlagment;//タイトルフラグメントを扱う変数
        fragment?.setTitle("図鑑画面");//自作メソッド（タイトル文字設定）を実行


    }
}
