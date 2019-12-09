package jp.ac.asojuku.animalbook


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_title_.*

/**
 * A simple [Fragment] subclass.
 */
class TitleFlagment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_, container, false)
    }

    //外から呼び出してこのフラグメント上のタイトル文字列を変更するメソッド
    fun setTitle(title:String){
        //引き渡された値でタイトル表示の文字列プロパティを上書き
        this.titleText.text = title;
    }

}
