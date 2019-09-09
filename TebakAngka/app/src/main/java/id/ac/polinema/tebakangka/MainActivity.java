package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int n, numInput;
	private Random random;
	private EditText numInputForm;
	private Button guessBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numInputForm = findViewById(R.id.number_input);
		guessBtn = findViewById(R.id.guess_button);
		random = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		n = random.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String numInputString = numInputForm.getText().toString();
		if (numInputString.equalsIgnoreCase( "" )){
			Toast.makeText(this, "input harus angka", Toast.LENGTH_SHORT).show();
		}else {
			numInput = Integer.parseInt(numInputString);
			if (numInput > n){
				Toast.makeText(this, "tebakan anda terlalu besar", Toast.LENGTH_SHORT).show();
			} else if (numInput < n){
				Toast.makeText(this, "tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
			} else{
				Toast.makeText(this, "tebakan anda benar", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numInputForm.setText("");
		initRandomNumber();
		guessBtn.setEnabled(true);
	}
}
