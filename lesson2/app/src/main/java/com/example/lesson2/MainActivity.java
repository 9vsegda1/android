package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private double amount = 0.0;
    private double percent = 0.15;
    private EditText et_amount; // Поле для ввода суммы счёта
    private SeekBar sb_percent; // Ползунок для процентов
    private TextView tv_percent; // Поле для значения процента
    private TextView tv_tip; // Поле для суммы чаевых
    private TextView tv_total; // Поле для итоговой суммы

    // Форматировщики денежных сумм и процентов
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private static class tipCalc {
        private double billAmount;
        private double percent;
        private double tip;
        private double total;

        public static double calculateTip(double billAmount, double percent) { return billAmount*percent; }
        public static double calculateTotal(double billAmount, double percent) { return billAmount*(1+percent); }

        public double getBillAmount() { return billAmount; }
        public void setBillAmount(double billAmount) { this.billAmount = billAmount; }

        public double getPercent() { return percent; }
        public void setPercent(double percent) { this.percent = percent; }

        public double getTip() { return tip; }
        public void setTip(double tip) { this.tip = tip; }

        public double getTotal() { return total; }
        public void setTotal(double total) { this.total = total; }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_amount = findViewById(R.id.et_amount);
        sb_percent = findViewById(R.id.sb_percent);
        tv_percent = findViewById(R.id.tv_percent);
        tv_tip = findViewById(R.id.tv_tip);
        tv_total = findViewById(R.id.tv_total);

        tv_tip.setText("0.0");
        tv_total.setText("0.0");

        et_amount.addTextChangedListener(amountTextWatcher);
        sb_percent.setOnSeekBarChangeListener(sbListener);
    }
    private final TextWatcher amountTextWatcher = new TextWatcher() {
        // Вызывается при изменении пользователем величины счета
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                amount = Double.parseDouble(s.toString());
                // Обновление полей с чаевыми и общей суммой
                tv_tip.setText(Double.toString(tipCalc.calculateTip(amount, percent)));
                tv_total.setText(Double.toString(tipCalc.calculateTotal(amount, percent)));
            }catch (Exception e){}
        }
        @Override
        public void afterTextChanged(Editable s) { }
        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener() {
        // Обновление процента чаевых и итоговой суммы
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0; // Назначение процента чаевых
            // Вычисление чаевых и общей суммы. Вывод их на экран.
            tv_percent.setText(percentFormat.format(percent));
            tv_tip.setText(currencyFormat.format(tipCalc.calculateTip(amount,percent)));
            tv_total.setText(currencyFormat.format(tipCalc.calculateTotal(amount, percent)));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    };
}

