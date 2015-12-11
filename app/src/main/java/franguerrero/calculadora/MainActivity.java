package franguerrero.calculadora;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAc, btnC, btnPorcentaje, btnDividir, btnMultiplicar, btnRestar, btnSumar, btnDecimal, btnIgual;
    private Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private TextView textView;
    private boolean lOp1 = true;
    private boolean lOp2 = true;
    private String strOperando1 = "";
    private String strOperando2 = "";
    private int intOperando1 = 0;
    private int intOperando2 = 0;
    private int intResultado = 0;
    private boolean lSuma, lResta, lMultiplicacion, lDivision, lPorcentaje = false;
    private boolean lNuevaOperacion = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = (TextView) findViewById(R.id.textView);

        btnAc = (Button) findViewById(R.id.btnAc);
        btnC = (Button) findViewById(R.id.btnC);
        btnPorcentaje = (Button) findViewById(R.id.btnPorcentaje);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        n0 = (Button) findViewById(R.id.n0);
        n1 = (Button) findViewById(R.id.n1);
        n2 = (Button) findViewById(R.id.n2);
        n3 = (Button) findViewById(R.id.n3);
        n4 = (Button) findViewById(R.id.n4);
        n5 = (Button) findViewById(R.id.n5);
        n6 = (Button) findViewById(R.id.n6);
        n7 = (Button) findViewById(R.id.n7);
        n8 = (Button) findViewById(R.id.n8);
        n9 = (Button) findViewById(R.id.n9);

        btnAc.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnPorcentaje.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);

    }


    @Override
    public void onClick(View control) {
        /**
         * Si el usuario pulsa un número, se acumula hasta que pulse una tecla de operación.
         * El operando 1 pasa a true y los siguientes números se acumularán en el operando 2
         */
        switch (control.getId()){
            case R.id.btnPorcentaje:
            case R.id.btnDividir:
            case R.id.btnMultiplicar:
            case R.id.btnRestar:
            case R.id.btnSumar:
                if (!lOp1){ //recoge el segundo operando
                    lOp2 = false; //se cierra el operando 2
                } else if (lOp1 && intOperando1 != 0) { //recoge el primer operando
                    lOp1 = false; //se cierra el operando 1
                }


                if (control.getId() == R.id.btnSumar){
                    lSuma = true; // se guarda la operación en un boleano, por si se pulsa el botón igual
                    textView.setText("+");
                    if (!lOp1 && !lOp2 && !lNuevaOperacion) { //si se ha pulsado el botón sumar con los dos operandos, hace la operación
                        getSuma();
                    } else if (!lOp1 && !lOp2 && lNuevaOperacion) {
                        //añadir un tercer operando para operar con el resultado nuevoOperando = getOperando();
                        //mandar a un método suma con el nuevo operando
                    }
                } else if (control.getId() == R.id.btnRestar){
                    lResta = true;
                    textView.setText("-");
                    if (!lOp1 && !lOp2 && !lNuevaOperacion) {
                        getResta();
                    }
                } else if (control.getId() == R.id.btnMultiplicar){
                    lMultiplicacion = true;
                    textView.setText("x");
                    if (!lOp1 && !lOp2 && !lNuevaOperacion) {
                        getMultiplica();
                    }
                } else if (control.getId() == R.id.btnDividir){
                    lDivision = true;
                    textView.setText("÷");
                    if (!lOp1 && !lOp2 && !lNuevaOperacion) {
                        getDividir();
                    }
                } else if (control.getId() == R.id.btnPorcentaje){
                    lPorcentaje = true;
                    textView.setText("%");
                    if (!lOp1 && !lOp2 && !lNuevaOperacion) {
                        getPorcentaje();
                    }
                }
                break;
            case R.id.n0:
                //si se pulsa un número y lNuevaOperacion es true se resetea la calculadora.
                //lNuevaOperacion evita problemas al pulsar un número sin antes haber pulsado una operación en la tercera operación
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("0");
                }
                break;
            case R.id.n1:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("1");
                }
                break;
            case R.id.n2:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("2");
                }
                break;
            case R.id.n3:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("3");
                }
                break;
            case R.id.n4:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("4");
                }
                break;
            case R.id.n5:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("5");
                }
                break;
            case R.id.n6:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("6");
                }
                break;
            case R.id.n7:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("7");
                }
                break;
            case R.id.n8:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("8");
                }
                break;
            case R.id.n9:
                if (lNuevaOperacion) {
                    reinicia();
                } else {
                    controlOperandos("9");
                }
                break;
            case R.id.btnDecimal:
                break;
            case R.id.btnIgual:
                if (lSuma){
                    getSuma();
                } else if (lResta){
                    getResta();
                } else if (lMultiplicacion){
                    getMultiplica();
                } else if (lDivision){
                    getDividir();
                } else if (lPorcentaje){
                    getPorcentaje();
                }
                break;

            case R.id.btnC:
                if (lOp1) { //recogiendo el operando 1
                    String str = Integer.toString(intOperando1);
                    str = str.substring(0, str.length() - 1); //elimina la última cifra
                    intOperando1 = Integer.parseInt(str); //convierte el string para trabajar con él
                    textView.setText(Integer.toString(intOperando1)); //muestra el operando 1
                    strOperando1 = Integer.toString(intOperando1); //actualiza el operando 1
                } else if (!lOp1) {
                    String str = Integer.toString(intOperando2);
                    str = str.substring(0, str.length() - 1); //elimina la última cifra
                    intOperando2 = Integer.parseInt(str); //convierte el string para trabajar con él
                    textView.setText(Integer.toString(intOperando2)); //muestra el operando 1
                    strOperando2 = Integer.toString(intOperando2); //actualiza el operando 1
                }

                break;
            case R.id.btnAc:
                reinicia();
                break;
            default:
                break;
        }

    }

    private void reinicia(){
        lOp1 = true;
        lOp2 = true;
        lNuevaOperacion = false;
        strOperando1 = "";
        strOperando2 = "";
        intResultado = 0;
        intOperando1 = 0;
        intOperando2 = 0;
        textView.setText(Integer.toString(intResultado));
    }


    /**
     * Añade los números pulsados al operando 1 o al operando 2
     * @param n número que se ha pulsado
     */
    private void controlOperandos(String n){
        if (lOp1){ //recoge el primer operando
            strOperando1 += n; //concatena los números en formato String del operando 1
            intOperando1 = Integer.parseInt(strOperando1); //añade el número que se ha pulsado
            textView.setText(Integer.toString(intOperando1));
        } else if (!lOp1){
            strOperando2 += n; //concatena los números del operando 2
            intOperando2 = Integer.parseInt(strOperando2);
            textView.setText(Integer.toString(intOperando2)); //muestra el operando 2 en el display
        }
    }

    private void getPorcentaje() {
        intResultado = intOperando1 + intOperando2;
        textView.setText(Integer.toString(intResultado));
        anadirOperacion();
    }

    private void getDividir() {
        intResultado = intOperando1 / intOperando2;
        textView.setText(Integer.toString(intResultado));
        anadirOperacion();
    }

    private void getMultiplica() {
        intResultado = intOperando1 * intOperando2;
        textView.setText(Integer.toString(intResultado));
        anadirOperacion();
    }

    private void getResta() {
        intResultado = intOperando1 - intOperando2;
        textView.setText(Integer.toString(intResultado));
        anadirOperacion();
    }

    private void getSuma() {
        intResultado = intOperando1 + intOperando2;
        textView.setText(Integer.toString(intResultado));
        anadirOperacion();
    }

    private void anadirOperacion() {
        lSuma = false;
        lResta = false;
        lMultiplicacion = false;
        lDivision = false;
        lPorcentaje = false;
        lNuevaOperacion = true; //ahora se coge el resultado con el nuevo operando
    }
}
