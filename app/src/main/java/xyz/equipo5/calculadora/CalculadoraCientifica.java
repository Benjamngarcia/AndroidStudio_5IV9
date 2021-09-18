package xyz.equipo5.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraCientifica extends AppCompatActivity {

    TextView tvResultado;
    float numero1 = 0.0f;
    float numero2 = 0.0f;
    double π = 3.14159265;
    String operacion = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cientifica);

        tvResultado = findViewById(R.id.tvResultado);
    }

    public void CambiarModo(View view) {
        Intent i = new Intent( this,MainActivity.class);
        startActivity(i);
    }

    public void LimpiarResultado(View view) {
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
        tvResultado.setText("0");
    }

    public void CambioSigno(View view) {
        float valor = Float.parseFloat(String.valueOf(tvResultado.getText()));
        valor = valor * -1.0f;
        tvResultado.setText("" + valor);
    }

    public void AbrirParentesis(View view) {
        if( !String.valueOf(tvResultado.getText()).contains("(") ){
            tvResultado.setText(tvResultado.getText() + "(");
        }
    }

    public void CerrarParentesis(View view) {
        if( !String.valueOf(tvResultado.getText()).contains(")") ){
            tvResultado.setText(tvResultado.getText() + ")");
        }
    }

    public void OperacionSeno(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        double res = Math.toRadians(numero1);
        double result = Math.sin(res);
        tvResultado.setText(Double.toString(result));
    }

    public void OperacionCoseno(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        double res = Math.toRadians(numero1);
        double result = Math.cos(res);
        tvResultado.setText(Double.toString(result));
    }

    public void OperacionTangente(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        double res = Math.toRadians(numero1);
        double result = Math.tan(res);
        tvResultado.setText(Double.toString(result));
    }

    public void OperacionLog(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        double result = Math.log10(numero1);
        tvResultado.setText(Double.toString(result));
    }

    public void OperacionLogN(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        double result = Math.log(numero1);
        tvResultado.setText(Double.toString(result));

    }

    public void OperacionElevar(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        try{
            if(Float.parseFloat(tvResultado.getText().toString()) <= 0){
                Toast.makeText(this, "El número tiene que ser mayor a 0", Toast.LENGTH_LONG).show();
            }else{
                try{
                    double result = Math.pow(numero1, 2);
                    tvResultado.setText(Double.toString(result));
                }catch (Exception e){
                    Toast.makeText(this, "Ocurrió un error inesperado..." + e.getMessage(), Toast.LENGTH_LONG).show();
                    tvResultado.setText("ERROR");
                }
            }
        }catch(Exception e){
            tvResultado.setText("0");
        }
    }

    public void OperacionElevarNumero(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "^";
        tvResultado.setText("0");
    }

    public void OperacionRaiz(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        try{
            if(Float.parseFloat(tvResultado.getText().toString()) <= 0){
                Toast.makeText(this, "El número tiene que ser mayor a 0", Toast.LENGTH_LONG).show();
            }else{
                try{
                    double result = Math.sqrt(Float.parseFloat(tvResultado.getText().toString()));
                    tvResultado.setText(Double.toString(result));
                }catch (Exception e){
                    Toast.makeText(this, "Ocurrio un error..." + e.getMessage(), Toast.LENGTH_LONG).show();
                    tvResultado.setText("ERROR");
                }
            }
        }catch(Exception e){
            tvResultado.setText("0");
        }
    }

    public void OperacionRacionalizar(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        try{
            double result = Math.pow(numero1, -1);
            tvResultado.setText(Double.toString(result));
        }catch (Exception e){
            Toast.makeText(this, "Ocurrió un error inesperado..." + e.getMessage(), Toast.LENGTH_LONG).show();
            tvResultado.setText("ERROR");
        }
    }

    public void OperacionPorcentaje(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "%";
        tvResultado.setText("0");
    }

    public void OperacionDividir(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "/";
        tvResultado.setText("0");
    }

    public void OperacionMulti(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "*";
        tvResultado.setText("0");
    }

    public void OperacionMenos(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "-";
        tvResultado.setText("0");
    }

    public void OperacionMas(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "+";
        tvResultado.setText("0");

    }


    public void EscribirPunto(View view) {
        if( !String.valueOf(tvResultado.getText()).contains(".") ){
            tvResultado.setText(tvResultado.getText() + ".");
        }
    }

    public void EscribirCero(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("0");
        }else{
            tvResultado.setText(tvResultado.getText() + "0");
        }
    }

    public void EscribirUno(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("1");
        }else{
            tvResultado.setText(tvResultado.getText() + "1");
        }
    }

    public void EscribirDos(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("2");
        }else{
            tvResultado.setText(tvResultado.getText() + "2");
        }
    }

    public void EscribirTres(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("3");
        }else{
            tvResultado.setText(tvResultado.getText() + "3");
        }
    }

    public void EscribirCuatro(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("4");
        }else{
            tvResultado.setText(tvResultado.getText() + "4");
        }
    }

    public void EscribirCinco(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("5");
        }else{
            tvResultado.setText(tvResultado.getText() + "5");
        }
    }

    public void EscribirSeis(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("6");
        }else{
            tvResultado.setText(tvResultado.getText() + "6");
        }
    }

    public void EscribirSiete(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("7");
        }else{
            tvResultado.setText(tvResultado.getText() + "7");
        }
    }

    public void EscribirOcho(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("8");
        }else{
            tvResultado.setText(tvResultado.getText() + "8");
        }
    }

    public void EscribirNueve(View view) {
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("9");
        }else{
            tvResultado.setText(tvResultado.getText() + "9");
        }
    }

    public void MostrarResultado(View view) {
        numero2 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        float result = 0.0f;

        if(operacion.equals("%")){
            result = (numero1 / 100.0f) * numero2;
        }if(operacion.equals("/")){
            if(numero2 != 0.0f){
                result = numero1 / numero2;
            }else{
                result = 0.0f;
                Toast.makeText(this, "OPERACIÓN NO VALIDA", Toast.LENGTH_LONG).show();
            }
        }else if(operacion.equals("*")){
            result = numero1 * numero2;
        }else if(operacion.equals("-")){
            result = numero1 - numero2;
        }else if(operacion.equals("+")){
            result = numero1 + numero2;
        }else if(operacion.equals("^")) {
            if (numero2 < 0) {
                Toast.makeText(this, "No se permiten potencias negativas", Toast.LENGTH_LONG).show();
            } else {
                if (numero2 == 0 && numero1 == 0) {
                    tvResultado.setText("ERROR");
                } else {
                    result = (float) Math.pow(numero1, numero2);
                }
            }
        }else if(operacion.equals("sin")){

        }

        tvResultado.setText(result + "");
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
    }
}