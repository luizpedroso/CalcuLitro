package com.luiz.calculitro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Double.parseDouble


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      seekBarEtanol.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
          lbl_calculado_etanol.text = (i / 10.00).toString()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
      })

      seekBarGasolina.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
          lbl_calculado_gasolina.text = (i / 10.00).toString()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
      })

      btn_calcular.setOnClickListener {
        var etanol = parseDouble(lbl_calculado_etanol.text as String)
        var gasolina = parseDouble(lbl_calculado_gasolina.text as String) * 0.70
        if(etanol <= gasolina && (etanol != 0.0 && gasolina != 0.0)){
          lbl_resultado.text = "Abasteça com Etanol"
          lbl_resultado.setTextColor(Color.GREEN)
        }else if(gasolina != 0.0 && etanol != 0.0) {
          lbl_resultado.text = "Abasteça com Gasolina"
          lbl_resultado.setTextColor(Color.RED)
        }else{
          lbl_resultado.text = "### Valor invalido! ###"
          lbl_resultado.setTextColor(Color.BLACK)
        }
      }
    }

}
