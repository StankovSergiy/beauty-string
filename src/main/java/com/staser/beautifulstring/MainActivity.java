package com.staser.beautifulstring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.staser.beautifulstring.commons.Common;
import com.staser.beautifulstring.converters.Converter;
import com.staser.beautifulstring.preparsers.InputText;
import com.staser.beautifulstring.preparsers.ReadyToConvert;
import com.staser.beautifulstring.models.Sentence;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInput;
    private Button btnConvert;
    private Button btnClean;
    private TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initViewElements();
        this.setListeners();

    }

    /**
     * view elements initialisation
     */
    private void initViewElements() {

        this.etInput = (EditText) findViewById(R.id.et_input);
        this.btnConvert = (Button) findViewById(R.id.btn_convert);
        this.btnClean = (Button) findViewById(R.id.btn_clean);
        this.tvOutput = (TextView) findViewById(R.id.tv_output);
    }

    /**
     * view elements listeners setting
     */
    private void setListeners() {

        this.btnConvert.setOnClickListener(this);
        this.btnClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_convert:
                this.convertString();
                break;

            case R.id.btn_clean:
                this.cleanAllViewsElements();
                break;
            default:
                break;
        }

        Common.hideKeyboard(this);
    }

    /**
     * method includes main steps for converting
     */
    private void convertString() {

        Sentence[] _readyToConvertArray = this.getReadyToConvertArray();

        String _convertedText = this.getConvertedText(_readyToConvertArray);

        this.tvOutput.setText(_convertedText);
    }


    /**
     * method calls steps to create array of Sentences that are ready to converting
     *
     * @return
     */
    private Sentence[] getReadyToConvertArray() {

        String _income = String.valueOf(this.etInput.getText());

        if (_income != null || !_income.equals("")) {

            InputText _inputText = new InputText(_income);

            String[] _sentencesArray = _inputText.getSentencesArray();

            ReadyToConvert _readyToConvert = new ReadyToConvert(_sentencesArray);

            return _readyToConvert.getReadyToConvert();
        } else {

            return null;
        }
    }

    /**
     * method calls converter for getting output text
     *
     * @param readyToConvertArray
     * @return String output converted text
     */
    private String getConvertedText(Sentence[] readyToConvertArray) {

        String _outputString = "";

        Converter _converter = new Converter(readyToConvertArray);

        _outputString = _converter.getOutputString();

        return _outputString;
    }


    /**
     * all view elements cleaning
     */
    private void cleanAllViewsElements() {

        this.etInput.setText("");
        this.tvOutput.setText("");
    }


    /**
     * free Static variables
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Common.THREE_POINTS = null;
        Common.THREE_POINTS_CHANGE = null;
        Common.THREE_POINTS_CHANGE_BACK = null;
    }

    /**
     * set Static variables back
     */
    @Override
    protected void onResume() {
        super.onResume();

        Common.THREE_POINTS = "...";
        Common.THREE_POINTS_CHANGE = "staser_just_three_points.";
        Common.THREE_POINTS_CHANGE_BACK = " staser_just_three_points";

    }
}
